package com.greenflag.television.domain;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DomainHelper {
	public static final String CHANNELS_ROUTE = "http://channels.apiary.io/channels";
	private static final String TAG_CHANNELS = "channels";
	public static List<Channel> getChannelsFromJsonResponse(String json) throws JSONException
	{
		List<Channel> result = new ArrayList<Channel>();
		JSONObject jsonResponse = new JSONObject(json);
		JSONArray channelsJson = jsonResponse.getJSONArray(TAG_CHANNELS);
		
		for(int i = 0;i<channelsJson.length();i++){
			JSONObject channelObject = (JSONObject)channelsJson.get(i);
			result.add(Channel.fromJSON(channelObject));
		}
	
		return result;
	}
}
