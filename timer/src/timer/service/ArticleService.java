package timer.service;

import java.util.List;

import timer.bean.Article;
import timer.bean.ArticleEntity;
/**
 * 文章接口
 * @author ROBB
 *
 */
public interface ArticleService {
	/**
	 * 新增文章
	 * @param title 文章标题
	 * @param path 图片路径
	 * @param tid 时间轴id
	 */
	void saveArticle(String title,String content,String path,String tid);
	/**
	 * 通过时间轴ID查找文章合集
	 * @param tid
	 * @return
	 */
	List<ArticleEntity> findArticleByTid(String tid);
	/**
	 * 通过文章ID移除文章
	 * @param aid
	 */
	void removeArticleByID(String aid);
	/**
	 * 查找单个文章
	 * @param aid
	 * @return
	 */
	Article findSimpleArticleByAid(String aid);
}
