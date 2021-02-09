package service;

import java.util.List;

import bean.Chat;
import bean.QueryVo;
import bean.User;
import myException.MyException;

public interface ChatService {
	/**
	 * 保存留言
	 * @param user 留言者信息
	 * @param uuid 收听者ID
	 * @param uname 收听者名字
	 * @param content 留言内容
	 * @throws MyException
	 */
	public void saveComment(User user,String uuid,String uname,String content)throws MyException;
	/**
	 * 查询用户收到的所有留言
	 * @param uid
	 * @return
	 */
	public QueryVo<Chat> findAllCommentsByLid(String page,int uid)throws MyException;
	/**
	 * 查询用户发送的所有留言
	 * @param qv
	 * @return
	 * @throws MyException
	 */
	public QueryVo<Chat> findAllCommentsBySid(String page,int uid)throws MyException;
	/**
	 * 保存关注消息
	 * @param user 用户信息
	 * @param uid 被关注者ID
	 * @throws MyException
	 */
	public void saveSystemMsg(User user,int uid)throws MyException;
	/**
	 * 查询系统消息
	 * @param qv
	 * @return
	 * @throws MyException
	 */
	public QueryVo<Chat> findSystemMsgLid(String page,int uid)throws MyException;
	/**
	 * 保存评论
	 * @param sid 评论者ID
	 * @param sname 评论者名字
	 * @param content 评论内容
	 * @param belong 所属文章ID
	 */
	public void saveReview(String sid, String sname, String content, String belong,String lid,String title)throws MyException;
	/**
	 * 分页查询用户收到的评论
	 * @param uid 用户ID
	 * @param page 当前页数
	 * @return
	 */
	public QueryVo<Chat> findReviewByLid(int uid, String page)throws MyException;
	/**
	 * 分页查询发送的评论
	 * @param uid 用户ID
	 * @param page 当前页数
	 * @return
	 * @throws MyException
	 */
	public QueryVo<Chat> findReviewBySid(int uid, String page)throws MyException;
	/**
	 * 根据文章ID查询所有评论
	 * @param aid 文章ID
	 * @return
	 * @throws MyException
	 */
	public List<Chat> findReviewByBelong(int aid)throws MyException;
	
}
