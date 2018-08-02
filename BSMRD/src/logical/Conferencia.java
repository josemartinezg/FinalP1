package logical;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Conferencia {
	private ArrayList<Juego> juegos;
	private ArrayList<Jugador> misJugadores;
	private ArrayList<Equipo> equipos;
	private static Conferencia conf = null;
	
	private Conferencia() {
		super();
		this.juegos = new ArrayList<Juego>();
		this.misJugadores = new ArrayList<>();
		this.equipos = new ArrayList<Equipo>();
	}

	public ArrayList<Juego> getJuegos() {
		return juegos;
	}
	
	public ArrayList<Juego> getJuegos(FechaSimple fecha, boolean ocurrido) {
		ArrayList<Juego> aux = new ArrayList<Juego>();
		for (Juego jg : juegos) {
			FechaSimple fechaJuego = jg.getFecha();
			if (fechaJuego.isEqual(fecha)) {
				aux.add(jg);
			}
		}
		return aux;
	}
	
	public ArrayList<Juego> getJuegos(int rangoDeDias) {
		ArrayList<Juego> aux = new ArrayList<Juego>();
		for (Juego jg : juegos) {
			FechaSimple fechaJuego = jg.getFecha();
			if (fechaJuego.daysLeft() <= rangoDeDias && !jg.isOcurrido()) {
				aux.add(jg);
			}
		}
		return aux;
	}

	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}
	
	public void insertJuego(Juego juego) {
		this.juegos.add(juego);
		Collections.sort(juegos, new Comparator() {
			public int compare(Object j1, Object j2) {
				FechaSimple f1 = ( (Juego) j1).getFecha();
				FechaSimple f2 = ( (Juego) j2 ).getFecha();
				
				Integer year1 = f1.getYear();
				Integer year2 = f2.getYear();
				int yComp = year1.compareTo(year2);
				
				if (yComp != 0) return yComp;
				
				Integer month1 = f1.getMonth();
				Integer month2 = f2.getMonth();
				int mComp = month1.compareTo(month2);
				
				if (mComp != 0) return mComp;
				
				Integer day1 = f1.getDay();
				Integer day2 = f2.getDay();
				
				return day1.compareTo(day2);
			}
		});
	}
	
	public void insertEquipo(Equipo equipo) {
		this.equipos.add(equipo);
	}
	
	public void removeJuego(Juego juego) {
		this.juegos.remove(juego);
	}
	
	public void removeEquipo(Equipo equipo) {
		this.equipos.remove(equipo);
	}
	
	public static Conferencia getInstance() {
		if (conf == null) {
			conf = new Conferencia();
		}
		return conf;
	}
	
	public ArrayList<Juego> getJuegosDelDia() {
		return this.getJuegos(FechaSimple.getInstance(), false);

	}
	
	public ArrayList<Juego> getJuegosSemana() {
		return this.getJuegos(7);
	}
	public ArrayList<Jugador> getMisJugadores() {
		return misJugadores;
	}
	public void setMisJugadores(ArrayList<Jugador> misJugadores) {
		this.misJugadores = misJugadores;
	}
	
	public Juego getProximoJuego() {
		int i = 0;
		boolean encontrado = false;
		Juego aux = null;
		while(!encontrado && i < juegos.size()) {
			aux = juegos.get(i);
			if (!aux.isOcurrido()) encontrado = true;
			else i++;
		}
		return aux;
	}
	
	public ArrayList<Jugador> topMasPuntos() {
		ArrayList<Jugador> aux = misJugadores;
		Collections.sort(aux, new Comparator() {
			public int compare(Object j1, Object j2) {
				Integer puntos1 = ((Jugador) j1).getEstadisticas().getTotalPuntos();
				Integer puntos2 = ((Jugador) j2).getEstadisticas().getTotalPuntos();
				return puntos1.compareTo(puntos2);
			}
		});
		return aux;
	}
	
	public ArrayList<Jugador> topMasAsistencias() {
		ArrayList<Jugador> aux = misJugadores;
		Collections.sort(aux, new Comparator() {
			public int compare(Object j1, Object j2) {
				Integer asist1 = ((Jugador) j1).getEstadisticas().getAsistencias();
				Integer asist2 = ((Jugador) j2).getEstadisticas().getAsistencias();
				return asist1.compareTo(asist2);
			}
		});
		return aux;
	}
	
	public ArrayList<Jugador> topMasRebotes() {
		ArrayList<Jugador> aux = misJugadores;
		Collections.sort(aux, new Comparator() {
			public int compare(Object j1, Object j2) {
				Integer rebotes1 = ((Jugador) j1).getEstadisticas().getRebotes();
				Integer rebotes2 = ((Jugador) j2).getEstadisticas().getRebotes();
				return rebotes1.compareTo(rebotes2);
			}
		});
		return aux;
	}
	
	public Jugador jugadorMasPuntos() {
		return topMasPuntos().get(0);
	}
	
	public Jugador jugadorMasAsistencias() {
		return topMasAsistencias().get(0);
	}
	
	public Jugador jugadorMasRebotes() {
		return topMasRebotes().get(0);
	}

	public void modficarJugador(Jugador jugador) {
		int ind = misJugadores.indexOf(jugador);
		misJugadores.set(ind, jugador);
	}
	public void addJugador(Jugador nuevoJugador) {
		misJugadores.add(nuevoJugador);
	}

	public Jugador buscarJugadores(String iD) {
		Jugador aux = null;
		for (Jugador jugador : misJugadores){ 
			if (jugador.getiD().equalsIgnoreCase(iD)) 
				aux = jugador;
		}
		return aux;
	}

	public Equipo buscarEquipos(String iD) {
		Equipo aux = null;
		for (Equipo equipo : equipos){ 
			if (equipo.getiD().equalsIgnoreCase(iD)) 
				aux = equipo;
		}
		return aux;
	}

}

