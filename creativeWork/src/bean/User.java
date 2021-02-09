package bean;

import java.io.Serializable;
/**
 * 用户数据模型
 * @author CAOto
 *
 */
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	//用户编号
	private int uid;
	//用户名
	private String username;
	//密码
	private String password;
	//头像
	private String photo;
	//性别
	private String sex;
	//简介
	private String info;
	//获得收藏数
	private int collectNum;
	//获得读者数
	private int readerNum;
	//关注作者数
	private int followNum;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getCollectNum() {
		return collectNum;
	}
	public void setCollectNum(int collectNum) {
		this.collectNum = collectNum;
	}
	public int getReaderNum() {
		return readerNum;
	}
	public void setReaderNum(int readerNum) {
		this.readerNum = readerNum;
	}
	
	public int getFollowNum() {
		return followNum;
	}
	public void setFollowNum(int followNum) {
		this.followNum = followNum;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", photo=" + photo + ", sex="
				+ sex + ", info=" + info + ", collectNum=" + collectNum + ", readerNum=" + readerNum + ", followNum="
				+ followNum + "]";
	}
	
}
