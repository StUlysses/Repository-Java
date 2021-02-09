package bean;

import java.io.Serializable;

/**
 * 专题数据模型
 * @author CAOto
 *
 */
public class Theme implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2255349583545088406L;
	//专题ID
	private int tid;
	//专题名
	private String tname;
	//创建者ID
	private int uid;
	//创建者名字
	private String username;
	//专题简介
	private String info;
	//专题公告
	private String bulletin;
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
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getBulletin() {
		return bulletin;
	}
	public void setBulletin(String bulletin) {
		this.bulletin = bulletin;
	}
	@Override
	public String toString() {
		return "Theme [tid=" + tid + ", tname=" + tname + ", uid=" + uid + ", username=" + username + ", info=" + info
				+ ", bulletin=" + bulletin + "]";
	}
	
}
