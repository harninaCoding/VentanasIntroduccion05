package conversorCompacto;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConversorVentana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorVentana frame = new ConversorVentana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConversorVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel fondo=new JPanel(new GridLayout(3,1));
		JPanel arriba=new JPanel (new GridLayout(2,2));
		
		JPanel medio=new JPanel ();
		medio.setLayout(new BoxLayout(medio, BoxLayout.X_AXIS));
		JPanel abajo=new JPanel(new GridLayout(2,1));
		
		JLabel paracantidad=new JLabel("Cantidad");
		JTextField cantidad=new JTextField();
		JLabel pararesultado=new JLabel("Resultado");
		JTextField resultado=new JTextField();
		
		arriba.add(paracantidad);
		arriba.add(pararesultado);
		arriba.add(cantidad);
		arriba.add(resultado);
		
		JButton euros=new JButton("euros");
		JButton pesetas=new JButton("Ptas.");
		medio.add(euros);
		medio.add(pesetas);
		
		JLabel paramensaje=new JLabel("Mensaje");
		JTextField mensaje=new JTextField();
		abajo.add(paramensaje);
		abajo.add(mensaje);
		
		fondo.add(arriba);
		fondo.add(medio);
		fondo.add(abajo);
		
		setContentPane(fondo);
		setVisible(true);
	}

}
