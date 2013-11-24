package com.greenflag.television.domain;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;
import org.json.JSONObject;

import com.greenflag.utils.http.DownloadBytesTask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

public class ChannelBuilderTask extends AsyncTask<JSONObject,Boolean,Channel>{

	@Override
	protected Channel doInBackground(JSONObject... params) {
		JSONObject channelObject = params[0];
		Channel result = null;
		try {
			result = Channel.fromJSON(channelObject);
			AsyncTask<URL, Boolean, byte[]> imageTask = new DownloadBytesTask().execute(new URL(result.getImageUrl()));
			
			Bitmap bitmap = null;
			byte[] imageBytes = imageTask.get();
			bitmap = BitmapFactory.decodeByteArray(imageBytes, 0,imageBytes.length);
			result.setBitmap(bitmap);
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		return result;
	}

}
