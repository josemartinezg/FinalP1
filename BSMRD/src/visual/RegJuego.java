package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logical.Conferencia;
import logical.Equipo;
import logical.FechaSimple;
import logical.Juego;

import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class RegJuego extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtEstadio;
	private JComboBox cbxDia;
	private JComboBox cbxMes;
	private JComboBox cbxAnno;
	private JComboBox cbxLocal;
	private JComboBox cbxVisitante;

	/**
	 * Create the dialog.
	 */
	public RegJuego() {
		setTitle("Programar un juego");
		setBounds(100, 100, 450, 300);
		setModal(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Nuevo juego", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblEquipoLocal = new JLabel("Equipo local:");
		lblEquipoLocal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEquipoLocal.setBounds(28, 21, 96, 14);
		panel.add(lblEquipoLocal);
		
		JLabel lblEquipoVisitante = new JLabel("Equipo visitante:");
		lblEquipoVisitante.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEquipoVisitante.setBounds(231, 21, 96, 14);
		panel.add(lblEquipoVisitante);
		
		cbxLocal = new JComboBox();
		cbxLocal.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Equipo local = Conferencia.getInstance().buscarEquipos(cbxLocal.getSelectedItem().toString());
				txtEstadio.setText(local.getEstadio());
			}
		});
		cbxLocal.setBounds(21, 46, 177, 20);
		panel.add(cbxLocal);
		
		cbxVisitante = new JComboBox();
		cbxVisitante.setBounds(225, 46, 177, 20);
		panel.add(cbxVisitante);
		fillEquipos();
		
		txtEstadio = new JTextField();
		txtEstadio.setEnabled(false);
		txtEstadio.setEditable(false);
		txtEstadio.setBounds(21, 110, 381, 20);
		panel.add(txtEstadio);
		txtEstadio.setColumns(10);
		
		JLabel lblEstadio = new JLabel("Estadio:");
		lblEstadio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstadio.setBounds(28, 85, 67, 14);
		panel.add(lblEstadio);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFecha.setBounds(28, 149, 46, 14);
		panel.add(lblFecha);
		
		cbxDia = new JComboBox();
		cbxDia.setBounds(21, 174, 53, 20);
		panel.add(cbxDia);
		
		cbxMes = new JComboBox();
		cbxMes.setBounds(95, 174, 53, 20);
		panel.add(cbxMes);
		
		cbxAnno = new JComboBox();
		cbxAnno.setBounds(168, 174, 86, 20);
		panel.add(cbxAnno);
		generarFecha();
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Equipo local = Conferencia.getInstance().buscarEquipos(cbxLocal.getSelectedItem().toString());
							Equipo visitante = Conferencia.getInstance().buscarEquipos(cbxVisitante.getSelectedItem().toString());
							String estadio = local.getEstadio();
							FechaSimple fecha = new FechaSimple(
									Integer.parseInt(cbxDia.getSelectedItem().toString()),
									Integer.parseInt(cbxMes.getSelectedItem().toString()),
									Integer.parseInt(cbxAnno.getSelectedItem().toString())
								);
							if(local == null | visitante == null | fecha.isBefore(FechaSimple.getInstance()) | local.getiD() == visitante.getiD()) {
								throw new Exception();
							};
							Juego juego = new Juego(estadio, local, visitante, fecha);
							Conferencia.getInstance().insertJuego(juego);
							JOptionPane.showMessageDialog(null, "Operación satisfactoria.", "Información", JOptionPane.INFORMATION_MESSAGE);
							clear();
							BSM.fillJuegosSemana();
						} catch(Exception e1) {
							System.out.println(e1);
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
	
	private void generarFecha() {
		String[] model;
		model = new String[32];
		model[0] = "DD";
		for (int i = 1; i <= 31; i++) {
			model[i] = String.format("%02d", i);
		}
		cbxDia.setModel(new DefaultComboBoxModel(model));
		model = new String[13];
		model[0] = "MM";
		for (int i = 1; i <= 12; i++) {
			model[i] = String.format("%02d", i);
		}
		cbxMes.setModel(new DefaultComboBoxModel(model));
		cbxAnno.setModel(new DefaultComboBoxModel(new String[] {"2018", "2019"}));
	}
	
	private void fillEquipos() {
		Conferencia conf = Conferencia.getInstance();
		String[] model;
		model = new String[conf.getEquipos().size()+1];
		model[0] = "<Seleccione un equipo>";
		for (int i = 1; i <= conf.getEquipos().size(); i++) {
			model[i] = conf.getEquipos().get(i-1).getiD();
		}
		cbxLocal.setModel(new DefaultComboBoxModel(model));
		cbxVisitante.setModel(new DefaultComboBoxModel(model));
	}
	
	public void clear() {
		txtEstadio.setText("");
		cbxDia.setSelectedIndex(0);
		cbxMes.setSelectedIndex(0);
		cbxAnno.setSelectedIndex(0);
		fillEquipos();
	}
}
