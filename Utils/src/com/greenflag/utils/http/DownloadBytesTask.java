package com.greenflag.utils.http;

import java.io.IOException;
import java.net.URL;

import org.apache.http.client.ClientProtocolException;

import com.greenflag.utils.http.WebClientRequest.RequestTypes;

import android.os.AsyncTask;

public class DownloadBytesTask extends AsyncTask<URL, Boolean, byte[]>{

	@Override
	protected byte[] doInBackground(URL... params) {
		byte[] result = null;
		WebClientRequest request = new WebClientRequest();
		request.setRequestType(RequestTypes.GET);
		request.setRequestUrl(params[0]);
		WebClient wc = new WebClient();
		try {
			result = wc.downloadBytes(request);
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
