package com.sp1.data;

import java.util.ArrayList;

import com.sp1.businessObjects.Tienda;

public  class dataAccess {


	public static ArrayList<Tienda> getTinedas()
	{
		ArrayList<Tienda> tiendas = new ArrayList<Tienda>();
		
		Tienda t1 = new Tienda(1,"Tienda 1");
		Tienda t2 = new Tienda(1,"Tienda 2");
		Tienda t3 = new Tienda(1,"Tienda 3");
		Tienda t4 = new Tienda(1,"Tienda 4");
		Tienda t5 = new Tienda(1,"Tienda 5");
		
		tiendas.add(t1);
		tiendas.add(t2);
		tiendas.add(t3);
		tiendas.add(t4);
		tiendas.add(t5);
		
		return tiendas;
		
		
	}
	
}
