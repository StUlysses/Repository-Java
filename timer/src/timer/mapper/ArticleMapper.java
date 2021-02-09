package timer.mapper;

import java.util.List;


import timer.bean.Article;
import timer.bean.ArticleEntity;
import timer.bean.Attachment;

public interface ArticleMapper {
	/**
	 * ����һƪ����
	 * @param arti
	 */
	void InsertArticle(Article arti);
	/**
	 * ͨ��ʱ����ID������������
	 * @param tid
	 * @return
	 */
	List<ArticleEntity> selectArticleList(String tid);
	/**
	 * ���븽��
	 * @param att
	 */
	void InsertAttachment(Attachment att);
	/**
	 * ��������ID��ѯ����
	 * @param aid
	 * @return
	 */
	List<Attachment> selectAttachmentByaid(String aid);
	/**
	 * ͨ������ID��ɾ������
	 * @param aid
	 */
	void deleteArticleById(String aid);
	/**
	 * ���ҵ�������
	 * @param aid
	 * @return
	 */
	Article selectSimpleArticleByAid(String aid);
}
