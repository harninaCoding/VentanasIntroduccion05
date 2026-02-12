package ahorcadoconsola;

public class Almacen {
private static String palabras[]={"julio","procesador","grafica","disco","memoria","carcasa","monitor",
		"teclado","raton","impresora","escaner","cargador","bateria","sonido","altavoz","inalambrica"};

private static int valorAleatorio(){
	return (int) (Math.random()*(float)palabras.length);
}

public static String sortearPalabra(){
	return palabras[valorAleatorio()];
}

}
