package AVANCE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class MOSTAR extends JFrame {

	private JPanel contentPane;
	static MOSTAR frame = new MOSTAR();

	public MOSTAR() {
		setType(Type.UTILITY);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("/resources/58c0b46819760.jpeg"));
		setTitle(" ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 376);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPolleriaZurita = new JLabel("\"POLLERIA BRIAN'S\"");
		lblPolleriaZurita.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPolleriaZurita.setBounds(148, 11, 182, 39);
		contentPane.add(lblPolleriaZurita);
		
		JButton btnRealizarPedido = new JButton("Realizar Pedido");
		btnRealizarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DESARROLLO desarrollo = new DESARROLLO();
				desarrollo.show();
				MOSTAR.this.hide();
			}
		});
		btnRealizarPedido.setBounds(299, 76, 125, 39);
		contentPane.add(btnRealizarPedido);
		
		JButton btnNewButton_1 = new JButton("Nuevo Usuario");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new REGISTRO().show();			
			}
		});
		btnNewButton_1.setBounds(299, 226, 125, 39);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Empleados");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new NuevoEmpleado().show();
				} catch (SQLException e1) {}
			}
		});
		btnNewButton.setBounds(299, 176, 125, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Clientes");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new NuevoCliente().show();
				} catch (SQLException e) {}
			}
		});
		btnNewButton_2.setBounds(299, 126, 125, 39);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Salir");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(MOSTAR.class.getResource("/ico/icon-atras[1].gif")));
		btnNewButton_3.setBounds(10, 288, 89, 39);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon(MOSTAR.class.getResource("/resources/giphy.gif")));
		lblNewLabel.setBounds(0, 38, 475, 309);
		contentPane.add(lblNewLabel);
	}
}
