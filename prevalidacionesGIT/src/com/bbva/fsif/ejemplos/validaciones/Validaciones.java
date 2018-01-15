package com.bbva.fsif.ejemplos.validaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * @author 
 * @since 1.8
 * @version 1.0
 */
public class Validaciones {

	private String registro;
	private String modelo;

	public static int NO_ES_NUMERO = 3;
	public static int MAYOR = 1;
	public static int MENOR_O_IGUAL = 2;
	
	public static String VACIO=" ";
	public static String CERO ="0";
	
	/**
	 * campo alfabetico
	 * 
	 * @param cadena
	 * @return true si solo contiene letras o caracteres permitidos
	 */
	public boolean validaT (String cadena){
		String caracteres []={" ","'",",","-",".","´","Ç","Ñ"};
		boolean encontrado;
		 for (int i = 0; i < cadena.length(); i++){	
			 encontrado =false;
	            if (!Character.isLetter(cadena.charAt(i))){
	            	for(int z=0; z < caracteres.length;z++){
			            	if(caracteres[z].equals(Character.toString(cadena.charAt(i)))) {
			            	encontrado = true;
			            	break;
			            } 		            	
			         }
					if(!encontrado) return false;
	            }
		 }
		return true;
	}
	
	/**
	 * campo alfanumerico
	 * 
	 * @param cadena
	 * @return true si es un número o letras y false si es otro caracter
	 */
	public boolean validaA(String cadena) {
		
		String caracteres []={" ","&","'",",","-",".","/",":",";","_","´","Ç","Ñ"};
		 boolean encontrado;
		
		 for (int i = 0; i < cadena.length(); i++){
			 encontrado =false;
				 if (!Character.isLetter(cadena.charAt(i)) && !Character.isDigit(cadena.charAt(i)))  {
	            	
					 for(int z=0; z < caracteres.length;z++){
			            	if(caracteres[z].equals(Character.toString(cadena.charAt(i)))) {
			            	encontrado = true;
			            	break;
			            } 		            	
			         }
					if(!encontrado) return false;
	            }
		 }
		return true;
	}
	
	/**
	 * Solo letras y caracteres de puntuacion
	 * 
	 * @param cadena
	 * @return true si solo contien letras y caracteres de puntuacion
	 */
	public boolean validaP(String cadena){
		String caracteres []={" ","'",",",".",":",";","Ç","Ñ"};
		 boolean encontrado;
		
		 for (int i = 0; i < cadena.length(); i++){
			 encontrado =false;
				 if (!Character.isLetter(cadena.charAt(i)) && !Character.isDigit(cadena.charAt(i)))  {
	            	
					 for(int z=0; z < caracteres.length;z++){
			            	if(caracteres[z].equals(Character.toString(cadena.charAt(i)))) {
			            	encontrado = true;
			            	break;
			            } 		            	
			         }
					if(!encontrado) return false;
	            }
		 }
		return true;
	}
	
	
	/**
	 * campo numérico
	 * 
	 * @param cadena
	 * @return true si es un numero y false si no lo es
	 */
	public boolean valida9 (String cadena){
		
		 try {
			Double.parseDouble(cadena);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}	
		
	}
	
	/**
	 * campo numerico positivo
	 * 
	 * @param cadena
	 * @return true numero entero false numero real
	 */
	public boolean validaU(String numero) {
		
		if (valida9(numero)&& Double.parseDouble(numero) >= 0)
			return true;
		return false;
	}
	
	/**
	 * Numero entero o decimal
	 * 
	 * @param numero
	 * @return true si es decimal y false si no
	 */
	public boolean validaE(String numero){
		
		if (valida9(numero)){
			double n=  Double.parseDouble(numero);
			if(n%1!=0){
				return true;
			}
		}
		return false;
	}

