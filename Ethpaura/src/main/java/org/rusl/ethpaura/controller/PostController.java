/**
 * 
 */
package org.rusl.ethpaura.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.rusl.ethpaura.entity.FileEntity;
import org.rusl.ethpaura.entity.MediaEntity;
import org.rusl.ethpaura.entity.PostsEntity;
import org.rusl.ethpaura.entity.QuestionEntity;
import org.rusl.ethpaura.entity.TimelineEntity;
import org.rusl.ethpaura.entity.UserEntity;
import org.rusl.ethpaura.model.MediaModel;
import org.rusl.ethpaura.services.PostsMangerInterface;
import org.rusl.ethpaura.services.UserManagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Tharindu
 * 
 */

@Controller
public class PostController {

	@Autowired
	private UserManagerInterface userManager;

	@Autowired
	private PostsMangerInterface postsManager;

	// Post Function
	@RequestMapping(value = "/posts", method = RequestMethod.POST)
	public String AddPost(@ModelAttribute(value = "posts") PostsEntity posts,
			BindingResult result) {

		// Spring Auth

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName(); // get logged in username

		// Spring Auth

		UserEntity prof = userManager.getUserByUsername(name);

		posts.setPoUserId(prof.getUserId());

		postsManager.addPosts(posts);

		TimelineEntity timeline = new TimelineEntity();

		timeline.setPostId(posts.getPostId());
		timeline.setType("post");
		timeline.setMediaType("");
		timeline.setDescription(posts.getDescription());
		timeline.setTitle(posts.getTitle());
		timeline.setFilePath("");
		timeline.setuId(prof.getUserId());
		timeline.setUserProfImage(prof.getPhoto());
		timeline.setUsername(prof.getFname() + " " + prof.getLname());

		postsManager.addTimeLine(timeline);

		return "redirect:/header";
	}

	@RequestMapping(value = "/upload_m", method = RequestMethod.POST)
	public String AddPost(@ModelAttribute(value = "med") MediaModel med,
			BindingResult result) throws IOException {

		// Spring Auth

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName();
		UserEntity prof = userManager.getUserByUsername(name);// get logged in
																// username

		// Spring Auth

		if (med.getMultipartFile() != null) {

			UserEntity userEntity = userManager.getUserByUsername(name);

			MediaEntity mediaEntity = new MediaEntity();
			mediaEntity.setTitle(med.getTitle());
			mediaEntity.setDescription("");
			mediaEntity.setFile_path(med.getMultipartFile()
					.getOriginalFilename());
			mediaEntity.setMedia_type("image");
			mediaEntity.setFile_path(med.getMultipartFile()
					.getOriginalFilename());
			mediaEntity.setM_user_id(userEntity.getUserId());
			postsManager.addImagePost(mediaEntity);

			MultipartFile multipartFile = med.getMultipartFile();

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			FileOutputStream output = null;
			File outputfile = null;
			String fileName = multipartFile.getOriginalFilename();

			String extensionOfFileName = fileName.substring(
					fileName.indexOf(".") + 1, fileName.length());
			outputfile = new File("C:\\Image\\" + fileName);
			InputStream inputStream = multipartFile.getInputStream();

			if (null != extensionOfFileName
					&& extensionOfFileName.equalsIgnoreCase("pdf")) {
				if (!outputfile.isDirectory()) {
					try {
						output = new FileOutputStream(outputfile);
						IOUtils.copy(inputStream, output);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						baos.close();
						output.close();

					}
				}

			} else if (null != extensionOfFileName
					&& extensionOfFileName.equalsIgnoreCase("png")) {
				BufferedImage imBuff = ImageIO.read(multipartFile
						.getInputStream());
				ImageIO.write(imBuff, extensionOfFileName, outputfile);
			} else if (null != extensionOfFileName
					&& extensionOfFileName.equalsIgnoreCase("jpg")) {
				BufferedImage imBuff = ImageIO.read(multipartFile
						.getInputStream());
				ImageIO.write(imBuff, extensionOfFileName, outputfile);
			} else {
				System.out.println("Unknown file extension"
						+ extensionOfFileName);
			}

			TimelineEntity timeline = new TimelineEntity();

			timeline.setPostId(mediaEntity.getMedia_id());
			timeline.setType("image");
			timeline.setMediaType("image");
			timeline.setDescription("");
			timeline.setTitle(mediaEntity.getTitle());
			timeline.setFilePath(mediaEntity.getFile_path());
			timeline.setuId(mediaEntity.getM_user_id());
			timeline.setUserProfImage(prof.getPhoto());
			timeline.setUsername(prof.getUsername());
			postsManager.addTimeLine(timeline);

		}

		return "redirect:/header";
	}

