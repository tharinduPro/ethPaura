/**
 * 
 */
package org.rusl.ethpaura.dao;

import java.util.List;

import org.rusl.ethpaura.entity.FileEntity;
import org.rusl.ethpaura.entity.MediaEntity;
import org.rusl.ethpaura.entity.PositionEntity;
import org.rusl.ethpaura.entity.PostsEntity;
import org.rusl.ethpaura.entity.QuestionEntity;
import org.rusl.ethpaura.entity.TimelineEntity;

/**
 * @author Rumesha
 * 
 */
public interface PostsDaoInterface {

	void addPosts(PostsEntity posts);

	void addQs(QuestionEntity question);

	void addTimeLine(TimelineEntity timeline);

	List<TimelineEntity> getRecords();

	void addImagePost(MediaEntity mediaEntity);

	void addFilePost(FileEntity fileEntity);

	public PostsEntity getPostById(int id);

	public List<PostsEntity> getPostByIdList(List<Integer> list);

	public List<TimelineEntity> search(String title);

}