	/**
	 * valor obligatorio en posiciones
	 * 
	 * @param cadena
	 * @param valor
	 *            obligatorio
	 * @param pos1
	 *            inicio
	 * @param pos2
	 *            fin
	 * @return true si coincide el valor false si no coincide
	 */
	public boolean validaV(String cadena, String valor, Integer pos1, Integer pos2) {
		if (cadena.substring(pos1, pos2).toUpperCase().equalsIgnoreCase(valor.toUpperCase()))
			return true;
		return false;
	}

	/**
	 * 
	 * 
	 * @param cadena 
	 * @param pos11 
	 *				Posicion inicial primer campo
	 * @param pos21	
	 *				Posicion final primer campo
	 * @param pos1a 
	 * 				Posicion inicial segundo campo
	 * @param pos2a 
	 * 				Posicion final segundo campo
	 * @return	1 si solo esta relleno el primer campo 2 si solo esta relleno el segundo campo 3 si estan los dos vacios 0 si estan los dos rellenos
	 */
	public int validaX(String cadena , Integer pos11, Integer pos12, Integer pos1a, Integer pos2a){
		
		if(!validaV(cadena," ",pos11,pos12) && validaV(cadena," ",pos1a,pos2a))return 1;
		if(validaV(cadena," ",pos11,pos12) && !validaV(cadena," ",pos1a,pos2a))return 2;
		if(validaV(cadena," ",pos11,pos12) && validaV(cadena," ",pos1a,pos2a))return 3;
			
		return 0;
	}
	
	/**
	 * valida documento identificativo
	 * 
	 * @param cadena
	 * @param tipo
	 *            valores N (nif) C(cif) E(nie)
	 * @return true si es vÃ¡lido con el tipo, false si no es vÃ¡lido o el tipo no
	 *         es corecto
	 */
	public boolean validaN(String cadena) {
		String tipo="N";
		if(validaTD(cadena)==2)
			tipo="C";
		if(validaTD(cadena)==3)
			tipo="E";
		switch (tipo) {
		case "N":
			return NIFVerificationManager.comprobarNIF(cadena);
		case "C":
			return NIFVerificationManager.comprobarCIF(cadena);
		case "E":
			return NIFVerificationManager.comprobarNIE(cadena);

		}
		return false;
	}
	/**
	 * valida el tipo de documento
	 * @param cadena
	 * @return 1 si es NIF, 2 si es CIF 3 si es NIE y 0 si no es ninguno
	 */
	public int validaTD(String cadena)
	{
		if(Character.isLetter(cadena.charAt(0)) &&  Character.isDigit(cadena.charAt(cadena.length()-1)))
			return 2;
		if(Character.isDigit(cadena.charAt(0)) &&  Character.isLetter(cadena.charAt(cadena.length()-1)))
			return 1;
		if(Character.isLetter(cadena.charAt(0)) &&  Character.isLetter(cadena.charAt(cadena.length()-1)))
			return 3;
		return 0;
	}
	
	/**
	 * valor excesivo
	 * 
	 * @param cadena
	 * @param valor
	 * @param pos1
	 *            inicio
	 * @param pos2
	 *            fin
	 * @return 1 si excede, 2 si no excede o es 0 y 3 si no es numero
	 */
	public int validaM(String cadena, Long valor, Integer pos1, Integer pos2) {

		if (validaT(cadena.substring(pos1, pos2))) {
			return Validaciones.NO_ES_NUMERO;
		}
		int numero = Integer.parseInt(cadena.substring(pos1, pos2));
		if (numero > valor)
			return Validaciones.MAYOR;
		return Validaciones.MENOR_O_IGUAL;

	}

	/**
	 * alineacion a la izquierda
	 * 
	 * @param cadena
	 * @param valor
	 * @param pos1
	 * @param pos2
	 * @return true si el contenido esta alineado a la izquierda de la cadena
	 *         false si no lo esta
	 */
	public boolean validaL(String cadena, String valor, Integer pos1, Integer pos2) {
		if (cadena.substring(pos1, pos2).startsWith(valor))
			return false;
		return true;

	}

