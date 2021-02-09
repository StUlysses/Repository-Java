package mapper;

import java.util.List;

import bean.Accept;
import bean.Corpus;
import bean.Follow;
import bean.QueryVo;
import bean.Submit;
import bean.Theme;
import bean.corpusContent;

public interface ArticleListMapper{
//*********************************文集********************************
	/**
	 * 向文集表插入数据
	 * @param corpus
	 */
	void insertCorpus(Corpus corpus);
	/**
	 * 向文集表根据UID查询记录数
	 * @param uid
	 * @return
	 */
	int selectCorpusNumByUid(int uid);
	/**
	 * 根据UID查询所有文集
	 * @param uid
	 * @return
	 */
	List<Corpus> selectAllCorpus(int uid);
	/**
	 * 向文集表插入文章
	 * @param cc
	 */
	void insertArticle(corpusContent cc);
	/**
	 * 根据coid查询记录数
	 * @param coid
	 * @return
	 */
	int selectCorpusCountBuCoid(int coid);
	/**
	 * 根据QueryVo分页查询CorpusContent
	 * @param ccs
	 * @return
	 */
	List<corpusContent> selectCorpusByQueryVo(QueryVo<corpusContent> ccs);
	/**
	 * 根据coid删除文集内容
	 * @param coid
	 */
	void deleteCorpusContentByCoid(int coid);
	/**
	 * 根据coid删除文集
	 * @param coid
	 */
	void deleteCorpusByCoid(int coid);
	/**
	 * 根据coid和aid删除文集中的文章
	 * @param cc
	 */
	void deleteCorpusContentByAidAndCoid(corpusContent cc);
	/**
	 * 根据文章id删除文集数据
	 * @param aid
	 */
	void deleteCorpusContentByAid(int aid);
	/**
	 * 查询文集内容表中的同一文章
	 * @param cc
	 * @return
	 */
	int selectCorpusContentByAid(corpusContent cc);
//*******************************专题**************************
	/**
	 * 插入专题信息
	 * @param theme
	 */
	void insertTheme(Theme theme);
	/**
	 * 根据uid查找专题
	 * @param uid 用户ID
	 * @return
	 */
	Theme selectThemeByUid(int uid);
	/**
	 * 根据tname获取记录数
	 * @param tname
	 * @return
	 */
	int selectThemeCountByTname(String tname);
	/**
	 * 根据tid更改专题的公告
	 * @param theme
	 */
	void updateBulletinByUid(Theme theme);
	/**
	 * 删除专题
	 * @param uid
	 */
	void deleteThemeByUid(int uid);
	/**
	 * 根据tname模糊查询记录数
	 * @param tname
	 * @return
	 */
	int selectThemeCountByWord(String tname);
	/**
	 *  根据tname模糊分页查询专题
	 * @param qv
	 * @return
	 */
	List<Theme> selectThemeByQueryVo(QueryVo<Theme> qv);
	/**
	 * 根据tid查询专题
	 * @param tid
	 * @return
	 */
	Theme selectThemeByTid(int tid);
	/**
	 * 根据关键字模糊搜索专题名
	 * @param word 关键字
	 * @return
	 */
	List<Theme> selectThemeByWord(String word);
//***********************************投稿****************************
	/**
	 * 向投稿表插入数据
	 * @param sub
	 */
	void insertSubmit(Submit sub);
	/**
	 * 根据专题名分页查询投稿文章
	 * @param tname
	 * @return
	 */
	List<Submit> selectSubmitByTname(QueryVo<Submit> qv);
	/**
	 * 根据专题名查询投稿文章数量
	 * @param tname
	 * @return
	 */
	int selectSubmitCountByWord(String tname);
	/**
	 * 根据tid和文章id查询是否已投稿
	 * @param sub
	 */
	int selectSubmitCountByTidAndAid(Submit sub);
	/**
	 * 删除投稿信息
	 * @param sub
	 */
	void deleteSubmitByTidAndId(Submit sub);
	/**
	 * 根据文章ID删除稿件
	 * @param id
	 */
	void deleteSubmitById(int id);
//******************************收录************************************
	/**
	 * 添加收录信息
	 * @param acc
	 */
	void insertAccept(Accept acc);
	/**
	 * 根据tid查询收录文章数
	 * @param tid
	 * @return
	 */
	int selectAcceptCountByTid(int tid);
	/**
	 * 分页查询收录文章
	 * @param qv
	 * @return
	 */
	List<Accept> selectAcceptByQueryVO(QueryVo<Accept> qv);
	/**
	 * 根据文章ID删除收录文章
	 * @param id
	 */
	void deleteAcceptByAid(int id);
//**************************综合*********************************
	/**
	 * 查询活跃专题
	 * @return
	 */
	List<Theme> selectThemeByAccepttime();
//***********************************订阅表*******************************
	/**
	 * 根据tid和uid查询订阅表长度
	 * @param fol
	 * @return
	 */
	int selectFollowCountByUidAndTid(Follow fol);
	/**
	 * 插入订阅专题信息
	 * @param fol
	 */
	void insertFollow(Follow fol);
	/**
	 * 移除订阅信息
	 * @param fol
	 */
	void cancelFollowTheme(Follow fol);
	/**
	 * 根据uid查询订阅信息
	 * @param uid
	 * @return
	 */
	List<Follow> selectFollowByUid(int uid);
	/**
	 * 根据tid查询订阅表长度
	 * @param tid
	 * @return
	 */
	int selectFollowCountByTid(int tid);
	/**
	 * 根据文章ID查找专题
	 * @param aid
	 * @return
	 */
	List<Theme> selectThemeByAid(int aid);
}
