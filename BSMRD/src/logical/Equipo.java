package logical;

import java.util.ArrayList;

public class Equipo {
	private String nombre;
	private  ArrayList<Jugador> misJugadores;
	private String entrenador; 
	private float presupuesto;
	private int juegosGanados; 
	private int juegosPerdidos; 
	private String estadio;
	public Equipo(String nombre, ArrayList<Jugador> misJugadores, String entrenador, float presupuesto,
			int juegosGanados, int juegosPerdidos, String estadio) {
		super();
		this.nombre = nombre;
		this.misJugadores = misJugadores;
		this.entrenador = entrenador;
		this.presupuesto = presupuesto;
		this.juegosGanados = juegosGanados;
		this.juegosPerdidos = juegosPerdidos;
		this.estadio = estadio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Jugador> getMisJugadores() {
		return misJugadores;
	}
	public void setMisJugadores(ArrayList<Jugador> misJugadores) {
		this.misJugadores = misJugadores;
	}
	public String getEntrenador() {
		return entrenador;
	}
	public void setEntrenador(String entrenador) {
		this.entrenador = entrenador;
	}
	public float getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(float presupuesto) {
		this.presupuesto = presupuesto;
	}
	public int getJuegosGanados() {
		return juegosGanados;
	}
	public void setJuegosGanados(int juegosGanados) {
		this.juegosGanados = juegosGanados;
	}
	public int getJuegosPerdidos() {
		return juegosPerdidos;
	}
	public void setJuegosPerdidos(int juegosPerdidos) {
		this.juegosPerdidos = juegosPerdidos;
	}
	public String getEstadio() {
		return estadio;
	}
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	} 
}
