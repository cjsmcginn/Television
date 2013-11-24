package com.greenflag.television.domain;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutionException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.greenflag.utils.http.DownloadBytesTask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

public class DomainHelper {
	public static final String CHANNELS_ROUTE = "http://channels.apiary.io/channels";
	private static final String TAG_CHANNELS = "channels";
	public static List<Channel> getChannelsFromJsonResponse(String json) throws JSONException
	{
		List<Channel> result = new ArrayList<Channel>();
		JSONObject jsonResponse = new JSONObject(json);
		JSONArray channelsJson = jsonResponse.getJSONArray(TAG_CHANNELS);
		for(int i = 0;i<channelsJson.length();i++){
		
			try {
				JSONObject channelObject = (JSONObject)channelsJson.get(i);
				Bitmap bitmap = null;
				Channel channel = Channel.fromJSON(channelObject);
				AsyncTask<URL, Boolean, byte[]> imageTask;
				imageTask = new DownloadBytesTask().execute(new URL(channel.getImageUrl()));
				byte[] imageBytes = imageTask.get();
				bitmap = BitmapFactory.decodeByteArray(imageBytes, 0,imageBytes.length);
				channel.setBitmap(bitmap);
				result.add(channel);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			
		}
	

		return result;
	}
}
