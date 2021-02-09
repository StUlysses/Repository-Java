package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import bean.Article;
import bean.Corpus;
import bean.Follow;
import bean.QueryVo;
import bean.Theme;
import bean.User;
import myException.MyException;
import service.ArticleListService;
import service.ArticleService;
import service.ChatService;
import service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private ArticleService artiService;
	@Autowired
	private ArticleListService alService;
	@Autowired
	private ChatService chatService;
	/**
	 * 登录注册页面
	 * @return
	 */
	@RequestMapping("common/login")
	public String login(HttpSession session,String md,String page) {
		//登录注册页面有两个模块：登录为md=l，注册为md=r
		session.setAttribute("md", md);
		//清除登录页面信息
		session.removeAttribute("loginMsg");
		if(page != null && page != "") {
			//保存跳转前页面地址
			String href = page.substring(35);
			session.setAttribute("href", href);
		}
		return "forward:../WEB-INF/jsp/login.jsp";
	}
	/**
	 * 注册功能实现
	 * @return
	 */
	@RequestMapping("common/registerUser")
	public String registerUser(HttpSession session,User user) {
		try {
			//注册用户
			userService.registerUser(user);
			session.setAttribute("md", "l");
		} catch (MyException e) {
			e.printStackTrace();
		}
		return "forward:../WEB-INF/jsp/login.jsp";
	}
	/**
	 * 登录功能实现
	 * @return
	 */
	@RequestMapping("common/loginUser")
	public String loginUser(HttpSession session,User user) {
		try {
			//用户登录
			User logined = userService.loginUser(user);
			if(logined == null) {
				//登录失败，添加错误提示，返回登录界面
				session.setAttribute("md", "l");
				session.setAttribute("loginMsg", "用户名或密码错误");
				return "forward:../WEB-INF/jsp/login.jsp";
			}else {
				//登录成功，注册登录时间
				userService.updateUserLasttime(logined);
				//往session添加用户信息
				session.setAttribute("logined", logined);
			}
		} catch (MyException e) {
			e.printStackTrace();
		}
		//返回之前页面
		String href = (String)session.getAttribute("href");
		String page = "";
		if(href != null && href.startsWith("common")) {//判断是否为common目录下的
			page = href.substring(7);
		}else {
			page = href;
		}
		return "redirect:"+page;
	}
	/**
	 * 用户退出
	 * @param session
	 * @return
	 */
	@RequestMapping("exitUser")
	public String exit(HttpSession session) {
		//清除用户信息
		session.removeAttribute("logined");
		//清除“是否已关注该用户”的信息
		session.removeAttribute("isFollow");
		return "redirect:common/creative.action";
	}
	/**
	 * 前往个人设置页面
	 * @return
	 */
	@RequestMapping("personSetting")
	public String personSetting() {
		return "forward:WEB-INF/jsp/personSetting.jsp";
	}
	/**
	 * 设置个人信息
	 * @return
	 * @throws  
	 * @throws Exception 
	 */
	@RequestMapping("setting")
	public String setting(HttpSession session,MultipartFile photo1,String sex1,String info1){
		try {
			//保存图片
			String oldName = photo1.getOriginalFilename();//获取文件名
			String newName = "";
			String subfix = "";
			if(oldName != null && oldName != "") {
				newName = UUID.randomUUID().toString();//随机名称
				subfix = oldName.substring(oldName.lastIndexOf('.'));//得到后缀名
				File file = new File("F:\\JavaSpace\\upload\\image\\"+newName+subfix);
				photo1.transferTo(file);
			}
			//设置用户信息
			User user = (User) session.getAttribute("logined");
			user.setInfo(info1);
			user.setSex(sex1);
			user.setPhoto(newName+subfix);
			userService.updateUserInfo(user);
			session.setAttribute("logined", user);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MyException e) {
			e.printStackTrace();
		}
		return "forward:WEB-INF/jsp/personSetting.jsp";
	}
	
	/**
	 *  进入个人页面
	 * @param suid 该页面所属用户ID
	 * @param session
	 * @param page 当前页码
	 * @return
	 */
	@RequestMapping("common/person")
	public String person(String suid,HttpSession session,String page){
		try {
			int uid = Integer.parseInt(suid);
			//判断是否已关注该作者-----------------
			User logined = (User)session.getAttribute("logined");//获取登录者ID
			if(logined != null) {
				int rid = logined.getUid();
				boolean isFollow = userService.findIsFollow(rid, uid);
				session.setAttribute("isFollow", isFollow);
				List<Follow> fos = alService.findAllThemeByUid(logined.getUid());
				session.setAttribute("myTheme", fos);
			}
			//获取该作者全部作品(分页)----------------
			QueryVo<Article> qv = artiService.findArticleByUid(uid,page);
			session.setAttribute("queryVo", qv);
			//根据参数suid查询页面个人信息----------------------------------
			User user = userService.findOtherUser(uid);
			session.setAttribute("user", user);
			//查询文集
			List<Corpus> list = alService.findAllCorpus(user.getUid());
			session.setAttribute("corpus", list);
			//查询所有订阅的专题
			Theme theme = alService.findThemeByUid(user.getUid());
			session.setAttribute("theme", theme);
			//查询个人专题
		} catch (MyException e) {
			e.printStackTrace();
		}
		return "forward:../WEB-INF/jsp/person.jsp";
	}
	/**
	 * 关注作者
	 * @param session
	 * @param uuid
	 * @return
	 */
	@RequestMapping("followAuthor")
	@ResponseBody
	public String followAuthor(HttpSession session,String uuid){
		int uid = Integer.parseInt(uuid);
		//取出当前用户信息作为读者信息
		User logined = (User)session.getAttribute("logined");
		//如果未登录，则不添加读者关系
		if(logined != null) {
			try {
				//实现关注逻辑
				userService.followAuthor(logined,uid);
				//发送关注消息
				chatService.saveSystemMsg(logined,uid);
			} catch (MyException e) {
				e.printStackTrace();
			}
			return "followed";
		}
		return "unFollow";
	}
	/**
	 * 取消关注
	 * @param session
	 * @param uuid
	 * @return
	 */
	@RequestMapping("cancelFollow")
	@ResponseBody
	public String cancelFollow(HttpSession session,String uuid) {
		int uid = Integer.parseInt(uuid);
		//获取读者RID
		User logined = (User)session.getAttribute("logined");
		//取消关注
		try {
			userService.cancelFollow(logined,uid);
		} catch (MyException e) {
			e.printStackTrace();
		}
		return "cancel";
	}
	/**
	 *进入读者列表
	 * @param session
	 * @return
	 */
	@RequestMapping("readerList")
	public String findReader(HttpSession session) {
		//获取当前用户UID
		User logined = (User)session.getAttribute("logined");
		//获取读者集合
		try {
			List<User> readers = userService.findAllReader(logined.getUid());
			session.setAttribute("readers", readers);
		} catch (MyException e) {
			e.printStackTrace();
		}
		return "forward:WEB-INF/jsp/readerList.jsp";
	}
	/**
	 * 进入已关注作者列表
	 * @param session
	 * @return
	 */
	@RequestMapping("followList")
	public String findFollow(HttpSession session) {
		//获取当前用户UID
		User logined = (User)session.getAttribute("logined");
		//获取已关注集合
		try {
			List<User> follows = userService.findAllAuthor(logined.getUid());
			session.setAttribute("follows", follows);
		} catch (MyException e) {
			e.printStackTrace();
		}
		return "forward:WEB-INF/jsp/followList.jsp";
	}
}
