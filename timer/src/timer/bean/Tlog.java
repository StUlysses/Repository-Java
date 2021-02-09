package timer.bean;

import java.util.Date;
/**
 * 异常实体
 * @author ROBB
 *
 */
public class Tlog {
	/**
	 * 主键
	 */
	private String guid;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 异常消息
	 */
	private String message;
	/**
	 * 异常位置
	 */
	private String stackTrack;
	/**
	 * 异常时间
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
