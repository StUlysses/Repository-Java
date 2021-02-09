package service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.Accept;
import bean.Article;
import bean.Chat;
import bean.Corpus;
import bean.Follow;
import bean.QueryVo;
import bean.Submit;
import bean.Theme;
import bean.User;
import bean.corpusContent;
import mapper.ArticleListMapper;
import mapper.ArticleMapper;
import mapper.ChatMapper;
import myException.MyException;
import service.ArticleListService;
@Service
public class ArticleListServiceImpl implements ArticleListService {
	@Autowired
	private ArticleListMapper alMapper;
	@Autowired
	private ArticleMapper artiMapper;
	@Autowired
	private ChatMapper chatMapper;
	
	@Override
	public void addCorpus(Corpus corpus)throws Exception{
		alMapper.insertCorpus(corpus);
	}
	@Override
	public int findCorpusNum(int uid){
		return alMapper.selectCorpusNumByUid(uid);
	}
	@Override
	public List<Corpus> findAllCorpus(int uid) {
		List<Corpus> list = alMapper.selectAllCorpus(uid);
		return list;
	}
	@Override
	public void saveToCorpus(String coid, Article arti) throws Exception {
		//建立文集内容关系
		corpusContent cc = new corpusContent();
		int Coid = Integer.parseInt(coid);
		cc.setCoid(Coid);
		cc.setAid(arti.getId());
		cc.setTitle(arti.getTitle());
		alMapper.insertArticle(cc);
	}
	@Override
	public List<corpusContent> getAllContent(QueryVo<corpusContent> ccs) {
		//查询总记录数
		int coid = ccs.getUid();
		int totalRecord = alMapper.selectCorpusCountBuCoid(coid);
		ccs.setTotalRecord(totalRecord);
		//设置总页数
		int totalPage = (int)Math.ceil(totalRecord/(ccs.getPageSize()*1.0));
		ccs.setTotalPage(totalPage);
		//设置偏移量
		int offset = (ccs.getCurrentPage()-1)*ccs.getPageSize();
		ccs.setOffset(offset);
		return alMapper.selectCorpusByQueryVo(ccs);
	}
	@Override
	public void removeCorpus(int coid) throws Exception {
		//删除文集内文章
		alMapper.deleteCorpusContentByCoid(coid);
		//删除文集
		alMapper.deleteCorpusByCoid(coid);;
	}
	@Override
	public void removeCorpusContent(String coid, String aid) {
		//根据aid删除文集内容
		int Coid = Integer.parseInt(coid);
		int Aid = Integer.parseInt(aid);
		corpusContent cc = new corpusContent();
		cc.setAid(Aid);
		cc.setCoid(Coid);
		alMapper.deleteCorpusContentByAidAndCoid(cc);
	}
	@Override
	public boolean findCorpuscontentName(String coid, Article arti) {
		//查询同名文章
		int Coid = Integer.parseInt(coid);
		corpusContent cc = new corpusContent();
		cc.setAid(arti.getId());
		cc.setCoid(Coid);
		int num = alMapper.selectCorpusContentByAid(cc);
		boolean bool = false;
		if(num > 0) {
			bool = true;
		}
		return bool;
	}
	@Override
	public Theme createTheme(User user, String tname, String bulletin, String info) throws MyException {
		//设置专题信息
		Theme theme = new Theme();
		theme.setTname(tname);
		theme.setUid(user.getUid());
		theme.setUsername(user.getUsername());
		theme.setInfo(info);
		theme.setBulletin(bulletin);
		//保存专题信息
		alMapper.insertTheme(theme);
		return theme;
	}
	@Override
	public Theme findThemeByUid(int uid) throws MyException {
		return alMapper.selectThemeByUid(uid);
	}
	@Override
	public String tnameAvailable(String tname) throws MyException {
		int num = alMapper.selectThemeCountByTname(tname);
		if(num == 0) {
			return "yes";
		}else{
			return "no";
		}
	}
	@Override
	public void editBulletin(String bulletin,String uid) throws MyException {
		Theme theme = new Theme();
		theme.setBulletin(bulletin);
		int Uid = Integer.parseInt(uid);
		theme.setUid(Uid);
		alMapper.updateBulletinByUid(theme);
		
	}
	@Override
	public void dropTheme(String uid) throws MyException {
		int Uid = Integer.parseInt(uid);
		alMapper.deleteThemeByUid(Uid);
	}
	@Override
	public QueryVo<Theme> searchThemeByTname(String tname,String page) throws MyException {
		QueryVo<Theme> qv = new QueryVo<Theme>();
		//默认为第一页
		if(page != null) {
			int currentPage = Integer.parseInt(page);
			qv.setCurrentPage(currentPage);
		}else {
			qv.setCurrentPage(1);
		}
		//设置关键字
		qv.setWord(tname);
		//查询总记录数
		int totalRecord = alMapper.selectThemeCountByWord(tname);
		qv.setTotalRecord(totalRecord);
		//设置总页数
		int totalPage = (int)Math.ceil(totalRecord/(qv.getPageSize()*1.0));
		qv.setTotalPage(totalPage);
		//设置偏移量
		int offset = (qv.getCurrentPage()-1)*qv.getPageSize();
		qv.setOffset(offset);
		List<Theme> list = alMapper.selectThemeByQueryVo(qv);
		qv.setList(list);
		return qv;
	}
	@Override
	public Theme findThemeByTid(int tid) throws MyException {
		return alMapper.selectThemeByTid(tid);
	}
	@Override
	public void articleSubmit(Article arti, String tid, String tname) throws MyException {
		//建立投稿关系
		Submit sub = new Submit();
		//设置文章id
		sub.setAid(arti.getId());
		//设置专题信息
		int Tid = Integer.parseInt(tid);
		sub.setTid(Tid);
		sub.setTname(tname);
		sub.setSubmittime(new Date());
		//实现投稿
		alMapper.insertSubmit(sub);
	}
	@Override
	public QueryVo<Submit> findSubmitArticle(String tname,String page) throws MyException {
		QueryVo<Submit> qv = new QueryVo<Submit>();
		//默认为第一页
		if(page != null) {
			int currentPage = Integer.parseInt(page);
			qv.setCurrentPage(currentPage);
		}else {
			qv.setCurrentPage(1);
		}
		//设置关键字
		qv.setWord(tname);
		//查询总记录数
		int totalRecord = alMapper.selectSubmitCountByWord(tname);
		qv.setTotalRecord(totalRecord);
		//设置总页数
		int totalPage = (int)Math.ceil(totalRecord/(qv.getPageSize()*1.0));
		qv.setTotalPage(totalPage);
		//设置偏移量
		int offset = (qv.getCurrentPage()-1)*qv.getPageSize();
		qv.setOffset(offset);
		List<Submit> list = alMapper.selectSubmitByTname(qv);
		qv.setList(list);
		return qv;
	}
	@Override
	public boolean isSubmited(String tid, int id) {
		Submit sub = new Submit();
		sub.setTid(Integer.parseInt(tid));
		sub.setAid(id);
		int num = alMapper.selectSubmitCountByTidAndAid(sub);
		if(num > 0) {
			return true;
		}
		return false;
	}
	@Override
	public void acceptSubmit(Theme theme, String aid, String title) throws MyException {
		//建立收录关系
		Accept acc = new Accept();
		acc.setAccepttime(new Date());
		//设置专题信息
		acc.setTid(theme.getTid());
		acc.setTname(theme.getTname());
		//设置文章id
		int Aid = Integer.parseInt(aid);
		acc.setAid(Aid);
		alMapper.insertAccept(acc);
		//删除投稿信息
		Submit sub = new Submit();
		sub.setTid(theme.getTid());
		sub.setAid(Aid);
		alMapper.deleteSubmitByTidAndId(sub);
		//发送收录信息
		Chat chat = new Chat();
		chat.setSort("s");
		chat.setChattime(new Date());
		//查询文章作者
		int uid = artiMapper.selectUidByAid(Aid);
		chat.setLid(uid);
		String content = "《"+theme.getTname()+"》收录了你的文章"+title;
		chat.setContent(content);
		chatMapper.insertComment(chat);
	}
	@Override
	public void objectSubmit(Theme theme, String aid, String title) throws MyException {
		//删除投稿信息
		Submit sub = new Submit();
		sub.setTid(theme.getTid());
		int Aid = Integer.parseInt(aid);
		sub.setAid(Aid);
		alMapper.deleteSubmitByTidAndId(sub);
		//发送拒绝信息
		Chat chat = new Chat();
		chat.setSort("s");
		chat.setChattime(new Date());
		//查询文章作者
		int uid = artiMapper.selectUidByAid(Aid);
		chat.setLid(uid);
		String content = "你的文章"+title+"没有被专题《"+theme.getTname()+"》收录";
		chat.setContent(content);
		chatMapper.insertComment(chat);
	}
	@Override
	public int findTotalArticleByTid(int tid) throws MyException {
		return alMapper.selectAcceptCountByTid(tid);
	}
	@Override
	public QueryVo<Accept> findAllAcceptByQueryVo(int tid,String page) throws MyException {
		QueryVo<Accept> qv = new QueryVo<Accept>();
		//默认为第一页
		if(page != null) {
			int currentPage = Integer.parseInt(page);
			qv.setCurrentPage(currentPage);
		}else {
			qv.setCurrentPage(1);
		}
		//设置专题ID
		qv.setUid(tid);
		//查询总记录数
		int totalRecord = alMapper.selectAcceptCountByTid(tid);
		qv.setTotalRecord(totalRecord);
		//设置总页数
		int totalPage = (int)Math.ceil(totalRecord/(qv.getPageSize()*1.0));
		qv.setTotalPage(totalPage);
		//设置偏移量
		int offset = (qv.getCurrentPage()-1)*qv.getPageSize();
		qv.setOffset(offset);
		List<Accept> list = alMapper.selectAcceptByQueryVO(qv);
		qv.setList(list);
		return qv;
	}
	@Override
	public List<Theme> findThemeByAccepttime() throws MyException {
		return alMapper.selectThemeByAccepttime();
	}
	@Override
	public String isFollowTheme(int uid, int tid) {
		Follow fol = new Follow();
		fol.setTid(tid);
		fol.setUid(uid);
		int num = alMapper.selectFollowCountByUidAndTid(fol);
		if(num > 0) {
			return "yes";
		}
		return "no";
	}
	@Override
	public void followTheme(int uid, int tid, String tname) throws MyException {
		Follow fol = new Follow();
		fol.setTid(tid);
		fol.setUid(uid);
		fol.setTname(tname);
		alMapper.insertFollow(fol);
	}
	@Override
	public void cancelFollowTheme(int uid, int tid) throws MyException {
		Follow fol = new Follow();
		fol.setTid(tid);
		fol.setUid(uid);
		alMapper.cancelFollowTheme(fol);
	}
	@Override
	public List<Follow> findAllThemeByUid(int uid) throws MyException {
		return alMapper.selectFollowByUid(uid);
	}
	@Override
	public int findTotalReaderByTid(int tid) throws MyException {
		return alMapper.selectFollowCountByTid(tid);
	}
	@Override
	public List<Theme> findThemeByWord(String word) throws MyException {
		return alMapper.selectThemeByWord(word);
	}
	@Override
	public List<Theme> findThemeByAid(int aid) throws MyException {
		return alMapper.selectThemeByAid(aid);
	}

}
