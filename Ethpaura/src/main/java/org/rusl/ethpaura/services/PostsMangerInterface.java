/**
 * 
 */
package org.rusl.ethpaura.services;

import java.util.List;

import org.rusl.ethpaura.entity.FileEntity;
import org.rusl.ethpaura.entity.MediaEntity;
import org.rusl.ethpaura.entity.PostsEntity;
import org.rusl.ethpaura.entity.QuestionEntity;
import org.rusl.ethpaura.entity.TimelineEntity;

/**
 * @author Rumesha
 * 
 */
public interface PostsMangerInterface {

	void addPosts(PostsEntity posts);

	void addQs(QuestionEntity question);

	void addTimeLine(TimelineEntity timeline);

	public List<TimelineEntity> getRecords();

	void addImagePost(MediaEntity mediaEntity);

	void addFilePost(FileEntity fileEntity);

	public PostsEntity getPostById(int id);

	public List<PostsEntity> getPostById(List<Integer> list);

	public List<TimelineEntity> serach(String title);

}
