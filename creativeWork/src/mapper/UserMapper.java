package mapper;

import java.util.List;

import bean.Reader;
import bean.User;
import bean.UserActive;

public interface UserMapper {
//**********************************用户表*************************************
	/**
	 * 插入用户数据
	 * @param user
	 */
	void insertUser(User user);
	/**
	 * 根据用户名密码查询用户
	 * @param user
	 * @return
	 */
	User selectUserByUAP(User user);
	/**
	 * 更新用户信息
	 * @param user
	 */
	void updateUserInfo(User user);
	/**
	 * 根据ID查询用户信息（访问他人主页使用）
	 * @param uid
	 * @return
	 */
	User selectUserInfo(int uid);
	/**
	 * 用户收藏数+1
	 * @param uid
	 */
	void addUserCollect(int uid);
	/**
	 * 用户收藏数-1
	 * @param uid
	 */
	void lessUserCollect(int uid);
//*****************************用户活跃表*********************************
	/**
	 * 根据ID查询用户活跃表
	 * @param uid
	 * @return
	 */
	int selectUserActiveById(int uid);
	/**
	 * 向用户活跃表插入数据
	 * @param ua
	 */
	void insertUserActive(UserActive ua);
	/**
	 * 更新用户活跃数据
	 * @param ua
	 */
	void updateUserActive(UserActive ua);
//****************************用户表与用户活跃表******************************
	/**
	 * 根据登录时间查询用户UID
	 * @return
	 */
	List<UserActive> selectUserActiveBylasttime();
//***************************************读者表*************************************
	/**
	 * 向读者表插入数据
	 * @param reader
	 */
	void insertReader(Reader reader);
	/**
	 * 查询已关注的作者
	 * @param rid 读者ID
	 * @return 关注的人集合
	 */
	List<Integer> selectFollowByRid(int rid);
	/**
	 * 删除关注信息
	 * @param reader
	 */
	void deleteReaderById(Reader reader);
	/**
	 * 根据UID查询读者信息
	 * @param uid
	 * @return
	 */
	List<User> selectReaderByUid(int uid);
	/**
	 * 关注数+1
	 * @param uid
	 */
	void addFollowNum(int uid);
	/**
	 * 关注数-1
	 * @param uid
	 */
	void lessFollowNum(int uid);
	/**
	 * 读者数+1
	 * @param uid
	 */
	void addReaderNum(int uid);
	/**
	 * 读者数-1
	 * @param uid
	 */
	void lessReaderNum(int uid);
	/**
	 * 根据UID查询已关注作者信息
	 * @param uid
	 * @return
	 */
	List<User> selectFollowByUid(int uid);
	/**
	 * 根据用户名模糊搜索用户
	 * @param word
	 * @return
	 */
	List<User> selectUserByUsername(String word);
}
