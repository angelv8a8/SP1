package com.sp1.tarea2;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sp1.businessObjects.Tienda;
import com.sp1.data.dataAccess;
import com.sp1.tarea2.fragments.TiendaComentariosFragment;

public class DetalleTiendaActivity extends FragmentActivity   {

	private String Telefono = "";

	private Tienda tienda;
	public final static String TIENDA_ID = "tienda_id";
	
	public Tienda getTienda()
	{
		return tienda;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalle_tienda);
		// Show the Up button in the action bar.
		setupActionBar();

		String id = getIntent().getStringExtra(TIENDA_ID).toString();

		tienda = dataAccess.getTienda(Integer.parseInt(id));

		InitializeView(tienda);
	}

	private void InitializeView(Tienda tienda) {

		Telefono = tienda.getTelefono();

		

		TextView txtNombre = (TextView) findViewById(R.id.tiendaNombre);
		txtNombre.setText(tienda.getNombre());

		TextView txtDireccion = (TextView) findViewById(R.id.tiendaDireccion);
		txtDireccion.setText(tienda.getDireccion());

		TextView txtHorario = (TextView) findViewById(R.id.tiendaHorarioDetalle);
		txtHorario.setText(tienda.getHorario());

		TextView txtEmail = (TextView) findViewById(R.id.tiendaEmail);
		Linkify.addLinks(txtEmail, Linkify.EMAIL_ADDRESSES);
		txtEmail.setText(tienda.getEmail());
		LinearLayout ll = (LinearLayout) findViewById(R.id.lista_comentarios);

		findViewById(R.id.button1).setOnClickListener(new onClickDetalle());
		findViewById(R.id.btn_ver_imagen).setOnClickListener(new onClickDetalle());
		
		
		TiendaComentariosFragment tcf = new TiendaComentariosFragment();
		//getFragmentManager().beginTransaction().commit();
		
		

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

	class onClickDetalle implements OnClickListener{

		@Override
		public void onClick(View v) {
			if (v.getId() == R.id.btn_ver_imagen) {
				Intent intent = new Intent(getApplicationContext(),
						TiendaImagenActivity.class);
				intent.putExtra(DetalleTiendaActivity.TIENDA_ID, tienda.getID());
				startActivity(intent);
			}
			else if(v.getId() == R.id.button1){
				String uri = "tel:" + Telefono;
				Intent intent = new Intent(Intent.ACTION_DIAL);
				intent.setData(Uri.parse(uri));
				startActivity(intent);
			}
			
		}
		
		
	}
}
