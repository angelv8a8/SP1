package com.sp1.s2demo7.data;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sp1.s2demo7.R;
import com.sp1.s2demo7.fragments.FlagFragment;

public class FlagPagerAdapter extends FragmentPagerAdapter {

	public FlagPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {

		int[] arrayFlags = new int[]
				{
					R.drawable.guatemala,
					R.drawable.brazil,
					R.drawable.mexico
				};
		
		Fragment frag = new FlagFragment();
		Bundle args = new Bundle();
		args.putInt(FlagFragment.RESOURCE, arrayFlags[arg0]);
		frag.setArguments(args);
		return frag;
	}

	@Override
	public int getCount() {
		return 3;
	}

}
