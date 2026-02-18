package conversormvp;

import java.awt.EventQueue;

public class Principal {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//este especifica las ventanas
					ConversorGUI frame = new ConversorGUI();
					//este sus eventos
					EventGUI eventGUI=new EventGUI(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
