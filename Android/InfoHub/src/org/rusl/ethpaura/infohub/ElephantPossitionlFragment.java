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

public class ElephantPossitionlFragment extends Fragment {
	
	private TextView retrieveData;
	private TextView map;
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(
				R.layout.elephant_possition_fragment, container, false);
		
		retrieveData = (TextView) view.findViewById(R.id.textretrievedata);
		map = (TextView) view.findViewById(R.id.textmap);
		
		
		map.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				MapFragment mapFragment = new MapFragment();

				addFragment(mapFragment);
			}
		});

		retrieveData.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				RetrieceDataFragment retriecedataFragment = new RetrieceDataFragment();

				addFragment(retriecedataFragment);
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