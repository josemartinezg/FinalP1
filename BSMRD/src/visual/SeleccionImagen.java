package visual;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SeleccionImagen extends JDialog {
	public JFileChooser fileChooser;
	public File file;
	private final JPanel contentPanel = new JPanel();
	public SeleccionImagen() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 641, 481);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			fileChooser = new JFileChooser();
			int result = fileChooser.showOpenDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
				file = fileChooser.getSelectedFile();
				dispose();
			}else if (result == JFileChooser.CANCEL_OPTION) {
				System.out.println("Cancelar se seleccionó");
			}
			//contentPanel.add(fileChooser, BorderLayout.CENTER);
			
		}
	}
}