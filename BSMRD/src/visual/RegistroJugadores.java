package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import logical.Conferencia;
import logical.Estadistica;
import logical.FechaSimple;
import logical.Jugador;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistroJugadores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtPeso;
	private JTextField txtID;
	private JTextField txtSalario;
	private JComboBox cbxEquipo;
	private JComboBox cbxDia;
	private JComboBox cbxLigaOrigen;
	private JTextField txtNumeroCamiseta;
	private JComboBox cbxLesiones;
	private Jugador jugador;
	private boolean lesionStatus = false;
	private String tipoLesion = null;
	private SeleccionImagen selImg = new SeleccionImagen();
	private DefaultComboBoxModel modeloLesiones =
			new DefaultComboBoxModel(new String[] {"<Sin Lesi\u00F3n>", "Lesi\u00F3n Grado 1", "Lesi\u00F3n Grado 2", "Lesi\u00F3n Grado 3", "Lesi\u00F3n Grado 4", "Lesi\u00F3n Grado 5"});
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	try {
		RegistroJugadores dialog = new RegistroJugadores(null);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

	/**
	 * Create the dialog.
	 */
	/*Pasar el equipo por constructor al momento de crear el equipo(?), 
	 * y no pasar nada al momento de agregarlo independientemente*/
	public RegistroJugadores(Jugador jugador) {
		this.jugador = jugador;
		if ( jugador == null) {
			setTitle("Registro de Jugadores");
		}else {
			setTitle("Modificación de Jugadores");
		}
		
		setBounds(100, 100, 512, 635);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblEquipo = new JLabel("Equipo:");
			lblEquipo.setBounds(12, 31, 83, 16);
			lblEquipo.setFont(new Font("Tahoma", Font.BOLD, 13));
			contentPanel.add(lblEquipo);
		}
		
		cbxEquipo = new JComboBox();
		cbxEquipo.setBounds(12, 56, 467, 22);
		cbxEquipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione un equipo>", "Golden State Warriors", "San Antonio Spurs"}));
		contentPanel.add(cbxEquipo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 91, 83, 16);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido: ");
		lblApellido.setBounds(249, 91, 83, 16);
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblApellido);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(12, 113, 230, 22);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(249, 113, 230, 22);
		txtApellido.setColumns(10);
		contentPanel.add(txtApellido);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(12, 278, 83, 16);
		lblPeso.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblPeso);
		
		txtPeso = new JTextField();
		txtPeso.setText("0.00");
		txtPeso.setBounds(12, 307, 149, 22);
		contentPanel.add(txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(12, 462, 56, 16);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblId);
		
		txtID = new JTextField();
		txtID.setBounds(12, 487, 149, 22);
		txtID.setEditable(false);
		txtID.setEnabled(false);
		txtID.setEnabled(false);
		txtID.setEditable(false);
		contentPanel.add(txtID);
		txtID.setColumns(10);
		
		
		JLabel lblSalario = new JLabel("Salario:");
		lblSalario.setBounds(12, 403, 83, 16);
		lblSalario.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblSalario);
		
		txtSalario = new JTextField();
		txtSalario.setText("00000.00");
		txtSalario.setBounds(12, 427, 149, 22);
		contentPanel.add(txtSalario);
		txtSalario.setColumns(10);
		
		JLabel lblLigaOrigen = new JLabel("Liga de Origen:");
		lblLigaOrigen.setBounds(12, 156, 116, 16);
		lblLigaOrigen.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblLigaOrigen);
		
		cbxLigaOrigen = new JComboBox();
		cbxLigaOrigen.setBounds(12, 179, 230, 22);
		cbxLigaOrigen.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione una Liga>", "G League", "Summer League", "JBA", "International Agency", ""}));
		contentPanel.add(cbxLigaOrigen);
		
		JLabel lblLesiones = new JLabel("Lesiones Activas:");
		lblLesiones.setBounds(249, 156, 127, 16);
		lblLesiones.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblLesiones);
		
		cbxLesiones = new JComboBox();
		cbxLesiones.setBounds(249, 179, 230, 22);
		cbxLesiones.setModel(modeloLesiones);
		contentPanel.add(cbxLesiones);
		
		txtNumeroCamiseta = new JTextField();
		txtNumeroCamiseta.setText("0");
		txtNumeroCamiseta.setBounds(12, 368, 149, 22);
		txtNumeroCamiseta.setColumns(10);
		contentPanel.add(txtNumeroCamiseta);
		
		JLabel lblNumeroCamiseta = new JLabel("N\u00FAmero:");
		lblNumeroCamiseta.setBounds(12, 343, 56, 16);
		lblNumeroCamiseta.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblNumeroCamiseta);
		
		JComboBox cbxAnno = new JComboBox();
		cbxAnno.setModel(new DefaultComboBoxModel(new String[] {"AAAA", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "PS C:\\Users\\Jos\u00E9 Manuel Mart\u00EDnez> & C:/Python27/python.exe \"c:/Users/Jos\u00E9 Manuel Mart\u00EDnez/Desktop/Local Version Control/Cicle.py\"", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018"}));
		cbxAnno.setBounds(136, 243, 85, 22);
		contentPanel.add(cbxAnno);
		
		JComboBox cbxMes = new JComboBox();
		cbxMes.setModel(new DefaultComboBoxModel(new String[] {"MM", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		cbxMes.setBounds(73, 243, 51, 22);
		contentPanel.add(cbxMes);
		
		cbxDia = new JComboBox();
		cbxDia.setModel(new DefaultComboBoxModel(new String[] {"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cbxDia.setBounds(12, 243, 49, 22);
		contentPanel.add(cbxDia);
		
		JLabel lblFechaNacim = new JLabel("Fecha de Nacimiento:");
		lblFechaNacim.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechaNacim.setBounds(12, 218, 144, 16);
		contentPanel.add(lblFechaNacim);
		
		JSpinner spnEstatura = new JSpinner();
		spnEstatura.setModel(new SpinnerListModel(new String[] {"5.7'", "5.8'", "5.9'", "6.0'", "6.1'", "6.2'", "6.3'", "6.4'", "6.5'", "6.6'", "6.7'"}));
		spnEstatura.setBounds(249, 243, 83, 22);
		contentPanel.add(spnEstatura);
		
		JLabel lblEstatura = new JLabel("Estatura:");
		lblEstatura.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEstatura.setBounds(249, 214, 83, 16);
		contentPanel.add(lblEstatura);
		
		JLabel lblCambiarFoto = new JLabel("Cargar Foto");
		lblCambiarFoto.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), Color.GRAY, null, null));
		lblCambiarFoto.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblCambiarFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCambiarFoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selImg.setVisible(true);
				selImg.setModal(true);
			}
		});
		lblCambiarFoto.setBounds(249, 290, 220, 219);
		contentPanel.add(lblCambiarFoto);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("");
				if ( jugador == null ) {
					btnRegistrar.setText("Registrar");
				}else {
					btnRegistrar.setText("Modificar");
				}
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
										
					if ( !(cbxDia.getSelectedItem().toString().equalsIgnoreCase("DD") || cbxMes.getSelectedItem().toString().equalsIgnoreCase("MM")
							|| cbxAnno.getSelectedItem().toString().equalsIgnoreCase("AAAA")) ) {
						String nombre = txtNombre.getText();
						String apellido = txtApellido.getText();
						String equipo = cbxEquipo.getSelectedItem().toString();
						Float peso = Float.valueOf(txtPeso.getText());
						float salarioAnual = Float.valueOf(txtSalario.getText());
						String estatura = spnEstatura.getValue().toString();
						Float fEstatura = Float.valueOf(estatura.substring(0, estatura.indexOf("'")));
						String ligaProveniente = cbxLigaOrigen.getSelectedItem().toString();
						//Add numeric exception.
						int numeroCamiseta = Integer.valueOf(txtNumeroCamiseta.getText());
						String iD = generateID(equipo, numeroCamiseta);
						int dia = Integer.valueOf(cbxDia.getSelectedItem().toString());
						int mes = Integer.valueOf(cbxMes.getSelectedItem().toString());
						int anno = Integer.valueOf(cbxAnno.getSelectedItem().toString());
						FechaSimple fechaNacimiento = new FechaSimple(dia, mes, anno);
						lesionStatus = activarLesion();
						tipoLesion = getTipoLesion();
						if (nombre.equalsIgnoreCase("") || apellido.equalsIgnoreCase("") ||  ligaProveniente.equalsIgnoreCase("") ||  iD.equalsIgnoreCase("") ||  
								 peso == 0.0 || (numeroCamiseta < 0 && numeroCamiseta > 100) || salarioAnual == 0.0 || equipo.equalsIgnoreCase("<Seleccione un equipo>")) {
							JOptionPane.showMessageDialog(null, "El jugador no pudo ser creado.\nVerifique los campos Obligatorios.", "Informacion", JOptionPane.WARNING_MESSAGE, null);
							}else {
								if (jugador == null) {
									Jugador nuevoJugador = new Jugador(nombre, apellido, equipo, iD, fechaNacimiento, salarioAnual, ligaProveniente, lesionStatus, numeroCamiseta, fEstatura, peso, null);
									Conferencia.getInstance().addJugador(nuevoJugador);
									JOptionPane.showMessageDialog(null, "Jugador registrado con exito", "Informacion", JOptionPane.INFORMATION_MESSAGE, null);
									clean();
									if ( lesionStatus == true ) {
										ControlLesiones ctrlLesion = new ControlLesiones(nuevoJugador, modeloLesiones, tipoLesion);
										ctrlLesion.setModal(true);
										ctrlLesion.setVisible(true);
										txtID.setText(generateID(equipo, numeroCamiseta));
									}
								}else {
									jugador.setiD(jugador.getiD());
									jugador.setNombre(nombre);
									jugador.setApellido(apellido);
									jugador.setPeso(peso);
									jugador.setSalarioAnual(salarioAnual);
									jugador.setEstatura(fEstatura);
									jugador.setLigaProveniente(ligaProveniente);
									jugador.setNumeroCamiseta(numeroCamiseta);
									jugador.setFechaNacimiento(fechaNacimiento);
									Conferencia.getInstance().modficarJugador(jugador);
									JOptionPane.showMessageDialog(null, "Jugador modificado con exito", "Informacion", JOptionPane.INFORMATION_MESSAGE, null);
								}
							}
					}else {
						System.out.println("Error! Numeros no van en la fecha...");
						JOptionPane.showMessageDialog(null, "El jugador no pudo ser creado.\nVerifique los campos Obligatorios.", "Informacion", JOptionPane.WARNING_MESSAGE, null);
					}
				}

					private void clean() {
						cbxEquipo.setSelectedIndex(0);
						txtNombre.setText("");
						txtApellido.setText("");
						cbxLigaOrigen.setSelectedIndex(0);
						cbxLesiones.setSelectedIndex(0);
						cbxDia.setSelectedIndex(0);
						cbxMes.setSelectedIndex(0);
						cbxAnno.setSelectedIndex(0);
						spnEstatura.setValue(new String("5.7'"));
						txtPeso.setText("0.00");
						txtNumeroCamiseta.setText("0");
						txtSalario.setText("00000.00");
						txtID.setText("");
						txtID.setEnabled(false);
						txtID.setEditable(false);
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnSalir = new JButton("Salir");
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
		}
	}
	private boolean activarLesion() {
		String tipoLesion = cbxLesiones.getSelectedItem().toString();
		System.out.println(tipoLesion);
		if (tipoLesion.equalsIgnoreCase("<Sin Lesión>")) {
			return false;
		}else {
			return true;
		}
	}
	private String getTipoLesion() {
		String tipoLesion = cbxLesiones.getSelectedItem().toString();
		System.out.println(tipoLesion);
		if (!(tipoLesion.equalsIgnoreCase("<Sin Lesión>"))) {
			return tipoLesion;
		}else {
			return tipoLesion;
		}
	}
	private void loadEquipos() {
		for (int i = 0; i < Conferencia.getInstance().getEquipos().size(); i++) {
			cbxEquipo.addItem(Conferencia.getInstance().getEquipos().get(i).getNombre());
		}
		cbxEquipo.insertItemAt("<Seleccione un equipo>", 0);
		cbxEquipo.setSelectedIndex(0);
	}
	
	private String generateID(String nombre, int numero) {
		String iD = null;
		
		iD = "LNB" + nombre.substring(0, 1) + nombre.substring(nombre.indexOf(" ")+1, (nombre.indexOf(" ")+2)) + Integer.toString(numero);
		
		return iD;
	}
}
