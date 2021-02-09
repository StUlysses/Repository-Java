package timer.mapper;

import java.util.List;

import timer.bean.TimeLine;
import timer.bean.Tlog;

public interface TimeLineMapper {
	/**
	 * ����һ��ʱ����
	 * @param name
	 */
	void insertTimeLine(TimeLine tLine);
	/**
	 * ��������ʱ����
	 * @return
	 */
	List<TimeLine> selectAllTimeLine();
	/**
	 * ͨ��ID����ʱ����
	 * @param id
	 * @return
	 */
	TimeLine SelectTimeLineById(String id);
	/**
	 * ���������־
	 * @param tlog
	 */
	void InsertTLog(Tlog tlog);
}
