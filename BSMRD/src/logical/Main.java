package logical;

import java.io.IOException;

import javax.swing.ImageIcon;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
//		Estadistica estadisticas = new Estadistica(0, 0, 0, 0, 0, 0, 0, 0, 0);
//		Lesion lesion = new Lesion("mala", 10, Calendar.getInstance(), 20, Calendar.getInstance(), "una vaina feisima", true);
//		Jugador jugador = new Jugador("juan", "jose", "123", Calendar.getInstance(), 152, "america", false, estadisticas);
//		FechaSimple fecha1 = new FechaSimple(17, 07, 2018), fecha2 = FechaSimple.getInstance();
//		System.out.println(fecha1.isEqual(fecha2));
		
//		System.out.println(new FechaSimple(6, 8, 2018).daysLeft());
		
		// Testing: Get Proximo Juego
		System.out.println("======== Probando Get Proximo Juego ============");
		Juego j7 = new Juego("Estadio 7", null, null, new FechaSimple(30, 7, 2020));
		Juego j6 = new Juego("Estadio 6", null, null, new FechaSimple(25, 7, 2019));
		Juego j5 = new Juego("Estadio 5", null, null, new FechaSimple(2, 9, 2018));
		Juego j4 = new Juego("Estadio 4", null, null, new FechaSimple(1, 8, 2018));
		Juego j1 = new Juego("Estadio 1", null, null, new FechaSimple(30, 7, 2018));
		Juego j2 = new Juego("Estadio 2", null, null, new FechaSimple(26, 7, 2018));
		Juego j3 = new Juego("Estadio 3", null, null, new FechaSimple(28, 7, 2018));
		
		j2.setOcurrido(true);
		
		Conferencia conf = Conferencia.getInstance();
		conf.insertJuego(j1);
		conf.insertJuego(j2);
		conf.insertJuego(j3);
		conf.insertJuego(j4);
		conf.insertJuego(j5);
		conf.insertJuego(j6);
		conf.insertJuego(j7);
//		
		System.out.println("La fecha del proximo juego es: " + conf.getProximoJuego().getFecha());
		System.out.println("El estadio del proximo juego es: " + conf.getProximoJuego().getEstadio());
		
		System.out.println("======== Probando Get Proximo Juego ============");
		// End Testing: Get Proximo Juego;
		
		// Testing: Get Juegos de La semana.
		System.out.println("\n\n======== Probando Get Juegos de la semana ============");
		for (Juego jg : conf.getJuegosSemana()) {
			System.out.println(jg.getFecha());
		}
		System.out.println("======== Probando Get Juegos de la semana ============");
	}

}
