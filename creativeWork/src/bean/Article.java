package bean;

import java.io.Serializable;
import java.util.Date;
/**
 * 文章数据模型
 * @author CAOto
 *
 */
public class Article implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//文章ID
	private int id;
	//文章标题
	private String title;
	//文章正文
	private String content;
	//文章作者id
	private int uid;
	//文章作者名
	private String username;
	//文章作者简介
	private String userinfo;
	//文章字数
	private int size;
	//文章获得收藏数
	private int collectNum;
	//更新时间
	private Date updatetime;
	//文章剩余投稿数，一共5次
	private int available;
	//文章评论id
	private int cid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(String userinfo) {
		this.userinfo = userinfo;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getCollectNum() {
		return collectNum;
	}
	public void setCollectNum(int collectNum) {
		this.collectNum = collectNum;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", content=" + content + ", uid=" + uid + ", username="
				+ username + ", userinfo=" + userinfo + ", size=" + size + ", collectNum=" + collectNum
				+ ", available=" + available + ", cid="
				+ cid + "]";
	}
	
	
}
