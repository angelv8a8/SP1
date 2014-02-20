package com.sp1.s2demo7;

import android.R.anim;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.sp1.s2demo7.fragments.CountriesFlagFragment;
import com.sp1.s2demo7.fragments.CountriesListFragment;


public class MainActivity extends ActionBarActivity implements TabListener{

	Fragment[] fragments ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Fragment flags = new CountriesFlagFragment();
		
		android.support.v4.view.ViewPager vp = new ViewPager(getApplicationContext());
		vp.setId(555);
		vp.setLayoutParams(ViewGroup.);
		
		fragments = new Fragment[]{ new CountriesListFragment(), 
				 flags};
		
		ActionBar actionBar = getSupportActionBar();
		
		FragmentManager manager = getSupportFragmentManager();
		
		manager.beginTransaction().add(R.id.main_content, fragments[0]).commit();
		
		
		
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.addTab(
				actionBar.newTab().setText(getString(R.string.title_fragment_list)).setTabListener(this));
		actionBar.addTab(
				actionBar.newTab().setText(getString(R.string.title_fragment_banderas)).setTabListener(this));
		
		/*
		TabListener tl = new TabListener() {
			
			@Override
			public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
				Toast.makeText(getApplicationContext(), arg0.getText().toString(), Toast.LENGTH_SHORT).show();
				
			}
			
			@Override
			public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
				// TODO Auto-generated method stub
				
			}
		};
		
		for(int i = 0; i < 10; i ++)
		{
			actionBar.addTab(
					actionBar.newTab().setText("Tab" + i).setTabListener(tl)); 
		}
		
		*/
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		
		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
			MenuItem itm = menu.getItem(menu.size() - 1);
			itm.setVisible(false);
		}
		return super.onPrepareOptionsMenu(menu);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction arg1) {
		
		Fragment toHide = null;
		Fragment toShow = null;
		
		switch (tab.getPosition()) {
		case 0:
			toHide = fragments[1];
			toShow = fragments[0];
			break;

		case 1:
			toHide = fragments[0];
			toShow = fragments[1];
			break;
		}
		
		arg1.hide(toHide).show(toShow).commit();
	
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
}
