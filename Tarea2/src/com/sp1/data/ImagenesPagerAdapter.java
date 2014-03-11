package com.sp1.data;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sp1.tarea2.fragments.ImagenFragment;

public class ImagenesPagerAdapter extends FragmentPagerAdapter {
	
	public ImagenesPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		
		int[] arrayFlags = dataAccess.getTiendasImagesIds();
		Fragment fragment = new ImagenFragment();
		Bundle args = new Bundle();
		args.putInt(ImagenFragment.RESOURCE,  arrayFlags[arg0]);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public int getCount() {
		return dataAccess.getTiendasImagesIds().length;
	}

}
