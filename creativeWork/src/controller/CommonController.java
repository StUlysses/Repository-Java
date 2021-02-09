package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Accept;
import bean.Article;
import bean.QueryVo;
import bean.Theme;
import bean.User;
import bean.UserActive;
import myException.MyException;
import service.ArticleListService;
import service.ArticleService;
import service.CommonService;
import service.UserService;



@Controller
public class CommonController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ArticleService artiService;
	@Autowired
	private CommonService comService;
	@Autowired
	private ArticleListService alService;
	/**
	 * 主页
	 * @return
	 */
	@RequestMapping("common/creative")
	public String mainPage(HttpSession session,String page) {
		try {
			//查询5位活跃作者
			List<UserActive> uas =  userService.findUsersByLasttime();
			session.setAttribute("activeUser", uas);
			//查询5个活跃专题
			List<Theme> ths = alService.findThemeByAccepttime();
			session.setAttribute("themes", ths);
			//获取该作者全部作品(分页)
			//UID为0表示查询所有作者的作品
			QueryVo<Article> qv = artiService.findArticleByUid(0,page);
			session.setAttribute("queryVo", qv);
		} catch (MyException e) {
			e.printStackTrace();
		}
		return "forward:../WEB-INF/jsp/mainPage.jsp";
	}
	/**
	 * 搜索页面
	 * @param session
	 * @param word 关键字
	 * @param page 当前页码
	 * @return
	 */
	@RequestMapping("common/search")
	public String search(HttpSession session,String word,String page){
		session.setAttribute("word", word);
		//如果关键字为空，则不搜索，移除session并直接返回
		if(word == null || word == "") {
			session.removeAttribute("resultA");
			session.removeAttribute("resultU");
			session.removeAttribute("resultT");
			return "forward:../WEB-INF/jsp/search.jsp";
		}
		//存入搜索历史
		int uid = 0;
		User user = (User)session.getAttribute("logined");
		if(user != null) {
			uid = user.getUid();
		}
		try {
			if(page == null) {
				comService.addSearchHistory(uid, word);
			}
			//搜索用户
			List<User> resultU = userService.findUserByWord(word);
			session.setAttribute("resultU", resultU);
			//搜索专题
			List<Theme> resultT = alService.findThemeByWord(word);
			session.setAttribute("resultT", resultT);
			//搜索文章
			QueryVo<Article> qv = artiService.findArticleByWord(word,page);
			session.setAttribute("resultA", qv);
			//取出搜索历史
			List<String> list = comService.getSearchHistory(uid);
			session.setAttribute("history", list);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return "forward:../WEB-INF/jsp/search.jsp";
	}
	/**
	 * 清除搜索历史
	 * @param session
	 * @return
	 */
	@RequestMapping("common/clearHistory")
	@ResponseBody
	public String clearHistory(HttpSession session){
		User user = (User)session.getAttribute("logined");
		int uid = 0;
		if(user != null) {
			uid = user.getUid();
		}
		try {
			comService.clearHistory(uid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	/**
	 * 专题页
	 * @return
	 */
	@RequestMapping("common/theme")
	public String theme(HttpSession session,String tid,String page){
		if(tid != null && !"0".equals(tid)) {
			int Tid = Integer.parseInt(tid);
			try {
				//查询用户是否已订阅该专题
				User user = (User)session.getAttribute("logined");
				String isFol = "no";
				if(user != null) {
					isFol = alService.isFollowTheme(user.getUid(),Tid);
				}
				session.setAttribute("followTheme", isFol);
				//根据tid查找专题并存入session
				Theme theme = alService.findThemeByTid(Tid);
				session.setAttribute("theme", theme);
				//从收录表中查询文章总数
				int totalArticle = alService.findTotalArticleByTid(Tid);
				session.setAttribute("ArticleNum", totalArticle);
				//从收录表中查询订阅总数
				int totalReader = alService.findTotalReaderByTid(Tid);
				session.setAttribute("ReaderNum", totalReader);
				//分页查询所有收录文章
				QueryVo<Accept> qv = alService.findAllAcceptByQueryVo(Tid,page);
				session.setAttribute("accepts", qv);
			} catch (MyException e) {
				e.printStackTrace();
			}
		}
		
		return "forward:../WEB-INF/jsp/theme.jsp";
	}
	
}