	/**
	 * alineacion a la derecha
	 * 
	 * @param cadena
	 * @param valor
	 * @param pos1
	 * @param pos2
	 * @return true si el contenido esta alineado a la derecha de la cadena
	 *         false si no lo esta
	 */
	public boolean validaR(String cadena, String valor, Integer pos1, Integer pos2) {
		if (cadena.substring(pos1, pos2).endsWith(valor))
			return true;	
		return false;

	}

	/**
	 * separacion por caracteres
	 * 
	 * @param cadena
	 * @param caracter
	 * @param cantidad
	 * @return true si coincide la cantidad de subcadenas indicada en cantidaad separadas por el caracter, o es superior false si no coincide
	 */
	public boolean validaB(String cadena, String caracter, Integer cantidad) {
		StringTokenizer stringTokenizer = new StringTokenizer(cadena, caracter);
		if (stringTokenizer.countTokens() >= cantidad)
			return true;
		return false;
	}
	
	/**
	 * Todos caracteres iguales
	 * 
	 * @param cadena
	 * @param pos1
	 * @param pos2
	 * @return true si los caracteres de la subcadena son iguales, false si alguno es diferente
	 */
	public boolean validaD(String cadena,Integer pos1, Integer pos2)
	{
		String caracter=cadena.substring(pos1,pos2).substring(0,1);
		boolean repetido=true;
		for (int i = 0;  i<cadena.substring(pos1,pos2).length()-1; i++) {
			if(!cadena.substring(i,i+1).equalsIgnoreCase(caracter))
				repetido=false;
		}
		return repetido;
	}
	
	/**
	 * coleccion de valores admisibles
	 * 
	 * @param cadena
	 * @param pos1
	 * @param pos2
	 * @param valores
	 * @return true si algunos de los valores es igual al fragmento de la cadena
	 */
	public boolean validaS(String cadena, Integer pos1, Integer pos2, String ...valores)
	{
		
		for (int i = 0; i < valores.length; i++) {
			if(cadena.substring(pos1,pos2).equalsIgnoreCase(valores[i]))
				return true;
		}
		return false;
	}
	
	/**
	 * Obligatorio
	 * 
	 * @param cadena
	 * @return false si se considera vacio ("" o 0) y true si no esta vacio
	 */
	public boolean validaO(String cadena){
		

	boolean result=false;
	
	      for (int i = 0; i < cadena.length(); i++){
	     
	    String c=  Character.toString(cadena.charAt(i));
	    if(!c.equals(CERO) && !c.equals(VACIO)){
	   
	    result =true;
	   
	    }
	     
	      }
	
	 
	return result;
	}
	
	
	/**
	 * Rango de valores
	 * 
	 * @param cadena
	 * @param rangos
	 * @return true si esta dentro del rango false si esta fuera del rango
	 */
	public boolean validaG(String cadena, ArrayList<Rango> rangos){
		
		Integer n = Integer.parseInt(cadena);
		
		
		for (Rango rango : rangos) {
			
		
			
			if (n >= rango.getInicio() && n <= rango.getFin()){
				
				return true;
				
			}
		}
		return false;
		
	}
	
	/**
	 * Valor concreto de cadena
	 * 
	 * @param cadena
	 * @param Valor
	 * @param pos1
	 * @param pos2
	 * @return true si coincide con el valor false si no coincide
	 */
	public boolean validaF(String cadena,String valor,Integer pos1,Integer pos2){
		
		if(!cadena.substring(pos1,pos2).toUpperCase().equals(valor.toUpperCase())){
			return false;
		}
		
		return true;
	}
	public boolean valida1(String cadena,String reg1, Integer pos1,Integer pos2){
		
		if(!reg1.substring(pos1, pos2).endsWith(cadena))
			return false;
		
		return true;
	}
	
	
	
	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

}
