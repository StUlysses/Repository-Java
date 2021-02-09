package mapper;

import java.util.List;

import bean.Search;

public interface commonMapper {
//*************************搜索历史表**************************
	/**
	 * 插入历史数据
	 * @param sh
	 */
	void insertSearch(Search sh);
	/**
	 * 取出搜索历史
	 * @return
	 */
	List<String> selectWordByWordtime(int uid);
	/**
	 * 根据uid删除搜索历史
	 * @param uid
	 */
	void deleteSearchByUid(int uid);
}
