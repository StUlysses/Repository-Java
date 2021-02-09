package timer.mapper;

import java.util.List;


import timer.bean.Article;
import timer.bean.ArticleEntity;
import timer.bean.Attachment;

public interface ArticleMapper {
	/**
	 * 插入一篇文章
	 * @param arti
	 */
	void InsertArticle(Article arti);
	/**
	 * 通过时间轴ID查找所有文章
	 * @param tid
	 * @return
	 */
	List<ArticleEntity> selectArticleList(String tid);
	/**
	 * 插入附件
	 * @param att
	 */
	void InsertAttachment(Attachment att);
	/**
	 * 根据文章ID查询附件
	 * @param aid
	 * @return
	 */
	List<Attachment> selectAttachmentByaid(String aid);
	/**
	 * 通过文章ID软删除文章
	 * @param aid
	 */
	void deleteArticleById(String aid);
	/**
	 * 查找单个文章
	 * @param aid
	 * @return
	 */
	Article selectSimpleArticleByAid(String aid);
}
