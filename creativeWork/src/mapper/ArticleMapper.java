package mapper;

import java.util.List;

import bean.Article;
import bean.Collect;
import bean.Draft;
import bean.QueryVo;

public interface ArticleMapper {
//***********************************文章表*************************************
	/**
	 * 向文章表插入数据
	 * @param article
	 */
	void insertArticle(Article article);
	/**
	 * 根据queryVo查询多篇文章
	 * @param uid
	 * @return
	 */
	List<Article> selectArticleByQueryVo(QueryVo<Article> qv);
	/**
	 * 查询用户有多少篇文章
	 * @param uid
	 * @return
	 */
	int selectArticleCountByUid(int uid);
	/**
	 * 查询总共有多少文章
	 * @return
	 */
	int selectArticleCount();
	/**
	 * 根据文章id查询单篇文章
	 * @param id
	 * @return
	 */
	Article selectArticleById(int id);
	/**
	 * 跟新同一作者的同名文章
	 * @param article
	 */
	void updateArticleByAid(Article article);
	/**
	 * 根据id删除文章
	 * @param id
	 */
	void deleteArticleById(int id);
	/**
	 * 文章收藏数+1
	 * @param aid
	 */
	void addArticleCollect(int aid);
	/**
	 * 文章收藏数-1
	 * @param aid
	 */
	void lessArticleCollect(int aid);
	/**
	 * 返回模糊查询得到的记录数
	 * @param word
	 * @return
	 */
	int selectArticleCountByWord(String word);
	/**
	 * 向文章表分页模糊查询
	 * @param qv
	 * @return
	 */
	List<Article> selectArticleByWord(QueryVo<Article> qv);
//*************************************草稿表**************************************
	/**
	 * 向草稿表插入数据
	 * @param draft
	 */
	void insertDraft(Draft draft);
	/**
	 * 查询用户有多少篇草稿
	 * @param uid
	 * @return
	 */
	int selectDraftConutByUid(int uid);
	/**
	 * 根据ID向草稿表查询草稿
	 * @param uid
	 * @return
	 */
	Draft selectDraftById(int id);
	/**
	 * 根据id删除草稿
	 * @param id
	 */
	void deleteDraftById(int id);
	/**
	 * 跟新同一作者的同名草稿
	 * @param article
	 */
	void updateDraftByTAU(Draft draft);
	/**
	 * 根据queryVo查询多篇草稿
	 * @param qv
	 * @return
	 */
	List<Draft> selectDraftByQueryVo(QueryVo<Draft> qv);
//********************************************收藏表**************************************
	/**
	 * 插入收藏数据
	 * @param clt
	 */
	void insertCollect(Collect clt);
	/**
	 * 删除收藏数据
	 * @param clt
	 */
	void deleteCollectByUidAndAid(Collect clt);
	/**
	 * 根据aid,uid查询数据
	 * @param clt
	 * @return
	 */
	int selectCollect(Collect clt);
	/**
	 * 根据queryVo查询收藏数据
	 * @param uid
	 * @return
	 */
	List<Collect> selectCollectByQueryVo(QueryVo<Collect> qv);
	/**
	 * 根据UID查询收藏数量
	 * @param uid
	 * @return
	 */
	int selectCollectCountByUid(int uid);
	/**
	 * 根据文章id删除收藏数据
	 * @param id
	 */
	void deleteCollectById(int id);
	/**
	 * 根据aid更新文章
	 * @param col
	 */
	void updateCollectById(Collect col);
	/**
	 * 根据文章ID查询作者ID
	 * @param aid
	 */
	int selectUidByAid(int id);
	/**
	 * 根据用户ID和文章标题查询文章
	 * @param uid
	 * @param title
	 * @return
	 */
	Article selectArticleByUidAndTitle(Article arti);
}
