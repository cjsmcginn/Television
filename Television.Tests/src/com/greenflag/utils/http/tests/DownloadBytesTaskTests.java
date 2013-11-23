package com.greenflag.utils.http.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import junit.framework.Assert;
import junit.framework.TestCase;
import android.os.AsyncTask;
import android.util.Log;

import com.greenflag.utils.http.DownloadBytesTask;

public class DownloadBytesTaskTests extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testDoInBackground() throws MalformedURLException, InterruptedException, ExecutionException {
		DownloadBytesTask target = new DownloadBytesTask();
		URL requestUrl = new URL("http://www.petfinder.com/wp-content/uploads/2012/11/99059361-choose-cat-litter-632x475.jpg");
		URL[] params = new URL[]{ requestUrl };
		AsyncTask<URL, Boolean, byte[]> task = target.execute(params);
		byte[] actual = task.get();
		Log.i("Tests", String.valueOf(actual.length));
		Assert.assertTrue(actual.length>0);
	}

}
