package org.rusl.ethpaura.infohub;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class GeneralInformationPanelFragment extends Fragment {
	
	private TextView addRecords;
	private TextView addAttackZones;
	private TextView mapDeathPlaces;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(
				R.layout.general_information_panel_fragment, container, false);
		
		addRecords = (TextView) view.findViewById(R.id.textChangePrivilegeLevel);
		addAttackZones = (TextView) view.findViewById(R.id.textAddAttackZones);
		mapDeathPlaces = (TextView) view.findViewById(R.id.textMapDeathPlaces);
		
		mapDeathPlaces.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				MapDeathPlacesFragment mapDeathPlacesFragment = new MapDeathPlacesFragment();

				addFragment(mapDeathPlacesFragment);
			}
		});

	
		
		
		return view;

	}

private void addFragment(Fragment fragment) {

	FragmentTransaction t = getFragmentManager().beginTransaction();
	Log.e("jjjj", "jjjjj");
	t.replace(R.id.content_frame, fragment);
	t.addToBackStack("Tag");
	t.commit();

}

}