package ahorcadoconsola;
import java.util.Scanner;


//Esto es cronologico
public class Principal {
	public static void main(String[] args) {
		char entrada ='s';
		while (entrada=='s'){
			Desarrollo juego = new Desarrollo();
			//
			Scanner leer = new Scanner(System.in);
			System.out.println("Bienvenido al ahorcado");
			juego.iniciarJuego();
			boolean acaba=false;
			int longitud = juego.enigma.length();
			do{
				System.out.println(juego.enigma);
				System.out.println("La palabra tiene: "+longitud+" letras");
				System.out.println("Dame una letra letra");
				juego.introducirLetra(leer.nextLine().charAt(0));
				int i=0;
				while(i!=juego.letrasIntroducidas.size()){
					System.out.println("Letras fallidas: "+juego.letrasIntroducidas.get(i));
					i+=1;
				}//while
				if(juego.aciertos==juego.palabra.length())
					acaba=true;
			}while(juego.fallos!=5 && acaba==false);
			if(juego.fallos==5){
				System.out.println("------------------------------");
				System.out.println("Se acabo el juego, has perdido");
				System.out.println("La palabra era: '"+juego.palabra+"' ");
				System.out.println("Pulsa 's' para seguir jugando, cualquier otra letra para salir");
				entrada=leer.nextLine().charAt(0);
			}
			else{
				if(juego.aciertos==juego.palabra.length())
					System.out.println("Has ganado, enorabuena campeon");
				System.out.println("Pulsa 's' para seguir jugando, cualquier otra letra para salir");
				entrada=leer.nextLine().charAt(0);
			}//else
			//			if(juego.fallos==5)
			//				System.out.println("Se acabo el juego");
			//			System.out.println("Pulsa 's' para seguir jugando, cualquier otra letra para salir");
			//			entrada=leer.nextLine().charAt(0);
		}//while







	}//main
}//class
