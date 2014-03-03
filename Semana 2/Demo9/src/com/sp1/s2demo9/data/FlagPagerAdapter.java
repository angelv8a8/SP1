package com.sp1.s2demo9.data;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sp1.s2demo9.R;
import com.sp1.s2demo9.fragments.FlagFragment;

public class FlagPagerAdapter extends FragmentPagerAdapter {

	


	int[] arrayFlags = new int[]
			{
				R.drawable.guatemala,
				R.drawable.brazil,
				R.drawable.mexico
			};
	
	public FlagPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		
		Fragment fragment = new FlagFragment();
		Bundle args = new Bundle();
		args.putInt(FlagFragment.RESOURCE, arrayFlags[arg0]);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public int getCount() {
		return arrayFlags.length;
	}

}
