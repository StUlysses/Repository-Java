package mapper;

import java.util.List;

import bean.Chat;
import bean.QueryVo;

public interface ChatMapper {
	/**
	 * 根据听者ID查询留言数
	 * @param lid
	 * @return
	 */
	int selectCommentCountByLid(int lid);
	/**
	 * 插入留言数据
	 * @param chat
	 */
	void insertComment(Chat chat);
	/**
	 * 根据听者ID查询会话数据
	 * @param qv
	 * @return
	 */
	List<Chat> selectCommentsByLid(QueryVo<Chat> qv);
	/**
	 * 根据用户ID查询留言数
	 * @param uid
	 * @return
	 */
	int selectCommentCountBySid(int uid);
	/**
	 * 根据听者ID查询会话数据
	 * @param qv
	 * @return
	 */
	List<Chat> selectCommentsBySid(QueryVo<Chat> qv);
	/**
	 * 根据被关注者ID查询关注信息
	 * @param qv
	 * @return
	 */
	List<Chat> selectSystemByLid(QueryVo<Chat> qv);
	/**
	 * 根据lid查询记录数
	 * @param uid
	 * @return
	 */
	int selectReviewCountByLid(int lid);
	/**
	 * 根据lid分页查询评论数据
	 * @param qv
	 * @return
	 */
	List<Chat> selectReviewByLid(QueryVo<Chat> qv);
	/**
	 * 根据sid查询记录数
	 * @param uid
	 * @return
	 */
	int selectReviewCountBySid(int sid);
	/**
	 * 根据sid分页查询评论数据
	 * @param qv
	 * @return
	 */
	List<Chat> selectReviewBySid(QueryVo<Chat> qv);
	/**
	 * 根据belong查询评论
	 * @param aid
	 * @return
	 */
	List<Chat> selectReviewByBelong(int aid);
	/**
	 * 根据用户ID查询系统消息数量
	 * @param uid
	 * @return
	 */
	int selectSystemCommentCount(int uid);
}
