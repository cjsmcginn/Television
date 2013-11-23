package com.greenflag.utils.http.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import junit.framework.Assert;
import junit.framework.TestCase;
import android.os.AsyncTask;
import android.util.Log;

import com.greenflag.utils.http.DownloadStringTask;

public class DownloadStringTaskTests extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testDoInBackground() throws MalformedURLException, InterruptedException, ExecutionException {
		DownloadStringTask target = new DownloadStringTask();
		URL requestUrl = new URL("http://channels.apiary.io/channels");
		URL[] params = new URL[]{ requestUrl };
		AsyncTask<URL, Void, String> task = target.execute(params);
		String actual = task.get().toString();
		Log.i("Tests", actual);
		Assert.assertNotNull(actual);
	}

}
