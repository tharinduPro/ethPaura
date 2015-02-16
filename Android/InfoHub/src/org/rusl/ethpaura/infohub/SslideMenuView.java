/**
 * 
 */
package org.rusl.ethpaura.infohub;

import java.util.ArrayList;

import org.rusl.ethpaura.infohub.adapters.AdapterList;
import org.rusl.ethpaura.infohub.models.BaseElement;
import org.rusl.ethpaura.infohub.models.GridElement;
import org.rusl.ethpaura.infohub.models.User;
import org.rusl.ethpaura.infohub.services.CommonVariable;
import org.rusl.ethpaura.infohub.utils.Elements;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author Tharindu
 * 
 */
public class SslideMenuView extends Fragment {

	private ArrayList<BaseElement> items;
	private ListView listItems;
	private AdapterList adapterList;
	private CommonVariable commonVariable;
	private TextView name;
	private TextView age;
	private TextView occ;
	private User user;
	private TextView editProfile;
	private TextView signOut;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater,
	 * android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.sslide_menu_view_fragment,
				container, false);

		commonVariable = (CommonVariable) getActivity().getApplication();

		commonVariable = (CommonVariable) getActivity().getApplication();

		signOut = (TextView) view.findViewById(R.id.signout);

		name = (TextView) view.findViewById(R.id.name);

		age = (TextView) view.findViewById(R.id.age);

		occ = (TextView) view.findViewById(R.id.occupation);

		editProfile = (TextView) view.findViewById(R.id.edit_profile);

		signOut.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent = new Intent(SslideMenuView.this.getActivity(),
						MainActivity.class);
				SslideMenuView.this.getActivity().finish();

				SslideMenuView.this.getActivity().startActivity(intent);

			}
		});

		editProfile.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				EditProfile editProfile = new EditProfile();
				addFragment(editProfile);

			}
		});

		if (commonVariable != null && commonVariable.getUser() != null) {

			user = commonVariable.getUser();
			name.setText(user.getFname() + " " + user.getLname());
			age.setText(user.getAge() + " Years");
			occ.setText(user.getOccupation());

		}

		listItems = (ListView) view.findViewById(R.id.left_menu_list_id);

		adapterList = new AdapterList(Elements.LEFT_MENU.getElement(),
				getListItems(), this.getActivity(), null);

		listItems.setAdapter(adapterList);

		listItems.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {

				if (position == 0) {
					ElephantDetailsFragment elephantDetailsFragment = new ElephantDetailsFragment();
					addFragment(elephantDetailsFragment);
				} else if (position == 1) {
					ElephantHelthDataFragment elephantHelthInformationFragment = new ElephantHelthDataFragment();
					addFragment(elephantHelthInformationFragment);
				} else if (position == 2) {
					ViewAttackPlace viewAttackPlace = new ViewAttackPlace();
					addFragment(viewAttackPlace);
				} else if (position == 3) {
					AttackAreaMapFragment attackAreaMapFragment = new AttackAreaMapFragment();
					addFragment(attackAreaMapFragment);
				} else if (position == 4) {
					ElephantPossitionlFragment elephantpossitionFragment = new ElephantPossitionlFragment();
					addFragment(elephantpossitionFragment);
				} /*
				 * else if (position == 5) { PossitionDataFragment
				 * possitionDataFragment = new PossitionDataFragment();
				 * addFragment(possitionDataFragment); } else if (position == 6)
				 * { EditProfile editProfile = new EditProfile();
				 * addFragment(editProfile); }
				 */
				commonVariable.getSlidingMenu().showContent();
			}
		});
		return view;
	}

	private void addFragment(Fragment fragment) {

		FragmentTransaction t = getFragmentManager().beginTransaction();

		t.replace(R.id.content_frame, fragment);
		t.commit();

	}

	private ArrayList<BaseElement> getListItems() {

		ArrayList<BaseElement> arrayList = new ArrayList<BaseElement>();

		GridElement gridElement = new GridElement();
		gridElement.setText("Elephant Details");
		arrayList.add(gridElement);

		GridElement gridElement2 = new GridElement();
		gridElement2.setText("Elephant Helth Information");
		arrayList.add(gridElement2);

		GridElement gridElement3 = new GridElement();
		gridElement3.setText("Recent Attacks");
		arrayList.add(gridElement3);

		GridElement gridElement4 = new GridElement();
		gridElement4.setText("Attack Area Maps");
		arrayList.add(gridElement4);

		GridElement gridElement5 = new GridElement();
		gridElement5.setText("Elephant Position Maps");
		arrayList.add(gridElement5);

		/*
		 * GridElement gridElement6 = new GridElement();
		 * gridElement6.setText("Position Data"); arrayList.add(gridElement6);
		 * 
		 * GridElement gridElement7 = new GridElement();
		 * gridElement7.setText("Edit Profile"); arrayList.add(gridElement7);
		 */

		return arrayList;

	}

}
