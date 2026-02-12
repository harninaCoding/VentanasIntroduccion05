package numeromasaltoventana;

import java.awt.EventQueue;

public class Principal {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumeroMasAltoGUI frame = new NumeroMasAltoGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
