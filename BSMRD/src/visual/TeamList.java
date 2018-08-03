package visual;

import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

import logical.Equipo;
import logical.Jugador;

public class TeamList {
	private final Map<String, ImageIcon> imageMap;
	private JList list;
	private String[] nameListArr;
	private Equipo equipo;
	
	public TeamList(Equipo equipo) {
		this.equipo = equipo;
		imageMap = createImageMap(equipo);
		ArrayList<String> nameList = new ArrayList<String>();
		for (Jugador j : equipo.getJugadores()) {
			nameList.add(j.getNombre());
		}
		nameListArr = new String[nameList.size()];
		nameListArr = nameList.toArray(nameListArr);
		
		list = new JList(nameListArr);
		list.setCellRenderer(new TeamListRenderer());
	}
	
	public class TeamListRenderer extends DefaultListCellRenderer {

        Font font = new Font("helvitica", Font.BOLD, 24);

        @Override
        public Component getListCellRendererComponent(
                JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {

            JLabel label = (JLabel) super.getListCellRendererComponent(
                    list, value, index, isSelected, cellHasFocus);
            label.setIcon(imageMap.get((String) value));
            label.setHorizontalTextPosition(JLabel.RIGHT);
            label.setFont(font);
            return label;
        }
    }
	
	private Map<String, ImageIcon> createImageMap(Equipo equipo) {
        Map<String, ImageIcon> map = new HashMap<>();
        for (Jugador j : equipo.getJugadores()) {
            map.put(j.getNombre(), j.getFotoPersonal());
        }
        return map;
    }
	
	public JList getList() {
		return this.list;
	}
	
	public Jugador getSelectedPlayer() {
		return equipo.getJugadores().get(this.list.getSelectedIndex());
	}
}
