package bean;

import java.io.Serializable;
/**
 * 收藏数据模型
 * @author CAOto
 *
 */
public class Collect implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;
	private int uid;
	private int aid;
	private String title;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
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
	@Override
	public String toString() {
		return "Collect [uid=" + uid + ", aid=" + aid + ", title=" + title + "]";
	}	
	
}
