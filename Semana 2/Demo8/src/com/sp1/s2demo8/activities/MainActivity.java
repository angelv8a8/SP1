package com.sp1.s2demo8.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.sp1.s2demo8.R;
import com.sp1.s2demo8.R.id;
import com.sp1.s2demo8.R.layout;
import com.sp1.s2demo8.R.string;
import com.sp1.s2demo8.fragments.CountriesFlagFragment;
import com.sp1.s2demo8.fragments.CountriesListFragment;


public class MainActivity extends ActionBarActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	
	}

}