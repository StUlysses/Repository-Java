package timer.bean;

import java.sql.Date;
/**
 * 附件表实体
 * @author ROBB
 *
 */
public class Attachment {
	/**
	 * 主键
	 */
	private String guid;
	/**
	 * 建立时间
	 */
	private Date createTime;
	/**
	 * 文章表ID
	 */
	private String articleId;
	/**
	 * 图片路径
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
