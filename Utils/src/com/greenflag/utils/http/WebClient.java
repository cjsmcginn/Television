package com.greenflag.utils.http;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class WebClient  {

	public String downloadString(WebClientRequest request) throws ClientProtocolException, IOException{
		String result = null;
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(request.getRequestUrl().toString());
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

public byte[] downloadBytes(WebClientRequest request) throws ClientProtocolException, IOException{
	
	byte[] result = null;
	  DefaultHttpClient httpClient = new DefaultHttpClient();
      HttpGet httpGet = new HttpGet(request.getRequestUrl().toString());
      HttpResponse httpResponse = httpClient.execute(httpGet);
      HttpEntity httpEntity = httpResponse.getEntity();
      InputStream is = httpEntity.getContent();       
      ByteArrayOutputStream buffer = new ByteArrayOutputStream();
      int nRead;
      byte[] data = new byte[16384];
      while ((nRead = is.read(data, 0, data.length)) != -1) {
    	  buffer.write(data, 0, nRead);
    	}
      buffer.flush();
      result = buffer.toByteArray();
      return result;
	}
}
