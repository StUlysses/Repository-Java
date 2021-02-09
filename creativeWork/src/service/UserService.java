package service;

import java.util.List;

import bean.User;
import bean.UserActive;
import myException.MyException;
/**
 * 用户相关逻辑接口
 * @author CAOto
 *
 */
public interface UserService {
	/**
	 * 注册用户
	 * @param user 用户模型
	 * @return
	 */
	public void registerUser(User user)throws MyException;
	/**
	 * 用户登录
	 * @param user 用户模型
	 * @return 登录成功返回用户信息
	 */
	public User loginUser(User user)throws MyException;
	/**
	 * 更新用户信息
	 * @param user 用户模型
	 */
	public void updateUserInfo(User user)throws MyException;
	/**
	 * 更新用户最后登录时间
	 * @param ua
	 */
	public void updateUserLasttime(User user)throws MyException;
	/**
	 * 查询活跃用户
	 * @param uas
	 * @return
	 */
	public List<UserActive> findUsersByLasttime()throws MyException;
	/**
	 * 通过id查询其他用户公开信息
	 * @param uid 用户ID
	 * @return
	 */
	public User findOtherUser(int uid)throws MyException;
	/**
	 * 关注行为实现
	 * @param user 登录者
	 * @param uid 对方ID
	 * @throws MyException
	 */
	public void followAuthor(User user,int uid)throws MyException;
	/**
	 * 查询是否已关注
	 * @param rid 当前用户(读者）ID
	 * @param uid 对方ID
	 * @return 有就返回true
	 */
	public boolean findIsFollow(int rid,int uid)throws MyException;
	/**
	 * 取消关注
	 * @param reader 读者关系模型
	 */
	public void cancelFollow(User user,int uid)throws MyException;
	/**
	 * 查询所有读者
	 * @param reader 读者关系模型
	 * @return
	 */
	public List<User> findAllReader(int uid)throws MyException;
	/**
	 * 查询所有已关注作者
	 * @param reader 读者关系模型
	 * @return
	 */
	public List<User> findAllAuthor(int uid)throws MyException;
	/**
	 * 根据关键字查询用户
	 * @param word
	 * @return
	 */
	public List<User> findUserByWord(String word)throws MyException;
}
