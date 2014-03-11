package com.sp1.tarea2.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sp1.tarea2.MainActivity;
import com.sp1.tarea2.R;

public class TiendasListAndMapFragment extends Fragment  implements TabListener{

	
	private Fragment[] fragments = new Fragment[]{
		new TiendasListaFragment(),
		new TiendasMapaFragment()
	};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		fragments[0].setHasOptionsMenu(true);

		final ActionBar actionBar = ((MainActivity)getActivity()).getSupportActionBar();
	
        actionBar.addTab(
                actionBar.newTab()
                        .setText(getResources().getString(R.string.title_fragment_list ))
                        .setTabListener(this));
        
        actionBar.addTab(
                actionBar.newTab()
                        .setText(getResources().getString(R.string.title_fragment_map))
                        .setTabListener(this));  
        FragmentManager manager =  ((MainActivity)getActivity()).getSupportFragmentManager();
        manager.beginTransaction()
        	    .add(R.id.listMapContent, fragments[0])
        		.add(R.id.listMapContent, fragments[1]).hide(fragments[1]).show(fragments[0])        		        	   
        	    .commit();
		
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.tiendas_list_map_fragment, null);
		return view;
	}
	

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction arg1) {
		
		FragmentManager manager =  ((MainActivity)getActivity()).getSupportFragmentManager();
        
		switch(tab.getPosition())
		{
			case 0:
				manager.beginTransaction()
		        	    .hide(fragments[1]).show(fragments[0])        		        	   
		        	    .commit();
				break;
				
			case 1:
				manager.beginTransaction()
		        	    .hide(fragments[0]).show(fragments[1])        		        	   
		        	    .commit();
				break;
		
		}
		
		    
		
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		
	}
	
	
	
}
