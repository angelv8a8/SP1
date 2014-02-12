package com.sp1.tarea1;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.text.Spannable;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sp1.businessObjects.Tienda;
import com.sp1.data.dataAccess;

public class DetalleTienda extends Activity {

	private String Telefono = "";
	private String Email = "";
	private int ID ;
	
	public final static String TIENDA_ID = "tienda_id";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalle_tienda);
		// Show the Up button in the action bar.
		setupActionBar();
		
		String id = getIntent().getStringExtra(this.TIENDA_ID).toString();
		
		Tienda tienda = dataAccess.getTienda(Integer.parseInt(id));
		
		InitializeView(tienda);
	}

	private void InitializeView(Tienda tienda) {

		Telefono = tienda.getTelefono();
		Email = tienda.getEmail();
		ID =  tienda.getID();
		
		
		Button btnLlamar = (Button)findViewById(R.id.button1);
		btnLlamar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String uri = "tel:" + Telefono;
				Intent intent = new Intent(Intent.ACTION_DIAL);
				intent.setData(Uri.parse(uri));
				 startActivity(intent);
				
			}
		});
		
		
		
		
		
		TextView txtNombre = (TextView)findViewById(R.id.tiendaNombre);
		txtNombre.setText(tienda.getNombre());
		
		TextView txtDireccion = (TextView)findViewById(R.id.tiendaDireccion);
		txtDireccion.setText(tienda.getDireccion());
		
		TextView txtHorario = (TextView)findViewById(R.id.tiendaHorarioDetalle);
		txtHorario.setText(tienda.getHorario());
		
		TextView txtEmail = (TextView)findViewById(R.id.tiendaEmail);
		Linkify.addLinks(txtEmail, Linkify.EMAIL_ADDRESSES);
		txtEmail.setText(tienda.getEmail());
		LinearLayout ll = (LinearLayout)findViewById(R.id.lista_comentarios);
		
		for (String comentario : tienda.getComentarios()) {
			
			TextView tv = new TextView(getApplicationContext());
			tv.setText(comentario);
			ll.addView(tv);
		}
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
		getMenuInflater().inflate(R.menu.detalle_tienda, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
		
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
