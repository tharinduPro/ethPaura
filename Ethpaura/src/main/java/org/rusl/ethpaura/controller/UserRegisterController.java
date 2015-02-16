/**
 * 
 */
package org.rusl.ethpaura.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.rusl.ethpaura.entity.AdminEntity;
import org.rusl.ethpaura.entity.AttackEntity;
import org.rusl.ethpaura.entity.Password;
import org.rusl.ethpaura.entity.PostsEntity;
import org.rusl.ethpaura.entity.QuestionEntity;
import org.rusl.ethpaura.entity.TimelineEntity;
import org.rusl.ethpaura.entity.UserEntity;
import org.rusl.ethpaura.model.MediaModel;
import org.rusl.ethpaura.model.RecentAttack;
import org.rusl.ethpaura.model.UserModel;
import org.rusl.ethpaura.services.ElephantManagerInterface;
import org.rusl.ethpaura.services.PostsMangerInterface;
import org.rusl.ethpaura.services.UserManager;
import org.rusl.ethpaura.services.UserManagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Rumesha
 * 
 */
@Controller
public class UserRegisterController {

	@Autowired
	private UserManagerInterface userManager;
	@Autowired
	private PostsMangerInterface postManager;
	@Autowired
	private ElephantManagerInterface elephantManager;

	// Return logging page
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String tt(ModelMap map) {

		map.addAttribute("user", new UserModel());
		map.addAttribute("admin", new AdminEntity());
		map.addAttribute("adminList", userManager.getAllAdmins());

		return "welcome";

	}

