/**
 * 
 */
package org.rusl.ethpaura.controller;

import java.util.List;

import org.rusl.ethpaura.entity.AttackEntity;
import org.rusl.ethpaura.entity.PositionEntity;
import org.rusl.ethpaura.entity.TimelineEntity;
import org.rusl.ethpaura.model.RecentAttack;
import org.rusl.ethpaura.services.ElephantManagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Rumesha
 * 
 */
@Controller
public class MapController {

	@Autowired
	private ElephantManagerInterface elephantManager;

	@RequestMapping(value = "/MapData/Id/{Id}", method = RequestMethod.GET)
	public @ResponseBody
	List<PositionEntity> getMapData(@PathVariable(value = "Id") int id,
			ModelMap map) {

		System.out.println("dsasdasd");

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

			recentAttack.setDescription(recentAtt.get(i).getDamages());

			recentAttack.setDate(recentAtt.get(i).getDate());

			recentAttack.setTime(recentAtt.get(i).getTime());

			arrayEleps[i] = recentAttack;

		}
		map.addAttribute("attackEleps", arrayEleps);

		return elephantManager.getMapData(id);

	}

	@RequestMapping(value = "/AttackMapData/", method = RequestMethod.GET)
	public @ResponseBody
	List<AttackEntity> getAttackMapData(ModelMap map) {

		System.out.println("dsasdasd");

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

			recentAttack.setDescription(recentAtt.get(i).getDamages());

			recentAttack.setDate(recentAtt.get(i).getDate());

			recentAttack.setTime(recentAtt.get(i).getTime());

			arrayEleps[i] = recentAttack;

		}
		map.addAttribute("attackEleps", arrayEleps);

		return elephantManager.getAttackMapData();

	}

}
