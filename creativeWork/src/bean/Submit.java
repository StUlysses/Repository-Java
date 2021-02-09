package bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 投稿数据模型
 * @author CAOto
 *
 */
public class Submit implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 315537437513911771L;
	//专题ID
	private int tid;
	//专题名
	private String tname;
	//文章ID
	private int aid;
	//文章标题
	private String title;
	//投稿日期
	private Date submittime;
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
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public Date getSubmittime() {
		return submittime;
	}
	public void setSubmittime(Date submittime) {
		this.submittime = submittime;
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
		return "Submit [tid=" + tid + ", tname=" + tname + ", aid=" + aid + ", title=" + title + ", submittime="
				+ submittime + ", size=" + size + ", collectNum=" + collectNum + "]";
	}	
}
