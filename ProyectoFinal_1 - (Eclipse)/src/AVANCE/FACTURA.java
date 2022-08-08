package AVANCE;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class FACTURA extends JFrame {

	private static JPanel contentPane;
	private static JTextField textField;
	private static JPasswordField passwordField;
	private JLabel label;
    static FACTURA frame = new FACTURA();
    
    Statement stm;
    ResultSet rst;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FACTURA() {
		setType(Type.UTILITY);
		setResizable(false);
		setBackground(SystemColor.inactiveCaption);
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("System Acceso de Ingreso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 214);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USUARIO:\r\n\r\n");
		lblNewLabel.setBounds(182, 45, 85, 21);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(267, 46, 144, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A:\r\n\r\n");
		lblContrasea.setBounds(151, 75, 106, 21);
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(267, 77, 144, 22);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton.setIcon(new ImageIcon(FACTURA.class.getResource("/resources/a\u00F1adir.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(169, 148, 123, 23);
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String usuario = textField.getText();
				String password = passwordField.getText();
				String confusuario = null;
				String confpass = null;
				
				Conexion conn = new Conexion();
				conn.Connection();
				try {
					stm = conn.Statements();				
					rst = conn.ResultS("SELECT CODUSU, CLAUSU FROM USUARIO");				
					int conf = 0;
					while(rst.next()) {
						confusuario = rst.getString(1);
						confpass = rst.getString(2);
						if(usuario.equals(confusuario) && password.equals(confpass)) {
							MOSTAR mostrar = new MOSTAR();
							mostrar.show();
							frame.hide();
							conf = 1;
						}
					}
					if(conf == 0) {
						JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
					}
				} catch (SQLException e1) {}
			}
		});
		contentPane.add(btnNewButton);
		
		
		ImageIcon face = new ImageIcon(FACTURA.class.getResource("/resources/login-usuario.png")); 
		label = new JLabel();
		label.setBounds(10, 33, 131, 82);
		label.setIcon(new ImageIcon(face.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(label);
				
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_1.setIcon(new ImageIcon(FACTURA.class.getResource("/ico/icon-atras[1].gif")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(318, 148, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(141, 33, 284, 90);
		contentPane.add(panel);
	}
}
