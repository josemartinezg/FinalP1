package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;

public class SeleccionImagen extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public SeleccionImagen() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		setBounds(100, 100, 641, 481);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JFileChooser fileChooser = new JFileChooser();
			contentPanel.add(fileChooser, BorderLayout.CENTER);
		}
	}

}
