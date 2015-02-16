package org.rusl.ethpaura.infohub.utils;

public enum PAGE {

	ELPHANT_DETAIL_VIEW(0);

	private int page;

	private PAGE(int page) {
		this.page = page;
	}

	public int getPage() {
		return page;
	}

}
