package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import logical.Conferencia;
import logical.Jugador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerEstadisticas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtEquipo;
	private JTextField txtNumero;
	private JTextField txtEdad;
	private JTextField txtEstatura;
	private JTextField txtPeso;
	private JTextField txtTotalPuntos;
	private JTextField txtTotalRebotes;
	private JTextField txtTotalAsistencias;
	private JTextField txtAPJ;
	private JTextField txtRPJ;
	private JTextField txtPPJ;
	private JTextField txtPTT;
	private JTextField txtPTC;
	private JTextField txtPTL;
	private Jugador jugador;
	private int asistencias;
	private int puntos;
	private int rebotes;
	private int juegosJugados;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VerEstadisticas dialog = new VerEstadisticas(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VerEstadisticas(Jugador jugador) {
		this.jugador = jugador;
		asistencias = jugador.getEstadisticas().getAsistencias();
		puntos = jugador.getEstadisticas().getTotalPuntos();
		rebotes = jugador.getEstadisticas().getRebotes();
		setTitle("Estad\u00EDsticas del Jugador");
		setBounds(100, 100, 512, 635);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("Cargar Foto");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 31));
		label.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), Color.GRAY, null, null));
		label.setBounds(12, 13, 220, 219);
		contentPanel.add(label);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setBounds(259, 70, 56, 16);
		contentPanel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setText(jugador.getNombre() + ' ' + jugador.getApellido());
		txtNombre.setBounds(259, 90, 223, 22);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumero.setBounds(259, 125, 56, 16);
		contentPanel.add(lblNumero);
		
		JLabel lblEstatura = new JLabel("Estatura:");
		lblEstatura.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEstatura.setBounds(259, 178, 71, 16);
		contentPanel.add(lblEstatura);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEdad.setBounds(382, 121, 71, 16);
		contentPanel.add(lblEdad);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPeso.setBounds(382, 178, 71, 16);
		contentPanel.add(lblPeso);
		
		JLabel lblTotalDePuntos = new JLabel("Total de puntos:");
		lblTotalDePuntos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotalDePuntos.setBounds(12, 270, 106, 16);
		contentPanel.add(lblTotalDePuntos);
		
		JLabel lblTotalDeRebotes = new JLabel("Total de rebotes:");
		lblTotalDeRebotes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotalDeRebotes.setBounds(171, 270, 120, 16);
		contentPanel.add(lblTotalDeRebotes);
		
		JLabel lblTotalDeAsistencia = new JLabel("Total de asistencias:");
		lblTotalDeAsistencia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotalDeAsistencia.setBounds(334, 270, 136, 16);
		contentPanel.add(lblTotalDeAsistencia);
		
		JLabel lblPuntosPorJuego = new JLabel("Puntos por Juego:");
		lblPuntosPorJuego.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPuntosPorJuego.setBounds(12, 350, 120, 16);
		contentPanel.add(lblPuntosPorJuego);
		
		JLabel lblRebotesPorJuego = new JLabel("Rebotes por Juego:");
		lblRebotesPorJuego.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRebotesPorJuego.setBounds(171, 350, 135, 16);
		contentPanel.add(lblRebotesPorJuego);
		
		JLabel lblAsistenciasPorJuego = new JLabel("Asistencias por Juego:");
		lblAsistenciasPorJuego.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAsistenciasPorJuego.setBounds(334, 350, 148, 16);
		contentPanel.add(lblAsistenciasPorJuego);
		
		JLabel lblTirosLibres = new JLabel("%Tiros Libres:");
		lblTirosLibres.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTirosLibres.setBounds(12, 428, 120, 16);
		contentPanel.add(lblTirosLibres);
		
		JLabel lblTirosDeCampo = new JLabel("%Tiros de Campo:");
		lblTirosDeCampo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTirosDeCampo.setBounds(171, 428, 120, 16);
		contentPanel.add(lblTirosDeCampo);
		
		JLabel lblTirosDeTres = new JLabel("%Tiros de Tres:");
		lblTirosDeTres.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTirosDeTres.setBounds(334, 428, 120, 16);
		contentPanel.add(lblTirosDeTres);
		
		JLabel lblEquipo = new JLabel("Equipo:");
		lblEquipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEquipo.setBounds(259, 13, 56, 16);
		contentPanel.add(lblEquipo);
		
		txtEquipo = new JTextField();
		txtEquipo.setEditable(false);
		txtEquipo.setText(jugador.getEquipo());
		txtEquipo.setColumns(10);
		txtEquipo.setBounds(259, 35, 223, 22);
		contentPanel.add(txtEquipo);
		
		txtNumero = new JTextField();
		txtNumero.setEditable(false);
		txtNumero.setText(String.valueOf(jugador.getNumeroCamiseta()));
		txtNumero.setColumns(10);
		txtNumero.setBounds(259, 143, 100, 22);
		contentPanel.add(txtNumero);
		
		txtEdad = new JTextField();
		txtEdad.setEditable(false);
		txtEdad.setText(String.valueOf(jugador.calcularEdad()));
		txtEdad.setColumns(10);
		txtEdad.setBounds(382, 143, 100, 22);
		contentPanel.add(txtEdad);
		
		txtEstatura = new JTextField();
		txtEstatura.setEditable(false);
		txtEstatura.setText(String.valueOf(jugador.getEstatura()));
		txtEstatura.setColumns(10);
		txtEstatura.setBounds(259, 198, 100, 22);
		contentPanel.add(txtEstatura);
		
		txtPeso = new JTextField();
		txtPeso.setEditable(false);
		txtPeso.setText(String.valueOf(jugador.getPeso()));
		txtPeso.setColumns(10);
		txtPeso.setBounds(382, 198, 100, 22);
		contentPanel.add(txtPeso);
		
		txtTotalPuntos = new JTextField();
		txtTotalPuntos.setEditable(false);
		txtTotalPuntos.setText(String.valueOf(jugador.getEstadisticas().getTotalPuntos()));
		txtTotalPuntos.setColumns(10);
		txtTotalPuntos.setBounds(12, 299, 100, 22);
		contentPanel.add(txtTotalPuntos);
		
		txtTotalRebotes = new JTextField();
		txtTotalRebotes.setEditable(false);
		txtTotalRebotes.setText(String.valueOf(jugador.getEstadisticas().getRebotes()));
		txtTotalRebotes.setColumns(10);
		txtTotalRebotes.setBounds(171, 299, 100, 22);
		contentPanel.add(txtTotalRebotes);
		
		txtTotalAsistencias = new JTextField();
		txtTotalAsistencias.setEditable(false);
		txtTotalAsistencias.setText(String.valueOf(jugador.getEstadisticas().getAsistencias()));
		txtTotalAsistencias.setColumns(10);
		txtTotalAsistencias.setBounds(334, 299, 100, 22);
		contentPanel.add(txtTotalAsistencias);
		
		txtAPJ = new JTextField();
		txtAPJ.setEditable(false);
	//	txtAPJ.setText(String.valueOf(jugador.getEstadisticas().calcAnotacionesPorJuego(asistencias)));
		txtAPJ.setColumns(10);
		txtAPJ.setBounds(334, 379, 100, 22);
		contentPanel.add(txtAPJ);
		
		txtRPJ = new JTextField();
		txtRPJ.setEditable(false);
	//	txtRPJ.setText(String.valueOf(jugador.getEstadisticas().calcAnotacionesPorJuego(rebotes)));
		txtRPJ.setColumns(10);
		txtRPJ.setBounds(171, 379, 100, 22);
		contentPanel.add(txtRPJ);
		
		txtPPJ = new JTextField();
		txtPPJ.setEditable(false);
	//	txtPPJ.setText(String.valueOf(jugador.getEstadisticas().calcAnotacionesPorJuego(puntos)));
		txtPPJ.setColumns(10);
		txtPPJ.setBounds(12, 379, 100, 22);
		contentPanel.add(txtPPJ);
		
		txtPTT = new JTextField();
		txtPTT.setEditable(false);
		//Ajustar método
		txtPTT.setText(String.valueOf(jugador.getEstadisticas().puntosPorJuego()));
		txtPTT.setColumns(10);
		txtPTT.setBounds(334, 457, 100, 22);
		contentPanel.add(txtPTT);
		
		txtPTC = new JTextField();
		txtPTC.setEditable(false);
		//Ajustar Método
		txtPTC.setText(String.valueOf(jugador.getEstadisticas().puntosPorJuego()));
		txtPTC.setColumns(10);
		txtPTC.setBounds(171, 457, 100, 22);
		contentPanel.add(txtPTC);
		
		txtPTL = new JTextField();
		txtPTL.setEditable(false);
		//Ajustar Método
		txtPTL.setText(String.valueOf(jugador.getEstadisticas().puntosPorJuego()));
		txtPTL.setColumns(10);
		txtPTL.setBounds(12, 457, 100, 22);
		contentPanel.add(txtPTL);
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

}
