package com.sp1.s2demo2;

import java.util.ArrayList;
import java.util.Arrays;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sp1.s2demo1.R;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		String[] p = { "Guatemala", "Brasil", "Mexico" };

		ArrayList<String> lista = new ArrayList<String>(Arrays.asList(p));

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, lista);

		ListView listaV = (ListView) findViewById(R.id.lista);

		listaV.setAdapter(adapter);

		listaV.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View v,
					int pos, long arg3) {

				String pais = adapterView.getItemAtPosition(pos).toString();
			
				if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

					FragmentManager manager = getSupportFragmentManager();
					
					CountryInfoFragment frag = (CountryInfoFragment)manager.findFragmentById(R.id.fragmentCountryInfo);
					
					frag.loadWebViewContent(pais);
					
				} else {
					Intent intent = new Intent(getApplicationContext(),
							CountryDetailActivity.class);

					intent.putExtra(CountryDetailActivity.COUNTRY_NAME, pais);
					startActivity(intent);
				}
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
