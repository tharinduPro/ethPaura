package org.rusl.ethpaura.infohub;

import org.rusl.ethpaura.infohub.services.JSONServices;

import android.media.JetPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AttachCollarFragment extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.attach_collar_fragment,container,false);
		new BackgroundProcess().execute();
		return view;
		
	}
	
	class BackgroundProcess extends AsyncTask<Void, Void, Void>{

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
