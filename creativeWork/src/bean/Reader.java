package bean;

import java.io.Serializable;
/**
 * 读者数据模型
 * @author CAOto
 *
 */
public class Reader implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	//用户id
	private int uid;
	//读者id
	private int rid;
	//读者名
	private String readername;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getReadername() {
		return readername;
	}
	public void setReadername(String readername) {
		this.readername = readername;
	}
	@Override
	public String toString() {
		return "Reader [uid=" + uid + ", rid=" + rid + ", readername=" + readername + "]";
	}
	
	
}
