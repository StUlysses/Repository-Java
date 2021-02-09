package timer.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import timer.bean.ArticleEntity;
import timer.bean.TimeLine;
import timer.service.ArticleService;
import timer.service.TimeLineService;
/**
 * ʱ������ؿ�����
 * @author ROBB
 *
 */
@Controller
public class TimeLineController {
	@Autowired
	private TimeLineService _timelimeService;
	@Autowired
	private ArticleService _articleService;
	/**
	 * ��ҳ
	 * @param session
	 * @return
	 */
	@RequestMapping("index")
	public String index(HttpSession session) {
		try {
			List<TimeLine> list = _timelimeService.FindTimeLineList();
			int total = list.size();
			session.setAttribute("total", total);
			session.setAttribute("list", list);
		}
		catch (Exception e) {
			org.apache.log4j.spi.LocationInfo ex = new org.apache.log4j.spi.LocationInfo(e.fillInStackTrace(),TimeLineController.class.getName());
			String stack = "className:"+ex.getClassName()+"LineNumber"+ex.getLineNumber()+"MethodName"+ex.getMethodName();
			_timelimeService.SaveErrorMsg("��ҳ", e.getMessage(),stack);
		}
		return "forward:/WEB-INF/jsp/index.jsp";
	}
	/**
	 * ����ʱ����
	 * @param session
	 * @param name ʱ�������� 
	 * @return
	 */
	@RequestMapping("timeline/create")
	public String CreateTimmeLine(HttpSession session,String name) {
		try {
			TimeLine tLine = _timelimeService.createTimeLine(name);
			session.setAttribute("tLine", tLine);
		}
		catch (Exception e) {org.apache.log4j.spi.LocationInfo ex = new org.apache.log4j.spi.LocationInfo(e.fillInStackTrace(),TimeLineController.class.getName());
		String stack = "className:"+ex.getClassName()+"LineNumber"+ex.getLineNumber()+"MethodName"+ex.getMethodName();
			_timelimeService.SaveErrorMsg("����ʱ����", e.getMessage(),stack);
		}
		return "forward:/WEB-INF/jsp/timeline.jsp";
	}
	/**
	 * ����ʱ����
	 * @param session
	 * @param tid ʱ��������
	 * @return
	 */
	@RequestMapping("timeline/index")
	public String IntoTimeLine(HttpSession session,String tid) {
		try {
			TimeLine tLine = _timelimeService.FindTimeLine(tid);
			session.setAttribute("tLine", tLine);
			List<ArticleEntity> list = _articleService.findArticleByTid(tLine.getGuid());
			session.setAttribute("artiList", list);
		}
		catch (Exception e) {
			org.apache.log4j.spi.LocationInfo ex = new org.apache.log4j.spi.LocationInfo(e.fillInStackTrace(),TimeLineController.class.getName());
			String stack = "className:"+ex.getClassName()+"LineNumber"+ex.getLineNumber()+"MethodName"+ex.getMethodName();
			_timelimeService.SaveErrorMsg("����ʱ����", e.getMessage(),stack);
		}
		return "forward:/WEB-INF/jsp/timeline.jsp";
	}
}
