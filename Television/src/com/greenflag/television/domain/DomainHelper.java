package com.greenflag.television.domain;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DomainHelper {
	private static final String TAG_CHANNELS = "channels";
	public static List<Channel> getChannelsFromJsonResponse(String json) throws JSONException
	{
		List<Channel> result = new ArrayList<Channel>();
		JSONObject jsonResponse = new JSONObject(json);
		JSONArray channelsJson = jsonResponse.getJSONArray(TAG_CHANNELS);
		
		for(int i = 0;i<channelsJson.length();i++){
			JSONObject channelObject = (JSONObject)channelsJson.get(1);
			result.add(Channel.fromJSON(channelObject));
		}
	
		return result;
	}
}
