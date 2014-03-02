package com.sp1.tarea2;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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

public class DetalleTienda extends Activity implements OnClickListener {

	private String Telefono = "";
	private String Email = "";
	private int ID ;
	Tienda tienda;
	
	public final static String TIENDA_ID = "tienda_id";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalle_tienda);
		// Show the Up button in the action bar.
		setupActionBar();
		
		String id = getIntent().getStringExtra(this.TIENDA_ID).toString();
		
		tienda = dataAccess.getTienda(Integer.parseInt(id));
		
		InitializeView(tienda);
		
		
		if(tienda.isEsFavorito())
		{
			MenuItem item = (MenuItem)findViewById(R.id.action_favorito);
			item.setIcon(R.drawable.ic_action_star);
		}
		
	}

	private void InitializeView(Tienda tienda) {

		Telefono = tienda.getTelefono();
		Email = tienda.getEmail();
		ID =  tienda.getID();
		
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
		
		Button btnLlamar = (Button)findViewById(R.id.button1);
		btnLlamar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String uri = "tel:" + Telefono;
				Intent intent = new Intent(Intent.ACTION_DIAL);
				intent.setData(Uri.parse(uri));
				startActivity(intent);	
			}});
		
		Button btnVerImagen = (Button)findViewById(R.id.btn_ver_imagen);
		btnVerImagen.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent intent = null;
				intent = new Intent(getApplicationContext(), TiendaImagen.class);
				//Log.i(TAG, "TEXTO:" + inputQuery.getText().toString());
				intent.putExtra(DetalleTienda.TIENDA_ID,  ID);
				startActivity(intent);
						
			}
			});
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
		case R.id.action_compartir:
			if(tienda != null)
			{
				String message = getString( R.string.msg_share, tienda.getNombre(), tienda.getWebSite());
				Intent share = new Intent();
				share.setAction(Intent.ACTION_SEND);
				share.putExtra(Intent.EXTRA_TEXT, message);
				share.setType("text/plain");
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

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		
		if(view.getId() == R.id.btn_ver_imagen)
		{
			Intent intent = new Intent(getApplicationContext(), TiendaImagen.class);
			intent.putExtra(DetalleTienda.TIENDA_ID , this.tienda.getID() );
			startActivity(intent);
		}
		else if (view.getId() == R.id.button1)
		{
			String uri = "tel:" + Telefono;
			Intent intent = new Intent(Intent.ACTION_DIAL);
			intent.setData(Uri.parse(uri));
			 startActivity(intent);	
		}
		
		
	}

	

}
