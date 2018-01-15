package com.bbva.fsif.ejemplos.validaciones;

public class Validacion {
	private String nombre;
	private Object resultado;
	public Validacion(String nombre, Object resultado) {
		this.nombre=nombre;
		this.resultado=resultado;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Object isResultado() {
		return resultado;
	}
	public void setResultado(Object resultado) {
		this.resultado = resultado;
	}
}
