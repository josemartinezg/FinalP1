package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import logical.FechaSimple;
import logical.Jugador;
import logical.Lesion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ControlLesiones extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtFechaRegreso;
	private JTextField txtDescripcion;
	private JTextField txtNombre;
	private JTextField txtNumero;
	private JTextField txtID;
	JComboBox cbxTiempoDeDesahibilitado;
	private Jugador jugador;
	public ControlLesiones(Jugador jugador, DefaultComboBoxModel modelLesion, String tipoLesion) {
		this.jugador = jugador;
		setTitle("Control de Lesiones");
		setBounds(100, 100, 520, 520);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Reporte de la Lesi\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JComboBox cbxLesion = new JComboBox();
		cbxLesion.setBounds(12, 101, 230, 22);
		if (tipoLesion.equalsIgnoreCase("")) {
			cbxLesion.setModel(modelLesion);
		}else {
			cbxLesion.setModel(new DefaultComboBoxModel(new String[] {tipoLesion}));
			cbxLesion.setEnabled(false);
		}
		contentPanel.add(cbxLesion);
		
		JLabel lblLesion = new JLabel("Lesi\u00F3n Activa:");
		lblLesion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLesion.setBounds(12, 78, 127, 16);
		contentPanel.add(lblLesion);
		
		JLabel lblFechaInic = new JLabel("Fecha de Inicio:");
		lblFechaInic.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechaInic.setBounds(252, 78, 127, 16);
		contentPanel.add(lblFechaInic);
		
		JComboBox cbxDias = new JComboBox();
		cbxDias.setModel(new DefaultComboBoxModel(new String[] {"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cbxDias.setBounds(254, 101, 49, 22);
		contentPanel.add(cbxDias);
		
		JComboBox cbxMes = new JComboBox();
		cbxMes.setModel(new DefaultComboBoxModel(new String[] {"MM", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		cbxMes.setBounds(315, 101, 51, 22);
		contentPanel.add(cbxMes);
		
		JComboBox cbxAnno = new JComboBox();
		cbxAnno.setModel(new DefaultComboBoxModel(new String[] {"AAAA", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018"}));
		cbxAnno.setBounds(378, 101, 85, 22);
		contentPanel.add(cbxAnno);
		
		JLabel lblTiempoDeDeshabilitado = new JLabel("Tiempo de Deshabilitado:");
		lblTiempoDeDeshabilitado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTiempoDeDeshabilitado.setBounds(12, 139, 166, 16);
		contentPanel.add(lblTiempoDeDeshabilitado);
		
		cbxTiempoDeDesahibilitado = new JComboBox();
		cbxTiempoDeDesahibilitado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		cbxTiempoDeDesahibilitado.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione el tiempo en d\u00EDas>", "10 d\u00EDas", "20 d\u00EDas", "1 mes", "2 meses", "3 meses", "4 meses", "6 meses", "9 meses", "1 a\u00F1o", "1 a\u00F1o o m\u00E1s"}));
		cbxTiempoDeDesahibilitado.setBounds(12, 163, 230, 22);
		contentPanel.add(cbxTiempoDeDesahibilitado);
		
		JLabel lblFechaRegreso = new JLabel("Fecha de Regreso");
		lblFechaRegreso.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechaRegreso.setBounds(252, 139, 127, 16);
		contentPanel.add(lblFechaRegreso);
		
		txtFechaRegreso = new JTextField();
		txtFechaRegreso.setEnabled(false);
		txtFechaRegreso.setEditable(false);
		txtFechaRegreso.setBounds(250, 163, 213, 22);
		contentPanel.add(txtFechaRegreso);
		txtFechaRegreso.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Haga una breve descripci\u00F3n de la lesi\u00F3n: ");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescripcion.setBounds(12, 206, 325, 16);
		contentPanel.add(lblDescripcion);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(12, 228, 478, 185);
		contentPanel.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		JLabel lblNombreDelJuador = new JLabel("Nombre del juador: ");
		lblNombreDelJuador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreDelJuador.setBounds(12, 24, 127, 16);
		contentPanel.add(lblNombreDelJuador);
		
		txtNombre = new JTextField();
		txtNombre.setText(jugador.getNombre() + " " + jugador.getApellido());
		txtNombre.setEnabled(false);
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(12, 43, 267, 22);
		contentPanel.add(txtNombre);
		
		JLabel lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumero.setBounds(291, 24, 65, 16);
		contentPanel.add(lblNumero);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblID.setBounds(365, 24, 65, 16);
		contentPanel.add(lblID);
		
		txtNumero = new JTextField();
		txtNumero.setText(String.valueOf(jugador.getNumeroCamiseta()));
		txtNumero.setEnabled(false);
		txtNumero.setEditable(false);
		txtNumero.setColumns(10);
		txtNumero.setBounds(291, 43, 65, 22);
		contentPanel.add(txtNumero);
		
		txtID = new JTextField();
		txtID.setText(jugador.getiD());
		txtID.setEnabled(false);
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setBounds(363, 43, 127, 22);
		contentPanel.add(txtID);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane(
					).add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnReistrar = new JButton("Registrar");
				btnReistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if ( !(cbxDias.getSelectedItem().toString().equalsIgnoreCase("DD") || cbxMes.getSelectedItem().toString().equalsIgnoreCase("MM")
								|| cbxAnno.getSelectedItem().toString().equalsIgnoreCase("AAAA")) )	{
							String tipoLes = getTipoLesion();
							int day = Integer.valueOf(cbxDias.getSelectedItem().toString());
							int month = Integer.valueOf(cbxMes.getSelectedItem().toString());
							int year = Integer.valueOf(cbxAnno.getSelectedItem().toString());
							FechaSimple fechaInicio = new FechaSimple(day, month, year);
							FechaSimple fechaRegreso = calcFechaRegreso(day, month, year);
							String descripcion = txtDescripcion.getText().toString();
							int gradoLesion = calcGradoLesion(tipoLes);
							String tiempoLesionado = cbxTiempoDeDesahibilitado.getSelectedItem().toString();
							Lesion nuevaLesion = new Lesion(tipoLes, gradoLesion, fechaInicio, tiempoLesionado , fechaRegreso, descripcion, true);
							txtFechaRegreso.setText(String.valueOf(fechaRegreso.getDay())+ "/"+String.valueOf(fechaRegreso.getMonth())+ "/"+ String.valueOf(fechaRegreso.getYear()));
							System.out.println(tipoLes + "\n" + String.valueOf(gradoLesion) + "\n" + day+"/"+month+"/"+year + "\n" +
									fechaRegreso.getDay()+"/"+ fechaRegreso.getMonth() +"/"+ fechaRegreso.getYear() + "\n" + tiempoLesionado  +"\n"  + "\n\n" + descripcion);	
							JOptionPane.showMessageDialog(null, "Jugador registrado con exito", "Informacion", JOptionPane.INFORMATION_MESSAGE, null);
						}else {
							System.out.println("Error! Numeros no van en la fecha...");
							JOptionPane.showMessageDialog(null, "La Lesión no pudo ser creada por la fecha.\nVerifique los campos Obligatorios.", "Informacion", JOptionPane.WARNING_MESSAGE, null);
						}
					}

					private int calcGradoLesion(String tipoLes) {
						String aux[] = tipoLes.split(" ");
						int gradoLes = Integer.valueOf(aux[2]);
						return gradoLes;
					}

					private FechaSimple calcFechaRegreso(int day, int month, int year) {
						String tiempoDeshab = cbxTiempoDeDesahibilitado.getSelectedItem().toString();
						String [] unidad = tiempoDeshab.split(" ");
						FechaSimple fecha;
						int undTiempoLesion = Integer.valueOf(unidad[0]);
						int sumDays = day + undTiempoLesion;
						int sumMonths = month + undTiempoLesion;
						System.out.println(unidad[1]);
						if (unidad[1].equalsIgnoreCase("días")) {
							if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) {
								if (sumDays > 31) {
									day = sumDays - 31;
									month += 1;
								}else {
									day += undTiempoLesion;
								}
							}
							if ((month == 4) || (month == 6) || (month == 9) || (month == 11)) {
								if (sumDays > 30) {
									day = sumDays - 30;
									month += 1;
								}else {
									day += undTiempoLesion;
								}
							}
							else {
								if (sumDays > 28) {
									day = sumDays - 28;
									month += 1;
								}else {
									day += undTiempoLesion;
								}
							}
						}if (unidad[1].equalsIgnoreCase("mes") || unidad[1].equalsIgnoreCase("meses")) {
							
							if(sumMonths > 12) {
								month = sumMonths - 12;
								year += 1;
							}
							else {
								month += undTiempoLesion;
							}
						}if (unidad[1].equalsIgnoreCase("año")) {
							year += undTiempoLesion;
						}
						return fecha = new FechaSimple(day, month, year);
					}
					private String getTipoLesion() {
						String tipoLes;
						if (tipoLesion.equalsIgnoreCase("")) {
							tipoLes = cbxLesion.getSelectedItem().toString();
						}else {
							 tipoLes = tipoLesion;
						}
						return tipoLes;
					}
				});
				btnReistrar.setActionCommand("OK");
				buttonPane.add(btnReistrar);
				getRootPane().setDefaultButton(btnReistrar);
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
}
