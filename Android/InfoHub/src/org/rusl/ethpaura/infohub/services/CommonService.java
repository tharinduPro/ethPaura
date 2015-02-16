package org.rusl.ethpaura.infohub.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.util.Log;

public class CommonService {

	/**
	 * Read the json output of the given URL
	 * 
	 * @return String
	 */
	public static String readJsonContent(String webUrl) {
		StringBuilder builder = new StringBuilder();
		HttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(webUrl);

		try {
			HttpResponse responce = client.execute(httpGet);
			StatusLine statusLine = responce.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if (statusCode == 200) {
				HttpEntity entity = responce.getEntity();
				InputStream content = entity.getContent();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(content));
				String line;
				while ((line = reader.readLine()) != null) {
					builder.append(line);
				}
			} else {
				Log.e("Failed", "Failed To download");
			}

		} catch (ClientProtocolException e) {

			// e.printStackTrace();
			Log.e("ERROR", e.toString());
		} catch (IOException e) {
			// Toast.makeText(this, "iOException", Toast.LENGTH_SHORT).show();
			// e.printStackTrace();
			Log.e("ERROR", e.toString());
		}
		return builder.toString();

	}

	public static String readJsonFromUrl(String url) {

		String htmlResponce = null;
		HttpGet httpGet = new HttpGet(url);
		HttpClient httpClient = new DefaultHttpClient();
		try {
			HttpResponse httpResponse = httpClient.execute(httpGet);
			StatusLine statusLine = httpResponse.getStatusLine();
			if (statusLine.getStatusCode() == 200) {

				HttpEntity httpEntity = httpResponse.getEntity();

				/*
				 * InputStream inputStream = httpEntity.getContent();
				 * BufferedReader reader = new BufferedReader(new
				 * InputStreamReader(inputStream));
				 * while(reader.readLine()!=null){
				 * stringBuilder.append(reader.readLine()); }
				 */

				htmlResponce = EntityUtils.toString(httpEntity);

			}
		} catch (ClientProtocolException e) {
			Log.e(CommonService.class.getName(), e.getMessage());
			return null;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log.e(CommonService.class.getName(), "" + e.getMessage());
			return null;
		}
		return htmlResponce;

	}

}
