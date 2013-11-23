package com.greenflag.television.domain;

import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Bitmap;

public class Channel {
	private static final String TAG_ID="id";
	private static final String TAG_NAME="name";
	private static final String TAG_IMAGE_URL="imageUrl";
	private String imageUrl;
	private int id;
	private String name;
	private Bitmap bitmap;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static Channel fromJSON(JSONObject channelJson) throws JSONException{
		Channel result = new Channel();		
		result.setId(channelJson.getInt(TAG_ID));
		result.setName(channelJson.getString(TAG_NAME));
		result.setImageUrl(channelJson.getString(TAG_IMAGE_URL));
		return result;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Bitmap getBitmap() {
		return bitmap;
	}

	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}
}
