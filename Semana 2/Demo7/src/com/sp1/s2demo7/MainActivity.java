package com.sp1.s2demo7;

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

import com.sp1.s2demo7.fragments.CountriesFlagFragment;
import com.sp1.s2demo7.fragments.CountriesListFragment;


public class MainActivity extends ActionBarActivity implements TabListener {
	Fragment[] fragments = new Fragment[]{new CountriesListFragment(), 
	          						      new CountriesFlagFragment()};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		fragments[0].setHasOptionsMenu(true);

		final ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        actionBar.addTab(
                actionBar.newTab()
                        .setText(getResources().getString(R.string.title_fragment_list ))
                        .setTabListener(this));
        
        actionBar.addTab(
                actionBar.newTab()
                        .setText(getResources().getString(R.string.title_fragment_banderas))
                        .setTabListener(this));  
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
        	    .add(R.id.main_content, fragments[0])
        		.add(R.id.main_content, fragments[1])        		        	   
        	    .commit();
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {	
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction arg1) {
		setContent(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
	}

	public void setContent(int tab) {		
		Fragment toHide = null;
		Fragment toShow = null;
		switch (tab) {
			case 0:
				toHide = fragments[1];
				toShow = fragments[0];
				break;
			case 1:
				toHide = fragments[0];
				toShow = fragments[1];
				break;
		}

		FragmentManager manager = getSupportFragmentManager();

		manager.beginTransaction()
				.hide(toHide)
				.show(toShow)
				.commit();
	}

}