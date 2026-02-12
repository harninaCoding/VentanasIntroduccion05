package ahorcadoventan;
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


public class VentanaAhorcado extends JFrame {

	
	private JPanel contentPane;
	
	//mis controles
	private JTextField txtLetra;
	private JButton btnTurno;
	private JLabel lblAcertadas;
	private JLabel lblMensaje;
	private JLabel lblFallos;
	private JButton btnJugar;
	private Ahorcado ahorcado;
	

	/**
	 * Create the frame.
	 */
	public VentanaAhorcado() {
		ahorcado=new Ahorcado();
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
		btnTurno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char letra = Character.toLowerCase(txtLetra.getText().charAt(0));
				if(!ahorcado.introducirLetra(letra)) {
					// cuando fallamos
					lblMensaje.setText("has fallado en esa letra");
					if(ahorcado.comprobarTopeFallos()) {
						lblMensaje.setText("has alcanzado el tope de fallos");
						btnTurno.setEnabled(false);
					}
				}else {
					//cuando acertamos
					lblAcertadas.setText(generarMensajesAcertadas());
					if(ahorcado.comprobarPalabraCompleta()) {
						lblMensaje.setText("has acertado la pabra");
						btnTurno.setEnabled(false);
					}else {
						lblMensaje.setText("has acertado en esa letra");
					}
				}
				lblFallos.setText(String.valueOf(ahorcado.getFallos()));
			}
		});
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
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ahorcado.iniciarJuego();
				lblAcertadas.setText(generarMensajesAcertadas());
				btnTurno.setEnabled(true);
			}
		});
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


	protected String generarMensajesAcertadas() {
		int length = ahorcado.getEnigma().length();
		StringBuilder entrega=new StringBuilder();
		for (int i = 0; i < length; i++) {
			entrega.append(ahorcado.getEnigma().charAt(i));
			entrega.append(' ');			
		}
		return entrega.toString();
	}
}
