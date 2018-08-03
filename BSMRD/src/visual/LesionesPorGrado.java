package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import logical.Conferencia;
import logical.FechaSimple;
import logical.Jugador;
import logical.Lesion;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LesionesPorGrado extends JFrame {

	private JPanel contentPane;
	private DefaultPieDataset porciones;
    private JFreeChart torta;
    private JLabel lblTorta;

	public LesionesPorGrado() {
		setResizable(false);
		setBounds(new Rectangle(0, 0, 800, 600));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 677, 399);
		
		porciones = Conferencia.getInstance().getMapLesiones();
        
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 640, 320));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setContentPane(contentPane);
		
		lblTorta = new JLabel();
		lblTorta.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTorta, BorderLayout.NORTH);
		
		PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator("{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
		
        torta = ChartFactory.createPieChart3D("Lesiones por Grado",porciones,true,true,false);
        ((PiePlot) torta.getPlot()).setLabelGenerator(gen);
        BufferedImage graficoTorta = torta.createBufferedImage(contentPane.getWidth(), contentPane.getHeight());        
        lblTorta.setSize(contentPane.getSize());
        
        lblTorta.setIcon(new ImageIcon(graficoTorta));    
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		try {
					ImageIO.write((RenderedImage) graficoTorta,"png" , new File("lesiones_grado.png"));
				} catch (IOException e) {
					System.out.println("Error al guardar grafico.");
				}
        	}
        });
        panel.add(btnGuardar);
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        panel.add(btnSalir);
        contentPane.updateUI();
	}

}
