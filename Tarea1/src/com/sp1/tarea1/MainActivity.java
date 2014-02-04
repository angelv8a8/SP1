package com.sp1.tarea1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.SimpleAdapter;

import com.sp1.businessObjects.Tienda;
import com.sp1.data.dataAccess;

public class MainActivity extends ListActivity {

	
	private final String NOMBRE = "nombre";
	private final String ID = "id";
	List<HashMap<String, String>> tiendas = new ArrayList<HashMap<String, String>> ();
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		List<Tienda> tiendasLista = dataAccess.getTinedas();
		
		for (Tienda laTienda : tiendasLista) {
			HashMap<String,String> aux= new HashMap<String,String>();
			
			aux.put(NOMBRE, laTienda.getNombre());
			aux.put(ID, String.valueOf(laTienda.getID()));
			
			tiendas.add(aux);
			
			SimpleAdapter adapter = (SimpleAdapter)getListAdapter();
			adapter.notifyDataSetChanged();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		SimpleAdapter adapter = new SimpleAdapter(this, tiendas, 
				android.R.layout.simple_expandable_list_item_2 , 
				new String[]{NOMBRE,ID}, 
				new int[]{android.R.id.text1, android.R.id.text2}
		);
		setListAdapter(adapter);
		
		return true;
		
	}
	
	

}
