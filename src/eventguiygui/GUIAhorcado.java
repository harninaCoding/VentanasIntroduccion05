package eventguiygui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class GUIAhorcado extends JFrame implements ComportamientoGUI{

	
	private JPanel contentPane;
	
	//mis controles
	private JTextField txtLetra;
	private JButton btnTurno;
	private JLabel lblAcertadas;
	private JLabel lblMensaje;
	private JLabel lblFallos;
	private JButton btnJugar;

	

	/**
	 * Create the frame.
	 */
	public GUIAhorcado() {
//		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaAhorcado.class.getResource("/javax/swing/plaf/metal/icons/ocean/hardDrive.gif")));
		setTitle("Mi Ahorcado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 92, 494, 176);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		lblAcertadas = new JLabel("");
		lblAcertadas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAcertadas.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblAcertadas, BorderLayout.CENTER);
		
		JLabel tituloJuego = new JLabel("Juego del Ahorcado");
		tituloJuego.setBackground(Color.CYAN);
		tituloJuego.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		tituloJuego.setHorizontalAlignment(SwingConstants.CENTER);
		tituloJuego.setBounds(102, 11, 300, 60);
		contentPane.add(tituloJuego);
		
		btnTurno = new JButton("Turno");
		
		btnTurno.setFont(new Font("Aparajita", Font.BOLD, 24));
		btnTurno.setBackground(Color.CYAN);
//		botonPlay.setSelectedIcon(new ImageIcon(VentanaAhorcado.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		btnTurno.setBounds(370, 316, 134, 73);
		contentPane.add(btnTurno);
		
		JLabel etiquetaMensaje = new JLabel("Mensaje:");
		etiquetaMensaje.setFont(new Font("Arabic Typesetting", Font.BOLD, 20));
		etiquetaMensaje.setForeground(Color.BLACK);
		etiquetaMensaje.setBounds(10, 295, 94, 29);
		contentPane.add(etiquetaMensaje);
		
		JLabel etiquetaFallos = new JLabel("Fallos");
		etiquetaFallos.setForeground(Color.BLACK);
		etiquetaFallos.setFont(new Font("Arabic Typesetting", Font.BOLD, 20));
		etiquetaFallos.setBounds(10, 345, 65, 24);
		contentPane.add(etiquetaFallos);
		
		JLabel etiquetaLetra = new JLabel("Letra");
		etiquetaLetra.setFont(new Font("Arabic Typesetting", Font.BOLD, 20));
		etiquetaLetra.setForeground(Color.BLACK);
		etiquetaLetra.setBounds(10, 380, 65, 31);
		contentPane.add(etiquetaLetra);
		
		txtLetra = new JTextField();
		//este evento de tipo focus se queda aqui porqwue no accede a informacion de control
		txtLetra.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblMensaje.setText("");
				txtLetra.setText("");
			}
		});
		txtLetra.setBounds(102, 384, 86, 27);
		contentPane.add(txtLetra);
		txtLetra.setColumns(10);
		
		btnJugar = new JButton("Jugar");
		
		btnJugar.setBounds(10, 23, 85, 21);
		contentPane.add(btnJugar);
		
		lblFallos = new JLabel("");
		lblFallos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFallos.setBounds(102, 345, 105, 24);
		contentPane.add(lblFallos);
		
		lblMensaje = new JLabel(" ");
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMensaje.setBounds(102, 295, 246, 24);
		contentPane.add(lblMensaje);
	}


	


	@Override
	public JTextField getTxtLetra() {
		return txtLetra;
	}


	@Override
	public JButton getBtnTurno() {
		return btnTurno;
	}


	@Override
	public JLabel getLblAcertadas() {
		return lblAcertadas;
	}


	@Override
	public JLabel getLblMensaje() {
		return lblMensaje;
	}


	@Override
	public JLabel getLblblFallos() {
		return lblFallos;
	}


	@Override
	public JButton getBtnJugar() {
		return btnJugar;
	}
}
