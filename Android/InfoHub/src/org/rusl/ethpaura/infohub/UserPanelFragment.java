package org.rusl.ethpaura.infohub;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class UserPanelFragment extends Fragment {

	private TextView removeUser;
	private TextView changePrivilegeLevel;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.user_panel_fragment, container,
				false);

		removeUser = (TextView) view.findViewById(R.id.textRemoveUser);
		changePrivilegeLevel = (TextView) view.findViewById(R.id.textChangePrivilegeLevel);

		removeUser.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				UserFragment removeUserFragment = new UserFragment();

				addFragment(removeUserFragment);
			}
		});

		changePrivilegeLevel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				ChangePrivilegeLevelFragment changePrivilegeLevelFragment = new ChangePrivilegeLevelFragment();
				addFragment(changePrivilegeLevelFragment);

			}
		});

		return view;
	}

	private void addFragment(Fragment fragment) {

		FragmentTransaction t = getFragmentManager().beginTransaction();
		Log.e("jjjj", "jjjjj");
		t.replace(R.id.content_frame, fragment);
		t.addToBackStack("Tag");
		t.commit();

	}

}
