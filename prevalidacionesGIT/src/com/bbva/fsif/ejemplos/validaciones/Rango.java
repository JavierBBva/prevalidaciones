package com.bbva.fsif.ejemplos.validaciones;
public class Rango {

	private Integer inicio;
	private Integer fin;
	
	public Rango(int inicio, int fin)
	{
		this.inicio=inicio;
		this.fin=fin;
	}
	public Integer getInicio() {
		return inicio;
	}
	public void setInicio(Integer inicio) {
		this.inicio = inicio;
	}
	public Integer getFin() {
		return fin;
	}
	public void setFin(Integer fin) {
		this.fin = fin;
	}
	
}
