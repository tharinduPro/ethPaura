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

public class PostPanelFragment extends Fragment {

	private TextView deletePosts;
	private TextView deleteQuestions;
	private TextView answerQuestions;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.post_panel_fragment, container,
				false);

		deletePosts = (TextView) view.findViewById(R.id.textDeletePosts);
		deleteQuestions = (TextView) view
				.findViewById(R.id.textDeleteQuestions);
		answerQuestions = (TextView) view
				.findViewById(R.id.textAnswerQuestions);

		deletePosts.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				DeletePostsFragment deletePostsFragment = new DeletePostsFragment();
				addFragment(deletePostsFragment);

			}
		});

		deleteQuestions.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				DeleteQuestionsFragment changePrivilegeLevelFragment = new DeleteQuestionsFragment();
				addFragment(changePrivilegeLevelFragment);

			}
		});

		answerQuestions.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				AnswerQuestionsFragment answerQuestionsFragment = new AnswerQuestionsFragment();
				addFragment(answerQuestionsFragment);

			}
		});

		return view;
	}

	private void addFragment(Fragment fragment) {

		FragmentTransaction t = getFragmentManager().beginTransaction();
		t.addToBackStack("Tag");
		t.replace(R.id.content_frame, fragment);
		Log.e("jjjj", "jjjjj");
		t.commit();

	}

}
