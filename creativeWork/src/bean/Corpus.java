package bean;

import java.io.Serializable;
/**
 * 文集数据模型
 * @author CAOto
 *
 */
public class Corpus implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7L;
	//文集id
	private int coid;
	//文集名
	private String coname;
	//创建者ID
	private int uid;
	//创建者名字
	private String username;
	public int getCoid() {
		return coid;
	}
	public void setCoid(int coid) {
		this.coid = coid;
	}
	public String getConame() {
		return coname;
	}
	public void setConame(String coname) {
		this.coname = coname;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Corpus [coid=" + coid + ", coname=" + coname + ", uid=" + uid + ", username=" + username
				+ "]";
	}
}
