/**
 * 
 */
package org.rusl.ethpaura.infohub;

import java.util.ArrayList;

import org.rusl.ethpaura.infohub.adapters.AdapterList;
import org.rusl.ethpaura.infohub.models.BaseElement;
import org.rusl.ethpaura.infohub.services.JSONServices;
import org.rusl.ethpaura.infohub.utils.Elements;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * @author Tharindu
 * 
 */
public class WallView extends Fragment {

	private ArrayList<BaseElement> items;

	private ListView listView;

	private AdapterList adapter;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater,
	 * android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.wall_view_fragment, container,
				false);

		listView = (ListView) view.findViewById(R.id.list_view);

		new BackgroundProcess().execute();

		return view;
	}

	class BackgroundProcess extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {

			items = JSONServices.getAllPosts();

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {

			if (items != null) {

				adapter = new AdapterList(Elements.TIME_LINE.getElement(),
						items, WallView.this.getActivity(), null);

				listView.setAdapter(adapter);

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
