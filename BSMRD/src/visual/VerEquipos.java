package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logical.Conferencia;
import logical.Equipo;

public class VerEquipos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnSalir;
	private String iD;
	public static DefaultTableModel model;
	private static Object fila[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VerEquipos dialog = new VerEquipos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
				scrollPane.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (table.getSelectedRow() >= 0) {
							btnEliminar.setEnabled(true);
							btnModificar.setEnabled(true);
							int index = table.getSelectedRow();
							iD = (String)table.getModel().getValueAt(index, 0);
						}
					}
				});
				panel.add(scrollPane);
				table = new JTable();
				scrollPane.setViewportView(table);
				model = new DefaultTableModel();
				String[] columnNames = {"ID.", "Logo", "Nombre", "Estadio", "Entrenador"};
				model.setColumnIdentifiers(columnNames);
				table.setModel(model);
				loadTable();
				{
					table = new JTable();
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!iD.equalsIgnoreCase("")) {
							Equipo aux = Conferencia.getInstance().buscarEquipos(iD);
							RegEquipo regEquipo = new RegEquipo();
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
				JButton btnEliminar = new JButton("Eliminar");
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
		for (int i = 0; i < Conferencia.getInstance().getMisJugadores().size(); i++) {
			
			fila[0] = Conferencia.getInstance().getEquipos().get(i).getiD();
			//fila[1] = Conferencia.getInstance().getMisJugadores().get(i).getIconImages();
			fila[2] = Conferencia.getInstance().getEquipos().get(i).getNombre();
			fila[3] = Conferencia.getInstance().getEquipos().get(i).getEstadio();
			fila[4] = Conferencia.getInstance().getEquipos().get(i).getEntrenador();
			model.addRow(fila);
		}
	}
}