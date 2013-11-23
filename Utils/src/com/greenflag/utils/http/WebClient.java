package com.greenflag.utils.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.util.Log;

public class WebClient extends AsyncTask<String, Void, String> {

	protected String downloadString(String url) throws ClientProtocolException, IOException{
		String result = null;
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity httpEntity = httpResponse.getEntity();
        InputStream is = httpEntity.getContent();        
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                is, "iso-8859-1"), 8);
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
        is.close();
        result = sb.toString();
		return result;
	}
	@Override
	protected String doInBackground(String... params) {
		// TODO Auto-generated method stub
		String url = params[0];
		String result = null;
		try {
			result = downloadString(url);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			Log.e("Television",e.getMessage());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log.e("Television",e.getMessage());
		}
		return result;
	}

}
