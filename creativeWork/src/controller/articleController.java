package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Article;
import bean.Chat;
import bean.Collect;
import bean.Draft;
import bean.QueryVo;
import bean.Theme;
import bean.User;
import myException.MyException;
import service.ArticleListService;
import service.ArticleService;
import service.ChatService;
/**
 * 文章相关控制器
 * @author CAOto
 *
 */
@Controller
public class articleController {
	
	@Autowired
	private ArticleService artiService;
	@Autowired
	private ChatService chatService;
	@Autowired
	private ArticleListService alService;
	
	/**
	 * 进入文章页面
	 * @param session
	 * @param id 文章id，id=0表示是草稿
	 * @param isPerson 是否为作者本人
	 * @return
	 */
	@RequestMapping("common/article")
	public String article(HttpSession session,String id,String isPerson){
		//是否是作者（权限判断）
		session.setAttribute("isPerson", isPerson);
		int aid = Integer.parseInt(id);
		try {
			if(aid > 0) {
				Article arti = artiService.findArticle(aid);
				session.setAttribute("arti", arti);
				//根据文章ID查找评论
				List<Chat> list = chatService.findReviewByBelong(aid);
				session.setAttribute("comments", list);
			}else if(aid == 0){
				Draft dra = (Draft)session.getAttribute("arti");
				Article arti = new Article();
				arti.setUid(dra.getUid());
				arti.setTitle(dra.getTitle());
				arti.setUsername(dra.getUsername());
				arti.setContent(dra.getContent());
				session.setAttribute("arti", arti);
			}
			//文章被哪些专题收录
			List<Theme> list = alService.findThemeByAid(aid);
			session.setAttribute("beforTheme", list);
		} catch (MyException e) {
			e.printStackTrace();
		}
		//判断浏览者是否登录，给予不同模块
		User user = (User)session.getAttribute("logined");
		if(user != null) {
			Article arti = (Article)session.getAttribute("arti");
			int usid = user.getUid();
			int artid = arti.getUid();
			if(usid != artid) {
				try {
					//查询是否已收藏
					Collect clt = new Collect();
					clt.setUid(user.getUid());
					//设置文章信息
					clt.setAid(arti.getId());
					String isCollect = artiService.findIsCollect(clt);
					session.setAttribute("isCollect", isCollect);
				} catch (MyException e) {
					e.printStackTrace();
				}
			}
		}
		return "forward:../WEB-INF/jsp/article.jsp";
	}
	/**
	 * 进入写作页面
	 * @param session
	 * @return
	 */
	@RequestMapping("creating")
	public String creating(HttpSession session,String keepEdit) {
		session.setAttribute("keepEdit", keepEdit);
		if(!"yes".equals(keepEdit)) {
			session.removeAttribute("arti");
		}
		return "forward:WEB-INF/jsp/creating.jsp";
	}
	/**
	 * 发布文章
	 * @param session
	 * @param title
	 * @param content
	 * @return
	 */
	@RequestMapping("publishArticle")
	public String publishArticle(HttpSession session,String title,String content) {
		//获取当前用户
		User user = (User)session.getAttribute("logined");
		//草稿ID（0表示当前session中存的是文章
		String draftId = (String) session.getAttribute("draftId");
		//是否是旧文章继续编辑
		String keepEdit = (String)session.getAttribute("keepEdit");
		Article arti = null;

		try {
			if(!"0".equals(draftId)) {
				//草稿发布
				arti = artiService.publishDraft(user,draftId,title,content);
			}else if("yes".equals(keepEdit)){
				//旧文章更新
				arti = (Article)session.getAttribute("arti");
				arti = artiService.editArticle(arti,title,content);				
			}else {
				//发布新文章
				arti = artiService.publishArticle(user, title, content);
			}
		} catch (MyException e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
		
		session.setAttribute("arti", arti);
		//0表示arti存的不是草稿
		session.setAttribute("draftId","0");
		return "redirect:common/article.action?id=-1";
	}
	/**
	 * 保存草稿
	 * @param session
	 * @param title
	 * @param content
	 * @return
	 */
	@RequestMapping("saveDraft")
	@ResponseBody
	public String saveDraft(HttpSession session,String title,String content) {
		//获取当前用户
		User user = (User)session.getAttribute("logined");
		String draftId = (String)session.getAttribute("draftId");
		try {
			artiService.saveArticle(title,content,user,draftId);
		} catch (MyException e) {
			e.printStackTrace();
		}
		return "success";
	}
	/**
	 * 进入草稿列表
	 * @param session
	 * @return
	 */
	@RequestMapping("draftList")
	public String draftList(HttpSession session,String page) {
		//得到用户ID
		User user = (User)session.getAttribute("logined");		
		try {
			QueryVo<Draft> qv = artiService.findDraftByUid(user,page);
			session.setAttribute("drafts", qv);
		} catch (MyException e) {
			e.printStackTrace();
		}
		return "forward:WEB-INF/jsp/draftList.jsp";
	}
	/**
	 * 查看草稿
	 * @param session
	 * @param id 草稿ID
	 * @param isPerson 是否作者本人（为了衔接文章页面的参数）
	 * @return
	 */
	@RequestMapping("viewDraft")
	public String draftEdit(HttpSession session,String id,String isPerson) {
		int did = Integer.parseInt(id);
		Draft draft = null;
		try {
			draft = artiService.findDraft(did);
		} catch (MyException e) {
			e.printStackTrace();
		}
		session.setAttribute("arti", draft);
		//存入草稿id
		session.setAttribute("draftId",id);
		return "redirect:common/article.action?id=0&isPerson="+isPerson;
	}
	/**
	 * 删除文章或草稿
	 * @param session
	 * @return
	 */
	@RequestMapping("dropArticle")
	public String dropArticle(HttpSession session) {
		String sid = (String)session.getAttribute("draftId");
		int id = Integer.parseInt(sid);
		try {
			if(id == 0) {
				//删除文章
				Article arti = (Article)session.getAttribute("arti");
				artiService.dropArticleById(arti);
				User user = (User)session.getAttribute("logined");
				return "redirect:common/person.action?suid="+user.getUid();//返回作者主页
			}else {
				//删除草稿
				artiService.dropDraft(id);
			}
		} catch (MyException e) {
			e.printStackTrace();
		}
		return "redirect:draftList.action";
	}
	/**
	 * 收藏文章
	 * @param session
	 * @return
	 */
	@RequestMapping("collectArticle")
	@ResponseBody
	public String collectArticle(HttpSession session) {
		//建立collect的bean
		Collect clt = new Collect();
		try {
			//设置用户信息
			User user = (User)session.getAttribute("logined");
			clt.setUid(user.getUid());
			//设置文章信息
			Article arti = (Article)session.getAttribute("arti");
			clt.setAid(arti.getId());
			clt.setTitle(arti.getTitle());
			artiService.collectArticle(clt);
		} catch (MyException e) {
			e.printStackTrace();
		}
		return "success";
	}
	/**
	 * 取消收藏
	 * @param session
	 * @return
	 */
	@RequestMapping("cancelCollect")
	@ResponseBody
	public String cancelCollect(HttpSession session) {
		try {
			//建立collect的bean
			Collect clt = new Collect();
			//设置用户信息
			User user = (User)session.getAttribute("logined");
			clt.setUid(user.getUid());
			//设置文章信息
			Article arti = (Article)session.getAttribute("arti");
			clt.setAid(arti.getId());
			artiService.cancelCollect(clt);
		} catch (MyException e) {
			e.printStackTrace();
		}
		return "success";
	}
	/**
	 * 进入收藏列表
	 * @param session
	 * @return
	 */
	@RequestMapping("collectList")
	public String collectList(HttpSession session,String page) {
		//得到用户ID
		User user = (User)session.getAttribute("logined");
		try {
			QueryVo<Collect> qv = artiService.findCollectArticle(user,page);
			session.setAttribute("collects",qv);
		} catch (MyException e) {
			e.printStackTrace();
		}
		return "forward:WEB-INF/jsp/collection.jsp";
	}
}
