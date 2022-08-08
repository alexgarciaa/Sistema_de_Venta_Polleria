package AVANCE;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class REGISTRO extends JFrame {
	public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				REGISTRO frame = new REGISTRO();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}
		
	private static JPanel contentPane;
	private static JTextField textField;
	private static JPasswordField passwordField;
	private static JPasswordField passwordField_1;
		
	//Variables
	static String Newusuario = "";
	static String Nombreusuario = "";
	private static String Newpass = "";
	private static String Confpass = "";  
    private static JLabel lblNewLabel;
    private static JTextField textField_1;
    Statement stm = null;
	ResultSet rst = null;
	private JPanel panel;
	private JMenuBar menuBar;
       
	public REGISTRO() {
		setResizable(false);
		
		setTitle("Registro Nuevo Usuario");
		setBackground(SystemColor.inactiveCaption);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 566, 229);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnRegistrar = new JButton("Registrar");
		menuBar.add(btnRegistrar);
		btnRegistrar.setIcon(new ImageIcon(REGISTRO.class.getResource("/ico/guardar.gif")));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nombreusuario = textField_1.getText();
				Newusuario = textField.getText();
				Newpass = passwordField.getText();
				Confpass = passwordField_1.getText();
					        
				if (Newusuario.equals("") || Newusuario.length() != 5) {
					JOptionPane.showMessageDialog(null, "Debe ingresar código de usuario de 5 dígitos", "", 0);
				}
				else
					if (Newpass.equals("") || Newpass.length() != 7) {
						JOptionPane.showMessageDialog(null, "Debe ingresar una contraseña de 7 dígitos", "", 0);
					}
					else
						if (Newpass.equals(Confpass)) {
							Conexion conn = new Conexion();
							conn.Connection();
							try {
								stm = conn.Statements();
								rst = conn.ResultS("INSERT INTO USUARIO VALUES"
										+ "('"+Newusuario+"','"+Nombreusuario+"','"+Newpass+"')");
							} catch (SQLException e2) {}
							
							JOptionPane.showMessageDialog(null, "Registrado con éxito");
							textField.setText("");
							passwordField.setText("");
							passwordField_1.setText("");	
							textField_1.setText("");							
							
						}
						else {
							JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "", 0);
						}
			}
		});
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreDeUsuario = new JLabel("Código de Usuario:");
		lblNombreDeUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreDeUsuario.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombreDeUsuario.setBounds(169, 30, 107, 21);
		contentPane.add(lblNombreDeUsuario);
		
		JLabel lblConfirmarContrasea = new JLabel("Confirmar contrase\u00F1a:");
		lblConfirmarContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmarContrasea.setFont(new Font("Arial", Font.PLAIN, 12));
		lblConfirmarContrasea.setBounds(150, 125, 129, 21);
		contentPane.add(lblConfirmarContrasea);
		
		textField = new JTextField();
		textField.setBounds(286, 30, 107, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(286, 62, 213, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(286, 95, 156, 21);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(289, 127, 156, 21);
		contentPane.add(passwordField_1);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setFont(new Font("Arial", Font.PLAIN, 12));
		lblContrasea.setBounds(182, 93, 93, 21);
		contentPane.add(lblContrasea);
			
		lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(216, 61, 61, 21);
		contentPane.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(134, 11, 401, 151);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(REGISTRO.class.getResource("/resources/imagesCAU7BDN7.gif")));
		lblNewLabel_1.setBounds(10, 30, 132, 116);
		contentPane.add(lblNewLabel_1);
		setVisible(true);													
	}
	
	void Conexion() throws SQLException{
	}
}
