package bean;

import java.io.Serializable;
import java.util.Date;
/**
 *用户最后登录时间数据模型
 * @author CAOto
 *
 */
public class UserActive implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	//用户ID
	private int uid;
	//用户登录时间
	private Date lastTime;
	//用户名
	private String username;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Date getLastTime() {
		return lastTime;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	@Override
	public String toString() {
		return "UserActive [uid=" + uid + ", lastTime=" + lastTime + ", username=" + username + "]";
	}
	
}
