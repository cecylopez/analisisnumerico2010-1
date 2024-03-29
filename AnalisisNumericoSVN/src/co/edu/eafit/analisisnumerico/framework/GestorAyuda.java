package co.edu.eafit.analisisnumerico.framework;

import co.edu.eafit.analisisnumerico.GUI.GUIAyuda;

public class GestorAyuda {

	/**objecto que garantiza singleton*/
	private static GestorAyuda gestorAyuda;
	
	/**gui con la ayuda*/
	private static GUIAyuda gui;
	
	/**
	 * constructor privado para garantizar unicidad 
	 */
	private GestorAyuda(){
		gui= new GUIAyuda("", "");
	}
		
	/**
	 * retorna la instancia del gestor de ayuda
	 * @return
	 */
	public static GestorAyuda getInstance() {
		if(gestorAyuda==null){
			gestorAyuda=new GestorAyuda();
		}
		return gestorAyuda;
	}

	public void mostrarAyudaMetodo() {
		String title = generarTituloAyuda(GestorMetodos.metodoEjecutandose);
		String ayudaText = obtenerAyuda(GestorMetodos.metodoEjecutandose);
		if(gui.isVisible()){
			gui.setVisible(false);
			gui.dispose();
		}
		gui= new GUIAyuda(title, ayudaText);
		gui.setVisible(true);
	}
	
	public void mostrarAyudaMetodo(int metodo) {
		String title = generarTituloAyuda(metodo);
		String ayudaText = obtenerAyuda(metodo);
		if(gui.isVisible()){
			gui.setVisible(false);
			gui.dispose();
		}
		gui= new GUIAyuda(title, ayudaText);
		gui.setVisible(true);
	}

	private String obtenerAyuda(int metodoEjecutandose) {
		String ruta = "ayudasInterfaz/";
		switch(metodoEjecutandose){
			case Constantes.BISECCION:
				ruta+="Biseccion.txt";
				break;
			case Constantes.BUSQUEDASINCREMENTALES:
				ruta+="BusquedasIncrementales.txt";
				break;
			case Constantes.CHOLESKY:
				ruta+="Cholesky.txt";
				break;
			case Constantes.CROULT:
				ruta+="Croult.txt";
				break;
			case Constantes.DOOLITTLE:
				ruta+="Dolytle.txt";
				break;
			case Constantes.GAUSSSIMPLE:
				ruta+="EliminacionGaussiana.txt";
				break;
			case Constantes.LUSIMPLE:
				ruta+="LUSimple.txt";
				break;
			case Constantes.NEWTON:
				ruta+="Newton.txt";
				break;
			case Constantes.PIVOTEOESCALONADO:
				ruta+="PivoteoEscalonado.txt";
				break;
			case Constantes.PIVOTEOPARCIAL:
				ruta+="PivoteoParcial.txt";
				break;
			case Constantes.PIVOTEOTOTAL:
				ruta+="PivoteoTotal.txt";
				break;
			case Constantes.PUNTOFIJO:
				ruta+="PuntoFijo.txt";
				break;
			case Constantes.RAICESMULTIPLES:
				ruta+="RaicesMultiples.txt";
				break;
			case Constantes.REGLAFALSA:
				ruta+="ReglaFalsa.txt";
				break;
			case Constantes.SECANTE:
				ruta+="Secante.txt";
				break;
			case Constantes.LUPIVOTEO:
				ruta+="LUPivoteoParcial.txt";
				break;
			case Constantes.JACOBI:
				ruta+="Jacobi.txt";
				break;
			case Constantes.GAUSSSEIDEL:
				ruta+="GaussSeidel.txt";
				break;
			case Constantes.RELAJACION:
				ruta+="Relajacion.txt";
				break;
			case Constantes.MATRIZBANDA:
				ruta+="MatrizBanda.txt";
				break;
			case Constantes.INFOGENERAL:
				ruta+="AcercaDe.txt";
				break;
			case Constantes.ECUACIONESNOLINEALES:
				ruta+="EcuacionesNoLineales.txt";
				break;
			case Constantes.SISTEMASDEECUACIONES:
				ruta+="SistemasDeEcuaciones.txt";
				break;
			case Constantes.INTERPOLACION:
				ruta+="Interpolacion.txt";
				break;
			case Constantes.DIFERENCIACION:
				ruta+="Diferenciacion.txt";
				break;
			case Constantes.INTEGRACION:
				ruta+="Integracion.txt";
				break;
			case Constantes.GRAFICADOR:
				ruta+="Graficador.txt";
				break;
			case Constantes.SPLINES:
				ruta+="Splines.txt";
				break;
			case Constantes.NEWTONDIFERENCIASDIVIDIDAS:
				ruta+="newtondifdivididas.txt";
				break;
			case Constantes.LAGRANGE:
				ruta+="lagrange.txt";
				break;
			case Constantes.NEVILLE:
				ruta+="neville.txt";
				break;
			case Constantes.DIFERENCIACION2PUNTOS:
				ruta+="diferenciacion2puntos.txt";
				break;
			case Constantes.DIFERENCIACION3PUNTOS:
				ruta+="diferenciacion3puntos.txt";
				break;
			case Constantes.DIFERENCIACION5PUNTOS:
				ruta+="diferenciacion5puntos.txt";
				break;
			case Constantes.SIMPSON:
				ruta+="simpson.txt";
				break;
			case Constantes.TRAPECIO:
				ruta+="trapecio.txt";
				break;

		}
		return readFile(ruta);
	}
	
