package logical;

import javax.swing.ImageIcon;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Estadistica estadisticas = new Estadistica(0, 0, 0, 0, 0, 0, 0, 0, 0);
//		Lesion lesion = new Lesion("mala", 10, Calendar.getInstance(), 20, Calendar.getInstance(), "una vaina feisima", true);
//		Jugador jugador = new Jugador("juan", "jose", "123", Calendar.getInstance(), 152, "america", false, estadisticas);
		FechaSimple fecha1 = new FechaSimple(17, 07, 2018), fecha2 = FechaSimple.getInstance();
		System.out.println(fecha1.isEqual(fecha2));
	}

}
