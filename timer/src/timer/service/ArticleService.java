package timer.service;

import java.util.List;

import timer.bean.Article;
import timer.bean.ArticleEntity;
/**
 * ���½ӿ�
 * @author ROBB
 *
 */
public interface ArticleService {
	/**
	 * ��������
	 * @param title ���±���
	 * @param path ͼƬ·��
	 * @param tid ʱ����id
	 */
	void saveArticle(String title,String content,String path,String tid);
	/**
	 * ͨ��ʱ����ID�������ºϼ�
	 * @param tid
	 * @return
	 */
	List<ArticleEntity> findArticleByTid(String tid);
	/**
	 * ͨ������ID�Ƴ�����
	 * @param aid
	 */
	void removeArticleByID(String aid);
	/**
	 * ���ҵ�������
	 * @param aid
	 * @return
	 */
	Article findSimpleArticleByAid(String aid);
}
