package bean;

import java.io.Serializable;
import java.util.Date;
/**
 * 搜索数据模型
 * @author CAOto
 *
 */
public class Search implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7780124738880753066L;
	//用户ID
	private int uid;
	//关键字
	private String word;
	//搜索时间
	private Date wordtime;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public Date getWordtime() {
		return wordtime;
	}
	public void setWordtime(Date wordtime) {
		this.wordtime = wordtime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Search [uid=" + uid + ", word=" + word + ", wordtime=" + wordtime + "]";
	}
	
}
