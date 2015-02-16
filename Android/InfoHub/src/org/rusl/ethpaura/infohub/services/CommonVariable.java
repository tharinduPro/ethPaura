/**
 * 
 */
package org.rusl.ethpaura.infohub.services;

import java.util.ArrayList;

import org.rusl.ethpaura.infohub.models.Admin;
import org.rusl.ethpaura.infohub.models.BaseElement;
import org.rusl.ethpaura.infohub.models.Elephant;
import org.rusl.ethpaura.infohub.models.User;

import android.app.Application;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * @author Tharindu
 * 
 */
public class CommonVariable extends Application {

	private SlidingMenu slidingMenu;

	private User user;

	private Admin admin;

	private ArrayList<BaseElement> elephantList;

	private Elephant elephant;

	public Elephant getElephant() {
		return elephant;
	}

	public void setElephant(Elephant elephant) {
		this.elephant = elephant;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public ArrayList<BaseElement> getElephantList() {
		return elephantList;
	}

	public void setElephantList(ArrayList<BaseElement> elephantList) {
		this.elephantList = elephantList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the slidingMenu
	 */
	public SlidingMenu getSlidingMenu() {
		return slidingMenu;
	}

	/**
	 * @param slidingMenu
	 *            the slidingMenu to set
	 */
	public void setSlidingMenu(SlidingMenu slidingMenu) {
		this.slidingMenu = slidingMenu;
	}

}
