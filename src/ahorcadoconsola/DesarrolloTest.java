package ahorcadoconsola;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DesarrolloTest {
	Desarrollo instancia;
	@Test
	public void testComprobarLetraIntroducida() {
		//NEcesito crear el obejto que voy a probar
		instancia=new Desarrollo();
		instancia.iniciarJuego();
		instancia.letrasIntroducidas.add('a');
		instancia.letrasIntroducidas.add('f');
		instancia.letrasIntroducidas.add('z');
		instancia.letrasIntroducidas.add('b');
		instancia.letrasIntroducidas.add('d');
		instancia.letrasIntroducidas.add('v');
		instancia.letrasIntroducidas.add('e');
		instancia.letra='d';
		assertTrue(instancia.comprobarLetraIntroducida());
		instancia.letra='a';
		assertTrue(instancia.comprobarLetraIntroducida());
		instancia.letra='e';
		assertTrue(instancia.comprobarLetraIntroducida());
		instancia.letra='x';
		assertTrue(!instancia.comprobarLetraIntroducida());

	}

}
