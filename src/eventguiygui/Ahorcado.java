package eventguiygui;

import java.util.Vector;

public class Ahorcado {

	// Propiedades
	private String palabra;
	private StringBuffer enigma;
	private Vector<Character> letrasIntroducidas;
	private char letra;
	private int fallos;
	private int aciertos;
	// Necesitamos de este contador de veces
	private int cuantasLetrasHasCambiado;

	// Metodos
	/**
	 * Este metodo Inic�a el juego, Sorteando una palabra, creando el enigma, inicia
	 * un vector din�mico para las letras que introduzcamos , pone los fallos a cero
	 * y pone los aciertos a Cero
	 * 
	 * @author Marc
	 */
	public void iniciarJuego() {
		sortearPalabra();
		crearPalabraEnigma();
		crearListaLetrasIntroducidas();
		ponerFallosACero();
		ponerAciertosACero();
	};// iniciarJuego

	/////////////////////////////// Parte
	/////////////////////////////// publica////////////////////////////////////////////////////////

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public StringBuffer getEnigma() {
		return enigma;
	}

	public void setEnigma(StringBuffer enigma) {
		this.enigma = enigma;
	}

	public Vector<Character> getLetrasIntroducidas() {
		return letrasIntroducidas;
	}

	public void setLetrasIntroducidas(Vector<Character> letrasIntroducidas) {
		this.letrasIntroducidas = letrasIntroducidas;
	}

	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}

	public int getFallos() {
		return fallos;
	}

	public void setFallos(int fallos) {
		this.fallos = fallos;
	}

	public int getAciertos() {
		return aciertos;
	}

	public void setAciertos(int aciertos) {
		this.aciertos = aciertos;
	}

	public int getCuantasLetrasHasCambiado() {
		return cuantasLetrasHasCambiado;
	}

	public void setCuantasLetrasHasCambiado(int cuantasLetrasHasCambiado) {
		this.cuantasLetrasHasCambiado = cuantasLetrasHasCambiado;
	}

	/**
	 * Este metodo se encarga de gestionar el juego, para ello comprueba la letra
	 * que le pasamos por parametros, para ello primero mira si est� en el vector de
	 * letras introducidas, si est� comprueba el tope de fallos. Si no est� en ese
	 * vector, la comprobamos en la palabra, y si es verdad, comprobamos que la
	 * palabra no est� completa ya Si no est� la letra en la palabra tampoco,
	 * miramos el numero de fallos maximo.
	 * 
	 * @param Letra por parametros, que asignamos a nuestra variable letra de la
	 *              clase ahorcado para trabajar con los metodos
	 * @return true si la letra esta en la palabra, false si ya ha sido jugada o no esta en la palabra
	 */
	public boolean introducirLetra(char letra) {
		this.letra = letra;
		if (comprobarLetraIntroducida()) {
			// Esta linea hay que mirarla detenidamente
			incrementarFallos();
			comprobarTopeFallos();
			return false;
		} else {
			anadirLetrasIntroducidas();
			if (comprobarLetraPalabra()) {
				comprobarPalabraCompleta();
				return true;
			} else {
				comprobarTopeFallos();
				return false;
			}
		}

	};// introducirLetra

	/**
	 * Comprueba la letra introducida, con el vector de las letras que hemos
	 * introducido
	 * 
	 * @return True si esta letra ya ha sido introducida, o false si la letra
	 *         todavia no habia sido escrita
	 */
