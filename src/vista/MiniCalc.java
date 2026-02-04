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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Color;

public class MiniCalc extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNumeroUno;
	private JTextField txtNumeroDos;
	private JLabel lblResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiniCalc frame = new MiniCalc();
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
	public MiniCalc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 505);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Calculadora");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(297, 23, 89, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNumero = new JLabel("numero1");
		lblNumero.setOpaque(true);
		lblNumero.setBackground(new Color(128, 0, 64));
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumero.setBounds(66, 97, 89, 17);
		contentPane.add(lblNumero);
		
		JLabel lblNumero_1 = new JLabel("numero2");
		lblNumero_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumero_1.setBounds(66, 164, 89, 17);
		contentPane.add(lblNumero_1);
		
		JLabel lblResultadod = new JLabel("resultado");
		lblResultadod.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblResultadod.setBounds(66, 241, 89, 17);
		contentPane.add(lblResultadod);
		
		lblResultado = new JLabel(" ");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblResultado.setBounds(194, 241, 89, 17);
		contentPane.add(lblResultado);
		
		JLabel lblMensajeD = new JLabel("mensaje");
		lblMensajeD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMensajeD.setBounds(54, 398, 89, 17);
		contentPane.add(lblMensajeD);
		
		JLabel lblMensaje = new JLabel("");
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMensaje.setBounds(194, 402, 361, 17);
		contentPane.add(lblMensaje);
		NumberFormatException c;
		
		JButton btnNewButton = new JButton("Suma");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numeroUno = txtNumeroUno.getText();
				Float valorUno = null;
				if(numeroUno.isEmpty());
				try {
					valorUno = Float.valueOf(numeroUno);
				} catch (NumberFormatException e1) {
					lblMensaje.setText(e1.getMessage()+ "en valor uno");
					return;
				}
				
				String numeroDos = txtNumeroDos.getText();
				Float valorDos = null;
				try {
					valorDos = Float.valueOf(numeroDos);
				} catch (NumberFormatException e1) {
					lblMensaje.setText(e1.getMessage()+"en valor dos");
					return;
				}
				Float suma=valorUno+valorDos;
				lblResultado.setText(String.valueOf(suma));
			}
		});
		btnNewButton.setBounds(634, 386, 85, 21);
		contentPane.add(btnNewButton);
		
		txtNumeroUno = new JTextField();
		txtNumeroUno.setBackground(new Color(128, 64, 0));
		txtNumeroUno.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblMensaje.setText("");
			}
		});
		txtNumeroUno.setBounds(194, 98, 96, 19);
		contentPane.add(txtNumeroUno);
		txtNumeroUno.setColumns(10);
		
		txtNumeroDos = new JTextField();
		txtNumeroDos.setBounds(194, 165, 96, 19);
		contentPane.add(txtNumeroDos);
		txtNumeroDos.setColumns(10);
	}
}
