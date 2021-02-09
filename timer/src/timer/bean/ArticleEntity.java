package timer.bean;
/**
 * 文章与图片实体
 * @author ROBB
 *
 */

import java.sql.Date;
import java.util.List;

public class ArticleEntity {
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
	/**
	 * 附件集合
	 */
	private List<Attachment> attList;
	/**
	 * 年份
	 */
	private int year;
	/**
	 * 月份
	 */
	private int month;
	/**
	 * 月份起首标志
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
