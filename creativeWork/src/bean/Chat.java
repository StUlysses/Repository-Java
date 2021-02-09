package bean;

import java.io.Serializable;
import java.util.Date;
/**
 * 会话数据模型
 * @author CAOto
 *
 */
public class Chat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8717835460369988537L;
	//对话ID
	private int chid;
	//所属类别:留言:u,评论:a,系统消息:s
	private String sort;
	//用户ID
	private int sid;
	//用户名
	private String sname;
	//听者ID
	private int lid;
	//听者名
	private String lname;
	//会话内容
	private String content;
	//属于回复那个对话，不是为0
	private int belong;
	//会话日期
	private Date chattime;
	
	public int getChid() {
		return chid;
	}
	public void setChid(int chid) {
		this.chid = chid;
	}
	
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getBelong() {
		return belong;
	}
	public void setBelong(int belong) {
		this.belong = belong;
	}
	public Date getChattime() {
		return chattime;
	}
	public void setChattime(Date chattime) {
		this.chattime = chattime;
	}
	@Override
	public String toString() {
		return "Chat [chid=" + chid + ", sort=" + sort + ", sid=" + sid + ", sname=" + sname + ", lid=" + lid
				+ ", lname=" + lname + ", content=" + content + ", belong=" + belong + ", chattime=" + chattime + "]";
	}
	
}
