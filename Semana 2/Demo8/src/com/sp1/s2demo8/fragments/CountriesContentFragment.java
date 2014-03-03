package com.sp1.s2demo8.fragments;

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

import com.sp1.s2demo8.R;
import com.sp1.s2demo8.activities.MainActivity;

public class CountriesContentFragment extends Fragment implements TabListener { 

	Fragment[] fragments = new Fragment[]{new CountriesListFragment(), 
	          						      new CountriesFlagFragment()};
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	 
		 return inflater.inflate(R.layout.fragment_countries_content, container, false);
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
                        .setText(getResources().getString(R.string.title_fragment_banderas))
                        .setTabListener(this));  
        FragmentManager manager =  ((MainActivity)getActivity()).getSupportFragmentManager();
        manager.beginTransaction()
        	    .add(R.id.main_content, fragments[0])
        		.add(R.id.main_content, fragments[1])        		        	   
        	    .commit();

		
	}

	
	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {	
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		
		Fragment toHide = null;
		Fragment toShow = null;
		switch (tab.getPosition() ) {
			case 0:
				toHide = fragments[1];
				toShow = fragments[0];
				break;
			case 1:
				toHide = fragments[0];
				toShow = fragments[1];
				break;
		}
		ft.hide(toHide);
		ft.show(toShow);
		
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction ft) {
	}

	public void setContent(int tab) {		

	}

}