package com.sp1.tarea2;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.sp1.businessObjects.Tienda;
import com.sp1.data.dataAccess;

public class TiendaImagen extends Activity {

	
	Tienda tienda;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tienda_imagen);
		// Show the Up button in the action bar.
		setupActionBar();
	

		int ID = getIntent().getIntExtra(DetalleTienda.TIENDA_ID, 0);
		
		//int ID = getIntent().getStringExtra(DetalleTienda.TIENDA_ID).toString();
		tienda = dataAccess.getTienda(ID);
		Resources res = getResources();
		String mDrawableName = tienda.getImage();
		int resID = res.getIdentifier(mDrawableName , "drawable", getPackageName());
		Drawable drawable = res.getDrawable(resID );
		ImageView iv = (ImageView)findViewById(R.id.imageTienda);
		iv.setImageDrawable(drawable);
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tienda_imagen, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		case R.id.action_compartir_imagen:
			if(tienda != null)
			{
				Intent share = new Intent();
				share.setAction(Intent.ACTION_SEND);
				//share.putExtra(Intent.EXTRA_TEXT, message);
				
				String mDrawableName = tienda.getImage();
				Resources res = getResources();
				int resID = res.getIdentifier(mDrawableName , "drawable", getPackageName());
				Drawable drawable = res.getDrawable(resID );
				
				ImageView iv = (ImageView)findViewById(R.id.imageTienda);
				iv.setImageDrawable(drawable);
				
				
				Uri uri = Uri.parse("http://www.compulab.com.pa/files/6eef2b0f03c57b9f7d80bbffae2d68c0.jpg");
				share.putExtra(Intent.EXTRA_STREAM, uri);
		        
				share.setType("image/jpeg");
				startActivity(Intent.createChooser(share, getString(R.string.action_compartir)));
			}
			return true;
		case R.id.action_favorito:
			tienda.setEsFavorito(!tienda.isEsFavorito());
			
			if(tienda.isEsFavorito())
			{
				item.setIcon(R.drawable.ic_action_star);
			}
			else
			{
				item.setIcon(R.drawable.ic_action_favorite);
			}
			break;
			
		}
		return super.onOptionsItemSelected(item);
	}

}
