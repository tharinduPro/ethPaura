/**
 * 
 */
package org.rusl.ethpaura.infohub;

import org.rusl.ethpaura.infohub.services.CommonVariable;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

/**
 * @author Tharindu
 * 
 */
public class InfoActivity extends SlidingFragmentActivity {

	protected ListFragment mFrag;
	private CommonVariable commonVariable;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		// -------SET behind view-------//

		setBehindContentView(R.layout.menu_frame);

		commonVariable = (CommonVariable) this.getApplication();

		if (savedInstanceState == null) {
			FragmentTransaction t = this.getSupportFragmentManager()
					.beginTransaction();

			SslideMenuView slideMenuView = new SslideMenuView();

			t.replace(R.id.menu_frame, slideMenuView);
			t.commit();
		} else {
			this.finish();
		}

		// customize the SlidingMenu
		SlidingMenu sm = getSlidingMenu();

		// ((CommonVariable) this.getApplication()).setSlidingMenu(sm);

		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setFadeDegree(0.35f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);

		commonVariable.setSlidingMenu(sm);

		// ----remove drawer icon----------//
		getSupportActionBar().setDisplayHomeAsUpEnabled(false);

		// -------set home button icon--------//
		getSupportActionBar().setIcon(R.drawable.menu);

		// --------set title bar color-----//
		getSupportActionBar().setBackgroundDrawable(
				getResources().getDrawable(R.drawable.title_back_color));

		// ---------enable home button click----------//
		getSupportActionBar().setHomeButtonEnabled(true);

		// -----front view--------//
		setContentView(R.layout.content_frame);

		getSupportFragmentManager().beginTransaction()
				.replace(R.id.content_frame, new WallView()).commit();

		setSlidingActionBarEnabled(true);

	}

}
