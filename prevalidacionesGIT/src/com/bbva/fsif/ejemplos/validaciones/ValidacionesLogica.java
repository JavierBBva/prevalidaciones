package com.bbva.fsif.ejemplos.validaciones;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidacionesLogica {
	// <modelo,Map<tipo,Map<campo,Map<validacion,List<parametros>>
	public Map<String, Map<String, Map<Campo, Map<Validacion, List<Object>>>>> validacionesModelos = new HashMap<>();
	private Validaciones validaciones;
	private static String NOMBRE_CLASE = "com.bbva.fsif.ejemplos.Validaciones";
	private String cadena;
	private String registroTipo1;

	public void carga190() {

		// 190

		// T1
		cargaValidacion("190", "T1", "tipo Registro", "01", "01", 0, 1, "F", true, "1", 0, 1);
		cargaValidacion("190", "T1", "tipo Registro", "01", "01", 0, 1, "9", true);
		cargaValidacion("190", "T1", "modelo", "02", "01", 1, 4, "9", true);
		cargaValidacion("190", "T1", "modelo", "02", "01", 1, 4, "F", true, "190", 0, 3);
		cargaValidacion("190", "T1", "modelo", "02", "03", 1, 4, "O", true);
		cargaValidacion("190", "T1", "ejercicio", "03", "01", 4, 8, "9", true);
		cargaValidacion("190", "T1", "ejercicio", "03", "01", 4, 8, "F", true, "2017", 0, 4);
		cargaValidacion("190", "T1", "ejercicio", "03", "03", 4, 8, "O", true);
		cargaValidacion("190", "T1", "N.I.F del declarante", "04", "03", 8, 17, "O", true);
		cargaValidacion("190", "T1", "N.I.F del declarante", "04", "01", 8, 17, "N", true);
		cargaValidacion("190", "T1", "N.I.F del declarante", "04", "03", 8, 17, "F", false, "X000000T", 0, 9);
		cargaValidacion("190", "T1", "nombre", "05", "03", 17, 57, "O", true);
		cargaValidacion("190", "T1", "nombre", "05", "03", 17, 57, "L", true, " ", 0, 40);
		cargaValidacion("190", "T1", "Tipo de Soporte", "06", "03", 57, 58, "O", true);
		cargaValidacion("190", "T1", "Tipo de Soporte", "06", "01", 57, 58, "F", true, "T", 0, 1);
		cargaValidacion("190", "T1", "Telefono", "07", "01", 58, 67, "9", true);
		cargaValidacion("190", "T1", "Telefono", "07", "03", 58, 67, "O", true);
		cargaValidacion("190", "T1", "Apellidos y nombre de la persona con quien relacionarse", "07", "03", 67, 107,
				"P", true);
		cargaValidacion("190", "T1", "Apellidos y nombre de la persona con quien relacionarse", "07", "03", 67, 107,
				"O", true);
		cargaValidacion("190", "T1", "Apellidos y nombre de la persona con quien relacionarse", "07", "01", 67, 107,
				"L", true, " ", 0, 40);
		cargaValidacion("190", "T1", "Apellidos y nombre de la persona con quien relacionarse", "07", "01", 67, 107,
				"B", true, " ", 3);
		cargaValidacion("190", "T1", "Apellidos y nombre de la persona con quien relacionarse", "07", "01", 67, 107,
				"D", false, 0, 3);
		cargaValidacion("190", "T1", "Numero identificativo de la declaracion", "08", "01", 107, 120, "O", true);
		cargaValidacion("190", "T1", "Numero identificativo de la declaracion", "08", "01", 107, 120, "9", true);
		cargaValidacion("190", "T1", "Numero identificativo de la declaracion", "08", "01", 107, 120, "F", true, "190",
				0, 3);

		cargaValidacion("190", "T1", "Declaracion Complementaria", "09", "01", 120, 121, "P", true);

		cargaValidacion("190", "T1", "Declaracion Sustitutiva", "10", "01", 121, 122, "P", true);

		cargaValidacion("190", "T1", "Numero identificativo declaración anterior", "11", "01", 122, 135, "9", true);
		 
		cargaValidacion("190", "T1", "Numero total de perceptores", "12", "03", 135, 144, "O", true);
		cargaValidacion("190", "T1", "Numero total de perceptores", "12", "01", 135, 144, "9", true);
		cargaValidacion("190", "T1", "Numero total de perceptores", "12", "04", 135, 144, "M", 2, 10000L, 0, 9);
		cargaValidacion("190", "T1", "Importe de las percepciones", "14", "03", 145, 160, "O", true);
		cargaValidacion("190", "T1", "Importe de las percepciones", "14", "01", 145, 160, "9", true);
		cargaValidacion("190", "T1", "Importe de las retenciones/ingresos a cuenta", "15", "03", 160, 175, "O", true);
		cargaValidacion("190", "T1", "Importe de las retenciones/ingresos a cuenta", "15", "04", 160, 175, "M", 2,
				1000000000000L, 0, 15);
		cargaValidacion("190", "T1", "Importe de las retenciones/ingresos a cuenta", "15", "11", 160, 175, "U", true);
		cargaValidacion("190", "T1", "Correo electronico de la persona con quien relacionarse", "16", "01", 175, 225,
				"A", true);
		cargaValidacion("190", "T1", "blancos", "17", "01", 225, 487, "O", false);
		cargaValidacion("190", "T1", "blancos", "18", "01", 487, 500, "O", false);

		// T2

		cargaValidacion("190", "T2", "tipo Registro", "01", "01", 0, 1, "F", true, "2", 0, 1);
		cargaValidacion("190", "T2", "tipo Registro", "01", "01", 0, 1, "9", true);

		cargaValidacion("190", "T2", "modelo", "02", "12", 1, 4, "F", true, getRegistroTipo1().substring(1, 4), 0, 3);

		cargaValidacion("190", "T2", "ejercicio", "03", "12", 4, 8, "F", true, getRegistroTipo1().substring(4, 8), 0,
				4);

		cargaValidacion("190", "T2", "nif del declarante", "04", "12", 8, 17, "F", true,
				getRegistroTipo1().substring(8, 17), 0, 9);
		cargaValidacion("190", "T2", "nif del declarante", "04", "01", 8, 17, "R", false, "0", 0, 9);
		String[] datos = { " " };

		cargaValidacion("190", "T2", "nif del declarante", "04", "01", 8, 17, "S", false, 0, 9, datos);

		cargaValidacion("190", "T2", "NIF del perceptor", "05", "03", 17, 26, "O", true);

		cargaValidacion("190", "T2", "NIF del perceptor", "05", "03", 17, 26, "F", false, "X000000T", 0, 9);

		cargaValidacion("190", "T2", "NIF del perceptor", "05", "03", 17, 26, "F", false, getCadena().substring(8, 16),
				0, 9);

		cargaValidacion("190", "T2", "NIF del perceptor", "05", "03", 17, 26, "F", false, getCadena().substring(26, 35),
				0, 9);

		cargaValidacion("190", "T2", "NIF del representante legal", "06", "01", 26, 35, "F", false, "X000000T", 0, 9);

		cargaValidacion("190", "T2", "NIF del  representante legal", "06", "01", 26, 35, "F", false,
				getCadena().substring(17, 26), 0, 9);

		cargaValidacion("190", "T2", "Apellidos y nombre o razon social del perceptor", "07", "03", 35, 75, "O", true);
		
		cargaValidacion("190", "T2", "Codigo de provincia", "08", "03", 75,77, "O", true);
		
		List<Object> rangos= new ArrayList<>();
		rangos.add(new Rango(1,52));
		rangos.add(new Rango(98, 98));
		
		
		cargaValidacion("190", "T2", "Codigo de provincia", "08", "01", 75,77, "G", true,rangos);
		
		cargaValidacion("190", "T2", "Clave de percepcion", "09", "03", 77,78, "O", true);
		cargaValidacion("190", "T2", "Clave de percepcion", "09", "03", 77,78, "S", true,0,1,"A","B","C","D","E","F","G","H","I","J","K","L");
		
	}

	public void validaciones190T1() {

		if (getValidaciones().validaTD(getCadena().substring(8, 17)) == 2) {
			cargaValidacion("190", "T1", "nombre", "05", "01", 17, 57, "A", true);
			
		}
		else
		{
			cargaValidacion("190", "T1", "nombre", "05", "01", 17, 57, "T", true);
			cargaValidacion("190", "T1", "nombre", "05", "01", 17, 57, "B", true," ",2);
			cargaValidacion("190", "T1", "nombre", "05", "01", 17, 57, "B", true," ",2);
			cargaValidacion("190", "T1", "Apellidos y nombre o razon social del perceptor", "05", "01", 17, 57, "D",
					true, 0, 3);
		}
		

		// validaciones Declaracion complementaria y sustitutiva
		// //valor del campo o espacio o C
		String resultado = "TODO CORRECTO CAMPO Declaracion complementaria validacion valores espacio o C";
		if (!getValidaciones().validaF(getCadena(), " ", 120, 121)
				&& !getValidaciones().validaF(getCadena(), "C", 120, 121)) {
			resultado = "ERROR EN CAMPO Declaracion complementaria validacion valores espacio o C 10901";
			// 10901
		}
		// si el campo es blanco la declaracion complementaria no puede tener
		// valor
		System.out.println(resultado);
		String resultado1 = "TODO CORRECTO CAMPO Declaracion complementaria validacion que declaracion sustitutiva no tiene tambien valor";
		if (getValidaciones().validaF(getCadena(), "C", 120, 121)
				&& getValidaciones().validaF(getCadena(), "S", 121, 122)) {
			resultado1 = "ERROR EN CAMPO Declaracion complementaria Declaracion complementaria validacion que declaracion sustitutiva no tiene tambien valor 10902";
			// 10902 en sustitutiva y complementaria
		}
		System.out.println(resultado1);
		// si es C declaracion complementaria debe tener valor
		String resultado2 = "TODO CORRECTO CAMPO Declaracion complementaria validacion que no tiene valor y tampoco numero identificativo declaracion anterior";

		if (getValidaciones().validaF(getCadena(), " ", 120, 121)
				&& getValidaciones().validaO(getCadena().substring(122, 135))) {
			resultado2 = "ERROR EN CAMPO CAMPO Declaracion complementaria validacion que no tiene valor y tampoco numero identificativo declaracion anterior";
			// 10903 en sustitutiva y complementaria
		}
		System.out.println(resultado2);

		String resultado3 = "TODO CORRECTO CAMPO Declaracion complementaria validacion que si tiene valor y tambien numero identificativo declaracion anterior";
		if (getValidaciones().validaF(getCadena(), "C", 120, 121)
				&& getValidaciones().validaO(getCadena().substring(122, 135))) {
			resultado3 = "ERROR EN CAMPO CAMPO Declaracion complementaria validacion que no tiene valor y tampoco numero identificativo declaracion anterior";
			// 10903 en sustitutiva y complementaria
		}

		System.out.println(resultado3);

		// Número identificativo de la declaración anterior

		String resultado4 = "TODO CORRECTO CAMPO número identificativo de la declaración anterior validacion que si tiene valor Declaración complementaria o sustitutiva no puede estar vacio";
		if (((getValidaciones().validaF(getCadena(), "C", 120, 121)
				&& getValidaciones().validaF(getCadena(), " ", 121, 122))
				|| (getValidaciones().validaF(getCadena(), "S", 121, 122)
						&& getValidaciones().validaF(getCadena(), " ", 120, 121)))
				&& !getValidaciones().validaO(getCadena().substring(122, 135))) {
			resultado4 = "ERROR EN CAMPO número identificativo de la declaración anterior validacion que si tiene valor Declaración complementaria o sustitutiva no puede estar vacio";
			cargaValidacion("190", "T1", "Número identificativo declaración anterior", "11", "01", 122, 135, "F", true,
					"190", 0, 3);
			
			// 11102
		}

		System.out.println(resultado4);

		String resultado5 = "TODO CORRECTO CAMPO número identificativo de la declaración anterior validacion es distinto del campo numero identificativo de declaracion 11101";
		if (getCadena().substring(108, 120)==getCadena().substring(122, 135)) {
			resultado5 = "ERROR EN CAMPO número identificativo de la declaración anterior validacion es distinto del campo numero identificativo de declaracion 11101";
			// 11103
		}

		System.out.println(resultado5);
		// Signo del importe total de las percepciones
		
		 resultado5 = "TODO CORRECTO CAMPO número identificativo de la declaración anterior validacion que si no tiene valor Declaración complementaria y sustitutiva no puede estar vacio 11101";
		if (((getValidaciones().validaF(getCadena(), " ", 120, 121)
				&& getValidaciones().validaF(getCadena(), " ", 121, 122))
				&& (getValidaciones().validaF(getCadena(), " ", 121, 122)
						&& getValidaciones().validaF(getCadena(), " ", 120, 121)))
				&& getValidaciones().validaO(getCadena().substring(122, 135))) {
			resultado5 = "ERROR EN CAMPO número identificativo de la declaración anterior validacion que si no tiene valor Declaración complementaria y sustitutiva no puede estar vacio";
			// 11103
		}

		System.out.println(resultado5);
		

		String resultado6 = "TODO CORRECTO CAMPO signo del importe total de las percepciones ";
		if ((getValidaciones().validaM(getCadena(), 0L, 145, 160) == 2
				&& getValidaciones().validaF(getCadena(), " ", 121, 122))) {	
			resultado6 = "ERROR EN CAMPO signo del importe total de las percepciones";
			// 11301
		}

		System.out.println(resultado6);

	}

	public void validaciones190T2() {

		String primeraPosicion = getCadena().substring(17, 18);
		System.out.println(primeraPosicion);
		String campoClave = getCadena().substring(77, 78);
		System.out.println(campoClave);

		String subclave = getCadena().substring(78, 80);

		String resultado1 = "TODO CORRECTO EN CAMPO NIF del declarante error 20502" + " - " + cadena.substring(17, 26);
		if (!getValidaciones().validaS(primeraPosicion, 0, 1, "P", "Q", "S")
				&& getValidaciones().validaS(campoClave, 0, 1, "D", "L")
				&& getValidaciones().validaS(subclave, 0, 1, "09", "13", "19", "22", "23")
				|| !getValidaciones().validaS(primeraPosicion, 0, 1, "P", "Q", "S", "G")
						&& getValidaciones().validaS(campoClave, 0, 1, "B")
						&& getValidaciones().validaS(subclave, 0, 1, "01")
				|| !getValidaciones().validaS(primeraPosicion, 0, 1, "P", "Q", "S", "G")
						&& getValidaciones().validaS(campoClave, 0, 1, "C", "L")
						&& getValidaciones().validaS(subclave, 0, 1, "20"))
			resultado1 = "ERROR EN CAMPO NIF del declarante error 20502" + " - " + cadena.substring(17, 26);

		System.out.println(resultado1);

		String resultado2 = "TODO CORRECTO EN CAMPO NIF del declarante error 20502" + " - " + cadena.substring(17, 26);
		if (getValidaciones().validaS(campoClave, 0, 1, "A", "F", "J")) {
			if (NIFVerificationManager.comprobarCIF(cadena.substring(17, 26)))
				resultado2 = "ERROR EN CAMPO NIF del declarante error 20502";
		} else {
			if (NIFVerificationManager.comprobarCIF(cadena.substring(17, 26))) {
				if (getValidaciones().validaS(primeraPosicion, 0, 1, "K", "L", "M", "X", "Y", "Z"))
					resultado2 = "TODO CORRECTO EN CAMPO NIF del declarante error 20502" + " - "
							+ cadena.substring(17, 26);
			} else {
				resultado2 = "ERROR EN CAMPO NIF del declarante error 20501" + " - " + cadena.substring(17, 26);

				if (NIFVerificationManager.comprobarNIF(cadena.substring(17, 26)))
					resultado2 = "TODO CORRECTO EN CAMPO NIF del declarante error 20502" + " - "
							+ cadena.substring(17, 26);
				else if (NIFVerificationManager.comprobarCIF(cadena.substring(17, 26))) {
					if (getValidaciones().validaS(primeraPosicion, 0, 1, "E", "G", "H", "J", "V")) {
						resultado2 = "TODO CORRECTO EN CAMPO NIF del declarante error 20502" + " - "
								+ cadena.substring(17, 26);
					}

				}
			}
		}
		System.out.println(resultado2);

		resultado2 = "TODO CORRECTO EN CAMPO NIF del declarante error 20503" + " - " + cadena.substring(17, 26);
		if (!getValidaciones().validaO(cadena.substring(17, 26)) && getValidaciones().validaO(cadena.substring(26, 35)))
			resultado2 = "ERROR EN CAMPO NIF del declarante error 20503" + " - " + cadena.substring(17, 26);

		System.out.println(resultado2);

		resultado2 = "TODO CORRECTO EN CAMPO NIF del representatnte legal error 20503" + " - "
				+ cadena.substring(26, 35);

		if (Integer.parseInt(getCadena().substring(152, 156)) > 2003
				&& getValidaciones().validaS(campoClave, 0, 1, "A", "B")
				&& getValidaciones().validaS(subclave, 0, 2, "01", "03")
				|| getValidaciones().validaS(campoClave, 0, 1, "C")) {
			cargaValidacion("190", "T2", "NIF del representatnte legal", "06", "03", 26, 35, "O", true);

		}

		if (Integer.parseInt(getCadena().substring(152, 156)) < 2003
				&& getValidaciones().validaS(campoClave, 0, 1, "A", "B")
				&& getValidaciones().validaS(subclave, 0, 2, "01", "03")
				|| getValidaciones().validaS(campoClave, 0, 1, "C")) {
			cargaValidacion("190", "T2", "NIF del representatnte legal", "06", "02", 26, 35, "F", true, "         ");

		}

		if (!getValidaciones().validaF(getCadena().substring(26, 35), "         ", 0, 9)) {
			String[] valores = { "N", "W" };
			cargaValidacion("190", "T2", "NIF del  representante legal", "06", "01", 26, 35, "S", true, 0, 9, valores);
			cargaValidacion("190", "T2", "NIF del representante legal", "06", "01", 26, 35, "N", true);
		}

		if (NIFVerificationManager.comprobarNIF(getCadena().substring(17, 26))) {
			cargaValidacion("190", "T2", "NIF del representante legal", "06", "03", 26, 35, "O", true);
		}

		if (getValidaciones().validaTD(getCadena().substring(17, 26)) == 2) {

			cargaValidacion("190", "T2", "Apellidos y nombre o razon social del perceptor", "07", "01", 35, 75, "A",
					true);
			cargaValidacion("190", "T2", "Apellidos y nombre o razon social del perceptor", "07", "01", 35, 75, "L",
					true, " ", 0, 40);
		}
		else {

			cargaValidacion("190", "T2", "Apellidos y nombre o razon social del perceptor", "07", "01", 35, 75, "T",
					true);
			cargaValidacion("190", "T2", "Apellidos y nombre o razon social del perceptor", "07", "01", 35, 75, "L",
					true, " ", 0, 40);
			cargaValidacion("190", "T2", "Apellidos y nombre o razon social del perceptor", "07", "01", 35, 75, "B",
					true, 2);

			cargaValidacion("190", "T2", "Apellidos y nombre o razon social del perceptor", "07", "01", 35, 75, "D",
					true, 0, 3);

		}
	}

	public void cargaValidacion(String modelo, String tipoRegistro, String nombreCampo, String numeroCampo,
			String codigoError, int posicionInicial, int posicionFinal, String nombreValidacion, Object resultado,
			Object... paramatrosValidacion) {
		if (validacionesModelos.get(modelo) == null)
			validacionesModelos.put(modelo, new HashMap<String, Map<Campo, Map<Validacion, List<Object>>>>());
		Map<String, Map<Campo, Map<Validacion, List<Object>>>> listaTiposModelo = validacionesModelos.get(modelo);

		if (listaTiposModelo.get(tipoRegistro) == null)
			listaTiposModelo.put(tipoRegistro, new HashMap<Campo, Map<Validacion, List<Object>>>());
		Map<Campo, Map<Validacion, List<Object>>> listaCamposTipo = listaTiposModelo.get(tipoRegistro);

		Campo campoSeleccionado = null;
		for (Campo campo : listaCamposTipo.keySet()) {
			if (campo.getNumero().equals(nombreCampo)) {
				campoSeleccionado = campo;
				break;
			}
		}

		if (campoSeleccionado == null)
			listaCamposTipo.put(new Campo(nombreCampo, posicionInicial, posicionFinal, numeroCampo, codigoError),
					new HashMap<Validacion, List<Object>>());
		for (Campo campo : listaCamposTipo.keySet()) {
			if (campo.getNombre().equals(nombreCampo)) {
				campoSeleccionado = campo;
				break;
			}
		}
		Validacion validacionSeleccionada = null;
		Map<Validacion, List<Object>> listaValidacionesCampo = listaCamposTipo.get(campoSeleccionado);
		for (Validacion validacion : listaValidacionesCampo.keySet()) {
			if (validacion.getNombre().equals(nombreValidacion)) {
				validacionSeleccionada = validacion;
				break;
			}
		}
		if (validacionSeleccionada == null)
			listaValidacionesCampo.put(new Validacion(nombreValidacion, resultado), new ArrayList<>());
		for (Validacion validacion : listaValidacionesCampo.keySet()) {
			if (validacion.getNombre().equals(nombreValidacion)) {
				validacionSeleccionada = validacion;
				break;
			}
		}
		List<Object> parametros = new ArrayList<>();

		for (int i = 0; i < paramatrosValidacion.length; i++) {
			parametros.add(paramatrosValidacion[i]);
		}

		listaValidacionesCampo.put(validacionSeleccionada, new ArrayList<>(parametros));

	}

	public void valida(String modelo, String tipo) {
		Map<Campo, Map<Validacion, List<Object>>> mapaValidaciones = validacionesModelos.get(modelo).get(tipo);

		for (Campo campo : mapaValidaciones.keySet()) {
			Map<Validacion, List<Object>> listaValidaciones = mapaValidaciones.get(campo);

			for (Validacion validacion : listaValidaciones.keySet()) {
				String metodo = "valida" + validacion.getNombre().toUpperCase();
				List<Class<?>> parameterTypes = new ArrayList<>();
				parameterTypes.add(String.class);
				for (Object objeto : listaValidaciones.get(validacion)) {
					parameterTypes.add(objeto.getClass());
				}
				try {
					Class<?>[] classes = new Class[parameterTypes.size()];
					parameterTypes.toArray(classes);
					Method method = Class.forName(ValidacionesLogica.NOMBRE_CLASE).getMethod(metodo, classes);
					Object[] valoresMetodo = new Object[listaValidaciones.get(validacion).size() + 1];
					valoresMetodo[0] = getCadena().substring(campo.getPos1(), campo.getPos2());
					int i = 1;
					for (Object object : listaValidaciones.get(validacion)) {
						valoresMetodo[i] = object;
						i++;
					}
					Object resultado = method.invoke(getValidaciones(), valoresMetodo);
					String fin = "TODO CORRECTO CAMPO " + campo.getNombre() + " VALIDACION " + metodo + " - "
							+ getCadena().substring(campo.getPos1(), campo.getPos2());
					if (!resultado.equals(validacion.isResultado())) {
						fin = "VALIDACION ERRONEA " + campo.getNombre() + " VALIDACION " + metodo + " - "
								+ getCadena().substring(campo.getPos1(), campo.getPos2());
						System.err.println(fin);
					} else
						System.out.println(fin);

				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	public Validaciones getValidaciones() {
		return validaciones;
	}

	public void setValidaciones(Validaciones validaciones) {
		this.validaciones = validaciones;
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public String getRegistroTipo1() {
		return registroTipo1;
	}

	public void setRegistroTipo1(String registroTipo1) {
		this.registroTipo1 = registroTipo1;
	}

}
