package com.greenflag.television;

import java.net.URL;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.widget.VideoView;

public class DetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		Intent intent = getIntent();
		VideoView v = (VideoView)findViewById(R.id.videoView);
		Uri source = Uri.parse("http://pseudo01.hddn.com/vod/demo.flowplayervod/bbb-800.mp4");
		v.setVideoURI(source);
		v.start();
/*		URL source = new URL("http://www.youtube.com/embed/lt416kX0tMY");
		*/
		/*MediaPlayer mediaPlayer = new MediaPlayer();
		mediaPlayer.set*/
		//String videoUrl = intent.
		//Log.i("Television",videoUrl);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detail, menu);
		return true;
	}

}
