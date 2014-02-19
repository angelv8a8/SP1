package com.sp1.businessObjects;

import java.util.ArrayList;

public class Tienda {

	private int TiendaID;
	private String TiendaNombre;
	private String Direccion;
	private String Telefono;
	private String Horario;
	private String WebSite;
	private String Email;
	
	private boolean Favorito;
	
	private String Image;
	
	private ArrayList<String> Comentarios;
	
	public Tienda()
	{
		
	}
	
	public Tienda(int id, String nombre)
	{
		this.TiendaID = id;
		this.TiendaNombre = nombre;
	}
	
	public Tienda(int id, String nombre, 
						String direccion, 
						String telefono,
						String horario, 
						String website, 
						String email,
						String image)
	{
		this.TiendaID = id;
		this.TiendaNombre = nombre;
		this.Direccion = direccion;
		this.Telefono = telefono;
		this.Horario = horario;
		this.WebSite = website;
		this.Email= email;
		this.setImage(image);
		
		this.Comentarios = new ArrayList<String>();
		this.Comentarios.add("Que bonito");
		
		this.setEsFavorito(false);
		
	}
	
	public String getNombre()
	{
		return this.TiendaNombre;
	}
	
	public int getID()
	{
		return this.TiendaID;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getWebSite() {
		return WebSite;
	}

	public void setWebSite(String webSite) {
		WebSite = webSite;
	}

	public String getHorario() {
		return Horario;
	}

	public void setHorario(String horario) {
		Horario = horario;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	
	public void agregarComentario(String comentario)
	{
		this.Comentarios.add(comentario);
	}
	
	public ArrayList<String> getComentarios()
	{
		return Comentarios;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public boolean isEsFavorito() {
		return Favorito;
	}

	public void setEsFavorito(boolean esFavorito) {
		Favorito = esFavorito;
	}
	
}
