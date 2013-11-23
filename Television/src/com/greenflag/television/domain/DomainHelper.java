package com.greenflag.television.domain;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.greenflag.utils.http.DownloadBytesTask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

public class DomainHelper {
	public static final String CHANNELS_ROUTE = "http://channels.apiary.io/channels";
	private static final String TAG_CHANNELS = "channels";
	public static List<Channel> getChannelsFromJsonResponse(String json) throws JSONException
	{
		List<Channel> result = new ArrayList<Channel>();
		JSONObject jsonResponse = new JSONObject(json);
		JSONArray channelsJson = jsonResponse.getJSONArray(TAG_CHANNELS);
		List<AsyncTask<URL, Boolean, byte[]>> taskList = new ArrayList<AsyncTask<URL, Boolean, byte[]>>();
		for(int i = 0;i<channelsJson.length();i++){
			JSONObject channelObject = (JSONObject)channelsJson.get(i);
			Channel channel = Channel.fromJSON(channelObject);
			
			AsyncTask<URL, Boolean, byte[]> imageTask = new DownloadBytesTask();
			try {
				imageTask.execute(new URL(channel.getImageUrl()));
				Bitmap bitmap = null;
				byte[] imageBytes = imageTask.get();
				bitmap = BitmapFactory.decodeByteArray(imageBytes, 0,imageBytes.length);
				channel.setBitmap(bitmap);
				result.add(channel);
				//imageTask.
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
}
