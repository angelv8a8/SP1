package com.sp1.s2demo6.fragments;

import java.util.ArrayList;
import java.util.Arrays;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sp1.s2demo6.R;
import com.sp1.s2demo6.activities.CountryDetailActivity;


public class CountriesListFragment extends Fragment implements
													OnItemClickListener {

	String pais = "";
	ListView  list  ;
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		
		
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		String[] p = { "Guatemala", "Brasil", "Mexico" };

		ArrayList<String> lista = new ArrayList<String>(Arrays.asList(p));

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, lista);

		//ListView listaV = (ListView) findViewById(R.id.lista);

		list.setAdapter(adapter);

		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View v,
					int pos, long arg3) {

				pais = adapterView.getItemAtPosition(pos).toString();
			
				if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

					FragmentManager manager = getActivity().getSupportFragmentManager();
					
					CountryInfoFragment frag = (CountryInfoFragment)manager.findFragmentById(R.id.fragmentCountryInfo);
					
					frag.loadWebViewContent(pais);
					
				} else {
					Intent intent = new Intent(getActivity().getApplicationContext(),
							CountryDetailActivity.class);

					intent.putExtra(CountryDetailActivity.COUNTRY_NAME, pais);
					startActivity(intent);
				}
			}
		});
		
		//registerForContextMenu(lista);
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view =inflater.inflate(R.layout.fragment_countries_list, container, false);
		
		list = (ListView)view.findViewById(R.id.lista);
		return view;
	}

	@Override
	public void onPrepareOptionsMenu(Menu menu) {
		
		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
			MenuItem itm = menu.getItem(menu.size() - 1);
			itm.setVisible(false);
		}
		super.onPrepareOptionsMenu(menu);
	}
	
	
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// Inflate the menu; this adds items to the action bar if it is present.
		inflater.inflate(R.menu.main, menu);
	
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
		getActivity().getMenuInflater().inflate(R.menu.main, menu);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		
		return onOptionsItemSelected(item);	
	}
	

}
