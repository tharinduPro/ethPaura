/**
 * 
 */
package org.rusl.ethpaura.services;

import java.util.List;

import org.rusl.ethpaura.dao.PostsDaoInterface;
import org.rusl.ethpaura.entity.FileEntity;
import org.rusl.ethpaura.entity.MediaEntity;
import org.rusl.ethpaura.entity.PostsEntity;
import org.rusl.ethpaura.entity.QuestionEntity;
import org.rusl.ethpaura.entity.TimelineEntity;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Rumesha
 * 
 */
public class PostsManager implements PostsMangerInterface {

	@Autowired
	private PostsDaoInterface postsDao;

	@Override
	public void addPosts(PostsEntity posts) {

		postsDao.addPosts(posts);

	}

	@Override
	public void addQs(QuestionEntity question) {
		postsDao.addQs(question);

	}

	@Override
	public void addTimeLine(TimelineEntity timeline) {
		postsDao.addTimeLine(timeline);

	}

	@Override
	public List<TimelineEntity> getRecords() {
		return postsDao.getRecords();

	}

	@Override
	public void addImagePost(MediaEntity mediaEntity) {
		postsDao.addImagePost(mediaEntity);

	}

	@Override
	public void addFilePost(FileEntity fileEntity) {
		postsDao.addFilePost(fileEntity);

	}

	@Override
	public List<PostsEntity> getPostById(List<Integer> list) {
		return postsDao.getPostByIdList(list);
	}

	@Override
	public PostsEntity getPostById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TimelineEntity> serach(String title) {
		// TODO Auto-generated method stub
		return postsDao.search(title);
	}
}
