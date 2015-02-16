package org.rusl.ethpaura.infohub;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class ElephantPanelFragment extends Fragment {

	private TextView addElephant;
	private TextView removeElephant;
	private TextView addElephantAttack;
	private TextView editElephant;
	private TextView attachCollar;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.elephant_panel_fragment,
				container, false);

		addElephant = (TextView) view.findViewById(R.id.textAddElephant);
		removeElephant = (TextView) view.findViewById(R.id.textRemoveElephant);
		addElephantAttack = (TextView) view
				.findViewById(R.id.textAddElephantAttack);
		editElephant = (TextView) view.findViewById(R.id.textEditElephant);
		attachCollar = (TextView) view.findViewById(R.id.textAttachCollar);

		addElephant.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				AddElephantFragment addElephantFragment = new AddElephantFragment();

				addFragment(addElephantFragment);
			}
		});

		removeElephant.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				RemoveElephantFragment removeElephantFragment = new RemoveElephantFragment();

				addFragment(removeElephantFragment);
			}
		});

		addElephantAttack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				AddElephantAttackFragment addElephantAttackFragment = new AddElephantAttackFragment();

				addFragment(addElephantAttackFragment);
			}
		});

		editElephant.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				EditElephantFragment editElephantFragment = new EditElephantFragment();

				addFragment(editElephantFragment);
			}
		});

		attachCollar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				AttachCollarFragment attachCollarFragment = new AttachCollarFragment();

				addFragment(attachCollarFragment);
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
