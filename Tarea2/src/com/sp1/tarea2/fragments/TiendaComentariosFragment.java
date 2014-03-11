package com.sp1.tarea2.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sp1.businessObjects.Tienda;
import com.sp1.tarea2.DetalleTiendaActivity;
import com.sp1.tarea2.R;
import com.sp1.tarea2.TiendaImagenActivity;

public class TiendaComentariosFragment extends Fragment {

	Tienda tienda;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {

		Activity ac = getActivity();
		if (ac instanceof DetalleTiendaActivity ) {
			tienda = ((DetalleTiendaActivity) getActivity()).getTienda();

			LinearLayout ll = (LinearLayout) getActivity().findViewById(R.id.lista_comentarios);
			
			for (String comentario : tienda.getComentarios()) {

				TextView tv = new TextView(getActivity().getApplicationContext());
				tv.setText(comentario);
				ll.addView(tv);
			}			
		}
		else if(ac instanceof TiendaImagenActivity  )
		{
			tienda = ((TiendaImagenActivity) getActivity()).getTienda();

			LinearLayout ll = (LinearLayout) getActivity().findViewById(R.id.lista_comentarios);
			
			for (String comentario : tienda.getComentarios()) {

				TextView tv = new TextView(getActivity().getApplicationContext());
				tv.setText(comentario);
				ll.addView(tv);
			}	
		}
		
		
		
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		View view = inflater
				.inflate(R.layout.tienda_comentarios_fragment, null);

		return view;

	}

}
