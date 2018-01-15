package com.bbva.fsif.ejemplos.validaciones;

public class NIFVerificationManager {
	
/*Fuente algoritmo ->   http://www.interior.gob.es/web/servicios-al-ciudadano/dni/calculo-del-digito-de-control-del-nif-nie */
	
	/*verifica el NIF de espa�oles residentes mayores de edad*/
	public static boolean comprobarNIF (String nif) {
		
		//formato NIF: n� DNI hasta 8 cifras + d�gito de control o letra
		String dni = nif.substring(0, nif.length()-1); //se devuelve substring desde 0 a 2�par�metro-1
		String digitoControl = nif.substring(nif.length()-1, nif.length());
		
		String letra = calcularDigitoControl (dni);
		
		//if (letra!=null && digitoControl == letra) return true;
		if (digitoControl.compareTo(letra)==0) return true;
		else return false;
	}
	
	
	
	
	public static boolean comprobarNIE (String nie) {
		//formato NIE: letra (X,Y,Z) + 7 n�meros + digito de control
		String letraInicio = nie.substring(0, 1), letraInicioANumero;
		String numeros = ""; //nif.substring(0, nif.length()); //se devuelve substring desde 0 a 2�par�metro-1
		
		//numeros = convertirLetraInicioANumero (letraInicio) + nie.substring(1, nie.length()-1);
		letraInicioANumero = convertirLetraInicioANumero (letraInicio);
		
		System.out.println("letraInicioANumero: "+letraInicioANumero);
		
		//if (letraInicioANumero != null) {
		numeros = letraInicioANumero + nie.substring(1, nie.length()-1);
		
		String digitoControl = nie.substring(nie.length()-1, nie.length());
		
		String letraControl = calcularDigitoControl (numeros);
		
		//if (digitoControl == letraControl) return true;
		if (digitoControl.compareTo(letraControl)==0) return true;
		else return false;
		
		/*} //a�adido
		else return false;  //letraInicioANumero = null */
	}
	
	
	
	
	private static String calcularDigitoControl (String dni) {
		
		String letra = "";
		
		try {
		int resto = Integer.valueOf(dni)%23;
		
		 switch (resto) {
	     case 0:  letra = "T";
	              break;
	     case 1:  letra = "R";
	              break;
	     case 2:  letra = "W";
	              break;
	     case 3:  letra = "A";
	              break;
	     case 4:  letra = "G";
	              break;
	     case 5:  letra = "M";
	              break;
	     case 6:  letra = "Y";
	              break;
	     case 7:  letra = "F";
	              break;
	     case 8:  letra = "P";
	              break;
	     case 9:  letra = "D";
	              break;
	     case 10: letra = "X";
	              break;
	     case 11: letra = "B";
	              break;
	     case 12: letra = "N";
	     		  break;
	     case 13: letra = "J";
	     		  break;
	     case 14: letra = "Z";
	     		  break;
	     case 15: letra = "S";
	     		  break;
	     case 16: letra = "Q";
	     		  break;
	     case 17: letra = "V";
	     		  break;
	     case 18: letra = "H";
	     		  break;
	     case 19: letra = "L";
	     		  break;
	     case 20: letra = "C";
	     		  break;
	     case 21: letra = "K";
	     		  break;
	     case 22: letra = "E";
	     		  break;
	     default: letra = null;
	              break;
		 }
		 
		 return letra;
		} catch (Exception e) {
			return letra;
		}
	}
	
	
	
	
	private static String convertirLetraInicioANumero (String letraInicio) {
		
		String numero = "";
		
		System.out.println("letraInicio: "+(letraInicio.toCharArray())[0]); //
		
		 switch ((letraInicio.toCharArray())[0]) {
	     case 'X':  numero = "0";
	              break;
	     case 'Y':  numero = "1";
	              break;
	     case 'Z':  numero = "2";
	              break;
	     default: numero = null;
	              break;
		 }
		 
		 return numero;
	}
	
	
	/* Comprueba formato CIF de acuerdo a  -> http://www.aplicacionesinformaticas.com/programas/gratis/cif.php  */
	public static boolean comprobarCIF (String cif) {
		//El n�mero CIF consta de 9 d�gitos alfanum�ricos con la siguiente estructura: O P P N N N N N C
		//O: Tipo de Organizaci�n  ; P: C�digo provincia  ; N: N�mero correlativo por provincia ; C: D�gito o letra de control
		
		String tipoOrganizacion = cif.substring(0, 1);
		String codigoProvincia = cif.substring(1, 3);
		String numeroCorrelativoProvincial = cif.substring(3, cif.length()-1);
		String digitoLetraControl = cif.substring(cif.length()-1, cif.length());
		
		String digitoLetraControlRequerido = comprobarTipoOrganizacion (tipoOrganizacion);
		
		if (digitoLetraControlRequerido != null) {
			if (comprobarCodigoProvincia (codigoProvincia)) {
				if (comprobarNumeroCorrelativoProvincial (numeroCorrelativoProvincial)) {
					if (comprobarDigitoLetraControl (digitoLetraControl, digitoLetraControlRequerido)) return true;
					else return false;
				}
				else return false;
				
			}
			else return false;	

		}
		else return false;
	
	}
	
	
	private static String comprobarTipoOrganizacion (String tipoOrganizacion) {
		
		 String caracterControlRequerido = "";
		
		 switch ((tipoOrganizacion.toCharArray())[0]) {
	     case 'A':
	     case 'B':
	     case 'E':
	     case 'H': caracterControlRequerido = "numero";
	    	 break;
	     case 'F':
	     case 'C':
	     case 'D':
	     case 'G':
	     case 'L':  //formato antiguo
	     case 'M':  //formato antiguo
	     case 'N': caracterControlRequerido = "indiferente";
	    	 break;
	     case 'K':  //formato antiguo
	     case 'P':
	     case 'Q':
	     case 'S':  caracterControlRequerido = "letra";
	         break;
	     default: caracterControlRequerido = null;
	         break;
		 }

		 return caracterControlRequerido;
	}
	
	
	private static boolean comprobarCodigoProvincia (String codigoProvincia) {
		
		if ((Integer.valueOf(codigoProvincia)>=01 && Integer.valueOf(codigoProvincia)<= 64) || (Integer.valueOf(codigoProvincia)>=70 && Integer.valueOf(codigoProvincia)<=87 ) || (Integer.valueOf(codigoProvincia)>=91 && Integer.valueOf(codigoProvincia)<=99 )) return true;
		else return false;
	}
	
	
	private static boolean comprobarNumeroCorrelativoProvincial (String numeroCorrelativoProvincial) {  //revisar
		/*try {
		if (Integer.parseInt(numeroCorrelativoProvincial)>0) return true;
		else return false;
		} catch (Exception e) {
			return false;
		}*/
		//else return false;
		
		return comprobarStringContieneNumero (numeroCorrelativoProvincial);
	}
	
	
	private static boolean comprobarStringContieneNumero (String stringAEvaluar) {  //revisar!!
		try {
			Integer.parseInt(stringAEvaluar);
			return true;
			
			} catch (Exception e) {
				return false;
			}
	}

	
	private static boolean comprobarDigitoLetraControl (String digitoLetraControl, String digitoLetraControlRequerido) {
	
		if (digitoLetraControlRequerido.compareTo("numero")==0 && comprobarStringContieneNumero(digitoLetraControl)) return true;
		else if (digitoLetraControlRequerido.compareTo("letra")==0 && !comprobarStringContieneNumero(digitoLetraControl)) return true;
		else if (digitoLetraControlRequerido.compareTo("indiferente")==0) return true;
		else return false;
	}

}
