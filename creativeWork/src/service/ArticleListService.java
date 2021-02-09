package service;

import java.util.List;

import bean.Accept;
import bean.Article;
import bean.Corpus;
import bean.Follow;
import bean.QueryVo;
import bean.Submit;
import bean.Theme;
import bean.User;
import bean.corpusContent;
import myException.MyException;

public interface ArticleListService{
//******************************文集操作****************************
	/**
	 * 新增文集
	 * @param corpus
	 */
	void addCorpus(Corpus corpus)throws Exception;
	/**
	 * 查询文集数量
	 * @param uid
	 * @return
	 */
	int findCorpusNum(int uid);
	/**
	 * 查询用户所有文集
	 * @param uid
	 * @return
	 */
	List<Corpus> findAllCorpus(int uid)throws MyException;
	/**
	 * 保存文章到文集
	 * @param coid
	 * @param arti
	 */
	void saveToCorpus(String coid, Article arti)throws Exception;
	/**
	 * 分页查询文集内所有文章
	 * @param coid
	 * @return
	 */
	List<corpusContent> getAllContent(QueryVo<corpusContent> ccs);
	/**
	 * 删除文集
	 * @param coid
	 */
	void removeCorpus(int coid)throws Exception;
	/**
	 * 删除文集中的文章
	 * @param coid
	 * @param aid
	 */
	void removeCorpusContent(String coid, String aid);
	/**
	 * 查询文集中同名文章
	 * @param coid
	 * @param arti
	 * @return
	 */
	boolean findCorpuscontentName(String coid, Article arti);
//********************************专题相关*****************************
	/**
	 * 实现创建专题逻辑
	 * @param user 用户信息
	 * @param tname 专题名
	 * @param bulletin 公告
	 * @param info 简介
	 * @throws MyException
	 */
	Theme createTheme(User user, String tname, String bulletin, String info)throws MyException;
	/**
	 * 根据用户ID查找专题
	 * @param uid 用户ID
	 * @throws MyException
	 */
	Theme findThemeByUid(int uid)throws MyException;
	/**
	 * 测试专题名是否唯一
	 * @param tname 专题名
	 * @return 唯一返回yes
	 * @throws MyException
	 */
	String tnameAvailable(String tname)throws MyException;
	/**
	 * 编辑专题的公告
	 * @param bulletin 新的公告
	 * @param uid 用户ID
	 * @throws MyException
	 */
	void editBulletin(String bulletin,String uid)throws MyException;
	/**
	 * 根据uid删除专题
	 * @param uid 用户ID
	 */
	void dropTheme(String uid)throws MyException;
	/**
	 * 根据关键字分页搜索专题
	 * @param tname
	 * @return
	 */
	QueryVo<Theme> searchThemeByTname(String tname,String page)throws MyException;
	/**
	 * 根据tid查询专题信息
	 * @param tid
	 * @return
	 * @throws MyException
	 */
	Theme findThemeByTid(int tid)throws MyException;
	/**
	 * 查询5个活跃专题
	 * @return
	 * @throws MyException
	 */
	List<Theme> findThemeByAccepttime()throws MyException;
	/**
	 * 根据关键字模糊搜索专题
	 * @param word
	 * @return
	 */
	List<Theme> findThemeByWord(String word)throws MyException;
//************************************投稿操作**************************************
	/**
	 * 文章投稿
	 * @param arti 投稿的文章
	 * @param tid 专题ID
	 * @param tname 专题名
	 */
	void articleSubmit(Article arti, String tid, String tname)throws MyException;
	/**
	 * 根据专题名分页查询投稿文章
	 * @param tname
	 * @param page
	 * @return
	 * @throws MyException
	 */
	QueryVo<Submit> findSubmitArticle(String tname,String page)throws MyException;
	/**
	 * 查看是否重复投稿
	 * @param tid 专题id
	 * @param id 文章id
	 * @return
	 */
	boolean isSubmited(String tid, int id);
//***************************收录相关**********************************
	/**
	 * 收录稿件
	 * @param theme 收录稿件的专题
	 * @param aid 稿件ID
	 * @param title 稿件标题
	 * @param collectNum 稿件收藏数
	 * @param size 稿件字数
	 * @throws MyException
	 */
	void acceptSubmit(Theme theme, String aid, String title)throws MyException;
	/**
	 * 拒绝稿件
	 * @param tid 专题ID
	 * @param aid 文章ID
	 * @throws MyException
	 */
	void objectSubmit(Theme theme, String aid, String title)throws MyException;
	/**
	 * 根据专题ID查询收录文章数
	 * @param tid 专题ID
	 * @return
	 * @throws MyException
	 */
	int findTotalArticleByTid(int tid)throws MyException;
	/**
	 * 根据tid分页查询所有收录文章
	 * @param tid 专题ID
	 * @return
	 * @throws MyException
	 */
	QueryVo<Accept> findAllAcceptByQueryVo(int tid,String page)throws MyException;
	/**
	 * 查找文章被哪些专题收录
	 * @param aid 文章ID
	 * @return
	 * @throws MyException
	 */
	List<Theme> findThemeByAid(int aid)throws MyException;
//***************************订阅相关********************************
	/**
	 * 根据用户ID和专题ID查询是否已订阅
	 * @param uid 用户ID
	 * @param tid 专题ID
	 * @return
	 */
	String isFollowTheme(int uid, int tid);
	/**
	 * 订阅专题
	 * @param uid 用户ID
	 * @param tid 专题ID
	 * @param tname 专题名
	 * @throws MyException
	 */
	void followTheme(int uid, int tid, String tname)throws MyException;
	/**
	 * 取消订阅专题
	 * @param uid 用户ID
	 * @param tid 专题ID
	 * @param tname 专题名
	 * @throws MyException
	 */
	void cancelFollowTheme(int uid, int tid)throws MyException;
	/**
	 * 查询用户订阅的专题
	 * @param uid 用户ID
	 * @return 
	 * @throws MyException
	 */
	List<Follow> findAllThemeByUid(int uid)throws MyException;
	/**
	 * 查找订阅该专题的人数
	 * @param tid 专题ID
	 * @return
	 * @throws MyException
	 */
	int findTotalReaderByTid(int tid)throws MyException;
	
}
