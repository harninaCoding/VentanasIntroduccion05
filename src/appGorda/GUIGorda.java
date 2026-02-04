package appGorda;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIGorda extends JFrame {

	private static final String CONSULTA_USUARIO = "consulta_usuario";
	private static final String ALTA_USUARIO = "alta_usuario";
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardLayout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIGorda frame = new GUIGorda();
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
	public GUIGorda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 455);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Usuario");
		menuBar.add(mnNewMenu);
		
		JMenuItem mnitAltaUsuario = new JMenuItem("Alta");
		mnitAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane,ALTA_USUARIO);
			}
		});
		mnNewMenu.add(mnitAltaUsuario);
		
		JMenuItem mnitConsultaUsuario = new JMenuItem("Consulta");
		mnitConsultaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane,CONSULTA_USUARIO);
			}
		});
		mnNewMenu.add(mnitConsultaUsuario);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		cardLayout = new CardLayout(0, 0);
		contentPane.setLayout(cardLayout);
		
		JPanel pnlAltaUsuario = new JPanel();
		contentPane.add(pnlAltaUsuario, ALTA_USUARIO);
		pnlAltaUsuario.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Formulario de alta de Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(268, 40, 294, 22);
		pnlAltaUsuario.add(lblNewLabel);
		
		JPanel pnlConsultaUsuario = new JPanel();
		contentPane.add(pnlConsultaUsuario, CONSULTA_USUARIO);
		pnlConsultaUsuario.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Consulta de usuario");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(302, 25, 165, 24);
		pnlConsultaUsuario.add(lblNewLabel_1);
	}
}
