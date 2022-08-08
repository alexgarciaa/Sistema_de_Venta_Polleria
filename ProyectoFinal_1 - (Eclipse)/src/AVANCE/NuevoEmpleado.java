package AVANCE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NuevoEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	String codigo = null, nombre = null, direccion = null, sexo = null, telefono = null, cargo = null;
	int sexoint, cargoint;
	Statement stm = null;
	ResultSet rst = null, rst2 = null, rst3 = null;
	int i = 0;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoEmpleado frame = new NuevoEmpleado();
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
	public NuevoEmpleado() throws SQLException {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Registro de Empleados");
		setBounds(100, 100, 656, 536);
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(62, 445, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
			
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"--Seleccione--", "M", "F"}));
		comboBox.setBounds(74, 99, 107, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"--Seleccione--", "Mesero", "Cajero"}));
		comboBox_1.setBounds(140, 164, 107, 20);
		contentPane.add(comboBox_1);
		
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Nombre");
		modelo.addColumn("Sexo");
		modelo.addColumn("Dirección");
		modelo.addColumn("Teléfono");
		modelo.addColumn("Cargo");
		Object [] fila = new Object[6];
		Conexion conn = new Conexion();
		conn.Connection();
		stm = conn.Statements();
		rst = conn.ResultS("SELECT * FROM EMPLEADO");
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
		textField_4.setText(""+i);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 260, 618, 162);
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
				comboBox.setSelectedIndex(0);
				comboBox_1.setSelectedIndex(0);
			}
		});
		mnNuevo.setIcon(new ImageIcon(NuevoEmpleado.class.getResource("/ico/nuevo.jpg")));
		menuBar.add(mnNuevo);
		
		JMenu mnGuardar = new JMenu("Guardar");
		mnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					codigo = textField_3.getText();
					nombre = textField_2.getText();				
					direccion = textField.getText();
					telefono = textField_1.getText();
					sexoint = comboBox.getSelectedIndex();
					cargoint = comboBox_1.getSelectedIndex();
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
					switch (cargoint) {
					case 0:
						break;
					case 1:
						cargo = "MESERO";
						break;
					case 2:
						cargo = "CAJERO";
						break;
				}
					if(codigo.length() == 5) {
						if(sexo != null && cargo != null) {		
							try {
								JOptionPane.showMessageDialog(null, "Empleado registrado con éxito");
								rst2 = conn.ResultS("INSERT INTO EMPLEADO VALUES"
										+ "('"+codigo+"','"+nombre+"','"+sexo+"','"+direccion+"','"+telefono+"','"+cargo+"')");							
							} catch (SQLException e) {} 
						}
						else {
							JOptionPane.showMessageDialog(null, "Ingrese correctamente los datos", "", 0);
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
		mnGuardar.setIcon(new ImageIcon(NuevoEmpleado.class.getResource("/ico/guardar.gif")));
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
					rst = conn.ResultS("SELECT * FROM EMPLEADO");
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
				textField_4.setText(""+i);
				JOptionPane.showMessageDialog(null, "Los datos han sido actualizados");						
			}
		});
		mnActualizar.setIcon(new ImageIcon(NuevoEmpleado.class.getResource("/ico/actualizar.jpg")));
		menuBar.add(mnActualizar);
		
		JMenu mnEliminar = new JMenu("Eliminar");
		mnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					String codigodelete = null, confdelete = null;
					int i2 = 0;
					codigodelete = JOptionPane.showInputDialog(null, "Ingrese el código del empleado que desea eliminar: ");	
					
					try {
						rst = conn.ResultS("SELECT * FROM EMPLEADO");
						while(rst.next()) {
							confdelete = rst.getString(1);
							if(codigodelete.equals(confdelete)) {
								i2 = 1;
							}
						}	
						
						if(i2 == 1) {
							try {
								JOptionPane.showMessageDialog(null, "El empleado ha sido eliminado");
								rst3 = conn.ResultS("DELETE FROM EMPLEADO WHERE ID_EMPLEADO = '"+codigodelete+"'");								
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
		mnEliminar.setIcon(new ImageIcon(NuevoEmpleado.class.getResource("/ico/ico_eliminar[1].gif")));
		menuBar.add(mnEliminar);
						
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(74, 132, 354, 21);
		contentPane.add(textField);
		
		JLabel label = new JLabel("Direcci\u00F3n:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Arial", Font.PLAIN, 12));
		label.setBounds(0, 131, 70, 21);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Telefono:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1.setBounds(271, 99, 70, 21);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(351, 100, 173, 21);
		contentPane.add(textField_1);
			
		JLabel label_2 = new JLabel("Sexo:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Arial", Font.PLAIN, 12));
		label_2.setBounds(27, 99, 43, 21);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(74, 68, 450, 21);
		contentPane.add(textField_2);
		
		JLabel label_3 = new JLabel("Nombre (s):");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Arial", Font.PLAIN, 12));
		label_3.setBounds(0, 67, 70, 21);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("C\u00F3digo:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Arial", Font.PLAIN, 12));
		label_4.setBounds(27, 35, 43, 21);
		contentPane.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(74, 36, 107, 21);
		contentPane.add(textField_3);
		
		JLabel lblCargoDelCajero = new JLabel("Cargo del Empleado:");
		lblCargoDelCajero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCargoDelCajero.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCargoDelCajero.setBounds(10, 164, 127, 21);
		contentPane.add(lblCargoDelCajero);
						
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Detalles de Datos de Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 21, 618, 213);
		contentPane.add(panel);
				
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Empleados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(0, 241, 618, 204);
		contentPane.add(panel_1);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(27, 445, 43, 20);
		contentPane.add(lblTotal);		
	}
}
