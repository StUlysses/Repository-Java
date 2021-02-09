package timer.service;

import java.util.List;

import timer.bean.TimeLine;

/**
 * ʱ����ӿ�
 * @author ROBB
 *
 */
public interface TimeLineService {
	/**
	 * ����ʱ����
	 * @param name
	 */
	TimeLine createTimeLine(String name);
	/**
	 * ��������ʱ����
	 * @return
	 */
	List<TimeLine> FindTimeLineList();
	/**
	 * ͨ��ID��ȡʱ����
	 * @param id
	 * @return
	 */
	TimeLine FindTimeLine(String id);
	/**
	 * ���������־
	 * @param title ����
	 * @param message �쳣��Ϣ
	 * @param stackTrack �쳣λ��
	 */
	void SaveErrorMsg(String title,String message,String stackTrack);
}
