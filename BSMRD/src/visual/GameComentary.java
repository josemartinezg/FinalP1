package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import logical.Conferencia;
import logical.Equipo;
import logical.Jugador;
import logical.FechaSimple;
import logical.Juego;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GameComentary extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTextField txtLocalPoints;
	private static JTextField txtAwayPoints;
	private JLabel lblAway;
	private JSeparator separator_1;
	private JLabel lblLocal;
	private JTextPane textPaneTime;
	private JLabel lblPeriod;
	private JTextPane textPanePeriod;
	private TeamList equipoLocalList;
	private TeamList equipoVisitanteList;
	private JScrollPane scollPaneLocal;
	private JScrollPane scrollPaneVisitante;
	private JLabel lblLocalLogo;
	private JLabel lblVisitanteLogo;
	private JButton localOne;
	private JButton localTwo;
	private JButton localThree;
	private JButton localMinusOne;

	private JComboBox cbxJugadaLocal;
	private JComboBox cbxJugadaVisitante;

	private JButton awayOne;
	private JButton awayTwo;
	private JButton awayThree;
	private JButton awayMinusOne;

	private JButton okButton;
	private JButton cancelButton;

	private JButton btnAsistenciaLocal;
	private JButton btnReboteLocal;
	private JButton btnAsistenciaVisitante;
	private JButton btnReboteVisitante;

	private Juego juego;
	private BasketCountDown countDown;
	private int quarterDuration;
	
	private static Equipo equipoLocal;
	private static Equipo equipoVisitante;
	
	boolean extraTime = false;
	Integer periodoActual = 1;
	int maxQuarters = 1;
	
	Map localPlayingPlayers;
	Map awayPlayingPlayers;
	
	// Pa TEST
	// public static void main(String[] args) {
	// try {
	// // DATA PRUEBA
	// ImageIcon imgKoopa = new
	// ImageIcon(GameComentary.class.getResource("/visual/players/Koopa.png"));
	// ImageIcon imgBowser = new
	// ImageIcon(GameComentary.class.getResource("/visual/players/Bowser.png"));
	// ImageIcon imgLuigi = new
	// ImageIcon(GameComentary.class.getResource("/visual/players/Luigi.png"));
	// ImageIcon imgMario = new
	// ImageIcon(GameComentary.class.getResource("/visual/players/Mario.png"));
	// ImageIcon imgPeach = new
	// ImageIcon(GameComentary.class.getResource("/visual/players/Peach.png"));
	//
	// Jugador j1 = new Jugador("Koopa", "Ortiz", "123", "Warriors", new
	// FechaSimple(11, 8, 2018), 500, "Liga 1", false, 23, 10, 50, imgKoopa);
	// Jugador j2 = new Jugador("Bowser", "Ortiz", "123", "Warriors", new
	// FechaSimple(11, 8, 2018), 500, "Liga 1", false, 23, 10, 50, imgBowser);
	// Jugador j3 = new Jugador("Mario", "Ortiz", "123", "Warriors", new
	// FechaSimple(11, 8, 2018), 500, "Liga 1", false, 23, 10, 50, imgMario);
	// Jugador j4 = new Jugador("Luigi", "Ortiz", "123", "Warriors", new
	// FechaSimple(11, 8, 2018), 500, "Liga 1", false, 23, 10, 50, imgLuigi);
	// Jugador j5 = new Jugador("Peach", "Ortiz", "123", "Warriors", new
	// FechaSimple(11, 8, 2018), 500, "Liga 1", false, 23, 10, 50, imgPeach);
	//
	// Equipo eq1 = new Equipo("Equipo 1", "Entrenador 1", "Estadio 1");
	// Equipo eq2 = new Equipo("Equipo 2", "Entrenador 2", "Estadio 2");
	//
	// eq1.setLogo(new
	// ImageIcon(GameComentary.class.getResource("/visual/teams/nba_golden_state_warriors_200x.png")));
	// eq2.setLogo(new
	// ImageIcon(GameComentary.class.getResource("/visual/teams/nba_golden_state_warriors_200x.png")));
	//
	// eq1.addJugador(j1);
	// eq1.addJugador(j2);
	// eq1.addJugador(j3);
	// eq1.addJugador(j4);
	// eq1.addJugador(j5);
	//
	// eq2.addJugador(j5);
	// eq2.addJugador(j4);
	// eq2.addJugador(j3);
	// eq2.addJugador(j2);
	// eq2.addJugador(j1);
	// Juego jg = new Juego("Estadio 1", eq1, eq2, null);
	//
	//
	//
	// GameComentary dialog = new GameComentary(3, jg);
	// dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	//
	// dialog.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	public GameComentary(int quarterDuration, Juego juego) {
		this.juego = juego;
		this.quarterDuration = quarterDuration;
		
		equipoLocal = juego.getLocal();
		equipoVisitante = juego.getVisitante();
		
		localPlayingPlayers = mapActividad(equipoLocal);
		awayPlayingPlayers = mapActividad(equipoVisitante);
		
		setBounds(100, 100, 1103, 578);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblAway = new JLabel("Visitante");
		lblAway.setHorizontalAlignment(SwingConstants.CENTER);
		lblAway.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblAway.setBounds(960, 14, 110, 37);
		contentPanel.add(lblAway);
		{
			lblLocal = new JLabel("Local");
			lblLocal.setHorizontalAlignment(SwingConstants.CENTER);
			lblLocal.setFont(new Font("Tahoma", Font.PLAIN, 23));
			lblLocal.setBounds(10, 14, 87, 37);
			contentPanel.add(lblLocal);
		}

		textPaneTime = new JTextPane();
		textPaneTime.setForeground(Color.RED);
		textPaneTime.setFont(new Font("Seven Segment", Font.BOLD, 50));
		textPaneTime.setText("00:00");
		textPaneTime.setEditable(false);
		textPaneTime.setBounds(482, 0, 130, 58);
		contentPanel.add(textPaneTime);

		lblPeriod = new JLabel("Periodo");
		lblPeriod.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPeriod.setBounds(506, 59, 75, 31);

		contentPanel.add(lblPeriod);

		textPanePeriod = new JTextPane();
		textPanePeriod.setForeground(Color.RED);
		textPanePeriod.setEditable(false);
    
		textPanePeriod.setFont(new Font("Seven Segment", Font.PLAIN, 32));
		textPanePeriod.setText("1");
		textPanePeriod.setBounds(534, 92, 21, 37);

		contentPanel.add(textPanePeriod);

		txtLocalPoints = new JTextField();
		txtLocalPoints.setEditable(false);
		txtLocalPoints.setForeground(Color.GREEN);
		txtLocalPoints.setText("0");
		txtLocalPoints.setFont(new Font("Seven Segment", Font.BOLD, 30));
		txtLocalPoints.setBounds(139, 12, 68, 39);
		contentPanel.add(txtLocalPoints);
		txtLocalPoints.setColumns(10);

		txtAwayPoints = new JTextField();
		txtAwayPoints.setForeground(Color.GREEN);
		txtAwayPoints.setText("0");
		txtAwayPoints.setFont(new Font("Seven Segment", Font.BOLD, 30));
		txtAwayPoints.setEditable(false);
		txtAwayPoints.setColumns(10);
		txtAwayPoints.setBounds(880, 12, 68, 39);
		contentPanel.add(txtAwayPoints);

		equipoLocalList = new TeamList(equipoLocal);
		equipoVisitanteList = new TeamList(equipoVisitante);
		
		equipoLocalList.getList().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					Jugador jg = equipoLocalList.getSelectedPlayer();
					if (!(boolean) localPlayingPlayers.get(jg)) {
						localPlayingPlayers.put(jg, true);
						jg.getEstadisticas().aumentarJuegos();
					}
				}
			}
		});
		
		equipoVisitanteList.getList().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					Jugador jg = equipoVisitanteList.getSelectedPlayer();
					if (!(boolean) awayPlayingPlayers.get(jg)) {
						awayPlayingPlayers.put(jg, true);
						jg.getEstadisticas().aumentarJuegos();
					}
					
				}
			}
		});
		
		scollPaneLocal = new JScrollPane(equipoLocalList.getList());
		scrollPaneVisitante = new JScrollPane(equipoVisitanteList.getList());

		scollPaneLocal.setBounds(10, 59, 197, 339);
		contentPanel.add(scollPaneLocal);

		lblLocalLogo = new JLabel("");
		lblLocalLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocalLogo.setIcon(equipoLocal.getLogo());
		scollPaneLocal.setColumnHeaderView(lblLocalLogo);

		scrollPaneVisitante.setBounds(880, 59, 197, 339);
		contentPanel.add(scrollPaneVisitante);

		lblVisitanteLogo = new JLabel("");
		lblVisitanteLogo.setIcon(equipoVisitante.getLogo());
		lblVisitanteLogo.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPaneVisitante.setColumnHeaderView(lblVisitanteLogo);

		localOne = new JButton("");
		localOne.setEnabled(false);
		localOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Jugador auxJugador = equipoLocalList.getSelectedPlayer();
					if (cbxJugadaLocal.getSelectedIndex() == 0) {
						txtLocalPoints.setText(Integer.toString(Integer.parseInt(txtLocalPoints.getText()) + 1));
						auxJugador.getEstadisticas().addTiro(1, true);

					} else {
						auxJugador.getEstadisticas().addTiro(1, false);
					}
				} catch (IndexOutOfBoundsException error) {
					System.out.println("Ningun jugador seleccionado");
				}

			}
		});
		localOne.setIcon(new ImageIcon(GameComentary.class.getResource("/visual/1-c.png")));
		localOne.setBounds(10, 451, 32, 32);
		contentPanel.add(localOne);

		localTwo = new JButton("");
		localTwo.setEnabled(false);
		localTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Jugador auxJugador = equipoLocalList.getSelectedPlayer();
					if (cbxJugadaLocal.getSelectedIndex() == 0) {
						txtLocalPoints.setText(Integer.toString(Integer.parseInt(txtLocalPoints.getText()) + 2));
						auxJugador.getEstadisticas().addTiro(2, true);
					} else {
						auxJugador.getEstadisticas().addTiro(2, false);
					}
				} catch (IndexOutOfBoundsException error) {
					System.out.println("Ningun jugador seleccionado");
				}
			}
		});
		localTwo.setIcon(new ImageIcon(GameComentary.class.getResource("/visual/2-c.png")));
		localTwo.setBounds(64, 451, 32, 32);
		contentPanel.add(localTwo);

		localThree = new JButton("");
		localThree.setEnabled(false);
		localThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Jugador auxJugador = equipoLocalList.getSelectedPlayer();
					if (cbxJugadaLocal.getSelectedIndex() == 0) {
						txtLocalPoints.setText(Integer.toString(Integer.parseInt(txtLocalPoints.getText()) + 3));
						auxJugador.getEstadisticas().addTiro(3, true);
					} else {
						auxJugador.getEstadisticas().addTiro(3, false);
					}
				} catch (IndexOutOfBoundsException error) {
					System.out.println("Ningun jugador seleccionado");
				}
			}
		});
		localThree.setFont(new Font("Tahoma", Font.PLAIN, 13));
		localThree.setIcon(new ImageIcon(GameComentary.class.getResource("/visual/numbers-3-black-icon(1).png")));
		localThree.setBounds(119, 451, 32, 32);
		contentPanel.add(localThree);

		localMinusOne = new JButton("");
		localMinusOne.setEnabled(false);
		localMinusOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Jugador auxJugador = equipoLocalList.getSelectedPlayer();
					if (Integer.parseInt(txtLocalPoints.getText()) > 0) {
						txtLocalPoints.setText(Integer.toString(Integer.parseInt(txtLocalPoints.getText()) - 1));
						auxJugador.getEstadisticas().addTiro(-1, true);
					}
				} catch (IndexOutOfBoundsException error) {
					System.out.println("Ningun jugador seleccionado");
				}
			}
		});
		localMinusOne.setIcon(new ImageIcon(GameComentary.class.getResource("/visual/backspace_web_remove_pixel_per.png")));
		localMinusOne.setBounds(176, 451, 32, 32);
		contentPanel.add(localMinusOne);

		awayOne = new JButton("");
		awayOne.setEnabled(false);
		awayOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Jugador auxJugador = equipoVisitanteList.getSelectedPlayer();
					if (cbxJugadaVisitante.getSelectedIndex() == 0) {
						txtAwayPoints.setText(Integer.toString(Integer.parseInt(txtAwayPoints.getText()) + 1));
						auxJugador.getEstadisticas().addTiro(1, true);
					} else {
						auxJugador.getEstadisticas().addTiro(1, false);
					}
				} catch (IndexOutOfBoundsException error) {
					System.out.println("Ningun jugador seleccionado");
				}
			}
		});
		awayOne.setIcon(new ImageIcon(GameComentary.class.getResource("/visual/1-c.png")));
		awayOne.setBounds(880, 451, 32, 32);
		contentPanel.add(awayOne);

		awayTwo = new JButton("");
		awayTwo.setEnabled(false);
		awayTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Jugador auxJugador = equipoVisitanteList.getSelectedPlayer();
					if (cbxJugadaVisitante.getSelectedIndex() == 0) {
						txtAwayPoints.setText(Integer.toString(Integer.parseInt(txtAwayPoints.getText()) + 2));
						auxJugador.getEstadisticas().addTiro(2, true);
					} else {
						auxJugador.getEstadisticas().addTiro(2, false);
					}
				} catch (IndexOutOfBoundsException error) {
					System.out.println("Ningun jugador seleccionado");
				}
			}
		});
		awayTwo.setIcon(new ImageIcon(GameComentary.class.getResource("/visual/2-c.png")));
		awayTwo.setBounds(939, 451, 32, 32);
		contentPanel.add(awayTwo);

		awayThree = new JButton("");
		awayThree.setEnabled(false);
		awayThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Jugador auxJugador = equipoVisitanteList.getSelectedPlayer();
					if (cbxJugadaVisitante.getSelectedIndex() == 0) {
						txtAwayPoints.setText(Integer.toString(Integer.parseInt(txtAwayPoints.getText()) + 3));
						auxJugador.getEstadisticas().addTiro(3, true);
					} else {
						auxJugador.getEstadisticas().addTiro(3, false);
					}
				} catch (IndexOutOfBoundsException error) {
					System.out.println("Ningun jugador seleccionado");
				}
			}
		});
		awayThree.setIcon(new ImageIcon(GameComentary.class.getResource("/visual/numbers-3-black-icon(1).png")));
		awayThree.setBounds(992, 451, 32, 32);
		contentPanel.add(awayThree);

		awayMinusOne = new JButton("");
		awayMinusOne.setEnabled(false);
		awayMinusOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Jugador auxJugador = equipoVisitanteList.getSelectedPlayer();
					if (Integer.parseInt(txtAwayPoints.getText()) > 0) {
						txtAwayPoints.setText(Integer.toString(Integer.parseInt(txtAwayPoints.getText()) - 1));
						auxJugador.getEstadisticas().addTiro(-1, true);
					}
				} catch (IndexOutOfBoundsException error) {
					System.out.println("Ningun jugador seleccionado");
				}
			}
		});
		awayMinusOne.setIcon(new ImageIcon(GameComentary.class.getResource("/visual/backspace_web_remove_pixel_per.png")));
		awayMinusOne.setBounds(1046, 451, 32, 32);
		contentPanel.add(awayMinusOne);

		separator_1 = new JSeparator();
		separator_1.setBounds(0, 304, 590, -9);
		contentPanel.add(separator_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Iniciar Periodo");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						countDown.start();
						okButton.setEnabled(false);
						enablePointControls();
					}
				});
				okButton.setActionCommand("");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Finalizar Juego");
				cancelButton.setEnabled(false);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

		countDown = new BasketCountDown(quarterDuration, 0, textPaneTime, this);

		cbxJugadaLocal = new JComboBox();
		cbxJugadaLocal.setEnabled(false);
		cbxJugadaLocal.setModel(new DefaultComboBoxModel(new String[] { "Anotacion", "Intento" }));
		cbxJugadaLocal.setBounds(10, 409, 197, 29);
		contentPanel.add(cbxJugadaLocal);

		cbxJugadaVisitante = new JComboBox();
		cbxJugadaVisitante.setEnabled(false);
		cbxJugadaVisitante.setModel(new DefaultComboBoxModel(new String[] { "Anotacion", "Intento" }));
		cbxJugadaVisitante.setBounds(880, 412, 197, 20);
		contentPanel.add(cbxJugadaVisitante);

		btnAsistenciaLocal = new JButton("");
		btnAsistenciaLocal.setToolTipText("Marcar Asistencia");
		btnAsistenciaLocal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					equipoLocalList.getSelectedPlayer().getEstadisticas().addAsistencias();
					System.out.println(
							equipoLocalList.getSelectedPlayer().getNombre() + " ha conseguido una asistencia.");
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Ningun jugador seleccionado");
				}
			}
		});
		btnAsistenciaLocal.setEnabled(false);
		btnAsistenciaLocal.setIcon(new ImageIcon(GameComentary.class.getResource("/visual/assist_icon.png")));
		btnAsistenciaLocal.setBounds(237, 59, 90, 85);
		contentPanel.add(btnAsistenciaLocal);

		btnReboteLocal = new JButton("");
		btnReboteLocal.setToolTipText("Marcar Rebote");
		btnReboteLocal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					equipoLocalList.getSelectedPlayer().getEstadisticas().addRebotes();
					System.out.println(equipoLocalList.getSelectedPlayer().getNombre() + " ha conseguido un rebote.");
				} catch (IndexOutOfBoundsException error) {
					System.out.println("Ningun jugador seleccionado");
				}
			}
		});
		btnReboteLocal.setEnabled(false);
		btnReboteLocal.setIcon(new ImageIcon(GameComentary.class.getResource("/visual/rebote_local.png")));
		btnReboteLocal.setBounds(237, 313, 90, 85);
		contentPanel.add(btnReboteLocal);

		btnAsistenciaVisitante = new JButton("");
		btnAsistenciaVisitante.setToolTipText("Marcar Asistencia");
		btnAsistenciaVisitante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					equipoVisitanteList.getSelectedPlayer().getEstadisticas().addAsistencias();
					System.out.println(
							equipoVisitanteList.getSelectedPlayer().getNombre() + " ha conseguido una asistencia.");
				} catch (IndexOutOfBoundsException error) {
					System.out.println("Ningun jugador seleccionado");
				}
			}
		});
		btnAsistenciaVisitante.setEnabled(false);
		btnAsistenciaVisitante.setIcon(new ImageIcon(GameComentary.class.getResource("/visual/assist_icon.png")));
		btnAsistenciaVisitante.setBounds(763, 59, 90, 85);
		contentPanel.add(btnAsistenciaVisitante);

		btnReboteVisitante = new JButton("");
		btnReboteVisitante.setToolTipText("Marcar Rebote");
		btnReboteVisitante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					equipoVisitanteList.getSelectedPlayer().getEstadisticas().addRebotes();
					System.out
							.println(equipoVisitanteList.getSelectedPlayer().getNombre() + " ha conseguido un rebote.");
				} catch (IndexOutOfBoundsException error) {
					System.out.println("Ningun jugador seleccionado");
				}
			}
		});
		btnReboteVisitante.setEnabled(false);
		btnReboteVisitante.setIcon(new ImageIcon(GameComentary.class.getResource("/visual/rebote_visitante.png")));
		btnReboteVisitante.setBounds(763, 313, 90, 85);
		contentPanel.add(btnReboteVisitante);
	}

	private Map mapActividad(Equipo equipo) {
		Map aux = new HashMap();
		for(Jugador jg : equipo.getJugadores()) {
			aux.put(jg, new Boolean(false));
		}
		return aux;
	}

	private void endGame() throws IOException, ClassNotFoundException {
		// acabar el juego
		System.out.println("Fin del juego");
		cancelButton.setEnabled(true);
		disablePointControls();

		int totalPointsLocal = Integer.parseInt(txtLocalPoints.getText());
		int totalPointsAway = Integer.parseInt(txtAwayPoints.getText());

		juego.getMarcador().setPuntajeLocal(totalPointsLocal);
		juego.getMarcador().setPuntajeVisitante(totalPointsAway);
		juego.setOcurrido(true);

		if (totalPointsLocal > totalPointsAway) {
			juego.getLocal().setJuegosGanados(juego.getLocal().getJuegosGanados() + 1);
			juego.getVisitante().setJuegosPerdidos(juego.getVisitante().getJuegosPerdidos() + 1);
		} else {
			juego.getVisitante().setJuegosGanados(juego.getVisitante().getJuegosGanados() + 1);
			juego.getLocal().setJuegosPerdidos(juego.getLocal().getJuegosPerdidos() + 1);
		}
		Conferencia.save();
		BSM.fillJuegosSemana();
		BSM.fillJugDestacados();
	}

	private void disablePointControls() {
		localOne.setEnabled(false);
		localTwo.setEnabled(false);
		localThree.setEnabled(false);
		localMinusOne.setEnabled(false);

		awayOne.setEnabled(false);
		awayTwo.setEnabled(false);
		awayThree.setEnabled(false);
		awayMinusOne.setEnabled(false);

		cbxJugadaLocal.setEnabled(false);
		cbxJugadaVisitante.setEnabled(false);

		btnAsistenciaLocal.setEnabled(false);
		btnReboteLocal.setEnabled(false);
		btnAsistenciaVisitante.setEnabled(false);
		btnReboteVisitante.setEnabled(false);
	}

	private void enablePointControls() {
		localOne.setEnabled(true);
		localTwo.setEnabled(true);
		localThree.setEnabled(true);
		localMinusOne.setEnabled(true);

		awayOne.setEnabled(true);
		awayTwo.setEnabled(true);
		awayThree.setEnabled(true);
		awayMinusOne.setEnabled(true);

		cbxJugadaLocal.setEnabled(true);
		cbxJugadaVisitante.setEnabled(true);

		btnAsistenciaLocal.setEnabled(true);
		btnReboteLocal.setEnabled(true);
		btnAsistenciaVisitante.setEnabled(true);
		btnReboteVisitante.setEnabled(true);
	}

	public void endPeriod() throws IOException, ClassNotFoundException {
        if (periodoActual >= maxQuarters && !juegoEmpate()) {
       	 this.endGame();
        } else if (periodoActual >= maxQuarters && juegoEmpate()) {
        	int tiempoExtra = Integer.parseInt(textPanePeriod.getText());
        	if (!extraTime) {
        		countDown.setDefaultMinutes(quarterDuration/3);
        		lblPeriod.setText("Tiempo Extra Nº");
        		extraTime = true;
        		textPanePeriod.setText(Integer.toString(1));
        		okButton.setText("Iniciar OT");
        	} else
        		textPanePeriod.setText(Integer.toString(tiempoExtra+1));
        	okButton.setEnabled(true);
        	disablePointControls();
        } else {
        	periodoActual += 1;
        	textPanePeriod.setText(Integer.toString(periodoActual));
        	okButton.setEnabled(true);
        	disablePointControls();
        }
	}

	public boolean juegoEmpate() {
		int totalPointsLocal = Integer.parseInt(txtLocalPoints.getText());
		int totalPointsAway = Integer.parseInt(txtAwayPoints.getText());

		return totalPointsLocal == totalPointsAway;
	}

	public static String getPuntajeLocal() {
		return txtLocalPoints.getText();
	}

	public static String getPuntajeVisitante() {
		return txtAwayPoints.getText();
	}
	
	public static ImageIcon getLogoLocal() {
		return equipoLocal.getLogo();
	}

	public static ImageIcon getLogoVisitante() {
		return equipoVisitante.getLogo();
	}
}
