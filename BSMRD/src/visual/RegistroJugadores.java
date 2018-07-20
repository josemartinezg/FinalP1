package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.border.TitledBorder;

import logical.Conferencia;
import logical.Estadistica;
import logical.FechaSimple;
import logical.Jugador;

public class RegistroJugadores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtPeso;
	private JTextField txtLnbsas;
	private JTextField txtSalario;
	private JComboBox cbxEquipo;
	private JSpinner spnEstatura;
	private JComboBox cbxLigaOrigen;
	private JTextField txtNumeroCamiseta;
	private JTextField txtFechaNacimiento;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public RegistroJugadores() {
		setTitle("Registro de Jugadores");
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
		cbxEquipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione un equipo>"}));
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
		
		JLabel lblEstatura = new JLabel("Estatura:");
		lblEstatura.setBounds(12, 214, 83, 16);
		lblEstatura.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblEstatura);
		
		spnEstatura = new JSpinner();
		spnEstatura.setBounds(12, 243, 83, 22);
		spnEstatura.setModel(new SpinnerListModel(new String[] {"5.7'", "5.8'", "5.9'", "5.10'", "5.11'", "6.0'", "6.1'", "6.2'", "6.3'", "6.4'", "6.5'", "6.6'", "6.7'", "6.8'", "6.9'", "6.10'", "6.11'", "7.0'", "7.1'", "7.2'", "7.3'", "7.4'", "7.5'", "7.6'"}));
		contentPanel.add(spnEstatura);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(249, 214, 83, 16);
		lblPeso.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblPeso);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(249, 243, 116, 22);
		contentPanel.add(txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(12, 462, 56, 16);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblId);
		
		txtLnbsas = new JTextField();
		txtLnbsas.setBounds(12, 487, 149, 22);
		txtLnbsas.setText("LNBSAS0001");
		txtLnbsas.setEditable(false);
		txtLnbsas.setEnabled(false);
		contentPanel.add(txtLnbsas);
		txtLnbsas.setColumns(10);
		
		JLabel lblSalario = new JLabel("Salario:");
		lblSalario.setBounds(12, 403, 83, 16);
		lblSalario.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblSalario);
		
		txtSalario = new JTextField();
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
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(249, 179, 230, 22);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"<Sin Lesi\u00F3n>", "Lesi\u00F3n Grado 1", "Lesi\u00F3n Grado 2", "Lesi\u00F3n Grado 3", "Lesi\u00F3n Grado 4", "Lesi\u00F3n Grado 5"}));
		contentPanel.add(comboBox_2);
		
		txtNumeroCamiseta = new JTextField();
		txtNumeroCamiseta.setBounds(12, 368, 149, 22);
		txtNumeroCamiseta.setColumns(10);
		contentPanel.add(txtNumeroCamiseta);
		
		JLabel label_1 = new JLabel("N\u00FAmero:");
		label_1.setBounds(12, 343, 56, 16);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(label_1);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaNacimiento.setBounds(12, 283, 144, 16);
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblFechaNacimiento);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setBounds(12, 308, 144, 22);
		txtFechaNacimiento.setText("DD/MM/AAAA");
		txtFechaNacimiento.setColumns(10);
		contentPanel.add(txtFechaNacimiento);
		
		JButton btnImage = new JButton("Cargar Foto");
		btnImage.setBounds(249, 290, 220, 219);
		contentPanel.add(btnImage);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					String nombre = txtNombre.getText();
					String apellido = txtApellido.getText();
					Float peso = Float.valueOf(txtPeso.getText());
					float salarioAnual = Float.valueOf(txtSalario.getText());
					String estatura = spnEstatura.getValue().toString();
					Float fEstatura = Float.valueOf(estatura.substring(0, estatura.indexOf("'")));
					String ligaProveniente = cbxLigaOrigen.toString();
					int numeroCamiseta = Integer.valueOf(txtNumeroCamiseta.getText());
					String iD = generateID(nombre, numeroCamiseta);
					String fechaNacim = txtFechaNacimiento.getText();
					String []fecha = generateFecha(fechaNacim);
					int dia = Integer.valueOf(fecha[0]);
					int mes = Integer.valueOf(fecha[1]);
					int anno = Integer.valueOf(fecha[2]);
					FechaSimple fechaNacimiento = new FechaSimple(dia, mes, anno);
					Estadistica estadisticas = new Estadistica();
					try {
						
					}catch(NumberFormatException e2) {
						System.out.println("Number Format exception caught.");
					}
					try {
						Jugador nuevoJugador = new Jugador(nombre, apellido, iD, fechaNacimiento, salarioAnual, ligaProveniente, false, estadisticas, numeroCamiseta, fEstatura, peso);
						Conferencia.getInstance().getMisJugadores().add(nuevoJugador);
					}catch(NullPointerException e1) {
						System.out.println("Null pointer exception caught.");
					}
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnSaliur = new JButton("Salir");
				btnSaliur.setActionCommand("Cancel");
				buttonPane.add(btnSaliur);
			}
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
		
		iD = "LNB" + nombre.substring(0, 2) + nombre.substring(nombre.indexOf(" "), (nombre.indexOf(" ")+2)) + Integer.toString(numero);
		
		return iD;
	}
	
	private String[] generateFecha(String fecha) {
		String fechaSimple[] = fecha.split("/");
		return fechaSimple;
	}
}
