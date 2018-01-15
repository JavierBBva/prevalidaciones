package com.bbva.fsif.ejemplos.validaciones;

public class Campo {

	private String nombre;
	private int pos1, pos2;
	private String numero;
	private String codigoError;
	
	public Campo(String nombre, int pos1, int pos2,String numero,String codigoError) {
		this.nombre=nombre;
		this.pos1=pos1;
		this.pos2=pos2;
		this.numero=numero;
		this.codigoError=codigoError;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPos1() {
		return pos1;
	}
	public void setPos1(int pos1) {
		this.pos1 = pos1;
	}
	public int getPos2() {
		return pos2;
	}
	public void setPos2(int pos2) {
		this.pos2 = pos2;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCodigoError() {
		return codigoError;
	}
	public void setCodigoError(String codigoError) {
		this.codigoError = codigoError;
	}
	
}
