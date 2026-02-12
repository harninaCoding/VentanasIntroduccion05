package adiviannumeroventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NumeroMasAltoGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNumero;
	private JLabel lblMensaje;
	private JButton btnJugar;
	private JLabel lblColor;


	/**
	 * Create the frame.
	 */
	public NumeroMasAltoGUI() {
		Juego juego=new Juego();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Juego Adivinar");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(53, 25, 341, 28);
		contentPane.add(lblNewLabel);
		
		lblColor = new JLabel("");
		lblColor.setOpaque(true);
		lblColor.setBackground(Color.BLUE);
		lblColor.setBounds(97, 63, 246, 66);
		contentPane.add(lblColor);
		BarraColores barra=new BarraColores();
		barra.setBounds(97, 156, 246, 15);
		contentPane.add(barra);
		
		JLabel lblNewLabel_2 = new JLabel("temperatura");
		lblNewLabel_2.setBounds(10, 63, 57, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("frio");
		lblNewLabel_3.setBounds(353, 156, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("calor");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(42, 158, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(100, 210, 96, 19);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("numero");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(42, 213, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = txtNumero.getText();
				int checkTry = juego.checkTry(Integer.valueOf(text));
				if(checkTry!=0) {
					lblMensaje.setText("el valor no es correcto "+text);
				}else {
					lblMensaje.setText("Genial!! es correcto "+text);
					btnJugar.setEnabled(false);
				}
				actualizarColorLabel(lblColor, checkTry, juego.getMin(), juego.getMax());
			}
		});
		btnJugar.setBounds(341, 209, 85, 21);
		contentPane.add(btnJugar);
		
		JLabel lblNewLabel_6 = new JLabel("Mensaje");
		lblNewLabel_6.setBounds(10, 240, 57, 13);
		contentPane.add(lblNewLabel_6);
		
		lblMensaje = new JLabel("");
		lblMensaje.setBounds(67, 240, 359, 13);
		contentPane.add(lblMensaje);
	}
	
	public void actualizarColorLabel(JLabel label, int n, int min, int max) {
	    // 1. Aseguramos que n esté dentro de los límites (clamping)
	    int valorClipped = Math.max(min, Math.min(max,Math.abs(n)));

	    // 2. Calculamos el factor (0.0 = muy cerca de min, 1.0 = muy cerca de max)
	    float factor = (float) (valorClipped - min) / (max - min);

	    // 3. Mapeamos el factor al rango de color.
	    // El matiz (Hue) va de 0.0 (Rojo) a 0.66f (Azul).
	    float hue = factor * 0.66f; 

	    // 4. Creamos el color (Saturación y Brillo al máximo para que sea vibrante)
	    Color colorResultado = Color.getHSBColor(hue, 1.0f, 1.0f);

	    // 5. Aplicamos al label
	    label.setBackground(colorResultado);
	    label.setOpaque(true); // ¡Importante! En Swing los JLabel suelen ser transparentes por defecto
	}
}
