package org.rusl.ethpaura.infohub;

import org.rusl.ethpaura.infohub.models.Elephant;
import org.rusl.ethpaura.infohub.services.CommonVariable;
import org.rusl.ethpaura.infohub.services.JSONServices;
import org.rusl.ethpaura.lazyloading.ImageLoader;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ElephantViewFragment extends Fragment {

	private TextView name;
	private TextView bDate;
	private TextView gender;
	private TextView description;
	private ImageView image;
	private ImageLoader imageLoader;
	private CommonVariable commonVariable;
	private Button remove;
	private Button edit;
	private Elephant elephant;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.elephant_view, container, false);

		commonVariable = (CommonVariable) (getActivity()
				.getApplicationContext());

		remove = (Button) view.findViewById(R.id.remove);

		edit = (Button) view.findViewById(R.id.edit);

		name = (TextView) view.findViewById(R.id.name);

		bDate = (TextView) view.findViewById(R.id.b_date);

		gender = (TextView) view.findViewById(R.id.gender);

		description = (TextView) view.findViewById(R.id.description);

		image = (ImageView) view.findViewById(R.id.image);

		imageLoader = new ImageLoader(getActivity());

		if (commonVariable.getElephant() != null) {

			elephant = (Elephant) commonVariable.getElephant();

			name.setText(elephant.getName());
			bDate.setText(elephant.getAge());
			gender.setText(elephant.getGender());
			description.setText(elephant.getDescription());
			imageLoader.DisplayImage(elephant.getPhoto(), getActivity(), image);
		}

		remove.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new RemoveElephant().execute();

			}
		});

		edit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				addFragmentWithHistory(new EditElephantFragment());

			}
		});

		return view;
	}

	class RemoveElephant extends AsyncTask<Void, Void, Void> {

		private String massage;

		@Override
		protected Void doInBackground(Void... params) {

			massage = JSONServices.deleteElephantById(elephant.getElephantId());

			return null;
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(Void result) {

			if (massage != null && massage.equals("success")) {

				Toast.makeText(ElephantViewFragment.this.getActivity(),
						"Sucessfully Remove User", Toast.LENGTH_LONG).show();

				addFragment(new ElephantListFragment());

			}

			super.onPostExecute(result);
		}

	}

	private void addFragment(Fragment fragment) {

		FragmentTransaction t = getFragmentManager().beginTransaction();

		t.replace(R.id.content_frame, fragment);

		t.commit();

	}

	private void addFragmentWithHistory(Fragment fragment) {

		FragmentTransaction t = getFragmentManager().beginTransaction();

		t.replace(R.id.content_frame, fragment);
		t.addToBackStack("back");
		t.commit();

	}
}
