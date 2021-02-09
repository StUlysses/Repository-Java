package timer.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import timer.bean.TimeLine;
import timer.bean.Tlog;
import timer.mapper.TimeLineMapper;
import timer.service.TimeLineService;
@Service
public class TimeLineServiceImpl implements TimeLineService {
	@Autowired
	private TimeLineMapper _timeLineMapper;
	@Override
	public TimeLine createTimeLine(String name) {
		TimeLine tLine = new TimeLine();
		//手动生成主键，稍后返回
		UUID uuid = UUID.randomUUID();
		tLine.setGuid(uuid.toString());
		tLine.setName(name);
		_timeLineMapper.insertTimeLine(tLine);
		return tLine;
	}
	@Override
	public List<TimeLine> FindTimeLineList() {
		List<TimeLine> list = _timeLineMapper.selectAllTimeLine();
		return list;
	}
	@Override
	public TimeLine FindTimeLine(String id) {
		TimeLine tLine = _timeLineMapper.SelectTimeLineById(id);
		return tLine;
	}
	@Override
	public void SaveErrorMsg(String title, String message,String stackTrack) {
		Tlog tlog = new Tlog();
		tlog.setMessage(message);
		tlog.setTitle(title);
		tlog.setStackTrack(stackTrack);
		_timeLineMapper.InsertTLog(tlog);
	}

}
