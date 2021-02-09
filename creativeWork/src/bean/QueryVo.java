package bean;

import java.util.List;
/**
 * 分页查询数据模型
 * @author CAOto
 *
 * @param <T>
 */
public class QueryVo <T>{
	//bean的集合
	private List<T> list;
	//总记录数
	private int totalRecord;
	//当前页数
	private int currentPage;
	//每页记录数
	private int pageSize = 10;
	//总页数
	private int totalPage;
	//偏移量
	private int offset;
	//用户UID
	private int uid;
	//模糊查询所用的关键字
	private String word;
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "QueryVo [list=" + list + ", totalRecord=" + totalRecord + ", currentPage=" + currentPage + ", pageSize="
				+ pageSize + ", totalPage=" + totalPage + ", offset=" + offset + ", uid=" + uid + "]";
	}
	
}
