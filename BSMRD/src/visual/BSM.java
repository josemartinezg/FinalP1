package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

import logical.Conferencia;
import logical.Juego;
import logical.Jugador;


import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class BSM extends JFrame {

	/**
	 * @wbp.nonvisual location=150,99
	 */
	private JPanel panelA;
	private static GameComentary gameComentary=null;
	private static Juego proximoJuego = null;
	private RegistroJugadores registroJugadores=null;
	private JMenuItem mntmRegistrarEquipo;
	private JMenuItem mntmListarEquipo;
	private JMenuItem mntmRegistrarJugador;
	private JMenuItem mntmListarJugador;
	private Conferencia conferencia;
	private JMenuItem mntmRegistrarJuego;
	private JMenuItem mntmListarJuego;
	private JMenuItem mntmReporteLesionados;
	private JMenuItem mntmReporteDestacados;
	private JMenuItem mntmReporteRanking;
	
	
	private static JList listJugadoresDestacados;
	private static JList listJuegosDeLaSemana;
	private static int indexJugadoresDestacados=0;
	private static JLabel lblPuntosEquipoLocal;
	private static JLabel lblPuntosEquipoVisitante;
	private static JLabel lblLogoEquipoLocal;
	private static JLabel lblLogoEquipoVisitante;
	private static JButton btnIniciarSiguienteJuego;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BSM frame = new BSM();
					frame.setVisible(true);
					//BORRAR ESTA LINEA
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public BSM() {
		setTitle("Basketball Statistical Manager RD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);
		setUndecorated(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
	    JLabel label = new JLabel(new ImageIcon(BSM.class.getResource("/thumb/background.jpg")));
	    setContentPane(label);
	    BorderLayout flowLayout = new BorderLayout();
	    getContentPane().setLayout(flowLayout);
	    
	    Font listFont = null;
	    try {
            InputStream is =  getClass().getResourceAsStream("/fonts/Segoe UI.ttf");
            listFont = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (Exception ex) {
            System.err.println("Segoe UI.ttf" + " No se cargo la fuente");
            listFont = new Font("Arial", Font.PLAIN, 14);            
        }
	    
	    Font headerListFont = null;
	    try {
            InputStream is =  getClass().getResourceAsStream("/fonts/Segoe UI.ttf");
            headerListFont = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (Exception ex) {
            System.err.println("Segoe UI.ttf" + " No se cargo la fuente");
            headerListFont = new Font("Arial", Font.PLAIN, 14);            
        }
	    
	    panelA = new JPanel();
	    panelA.setBounds(100, 100, 1280, 800);
	    panelA.setOpaque(false);
	    getContentPane().add(panelA);
	    panelA.setLayout(null);
	    
	    JButton btnJuegos = new JButton("Juegos");
	    btnJuegos.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		mntmListarJuego.setVisible(!mntmListarJuego.isVisible());
	    		mntmRegistrarJuego.setVisible(!mntmRegistrarJuego.isVisible());
	    	}
	    });
	    btnJuegos.setBackground(new Color(255, 204, 0));
	    btnJuegos.setForeground(new Color(255, 255, 255));
	    btnJuegos.setFont(new Font("Lucida Bright", Font.BOLD, 34));
	    btnJuegos.setBounds(824, 0, 230, 120);
	    btnJuegos.setOpaque(false);
	    btnJuegos.setContentAreaFilled(false);
	    btnJuegos.setBorderPainted(false);
	    panelA.add(btnJuegos);
	    
	    JButton btnJugadores = new JButton("Jugadores");
	    btnJugadores.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		mntmListarJugador.setVisible(!mntmListarJugador.isVisible());
	    		mntmRegistrarJugador.setVisible(!mntmRegistrarJugador.isVisible());
	    	}
	    });
	    btnJugadores.setBackground(new Color(255, 204, 0));
	    btnJugadores.setOpaque(false);
	    btnJugadores.setForeground(new Color(255, 255, 255));
	    btnJugadores.setFont(new Font("Lucida Bright", Font.BOLD, 34));
	    btnJugadores.setContentAreaFilled(false);
	    btnJugadores.setBorderPainted(false);
	    btnJugadores.setBounds(617, 0, 210, 120);
	    panelA.add(btnJugadores);
	    
	    JButton btnEquipos = new JButton("Equipos");
	    btnEquipos.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		mntmListarEquipo.setVisible(!mntmListarEquipo.isVisible());
	    		mntmRegistrarEquipo.setVisible(!mntmRegistrarEquipo.isVisible());
	    	}
	    });
	    btnEquipos.setBackground(new Color(255, 204, 0));
	    btnEquipos.setForeground(new Color(255, 255, 255));
	    btnEquipos.setFont(new Font("Lucida Bright", Font.BOLD, 34));
	    btnEquipos.setOpaque(false);
	    btnEquipos.setContentAreaFilled(false);
	    btnEquipos.setBorderPainted(false);
	    btnEquipos.setBounds(408, 0, 210, 120);
	    panelA.add(btnEquipos);
	    
	    JLabel lblVs = new JLabel("VS");
	    lblVs.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
	    lblVs.setHorizontalAlignment(SwingConstants.CENTER);
	    lblVs.setForeground(new Color(255, 255, 255));
	    lblVs.setBounds(825, 400, 63, 48);
	    lblVs.setVisible(false);
	    panelA.add(lblVs);
	    
	    JLabel lblVersusball = new JLabel(new ImageIcon(BSM.class.getResource("/thumb/versus-ball.png")));
	    lblVersusball.setBounds(800, 362, 120, 120);
	    lblVersusball.setVisible(false);
	    panelA.add(lblVersusball);
	    
	    lblPuntosEquipoLocal = new JLabel("72");
	    lblPuntosEquipoLocal.setForeground(new Color(255, 255, 255));
	    lblPuntosEquipoLocal.setFont(new Font("SimSun", Font.BOLD, 48));
	    lblPuntosEquipoLocal.setHorizontalAlignment(SwingConstants.CENTER);
	    lblPuntosEquipoLocal.setBounds(522, 546, 165, 55);
	    panelA.add(lblPuntosEquipoLocal);
	    
	    lblPuntosEquipoVisitante = new JLabel("90");
	    lblPuntosEquipoVisitante.setForeground(new Color(255, 255, 255));
	    lblPuntosEquipoVisitante.setHorizontalAlignment(SwingConstants.CENTER);
	    lblPuntosEquipoVisitante.setFont(new Font("SimSun", Font.BOLD, 48));
	    lblPuntosEquipoVisitante.setBounds(1032, 546, 165, 55);
	    panelA.add(lblPuntosEquipoVisitante);
	    
	    lblLogoEquipoLocal = new JLabel(new ImageIcon(BSM.class.getResource("/thumb/houston-rockets.png")));
	    lblLogoEquipoLocal.setBounds(487, 300, 233, 221);
	    panelA.add(lblLogoEquipoLocal);
	    
	    lblLogoEquipoVisitante = new JLabel(new ImageIcon(BSM.class.getResource("/thumb/boston-celtics.png")));
	    lblLogoEquipoVisitante.setBounds(998, 300, 233, 221);
	    panelA.add(lblLogoEquipoVisitante);
	    
	    JButton btnJuegosDeLa = new JButton("Juegos de la semana");
	    btnJuegosDeLa.setForeground(Color.BLACK);
	    btnJuegosDeLa.setFont(headerListFont.deriveFont(Font.BOLD, 30));
	    btnJuegosDeLa.setBorderPainted(false);
	    btnJuegosDeLa.setBackground(new Color(255, 204, 0));
	    btnJuegosDeLa.setBounds(0, 0, 407, 120);
	    panelA.add(btnJuegosDeLa);
	    
	    listJuegosDeLaSemana = new JList();
	    listJuegosDeLaSemana.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    listJuegosDeLaSemana.setBounds(0, 118, 407, 361);
	    listJuegosDeLaSemana.setForeground(Color.BLACK);
	    listJuegosDeLaSemana.setFont(listFont.deriveFont(Font.ITALIC, 20));
	    listJuegosDeLaSemana.setBackground(new Color(255, 255, 204));
	    try {
			fillJuegosSemana();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    panelA.add(listJuegosDeLaSemana);
	    
	    JButton btnJugadoresDestacados = new JButton("Jugadores destacados");
	    btnJugadoresDestacados.setForeground(Color.BLACK);
	    btnJugadoresDestacados.setFont(headerListFont.deriveFont(Font.BOLD, 24));
	    btnJugadoresDestacados.setBorderPainted(false);
	    btnJugadoresDestacados.setBackground(new Color(255, 204, 0));
	    btnJugadoresDestacados.setBounds(38, 479, 330, 120);
	    panelA.add(btnJugadoresDestacados);
	    
	    mntmReporteLesionados = new JMenuItem("Jugadores lesionados");
	    mntmReporteLesionados.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		LesionesPorGrado lesionesPorGrado=null;
				try {
					lesionesPorGrado = new LesionesPorGrado();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lesionesPorGrado.setVisible(true);
	    	}
	    });
	    mntmReporteLesionados.setForeground(new Color(255, 255, 255));
	    mntmReporteLesionados.setFont(new Font("Segoe UI", Font.BOLD, 20));
	    mntmReporteLesionados.setOpaque(false);
	    mntmReporteLesionados.setContentAreaFilled(false);
	    mntmReporteLesionados.setBorderPainted(false);
	    mntmReporteLesionados.setBounds(1050, 117, 226, 79);
	    mntmReporteLesionados.setVisible(false);
	    panelA.add(mntmReporteLesionados);
	    
	    mntmReporteDestacados = new JMenuItem("Jugadores destacados");
	    mntmReporteDestacados.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		TopFivePorcentajeTiro topFivePorcentajeTiro=null;
				try {
					topFivePorcentajeTiro = new TopFivePorcentajeTiro();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				topFivePorcentajeTiro.setVisible(true);
	    	}
	    });
	    mntmReporteDestacados.setForeground(new Color(255, 255, 255));
	    mntmReporteDestacados.setFont(new Font("Segoe UI", Font.BOLD, 20));
	    mntmReporteDestacados.setOpaque(false);
	    mntmReporteDestacados.setContentAreaFilled(false);
	    mntmReporteDestacados.setBorderPainted(false);
	    mntmReporteDestacados.setBounds(1050, 167, 226, 79);
	    mntmReporteDestacados.setVisible(false);
	    panelA.add(mntmReporteDestacados);
	    
	    mntmReporteRanking = new JMenuItem("Ranking de la liga");
	    mntmReporteRanking.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		RankingLiga rankingLiga=null;
				try {
					rankingLiga = new RankingLiga();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				rankingLiga.setVisible(true);
	    	}
	    });
	    mntmReporteRanking.setForeground(new Color(255, 255, 255));
	    mntmReporteRanking.setFont(new Font("Segoe UI", Font.BOLD, 20));
	    mntmReporteRanking.setOpaque(false);
	    mntmReporteRanking.setContentAreaFilled(false);
	    mntmReporteRanking.setBorderPainted(false);
	    mntmReporteRanking.setBounds(1050, 217, 226, 79);
	    mntmReporteRanking.setVisible(false);
	    panelA.add(mntmReporteRanking);
	    
	    JButton btnReportes = new JButton("Reportes");
	    btnReportes.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		mntmReporteDestacados.setVisible(!mntmReporteDestacados.isVisible());
	    		mntmReporteLesionados.setVisible(!mntmReporteLesionados.isVisible());
	    		mntmReporteRanking.setVisible(!mntmReporteRanking.isVisible());
	    	}
	    });
	    btnReportes.setOpaque(false);
	    btnReportes.setForeground(Color.WHITE);
	    btnReportes.setFont(new Font("Lucida Bright", Font.BOLD, 34));
	    btnReportes.setContentAreaFilled(false);
	    btnReportes.setBorderPainted(false);
	    btnReportes.setBackground(new Color(255, 204, 0));
	    btnReportes.setBounds(1050, 0, 230, 120);
	    panelA.add(btnReportes);
	    
	    listJugadoresDestacados = new JList();
	    listJugadoresDestacados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    listJugadoresDestacados.setForeground(Color.BLACK);
	    listJugadoresDestacados.setFont(listFont.deriveFont(Font.ITALIC, 20));
	    listJugadoresDestacados.setBackground(new Color(255, 255, 204));
	    listJugadoresDestacados.setBounds(0, 598, 407, 202);
	    try {
			fillJugDestacados();
		} catch (ClassNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
	    panelA.add(listJugadoresDestacados);
	    
	    mntmRegistrarEquipo = new JMenuItem("Registrar equipo");
	    mntmRegistrarEquipo.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		RegEquipo regEquipo = new RegEquipo(null);
	    		regEquipo.setVisible(true);
	    	}
	    });
	    mntmRegistrarEquipo.setForeground(new Color(255, 255, 255));
	    mntmRegistrarEquipo.setFont(new Font("Segoe UI", Font.BOLD, 20));
	    mntmRegistrarEquipo.setOpaque(false);
	    mntmRegistrarEquipo.setContentAreaFilled(false);
	    mntmRegistrarEquipo.setBorderPainted(false);
	    mntmRegistrarEquipo.setBounds(408, 118, 228, 79);
	    mntmRegistrarEquipo.setVisible(false);
	    panelA.add(mntmRegistrarEquipo);
	    
	    mntmListarEquipo = new JMenuItem("Listar equipos");
	    mntmListarEquipo.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		VerEquipos verEquipos = new VerEquipos();
	    		verEquipos.setVisible(true);
	    	}
	    });
	    mntmListarEquipo.setForeground(new Color(255, 255, 255));
	    mntmListarEquipo.setFont(new Font("Segoe UI", Font.BOLD, 20));
	    mntmListarEquipo.setOpaque(false);
	    mntmListarEquipo.setContentAreaFilled(false);
	    mntmListarEquipo.setBorderPainted(false);
	    mntmListarEquipo.setBounds(408, 190, 228, 79);
	    mntmListarEquipo.setVisible(false);
	    panelA.add(mntmListarEquipo);
	    
	    mntmRegistrarJugador = new JMenuItem("Registrar jugador");
	    mntmRegistrarJugador.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		registroJugadores = RegistroJugadores.getInstance();
	    		registroJugadores.setVisible(true);
	    	}
	    });
	    mntmRegistrarJugador.setForeground(new Color(255, 255, 255));
	    mntmRegistrarJugador.setFont(new Font("Segoe UI", Font.BOLD, 20));
	    mntmRegistrarJugador.setOpaque(false);
	    mntmRegistrarJugador.setContentAreaFilled(false);
	    mntmRegistrarJugador.setBorderPainted(false);
	    mntmRegistrarJugador.setBounds(617, 117, 226, 79);
	    mntmRegistrarJugador.setVisible(false);
	    panelA.add(mntmRegistrarJugador);
	    
	    mntmListarJugador = new JMenuItem("Listar jugadores");
	    mntmListarJugador.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		VerJugadores verJugadores = null;
				try {
					verJugadores = new VerJugadores();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		verJugadores.setVisible(true);
	    	}
	    });
	    mntmListarJugador.setForeground(new Color(255, 255, 255));
	    mntmListarJugador.setFont(new Font("Segoe UI", Font.BOLD, 20));
	    mntmListarJugador.setOpaque(false);
	    mntmListarJugador.setContentAreaFilled(false);
	    mntmListarJugador.setBorderPainted(false);
	    mntmListarJugador.setBounds(617, 189, 226, 79);
	    mntmListarJugador.setVisible(false);
	    panelA.add(mntmListarJugador);
	    
	    mntmRegistrarJuego = new JMenuItem("Programar un juego");
	    mntmRegistrarJuego.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		RegJuego regJuego=null;
				try {
					regJuego = new RegJuego();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		regJuego.setVisible(true);
	    	}
	    });
	    mntmRegistrarJuego.setForeground(new Color(255, 255, 255));
	    mntmRegistrarJuego.setFont(new Font("Segoe UI", Font.BOLD, 20));
	    mntmRegistrarJuego.setOpaque(false);
	    mntmRegistrarJuego.setContentAreaFilled(false);
	    mntmRegistrarJuego.setBorderPainted(false);
	    mntmRegistrarJuego.setBounds(850, 117, 226, 79);
	    mntmRegistrarJuego.setVisible(false);
	    panelA.add(mntmRegistrarJuego);
	    
	    mntmListarJuego = new JMenuItem("Ver juegos pasados");
	    mntmListarJuego.setForeground(new Color(255, 255, 255));
	    mntmListarJuego.setFont(new Font("Segoe UI", Font.BOLD, 20));
	    mntmListarJuego.setOpaque(false);
	    mntmListarJuego.setContentAreaFilled(false);
	    mntmListarJuego.setBorderPainted(false);
	    mntmListarJuego.setBounds(850, 189, 226, 79);
	    mntmListarJuego.setVisible(false);
	    panelA.add(mntmListarJuego);
	    
	    
	    JButton btnSiguienteCategoria = new JButton(">");
	    btnSiguienteCategoria.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		indexJugadoresDestacados = indexJugadoresDestacados > 1 ? 0 : indexJugadoresDestacados+1;
	    		try {
					fillJugDestacados();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	}
	    });
	    btnSiguienteCategoria.setForeground(Color.BLACK);
	    btnSiguienteCategoria.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
	    btnSiguienteCategoria.setBorderPainted(false);
	    btnSiguienteCategoria.setBackground(new Color(255, 204, 0));
	    btnSiguienteCategoria.setBounds(358, 479, 49, 120);
	    panelA.add(btnSiguienteCategoria);
	    
	    JButton btnAnteriorCategoria = new JButton("<");
	    btnAnteriorCategoria.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		indexJugadoresDestacados = indexJugadoresDestacados < 1 ? 2 : indexJugadoresDestacados-1;
	    		try {
					fillJugDestacados();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	}
	    });
	    btnAnteriorCategoria.setForeground(Color.BLACK);
	    btnAnteriorCategoria.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
	    btnAnteriorCategoria.setBorderPainted(false);
	    btnAnteriorCategoria.setBackground(new Color(255, 204, 0));
	    btnAnteriorCategoria.setBounds(0, 479, 49, 120);
	    panelA.add(btnAnteriorCategoria);
	    
	    JButton btnClose = new JButton("Salir");
	    btnClose.setFont(new Font("Tahoma", Font.BOLD, 15));
	    btnClose.setBounds(1190, 739, 80, 50);
	    btnClose.setBackground(new Color(255, 204, 0));
	    btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(registroJugadores!=null)
						registroJugadores.dispose();
					dispose();
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
	    });
	    panelA.add(btnClose);
	    
	    btnIniciarSiguienteJuego = new JButton("Iniciar siguiente juego");
	    btnIniciarSiguienteJuego.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if (gameComentary == null) {
					try {
						proximoJuego = Conferencia.getInstance().getProximoJuego();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    		gameComentary = new GameComentary(10, proximoJuego);
		    		btnIniciarSiguienteJuego.setText("Ver juego en curso");
	    		}
	    		lblVersusball.setVisible(true);
	    		lblVs.setVisible(true);
		    	gameComentary.setVisible(true);
	    	}
	    });
	    btnIniciarSiguienteJuego.setFont(new Font("Tahoma", Font.BOLD, 15));
	    btnIniciarSiguienteJuego.setBackground(new Color(255, 204, 0));
	    btnIniciarSiguienteJuego.setBounds(976, 739, 210, 50);
	    panelA.add(btnIniciarSiguienteJuego);
		
	}
	
	static void fillJugDestacados() throws ClassNotFoundException, IOException {
		ArrayList<Jugador> jugadores = null;
		Jugador tempJugador = null;
		String tempString = "";
		String[] values;
		switch(indexJugadoresDestacados) {
			case 0:
				jugadores = Conferencia.getInstance().getInstance().topMasPuntos();
				break;
			case 1:
				jugadores = Conferencia.getInstance().getInstance().topMasAsistencias();
				break;
			case 2:
				jugadores = Conferencia.getInstance().getInstance().topMasRebotes();
				break;
		}
		values = new String[jugadores.size()];
		for (int i = 0; i < values.length; i++) {
			tempJugador = jugadores.get(i);
			switch(indexJugadoresDestacados) {
				case 0:
					tempString = tempJugador.getNombre()+" "+tempJugador.getApellido()+" - "+tempJugador.getEstadisticas().getTotalPuntos()+" puntos";
					break;
				case 1:
					tempString = tempJugador.getNombre()+" "+tempJugador.getApellido()+" - "+tempJugador.getEstadisticas().getAsistencias()+" asistencias";
					break;
				case 2:
					tempString = tempJugador.getNombre()+" "+tempJugador.getApellido()+" - "+tempJugador.getEstadisticas().getRebotes()+" rebotes";
					break;
			}
			values[i] = tempString;
		}

	    listJugadoresDestacados.setModel(new AbstractListModel() {
	    	public int getSize() {
	    		return values.length;
	    	}
	    	public Object getElementAt(int index) {
	    		return values[index];
	    	}
	    });
	}
	
	public static void fillJuegosSemana() throws ClassNotFoundException, IOException {
		ArrayList<Juego> juegos = Conferencia.getInstance().getJuegosSemana();
		String[] values = new String[juegos.size()];
		
		for (int i = 0; i < juegos.size(); i++) {
			values[i] = juegos.get(i).getLocal().getiD()+" vs "+juegos.get(i).getVisitante().getiD()+" - "+juegos.get(i).getFecha().toString();
		}
		
		listJuegosDeLaSemana.setModel(new AbstractListModel() {
	    	public int getSize() {
	    		return values.length;
	    	}
	    	public Object getElementAt(int index) {
	    		return values[index];
	    	}
		});
		
	}

	public static void update() throws ClassNotFoundException, IOException {
		lblPuntosEquipoLocal.setText(GameComentary.getPuntajeLocal());
		lblPuntosEquipoVisitante.setText(GameComentary.getPuntajeVisitante());
		if (proximoJuego.isOcurrido()) {
			gameComentary = null;
			btnIniciarSiguienteJuego.setText("Iniciar siguiente juego");
		}
		//ESTAS LINEAS SERAN USADAS CUANDO SE MEJORE EL SISTEMA DE LOGOS
		lblLogoEquipoLocal.setIcon(GameComentary.getLogoLocal());
		lblLogoEquipoVisitante.setIcon(GameComentary.getLogoVisitante());
		
	}
}
