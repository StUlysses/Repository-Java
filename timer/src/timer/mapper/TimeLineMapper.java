package timer.mapper;

import java.util.List;

import timer.bean.TimeLine;
import timer.bean.Tlog;

public interface TimeLineMapper {
	/**
	 * 插入一条时间轴
	 * @param name
	 */
	void insertTimeLine(TimeLine tLine);
	/**
	 * 查找所有时间轴
	 * @return
	 */
	List<TimeLine> selectAllTimeLine();
	/**
	 * 通过ID查找时间轴
	 * @param id
	 * @return
	 */
	TimeLine SelectTimeLineById(String id);
	/**
	 * 插入错误日志
	 * @param tlog
	 */
	void InsertTLog(Tlog tlog);
}
