package com.sp1.tarea2;

import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sp1.tarea2.fragments.ComunidadFragment;
import com.sp1.tarea2.fragments.ImagenesFragment;
import com.sp1.tarea2.fragments.TiendasListAndMapFragment;

public class MainActivity extends  ActionBarActivity implements OnItemClickListener{

	private ListView drawerList;
	private DrawerLayout drawerLayout;

	private String[] drawerOptions;
	
	private ActionBarDrawerToggle drawerToggle;
	
	private Fragment[] fragments = new Fragment[]{
		new TiendasListAndMapFragment(),
		new ImagenesFragment(),
		new ComunidadFragment()
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
	        		.add(R.id.contentFrame, fragments[2])
	        		.hide(fragments[1]).hide(fragments[2])
	        	    .commit();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}
	

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
	

	public void setContent(int pos) {
		
		ActionBar actionBar = getSupportActionBar(); 
		actionBar.setTitle(drawerOptions[pos]);
		
		FragmentManager fm = getSupportFragmentManager();
		
		FragmentTransaction ft = fm.beginTransaction();
		
		Fragment toHide = null;
		Fragment toShow = null;
		switch (pos) {
			case 0:
				ft.show( fragments[0]);
				ft.hide(fragments[1]);
				ft.hide(fragments[2]);
				actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
				break;
			case 1:
				ft.hide( fragments[0]);
				ft.show(fragments[1]);
				ft.hide(fragments[2]);
				actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
				break;
				
			case 2:
				ft.hide( fragments[0]);
				ft.hide(fragments[1]);
				ft.show(fragments[2]);
				actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
				break;
		}
		
		
		ft.commit();
		drawerList.setItemChecked(pos, true);
		drawerLayout.closeDrawer(drawerList);
	}
	
	

	class DrawerItemClickListener implements ListView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> adapter, View view, int pos,
				long arg3) {

			setContent(pos);

		}

	}

		
}
