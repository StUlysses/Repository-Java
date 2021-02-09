package bean;

import java.io.Serializable;
/**
 * 订阅表数据模型
 * @author CAOto
 *
 */
public class Follow implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3666493730686583224L;
	//专题ID
	private int tid;
	//专题名
	private String tname;
	//用户ID
	private int uid;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Follow [tid=" + tid + ", tname=" + tname + ", uid=" + uid + "]";
	}
	
}
