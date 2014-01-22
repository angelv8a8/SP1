package com.example.demo3;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
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
        btnSearch.setOnClickListener(Lisener);
        btnOpenActivity.setOnClickListener(Lisener);
        
        Button btnList = new Button(this);
        btnList.setText(R.string.btn_list);
        btnList.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 
        										 LayoutParams.WRAP_CONTENT));
        
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.mainActivity);
        
        LinearLayout inputControls = (LinearLayout) View.inflate(this, R.layout.input_controls_content, null);
        
        
        linearLayout.addView(btnList);
        linearLayout.addView(inputControls);
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


