package com.greenflag.television.domain;

import org.json.JSONException;
import org.json.JSONObject;

public class Channel {
	private static final String TAG_ID="id";
	private static final String TAG_NAME="name";
	private int id;
	private String name;

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
		return result;
	}
}
