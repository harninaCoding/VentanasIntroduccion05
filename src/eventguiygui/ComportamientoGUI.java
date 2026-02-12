package eventguiygui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public interface ComportamientoGUI {
	//la ventana debe exponer los componentes que 
	//sufren eventos o que necesitan ser modificados
	 JTextField getTxtLetra();
	 JButton getBtnTurno();
	 JLabel getLblAcertadas();
	 JLabel getLblMensaje();
	 JLabel getLblblFallos();
	 JButton getBtnJugar();
}
