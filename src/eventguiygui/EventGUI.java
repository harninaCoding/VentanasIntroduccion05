package eventguiygui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventGUI {
//Esta clase aloja los eventos de la GUI pero te ahorra tener que trabajar sobre la GUI
	//que es compleja, larga y tediosa
	private ComportamientoGUI comportamientoGUI;
	private Ahorcado ahorcado;
	
	public EventGUI(ComportamientoGUI comportamientoGUI) {
		super();
		this.comportamientoGUI = comportamientoGUI;
		this.ahorcado=new Ahorcado();
		comportamientoGUI.getBtnTurno().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char letra = Character.toLowerCase(comportamientoGUI.getTxtLetra().getText().charAt(0));
				if(!ahorcado.introducirLetra(letra)) {
					// cuando fallamos
					comportamientoGUI.getLblMensaje().setText("has fallado en esa letra");
					if(ahorcado.comprobarTopeFallos()) {
						comportamientoGUI.getLblMensaje().setText("has alcanzado el tope de fallos");
						comportamientoGUI.getBtnTurno().setEnabled(false);
					}
				}else {
					//cuando acertamos
					comportamientoGUI.getLblAcertadas().setText(generarMensajesAcertadas());
					if(ahorcado.comprobarPalabraCompleta()) {
						comportamientoGUI.getLblMensaje().setText("has acertado la pabra");
						comportamientoGUI.getBtnTurno().setEnabled(false);
					}else {
						comportamientoGUI.getLblMensaje().setText("has acertado en esa letra");
					}
				}
				comportamientoGUI.getLblblFallos().setText(String.valueOf(ahorcado.getFallos()));
			}
		});
		comportamientoGUI.getBtnJugar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ahorcado.iniciarJuego();
				comportamientoGUI.getLblAcertadas().setText(generarMensajesAcertadas());
				comportamientoGUI.getBtnTurno().setEnabled(true);
			}
		});
	}
	private  String generarMensajesAcertadas() {
		int length = ahorcado.getEnigma().length();
		StringBuilder entrega=new StringBuilder();
		for (int i = 0; i < length; i++) {
			entrega.append(ahorcado.getEnigma().charAt(i));
			entrega.append(' ');			
		}
		return entrega.toString();
	}
	
}
