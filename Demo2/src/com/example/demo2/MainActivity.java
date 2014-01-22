package com.example.demo2;

import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button btnSearch;
	Button btnOpenActivity;
	
	private String TAG = MainActivity.class.toString(); 
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnSearch = (Button)findViewById(R.id.btnSearch);
        btnOpenActivity = (Button)findViewById(R.id.btnOpenActivity);
        
        ButtonListener Lisener = new ButtonListener();
        btnSearch.setOnClickListener((android.view.View.OnClickListener) Lisener);
        btnOpenActivity.setOnClickListener((android.view.View.OnClickListener) Lisener);
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
    	public void onClick(DialogInterface dialog, int which) {
    		Log.i(TAG,"hay click!!!");
    		
    		Toast.makeText(getApplicationContext(),"hizo click", Toast.LENGTH_SHORT).show();
    		
    	}
    	
    }
    
}


