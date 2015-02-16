package org.rusl.ethpaura.infohub.adapters;

import java.util.ArrayList;

import org.rusl.ethpaura.infohub.R;
import org.rusl.ethpaura.infohub.models.BaseElement;
import org.rusl.ethpaura.infohub.models.Elephant;
import org.rusl.ethpaura.infohub.utils.PAGE;
import org.rusl.ethpaura.infohub.utils.ServiceUrl;
import org.rusl.ethpaura.lazyloading.ImageLoader;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ViewPagerAdapter extends PagerAdapter {

	private ArrayList<BaseElement> item;
	private int page;
	private Activity activity;
	private ImageLoader imageLoader;
	private LayoutInflater inflater;

	public ViewPagerAdapter(ArrayList<BaseElement> item, int page,
			Activity activity) {
		super();
		this.item = item;
		this.page = page;
		this.activity = activity;
		imageLoader = new ImageLoader(activity);

		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return item.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		// TODO Auto-generated method stub
		return view == (LinearLayout) object;
	}

	@Override
	public int getItemPosition(Object object) {
		// TODO Auto-generated method stub
		return POSITION_NONE;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {

		View view = null;

		if (page == PAGE.ELPHANT_DETAIL_VIEW.getPage()) {

			view = inflater.inflate(R.layout.elephant_view_sub_layout,
					container, false);

			TextView name = (TextView) view.findViewById(R.id.name);

			TextView bDate = (TextView) view.findViewById(R.id.b_date);

			TextView gender = (TextView) view.findViewById(R.id.gender);

			TextView description = (TextView) view
					.findViewById(R.id.description);

			ImageView image = (ImageView) view.findViewById(R.id.image);

			Elephant elephant = (Elephant) item.get(position);

			String imageUrl = "http://192.168.172.1:8080/Image/"
					+ elephant.getPhoto();

			name.setText(elephant.getName());
			bDate.setText(elephant.getAge());
			gender.setText(elephant.getGender());
			description.setText(elephant.getDescription());
			imageLoader.DisplayImage(imageUrl, activity, image);

		}
		((ViewPager) container).addView(view);
		return view;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		((ViewPager) container).removeView((LinearLayout) object);

	}
}
