package ahorcadoconsola;
import java.util.Vector;

public class Ahorcado {

	
	//Propiedades 
	protected String palabra;
	protected StringBuffer enigma;
	protected Vector<Character> letrasIntroducidas;
	protected char letra;
	protected int fallos;
	protected int aciertos;
	//Necesitamos de este contador de veces
	protected int cuantasLetrasHasCambiado;
	//Metodos
	/**
	 * Este metodo Inic�a el juego, Sorteando una palabra, creando el enigma, inicia un vector
	 * din�mico para las letras que introduzcamos , pone los fallos a cero y pone los aciertos a Cero
	 * @author Marc
	 */
	 public void iniciarJuego(){
		 sortearPalabra();
		 crearPalabraEnigma();
		 crearListaLetrasIntroducidas();
		 ponerFallosACero();
		 ponerAciertosACero();
	 };//iniciarJuego
	/**
	 * Metodo que se encarga de elegir una palabra aleatoria del almac�n con un Math.Random
	 * Nos devuelve una palabra al azar dentro de nuestra String palabra
	 */
	 
	 private void sortearPalabra(){
		 palabra=Almacen.sortearPalabra();
	 }//sortearPalabra 
	 /**
	  * A trav�s del tama�o de nuestra palabra, le asignamos a engima el valor "_ _ _ _ _" 
	  * Puesto que enigma es una StringBuffer, se puede jugar con su modificaci�n
	  */
	 
	 private void crearPalabraEnigma(){
		 	enigma=new StringBuffer();
		 	for (int i = 0; i < palabra.length(); i++) {
				enigma.append("_");
			}
	 }//crearPalabraEnigma
	
	 /**
	  * M�todo que crea un vector din�mico, que aumenta el tama�o seg�n las letras que introduzcamos
	  */
	 private void crearListaLetrasIntroducidas(){
		 letrasIntroducidas=new Vector();
	 };//crearListaLetrasIntroducidas
	 
	 /**
	  * M�todo que se encarga de reiniciar los fallos a Cero
	  */
	 private void ponerFallosACero(){
		 this.fallos=0;
	 };//ponerFallosACero
	
	 /**
	  * Este m�todo se encarga de poner los aciertos a Cero
	  */
	 private void ponerAciertosACero(){
		 this.aciertos=0;
	 };//ponerAciertosACero
	 

}//class
