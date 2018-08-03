package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPosition;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.CategoryLabelWidthType;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.text.TextBlockAnchor;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.TextAnchor;

import logical.Conferencia;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class RankingLiga extends JFrame {

	private JPanel contentPane;
	private JLabel lblRanking;
	private JFreeChart chart;

	public RankingLiga() throws ClassNotFoundException, IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		lblRanking = new JLabel("");
		lblRanking.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblRanking, BorderLayout.NORTH);
		
		DefaultCategoryDataset dataset = Conferencia.getInstance().getRanking();
        
        
         chart = ChartFactory.createBarChart3D(
                "Ranking de la liga",
                "Equipo",
                "Estadisticas",
                dataset,
                PlotOrientation.HORIZONTAL,
                true,
                true,
                false
            );

            CategoryPlot plot = chart.getCategoryPlot();
            plot.setForegroundAlpha(1.0f);

            CategoryAxis axis = plot.getDomainAxis();
            CategoryLabelPositions p = axis.getCategoryLabelPositions();
            
            CategoryLabelPosition left = new CategoryLabelPosition(
                RectangleAnchor.LEFT, TextBlockAnchor.CENTER_LEFT, 
                TextAnchor.CENTER_LEFT, 0.0,
                CategoryLabelWidthType.RANGE, 0.30f
            );
            axis.setCategoryLabelPositions(CategoryLabelPositions.replaceLeftPosition(p, left));
          
        int width = 620;    /* Width of the image */
		int height = 320;   /* Height of the image */
		BufferedImage img = chart.createBufferedImage(width, height);
        lblRanking.setIcon(new ImageIcon(img));

		
	}

}
