package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logical.Conferencia;
import logical.Jugador;

public class ListaLesiones extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object fila[];
	private static Jugador jugador;

	/**
	 * Launch the application.
	 */



	/**
	 * Create the dialog.
	 */
	public ListaLesiones(Jugador jugador) {
		this.jugador = jugador;
		setBounds(100, 100, 480, 520);
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
				{
					
					table = new JTable();
					scrollPane.setViewportView(table);
					model = new DefaultTableModel();
					String[] columnNames = {"Tipo de Lesión", "Duración"};
					model.setColumnIdentifiers(columnNames);
					table.setModel(model);
					try {
						loadTable();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
	private void loadTable() throws ClassNotFoundException, IOException{
		
		
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (int i = 0; i < jugador.getMisLesiones().size(); i++) {
			fila[0] =jugador.getMisLesiones().get(i).getTipoLesion();
			fila[1] = jugador.getMisLesiones().get(i).getTiempoLesionado();
			model.addRow(fila);
		}
		
		table.setModel(model);
		TableColumnModel columnModel = table.getColumnModel();
		table.setRowHeight(60);
		columnModel.getColumn(0).setPreferredWidth(140);
		columnModel.getColumn(1).setPreferredWidth(140);

	}

}
