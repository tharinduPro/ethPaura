/**
 * 
 */
package org.rusl.ethpaura.controller;

import java.util.List;

import org.rusl.ethpaura.entity.AttackEntity;
import org.rusl.ethpaura.entity.HealthDataEntity;
import org.rusl.ethpaura.entity.SelectionEntity;
import org.rusl.ethpaura.entity.TimelineEntity;
import org.rusl.ethpaura.model.RecentAttack;
import org.rusl.ethpaura.services.ElephantManagerInterface;
import org.rusl.ethpaura.services.UserManagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Rumesha
 * 
 */
@Controller
public class ElephantController {

	@Autowired
	private ElephantManagerInterface elephantManager;
	@Autowired
	private UserManagerInterface userManager;

	// Elephant List page
	@RequestMapping(value = "/Elephants", method = RequestMethod.GET)
	public String elephantPage(ModelMap map) {
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

		map.addAttribute("elephantList", elephantManager.getAllElephants());
		map.addAttribute("myprof", userManager.getUserByUsername(name));

		return "ElephantList";

	}

	// show elepahnt page
	@RequestMapping(value = "/showElephant/{id}", method = RequestMethod.GET)
	public String showelephantPage(@PathVariable("id") Integer id, ModelMap map) {

		// Spring Auth

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName(); // get logged in username
		String password = auth.getCredentials().toString();

		// Spring Auth

		map.addAttribute("elephant", elephantManager.getElephantById(id));
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

		return "ShowElephant";

	}

	// Select Health DAta filter
	@RequestMapping(value = "/SelectHealthData", method = RequestMethod.GET)
	public String HealthPage(ModelMap map) {

		// Spring Auth

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName(); // get logged in username
		String password = auth.getCredentials().toString();

		// Spring Auth

		map.addAttribute("hh", new HealthDataEntity());
		map.addAttribute("myprof", userManager.getUserByUsername(name));

		map.addAttribute("elephantList", elephantManager.getAllElephants());

		String sdate = "1970-01-22";

		map.addAttribute("HList", elephantManager.getAllHData(1, sdate));

		map.addAttribute("elephantdetail", new SelectionEntity());

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

		return "ShowHealthData";

	}

	// Show filtered Health Data
	@RequestMapping(value = "/showHData", method = RequestMethod.POST)
	public String showhealth(
			@ModelAttribute(value = "elephantdetail") SelectionEntity elephantdetail,
			BindingResult result, ModelMap map) {

		// Spring Auth

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName(); // get logged in username
		String password = auth.getCredentials().toString();

		// Spring Auth

		map.addAttribute("elephantList", elephantManager.getAllElephants());
		map.addAttribute("elephantdetail", new SelectionEntity());
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
		String sdate = elephantdetail.getXdate().toString();
		map.addAttribute("HList",
				elephantManager.getAllHData(elephantdetail.getEid(), sdate));

		return "ShowHealthData";

	}

	// select predictions
	@RequestMapping(value = "/HeathInfo", method = RequestMethod.GET)
	public String predictions(ModelMap map) {

		// Spring Auth

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName(); // get logged in username
		String password = auth.getCredentials().toString();

		// Spring Auth

		map.addAttribute("elephantList", elephantManager.getAllElephants());
		map.addAttribute("elephantdetail", new SelectionEntity());
		map.addAttribute("myprof", userManager.getUserByUsername(name));

		map.addAttribute("PList", elephantManager.getPredictions(1));

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
		return "prediction";

	}

	// Show filtered prediction Data
	@RequestMapping(value = "/showPredictions", method = RequestMethod.POST)
	public String showp(
			@ModelAttribute(value = "elephantdetail") SelectionEntity elephantdetail,
			BindingResult result, ModelMap map) {

		// Spring Auth

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName(); // get logged in username
		String password = auth.getCredentials().toString();

		// Spring Auth

		map.addAttribute("elephantList", elephantManager.getAllElephants());
		map.addAttribute("elephantdetail", new SelectionEntity());
		map.addAttribute("myprof", userManager.getUserByUsername(name));
		map.addAttribute("timeline", new TimelineEntity());
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

		map.addAttribute("PList",
				elephantManager.getPredictions(elephantdetail.getEid()));

		return "prediction";

	}