	/**
	 * lee el archivo de ayuda
	 * @param NomArch nombre del archivo
	 * @return string con la ayuda del metodo
	 */
	public static String readFile(String NomArch){
		java.io.FileReader fstream = null;
		StringBuffer strBuf = new StringBuffer();
		try{
			fstream = new java.io.FileReader(NomArch);
			int c;
			int cont = 0;
			while ((c = fstream.read()) != -1){
				strBuf.append((char)c);
				cont += 1;
			}
			return strBuf.toString();
		}catch (java.io.IOException ex){return ex.getMessage();}
		finally{
			if (fstream != null){
				try{
					fstream.close();
				}
				catch (java.io.IOException ex){
					return "";
				}
			}
		}
	}


	private String generarTituloAyuda(int metodoEjecutandose) {
		String textInicio="AYUDA METODO ";
		switch(metodoEjecutandose){
			case Constantes.BISECCION:
				return textInicio+" BISECCION";
			case Constantes.BUSQUEDASINCREMENTALES:
				return textInicio+" BUSQUEDAS INCREMENTALES";
			case Constantes.CHOLESKY:
				return textInicio+" CHOLESKY";
			case Constantes.CROULT:
				return textInicio+" CROULT";
			case Constantes.DOOLITTLE:
				return textInicio+" DOOLITTLE";
			case Constantes.GAUSSSIMPLE:
				return textInicio+" ELIMINACION GAUSSIANA SIMPLE";
			case Constantes.LUSIMPLE:
				return textInicio+" LU POR ELIMINACION GAUSSIANA SIMPLE";
			case Constantes.NEWTON:
				return textInicio+" NEWTON";
			case Constantes.PIVOTEOESCALONADO:
				return textInicio+" PIVOTEO ESCALONADO";
			case Constantes.PIVOTEOPARCIAL:
				return textInicio+" PIVOTEO PARCIAL";
			case Constantes.SECANTE:
				return textInicio+" SECANTE";
			case Constantes.REGLAFALSA:
				return textInicio+" REGLA FALSA";
			case Constantes.RAICESMULTIPLES:
				return textInicio+" RAICES MULTIPLES";
			case Constantes.PUNTOFIJO:
				return textInicio+" PUNTO FIJO";
			case Constantes.PIVOTEOTOTAL:
				return textInicio+" PIVOTEO TOTAL";
			case Constantes.LUPIVOTEO:
				return textInicio+" LU PIVOTEO PARCIAL";
			case Constantes.GAUSSSEIDEL:
				return textInicio+" GAUSS SEIDEL";
			case Constantes.JACOBI:
				return textInicio+" JACOBI";
			case Constantes.RELAJACION:
				return textInicio+" RELAJACION";
			case Constantes.MATRIZBANDA:
				return textInicio+" MATRIZ BANDA";
			case Constantes.INFOGENERAL:
				return textInicio+" ACERCA DE";
			case Constantes.ECUACIONESNOLINEALES:
				return textInicio+" ECUACIONES NO LINEALES";
			case Constantes.SISTEMASDEECUACIONES:
				return textInicio+" SISTEMAS DE ECUACIONES";
			case Constantes.INTERPOLACION:
				return textInicio+" INTERPOLACION";
			case Constantes.DIFERENCIACION:
				return textInicio+" DIFERENCIACION";
			case Constantes.INTEGRACION:
				return textInicio+" INTEGRACION";
			case Constantes.ECUACIONESDIFERENCIALES:
				return textInicio+" ECUACIONES DIFERENCIALES";
			case Constantes.GRAFICADOR:
				return textInicio+" GRAFICADOR";
				
		}
		return "";
	}
}