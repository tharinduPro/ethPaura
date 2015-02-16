package org.rusl.ethpaura.infohub;

import java.util.zip.Inflater;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class EditProfile extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	View view = inflater.inflate(R.layout.edit__profile_fragment,container,false);
	return view;
	}
}
