package com.sp1.s2demo5;

import java.util.ArrayList;
import java.util.Arrays;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

	
	String pais = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		String[] p = { "Guatemala", "Brasil", "Mexico" };

		ArrayList<String> lista = new ArrayList<String>(Arrays.asList(p));

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, lista);

		ListView listaV = (ListView) findViewById(R.id.lista);

		listaV.setAdapter(adapter);

		listaV.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View v,
					int pos, long arg3) {

				pais = adapterView.getItemAtPosition(pos).toString();
			
				if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

					FragmentManager manager = getSupportFragmentManager();
					
					CountryInfoFragment frag = (CountryInfoFragment)manager.findFragmentById(R.id.fragmentCountryInfo);
					
					frag.loadWebViewContent(pais);
					
				} else {
					Intent intent = new Intent(getApplicationContext(),
							CountryDetailActivity.class);

					intent.putExtra(CountryDetailActivity.COUNTRY_NAME, pais);
					startActivity(intent);
				}
			}
		});
		
		registerForContextMenu(listaV);
		
		
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
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
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_share:
			
			if(!this.pais.equals(""))
			{
				String url  = "http://es.m.wikipedia.org/wiki/"+ pais;
				String message =getString( R.string.msg_share, pais, url);
				Intent share = new Intent();
				share.setAction(Intent.ACTION_SEND);
				share.putExtra(Intent.EXTRA_TEXT, message);
				share.setType("text/plain");
				startActivity(Intent.createChooser(share, getString(R.string.action_share)));
			}
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
		
		
		
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {

		
		super.onCreateContextMenu(menu, v, menuInfo);
		
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
		
		pais = ((TextView)info.targetView).getText().toString();
		getMenuInflater().inflate(R.menu.main, menu);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		
		return onOptionsItemSelected(item);	
	}

}
