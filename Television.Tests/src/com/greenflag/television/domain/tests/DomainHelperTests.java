package com.greenflag.television.domain.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;

import junit.framework.Assert;
import junit.framework.TestCase;
import android.os.AsyncTask;

import com.greenflag.television.domain.Channel;
import com.greenflag.television.domain.DomainHelper;
import com.greenflag.utils.http.DownloadStringTask;

public class DomainHelperTests extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}
	public void testGetChannelsFromJsonResponse() throws MalformedURLException, InterruptedException, ExecutionException, JSONException{
		DownloadStringTask target = new DownloadStringTask();
		URL requestUrl = new URL("http://channels.apiary.io/channels");
		URL[] params = new URL[]{ requestUrl };
		AsyncTask<URL, Boolean, String> task = target.execute(params);
		String response = task.get().toString();
		List<Channel> actual = DomainHelper.getChannelsFromJsonResponse(response);
		Assert.assertTrue(actual.size()>0);
	}
	
	
}
