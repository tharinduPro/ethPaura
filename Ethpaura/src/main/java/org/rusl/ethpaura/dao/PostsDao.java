/**
 * 
 */
package org.rusl.ethpaura.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.rusl.ethpaura.entity.FileEntity;
import org.rusl.ethpaura.entity.MediaEntity;
import org.rusl.ethpaura.entity.PositionEntity;
import org.rusl.ethpaura.entity.PostsEntity;
import org.rusl.ethpaura.entity.QuestionEntity;
import org.rusl.ethpaura.entity.TimelineEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Rumesha
 * 
 */
public class PostsDao implements PostsDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public void addPosts(PostsEntity posts) {

		this.sessionFactory.getCurrentSession().save(posts);

	}

	@Transactional
	@Override
	public void addQs(QuestionEntity question) {
		this.sessionFactory.getCurrentSession().save(question);

	}

	@Transactional
	@Override
	public void addTimeLine(TimelineEntity timeline) {

		this.sessionFactory.getCurrentSession().save(timeline);

	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<TimelineEntity> getRecords() {
		return this.sessionFactory
				.getCurrentSession()
				.createQuery(
						"from TimelineEntity ORDER BY timelineId DESC LIMIT 10")
				.list();
	}

	@Transactional
	@Override
	public void addImagePost(MediaEntity mediaEntity) {
		this.sessionFactory.getCurrentSession().save(mediaEntity);

	}

	@Transactional
	@Override
	public void addFilePost(FileEntity fileEntity) {
		this.sessionFactory.getCurrentSession().save(fileEntity);

	}

	@Transactional
	@Override
	public PostsEntity getPostById(int id) {

		PostsEntity postsEntity = (PostsEntity) sessionFactory
				.getCurrentSession().createCriteria(PostsEntity.class)
				.add(Restrictions.eq("postId", id)).uniqueResult();

		return postsEntity;
	}

	@Transactional
	@Override
	@SuppressWarnings("unchecked")
	public List<PostsEntity> getPostByIdList(List<Integer> list) {

		return this.sessionFactory.getCurrentSession()
				.createQuery("from PostsEntity where postId = :id")
				.setParameterList("id", list).list();

	}

	@Transactional
	@Override
	@SuppressWarnings("unchecked")
	public List<TimelineEntity> search(String title) {

		return this.sessionFactory.getCurrentSession()
				.createQuery("from TimelineEntity where title like :id or description like :id")
				.setParameter("id", title).list();

	}

}
