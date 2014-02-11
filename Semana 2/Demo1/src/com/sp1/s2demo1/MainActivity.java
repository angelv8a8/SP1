package com.sp1.s2demo1;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		String[] p = {"Guatemala","Brasil","Mexico"};
		
		ArrayList<String> lista = new ArrayList<String>(Arrays.asList(p));
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
																android.R.layout.simple_list_item_1,
																lista);
		
		ListView listaV = (ListView)findViewById(android.R.id.list);
		
		listaV.setAdapter(adapter);
		
		
		listaV.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View v, int pos,
					long arg3) {
				
				
			String pais = adapterView.getItemAtPosition(pos).toString();
			Intent intent = new Intent(getApplicationContext(), CountryDetailActivity.class);
			
			intent.putExtra(CountryDetailActivity.COUNTRY_NAME, pais);
			startActivity(intent);
			
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
