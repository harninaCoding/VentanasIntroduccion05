package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConversorEuroPta extends JFrame {

	private static final double conversion = 166.38;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCantidad;
	private JLabel lblResultado;
	private JLabel lblMensaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorEuroPta frame = new ConversorEuroPta();
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
	public ConversorEuroPta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 234, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Conversor");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(74, 10, 69, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblCantidad = new JLabel("cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantidad.setBounds(23, 47, 69, 22);
		contentPane.add(lblCantidad);
		
		JLabel lblResultadoB = new JLabel("resultado");
		lblResultadoB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblResultadoB.setBounds(128, 47, 69, 22);
		contentPane.add(lblResultadoB);
		
		JLabel lblMensajef = new JLabel("Mensaje");
		lblMensajef.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMensajef.setBounds(23, 164, 69, 22);
		contentPane.add(lblMensajef);
		
		lblMensaje = new JLabel(" ");
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMensaje.setBounds(23, 208, 159, 22);
		contentPane.add(lblMensaje);
		
		JButton btnNewButton = new JButton("Euros");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblResultado.setText(String.valueOf(Float.valueOf(txtCantidad.getText())/conversion));
			}
		});
		btnNewButton.setBounds(23, 114, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnPtas = new JButton("Ptas");
		btnPtas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblResultado.setText(String.valueOf(Float.valueOf(txtCantidad.getText())*conversion));
			}
		});
		btnPtas.setBounds(118, 114, 85, 21);
		contentPane.add(btnPtas);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(22, 79, 69, 19);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		lblResultado = new JLabel(" ");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblResultado.setBounds(118, 79, 78, 22);
		contentPane.add(lblResultado);
	}

}
