package com.sp1.data;

import java.util.ArrayList;

import com.sp1.businessObjects.Tienda;
import com.sp1.tarea2.R;

public  class dataAccess {

	public static ArrayList<Tienda> Tiendas; 

	public static ArrayList<Tienda> getTinedas()
	{
		ArrayList<Tienda> tiendas = new ArrayList<Tienda>();
		
		Tienda t1 = new Tienda(1,"Apple Store", "Zona 9, Guatemala", "4027 8506", "Lun-Viernes: 8:00 - 18:00","www.laTienda1.com", "contactenos@tienda1.com","@drawable/tienda_1");
		Tienda t2 = new Tienda(2,"Wall Mart", "San Cristobal, Guatemala", "2222 2222", "Lun-Sab: 8:00 - 18:00","www.laTienda2.com", "contactenos@tienda2.com","@drawable/tienda_2");
		Tienda t3 = new Tienda(3,"Tienda Sport Check",  "Zona 13, Geminis Interior, Guatemala", "3333 3333", "Martes-Domingo: 9:00 - 17:00","www.laTiend3.com", "contactenos@tienda3.com","@drawable/tienda_3");
		Tienda t4 = new Tienda(4,"Tienda Smokos" ,  "Zona 4, Guatemala", "4444 4444", "Martes-Domingo: 9:00 - 17:00","www.laTiend4.com", "contactenos@tienda4.com","@drawable/tienda_4");
		Tienda t5 = new Tienda(5,"Tienda Android",  "Zona 5, Geminis Interior, Guatemala", "5555 5555", "Martes-Domingo: 9:00 - 17:00","www.laTiend3.com", "contactenos@tienda5.com","@drawable/tienda_5");
		
		tiendas.add(t1);
		tiendas.add(t2);
		tiendas.add(t3);
		tiendas.add(t4);
		tiendas.add(t5);
		
		Tiendas = tiendas;
		
		return tiendas;
	}
	
	public static Tienda getTienda(int id)
	{
		for (Tienda tienda : Tiendas) {
			if(tienda.getID() == id)
			{
				return tienda;
			}
		}
		return null;
	}
	
	

	
	public static int[] getTiendasImagesIds()
	{
		int[] arrayImages = new int[]
				{
					R.drawable.tienda_1 ,
					R.drawable.tienda_2,
					R.drawable.tienda_3,
					R.drawable.tienda_4,
					R.drawable.tienda_5
				};
		
		return arrayImages; 
	}
	
	
	
}
