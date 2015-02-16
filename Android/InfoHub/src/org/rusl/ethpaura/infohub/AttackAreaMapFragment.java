package org.rusl.ethpaura.infohub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.SupportMapFragment;

public class AttackAreaMapFragment extends SupportMapFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.attack_area_map_fragment,container,false);
		
		
		/*GoogleMap mMap;
		mMap = ((SupportMapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		mMap.addMarker(new MarkerOptions()
		        .position(new LatLng(17.6078, 8.08167))
		        .title("Bisso menike"));*/
				
		return view;
	}

}
