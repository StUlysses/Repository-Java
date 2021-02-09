package service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.Article;
import bean.Collect;
import bean.Draft;
import bean.QueryVo;
import bean.User;
import mapper.ArticleListMapper;
import mapper.ArticleMapper;
import mapper.UserMapper;
import myException.MyException;
import service.ArticleService;

@Service
public class ArticleServiceimpl implements ArticleService {
	
	@Autowired
	private ArticleMapper artiMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ArticleListMapper alMapper;
	@Override
	
	public void saveArticle(String title,String content,User user,String draftId)throws MyException{
		//建立草稿bean
		Draft dra = new Draft();
		dra.setContent(content);
		dra.setTitle(title);
		dra.setSize(content.length());
		dra.setUid(user.getUid());
		dra.setUsername(user.getUsername());
		if(draftId == null || "0".equals(draftId)) {
			//新增草稿
			artiMapper.insertDraft(dra);
		}else {
			//跟新草稿
			artiMapper.updateDraftByTAU(dra);			
		}		
	}
	
	@Override
	public Article publishArticle(User user,String title,String content) throws MyException{
		//建立文章bean
		Article art = new Article();
		//存入作者信息
		art.setUid(user.getUid());
		art.setUsername(user.getUsername());
		art.setUserinfo(user.getInfo());
		//文章信息
		art.setTitle(title);
		art.setContent(content);
		art.setSize(content.length());
		art.setUpdatetime(new Date());
		//新增文章
		artiMapper.insertArticle(art);
		return art;
	}

	@Override
	public Article publishDraft(User user,String draftId, String title, String content) throws MyException {
		//删除草稿
		int did = Integer.parseInt(draftId);
		artiMapper.deleteDraftById(did);
		//建立文章bean
		Article art = new Article();
		//存入作者信息
		art.setUid(user.getUid());
		art.setUsername(user.getUsername());
		art.setUserinfo(user.getInfo());
		//文章信息
		art.setTitle(title);
		art.setContent(content);
		art.setSize(content.length());
		art.setUpdatetime(new Date());
		//新增文章
		artiMapper.insertArticle(art);
		return art;
	}
	
	@Override
	public Article editArticle(Article arti, String title, String content) throws MyException{
		//	更新文章
		arti.setTitle(title);
		arti.setContent(content);
		arti.setSize(content.length());
		arti.setUpdatetime(new Date());
		artiMapper.updateArticleByAid(arti);
		return arti;
	}
	
	@Override
	public QueryVo<Article> findArticleByUid(int uid,String page)throws MyException{
		QueryVo<Article> qv = new QueryVo<Article>();
		//默认当前为第一页
		if(page == null || page == "") {
			page = "1";
		}
		int currentPage = Integer.parseInt(page);
		qv.setCurrentPage(currentPage);
		qv.setUid(uid);
		//查询总记录数
		int totalRecord;
		if(uid == 0) {
			totalRecord = artiMapper.selectArticleCount();
		}else{
			totalRecord = artiMapper.selectArticleCountByUid(qv.getUid());
		}
		qv.setTotalRecord(totalRecord);
		//设置总页数
		int totalPage = (int)Math.ceil(totalRecord/(qv.getPageSize()*1.0));
		qv.setTotalPage(totalPage);
		//设置偏移量
		int offset = (qv.getCurrentPage()-1)*qv.getPageSize();
		qv.setOffset(offset);
		//查询文章集合
		List<Article> list = artiMapper.selectArticleByQueryVo(qv);
		qv.setList(list);
		return qv;
	}
	
	@Override
	public Article findArticle(int id)throws MyException{
		return artiMapper.selectArticleById(id);
	}
	
	@Override
	public Draft findDraft(int id)throws MyException{
		return artiMapper.selectDraftById(id);
	}
	
