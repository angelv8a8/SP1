package com.sp1.businessObjects;

public class Tienda {

	private int TiendaID;
	private String TiendaNombre;
	
	
	public Tienda()
	{
		
	}
	
	public Tienda(int id, String nombre)
	{
		this.TiendaID = id;
		this.TiendaNombre = nombre;
	}
	
	public String getNombre()
	{
		return this.TiendaNombre;
	}
	
	public int getID()
	{
		return this.TiendaID;
	}
	
}
