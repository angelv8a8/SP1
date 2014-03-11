package com.sp1.tarea2.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sp1.tarea2.R;

public class ImagenFragment extends Fragment{

	public final static String RESOURCE = "resource";
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.imagen_fragment , null);
		
		ImageView imageView =(ImageView) view.findViewById(R.id.imageView);
		
		Bundle args = getArguments();
		imageView.setImageResource(args.getInt(RESOURCE));
		
		return view;
	}
}
