package com.example.demo5;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class EmailActivity extends ListActivity implements OnClickListener {

	
	private final String EMAIL = "email";
	private final String DATE_ADDED = "date";
	private final List<HashMap<String , String>> emails = new ArrayList<HashMap<String, String>>();  	
	
	@Override
	public void onClick(View arg0) {
		
		EditText editTextEmail = (EditText)findViewById(R.id.editTextEmail);
		String email = editTextEmail.getText().toString();
		
		HashMap<String, String> elemento = new HashMap<String, String>();
		elemento.put(EMAIL, email);
		elemento.put(DATE_ADDED, new SimpleDateFormat("dd/MM/yyyy HH:mm",Locale.getDefault()).format(Calendar.getInstance().getTime()));

		
		if(!email.trim().equals(""))
		{
			if(Patterns.EMAIL_ADDRESS.matcher(email).matches())
			{
			emails.add(elemento);	

			SimpleAdapter adapter = (SimpleAdapter)getListAdapter();
			adapter.notifyDataSetChanged();
			}
			else
			{
				Toast.makeText(this, "Correo invalido", Toast.LENGTH_SHORT).show();
			}
			
		}
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_email_list);
		
		Button btnAdd = (Button)findViewById(R.id.btnAdd);
		btnAdd.setOnClickListener(this);
		
		SimpleAdapter adapter = new SimpleAdapter(this, emails, 
									android.R.layout.simple_expandable_list_item_2 , 
									new String[]{EMAIL, DATE_ADDED}, 
									new int[]{android.R.id.text1, android.R.id.text2}
		);
		setListAdapter(adapter);
		
	}

}
