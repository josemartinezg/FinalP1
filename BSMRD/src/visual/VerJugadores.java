package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

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
import logical.Jugador;
import javax.swing.JComboBox;

public class VerJugadores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object fila[];
	private JButton btnEliminar;
	private JButton btnModificar;
	private JComboBox cbxEquipos;
	private String iD;
	private JButton btnReporteLesiones;
	private JButton btnEstadsticas;

	/**46366
	 * Create the dialog.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public VerJugadores() throws ClassNotFoundException, IOException {
		setTitle("Visualizar Jugadores");
		setBounds(100, 100, 720, 480);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 46, 692, 342);
		panel.setLayout(null);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRow() >= 0) {
					btnEliminar.setEnabled(true);
					btnModificar.setEnabled(true);
					btnReporteLesiones.setEnabled(true);
					btnEstadsticas.setEnabled(true);
					int index = table.getSelectedRow();
					iD = (String)table.getModel().getValueAt(index, 5);
				}
			}
		});
		scrollPane.setViewportView(table);
		model = new DefaultTableModel();
		String[] columnNames = {"No.", "Foto", "Equipo", "Nombre","Apellido", "ID"};
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
		
		
		cbxEquipos = new JComboBox();
		cbxEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String equipo = cbxEquipos.getSelectedItem().toString();
				if (equipo != "<Seleccione un equipo>") {
					try {
						loadTable(equipo);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					try {
						loadTable(null);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		cbxEquipos.setBounds(220, 11, 250, 22);
		loadEquipos();
		panel.add(cbxEquipos);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!iD.equalsIgnoreCase("")) {
							try {
								Jugador aux = Conferencia.getInstance().buscarJugadores(iD);
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							RegistroJugadores regJug = RegistroJugadores.getInstance();
							regJug.setModal(true);
							regJug.setVisible(true);
							btnEliminar.setEnabled(false);
							btnModificar.setEnabled(false);
							btnReporteLesiones.setEnabled(false);
							btnEstadsticas.setEnabled(false);
							try {
								loadTable(null);
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}	
				});
				btnModificar.setEnabled(false);
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!iD.equalsIgnoreCase("")) {
							Jugador aux = null;
							try {
								aux = Conferencia.getInstance().buscarJugadores(iD);
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							int borrar = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este elemento?" + aux.getNombre(), "Información", JOptionPane.YES_NO_OPTION);
							if (borrar == JOptionPane.YES_OPTION) {
								try {
									Conferencia.getInstance().getMisJugadores().remove(aux);
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								btnEliminar.setEnabled(false);
								btnModificar.setEnabled(false);
								btnReporteLesiones.setEnabled(false);
								btnEstadsticas.setEnabled(false);
								try {
									loadTable(null);
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}
					}
				});
				btnEliminar.setEnabled(false);
				buttonPane.add(btnEliminar);
				
				btnReporteLesiones = new JButton("Lesiones");
				btnReporteLesiones.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!iD.equalsIgnoreCase("")) {
							try {
								Jugador aux = Conferencia.getInstance().buscarJugadores(iD);
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							//ControlLesiones ctrlLesiones = new ControlLesiones(aux, modelLesion, tipoLesion)
							btnEliminar.setEnabled(false);
							btnModificar.setEnabled(false);
							btnReporteLesiones.setEnabled(false);
							btnEstadsticas.setEnabled(false);
						}
					}
				});
				btnReporteLesiones.setEnabled(false);
				buttonPane.add(btnReporteLesiones);
				
				btnEstadsticas = new JButton("Estad\u00EDsticas");
				btnEstadsticas.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Jugador aux = null;
						try {
							aux = Conferencia.getInstance().buscarJugadores(iD);
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						VerEstadisticas verStats = new VerEstadisticas(aux);
						verStats.setVisible(true);
						btnEliminar.setEnabled(false);
						btnModificar.setEnabled(false);
						btnReporteLesiones.setEnabled(false);
						btnEstadsticas.setEnabled(false);
					}
				});
				btnEstadsticas.setEnabled(false);
				buttonPane.add(btnEstadsticas);
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

	private void loadTable(String equipo) throws ClassNotFoundException, IOException {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		if (equipo != null) {
			for (Jugador aux : Conferencia.getInstance().getMisJugadores()) {
				if (aux.getEquipo() == equipo) {
					fila[0] = aux.getNumeroCamiseta();
					fila[2] = aux.getEquipo();
					fila[3] = aux.getNombre();
					fila[4] = aux.getApellido();
					fila[5] = aux.getiD();
					model.addRow(fila);
				}
			}
		}else {
			for (int i = 0; i < Conferencia.getInstance().getMisJugadores().size(); i++) {
				fila[0] = Conferencia.getInstance().getMisJugadores().get(i).getNumeroCamiseta();
				//fila[1] = Conferencia.getInstance().getMisJugadores().get(i).getIconImages();
				fila[2] = Conferencia.getInstance().getMisJugadores().get(i).getEquipo();
				fila[3] = Conferencia.getInstance().getMisJugadores().get(i).getNombre();
				fila[4] = Conferencia.getInstance().getMisJugadores().get(i).getApellido();
				fila [5] = Conferencia.getInstance().getMisJugadores().get(i).getiD();
				model.addRow(fila);
			}
		}
		
		
		
			/*if (equipo == null) {
				for (int i = 0; i < Conferencia.getInstance().sortByLastName().size(); i++) {
				fila[0] = Conferencia.getInstance().sortByLastName().get(i).getNumeroCamiseta();
				//fila[1] = Conferencia.getInstance().getMisJugadores().get(i).getIconImages();
				fila[2] = Conferencia.getInstance().sortByLastName().get(i).getEquipo();
				fila[3] = Conferencia.getInstance().sortByLastName().get(i).getNombre();
				fila[4] = Conferencia.getInstance().sortByLastName().get(i).getApellido();
				fila [5] = Conferencia.getInstance().sortByLastName().get(i).getiD();
				}
			}else {
				for (int i = 0; i < Conferencia.getInstance().getTeamMembers().size(); i++) {
					fila[0] = Conferencia.getInstance().getTeamMembers(equipo).get(i).getNumeroCamiseta();
					//fila[1] = Conferencia.getInstance().getMisJugadores().get(i).getIconImages();
					fila[2] = Conferencia.getInstance().getTeamMembers(equipo).get(i).getEquipo();
					fila[3] = Conferencia.getInstance().getTeamMembers(equipo).get(i).getNombre();
					fila[4] = Conferencia.getInstance().getTeamMembers(equipo).get(i).getApellido();
					fila [5] = Conferencia.getInstance().getTeamMembers(equipo).get(i).getiD();
				}*/
				
			
			
			//model.addRow(fila);
		table.setModel(model);
		TableColumnModel columnModel = table.getColumnModel();
		table.setRowHeight(60);
		columnModel.getColumn(0).setPreferredWidth(60);
		columnModel.getColumn(1).setPreferredWidth(140);
		columnModel.getColumn(2).setPreferredWidth(170);
		columnModel.getColumn(3).setPreferredWidth(170);
		columnModel.getColumn(4).setPreferredWidth(170);
		columnModel.getColumn(5).setPreferredWidth(120);
	}
	private void loadEquipos() throws ClassNotFoundException, IOException {
		for (int i = 0; i < Conferencia.getInstance().getEquipos().size(); i++) {
			cbxEquipos.addItem(Conferencia.getInstance().getEquipos().get(i).getNombre());
		}
		cbxEquipos.insertItemAt("<Seleccione un equipo>", 0);
		cbxEquipos.setSelectedIndex(0);
	}
}