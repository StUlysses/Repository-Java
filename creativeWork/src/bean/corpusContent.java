package bean;

import java.io.Serializable;
/**
 * 文集内容数据模型
 * @author CAOto
 *
 */
public class corpusContent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8L;
	//文集id
	private int coid;
	//文章id
	private int aid;
	//文章标题
	private String title;
	public int getCoid() {
		return coid;
	}
	public void setCoid(int coid) {
		this.coid = coid;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "corpusContent [coid=" + coid + ", aid=" + aid + ", title=" + title + "]";
	}
	
}
