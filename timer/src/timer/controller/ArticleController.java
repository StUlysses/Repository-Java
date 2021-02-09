package timer.controller;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import timer.bean.Article;
import timer.bean.TimeLine;
import timer.service.ArticleService;
import timer.service.TimeLineService;
/**
 * ������ؿ�����
 * @author ROBB
 *
 */
@Controller
public class ArticleController {
	@Autowired
	private ArticleService _articleService;
	@Autowired
	private TimeLineService _timeLineService;
	/**
	 * ��������
	 * @param session
	 * @param arti
	 * @return
	 */
	@RequestMapping("article/create")
	public String createArticle(HttpSession session,MultipartFile uploadImg,String describe,String content) {
		TimeLine tLine = (TimeLine)session.getAttribute("tLine");
		try {
			//����ͼƬ
			String oldName = uploadImg.getOriginalFilename();//��ȡ�ļ���
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			String nameString = "";
			String path = "";
			if(oldName != null && oldName != "") {
				String subfix = oldName.substring(oldName.lastIndexOf('.'));//�õ���׺��
				nameString = UUID.randomUUID().toString()+subfix;
				path = "/"+calendar.get(Calendar.YEAR)+"/"+(calendar.get(Calendar.MONDAY)+1);
				File file = new File("C://upload/"+path);
				if(!file.exists() && !file.isDirectory()){//����ļ��в�����
					file.mkdirs();//�����ļ���mkdirs:һ�ζ༶��mkdirһ��һ��
				}
				File imgFile = new File("C://upload/"+path+"/"+nameString);
				uploadImg.transferTo(imgFile);
			}
			_articleService.saveArticle(describe, content.replace("\r\n", "###&&&"),path+"/"+nameString, tLine.getGuid());
		}
		catch (Exception e) {
			org.apache.log4j.spi.LocationInfo ex = new org.apache.log4j.spi.LocationInfo(e.fillInStackTrace(),TimeLineController.class.getName());
			String stack = "className:"+ex.getClassName()+"LineNumber"+ex.getLineNumber()+"MethodName"+ex.getMethodName();
			_timeLineService.SaveErrorMsg("��������", e.getMessage(),stack);
		}
		return "redirect:../timeline/index.action?tid="+tLine.getGuid();
	}
	/**
	 * ɾ������
	 * @param session
	 * @param aid
	 * @return
	 */
	@RequestMapping("article/delete")
	public String deleteArticle(HttpSession session,String aid) {
		TimeLine tLine = (TimeLine)session.getAttribute("tLine");
		try {
			_articleService.removeArticleByID(aid);
		}catch (Exception e) {
			org.apache.log4j.spi.LocationInfo ex = new org.apache.log4j.spi.LocationInfo(e.fillInStackTrace(),TimeLineController.class.getName());
			String stack = "className:"+ex.getClassName()+"LineNumber"+ex.getLineNumber()+"MethodName"+ex.getMethodName();
			_timeLineService.SaveErrorMsg("ɾ������", e.getMessage(),stack);
		}
		return "redirect:../timeline/index.action?tid="+tLine.getGuid();
	}
	/**
	 * ת����������ҳ��
	 * @param session
	 * @param aid
	 * @return
	 */
	@RequestMapping("article/info")
	public String articleInfo(HttpSession session,String aid) {
		try {
			Article article = _articleService.findSimpleArticleByAid(aid);
			session.setAttribute("arti", article);
			String string = "";
			string.replace("\r\n", "#@#");
		}
		catch (Exception e) {
			org.apache.log4j.spi.LocationInfo ex = new org.apache.log4j.spi.LocationInfo(e.fillInStackTrace(),TimeLineController.class.getName());
			String stack = "className:"+ex.getClassName()+"LineNumber"+ex.getLineNumber()+"MethodName"+ex.getMethodName();
			_timeLineService.SaveErrorMsg("ת����������ҳ��", e.getMessage(),stack);
		}
		return "forward:/WEB-INF/jsp/articleInfo.jsp";
	}
}
