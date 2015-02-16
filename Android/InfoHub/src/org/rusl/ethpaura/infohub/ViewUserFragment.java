package org.rusl.ethpaura.infohub;

import org.rusl.ethpaura.infohub.models.User;
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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewUserFragment extends Fragment {

	private TextView name;
	private TextView age;
	private TextView description;
	private TextView gender;
	private Button remove;
	private Button accept;
	private ImageView userImage;
	private CommonVariable commonVariable;
	private User user;
	private ImageLoader imageLoader;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.view_user_fragment, container,
				false);

		commonVariable = (CommonVariable) (this.getActivity()
				.getApplicationContext());

		imageLoader = new ImageLoader(getActivity());

		name = (TextView) view.findViewById(R.id.user_name);

		age = (TextView) view.findViewById(R.id.user_age);

		description = (TextView) view.findViewById(R.id.user_description);

		gender = (TextView) view.findViewById(R.id.user_gender);

		remove = (Button) view.findViewById(R.id.remove);

		accept = (Button) view.findViewById(R.id.accept);

		userImage = (ImageView) view.findViewById(R.id.user_image);

		if (commonVariable.getUser() != null) {

			user = commonVariable.getUser();

			name.setText(user.getFname() + " " + user.getLname());

			age.setText(user.getAge());

			description.setText(user.getBiblography());

			gender.setText(user.getGender());

			imageLoader.DisplayImage(user.getPhoto(), getActivity(), userImage);

			if (user.getEnabled() != 0) {

				accept.setVisibility(View.GONE);
			}

		}

		remove.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				RemoveUser removeUser = new RemoveUser();
				removeUser.execute();

			}
		});
		accept.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});

		return view;

	}

	class RemoveUser extends AsyncTask<Void, Void, Void> {

		private String massage;

		@Override
		protected Void doInBackground(Void... params) {

			massage = JSONServices.deleteUserById(user.getUserId());

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

				Toast.makeText(ViewUserFragment.this.getActivity(),
						"Sucessfully Remove User", Toast.LENGTH_LONG).show();

				addFragment(new UserFragment());

			}

			super.onPostExecute(result);
		}

	}

	private void addFragment(Fragment fragment) {

		FragmentTransaction t = getFragmentManager().beginTransaction();
		Log.e("jjjj", "jjjjj");
		t.replace(R.id.content_frame, fragment);

		t.commit();

	}

}
