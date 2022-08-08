package AVANCE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class NuevoCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private JTextField textField_5;
	String codigo = null, apellido = null, nombre = null, direccion = null, sexo = null, telefono = null;
	int sexoint;
	Statement stm = null;
	ResultSet rst = null, rst2 = null, rst3 = null;
	int i = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoCliente frame = new NuevoCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public NuevoCliente() throws SQLException {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Registro de Clientes");
		setBounds(100, 100, 643, 487);
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"--Seleccione--", "M", "F"}));
		comboBox.setBounds(73, 89, 107, 20);
		contentPane.add(comboBox);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(60, 389, 70, 21);
		contentPane.add(textField_5);
		
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Sexo");
		modelo.addColumn("Dirección");
		modelo.addColumn("Teléfono");
		Object [] fila = new Object[6];		
		Conexion conn = new Conexion();
		conn.Connection();
		stm = conn.Statements();
		rst = conn.ResultS("SELECT * FROM CLIENTE");
		while(rst.next()) {
			fila[0] = rst.getString(1);
			fila[1] = rst.getString(2);
			fila[2] = rst.getString(3);
			fila[3] = rst.getString(4);
			fila[4] = rst.getString(5);
			fila[5] = rst.getString(6);
			modelo.addRow(fila);
			i = i+1;
		}
		textField_5.setText(""+i);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 220, 590, 165);
		contentPane.add(scrollPane);
		table = new JTable(modelo);
		scrollPane.setViewportView(table);
		
		JMenu mnNuevo = new JMenu("Nuevo");
		mnNuevo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				comboBox.setSelectedIndex(0);
			}
		});
		mnNuevo.setIcon(new ImageIcon(NuevoCliente.class.getResource("/ico/nuevo.png")));
		menuBar.add(mnNuevo);
		
		JMenu mnGuardar =new JMenu("Guardar");
		mnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					codigo = textField.getText();
					nombre = textField_2.getText();
					apellido = textField_1.getText();				
					direccion = textField_3.getText();
					telefono = textField_4.getText();
					sexoint = comboBox.getSelectedIndex();
					switch (sexoint) {
						case 0:
							break;
						case 1:
							sexo = "M";
							break;
						case 2:
							sexo = "F";
							break;
					}
					if(codigo.length() == 5) {
						if(sexo != null) {
							try {
								JOptionPane.showMessageDialog(null, "Cliente registrado con éxito");
								rst2 = conn.ResultS("INSERT INTO CLIENTE VALUES"
										+ "('"+codigo+"','"+nombre+"','"+apellido+"','"+sexo+"','"+direccion+"','"+telefono+"')");							
							} catch (SQLException e) {} 
						}
						else {
							JOptionPane.showMessageDialog(null, "Debe especificar un sexo", "", 0);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "El código debe contener 5 dígitos", "", 0);
					}
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Ingrese correctamente los datos", "", 0);
				}
			}
		});		
		mnGuardar.setIcon(new ImageIcon(NuevoCliente.class.getResource("/ico/guardar.gif")));
		menuBar.add(mnGuardar);
				
		JMenu mnActualizar = new JMenu("Actualizar");
		mnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				do {
					modelo.removeRow(i-1);
					i = i-1;
				}
				while(i>0);
				
				try {
					rst = conn.ResultS("SELECT * FROM CLIENTE");
					while(rst.next()) {
						fila[0] = rst.getString(1);
						fila[1] = rst.getString(2);
						fila[2] = rst.getString(3);
						fila[3] = rst.getString(4);
						fila[4] = rst.getString(5);
						fila[5] = rst.getString(6);
						modelo.addRow(fila);
						i = i+1;
					}
				} catch (SQLException e) {}
				textField_5.setText(""+i);
				JOptionPane.showMessageDialog(null, "Los datos han sido actualizados");
			}			
		});
		mnActualizar.setIcon(new ImageIcon(NuevoCliente.class.getResource("/ico/actualizar.gif")));
		menuBar.add(mnActualizar);
		
		JMenu mnEliminar = new JMenu("Eliminar");
		mnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {		
				try {
					String codigodelete = null, confdelete = null;
					int i2 = 0;
					codigodelete = JOptionPane.showInputDialog(null, "Ingrese el código del cliente que desea eliminar: ");	
					
					try {
						rst = conn.ResultS("SELECT * FROM CLIENTE");
						while(rst.next()) {
							confdelete = rst.getString(1);
							if(codigodelete.equals(confdelete)) {
								i2 = 1;
							}
						}	

						if(i2 == 1) {
							try {
								JOptionPane.showMessageDialog(null, "El cliente ha sido eliminado");
								rst3 = conn.ResultS("DELETE FROM CLIENTE WHERE ID_CLIENTE = '"+codigodelete+"'");								
							} 
							catch (SQLException e1) {}						
						}
						if(i2 == 0) {
							JOptionPane.showMessageDialog(null, "No se encontro el código");
						}
					} 
					catch (SQLException e) {}
					}
				catch(Exception e) {}
			}
		});
		mnEliminar.setIcon(new ImageIcon(NuevoCliente.class.getResource("/ico/ico_eliminar[1].gif")));
		menuBar.add(mnEliminar);
				
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCdigo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCdigo.setBounds(26, 25, 43, 21);
		contentPane.add(lblCdigo);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(73, 26, 107, 21);
		contentPane.add(textField);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellidos.setFont(new Font("Arial", Font.PLAIN, 12));
		lblApellidos.setBounds(-1, 57, 70, 21);
		contentPane.add(lblApellidos);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(73, 57, 242, 21);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(421, 58, 173, 21);
		contentPane.add(textField_2);
		
		JLabel lblNombre = new JLabel("Nombre (s):");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombre.setBounds(341, 57, 70, 21);
		contentPane.add(lblNombre);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSexo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSexo.setBounds(26, 89, 43, 21);
		contentPane.add(lblSexo);
			
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccin.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDireccin.setBounds(-1, 118, 70, 21);
		contentPane.add(lblDireccin);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(73, 119, 354, 21);
		contentPane.add(textField_3);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTelefono.setBounds(-1, 150, 70, 21);
		contentPane.add(lblTelefono);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(73, 151, 173, 21);
		contentPane.add(textField_4);
				
		JLabel lblNewLabel = new JLabel("Total:");
		lblNewLabel.setBounds(26, 395, 46, 14);
		contentPane.add(lblNewLabel);
			
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBorder(new TitledBorder(null, "Detalle de Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(6, 11, 611, 165);
		contentPane.add(panel);
				
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBorder(new TitledBorder(null, "Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(6, 200, 611, 213);
		contentPane.add(panel_1);
	}
}
