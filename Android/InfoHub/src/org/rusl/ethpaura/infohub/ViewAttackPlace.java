package org.rusl.ethpaura.infohub;

import java.util.ArrayList;
import java.util.Calendar;

import org.rusl.ethpaura.infohub.adapters.AdapterList;
import org.rusl.ethpaura.infohub.models.BaseElement;
import org.rusl.ethpaura.infohub.services.JSONServices;
import org.rusl.ethpaura.infohub.utils.Elements;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Spinner;

public class ViewAttackPlace extends Fragment {
	private ListView list;
	private AdapterList adapter;
	private ArrayList<BaseElement> items;
	private Button buttonFrom;
	private Button buttonto;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.view__attack_place_fragment,
				container, false);
		list = (ListView) view.findViewById(R.id.listview);
		new BackgroundProcess().execute();

		return view;
	}

	class BackgroundProcess extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			items = JSONServices.getAllRecentAttacks();
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {

			if (items != null) {

				adapter = new AdapterList(
						Elements.ATTACK_RECENT_DETAILS.getElement(), items,
						ViewAttackPlace.this.getActivity(), null);

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

class DatePickerFragment extends DialogFragment implements
		DatePickerDialog.OnDateSetListener {

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// Use the current date as the default date in the picker
		final Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);

		// Create a new instance of DatePickerDialog and return it
		return new DatePickerDialog(getActivity(), this, year, month, day);
	}

	public void onDateSet(DatePicker view, int year, int month, int day) {
		// Do something with the date chosen by the user
	}
}