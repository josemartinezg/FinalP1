package logical;

import java.util.ArrayList;

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

	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}
	
	public void insertJuego(Juego juego) {
		this.juegos.add(juego);
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
	public ArrayList<Jugador> getMisJugadores() {
		return misJugadores;
	}
	public void setMisJugadores(ArrayList<Jugador> misJugadores) {
		this.misJugadores = misJugadores;
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
		boolean found = false;
		int ind = 0;
		for (Jugador jugador : misJugadores){ 
			if (jugador.getiD().equalsIgnoreCase(iD)) 
				aux = jugador;
		}
		return aux;
	}

	public Equipo buscarEquipos(String iD) {
		Equipo aux = null;
		boolean found = false;
		int ind = 0;
		for (Equipo equipo : equipos){ 
			if (equipo.getiD().equalsIgnoreCase(iD)) 
				aux = equipo;
		}
		return aux;
	}

}

