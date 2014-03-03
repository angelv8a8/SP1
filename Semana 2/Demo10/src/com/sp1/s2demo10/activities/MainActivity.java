package com.sp1.s2demo10.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sp1.s2demo10.R;
import com.sp1.s2demo10.fragments.CountriesContentFragment;
import com.sp1.s2demo10.fragments.FragmentAbout;

public class MainActivity extends ActionBarActivity {

	private ListView drawerList;
	private DrawerLayout drawerLayout;

	private String[] drawerOptions;
	
	private ActionBarDrawerToggle drawerToggle;
	
	private Fragment[] fragments = new Fragment[]{
		new CountriesContentFragment(),
		new FragmentAbout()
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		drawerList = (ListView) findViewById(R.id.leftDrawer);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
		drawerOptions = getResources().getStringArray(R.array.drawer_options);

		drawerList.setAdapter(new ArrayAdapter<String>(this,
				R.layout.drawer_list_item, drawerOptions));

		drawerList.setItemChecked(0, true);
		drawerList.setOnItemClickListener(new DrawerItemClickListener());
		
		drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, 
												R.drawable.ic_drawer	,
												R.string.drawer_open,
												R.string.drawer_close
												)
		{
			@Override
			public void onDrawerClosed(View drawerView) {
				ActivityCompat.invalidateOptionsMenu(MainActivity.this);
			}
			
			@Override
			public void onDrawerOpened(View drawerView) {
				ActivityCompat.invalidateOptionsMenu(MainActivity.this);
			}
		};
		
		drawerLayout.setDrawerListener(drawerToggle);
		
		ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setTitle(drawerOptions[0]);
        
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
		
		FragmentManager manager = getSupportFragmentManager();
	        manager.beginTransaction()
	        	    .add(R.id.contentFrame, fragments[0])
	        		.add(R.id.contentFrame, fragments[1])        		
	        		.hide(fragments[1])
	        	    .commit();
        
	}

	public void setContent(int pos) {
		
		ActionBar actionBar = getSupportActionBar(); 
		actionBar.setTitle(drawerOptions[pos]);
		
		Fragment toHide = null;
		Fragment toShow = null;
		switch (pos) {
			case 0:
				toHide = fragments[1];
				toShow = fragments[0];
				actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
				break;
			case 1:
				toHide = fragments[0];
				toShow = fragments[1];
				actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
				break;
		}
		
		FragmentManager fm = getSupportFragmentManager();
		
		fm.beginTransaction().hide(toHide).show(toShow).commit();
		drawerList.setItemChecked(pos, true);
		drawerLayout.closeDrawer(drawerList);
	}
	
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		drawerToggle.syncState();
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		
		drawerToggle.onConfigurationChanged(newConfig);
	}
	
	public boolean onItemOptionsSelceted(MenuItem item)
	{
		if(item.getItemId()== android.R.id.home)
		{
			if(drawerLayout.isDrawerOpen(drawerList))
			{
				drawerLayout.closeDrawer(drawerList);
			}
			else 
			{
				drawerLayout.openDrawer(drawerList);
			}
		}
		return true;
	}

	class DrawerItemClickListener implements ListView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> adapter, View view, int pos,
				long arg3) {

			setContent(pos);

		}

	}

}