	@RequestMapping(value = "/Attacks", method = RequestMethod.GET)
	public String attackPage(ModelMap map) {

		// Spring Auth

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName(); // get logged in username
		String password = auth.getCredentials().toString();

		// Spring Auth

		map.addAttribute("elephantList", elephantManager.getAllElephants());
		map.addAttribute("myprof", userManager.getUserByUsername(name));
		map.addAttribute("villageList", elephantManager.getAllVillages());
		map.addAttribute("attacks", new SelectionEntity());

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

		map.addAttribute("attackList", elephantManager.getAllAttacks());

		return "Attacks";

	}

	// Show filtered positions
	@RequestMapping(value = "/showAttacks", method = RequestMethod.POST)
	public String attacks(
			@ModelAttribute(value = "attacks") SelectionEntity attacks,
			BindingResult result, ModelMap map) {

		// Spring Auth

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName(); // get logged in username
		String password = auth.getCredentials().toString();

		// Spring Auth

		map.addAttribute("elephantList", elephantManager.getAllElephants());
		map.addAttribute("myprof", userManager.getUserByUsername(name));
		map.addAttribute("villageList", elephantManager.getAllVillages());
		map.addAttribute("attacks", new SelectionEntity());

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

		System.out
				.println("bfkhgkfgkfbgkjfgkf999999*****" + attacks.getXdate());

		if (attacks.getXdate().equals("")) {
			System.out.println("nhkgjhkgnullllllllll*");
		}

		map.addAttribute(
				"attackList",
				elephantManager.getAttackByInfo(attacks.getEid(),
						attacks.getXdate(), attacks.getVid()));

		return "Attacks";

	}
	
	// return
		@RequestMapping(value = "/AttackMap", method = RequestMethod.GET)
		public String attackMap(ModelMap map) {
			map.addAttribute("positionList", elephantManager.getAllPositions(2, ""));

			// Spring Auth

			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String name = auth.getName(); // get logged in username
			// Spring Auth

			map.addAttribute("elephantList", elephantManager.getAllElephants());
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

			return "AttackMap";

		}
	

	// Select Position filter
	@RequestMapping(value = "/SelectPosition", method = RequestMethod.GET)
	public String testPage(ModelMap map) {

		// Spring Auth

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName(); // get logged in username
		String password = auth.getCredentials().toString();

		// Spring Auth

		map.addAttribute("elephantdetail", new SelectionEntity());
		map.addAttribute("myprof", userManager.getUserByUsername(name));
		map.addAttribute("elephantList", elephantManager.getAllElephants());
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
		String sdate = "1970-01-16";
		map.addAttribute("positionList",
				elephantManager.getAllPositions(1, sdate));
		return "SelectPositions";

	}

	// Show filtered positions
	@RequestMapping(value = "/showPositions", method = RequestMethod.POST)
	public String datacation(
			@ModelAttribute(value = "elephantdetail") SelectionEntity elephantdetail,
			BindingResult result, ModelMap map) {

		// Spring Auth

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName(); // get logged in username
		String password = auth.getCredentials().toString();

		// Spring Auth

		map.addAttribute("elephantList", elephantManager.getAllElephants());
		map.addAttribute("elephantdetail", new SelectionEntity());
		map.addAttribute("myprof", userManager.getUserByUsername(name));
		map.addAttribute("positionList", elephantManager.getAllPositions(
				elephantdetail.getEid(), elephantdetail.getXdate()));
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

		return "SelectPositions";

	}

	@RequestMapping(value = "/PositionMap", method = RequestMethod.GET)
	public String end(ModelMap map) {
		map.addAttribute("positionList", elephantManager.getAllPositions(2, ""));

		// Spring Auth

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName(); // get logged in username
		// Spring Auth

		map.addAttribute("elephantList", elephantManager.getAllElephants());
		map.addAttribute("myprof", userManager.getUserByUsername(name));

		map.addAttribute("timeline", new TimelineEntity());

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
		return "map";

	}

	

	// Add Attack Data Automatically
	@RequestMapping(value = "/addAttackDetails/{vid}/{dir}/{lat}/{lan}", method = RequestMethod.GET)
	public String addAttackauto(@PathVariable("vid") String vid,
			@PathVariable("dir") String dir, @PathVariable("lat") String lat,
			@PathVariable("lan") String lan) {

		int vID = Integer.parseInt(vid);

		AttackEntity attack = new AttackEntity();
		attack.setAtVillageId(vID);
		attack.setLatitute(lat);
		attack.setLongitude(lan);
		attack.setDirection(dir);
		attack.setDate("2014-08-28");

		elephantManager.addAttackAuto(attack);

		return "redirect:/user";

	}

}
