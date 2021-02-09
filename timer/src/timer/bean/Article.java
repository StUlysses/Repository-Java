package timer.bean;

import java.sql.Date;
/**
 * ���±�ʵ��
 * @author ROBB
 *
 */
public class Article {
	/**
	 * ����
	 */
	private String guid;
	/**
	 * ʱ���������
	 */
	private String timeLineID;
	/**
	 * ����ʱ��
	 */
	private Date createTime;
	/**
	 * ����
	 */
	private String title;
	/**
	 * ����
	 */
	private String content;
	/**
	 * ɾ�����
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
