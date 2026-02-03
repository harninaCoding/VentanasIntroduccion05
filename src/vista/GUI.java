package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	public JLabel lblRegistro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Alta de Usuario");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitulo.setBounds(295, 27, 170, 34);
		contentPane.add(lblTitulo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(74, 122, 57, 23);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(141, 125, 262, 19);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApellidos.setBounds(74, 184, 57, 23);
		contentPane.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(141, 187, 390, 19);
		contentPane.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		lblRegistro = new JLabel(" ");
		lblRegistro.setBackground(new Color(0, 64, 64));
		lblRegistro.setBounds(142, 285, 399, 13);
		contentPane.add(lblRegistro);
		
		JButton btnValidar = new JButton("Validar");
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblRegistro.setText("datos escritos, nombre:"+txtNombre.getText()+" apellidos:"+txtApellidos.getText());
			}
		});
		
		btnValidar.setBounds(691, 374, 85, 21);
		contentPane.add(btnValidar);
		
		JLabel lblNewLabel = new JLabel("registro");
		lblNewLabel.setBounds(45, 285, 45, 13);
		contentPane.add(lblNewLabel);
		
		
	}
}
