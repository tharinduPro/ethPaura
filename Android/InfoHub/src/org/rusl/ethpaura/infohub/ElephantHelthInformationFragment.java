package org.rusl.ethpaura.infohub;

import java.util.ArrayList;
import java.util.Calendar;

import org.rusl.ethpaura.infohub.ElephantDetailsFragment.BackgroundProcess;
import org.rusl.ethpaura.infohub.adapters.AdapterList;
import org.rusl.ethpaura.infohub.models.BaseElement;
import org.rusl.ethpaura.infohub.services.CommonVariable;
import org.rusl.ethpaura.infohub.services.JSONServices;
import org.rusl.ethpaura.infohub.utils.Elements;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public class ElephantHelthInformationFragment extends Fragment {

	private ListView list;
	private AdapterList adapter;
	private ArrayList<BaseElement> items;
	private int id;
	private TextView elephantName;
	private String name;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(
				R.layout.elephant_helth_information_fragment, container, false);

		id = getArguments().getInt("id");
		String name = getArguments().getString("name");

		elephantName = (TextView) view.findViewById(R.id.elephant);

		elephantName.setText(name);

		list = (ListView) view.findViewById(R.id.list_view);

		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

			}
		});

		new BackgroundProcess().execute();

		return view;
	}

	void addFragment(Fragment fragment, boolean addToBackStack, int transition) {
		FragmentManager fragmentManager = this.getFragmentManager();
		FragmentTransaction ft = fragmentManager.beginTransaction();
		ft.replace(R.id.content_frame, fragment, "PageSectionFragment");
		ft.setTransition(transition);
		ft.addToBackStack("PageSectionFragment");
		ft.commit();

	}

	class BackgroundProcess extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			items = JSONServices.getHealthDataById(id);
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {

			adapter = new AdapterList(Elements.HEALTHDATA.getElement(), items,
					ElephantHelthInformationFragment.this.getActivity(), null);

			if (items != null) {

				list.setAdapter(adapter);

			}
			super.onPostExecute(result);
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}

	}

}