	// Ask Function
	@RequestMapping(value = "/ask", method = RequestMethod.POST)
	public String AddQs(
			@ModelAttribute(value = "question") QuestionEntity question,
			BindingResult result, ModelMap map) {

		// Spring Auth

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName(); // get logged in username

		// Spring Auth

		UserEntity prof = userManager.getUserByUsername(name);

		question.setQUsweId(prof.getUserId());

		postsManager.addQs(question);

		TimelineEntity timeline = new TimelineEntity();

		timeline.setPostId(question.getQuestionId());
		timeline.setType("questions");
		timeline.setDescription("");
		timeline.setTitle(question.getQuestion());
		timeline.setFilePath("");
		timeline.setuId(prof.getUserId());
		timeline.setUserProfImage(prof.getPhoto());
		timeline.setUsername(prof.getUsername());
		postsManager.addTimeLine(timeline);

		return "redirect:/header";
	}

	// Ask Function
	@RequestMapping(value = "/uploaddoc", method = RequestMethod.POST)
	public String AddDocument(@ModelAttribute(value = "doc") MediaModel med,
			BindingResult result, ModelMap map) throws IOException {

		// Spring Auth

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName();
		UserEntity prof = userManager.getUserByUsername(name);// get logged in
																// username

		// Spring Auth

		if (med.getMultipartFile() != null) {

			UserEntity userEntity = userManager.getUserByUsername(name);

			FileEntity fileEntity = new FileEntity();

			fileEntity.setTitle(med.getTitle());
			fileEntity.setDescription("");
			fileEntity.setFile_path(med.getMultipartFile()
					.getOriginalFilename());
			fileEntity.setFile_type("pdf");
			fileEntity.setFile_path(med.getMultipartFile()
					.getOriginalFilename());
			fileEntity.setF_user_id(userEntity.getUserId());

			postsManager.addFilePost(fileEntity);

			MultipartFile multipartFile = med.getMultipartFile();

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			FileOutputStream output = null;
			File outputfile = null;
			String fileName = multipartFile.getOriginalFilename();

			String extensionOfFileName = fileName.substring(
					fileName.indexOf(".") + 1, fileName.length());
			outputfile = new File("C:\\Image\\" + fileName);
			InputStream inputStream = multipartFile.getInputStream();

			if (null != extensionOfFileName
					&& extensionOfFileName.equalsIgnoreCase("pdf")) {
				if (!outputfile.isDirectory()) {
					try {
						output = new FileOutputStream(outputfile);
						IOUtils.copy(inputStream, output);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						baos.close();
						output.close();

					}
				}

			} else if (null != extensionOfFileName
					&& extensionOfFileName.equalsIgnoreCase("png")) {
				BufferedImage imBuff = ImageIO.read(multipartFile
						.getInputStream());
				ImageIO.write(imBuff, extensionOfFileName, outputfile);
			} else if (null != extensionOfFileName
					&& extensionOfFileName.equalsIgnoreCase("jpg")) {
				BufferedImage imBuff = ImageIO.read(multipartFile
						.getInputStream());
				ImageIO.write(imBuff, extensionOfFileName, outputfile);
			} else {
				System.out.println("Unknown file extension"
						+ extensionOfFileName);
			}

			TimelineEntity timeline = new TimelineEntity();

			timeline.setPostId(fileEntity.getFile_id());
			timeline.setType("pdf");
			timeline.setMediaType("pdf");
			timeline.setDescription("");
			timeline.setTitle(fileEntity.getTitle());
			timeline.setFilePath(fileEntity.getFile_path());
			timeline.setuId(fileEntity.getF_user_id());
			timeline.setUsername(prof.getUsername());
			timeline.setUserProfImage(prof.getPhoto());
			postsManager.addTimeLine(timeline);

		}

		return "redirect:/header";
	}
}
