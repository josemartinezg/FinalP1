package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import logical.Conferencia;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class TopFivePorcentajeTiro extends JFrame {

	private JPanel contentPane;
	private JLabel lblBarra;
	
	public TopFivePorcentajeTiro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		lblBarra = new JLabel("");
		lblBarra.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblBarra, BorderLayout.WEST);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);


		DefaultCategoryDataset dataset = Conferencia.getInstance().getMapTopFive();
		
		
		JFreeChart barChart = ChartFactory.createBarChart("Top 5 Jugadores", "Categoría", "Puntajes", dataset, PlotOrientation.VERTICAL, true, true, false);
		     
		int width = 640;    /* Width of the image */
		int height = 480;   /* Height of the image */
		
		BufferedImage graficoBarra = barChart.createBufferedImage(width, height);        
        lblBarra.setSize(contentPane.getSize());
        
        lblBarra.setIcon(new ImageIcon(graficoBarra));
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ImageIO.write((RenderedImage) graficoBarra,"png" , new File("top_five_players.png"));
				} catch (IOException e1) {
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
	}

}
