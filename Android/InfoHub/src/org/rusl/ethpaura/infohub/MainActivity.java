package org.rusl.ethpaura.infohub;

import org.rusl.ethpaura.infohub.models.Admin;
import org.rusl.ethpaura.infohub.models.User;
import org.rusl.ethpaura.infohub.services.CommonVariable;
import org.rusl.ethpaura.infohub.services.JSONServices;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button sub;
	private EditText username;
	private EditText password;
	private CommonVariable commonVariable;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		commonVariable = (CommonVariable) this.getApplicationContext();

		username = (EditText) findViewById(R.id.username);
		password = (EditText) findViewById(R.id.password);
		sub = (Button) findViewById(R.id.sub);
		sub.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (username.getText().length() == 0) {

					password.setError("Empty Username");

				} else if (password.getText().length() == 0) {

					password.setError("Empty Password");

				} else {

					new LogingBackGround().execute();
				}

			}

			private void onClear() {
				if (username != null)
					username.setText("");
				if (password != null)
					password.setText("");
				return;
			}
		});

	}

	class LogingBackGround extends AsyncTask<Void, Void, Void> {

		private User user;

		@Override
		protected Void doInBackground(Void... params) {

			user = JSONServices.getUSerByName(username.getText().toString(),
					password.getText().toString());

			return null;
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(Void result) {

			if (user != null) {

				if (user.getUsername().equals("No user")) {

					new LogingBackGroundAdmin().execute();

					/*
					 * Toast.makeText(MainActivity.this,
					 * "Wrong Username or Pasword", Toast.LENGTH_LONG) .show();
					 */
				} else {

					commonVariable.setUser(user);

					Intent intent = new Intent(MainActivity.this,
							InfoActivity.class);
					startActivity(intent);

				}

			} else {

				new LogingBackGroundAdmin().execute();
			}

			super.onPostExecute(result);
		}
	}

	class LogingBackGroundAdmin extends AsyncTask<Void, Void, Void> {

		private Admin admin;

		@Override
		protected Void doInBackground(Void... params) {

			admin = JSONServices.getAdminByName(username.getText().toString(),
					password.getText().toString());

			return null;
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(Void result) {

			if (admin != null) {

				if (admin.getUsername().equals("No user")) {

					Toast.makeText(MainActivity.this,
							"Wrong Username or Pasword", Toast.LENGTH_LONG)
							.show();
				} else {

					commonVariable.setAdmin(admin);

					Intent intent = new Intent(MainActivity.this,
							AdministratorOfInfoActivity.class);
					startActivity(intent);

				}

			} else {

				Toast.makeText(MainActivity.this, "Connection Error",
						Toast.LENGTH_LONG).show();
			}

			super.onPostExecute(result);
		}
	}

}
