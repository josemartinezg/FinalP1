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

public class RegEquipo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtEstadio;
	private JTextField txtEntrenador;
	private JSpinner spnPresupuesto;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public RegEquipo() {
		setTitle("Registrar equipo");
		setBounds(100, 100, 450, 256);
		setLocationRelativeTo(null);
		setModal(true);
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
			txtNombre.setBounds(39, 57, 170, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			txtEstadio = new JTextField();
			txtEstadio.setBounds(247, 57, 161, 20);
			panel.add(txtEstadio);
			txtEstadio.setColumns(10);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("Dialog", Font.BOLD, 11));
			lblNombre.setBounds(29, 32, 73, 14);
			panel.add(lblNombre);
			
			JLabel lblEstadio = new JLabel("Estadio:");
			lblEstadio.setFont(new Font("Dialog", Font.BOLD, 11));
			lblEstadio.setBounds(237, 32, 73, 14);
			panel.add(lblEstadio);
			
			JLabel lblEntrenador = new JLabel("Entrenador:");
			lblEntrenador.setFont(new Font("Dialog", Font.BOLD, 11));
			lblEntrenador.setBounds(29, 104, 73, 14);
			panel.add(lblEntrenador);
			
			JLabel lblPresupuesto = new JLabel("Presupuesto (D\u00F3lares):");
			lblPresupuesto.setFont(new Font("Dialog", Font.BOLD, 11));
			lblPresupuesto.setBounds(237, 104, 142, 14);
			panel.add(lblPresupuesto);
			
			txtEntrenador = new JTextField();
			txtEntrenador.setBounds(39, 129, 170, 20);
			panel.add(txtEntrenador);
			txtEntrenador.setColumns(10);
			
			spnPresupuesto = new JSpinner();
			spnPresupuesto.setModel(new SpinnerNumberModel(new Float(100000), new Float(100000), new Float(2147483647), new Float(1000)));
			spnPresupuesto.setBounds(247, 129, 161, 20);
			panel.add(spnPresupuesto);
			
			JLabel label = new JLabel("$");
			label.setFont(new Font("Dialog", Font.BOLD, 11));
			label.setBounds(237, 132, 28, 14);
			panel.add(label);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
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
							JOptionPane.showMessageDialog(null, "Operación satisfactoria.", "Información", JOptionPane.INFORMATION_MESSAGE);
							clear();
						} catch (Exception e2) {
							System.out.println(e2);
							JOptionPane.showMessageDialog(null, "Asegúrese de que sus datos están correctos.", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
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
