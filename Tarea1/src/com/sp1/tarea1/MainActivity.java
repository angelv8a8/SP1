package com.sp1.tarea1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.sp1.businessObjects.Tienda;
import com.sp1.data.dataAccess;

public class MainActivity extends  ListActivity{

	
	private final String NOMBRE = "nombre";
	private final String ID = "id";
	private final String DIRECCION = "direccion";
	List<HashMap<String, String>> tiendas = new ArrayList<HashMap<String, String>> ();
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		SimpleAdapter adapter = new SimpleAdapter(this, tiendas, 
				android.R.layout.simple_expandable_list_item_2 , 
				new String[]{NOMBRE,DIRECCION}, 
				new int[]{android.R.id.text1, android.R.id.text2}
		);
		setListAdapter(adapter);
		
		List<Tienda> tiendasLista = dataAccess.getTinedas();
		
		for (Tienda laTienda : tiendasLista) {
			
			HashMap<String,String> aux= new HashMap<String,String>();
			
			aux.put(NOMBRE, laTienda.getNombre());
			aux.put(DIRECCION, String.valueOf(laTienda.getDireccion()));
			aux.put(ID, String.valueOf(laTienda.getID()));
			
			tiendas.add(aux);
			
			
		}
		SimpleAdapter adapter2 = (SimpleAdapter)getListAdapter();
		adapter2.notifyDataSetChanged();
		
		ListView lv = (ListView)findViewById(android.R.id.list);
		lv.setOnItemClickListener(listListener);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		
		return true;
		
	}

	OnItemClickListener listListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
		
			HashMap<String,String>  tienda = tiendas.get(arg2);
			
			Intent intent = null;
			intent = new Intent(getApplicationContext(), DetalleTienda.class);
			//Log.i(TAG, "TEXTO:" + inputQuery.getText().toString());
			intent.putExtra(DetalleTienda.TIENDA_ID, tienda.get(ID));
			startActivity(intent);
			
		}
	};
	

	
	
}
