package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import logical.Conferencia;
import logical.Equipo;

import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegEquipo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtEstadio;
	private JTextField txtEntrenador;
	private JSpinner spnPresupuesto;
	private Equipo equipo;
	private SeleccionImagen selImg = new SeleccionImagen();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public RegEquipo(Equipo equipo) {
		this.equipo = equipo;
		if ( equipo == null) {
			setTitle("Registro de Jugadores");
		}else {
			setTitle("Modificación de Jugadores");
		}
		setBounds(100, 100, 500, 398);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Registro de equipos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(29, 57, 170, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			txtEstadio = new JTextField();
			txtEstadio.setBounds(29, 173, 170, 20);
			panel.add(txtEstadio);
			txtEstadio.setColumns(10);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("Dialog", Font.BOLD, 11));
			lblNombre.setBounds(29, 32, 73, 14);
			panel.add(lblNombre);
			
			JLabel lblEstadio = new JLabel("Estadio:");
			lblEstadio.setFont(new Font("Dialog", Font.BOLD, 11));
			lblEstadio.setBounds(29, 146, 73, 14);
			panel.add(lblEstadio);
			
			JLabel lblEntrenador = new JLabel("Entrenador:");
			lblEntrenador.setFont(new Font("Dialog", Font.BOLD, 11));
			lblEntrenador.setBounds(29, 90, 73, 14);
			panel.add(lblEntrenador);
			
			JLabel lblPresupuesto = new JLabel("Presupuesto (D\u00F3lares):");
			lblPresupuesto.setFont(new Font("Dialog", Font.BOLD, 11));
			lblPresupuesto.setBounds(29, 206, 142, 14);
			panel.add(lblPresupuesto);
			
			txtEntrenador = new JTextField();
			txtEntrenador.setBounds(29, 117, 170, 20);
			panel.add(txtEntrenador);
			txtEntrenador.setColumns(10);
			
			spnPresupuesto = new JSpinner();
			spnPresupuesto.setModel(new SpinnerNumberModel(new Float(100000), new Float(100000), new Float(2147483647), new Float(1000)));
			spnPresupuesto.setBounds(39, 231, 161, 20);
			panel.add(spnPresupuesto);
			
			JLabel label = new JLabel("$");
			label.setFont(new Font("Dialog", Font.BOLD, 11));
			label.setBounds(29, 237, 28, 14);
			panel.add(label);
			
			JLabel lblCambiarFoto = new JLabel("Cargar Foto");
			lblCambiarFoto.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					selImg.setVisible(true);
					selImg.setModal(true);
				}
			});
			lblCambiarFoto.setHorizontalAlignment(SwingConstants.CENTER);
			lblCambiarFoto.setFont(new Font("Tahoma", Font.PLAIN, 31));
			lblCambiarFoto.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), Color.GRAY, null, null));
			lblCambiarFoto.setBounds(235, 47, 220, 219);
			panel.add(lblCambiarFoto);
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("");
				if ( equipo == null ) {
					btnRegistrar.setText("Registrar");
				}else {
					btnRegistrar.setText("Modificar");
				}
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							String nombre = txtNombre.getText().toString();
							String estadio = txtEstadio.getText().toString();
							String entrenador = txtEntrenador.getText().toString();
							float presupuesto = Float.parseFloat(spnPresupuesto.getValue().toString());
							String iD = generateID(nombre);
							if(nombre.isEmpty() | estadio.isEmpty() | entrenador.isEmpty()) {
								throw new Exception();
							}
							Equipo equipo = new Equipo(nombre, entrenador, presupuesto, estadio, iD);
							Conferencia.getInstance().insertEquipo(equipo);
							for (int ind = 0; ind < Conferencia.getInstance().getEquipos().size(); ind++) {
								System.out.println(Conferencia.getInstance().getEquipos().get(ind).getNombre() + ' ' 
										+ Conferencia.getInstance().getEquipos().get(ind).getiD()+ ' ' + Conferencia.getInstance().getEquipos().get(ind).getEntrenador()
										+ "  " +Conferencia.getInstance().getEquipos().size());
							}
							JOptionPane.showMessageDialog(null, "Operación satisfactoria.", "Información", JOptionPane.INFORMATION_MESSAGE);
							clear();
						} catch (Exception e2) {
							System.out.println(e2);
							JOptionPane.showMessageDialog(null, "Asegúrese de que sus datos están correctos.", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public void clear() {
		txtNombre.setText("");
		txtEntrenador.setText("");
		txtEstadio.setText("");
		spnPresupuesto.setValue(100000.0);
	}
	
	private String generateID(String nombre) {
		String iD = null;
		
		iD = nombre.substring(0, 1) + nombre.substring(nombre.indexOf(" ")+1, (nombre.indexOf(" ")+2));
		
		return iD;
	}
}
