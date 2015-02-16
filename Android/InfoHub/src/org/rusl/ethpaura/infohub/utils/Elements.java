package org.rusl.ethpaura.infohub.utils;

public enum Elements {

	LEFT_MENU(0), ELEPHANT_DETAIL(1), ATTACK_DETAILS(2), HEALTHDATA(3), USER(4), ATTACK_RECENT_DETAILS(
			5), TIME_LINE(6);

	private int element;

	/**
	 * @param element
	 */
	private Elements(int element) {
		this.element = element;
	}

	/**
	 * @return the element
	 */
	public int getElement() {
		return element;
	}

}
