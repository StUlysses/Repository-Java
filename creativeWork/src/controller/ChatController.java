package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bean.Chat;
import bean.QueryVo;
import bean.User;
import myException.MyException;
import service.ChatService;

@Controller
public class ChatController {
	@Autowired
	private ChatService chatService;
	/**
	 * 添加留言
	 * @param session
	 * @param uuid
	 * @param uname
	 * @param content
	 */
	@RequestMapping("addComment")
	public void addComment(HttpSession session,String uuid,String uname,String content){
		//设置留言者信息
		User user = (User)session.getAttribute("logined");
		//保存留言
		try {
			chatService.saveComment(user,uuid,uname,content);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 进入消息页面(我收到的留言)
	 * @return
	 */
	@RequestMapping("myComment")
	public String myComment(HttpSession session,String page){
		User user = (User)session.getAttribute("logined");
		try {
			QueryVo<Chat> qv = chatService.findAllCommentsByLid(page,user.getUid());
			session.setAttribute("comments", qv);
			//设置我的留言模式receiveComment
			session.setAttribute("chatMode", "rc");
		} catch (MyException e) {
			e.printStackTrace();
		}
		return "forward:WEB-INF/jsp/message.jsp";
	}
	/**
	 * 我的留言
	 * @param session
	 * @param page 当前页数
	 * @return
	 */
	@RequestMapping("sendComment")
	public String sendComment(HttpSession session,String page){
		User user = (User)session.getAttribute("logined");
		try {
			QueryVo<Chat> qv = chatService.findAllCommentsBySid(page,user.getUid());
			session.setAttribute("comments", qv);
		} catch (MyException e) {
			e.printStackTrace();
		}
		//设置我的留言模式sendComment
		session.setAttribute("chatMode", "sc");
		return "forward:WEB-INF/jsp/message.jsp";
	}
	/**
	 * 保存评论
	 * @return
	 */
	@RequestMapping("addReview")
	public void addReview(HttpSession session,String sid,String sname,String content,String belong,String lid,String title){
		//保存评论
		try {
			chatService.saveReview(sid,sname,content,belong,lid,title);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 查看我收到的评论
	 * @param session
	 * @param page 当前页数
	 * @return
	 */
	@RequestMapping("myReview")
	public String myReview(HttpSession session,String page){
		User user = (User)session.getAttribute("logined");
		try {
			QueryVo<Chat> qv = chatService.findReviewByLid(user.getUid(),page);
			session.setAttribute("comments", qv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//设置我的评论模式receiveReview
		session.setAttribute("chatMode", "rr");
		return "forward:WEB-INF/jsp/message.jsp";
	}
	/**
	 * 我发送的评论
	 * @param session
	 * @param page 当前页码
	 * @return
	 */
	@RequestMapping("sendReview")
	public String sendReview(HttpSession session,String page){
		User user = (User)session.getAttribute("logined");
		try {
			QueryVo<Chat> qv = chatService.findReviewBySid(user.getUid(),page);
			session.setAttribute("comments", qv);
		} catch (MyException e) {
			e.printStackTrace();
		}
		//设置我的评论模式sendReview
		session.setAttribute("chatMode", "sr");
		return "forward:WEB-INF/jsp/message.jsp";
	}
	/**
	 * 系统消息
	 * @param session
	 * @param page 当前页数
	 * @return
	 */
	@RequestMapping("systemMsg")
	public String systemMsg(HttpSession session,String page){
		User user = (User)session.getAttribute("logined");
		try {
			QueryVo<Chat> qv = chatService.findSystemMsgLid(page,user.getUid());
			session.setAttribute("comments", qv);
		} catch (MyException e) {
			e.printStackTrace();
		}
		//设置我的留言模式systemMsg
		session.setAttribute("chatMode", "sm");
		return "forward:WEB-INF/jsp/message.jsp";
	}
}
