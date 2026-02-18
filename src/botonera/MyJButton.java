package botonera;

import javax.swing.JButton;

public class MyJButton extends JButton {
	private Coordenada coordenada;

	public MyJButton(Coordenada coordenada) {
		super();
		this.coordenada = coordenada;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}
	
}
