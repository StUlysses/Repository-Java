package timer.bean;
/**
 * ������ͼƬʵ��
 * @author ROBB
 *
 */

import java.sql.Date;
import java.util.List;

public class ArticleEntity {
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
	/**
	 * ��������
	 */
	private List<Attachment> attList;
	/**
	 * ���
	 */
	private int year;
	/**
	 * �·�
	 */
	private int month;
	/**
	 * �·����ױ�־
	 */
	private String dateFlag;
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
	public List<Attachment> getAttList() {
		return attList;
	}
	public void setAttList(List<Attachment> attList) {
		this.attList = attList;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public String getDateFlag() {
		return dateFlag;
	}
	public void setDateFlag(String dateFlag) {
		this.dateFlag = dateFlag;
	}
	
	
}
