package conversormvp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventGUI {
	private ComportamientoGUI comportamientoGUI;

	public EventGUI(ComportamientoGUI comportamientoGUI) {
		super();
		this.comportamientoGUI = comportamientoGUI;
		implementarEventos();
	}

	private void implementarEventos() {
		comportamientoGUI.getEuros().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				comportamientoGUI.getResultado()
						.setText(String.valueOf(
								Float.valueOf(comportamientoGUI.getCantidad().getText()) / 166));

			}
		});

	}

}
