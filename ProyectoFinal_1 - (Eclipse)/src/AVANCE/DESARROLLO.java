package AVANCE;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSpinner;
import java.awt.Window.Type;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;

@SuppressWarnings("unused")
public class DESARROLLO extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	JButton btnNewButton = new JButton("Imprimir");
	
	//Variables
	int a, b, c, d;
	int Pa = 0, Pb = 0, Pc = 0, Pd = 0;
	int cantA, cantB, cantC, cantD;	
	
	String Direccion = "", Nombre = "", Emite = "Boleta";
	double Precio, Descuento, PrecioT;
	
	String ComboP, Bebida, Comp, PCarta;
	
	//Optional Variables
	String RUC = "", RazonS = "";
	
	private JTextField textField_6;
	private JTextField textField_7;
	
	static DESARROLLO frame = new DESARROLLO();
	
	public DESARROLLO() {
		setType(Type.UTILITY);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(SystemColor.inactiveCaption);
		setResizable(false);
		setBounds(100, 100, 997, 503);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(625, 14, 356, 450);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setText(null);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
		JLabel lblExtra = new JLabel("COMPLEMENTOS:");
		lblExtra.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblExtra.setBounds(310, 14, 118, 19);
		contentPane.add(lblExtra);
					
		JLabel lblDireccin = new JLabel("DIRECCI\u00D3N:");
		lblDireccin.setBounds(10, 259, 95, 25);
		contentPane.add(lblDireccin);
		
		JLabel lblNewLabel = new JLabel("NOMBRE:");
		lblNewLabel.setBounds(10, 288, 95, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblMen = new JLabel("COMBO POLLO:");
		lblMen.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMen.setBounds(10, 11, 118, 25);							
		contentPane.add(lblMen);
		
		JLabel lblBebidas = new JLabel("BEBIDAS:");
		lblBebidas.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBebidas.setBounds(460, 11, 108, 25);
		contentPane.add(lblBebidas);
		
		JLabel lblPrecio = new JLabel("PRECIO:");
		lblPrecio.setBounds(419, 233, 82, 14);
		contentPane.add(lblPrecio);
		
		JLabel lblDescuento = new JLabel("DESCUENTO:");
		lblDescuento.setBounds(419, 264, 95, 14);
		contentPane.add(lblDescuento);
		
		JLabel lblPrecioTotal = new JLabel("PRECIO TOTAL:");
		lblPrecioTotal.setBounds(419, 293, 95, 14);
		contentPane.add(lblPrecioTotal);
		
		JLabel lblRaznSocial = new JLabel("RAZ\u00D3N SOCIAL:");
		lblRaznSocial.setBounds(10, 403, 118, 19);
		lblRaznSocial.setVisible(false);
		contentPane.add(lblRaznSocial);
		
		JLabel lblRuc = new JLabel("RUC:");
		lblRuc.setBounds(10, 433, 75, 19);
		lblRuc.setVisible(false);
		contentPane.add(lblRuc);
				
		textField_1 = new JTextField();
		textField_1.setBounds(130, 260, 266, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(79, 289, 317, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(511, 230, 75, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setText("0");
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(511, 261, 75, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		textField_4.setText("0");
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(511, 290, 75, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		textField_5.setText("0");
		
		textField_6 = new JTextField();
		textField_6.setBounds(130, 401, 266, 22);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		textField_6.setVisible(false);
		
		textField_7 = new JTextField();
		textField_7.setBounds(130, 431, 266, 22);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		textField_7.setVisible(false);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(79, 181, 49, 19);
		contentPane.add(spinner);
		spinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				//Combo Pollo
					cantA = (Integer)spinner.getValue();
					textField_3.setText(""+(Pa*cantA+Pb*cantB+Pc*cantC+Pd*cantD));
					textField_5.setText(""+(Pa*cantA+Pb*cantB+Pc*cantC+Pd*cantD));
					if (cantA<0) {
						spinner.setValue(0);
					}
			}
		});
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(537, 181, 49, 19);
		contentPane.add(spinner_1);
		spinner_1.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				//Bebidas
					cantB = (Integer)spinner_1.getValue();
					textField_3.setText(""+(Pa*cantA+Pb*cantB+Pc*cantC+Pd*cantD));
					textField_5.setText(""+(Pa*cantA+Pb*cantB+Pc*cantC+Pd*cantD));
					if (cantB<0) {
						spinner_1.setValue(0);
					}
			}
		});
		
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(401, 181, 49, 19);
		contentPane.add(spinner_2);
		spinner_2.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				//Complementos
					cantC = (Integer)spinner_2.getValue();	
					textField_3.setText(""+(Pa*cantA+Pb*cantB+Pc*cantC+Pd*cantD));
					textField_5.setText(""+(Pa*cantA+Pb*cantB+Pc*cantC+Pd*cantD));
					if (cantC<0) {
						spinner_2.setValue(0);
					}
			}
		});
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(251, 181, 49, 19);
		contentPane.add(spinner_3);
		spinner_3.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				//Platos a la carta
					cantD = (Integer)spinner_3.getValue();		
					textField_3.setText(""+(Pa*cantA+Pb*cantB+Pc*cantC+Pd*cantD));
					textField_5.setText(""+(Pa*cantA+Pb*cantB+Pc*cantC+Pd*cantD));
					if (cantD<0) {
						spinner_3.setValue(0);
					}
			}
		});
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"---SELECCIONE---", "1 POLLO", "1/2 POLLO", "1/4 POLLO"}));
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"---SELECCIONE---", "1L INKA COLA", "1L COCA COLA", "1L CHICHA MORADA"}));
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"---SELECCIONE---", "PAPAS", "ENSALADA", "SALCHIPAPA", "ALITA BROSTER"}));
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"---SELECCIONE---", "CHAUFA DE POLLO", "POLLO A LA PARRILLA", "POLLO BROSTER", "ARROZ A LA CUBANA"}));
		comboBox.addActionListener(new ActionListener() {
			@Override
			//Combo Pollo
			public void actionPerformed(ActionEvent e) {
					a = comboBox.getSelectedIndex();
					switch (a) {
						case 0: 
							Pa = 0;
							break;
						case 1:
							Pa = 40;
							break;
						case 2:
							Pa = 22;
							break;
						case 3:
							Pa = 12;
					}
					
					if (true) {
						textField_3.setText(""+(Pa*cantA+Pb*cantB+Pc*cantC+Pd*cantD));	
						textField_5.setText(""+(Pa*cantA+Pb*cantB+Pc*cantC+Pd*cantD));
					}
			}
		});
		
		comboBox_1.addActionListener(new ActionListener() {
			@Override
			//Bebidas
			public void actionPerformed(ActionEvent e) {
					b = comboBox_1.getSelectedIndex();
					switch (b) {
					case 0: 
						Pb = 0;
						break;
					case 1:
						Pb = 5;
						break;
					case 2:
						Pb = 5;
						break;
					case 3:
						Pb = 8;
						break;
				}
				
				if (true) {
					textField_3.setText(""+(Pa*cantA+Pb*cantB+Pc*cantC+Pd*cantD));
					textField_5.setText(""+(Pa*cantA+Pb*cantB+Pc*cantC+Pd*cantD));
				}
			}
		});
		
		comboBox_2.addActionListener(new ActionListener() {
			@Override
			//Complementos
			public void actionPerformed(ActionEvent e) {
					c = comboBox_2.getSelectedIndex();		
					switch (c) {
					case 0: 
						Pc = 0;
						break;
					case 1:
						Pc = 8;
						break;
					case 2:
						Pc = 8;
						break;
					case 3:
						Pc = 10;
						break;
					case 4:
						Pc = 10;
						break;
				}
				
				if (true) {
					textField_3.setText(""+(Pa*cantA+Pb*cantB+Pc*cantC+Pd*cantD));	
					textField_5.setText(""+(Pa*cantA+Pb*cantB+Pc*cantC+Pd*cantD));
				}
			}
		});
		
		comboBox_3.addActionListener(new ActionListener() {
			@Override
			//Platos a la Carta
			public void actionPerformed(ActionEvent e) {
					d = comboBox_3.getSelectedIndex();	
					switch (d) {
					case 0: 
						Pd = 0;
						break;
					case 1:
						Pd = 12;
						break;
					case 2:
						Pd = 15;
						break;
					case 3:
						Pd = 12;
						break;
					case 4:
						Pd = 10;
						break;
				}
				
				if (true) {
					textField_3.setText(""+(Pa*cantA+Pb*cantB+Pc*cantC+Pd*cantD));
					textField_5.setText(""+(Pa*cantA+Pb*cantB+Pc*cantC+Pd*cantD));
				}
			}
		});
		
		comboBox.setBounds(10, 33, 140, 24);
		contentPane.add(comboBox);
		comboBox_1.setBounds(460, 33, 140, 25);
		contentPane.add(comboBox_1);
		comboBox_3.setBounds(160, 34, 140, 23);
		contentPane.add(comboBox_3);
		comboBox_2.setBounds(310, 33, 140, 25);
		contentPane.add(comboBox_2);
		
		JRadioButton rdbtnBoleta = new JRadioButton("BOLETA");
		rdbtnBoleta.setBounds(123, 347, 109, 29);
		rdbtnBoleta.setSelected(true);
		contentPane.add(rdbtnBoleta);
		
		JRadioButton rdbtnFactura = new JRadioButton("FACTURA");
		rdbtnFactura.setBounds(234, 347, 109, 29);
		contentPane.add(rdbtnFactura);
		
		rdbtnBoleta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnBoleta.isSelected() == true) {
					rdbtnFactura.setSelected(false);
					
					lblRaznSocial.setVisible(false);
					lblRuc.setVisible(false);
					textField_6.setVisible(false);
					textField_7.setVisible(false);
					Emite = "Boleta";
				}
				if (rdbtnBoleta.isSelected() == false) {
					rdbtnBoleta.setSelected(true);
				}
			}			
		});
		
		rdbtnFactura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnFactura.isSelected() == true) {
					rdbtnBoleta.setSelected(false);
					
					lblRaznSocial.setVisible(true);
					lblRuc.setVisible(true);
					textField_6.setVisible(true);
					textField_7.setVisible(true);
					Emite = "Factura";
				}
				if (rdbtnFactura.isSelected() == false) {
					rdbtnFactura.setSelected(true);
				}
			}			
		});
			
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setVisible(true);
				LocalDate Fecha = LocalDate.now();
				LocalDateTime dt = LocalDateTime.now();
				
				DateTimeFormatter dtFor = DateTimeFormatter.ofPattern("HH:mm:ss");
				
				String Hora = dt.format(dtFor);
								
				Direccion = textField_1.getText();
				Nombre = textField_2.getText();
				
				Precio = Double.parseDouble(textField_3.getText());
				Descuento = Double.parseDouble(textField_4.getText());
				PrecioT = Pa*cantA+Pb*cantB+Pc*cantC+Pd*cantD - Descuento;
				double IGV = 18*PrecioT/100;
				double OpGravada = PrecioT - IGV;
				
				RazonS = textField_6.getText();
				RUC = textField_7.getText();
				
				switch (a) {
				case 0: 
					ComboP = "";
					break;
				case 1:
					ComboP = "1 Pollo";
					break;
				case 2:
					ComboP = "1/2 Pollo";
					break;
				case 3:
					ComboP = "1/4 Pollo";
				}
				
				switch (b) {
				case 0: 
					Bebida = "";
					break;
				case 1:
					Bebida = "1L Inka Cola";
					break;
				case 2:
					Bebida = "1L Coca Cola";
					break;
				case 3:
					Bebida = "1L Chicha Morada";
					break;
				}
				
				switch (c) {
				case 0: 
					Comp = "";
					break;
				case 1:
					Comp = "Papas";
					break;
				case 2:
					Comp = "Ensalada";
					break;
				case 3:
					Comp = "Salchipapa";
					break;
				case 4:
					Comp = "Alita Broster";
					break;
				}
				
				switch (d) {
				case 0: 
					PCarta = "";
					break;
				case 1:
					PCarta = "Chaufa de Pollo";
					break;
				case 2:
					PCarta = "Pollo a la Parrila";
					break;
				case 3:
					PCarta = "Pollo Broster";
					break;
				case 4:
					PCarta = "Arroz a la Cubana";
					break;
				}
				
				
				textArea.setText("                    	  ---'Polleria Brian's'---\n"
								+"                           RUC: 20553322145\n"
								+"                          Jazmines 546 - Comas"
								+"                      	  "
								+"                          "+Emite+" de Venta\n"
								+"\n"
								+"Fecha: "+Fecha+"\t|Nombre:\n"
								+"Hora: "+Hora+"\t|"+Nombre+"\n");
				
				if (rdbtnBoleta.isSelected() == true) {
				textArea.append(""+"Local: "+"\t\t|\n"
								+"		|\n"
								+""+"\t\t|\n"
								+""+"Dirección: "+Direccion+"	|\n");
				}
				else
					if (rdbtnFactura.isSelected() == true) {
						textArea.append(""+"Local: "+"\t\t|Razón Social:\n"
								+"		|"+RazonS+"\n"
								+""+"\t\t|RUC:\n"
								+""+"Dirección: "+Direccion+"	|"+RUC+"\n");
					}
				
				textArea.append(""+"____________________________________________\n"
								+"Descripción del Producto\tCantidad\tPrecio\n");
				if (a != 0 && cantA != 0) {
					textArea.append("  "+ComboP+"\t\t"+cantA+"\t"+Pa*cantA+"\n");
				}
				if (b != 0 && cantB != 0) {
					textArea.append("  "+Bebida+"\t\t"+cantB+"\t"+Pb*cantB+"\n");
				}
				if (c != 0 && cantC != 0) {
					textArea.append("  "+Comp+"\t\t"+cantC+"\t"+Pc*cantC+"\n");
				}
				if (d != 0 && cantD != 0) {
					textArea.append("  "+PCarta+"\t"+cantD+"\t"+Pd*cantD+"\n");
				}
				textArea.append("\t\t\t___");				
				textArea.append("\n\t\tOp. Gravada:	"+OpGravada
								+"\n\t\tIGV:	"+IGV
								+"\n\t\tTotal:	"+PrecioT);
				textArea.append("\n____________________________________________");
				textArea.append("\n\nRepresentación impresa de la boleta, si desea una versión\n"
						+ "electrónica sirvase a dejar su correo"
						+ "\n	Gracias por comprar en Polleria Brian's");
			}
		});
		btnGuardar.setBounds(441, 320, 108, 25);
		contentPane.add(btnGuardar);
		
		JLabel lblPlatosALa = new JLabel("PLATOS A LA CARTA:");
		lblPlatosALa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPlatosALa.setBounds(160, 16, 150, 14);
		contentPane.add(lblPlatosALa);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCantidad.setBounds(10, 183, 82, 14);
		contentPane.add(lblCantidad);
		
		JLabel lblNewLabel_2 = new JLabel("EMITE:");
		lblNewLabel_2.setBounds(10, 353, 82, 19);
		contentPane.add(lblNewLabel_2);		
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnNewButton.setVisible(false);
				textField_1.setText("");
				textField_2.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textArea.setText(null);
				comboBox.setSelectedIndex(0);
				comboBox_1.setSelectedIndex(0);
				comboBox_2.setSelectedIndex(0);
				comboBox_3.setSelectedIndex(0);
				spinner.setValue(0);
				spinner_1.setValue(0);
				spinner_2.setValue(0);
				spinner_3.setValue(0);
			}
		});
		btnNuevo.setBounds(441, 350, 108, 25);
		contentPane.add(btnNuevo);
		
		
		ImageIcon polloima = new ImageIcon(DESARROLLO.class.getResource("/resources/58c0b46819760.jpeg"));
		JLabel label = new JLabel();
		label.setBounds(20, 77, 125, 72);
		label.setIcon(new ImageIcon(polloima.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(label);
		
		
		ImageIcon mostroima =new ImageIcon(DESARROLLO.class.getResource("/resources/mostr.jpg"));
		JLabel Label_1 = new JLabel();
		Label_1.setBounds(170, 77, 130, 72);
		Label_1.setIcon(new ImageIcon(mostroima.getImage().getScaledInstance(Label_1.getWidth(), Label_1.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(Label_1);
		
		
		ImageIcon cola = new ImageIcon(DESARROLLO.class.getResource("/resources/COCA.png"));
		JLabel Label_3 = new JLabel("");
		Label_3 .setBounds(505, 77, 63, 72);
		Label_3.setIcon(new ImageIcon(cola.getImage().getScaledInstance(Label_3.getWidth(),Label_3.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(Label_3 );
		
		ImageIcon ensalada= new ImageIcon(DESARROLLO.class.getResource("/resources/ensala.jpg"));
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(320, 77, 130, 64);
		lblNewLabel_1.setIcon(new ImageIcon(ensalada.getImage().getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(),Image.SCALE_SMOOTH)));
		contentPane.add(lblNewLabel_1);				
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				MOSTAR mostrar = new MOSTAR();
				mostrar.show();
				DESARROLLO.this.hide();
			}
		});
		btnAtras.setBounds(441, 430, 108, 25);
		contentPane.add(btnAtras);
			
		btnNewButton.setVisible(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Document document = new Document();
				try {				
					JFileChooser jF1= new JFileChooser();
					String ruta = "";
					try {
						if(jF1.showSaveDialog(null)==jF1.APPROVE_OPTION) {
							ruta = jF1.getSelectedFile().getAbsolutePath();

						}
					} catch (Exception ex){}
					if(new File(ruta).exists()) {
						int result = JOptionPane.showConfirmDialog(null, 
								"El archivo ya existe,deseas reemplazarlo?",null, JOptionPane.YES_NO_OPTION);
						if(result == JOptionPane.YES_OPTION) {
							try {
								PdfWriter.getInstance(document, new FileOutputStream(""+ruta));
							} 
							catch (FileNotFoundException e1) {} 
							catch (DocumentException e1) {}
							 
							document.open();
							com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.COURIER, 12, BaseColor.BLACK);
							Paragraph chunk = new Paragraph(textArea.getText(), font);
							try {
								document.add(chunk);
							} catch (DocumentException e1) {}
							document.close();
							//JOptionPane.showMessageDialog(null,"printed in"+ruta);
						} 
						if(result == JOptionPane.NO_OPTION) {}
					}
					else {
						try {
							try {
								PdfWriter.getInstance(document, new FileOutputStream(""+ruta+".pdf"));
								document.open();
								com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.COURIER, 12, BaseColor.BLACK);
								Paragraph chunk = new Paragraph(textArea.getText(), font);
								try {
									document.add(chunk);							
								} catch (DocumentException e1) {}
								document.close();							
							} 
							//JOptionPane.showMessageDialog(null,"printed in"+ruta+".pdf");
							catch (FileNotFoundException e1) {} 
							catch (DocumentException e1) {}							
						}
						catch(Exception e5) {}
					}
				}
				catch(Exception e3) {
					JOptionPane.showMessageDialog(null,"ERROR", "", 0);					
				}
			}
		});
		btnNewButton.setBounds(441, 380, 108, 25);
		contentPane.add(btnNewButton);
		
	}
}