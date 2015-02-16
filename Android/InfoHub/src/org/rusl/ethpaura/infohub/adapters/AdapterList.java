/**
 * 
 */
package org.rusl.ethpaura.infohub.adapters;

import java.util.ArrayList;

import org.rusl.ethpaura.infohub.R;
import org.rusl.ethpaura.infohub.models.Attack;
import org.rusl.ethpaura.infohub.models.BaseElement;
import org.rusl.ethpaura.infohub.models.Elephant;
import org.rusl.ethpaura.infohub.models.GridElement;
import org.rusl.ethpaura.infohub.models.HealthData;
import org.rusl.ethpaura.infohub.models.TimeLine;
import org.rusl.ethpaura.infohub.models.User;
import org.rusl.ethpaura.infohub.utils.Elements;
import org.rusl.ethpaura.lazyloading.ImageLoader;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Tharindu
 * 
 */
public class AdapterList extends BaseAdapter {

	private int type;
	private ArrayList<BaseElement> items;
	private Activity activity;
	private Fragment fragment;
	private LayoutInflater inflater;
	private ImageLoader imageLoader;

	/**
	 * @param type
	 * @param items
	 * @param activity
	 * @param fragment
	 */
	public AdapterList(int type, ArrayList<BaseElement> items,
			Activity activity, Fragment fragment) {
		super();
		this.type = type;
		this.items = items;
		this.activity = activity;
		this.fragment = fragment;
		imageLoader = new ImageLoader(activity);

		inflater = (LayoutInflater) this.activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;

		if (type == Elements.LEFT_MENU.getElement()) {

			view = inflater.inflate(R.layout.left_menu_list_layout, null);

			GridElement gridElement = (GridElement) items.get(position);

			TextView text = (TextView) view.findViewById(R.id.text);

			text.setText(gridElement.getText());

		}
		if (type == Elements.TIME_LINE.getElement()) {

			view = inflater.inflate(R.layout.time_line_listview_layout, null);

			TimeLine timeLine = (TimeLine) items.get(position);

			TextView userName = (TextView) view.findViewById(R.id.user_name);

			TextView date = (TextView) view.findViewById(R.id.date);

			TextView title = (TextView) view.findViewById(R.id.title);

			TextView description = (TextView) view
					.findViewById(R.id.description);

			ImageView image = (ImageView) view.findViewById(R.id.user_image);

			ImageView imagePost = (ImageView) view
					.findViewById(R.id.posi_image);

			userName.setText(timeLine.getUsername());

			date.setText(timeLine.getTimeStamp());

			title.setText(timeLine.getTitle());

			description.setText(timeLine.getDescription());

			imageLoader.DisplayImage(timeLine.getUserProfImage(), activity,
					image);

			if (!timeLine.getType().equals("image")) {

				imagePost.setVisibility(View.GONE);
				
			} else {
				
				imageLoader.DisplayImage(timeLine.getUserProfImage(), activity,
						imagePost);
			}
			
			
			
		}
		if (type == Elements.USER.getElement()) {

			view = inflater.inflate(R.layout.user_list_layout, null);

			TextView name = (TextView) view.findViewById(R.id.name);

			TextView age = (TextView) view.findViewById(R.id.age);

			TextView occ = (TextView) view.findViewById(R.id.occ);

			ImageView image = (ImageView) view.findViewById(R.id.image);

			User user = (User) items.get(position);

			imageLoader.DisplayImage(user.getPhoto(), activity, image);
			name.setText(user.getFname() + " " + user.getLname());
			age.setText(user.getAge() + " Years");
			occ.setText(user.getOccupation());

		}
		if (type == Elements.HEALTHDATA.getElement()) {

			view = inflater.inflate(R.layout.health_data_list_layout, null);

			TextView time = (TextView) view.findViewById(R.id.time);

			TextView blood = (TextView) view.findViewById(R.id.blood);

			TextView temp = (TextView) view.findViewById(R.id.temp);

			TextView heart = (TextView) view.findViewById(R.id.heart);

			HealthData healthData = (HealthData) items.get(position);

			time.setText(healthData.getTime());
			blood.setText(healthData.getBloodPressure());
			temp.setText(healthData.getBodytemp());
			heart.setText(healthData.getHeartbeat());

		}
		if (type == Elements.ELEPHANT_DETAIL.getElement()) {

			view = inflater.inflate(R.layout.elephant_detail_layout, null);

			Elephant elephant = (Elephant) items.get(position);

			TextView text = (TextView) view.findViewById(R.id.name);

			TextView text2 = (TextView) view.findViewById(R.id.elephantage);
			TextView text3 = (TextView) view.findViewById(R.id.elephantgender);
			TextView text4 = (TextView) view.findViewById(R.id.elephanttype);

			text.setText(elephant.getName());

			text2.setText(elephant.getAge());
			text3.setText(elephant.getGender());
			text4.setText(elephant.getType());

		}
		if (type == Elements.ATTACK_DETAILS.getElement()) {

			view = inflater.inflate(R.layout.view__attack_place_fragment, null);

			Attack attack = (Attack) items.get(position);

			TextView text = (TextView) view.findViewById(R.id.attackdate);
			TextView text2 = (TextView) view.findViewById(R.id.attacktime);
			TextView text3 = (TextView) view.findViewById(R.id.attackdirection);
			TextView text4 = (TextView) view.findViewById(R.id.attackdamages);
			TextView text5 = (TextView) view
					.findViewById(R.id.attackcasualties);

			text.setText(attack.getDate());
			text2.setText(attack.getTime());
			text3.setText(attack.getDirection());
			text4.setText(attack.getDamages());
			text5.setText(attack.getCasualties());

		}
		if (type == Elements.ATTACK_RECENT_DETAILS.getElement()) {

			view = inflater.inflate(R.layout.elephant_att_layout, null);

			Attack attack = (Attack) items.get(position);

			TextView text = (TextView) view.findViewById(R.id.attackdate);
			TextView text2 = (TextView) view.findViewById(R.id.attacktime);
			TextView text3 = (TextView) view.findViewById(R.id.attackdirection);
			TextView text4 = (TextView) view.findViewById(R.id.attackdamages);
			TextView text5 = (TextView) view
					.findViewById(R.id.attackcasualties);

			text.setText(attack.getDate());
			text2.setText(attack.getTime());
			text3.setText(attack.getDirection());
			text4.setText(attack.getDamages());
			text5.setText(attack.getCasualties());

		}
		return view;
	}
}
