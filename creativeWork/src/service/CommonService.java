package service;

import java.util.List;

import myException.MyException;

public interface CommonService {
	/**
	 * 增加搜索历史
	 * @param uid 用户ID
	 * @param word 关键字
	 * @throws MyException
	 */
	public void addSearchHistory(int uid,String word)throws MyException;
	/**
	 * 取得搜索历史
	 * @param uid 用户ID
	 * @return 搜索历史集合
	 * @throws MyException
	 */
	public List<String> getSearchHistory(int uid)throws MyException;
	/**
	 * 清除收缩历史
	 * @param uid 用户ID
	 */
	public void clearHistory(int uid)throws MyException;
}
