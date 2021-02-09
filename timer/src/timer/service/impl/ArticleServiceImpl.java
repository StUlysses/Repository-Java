package timer.service.impl;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import timer.bean.Article;
import timer.bean.ArticleEntity;
import timer.bean.Attachment;
import timer.mapper.ArticleMapper;
import timer.service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleMapper _articleMapper; 
	@Override
	public void saveArticle(String title,String content,String path,String tid) {
		//保存文章，并将附件存入文章
		String artiId = UUID.randomUUID().toString();
		Article arti = new Article();
		arti.setGuid(artiId);
		arti.setTimeLineID(tid);
		arti.setTitle(title);
		arti.setContent(content);
		_articleMapper.InsertArticle(arti);
		//保存附件
		Attachment attachment = new Attachment();
		attachment.setGuid(UUID.randomUUID().toString());
		attachment.setPath(path);
		attachment.setArticleId(artiId);
		_articleMapper.InsertAttachment(attachment);
	}
	@Override
	public List<ArticleEntity> findArticleByTid(String tid) {
		List<ArticleEntity> list = _articleMapper.selectArticleList(tid);
		int year = 0,month = 0;//存储年月
		for (ArticleEntity articleEntity : list) {
			List<Attachment> attList = _articleMapper.selectAttachmentByaid(articleEntity.getGuid());
			articleEntity.setAttList(attList);
			//获取日历类单例
			Calendar calendar = Calendar.getInstance();
			//转化时间
			calendar.setTime(articleEntity.getCreateTime());
			//年月有变，则插入标记
			if(calendar.get(Calendar.YEAR) != year || calendar.get(Calendar.MONTH)+1 != month) {
				year = calendar.get(Calendar.YEAR);
				month = calendar.get(Calendar.MONTH)+1;
				articleEntity.setDateFlag(year+"and"+month);
			}else {
				articleEntity.setDateFlag("none");
			}
			articleEntity.setYear(calendar.get(Calendar.YEAR));
			articleEntity.setMonth(calendar.get(Calendar.MONTH)+1);//java计数从0开始，所以要+1
		}
		return list;
	}
	@Override
	public void removeArticleByID(String aid) {
		_articleMapper.deleteArticleById(aid);
	}
	@Override
	public Article findSimpleArticleByAid(String aid) {
		return _articleMapper.selectSimpleArticleByAid(aid);
	}
	
}
