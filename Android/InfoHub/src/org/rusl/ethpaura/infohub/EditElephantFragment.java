package org.rusl.ethpaura.infohub;

import org.rusl.ethpaura.infohub.models.Elephant;
import org.rusl.ethpaura.infohub.services.CommonVariable;
import org.rusl.ethpaura.infohub.services.JSONServices;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class EditElephantFragment extends Fragment {

	private CommonVariable commonVariable;

	private EditText elephantName;
	private EditText type;
	private EditText age;
	private EditText gender;
	private EditText habit;
	private EditText description;
	private EditText collerdate;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.edit_elephant_fragment,
				container, false);

		commonVariable = (CommonVariable) (getActivity()
				.getApplicationContext());

		elephantName = (EditText) view.findViewById(R.id.name);

		type = (EditText) view.findViewById(R.id.type);

		age = (EditText) view.findViewById(R.id.age);

		gender = (EditText) view.findViewById(R.id.gender);

		habit = (EditText) view.findViewById(R.id.habbitat);

		description = (EditText) view.findViewById(R.id.description);

		collerdate = (EditText) view.findViewById(R.id.c_dDate);

		if (commonVariable.getElephant() != null) {

			Elephant elephant = commonVariable.getElephant();
			
			elephantName.setText(elephant.getName());
			type.setText(elephant.getType());
			age.setText(elephant.getAge());
			gender.setText(elephant.getGender());
			description.setText(elephant.getDescription());
			collerdate.setText(elephant.getCollaredDate());
			

		}
		// new BackgroundProcess().execute();
		return view;

	}

	class BackgroundProcess extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			JSONServices.getAllElephants();
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}

	}
}
