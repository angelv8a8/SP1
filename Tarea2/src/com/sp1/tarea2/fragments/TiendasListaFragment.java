package com.sp1.tarea2.fragments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.sp1.businessObjects.Tienda;
import com.sp1.data.dataAccess;
import com.sp1.tarea2.DetalleTiendaActivity;
import com.sp1.tarea2.R;

public class TiendasListaFragment extends Fragment{

	private final String NOMBRE = "nombre";
	private final String ID = "id";
	private final String DIRECCION = "direccion";
	List<HashMap<String, String>> tiendas = new ArrayList<HashMap<String, String>>();

	private ListView list;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {

		
		
		SimpleAdapter adapter = new SimpleAdapter(getActivity()
				.getApplicationContext(), tiendas,
				android.R.layout.simple_expandable_list_item_2, new String[] {
						NOMBRE, DIRECCION }, new int[] { android.R.id.text1,
						android.R.id.text2 });
		
		
		list.setAdapter(adapter);
		
		List<Tienda> tiendasLista = dataAccess.getTinedas();

		for (Tienda laTienda : tiendasLista) {

			HashMap<String, String> aux = new HashMap<String, String>();

			aux.put(NOMBRE, laTienda.getNombre());
			aux.put(DIRECCION, String.valueOf(laTienda.getDireccion()));
			aux.put(ID, String.valueOf(laTienda.getID()));

			tiendas.add(aux);

		}

		list.setOnItemClickListener(listListener);

		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.tiendas_list_fragment,
				container, false);

		list = (ListView) view.findViewById(R.id.lista);

		return view;
	}
	


	OnItemClickListener listListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
		
			HashMap<String,String>  tienda = tiendas.get(arg2);
			
			//Intent intent = null;
			Intent intent =  new Intent(getActivity(),  DetalleTiendaActivity.class);
			//intent = new Intent(  getActivity().getApplicationContext(),  DetalleTiendaFragment.class);
			//Toast.makeText(getActivity(), "Tienda " + tienda.toString(), Toast.LENGTH_LONG).show();
			intent.putExtra(DetalleTiendaActivity.TIENDA_ID, tienda.get(ID));
			
			startActivity(intent);
			
		}
	};


}
