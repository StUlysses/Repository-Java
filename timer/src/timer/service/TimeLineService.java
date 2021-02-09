package timer.service;

import java.util.List;

import timer.bean.TimeLine;

/**
 * 时间轴接口
 * @author ROBB
 *
 */
public interface TimeLineService {
	/**
	 * 建立时间轴
	 * @param name
	 */
	TimeLine createTimeLine(String name);
	/**
	 * 查找所有时间轴
	 * @return
	 */
	List<TimeLine> FindTimeLineList();
	/**
	 * 通过ID获取时间轴
	 * @param id
	 * @return
	 */
	TimeLine FindTimeLine(String id);
	/**
	 * 保存错误日志
	 * @param title 标题
	 * @param message 异常消息
	 * @param stackTrack 异常位置
	 */
	void SaveErrorMsg(String title,String message,String stackTrack);
}
