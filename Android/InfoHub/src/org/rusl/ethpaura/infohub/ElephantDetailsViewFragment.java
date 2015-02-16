package org.rusl.ethpaura.infohub;

import java.util.ArrayList;

import org.rusl.ethpaura.infohub.adapters.AdapterList;
import org.rusl.ethpaura.infohub.adapters.ViewPagerAdapter;
import org.rusl.ethpaura.infohub.models.BaseElement;
import org.rusl.ethpaura.infohub.models.Elephant;
import org.rusl.ethpaura.infohub.services.CommonVariable;
import org.rusl.ethpaura.infohub.services.JSONServices;
import org.rusl.ethpaura.infohub.utils.Elements;
import org.rusl.ethpaura.infohub.utils.PAGE;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ElephantDetailsViewFragment extends Fragment {

	private ViewPager viewPager;
	private ViewPagerAdapter adapter;
	private ArrayList<BaseElement> items;
	private CommonVariable commonVariable;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.elephant_detailview_fragment,
				container, false);

		int position = getArguments().getInt("position");

		commonVariable = (CommonVariable) (this.getActivity()
				.getApplicationContext());

		viewPager = (ViewPager) view.findViewById(R.id.elephant_detail);

		adapter = new ViewPagerAdapter(commonVariable.getElephantList(),
				PAGE.ELPHANT_DETAIL_VIEW.getPage(), getActivity());

		viewPager.setAdapter(adapter);

		viewPager.setCurrentItem(position);

		return view;
	};

}
