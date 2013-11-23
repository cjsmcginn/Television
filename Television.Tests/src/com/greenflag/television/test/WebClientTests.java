package com.greenflag.television.test;

import java.util.concurrent.ExecutionException;

import junit.framework.Assert;
import junit.framework.TestCase;
import android.os.AsyncTask;
import android.util.Log;

import com.greenflag.utils.http.WebClient;

public class WebClientTests extends TestCase {
	private WebClient wc;
	protected void setUp() throws Exception {
		super.setUp();
		wc=new WebClient();
	}

	public void testSync(){
		Assert.assertNotNull("Target is null", wc);
	}

	public void testDoInBackground() throws InterruptedException, ExecutionException{
		String[] params = new String[]{"http://google.com"};
		AsyncTask<String, Void, String> task = wc.execute(params);
		String actual = task.get().toString();
		Log.i("Tests", actual);
		Assert.assertNotNull(actual);
		
	}
}
