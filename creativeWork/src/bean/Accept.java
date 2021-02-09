package bean;

import java.io.Serializable;
import java.util.Date;

public class Accept implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -762867093672786379L;
	//专题ID
	private int tid;
	//专题名
	private String tname;
	//文章ID
	private int aid;
	//文章标题
	private String title;
	//收录日期
	private Date accepttime;
	//文章字数
	private int size;
	//文章收藏数
	private int collectNum;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getAccepttime() {
		return accepttime;
	}
	public void setAccepttime(Date accepttime) {
		this.accepttime = accepttime;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Accept [tid=" + tid + ", tname=" + tname + ", aid=" + aid + ", title=" + title + ", accepttime="
				+ accepttime + ", size=" + size + ", collectNum=" + collectNum + "]";
	}
	
}
