package timer.bean;

import java.sql.Date;
/**
 * ������ʵ��
 * @author ROBB
 *
 */
public class Attachment {
	/**
	 * ����
	 */
	private String guid;
	/**
	 * ����ʱ��
	 */
	private Date createTime;
	/**
	 * ���±�ID
	 */
	private String articleId;
	/**
	 * ͼƬ·��
	 */
	private String path;
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
