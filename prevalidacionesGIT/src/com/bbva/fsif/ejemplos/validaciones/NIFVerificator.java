package com.bbva.fsif.ejemplos.validaciones;

public class NIFVerificator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
System.out.println("NIF 71220583W correcto: "+NIFVerificationManager.comprobarNIF("71220583W")); //nif
		
		System.out.println("NIF 71220583Z correcto: "+NIFVerificationManager.comprobarNIF("71220583Z"));
		
		System.out.println("NIF 71A20583Z correcto: "+NIFVerificationManager.comprobarNIF("71A20583Z"));
		
		//---------------------------
		System.out.println("");
		
		System.out.println("CIF A28599033 correcto: "+NIFVerificationManager.comprobarCIF("A28599033")); //Indra
		
		System.out.println("CIF A2859903P correcto: "+NIFVerificationManager.comprobarCIF("A2859903P"));
		
		System.out.println("CIF A28X9903P correcto: "+NIFVerificationManager.comprobarCIF("A28X9903P"));
		
		System.out.println("CIF 12859903P correcto: "+NIFVerificationManager.comprobarCIF("12859903P"));
		
		
		System.out.println("");
		
		System.out.println("CIF Q1368009E correcto: "+NIFVerificationManager.comprobarCIF("Q1368009E"));  //UCLM
		
		System.out.println("CIF Q13680091 correcto: "+NIFVerificationManager.comprobarCIF("Q13680091"));
		
		System.out.println("CIF Q136X0091 correcto: "+NIFVerificationManager.comprobarCIF("Q136X0091"));
		
		System.out.println("CIF 91368009E correcto: "+NIFVerificationManager.comprobarCIF("91368009E"));
		
		
		System.out.println("");
		
		System.out.println("NIE X7496481E correcto: "+NIFVerificationManager.comprobarNIE("X7496481E"));  //profe UCLM
		System.out.println("NIE X7496481A incorrecto: "+NIFVerificationManager.comprobarNIE("X7496481A"));  
		System.out.println("NIE X74964815 incorrecto: "+NIFVerificationManager.comprobarNIE("X74964815")); 
		System.out.println("NIE A7496481E incorrecto: "+NIFVerificationManager.comprobarNIE("A7496481E"));
		
		System.out.println("NIE X7100420K correcto: "+NIFVerificationManager.comprobarNIE("X7100420K"));  //profe UCLM
		System.out.println("NIE X7100420R incorrecto: "+NIFVerificationManager.comprobarNIE("X7100420R"));
		System.out.println("NIE X71004205 incorrecto: "+NIFVerificationManager.comprobarNIE("X71004205"));
		System.out.println("NIE B7100420K incorrecto: "+NIFVerificationManager.comprobarNIE("B7100420K"));
	}

}
