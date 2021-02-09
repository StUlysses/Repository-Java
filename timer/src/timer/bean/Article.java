package timer.bean;

import java.sql.Date;
/**
 * 文章表实体
 * @author ROBB
 *
 */
public class Article {
	/**
	 * 主键
	 */
	private String guid;
	/**
	 * 时间轴表主键
	 */
	private String timeLineID;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 删除标记
	 */
	private boolean deleteFlag;
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getTimeLineID() {
		return timeLineID;
	}
	public void setTimeLineID(String timeLineID) {
		this.timeLineID = timeLineID;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	@Override
	public String toString() {
		return "Article [guid=" + guid + ", timeLineID=" + timeLineID + ", createTime=" + createTime + ", title="
				+ title + ", content=" + content + ", deleteFlag=" + deleteFlag + "]";
	}
	
}
