package org.rusl.ethpaura.infohub;

import java.util.ArrayList;

import org.rusl.ethpaura.infohub.ElephantDetailsFragment.BackgroundProcess;
import org.rusl.ethpaura.infohub.adapters.AdapterList;
import org.rusl.ethpaura.infohub.models.BaseElement;
import org.rusl.ethpaura.infohub.models.User;
import org.rusl.ethpaura.infohub.services.CommonVariable;
import org.rusl.ethpaura.infohub.services.JSONServices;
import org.rusl.ethpaura.infohub.utils.Elements;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class UserFragment extends Fragment {

	private ArrayList<BaseElement> items;
	private ListView listView;
	private AdapterList adapter;
	private CommonVariable commonVariable;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.remove_user_fragment, container,
				false);

		commonVariable = (CommonVariable) (this.getActivity()
				.getApplicationContext());

		listView = (ListView) view.findViewById(R.id.listview);

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				User user = (User) items.get(position);

				commonVariable.setUser(user);

				Bundle bundle = new Bundle();

				bundle.putInt("userId", user.getUserId());

				ViewUserFragment userPanelFragment = new ViewUserFragment();

				userPanelFragment.setArguments(bundle);

				addFragment(userPanelFragment);

				// TODO Auto-generated method stub

			}
		});

		new BackgroundProcess().execute();
		return view;

	}

	class BackgroundProcess extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			items = JSONServices.getAllUsers();
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {

			adapter = new AdapterList(Elements.USER.getElement(), items,
					UserFragment.this.getActivity(), null);

			listView.setAdapter(adapter);

			super.onPostExecute(result);
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}

	}

	private void addFragment(Fragment fragment) {

		FragmentTransaction t = getFragmentManager().beginTransaction();
		Log.e("jjjj", "jjjjj");
		t.replace(R.id.content_frame, fragment);
		t.addToBackStack("Tag");
		t.commit();

	}

}
