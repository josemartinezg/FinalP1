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
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class BSM extends JFrame {

	/**
	 * @wbp.nonvisual location=150,99
	 */
	private final JPanel panelA = new JPanel();
	private GameComentary gameComentary=null;
	private RegistroJugadores registroJugadores=null;
	private JMenuItem mntmRegistrarEquipo;
	private JMenuItem mntmListarEquipo;
	private JMenuItem mntmRegistrarJugador;
	private JMenuItem mntmListarJugador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BSM frame = new BSM();
					frame.setVisible(true);
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
	    
	    panelA.setBounds(100, 100, 1280, 800);
	    panelA.setOpaque(false);
	    getContentPane().add(panelA);
	    panelA.setLayout(null);
	    
	    JButton btnClose = new JButton("Salir");
	    btnClose.setFont(new Font("Tahoma", Font.BOLD, 15));
	    btnClose.setBounds(1190, 739, 80, 50);
	    btnClose.setBackground(new Color(255, 204, 0));
	    btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
	    });
	    panelA.add(btnClose);
	    
	    JButton btnIniciarSiguienteJuego = new JButton("Iniciar siguiente juego");
	    btnIniciarSiguienteJuego.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if (gameComentary == null) {
		    		gameComentary = new GameComentary(10);
		    		btnIniciarSiguienteJuego.setText("Ver juego en curso");
	    		}
		    	gameComentary.setVisible(true);
	    	}
	    });
	    btnIniciarSiguienteJuego.setFont(new Font("Tahoma", Font.BOLD, 15));
	    btnIniciarSiguienteJuego.setBackground(new Color(255, 204, 0));
	    btnIniciarSiguienteJuego.setBounds(976, 739, 210, 50);
	    panelA.add(btnIniciarSiguienteJuego);
	    
	    JButton btnResultados = new JButton("Resultados");
	    btnResultados.setBackground(new Color(255, 204, 0));
	    btnResultados.setForeground(new Color(255, 255, 255));
	    btnResultados.setFont(new Font("Lucida Bright", Font.BOLD, 34));
	    btnResultados.setBounds(1000, 0, 280, 120);
	    btnResultados.setOpaque(false);
	    btnResultados.setContentAreaFilled(false);
	    btnResultados.setBorderPainted(false);
	    panelA.add(btnResultados);
	    
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
	    btnJugadores.setBounds(720, 0, 280, 120);
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
	    btnEquipos.setBounds(442, 0, 280, 120);
	    panelA.add(btnEquipos);
	    
	    JLabel lblVs = new JLabel("VS");
	    lblVs.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
	    lblVs.setHorizontalAlignment(SwingConstants.CENTER);
	    lblVs.setForeground(new Color(255, 255, 255));
	    lblVs.setBounds(824, 379, 63, 48);
	    panelA.add(lblVs);
	    
	    JLabel lblVersusball = new JLabel(new ImageIcon(BSM.class.getResource("/thumb/versus-ball.png")));
	    lblVersusball.setBounds(799, 341, 120, 120);
	    panelA.add(lblVersusball);
	    
	    JLabel lblPuntosEquipo1 = new JLabel("72");
	    lblPuntosEquipo1.setForeground(new Color(255, 255, 255));
	    lblPuntosEquipo1.setFont(new Font("SimSun", Font.BOLD, 48));
	    lblPuntosEquipo1.setHorizontalAlignment(SwingConstants.CENTER);
	    lblPuntosEquipo1.setBounds(483, 525, 249, 55);
	    panelA.add(lblPuntosEquipo1);
	    
	    JLabel lblPuntosEquipo2 = new JLabel("90");
	    lblPuntosEquipo2.setForeground(new Color(255, 255, 255));
	    lblPuntosEquipo2.setHorizontalAlignment(SwingConstants.CENTER);
	    lblPuntosEquipo2.setFont(new Font("SimSun", Font.BOLD, 48));
	    lblPuntosEquipo2.setBounds(981, 512, 249, 80);
	    panelA.add(lblPuntosEquipo2);
	    
	    JLabel lblLogoequipo1 = new JLabel(new ImageIcon(BSM.class.getResource("/thumb/houston-rockets.png")));
	    lblLogoequipo1.setBounds(486, 279, 233, 221);
	    panelA.add(lblLogoequipo1);
	    
	    JLabel lblLogoEquipo2 = new JLabel(new ImageIcon(BSM.class.getResource("/thumb/boston-celtics.png")));
	    lblLogoEquipo2.setBounds(997, 279, 233, 221);
	    panelA.add(lblLogoEquipo2);
	    
	    JButton btnJuegosDeLa = new JButton("Juegos de la semana");
	    btnJuegosDeLa.setForeground(Color.BLACK);
	    btnJuegosDeLa.setFont(headerListFont.deriveFont(Font.BOLD, 34));
	    btnJuegosDeLa.setBorderPainted(false);
	    btnJuegosDeLa.setBackground(new Color(255, 204, 0));
	    btnJuegosDeLa.setBounds(0, 0, 407, 120);
	    panelA.add(btnJuegosDeLa);
	    
	    JList listJuegosDeLaSemana = new JList();
	    listJuegosDeLaSemana.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    listJuegosDeLaSemana.setModel(new AbstractListModel() {
	    	String[] values = new String[] {"Equipo1 vs. Equipo2 - 28/07/2018", "Equipo3 vs. Equipo4 - 31/07/2018", "Equipo6 vs. Equipo5 - 2/08/2018"};
	    	public int getSize() {
	    		return values.length;
	    	}
	    	public Object getElementAt(int index) {
	    		return values[index];
	    	}
	    });
	    listJuegosDeLaSemana.setBounds(0, 118, 407, 361);
	    listJuegosDeLaSemana.setForeground(Color.BLACK);
	    listJuegosDeLaSemana.setFont(listFont.deriveFont(Font.ITALIC, 20));
	    listJuegosDeLaSemana.setBackground(new Color(255, 255, 204));
	    panelA.add(listJuegosDeLaSemana);
	    
	    JButton btnJugadoresDestacados = new JButton("Jugadores destacados");
	    btnJugadoresDestacados.setForeground(Color.BLACK);
	    btnJugadoresDestacados.setFont(headerListFont.deriveFont(Font.BOLD, 34));
	    btnJugadoresDestacados.setBorderPainted(false);
	    btnJugadoresDestacados.setBackground(new Color(255, 204, 0));
	    btnJugadoresDestacados.setBounds(0, 479, 407, 120);
	    panelA.add(btnJugadoresDestacados);
	    
	    JList listJuegosDestacados = new JList();
	    listJuegosDestacados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    listJuegosDestacados.setModel(new AbstractListModel() {
	    	String[] values = new String[] {"Jugador1 - 520 puntos", "Jugador2 - 313 asistencias", "Jugador3 - 140 triples"};
	    	public int getSize() {
	    		return values.length;
	    	}
	    	public Object getElementAt(int index) {
	    		return values[index];
	    	}
	    });
	    listJuegosDestacados.setForeground(Color.BLACK);
	    listJuegosDestacados.setFont(listFont.deriveFont(Font.ITALIC, 20));
	    listJuegosDestacados.setBackground(new Color(255, 255, 204));
	    listJuegosDestacados.setBounds(0, 598, 407, 202);
	    panelA.add(listJuegosDestacados);
	    
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
	    mntmRegistrarEquipo.setBounds(408, 118, 302, 79);
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
	    mntmListarEquipo.setBounds(408, 190, 302, 79);
	    mntmListarEquipo.setVisible(false);
	    panelA.add(mntmListarEquipo);
	    
	    mntmRegistrarJugador = new JMenuItem("Registrar jugador");
	    mntmRegistrarJugador.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(registroJugadores==null) {
	    			registroJugadores = new RegistroJugadores(null);
	    		}
	    		registroJugadores.setVisible(true);
	    	}
	    });
	    mntmRegistrarJugador.setForeground(new Color(255, 255, 255));
	    mntmRegistrarJugador.setFont(new Font("Segoe UI", Font.BOLD, 20));
	    mntmRegistrarJugador.setOpaque(false);
	    mntmRegistrarJugador.setContentAreaFilled(false);
	    mntmRegistrarJugador.setBorderPainted(false);
	    mntmRegistrarJugador.setBounds(720, 118, 302, 79);
	    mntmRegistrarJugador.setVisible(false);
	    panelA.add(mntmRegistrarJugador);
	    
	    mntmListarJugador = new JMenuItem("Listar jugadores");
	    mntmListarJugador.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		VerJugadores verJugadores = new VerJugadores();
	    		verJugadores.setVisible(true);
	    	}
	    });
	    mntmListarJugador.setForeground(new Color(255, 255, 255));
	    mntmListarJugador.setFont(new Font("Segoe UI", Font.BOLD, 20));
	    mntmListarJugador.setOpaque(false);
	    mntmListarJugador.setContentAreaFilled(false);
	    mntmListarJugador.setBorderPainted(false);
	    mntmListarJugador.setBounds(720, 190, 302, 79);
	    mntmListarJugador.setVisible(false);
	    panelA.add(mntmListarJugador);
	}
}
