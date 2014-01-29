package com.example.demo5;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.sax.TextElementListener;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button btnSearch;
	Button btnList;
	Button btnOpenActivity;
	ScrollView inputControls= null;
	private String TAG = MainActivity.class.toString(); 
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnSearch = (Button)findViewById(R.id.btnSearch);
        btnOpenActivity = (Button)findViewById(R.id.btnOpenActivity);
        
        /*
        ButtonListener Lisener = new ButtonListener();
        btnSearch.setOnClickListener(Lisener);
        btnOpenActivity.setOnClickListener(Lisener);
        
        Button btnList = new Button(this);
        btnList.setText(R.string.btn_list);
        btnList.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 
        										 LayoutParams.WRAP_CONTENT));
        
        */
        btnList = new Button(this);
        
        
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.mainActivity);
        
        inputControls = (ScrollView) View.inflate(this, R.layout.input_controls_content, null);
        
        
        //linearLayout.addView(btnList);
        
        
        setInputControls();
        linearLayout.addView(inputControls);
    }


    private void setInputControls() {
		
    	SeekBar slider = (SeekBar)inputControls.findViewById(R.id.seekBar1);
    	RatingBar estrellas = (RatingBar)inputControls.findViewById(R.id.ratingBar1 );
    	Spinner spinner = (Spinner)inputControls.findViewById(R.id.spinner1 );
    	CheckBox checkbox = (CheckBox)inputControls.findViewById(R.id.checkBox1 );
    	RadioGroup radioGroup = (RadioGroup)inputControls.findViewById(R.id.radioGroup1 );
    	
    	
    	estrellas.setRating((float)2.5);
    	
    	ArrayList<String> nombres = new ArrayList<String>();
    	nombres.add("Hugo");
    	nombres.add("Paco");
    	nombres.add("Luis");
    	nombres.add("Miguelito");
    	
    	
    	ArrayAdapter<String> nombresAdaptador = new ArrayAdapter<String>(this, 
    															android.R.layout.simple_spinner_dropdown_item, nombres);    	
    	spinner.setAdapter(nombresAdaptador);
    	
    	checkbox.setChecked(true);
    	
    	radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				
				String seleccion = "";
				switch (checkedId)
				{
				case R.id.radio0:
					seleccion = "A";
					break;
				case R.id.radio1:
					seleccion = "B";
					break;
				case R.id.radio2:
					seleccion = "C";
					break;
				}
				
				EditText txt = (EditText)findViewById(R.id.editText1);
				txt.setText(seleccion);
				
			}
		});
    	
    	slider.setMax(10);
    	slider.setProgress(5);
    
    	slider.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				
				Toast.makeText(getApplicationContext(), "Cambio a " + progress,  Toast.LENGTH_SHORT).show();
				CheckBox checkbox = (CheckBox)inputControls.findViewById(R.id.checkBox1 );
		    	
				if(progress<3)
					checkbox.setChecked(false);
				else
					checkbox.setChecked(true);
				
			}
		});
    	
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    class ButtonListener implements OnClickListener
    {

		@Override
		public void onClick(View v) {
			//Toast.makeText(getApplicationContext(),"hizo click", Toast.LENGTH_SHORT).show();
			
			EditText inputQuery = (EditText)findViewById(R.id.editTextSearchQuery);
			String searchString = inputQuery.getText().toString();
			Intent intent = null;
			if(v.getId() == R.id.btnSearch)
			{
				intent = new Intent(getApplicationContext(), ShowSearchQueryActivity.class);
				//Log.i(TAG, "TEXTO:" + inputQuery.getText().toString());
				intent.putExtra(ShowSearchQueryActivity.QUERY, searchString);
				
			}
			if(v.getId() == R.id.btnList)
			{
				intent = new Intent(getApplicationContext(), EmailActivity.class);
				
			}
			else if (v.getId() == R.id.btnOpenActivity )
			{
				String url = "https://www.google.com/?q=" + searchString + "#q=" + searchString;
				intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse( url));
				
			}
			startActivity(intent);
		}
    	
    }
    
}


