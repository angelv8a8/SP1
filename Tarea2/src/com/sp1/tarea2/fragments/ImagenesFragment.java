package com.sp1.tarea2.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sp1.tarea2.R;
import com.sp1.data.*;

public class ImagenesFragment extends Fragment {

	ViewPager viewPager;


	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		ImagenesPagerAdapter adapter = new ImagenesPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.tiendas_imagenes_fragment, container, false);
		viewPager = (ViewPager) view.findViewById(R.id.pager);
		return view;
	}
	
	
}
