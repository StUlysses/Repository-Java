package timer.bean;

import java.util.Date;
/**
 * �쳣ʵ��
 * @author ROBB
 *
 */
public class Tlog {
	/**
	 * ����
	 */
	private String guid;
	/**
	 * ����
	 */
	private String title;
	/**
	 * �쳣��Ϣ
	 */
	private String message;
	/**
	 * �쳣λ��
	 */
	private String stackTrack;
	/**
	 * �쳣ʱ��
	 */
	private Date createTime;
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getStackTrack() {
		return stackTrack;
	}
	public void setStackTrack(String stackTrack) {
		this.stackTrack = stackTrack;
	}
	
}
