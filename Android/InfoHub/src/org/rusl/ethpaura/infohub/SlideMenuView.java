/**
 * 
 */
package org.rusl.ethpaura.infohub;

import java.util.ArrayList;

import org.rusl.ethpaura.infohub.adapters.AdapterList;
import org.rusl.ethpaura.infohub.models.Admin;
import org.rusl.ethpaura.infohub.models.BaseElement;
import org.rusl.ethpaura.infohub.models.GridElement;
import org.rusl.ethpaura.infohub.services.CommonVariable;
import org.rusl.ethpaura.infohub.utils.Elements;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author Ayesha
 * 
 */
public class SlideMenuView extends Fragment {

	private ArrayList<BaseElement> items;
	private ListView listItems;
	private AdapterList adapterList;
	private CommonVariable commonVariable;
	private TextView name;
	private TextView age;
	private TextView occ;
	private Admin admin;
	private TextView signOut;
	private TextView editProfile;

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

		name = (TextView) view.findViewById(R.id.name);

		age = (TextView) view.findViewById(R.id.age);

		occ = (TextView) view.findViewById(R.id.occupation);
		signOut = (TextView) view.findViewById(R.id.signout);
		editProfile = (TextView) view.findViewById(R.id.edit_profile);
		signOut.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent = new Intent(SlideMenuView.this.getActivity(),
						MainActivity.class);
				SlideMenuView.this.getActivity().finish();

				SlideMenuView.this.getActivity().startActivity(intent);

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

		if (commonVariable != null && commonVariable.getAdmin() != null) {

			admin = commonVariable.getAdmin();
			name.setText(admin.getFname() + " " + admin.getLname());
			age.setText(admin.getAge() + " Years");
			occ.setText(admin.getOccupation());

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

					UserFragment userPanel = new UserFragment();
					addFragment(userPanel);

				} else if (position == 1) {

					ElephantListFragment elephantPanel = new ElephantListFragment();
					addFragment(elephantPanel);

				} else if (position == 2) {
					PostPanelFragment postPanel = new PostPanelFragment();
					addFragment(postPanel);

				} else if (position == 3) {
					GeneralInformationPanelFragment generalInformationPanel = new GeneralInformationPanelFragment();
					addFragment(generalInformationPanel);

				}

				commonVariable.getSlidingMenu().showContent();

			}
		});

		return view;
	}

	private void addFragment(Fragment fragment) {

		FragmentTransaction t = getFragmentManager().beginTransaction();
		Log.e("jjjj", "jjjjj");
		t.addToBackStack("Tag");
		t.replace(R.id.content_frame, fragment);
		t.commit();

	}

	private ArrayList<BaseElement> getListItems() {

		ArrayList<BaseElement> arrayList = new ArrayList<BaseElement>();

		GridElement gridElement = new GridElement();
		gridElement.setText("User Panel");
		arrayList.add(gridElement);

		GridElement gridElement1 = new GridElement();
		gridElement1.setText("Elephant Panel");
		arrayList.add(gridElement1);

		GridElement gridElement2 = new GridElement();
		gridElement2.setText("Post Panel");
		arrayList.add(gridElement2);

		GridElement gridElement3 = new GridElement();
		gridElement3.setText("General Information Panel");
		arrayList.add(gridElement3);

		return arrayList;

	}

}
