package conversormvp;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConversorGUI extends JFrame  implements ComportamientoGUI{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	// la parte publica para el eventgui
	private JTextField cantidad;

	private JTextField resultado;
	private JButton euros;
	private JButton pesetas;
	private JTextField mensaje;

	/**
	 * Create the frame.
	 */
	public ConversorGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel fondo = new JPanel(new GridLayout(3, 1));
		JPanel arriba = new JPanel(new GridLayout(2, 2));

		JPanel medio = new JPanel();
		medio.setLayout(new BoxLayout(medio, BoxLayout.X_AXIS));
		JPanel abajo = new JPanel(new GridLayout(2, 1));

		JLabel paracantidad = new JLabel("Cantidad");
		cantidad = new JTextField();
		JLabel pararesultado = new JLabel("Resultado");
		resultado = new JTextField();

		arriba.add(paracantidad);
		arriba.add(pararesultado);
		arriba.add(cantidad);
		arriba.add(resultado);

		euros = new JButton("euros");
		pesetas = new JButton("Ptas.");
		medio.add(euros);
		medio.add(pesetas);

		JLabel paramensaje = new JLabel("Mensaje");
		mensaje = new JTextField();
		abajo.add(paramensaje);
		abajo.add(mensaje);

		fondo.add(arriba);
		fondo.add(medio);
		fondo.add(abajo);

		setContentPane(fondo);
		setVisible(true);
	}

	public JTextField getCantidad() {
		return cantidad;
	}

	public JTextField getResultado() {
		return resultado;
	}

	public JButton getEuros() {
		return euros;
	}

	public JButton getPesetas() {
		return pesetas;
	}

	public JTextField getMensaje() {
		return mensaje;
	}

}
