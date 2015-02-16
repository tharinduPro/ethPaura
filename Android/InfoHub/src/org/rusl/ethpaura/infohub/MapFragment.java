package org.rusl.ethpaura.infohub;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.actionbarsherlock.view.Menu;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.http.AndroidHttpClient;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MapFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.map_fragment,container,false);
		
double[][] elephantArray=new double[3][2];
elephantArray[0][0]=4.0125;
elephantArray[0][1]=2.2546;
elephantArray[1][0]=5.262;
elephantArray[1][1]=2.5452;
elephantArray[2][0]=5.01522;
elephantArray[2][1]=2.5652;
		for(int i=0;i<3;i++){
				for(int j=0;j<2;j++){
				GoogleMap mMap;
				mMap = ((SupportMapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
				mMap.addMarker(new MarkerOptions()
				        .position(new LatLng(i, j))
				        .title("Bisso menike"));
			}
			
		}
		return view;
	}

}
