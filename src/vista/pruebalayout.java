package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JPasswordField;

public class pruebalayout extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pruebalayout frame = new pruebalayout();
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
	public pruebalayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("New label");
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		contentPane.add(btnNewButton);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		contentPane.add(rdbtnNewRadioButton);
		
		JTextArea textArea = new JTextArea();
		contentPane.add(textArea);
		
		JComboBox comboBox = new JComboBox();
		contentPane.add(comboBox, BorderLayout.WEST);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		contentPane.add(tglbtnNewToggleButton, BorderLayout.EAST);
		
		JTextArea textArea_1 = new JTextArea();
		contentPane.add(textArea_1, BorderLayout.SOUTH);
		
		passwordField = new JPasswordField();
		contentPane.add(passwordField, BorderLayout.NORTH);
	}

}
