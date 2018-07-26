package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logical.Conferencia;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerJugadores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object fila[];
	private JButton btnEliminar;
	private JButton btnModificar;
	private String iD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VerJugadores dialog = new VerJugadores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**46366
	 * Create the dialog.
	 */
	public VerJugadores() {
		setTitle("Visualizar Jugadores");
		setBounds(100, 100, 720, 480);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
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
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model = new DefaultTableModel();
		String[] columnNames = {"No.", "Foto", "Equipo", "Nombre","Apellido", "ID"};
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
		loadTable();
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnModificar.setEnabled(false);
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			
			btnEliminar = new JButton("Eliminar");
			btnEliminar.setEnabled(false);
			buttonPane.add(btnEliminar);
			{
				JButton btnSalir = new JButton("Salir");
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
		}
	}

	private void loadTable() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (int i = 0; i < Conferencia.getInstance().getMisJugadores().size(); i++) {
			
			fila[0] = Conferencia.getInstance().getMisJugadores().get(i).getNumeroCamiseta();
			//fila[1] = Conferencia.getInstance().getMisJugadores().get(i).getIconImages();
			fila[2] = Conferencia.getInstance().getMisJugadores().get(i).getEquipo();
			fila[3] = Conferencia.getInstance().getMisJugadores().get(i).getNombre();
			fila[4] = Conferencia.getInstance().getMisJugadores().get(i).getApellido();
			fila [5] = Conferencia.getInstance().getMisJugadores().get(i).getiD();
			model.addRow(fila);
		}
		TableColumnModel columnModel = table.getColumnModel();
		table.setRowHeight(60);
		columnModel.getColumn(0).setPreferredWidth(70);
		columnModel.getColumn(1).setPreferredWidth(140);
		columnModel.getColumn(2).setPreferredWidth(170);
		columnModel.getColumn(3).setPreferredWidth(170);
		columnModel.getColumn(4).setPreferredWidth(170);
		columnModel.getColumn(5).setPreferredWidth(120);
	}
}
