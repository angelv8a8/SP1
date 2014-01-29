package com.example.demo5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class ShowSearchQueryActivity extends Activity {

	public static final String QUERY = "query";
	
	
	private static final String TAG = ShowSearchQueryActivity.class.toString();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_search_query);
		
		Intent intent = getIntent();
		
		String query = intent.getStringExtra(QUERY);
		
		if(query != null)
		{
			Log.i(TAG, query);
			TextView textView = (TextView)findViewById(R.id.textView1);
			textView.setText(query);
			
		}else
		{
			Log.i(TAG, "No query");
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_search_query, menu);
		return true;
	}

}
