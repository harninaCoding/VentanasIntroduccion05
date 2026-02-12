package eventguiygui;
import java.awt.EventQueue;

public class PrincipalVentana {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIAhorcado gui = new GUIAhorcado();
					//al pasarle la venta al event ya le dejo controlarla
					EventGUI eventGUI=new EventGUI(gui);
					gui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