//		private boolean comprobarLetraIntroducida(){
	public boolean comprobarLetraIntroducida() {
		boolean esta = false;
		for (int i = 0; i < letrasIntroducidas.size(); i++) {
			if (letrasIntroducidas.get(i).equals(letra))
				esta = true;
		} // for
		return esta;
	}// comprobarLetraIntroducidas

	/////////////////////////////////// parte
	/////////////////////////////////// privada///////////////////////////////////////
	/**
	 * Atrav�s de los aciertos, compara este valor con el tama�o de la palabra y si
	 * coinciden, la palabra esta completamente acertada
	 * 
	 * @param aciertos que hicimos de la palabra
	 * @return True en caso de que esta palabra este completa, false en caso
	 *         contrario
	 */
	public boolean comprobarPalabraCompleta() {
		boolean completa = false;
		if (palabra.length() == this.aciertos) {
			completa = true;
		} // if
		return completa;
	}// comprobarPalabraCompleta

	/**
	 * Nosotros elegimos el m�ximo de fallos que se pueden realizar en el juego, a
	 * trav�s de este dato podemos comprobar, si al fallar en una letra hemos
	 * alcanzado el m�ximo, finalizando el juego, o en caso contrario seguir jugando
	 * 
	 * @param fallos que hemos realizado a medida que avanza el juego
	 * @return True en caso de llegar al m�ximo // false en caso contrario
	 */
	public boolean comprobarTopeFallos() {
		int tope = 5;
		boolean cantidad;
		;
		if (fallos == tope) {
			cantidad = true;
		} // if
		else {
			cantidad = false;
		} // else
		return cantidad;
	}// comprobarTopeFallos

	/**
	 * Metodo que incrementa los fallos en 1
	 */
	private void incrementarFallos() {
		fallos += 1;
	}// incrementarFallos

	/**
	 * Incrementa los aciertos, dependiendo de las letras que hayas cambiado en la
	 * palabra "enigma"
	 * 
	 * @param cuantasLetrasHasCambiado
	 */
	private void incrementarAciertos(int veces) {
		this.aciertos = aciertos + cuantasLetrasHasCambiado;
	}// incrementarAciertos

	/**
	 * Compara la letra introducida, con todas las letras de la palabra
	 * 
	 * @return True si esta letra esta dentro de la palabra, false en caso contrario
	 */
	private boolean comprobarLetraPalabra() {
		// Comrpboamos si la letra actual esta en la palabra
		// si lo est� llamamos a letras introducidas
		if (palabra.indexOf(letra) != -1) {
			this.cuantasLetrasHasCambiado = modificarEnigma();
			incrementarAciertos(cuantasLetrasHasCambiado);
			return true;
		} else {
			incrementarFallos();
			return false;
		} // else
	}// comprobarletraPalabra

	/**
	 * Este m�todo calcula cuantas veces hemos cambiado una letra de la
	 * palabra(Ocurrencias) Esto nos da utilidad, para saber cuantos aciertos hemos
	 * realizado en la palabra, y asi de esta manera nos ayuda a poder comprobar si
	 * hemos completado la palabra, con el metodo comprobarPalabraCompleta
	 * 
	 * @return Un numero de cambios realizados en la palabra enigma(Ocurrencias de
	 *         la letra en la palabra));
	 */
	private int modificarEnigma() {
		int contadorCambios = 0;
		for (int i = 0; i < palabra.length(); i++) {
			if (palabra.charAt(i) == letra) {
				enigma.setCharAt(i, letra);
				contadorCambios += 1;
			} // if
		} // for
		return contadorCambios;
	}// modificarEngima

	/**
	 * A�ade al vector de letras introducidas, la letra pasada por parametros en
	 * cada jugada
	 */
	private void anadirLetrasIntroducidas() {
		letrasIntroducidas.add(letra);
	}// a�adirLetrasIntroducidas

	/**
	 * Metodo que se encarga de elegir una palabra aleatoria del almac�n con un
	 * Math.Random Nos devuelve una palabra al azar dentro de nuestra String palabra
	 */

	private void sortearPalabra() {
		palabra = Almacen.sortearPalabra();
	}// sortearPalabra

	/**
	 * A trav�s del tama�o de nuestra palabra, le asignamos a engima el valor "_ _ _
	 * _ _" Puesto que enigma es una StringBuffer, se puede jugar con su
	 * modificaci�n
	 */

	private void crearPalabraEnigma() {
		enigma = new StringBuffer();
		for (int i = 0; i < palabra.length(); i++) {
			enigma.append("_");
		}
	}// crearPalabraEnigma

	/**
	 * M�todo que crea un vector din�mico, que aumenta el tama�o seg�n las letras
	 * que introduzcamos
	 */
	private void crearListaLetrasIntroducidas() {
		letrasIntroducidas = new Vector();
	};// crearListaLetrasIntroducidas

	/**
	 * M�todo que se encarga de reiniciar los fallos a Cero
	 */
	private void ponerFallosACero() {
		this.fallos = 0;
	};// ponerFallosACero

	/**
	 * Este m�todo se encarga de poner los aciertos a Cero
	 */
	private void ponerAciertosACero() {
		this.aciertos = 0;
	};// ponerAciertosACero

}// class
