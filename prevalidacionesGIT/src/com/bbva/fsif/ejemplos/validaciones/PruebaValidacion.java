package com.bbva.fsif.ejemplos.validaciones;

public class PruebaValidacion {

	public static void main(String[] args) {

		int i = 1;
		int j = 2;
		int k = 3;
		int m = 2;
		System.out.println((j >= i) || (k == m));

		String registro = "21902017A08188807E87206934         NOTARIA RIVES PALACIO C B               28G01 00000000214580000000003218 0000000000000000000000000000000000000000000000000         00 0000000000000000000000000000000000000000000000000000000000000000000000000000000000000 000000000000000000000000000000000000000                                                                                                                                                                                                              ";
		String registroTipo1 = "11902017A08188807BBVA BANCO DE FINANCIACION S.A.         T944876329JOSE RAMON BANALES PASCUAL              1900000000000  0000000000000000000002 000000000255541000000000038331                                                                                                                                                                                                                                                                                                                                     ";
		// 11902017A08188807BBVA BANCO DE FINANCIACION S.A. T944876329JOSE RAMON
		// BANALES PASCUAL 0000000000000 0000000000000000000002
		// 000000000255541000000000038331
		ValidacionesLogica logica = new ValidacionesLogica();
		logica.setRegistroTipo1(registroTipo1);
		logica.setValidaciones(new Validaciones());
		logica.setCadena(registro);
		logica.carga190();
		logica.validaciones190T2();
		logica.valida( "190", "T2");
		
		
	}

}
