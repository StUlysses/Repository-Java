package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Article;
import bean.Corpus;
import bean.QueryVo;
import bean.Submit;
import bean.Theme;
import bean.User;
import bean.corpusContent;
import myException.MyException;
import net.sf.json.JSONArray;
import service.ArticleListService;

@Controller
public class ArticleRelationController {
	@Autowired
	private ArticleListService alService;
	/**
	 * 查询该用户所有文集
	 * @param session
	 * @return
	 */
	@RequestMapping("findCorpus")
	@ResponseBody
	public String findCorpus(HttpSession session) {
		User user = (User)session.getAttribute("logined");
		String json = null;
		try {
			List<Corpus> list = alService.findAllCorpus(user.getUid());
			JSONArray jsonArray = JSONArray.fromObject(list);
			json = jsonArray.toString();
		} catch (MyException e) {
			e.printStackTrace();
		}
		return json;
	}
	/**
	 * 新建文集
	 * @param session
	 * @return
	 */
	@RequestMapping("newCorpus")
	@ResponseBody
	public String newCorpus(HttpSession session,String name){
		User user = (User)session.getAttribute("logined");
		//设置文集

		Corpus cor = new Corpus();
		cor.setConame(name);
		cor.setUid(user.getUid());
		cor.setUsername(user.getUsername());
		int num = alService.findCorpusNum(user.getUid());//查询文集个数
		if(num == 5) {
			return "fail";
		}
		try {
			alService.addCorpus(cor);//新建文集操作
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	/**
	 * 保存文章到文集
	 * @param session
	 * @param coid
	 * @return
	 */
	@RequestMapping("saveToCorpus")
	@ResponseBody
	public String saveToCorpus(HttpSession session,String coid) {
		Article arti = (Article)session.getAttribute("arti");
		
		if(arti == null || arti.getUserinfo() == null) {
			return "fail";
		}
		if(alService.findCorpuscontentName(coid,arti)) {
			return "nameError";
		}
		try {
			alService.saveToCorpus(coid,arti);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	/**
	 * 进入文集页
	 * @param session
	 * @param coid
	 * @return
	 */
	@RequestMapping("corpusList")
	public String corpusList(HttpSession session,String coid,String page) {
		int Coid = Integer.parseInt(coid);
		//分页查询文集内文章
		//默认第一页
		if(page == null || page == "") {
			page = "1";
		}
		int currentPage = Integer.parseInt(page);
		QueryVo<corpusContent> ccs = new QueryVo<corpusContent>();
		ccs.setCurrentPage(currentPage);
		ccs.setUid(Coid);//此处QueryVo的UID放置文集的coid
		List<corpusContent> list = alService.getAllContent(ccs);
		ccs.setList(list);
		session.setAttribute("ccs", ccs);
		//查询文集信息
		@SuppressWarnings("unchecked")
		List<Corpus> cors = (List<Corpus>) session.getAttribute("corpus");
		for (Corpus corpus : cors) {
			if(corpus.getCoid() == Coid) {
				session.setAttribute("cor", corpus);
				continue;
			}
		}
		return "forward:WEB-INF/jsp/corpus.jsp";
	}
	/**
	 * 删除文集
	 * @param coid
	 * @return
	 */
	@RequestMapping("removeCorpus")
	public String removeCoorpus(HttpSession session,String coid){
		int Coid = Integer.parseInt(coid);
		try {
			alService.removeCorpus(Coid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		User logined = (User)session.getAttribute("logined");
		return "redirect:common/person.action?suid="+logined.getUid();
	}
	/**
	 * 删除文集内文章
	 * @param coid 文集ID
	 * @param aid 文章ID
	 * @return
	 */
	@RequestMapping("removeCorpusContent")
	public String removeCorpusContent(String coid,String aid) {
		//删除文集中的文章
		alService.removeCorpusContent(coid,aid);
		return "redirect:corpusList.action?coid="+coid;
	}
	/**
	 * 进入创建专题页
	 * @return
	 */
	@RequestMapping("toCreateTheme")
	public String toCreateTheme() {
		return "forward:WEB-INF/jsp/createTheme.jsp";
	}
	/**
	 * 创建专题
	 * @param session
	 * @param tname专题名
	 * @param bulletin公告
	 * @param info简介
	 * @return 进入专题
	 */
	@RequestMapping("createTheme")
	public String createTheme(HttpSession session,String tname,String bulletin,String info){
		User user = (User)session.getAttribute("logined");
		try {
			//实现创建专题逻辑
			Theme theme = alService.createTheme(user,tname,bulletin,info);
			//往session存入专题信息
			theme.setUsername(user.getUsername());
			theme.setUid(user.getUid());
			theme.setTname(tname);
			theme.setInfo(info);
			theme.setBulletin(bulletin);
			session.setAttribute("theme", theme);
		} catch (MyException e) {
			e.printStackTrace();
		}
		return "redirect:common/theme.action?tid=0";
	}
	/**
	 * 测试专题名是否可用
	 * @param tname 专题名
	 * @return 可用yes 不可以用no
	 */
	@RequestMapping("tnameTest")
	@ResponseBody
	public String tnameTest(String tname){
		String ava = "no";
		try {
			ava = alService.tnameAvailable(tname);
		} catch (MyException e) {
			e.printStackTrace();
		}
		return ava;
	}
	/**
	 * 编辑专题公告
	 * @param bulletin 新的公告
	 * @param uid 用户ID
	 * @return
	 */
	@RequestMapping("editBulletin")
	@ResponseBody
	public String editBulletin(String bulletin,String uid){
		try {
			alService.editBulletin(bulletin,uid);
		} catch (MyException e) {
			e.printStackTrace();
		}
		return "success";
	}
	/**
	 * 删除专题
	 * @param uid 用户ID
	 * @return
	 */
	@RequestMapping("removeTheme")
	public String removeTheme(String uid){
		try {
			alService.dropTheme(uid);
		} catch (MyException e) {
			e.printStackTrace();
		}
		return "redirect:common/person.action?suid="+uid;
	}
	/**
	 * 前往投稿页面
	 * @param session
	 * @return
	 */
	@RequestMapping("toSubmit")
	public String submit(HttpSession session) {
		session.removeAttribute("themeQv");
		return "forward:WEB-INF/jsp/submit.jsp";
	}
	/**
	 * 搜索专题
	 * @param session
	 * @param tname 关键字
	 * @param page 当前页数
	 * @return
	 */
	@RequestMapping("searchTheme")
	public String searchTheme(HttpSession session,String tname,String page){
		QueryVo<Theme> qv = null;
		try {
			qv = alService.searchThemeByTname(tname,page);
		} catch (MyException e) {
			e.printStackTrace();
		}
		session.setAttribute("themeQv", qv);
		return "forward:WEB-INF/jsp/submit.jsp";
	}
	/**
	 * 向专题投稿
	 * @param session
	 * @param tid 专题ID
	 * @param tname 专题名
	 * @return 投稿状态
	 */
	@RequestMapping("submit")
	@ResponseBody
	public String submit(HttpSession session,String tid,String tname){
		Article arti = (Article)session.getAttribute("arti");
		if(alService.isSubmited(tid,arti.getId())) {
			return "fail";
		}
		try {
			alService.articleSubmit(arti,tid,tname);
		} catch (MyException e) {
			e.printStackTrace();
		}
		return "success";
	}
	/**
	 * 进入来稿审核页面
	 * @param session
	 * @param tname 稿件名称
	 * @param page 当前页数
	 * @return
	 */
	@RequestMapping("reView")
	public String reView(HttpSession session,String tname,String page) {
		try {
			QueryVo<Submit> qv = alService.findSubmitArticle(tname,page);
			session.setAttribute("submitArticle", qv);
		} catch (MyException e) {
			e.printStackTrace();
		}
		return "forward:WEB-INF/jsp/review.jsp";
	}
	/**
	 * 收录文章
	 * @param session
	 * @param aid 文章ID
	 * @param title 文章标题
	 * @param collectNum 文章收藏数
	 * @param size 文章字数
	 * @return
	 */
	@RequestMapping("accept")
	@ResponseBody
	public String accept(HttpSession session,String aid,String title) {
		Theme theme = (Theme)session.getAttribute("theme");
		try {
			alService.acceptSubmit(theme,aid,title);
		} catch (MyException e) {
			e.printStackTrace();
		}
		return "success";
	}
	/**
	 * 拒接收录文章
	 * @param session
	 * @param aid 文章ID
	 * @param title 文章标题
	 * @return
	 */
	@RequestMapping("object")
	@ResponseBody
	public String object(HttpSession session,String aid,String title) {
		Theme theme = (Theme)session.getAttribute("theme");
		try {
			alService.objectSubmit(theme,aid,title);
		} catch (MyException e) {
			e.printStackTrace();
		}
		return "success";
	}
	/**
	 * 订阅专题
	 * @param session
	 * @param uid 用户ID
	 * @return
	 */
	@RequestMapping("followTheme")
	@ResponseBody
	public String followTheme(HttpSession session,String uid) {
		int Uid = Integer.parseInt(uid);
		Theme theme = (Theme)session.getAttribute("theme");
		try {
			alService.followTheme(Uid,theme.getTid(),theme.getTname());
		} catch (MyException e) {
			e.printStackTrace();
		}
		return "success";
	}
	/**
	 * 取消订阅
	 * @param session
	 * @param uid 用户ID
	 * @return
	 */
	@RequestMapping("cancelFollowTheme")
	@ResponseBody
	public String cancelFollowTheme(HttpSession session,String uid) {
		int Uid = Integer.parseInt(uid);
		Theme theme = (Theme)session.getAttribute("theme");
		try {
			alService.cancelFollowTheme(Uid,theme.getTid());
		} catch (MyException e) {
			e.printStackTrace();
		}
		return "success";
	}
}
