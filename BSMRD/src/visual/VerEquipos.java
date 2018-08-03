package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logical.Conferencia;
import logical.Equipo;
import logical.Jugador;

public class VerEquipos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static DefaultTableModel model;
	private static JTable table;
	private static JButton btnModificar;
	private static JButton btnEliminar;
	private static JButton btnSalir;
	private static Object fila[];
	private String iD;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public VerEquipos() {
		setTitle("Visualizar Equipos");
		setBounds(100, 100, 720, 480);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane);
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					if (table.getSelectedRow() >= 0) {
						btnEliminar.setEnabled(true);
						btnModificar.setEnabled(true);
						int index = table.getSelectedRow();
						iD = (String)table.getModel().getValueAt(index, 0);
						//System.out.println(iD);
						}
					}
				});
				scrollPane.setViewportView(table);
				model = new DefaultTableModel();
				String[] columnNames = {"ID", "Logo", "Nombre", "Estadio", "Entrenador"};
				model.setColumnIdentifiers(columnNames);
				table.setModel(model);
				loadTable();
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!(iD.equalsIgnoreCase(""))) {
							Equipo aux = Conferencia.getInstance().buscarEquipos(iD);
							RegEquipo regEquipo = new RegEquipo(aux);
							regEquipo.setModal(true);
							regEquipo.setVisible(true);
							btnEliminar.setEnabled(false);
							btnModificar.setEnabled(false);
							loadTable();
						}
					}
				});
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!iD.equalsIgnoreCase("")) {
							Equipo aux = Conferencia.getInstance().buscarEquipos(iD);
							int borrar = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este elemento?" + aux.getNombre(), "Información", JOptionPane.YES_NO_OPTION);
							if (borrar == JOptionPane.YES_OPTION) {
								Conferencia.getInstance().getEquipos().remove(aux);
								btnEliminar.setEnabled(false);
								btnModificar.setEnabled(false);
								loadTable();
							}
						}
					}
				});
				buttonPane.add(btnEliminar);
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
	private void loadTable() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (int i = 0; i < Conferencia.getInstance().getEquipos().size(); i++) {
			fila[0] = Conferencia.getInstance().getEquipos().get(i).getiD();
			//fila[1] = Conferencia.getInstance().getMisJugadores().get(i).getIconImages();
			fila[2] = Conferencia.getInstance().getEquipos().get(i).getNombre();
			fila[3] = Conferencia.getInstance().getEquipos().get(i).getEstadio();
			fila[4] = Conferencia.getInstance().getEquipos().get(i).getEntrenador();
			model.addRow(fila);
		}
		table.setModel(model);
		TableColumnModel columnModel = table.getColumnModel();
		//table.setRowHeight(60);
		columnModel.getColumn(0).setPreferredWidth(70);
		columnModel.getColumn(1).setPreferredWidth(140);
		columnModel.getColumn(2).setPreferredWidth(170);
		columnModel.getColumn(3).setPreferredWidth(170);
		columnModel.getColumn(4).setPreferredWidth(170);
	}
}