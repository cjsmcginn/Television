package com.greenflag.utils.http;

import java.io.IOException;
import java.net.URL;

import org.apache.http.client.ClientProtocolException;

import com.greenflag.utils.http.WebClientRequest.RequestTypes;

import android.os.AsyncTask;

public class DownloadStringTask extends AsyncTask<URL, Void, String>{

	@Override
	protected String doInBackground(URL... params) {
		// TODO Auto-generated method stub
		String result = null;
		WebClientRequest request = new WebClientRequest();
		request.setRequestType(RequestTypes.GET);
		request.setRequestUrl(params[0]);
		WebClient wc = new WebClient();
		try {
			result = wc.downloadString(request);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
