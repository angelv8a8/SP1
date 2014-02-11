package com.sp1.s2demo2;

import com.sp1.s2demo1.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class CountryDetailActivity extends FragmentActivity {

	private static String pais = "";
	public static final String COUNTRY_NAME = "pais";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_country_detail);
		
		pais = getIntent().getStringExtra(this.COUNTRY_NAME);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.country_detail, menu);
		return true;
	}
	
	public static String getPais()
	{
		return pais; 
	}

}
