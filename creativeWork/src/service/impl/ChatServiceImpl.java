package service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.Chat;
import bean.QueryVo;
import bean.User;
import mapper.ChatMapper;
import myException.MyException;
import service.ChatService;

@Service
public class ChatServiceImpl implements ChatService {
	@Autowired
	private ChatMapper chatMapper;
	
	@Override
	public void saveComment(User user,String uuid,String uname,String content) throws MyException {
		//建立会话关系
		Chat chat = new Chat();
		chat.setSid(user.getUid());
		chat.setSname(user.getUsername());
		//设置听者信息
		int lid = Integer.parseInt(uuid);
		chat.setLid(lid);
		chat.setLname(uname);
		//设置留言属性
		chat.setBelong(0);
		chat.setChattime(new Date());
		chat.setSort("u");
		chat.setContent(content);
		//保存留言
		chatMapper.insertComment(chat);
		
	}
	
	@Override
	public QueryVo<Chat> findAllCommentsByLid(String page,int uid) throws MyException  {
		QueryVo<Chat> qv = new QueryVo<Chat>();
		//默认当前为第一页
		if(page == null || page == "") {
			page = "1";
		}
		int currentPage = Integer.parseInt(page);
		qv.setCurrentPage(currentPage);
		qv.setUid(uid);
		//查询总记录数
		int totalRecord;
		totalRecord = chatMapper.selectCommentCountByLid(qv.getUid()); 
		qv.setTotalRecord(totalRecord);
		//设置每页15条
		qv.setPageSize(15);
		//设置总页数
		int totalPage = (int)Math.ceil(totalRecord/(qv.getPageSize()*1.0));
		qv.setTotalPage(totalPage);
		//设置偏移量
		int offset = (qv.getCurrentPage()-1)*qv.getPageSize();
		qv.setOffset(offset);
		List<Chat> comments = chatMapper.selectCommentsByLid(qv);
		qv.setList(comments);
		return qv;
	}
	
	@Override
	public QueryVo<Chat> findAllCommentsBySid(String page,int uid) throws MyException {
		QueryVo<Chat> qv = new QueryVo<Chat>();
		//默认当前为第一页
		if(page == null || page == "") {
			page = "1";
		}
		int currentPage = Integer.parseInt(page);
		qv.setCurrentPage(currentPage);
		qv.setUid(uid);
		//查询总记录数
		int totalRecord;
		totalRecord = chatMapper.selectCommentCountBySid(qv.getUid()); 
		qv.setTotalRecord(totalRecord);
		//设置每页15条
		qv.setPageSize(15);
		//设置总页数
		int totalPage = (int)Math.ceil(totalRecord/(qv.getPageSize()*1.0));
		qv.setTotalPage(totalPage);
		//设置偏移量
		int offset = (qv.getCurrentPage()-1)*qv.getPageSize();
		qv.setOffset(offset);
		List<Chat> comments = chatMapper.selectCommentsBySid(qv);
		qv.setList(comments);
		return qv;
	}
	
	@Override
	public void saveSystemMsg(User user,int uid) throws MyException {
		//建立关注信息
		Chat chat = new Chat();
		
		chat.setSort("s");
		chat.setSid(user.getUid());
		chat.setSname(user.getUsername());
		chat.setChattime(new Date());
		chat.setLid(uid);
		chat.setBelong(0);
		String content = user.getUsername()+"关注了你";
		chat.setContent(content);
		chatMapper.insertComment(chat);
	}
	
	@Override
	public QueryVo<Chat> findSystemMsgLid(String page,int uid) throws MyException {
		QueryVo<Chat> qv = new QueryVo<Chat>();
		//默认当前为第一页
		if(page == null || page == "") {
			page = "1";
		}
		int currentPage = Integer.parseInt(page);
		qv.setCurrentPage(currentPage);
		qv.setUid(uid);
		//查询总记录数
		int totalRecord;
		totalRecord = chatMapper.selectSystemCommentCount(uid); 
		qv.setTotalRecord(totalRecord);
		//设置每页15条
		qv.setPageSize(15);
		//设置总页数
		int totalPage = (int)Math.ceil(totalRecord/(qv.getPageSize()*1.0));
		qv.setTotalPage(totalPage);
		//设置偏移量
		int offset = (qv.getCurrentPage()-1)*qv.getPageSize();
		qv.setOffset(offset);
		List<Chat> comments = chatMapper.selectSystemByLid(qv);
		qv.setList(comments);
		return qv;
	}
	
	@Override
	public void saveReview(String sid, String sname, String content, String belong,String lid,String title) throws MyException {
		//建立评论关系
		Chat chat = new Chat();
		int Sid = Integer.parseInt(sid);
		chat.setSid(Sid);
		chat.setSname(sname);
		int Belong = Integer.parseInt(belong);
		chat.setBelong(Belong);
		int Lid = Integer.parseInt(lid);
		chat.setLid(Lid);
		chat.setLname(title);
		chat.setContent(content);
		chat.setChattime(new Date());
		chat.setSort("a");
		chatMapper.insertComment(chat);
	}
	
	@Override
	public QueryVo<Chat> findReviewByLid(int uid, String page) throws MyException {
		QueryVo<Chat> qv = new QueryVo<Chat>();
		//默认当前为第一页
		if(page == null || page == "") {
			page = "1";
		}
		int currentPage = Integer.parseInt(page);
		qv.setCurrentPage(currentPage);
		qv.setUid(uid);
		//查询总记录数
		int totalRecord;
		totalRecord = chatMapper.selectReviewCountByLid(qv.getUid()); 
		qv.setTotalRecord(totalRecord);
		//设置每页15条
		qv.setPageSize(15);
		//设置总页数
		int totalPage = (int)Math.ceil(totalRecord/(qv.getPageSize()*1.0));
		qv.setTotalPage(totalPage);
		//设置偏移量
		int offset = (qv.getCurrentPage()-1)*qv.getPageSize();
		qv.setOffset(offset);
		List<Chat> list = chatMapper.selectReviewByLid(qv);
		qv.setList(list);
		return qv;
	}
	
	@Override
	public QueryVo<Chat> findReviewBySid(int uid, String page) throws MyException {
		QueryVo<Chat> qv = new QueryVo<Chat>();
		//默认当前为第一页
		if(page == null || page == "") {
			page = "1";
		}
		int currentPage = Integer.parseInt(page);
		qv.setCurrentPage(currentPage);
		qv.setUid(uid);
		//查询总记录数
		int totalRecord;
		totalRecord = chatMapper.selectReviewCountBySid(qv.getUid()); 
		qv.setTotalRecord(totalRecord);
		//设置每页15条
		qv.setPageSize(15);
		//设置总页数
		int totalPage = (int)Math.ceil(totalRecord/(qv.getPageSize()*1.0));
		qv.setTotalPage(totalPage);
		//设置偏移量
		int offset = (qv.getCurrentPage()-1)*qv.getPageSize();
		qv.setOffset(offset);
		List<Chat> list = chatMapper.selectReviewBySid(qv);
		qv.setList(list);
		return qv;
	}
	
	@Override
	public List<Chat> findReviewByBelong(int aid) throws MyException {
		return chatMapper.selectReviewByBelong(aid);
	}
}
