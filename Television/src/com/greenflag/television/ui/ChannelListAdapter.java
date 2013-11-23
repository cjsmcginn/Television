/**
 * 
 */
package com.greenflag.television.ui;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.greenflag.television.R;
import com.greenflag.television.domain.Channel;

/**
 * @author Chris
 *
 */
public class ChannelListAdapter extends ArrayAdapter<Channel> {

	private final List<Channel> channels;
	private final Context context;
	private final int resource;
	public ChannelListAdapter(Context context, int resource,
			List<Channel> objects) {
		super(context, resource, objects);
		this.context =context;
		this.resource=resource;
		this.channels = objects;
		
	}
	
	@Override
	public View getView(int position,View convertView,ViewGroup parent){
		LayoutInflater inflater = (LayoutInflater) context
		        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View result = inflater.inflate(R.layout.channel_listview, parent, false);
		TextView nameText= (TextView) result.findViewById(R.id.channelName);
		ImageView channelImage = (ImageView)result.findViewById(R.id.channelImage);
		
		Channel c = channels.get(position);
		channelImage.setImageBitmap(c.getBitmap());
		nameText.setText(c.getName());
		return result;
	}

}
