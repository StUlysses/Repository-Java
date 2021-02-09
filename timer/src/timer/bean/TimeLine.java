package timer.bean;

import java.sql.Date;
/**
 * ʱ����ʵ��
 * @author ROBB
 *
 */
public class TimeLine{
	/**
	 * ����
	 */
	private String guid;
	/**
	 * ʱ��������
	 */
	private String name;
	/**
	 * ����ʱ��
	 */
	private Date createTime;
	/**
	 * ����ʱ��
	 */
	private Date updateTimeDate;
	/**
	 * ɾ����־
	 */
	private boolean deleteFlag;
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTimeDate() {
		return updateTimeDate;
	}
	public void setUpdateTimeDate(Date updateTimeDate) {
		this.updateTimeDate = updateTimeDate;
	}
	public boolean isDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	@Override
	public String toString() {
		return "TimeLine [guid=" + guid + ", name=" + name + ", createTime=" + createTime + ", updateTimeDate="
				+ updateTimeDate + ", deleteFlag=" + deleteFlag + "]";
	}
	
}
