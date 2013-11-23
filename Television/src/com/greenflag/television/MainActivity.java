package com.greenflag.television;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import com.greenflag.television.domain.Channel;
import com.greenflag.television.domain.DomainHelper;
import com.greenflag.television.ui.ChannelListAdapter;
import com.greenflag.utils.http.DownloadStringTask;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		populateChannelList();
		return true;
	}
	protected void populateChannelList(){
		//TODO Refactor into better helper
		DownloadStringTask t = new DownloadStringTask();
		try {
			URL route = new URL(DomainHelper.CHANNELS_ROUTE);
			URL[] params = new URL[]{route};
			AsyncTask<URL,Boolean,String> task = t.execute(params);
			try {
				String response = task.get();
				List<Channel> channelList = DomainHelper.getChannelsFromJsonResponse(response);
				
				Channel[] channelsArray = channelList.toArray(new Channel[channelList.size()]);
				ChannelListAdapter adapter = new ChannelListAdapter(this,R.layout.channel_listview,channelList);
				ListView listView = (ListView) findViewById(R.id.channelListView);
				listView.setAdapter(adapter);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
}