	// return loggedin view
	@RequestMapping(value = "/header", method = RequestMethod.GET)
	public String loginSuccessPage(ModelMap map) {

		// Spring Auth
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName(); // get logged in username
		String password = auth.getCredentials().toString();
		// Spring Auth

		map.addAttribute("posts", new PostsEntity());
		map.addAttribute("timeline", new TimelineEntity());
		map.addAttribute("recentAttacks", elephantManager.getRecentAttacks());
		map.addAttribute("question", new QuestionEntity());
		map.addAttribute("myprof", userManager.getUserByUsername(name));
		map.addAttribute("records", postManager.getRecords());
		map.addAttribute("med", new MediaModel());
		map.addAttribute("doc", new MediaModel());
		map.addAttribute("question", new QuestionEntity());

		RecentAttack arrayEleps[] = new RecentAttack[3];

		List<AttackEntity> recentAtt = elephantManager.getRecentAttacks();

		for (int i = 0; i < recentAtt.size(); i++) {
			RecentAttack recentAttack = new RecentAttack();

			try {

				recentAttack.setName(elephantManager.getElephantById(
						recentAtt.get(i).getAtElephantId()).getName());

			} catch (NullPointerException e) {
				recentAttack.setName("Unknown");
			}

			try {

				recentAttack.setImage(elephantManager.getElephantById(
						recentAtt.get(i).getAtElephantId()).getPhoto());

			} catch (NullPointerException e) {
				recentAttack.setImage("lolo.png");
			}

			recentAttack.setDescription(elephantManager.getVillageById(
					recentAtt.get(i).getAtVillageId()).getName());
			recentAttack.setDate(recentAtt.get(i).getDate());
			recentAttack.setTime(recentAtt.get(i).getTime());
			arrayEleps[i] = recentAttack;
		}
		map.addAttribute("attackEleps", arrayEleps);

		return "index_header";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(
			@ModelAttribute(value = "timeline") TimelineEntity timeline,
			ModelMap map) {
		// Spring Auth

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName(); // get logged in username
		String password = auth.getCredentials().toString();

		// Spring Auth

		RecentAttack arrayEleps[] = new RecentAttack[3];

		map.addAttribute("posts", new PostsEntity());

		map.addAttribute("question", new QuestionEntity());
		map.addAttribute("myprof", userManager.getUserByUsername(name));

		map.addAttribute("records", postManager.serach(timeline.getTitle()));

		map.addAttribute("med", new MediaModel());
		map.addAttribute("doc", new MediaModel());
		map.addAttribute("question", new QuestionEntity());
		map.addAttribute("recentAttacks", elephantManager.getRecentAttacks());
		List<AttackEntity> recentAtt = elephantManager.getRecentAttacks();

		for (int i = 0; i < recentAtt.size(); i++) {

			System.out.println(recentAtt.get(i).getAtElephantId());

			RecentAttack recentAttack = new RecentAttack();

			try {

				recentAttack.setName(elephantManager.getElephantById(
						recentAtt.get(i).getAtElephantId()).getName());

			} catch (NullPointerException e) {
				recentAttack.setName("Unknown");
			}

			try {

				recentAttack.setImage(elephantManager.getElephantById(
						recentAtt.get(i).getAtElephantId()).getPhoto());

			} catch (NullPointerException e) {
				recentAttack.setImage("lolo.png");
			}

			recentAttack.setDescription(elephantManager.getVillageById(
					recentAtt.get(i).getAtVillageId()).getName());
			recentAttack.setDate(recentAtt.get(i).getDate());
			recentAttack.setTime(recentAtt.get(i).getTime());
			arrayEleps[i] = recentAttack;

		}
		map.addAttribute("attackEleps", arrayEleps);

		return "index_header";
	}

	// Return Edit Profile
	@RequestMapping(value = "/editProfile", method = RequestMethod.GET)
	public String gettt(ModelMap map) {
		// Spring Auth

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName(); // get logged in username
		String password = auth.getCredentials().toString();

		// Spring Auth

		map.addAttribute("myprof", userManager.getUserByUsername(name));

		map.addAttribute("timeline", new TimelineEntity());
		RecentAttack arrayEleps[] = new RecentAttack[3];

		List<AttackEntity> recentAtt = elephantManager.getRecentAttacks();

		for (int i = 0; i < recentAtt.size(); i++) {

			System.out.println(recentAtt.get(i).getAtElephantId());

			RecentAttack recentAttack = new RecentAttack();

			try {

				recentAttack.setName(elephantManager.getElephantById(
						recentAtt.get(i).getAtElephantId()).getName());

			} catch (NullPointerException e) {
				recentAttack.setName("Unknown");
			}

			try {

				recentAttack.setImage(elephantManager.getElephantById(
						recentAtt.get(i).getAtElephantId()).getPhoto());

			} catch (NullPointerException e) {
				recentAttack.setImage("lolo.png");
			}

			recentAttack.setDescription(elephantManager.getVillageById(
					recentAtt.get(i).getAtVillageId()).getName());
			recentAttack.setDate(recentAtt.get(i).getDate());
			recentAttack.setTime(recentAtt.get(i).getTime());
			arrayEleps[i] = recentAttack;

		}
		map.addAttribute("attackEleps", arrayEleps);

		return "editProfile";

	}

	// Edit
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String Edit(@ModelAttribute(value = "user") @Valid UserEntity user,
			BindingResult result) throws IOException {

		user.setEnabled(1);
		userManager.editUser(user);

		return "redirect:/editProfile";

	}

	// Test Logout
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutSuccessPage(ModelMap map) {

		return "redirect:/index";


	}

	// Change Password
	@RequestMapping(value = "/PanelPassword", method = RequestMethod.GET)
	public String PasswordChanePage(ModelMap map) {
		// Spring Auth

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName(); // get logged in username
		String password = auth.getCredentials().toString();
		map.addAttribute("timeline", new TimelineEntity());

		// Spring Auth

		if (isRememberMeAuthenticated()) {
			return "redirect:/index";

		} else {

			map.addAttribute("password", new Password());
			map.addAttribute("myprof", userManager.getUserByUsername(name));

			map.addAttribute("timeline", new TimelineEntity());
			RecentAttack arrayEleps[] = new RecentAttack[3];

			List<AttackEntity> recentAtt = elephantManager.getRecentAttacks();

			for (int i = 0; i < recentAtt.size(); i++) {

				System.out.println(recentAtt.get(i).getAtElephantId());

				RecentAttack recentAttack = new RecentAttack();

				try {

					recentAttack.setName(elephantManager.getElephantById(
							recentAtt.get(i).getAtElephantId()).getName());

				} catch (NullPointerException e) {
					recentAttack.setName("Unknown");
				}

				try {

					recentAttack.setImage(elephantManager.getElephantById(
							recentAtt.get(i).getAtElephantId()).getPhoto());

				} catch (NullPointerException e) {
					recentAttack.setImage("lolo.png");
				}

				recentAttack.setDescription(elephantManager.getVillageById(
						recentAtt.get(i).getAtVillageId()).getName());
				recentAttack.setDate(recentAtt.get(i).getDate());
				recentAttack.setTime(recentAtt.get(i).getTime());
				arrayEleps[i] = recentAttack;

			}
			map.addAttribute("attackEleps", arrayEleps);
			
			return "change_password";
		}

	}

	// Function Change Password
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public String PasswordChange(
			@ModelAttribute(value = "password") Password pass,
			BindingResult result) {
		// Spring Auth

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName(); // get logged in username
		String password = auth.getCredentials().toString();

		// Spring Auth

		UserEntity prof = userManager.getUserByUsername(name);
		String oldpass = pass.getPassword1();
		String newpass = (PasswordEncoderGenerator.getHash(pass.getPassword2()));

		System.out.println("currrrrrent : " + password);
		System.out.println("corrrrrrent : " + oldpass);

		if (password.equals(oldpass)) {

			prof.setPassword(newpass);
			prof.setEnabled(1);
			userManager.changePassword(prof);

		}

		else {

			return "redirect:/PanelPassword";

		}

		return "redirect:/index";

	}

	// Deactivate
	@RequestMapping(value = "/PanelDeactivate", method = RequestMethod.GET)
	public String DeactivatePage(ModelMap map) {
		// Spring Auth

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName(); // get logged in username
		String password = auth.getCredentials().toString();

		// Spring Auth

		map.addAttribute("timeline", new TimelineEntity());
		RecentAttack arrayEleps[] = new RecentAttack[3];

		List<AttackEntity> recentAtt = elephantManager.getRecentAttacks();

		for (int i = 0; i < recentAtt.size(); i++) {

			System.out.println(recentAtt.get(i).getAtElephantId());

			RecentAttack recentAttack = new RecentAttack();

			try {

				recentAttack.setName(elephantManager.getElephantById(
						recentAtt.get(i).getAtElephantId()).getName());

			} catch (NullPointerException e) {
				recentAttack.setName("Unknown");
			}

			try {

				recentAttack.setImage(elephantManager.getElephantById(
						recentAtt.get(i).getAtElephantId()).getPhoto());

			} catch (NullPointerException e) {
				recentAttack.setImage("lolo.png");
			}

			recentAttack.setDescription(elephantManager.getVillageById(
					recentAtt.get(i).getAtVillageId()).getName());
			recentAttack.setDate(recentAtt.get(i).getDate());
			recentAttack.setTime(recentAtt.get(i).getTime());
			arrayEleps[i] = recentAttack;

		}
		map.addAttribute("attackEleps", arrayEleps);

		map.addAttribute("password", new Password());
		map.addAttribute("myprof", userManager.getUserByUsername(name));

		return "DeactivateAccount";

	}

	// Function Deactivate Account
	@RequestMapping(value = "/Deactivate", method = RequestMethod.POST)
	public String Deactivate(@ModelAttribute(value = "password") Password pass,
			BindingResult result) {
		// Spring Auth

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName(); // get logged in username
		String password = auth.getCredentials().toString();

		// Spring Auth

		UserEntity prof = userManager.getUserByUsername(name);

		if (password.equals(pass.getPassword1())) {

			userManager.deactivate(prof);

		}

		return "redirect:/user";

	}

	// View User Profile
	@RequestMapping(value = "/userProfile", method = RequestMethod.GET)
	public String ShowProfile(ModelMap map) {

		map.addAttribute("user", new UserEntity());

		// Spring Auth

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName(); // get logged in username

		// Spring Auth

		map.addAttribute("myprofile", userManager.getUserByUsername(name));

		map.addAttribute("timeline", new TimelineEntity());
		RecentAttack arrayEleps[] = new RecentAttack[3];

		List<AttackEntity> recentAtt = elephantManager.getRecentAttacks();

		for (int i = 0; i < recentAtt.size(); i++) {

			System.out.println(recentAtt.get(i).getAtElephantId());

			RecentAttack recentAttack = new RecentAttack();

			try {

				recentAttack.setName(elephantManager.getElephantById(
						recentAtt.get(i).getAtElephantId()).getName());

			} catch (NullPointerException e) {
				recentAttack.setName("Unknown");
			}

			try {

				recentAttack.setImage(elephantManager.getElephantById(
						recentAtt.get(i).getAtElephantId()).getPhoto());

			} catch (NullPointerException e) {
				recentAttack.setImage("lolo.png");
			}

			recentAttack.setDescription(elephantManager.getVillageById(
					recentAtt.get(i).getAtVillageId()).getName());
			recentAttack.setDate(recentAtt.get(i).getDate());
			recentAttack.setTime(recentAtt.get(i).getTime());
			arrayEleps[i] = recentAttack;

		}
		map.addAttribute("attackEleps", arrayEleps);
		UserEntity prof = userManager.getUserByUsername(name);
		AdminEntity adm = userManager.getAdminById(prof.getReference());
		map.addAttribute("refer", adm.getFname() + " " + adm.getLname());

		return "myprofile";

	}

	// Add Function
	@RequestMapping(value = "/addDetails", method = RequestMethod.POST)
	public String addUser(
			@ModelAttribute(value = "user") @Valid UserModel user,
			BindingResult result) throws IOException {

		UserEntity userEntity = new UserEntity();

		userEntity.setAge(user.getAge());
		userEntity.setBiblography(user.getBiblography());
		userEntity.setEmail(user.getEmail());
		userEntity.setFname(user.getFname());
		userEntity.setGender(user.getGender());
		userEntity.setLname(user.getLname());
		userEntity.setOccupation(user.getOccupation());
		userEntity.setPassword(PasswordEncoderGenerator.getHash(user
				.getPassword()));
		userEntity.setPhoneNo(user.getPhoneNo());
		userEntity.setPolicy(user.getPolicy());
		userEntity.setReference(user.getReference());
		userEntity.setUsername(user.getUsername());

		if ((user.getPhotofile().getOriginalFilename() != null)
				&& (user.getPhotofile().getOriginalFilename() != "")) {

			MultipartFile multipartFile = user.getPhotofile();

			userEntity.setPhoto(user.getPhotofile().getOriginalFilename());

			File outputfile = null;
			String fileName = multipartFile.getOriginalFilename();

			String extensionOfFileName = fileName.substring(
					fileName.indexOf(".") + 1, fileName.length());
			outputfile = new File("C:\\Image\\" + fileName);

			File thoutputfile = null;

			thoutputfile = new File("C:\\Image\\thumb\\" + fileName);

			BufferedImage thumb = ImageIO.read(multipartFile.getInputStream());
			double percent = 0.8;
			double per = 0.5;
			int scaledWidth = (int) (thumb.getWidth() * percent);
			int scaledHeight = (int) (thumb.getWidth() * per);

			// creates output image
			BufferedImage outputImage = new BufferedImage(scaledWidth,
					scaledHeight, thumb.getType());

			// scales the input image to the output image
			Graphics2D g2d = outputImage.createGraphics();
			g2d.drawImage(thumb, 0, 0, scaledWidth, scaledHeight, null);
			g2d.dispose();

			// extracts extension of output file
			String thextensionOfFileName = fileName.substring(
					fileName.indexOf(".") + 1, fileName.length());

			// writes to output file
			ImageIO.write(outputImage, thextensionOfFileName, thoutputfile);

			if (null != extensionOfFileName
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
		} else {

			userEntity.setPhoto("prof.jpg");
		}

		if (result.hasErrors()) {

			return "redirect:/index";
		} else {

			user.setPassword(PasswordEncoderGenerator.getHash(user
					.getPassword()));

			System.out.println(user.getEmail());

			userManager.addUser(userEntity);

			return "redirect:/index";
		}

	}

	@RequestMapping("/delete/{user_id}")
	public String deleteUser(@PathVariable("user_id") Integer user_id) {

		userManager.deleteUser(user_id);

		return "redirect:user/";
	}

	public void setUserManager(UserManager userManager) {

		this.userManager = userManager;

	}

	/** For remember me authentication */

	/**
	 * Check if user is login by remember me cookie, refer
	 * org.springframework.security
	 * .authentication.AuthenticationTrustResolverImpl
	 */

	/** Admin restriction Dummy Page */
	@RequestMapping(value = "/adminres**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Remember Me");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName("adminrestrict");

		return model;

	}

	/**
	 * This update page is for user login with password only. If user is login
	 * via remember me cookie, send login to ask for password again. To avoid
	 * stolen remember me cookie to update info
	 */
	@RequestMapping(value = "/adminres/update**", method = RequestMethod.GET)
	public ModelAndView updatePage(HttpServletRequest request) {

		ModelAndView model = new ModelAndView();

		if (isRememberMeAuthenticated()) {
			// send login for update
			setRememberMeTargetUrlToSession(request);
			model.addObject("loginUpdate", true);
			model.setViewName("/login");

		} else {
			model.setViewName("update");
		}

		return model;

	}

	private boolean isRememberMeAuthenticated() {

		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		if (authentication == null) {
			return false;
		}

		return RememberMeAuthenticationToken.class
				.isAssignableFrom(authentication.getClass());
	}

	/**
	 * save targetURL in session
	 */
	private void setRememberMeTargetUrlToSession(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.setAttribute("targetUrl", "/adminres/update");
		}
	}

	/**
	 * get targetURL from session
	 */

	private String getRememberMeTargetUrlFromSession(HttpServletRequest request) {
		String targetUrl = "";
		HttpSession session = request.getSession(false);
		if (session != null) {
			targetUrl = session.getAttribute("targetUrl") == null ? ""
					: session.getAttribute("targetUrl").toString();
		}
		return targetUrl;
	}

}