	@Override
	public void dropArticleById(Article article)throws MyException{
		int id = article.getId();
		//删除文章
		artiMapper.deleteArticleById(id);
		//删除收藏文章
		artiMapper.deleteCollectById(id);
		//删除文集文章
		alMapper.deleteCorpusContentByAid(id);
		//删除投稿文章
		alMapper.deleteSubmitById(id);
		//删除已收录文章
		alMapper.deleteAcceptByAid(id);
	}
	@Override
	public QueryVo<Article> findArticleByWord(String word,String page)throws MyException{
		QueryVo<Article> qv = new QueryVo<Article>();
		qv.setWord(word);
		//默认为第一页
		if(page == null || page == "") {
			page = "1";
		}
		int currentPage = Integer.parseInt(page);
		qv.setCurrentPage(currentPage);		
		//设置总记录数
		int totalRecord = artiMapper.selectArticleCountByWord(qv.getWord());
		qv.setTotalRecord(totalRecord);
		//设置总页数
		int totalPage = (int)Math.ceil(totalRecord/(qv.getPageSize()*1.0));
		qv.setTotalPage(totalPage);
		//设置偏移量
		int offset = (qv.getCurrentPage()-1)*qv.getPageSize();
		qv.setOffset(offset);
		List<Article> list = artiMapper.selectArticleByWord(qv);
		qv.setList(list);
		return qv;
	}
	
	@Override
	public void dropDraft(int id)throws MyException{
		artiMapper.deleteDraftById(id);
	}
	
	@Override
	public QueryVo<Draft> findDraftByUid(User user,String page)throws MyException{
		//查询草稿，存入session
		QueryVo<Draft> qv = new QueryVo<Draft>();
		qv.setUid(user.getUid());
		//默认当前为第一页
		if(page == "" || page == null) {
			page = "1";
		}
		int currentPage = Integer.parseInt(page);
		qv.setCurrentPage(currentPage);
		
		//设置总记录数
		int totalRecord = artiMapper.selectDraftConutByUid(qv.getUid());
		qv.setTotalRecord(totalRecord);
		//设置总页数
		int totalPage = (int)Math.ceil(totalRecord/(qv.getPageSize()*1.0));
		qv.setTotalPage(totalPage);
		//设置偏移量
		int offset = (qv.getCurrentPage()-1)*qv.getPageSize();
		qv.setOffset(offset);
		List<Draft> list = artiMapper.selectDraftByQueryVo(qv);
		qv.setList(list);
		return qv;
	}
	
	@Override
	public void collectArticle(Collect clt)throws MyException{
		//用户收藏数+1
		userMapper.addUserCollect(clt.getUid());
		//文章收藏数+1
		artiMapper.addArticleCollect(clt.getAid());
		//向收藏表插入数据
		artiMapper.insertCollect(clt);
	}
	
	@Override
	public void cancelCollect(Collect clt)throws MyException{
		artiMapper.deleteCollectByUidAndAid(clt);
		artiMapper.lessArticleCollect(clt.getAid());
		userMapper.lessUserCollect(clt.getUid());
	}
	
	@Override
	public String findIsCollect(Collect clt)throws MyException{
		int num = artiMapper.selectCollect(clt);
		if(num == 0) {
			return "unCollect";
		}else {
			return "collected";
		}
	}
	
	@Override
	public QueryVo<Collect> findCollectArticle(User user,String page)throws MyException{
		//查询收藏，存入session
		QueryVo<Collect> qv = new QueryVo<Collect>();
		qv.setUid(user.getUid());
		//默认当前为第一页
		if(page == "" || page == null) {
			page = "1";
		}
		int currentPage = Integer.parseInt(page);
		qv.setCurrentPage(currentPage);
		//设置总记录数
		int totalRecord = artiMapper.selectCollectCountByUid(qv.getUid());
		qv.setTotalRecord(totalRecord);
		//设置总页数
		int totalPage = (int)Math.ceil(totalRecord/(qv.getPageSize()*1.0));
		qv.setTotalPage(totalPage);
		//设置偏移量
		int offset = (qv.getCurrentPage()-1)*qv.getPageSize();
		qv.setOffset(offset);
		List<Collect> list = artiMapper.selectCollectByQueryVo(qv);
		qv.setList(list);
		return qv;
	}
}
