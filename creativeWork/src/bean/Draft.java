package bean;

import java.io.Serializable;
/**
 * 草稿数据模型
 * @author CAOto
 *
 */
public class Draft implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;
	//文章ID
	private int id;
	//文章标题
	private String title;
	//文章正文
	private String content;
	//文章作者id
	private int uid;
	//作者名
	private String username;
	//文章字数
	private int size;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Draft [id=" + id + ", title=" + title + ", content=" + content + ", uid=" + uid + ", username="
				+ username + ", size=" + size + "]";
	}
	
	
}
