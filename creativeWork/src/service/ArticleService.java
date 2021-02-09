package service;

import bean.Article;
import bean.Collect;
import bean.Draft;
import bean.QueryVo;
import bean.User;
import myException.MyException;

public interface ArticleService {
//*******************************文章相关************************************
	/**
	 * 发布文章
	 * @param article
	 */
	public Article publishArticle(User user,String title,String content)throws MyException;
	/**
	 * 更改文章
	 * @param arti 文章模型
	 * @param draftId 草稿ID
	 * @param content 
	 */
	public Article editArticle(Article arti, String title, String content)throws MyException;
	/**
	 * 	 * 分页查询该用户所有文章
	 * @param uid 用户ID，0表示查询所有用户文章
	 * @param page 当前页码
	 * @return
	 * @throws MyException
	 */
	public QueryVo<Article> findArticleByUid(int uid,String page)throws MyException;
	/**
	 * 查询单篇文章
	 * @param id 文章ID
	 * @return
	 */
	public Article findArticle(int id)throws MyException;
	/**
	 * 根据id删除文章
	 * @param article
	 */
	public void dropArticleById(Article article)throws MyException;
	/**
	 * 分页模糊查询文章
	 * @param word 关键字
	 * @param page 当前页码
	 * @return 文章分页数据模型
	 * @throws MyException
	 */
	public QueryVo<Article> findArticleByWord(String word,String page)throws MyException;
//************************************草稿相关***********************************
	/**
	 * 保存草稿
	 * @param draft 草稿数据模型
	 * @throws MyException
	 */
	public void saveArticle(String title,String content,User user,String draftId)throws MyException;
	/**
	 * 根据排序方式分页查询该用户所有草稿
	 * @param uid
	 * @return
	 */
	public QueryVo<Draft> findDraftByUid(User user,String page)throws MyException;
	/**
	 * 查询特定草稿
	 * @param id
	 * @return
	 */
	public Draft findDraft(int id)throws MyException;
	/**
	 * 根据id删除草稿
	 * @param id
	 */
	public void dropDraft(int id)throws MyException;
	/**
	 * 草稿发布
	 * @param draftId 草稿ID
	 * @param title 文章标题
	 * @param content 文章内容
	 * @throws MyException
	 */
	public Article publishDraft(User user,String draftId, String title, String content)throws MyException;
//****************************************收藏相关*********************************
	/**
	 * 实现收藏逻辑
	 * @param user
	 * @param clt
	 */
	public void collectArticle(Collect clt)throws MyException;
	/**
	 * 实现取消收藏
	 * @param clt
	 */
	public void cancelCollect(Collect clt)throws MyException;
	/**
	 * 查询是否已收藏
	 * @param clt 收藏关系模型
	 */
	public String findIsCollect(Collect clt)throws MyException;
	/**
	 * 获取用户收藏的文章
	 * @param uid
	 * @return
	 */
	public QueryVo<Collect> findCollectArticle(User user,String page)throws MyException;
	
}
