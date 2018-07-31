package logical;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Equipo {
	private String nombre;
	private  ArrayList<Jugador> jugadores;
	private String entrenador; 
	private float presupuesto;
	private int juegosGanados; 
	private int juegosPerdidos; 
	private String estadio;
	private String iD;
	private ImageIcon logo;
	public Equipo(String nombre, String entrenador, float presupuesto, String estadio, String iD) {
		super();
		this.nombre = nombre;
		this.estadio = estadio;
		this.entrenador = entrenador;
		this.presupuesto = presupuesto;
		this.jugadores = new ArrayList<>();
		this.iD = iD;
		this.juegosGanados = 0;
		this.juegosPerdidos = 0;
	}
	public Equipo(String nombre, ArrayList<Jugador> misJugadores, String entrenador, float presupuesto,
			int juegosGanados, int juegosPerdidos, String estadio) {
		super();
		this.nombre = nombre;
		this.jugadores = misJugadores;
		this.entrenador = entrenador;
		this.presupuesto = presupuesto;
		this.juegosGanados = juegosGanados;
		this.juegosPerdidos = juegosPerdidos;
		this.estadio = estadio;
	}
	public Equipo(String nombre, String entrenador, String estadio) {
		super();
		this.nombre = nombre;
		this.jugadores = new ArrayList<>();
		this.entrenador = entrenador;
		this.presupuesto = 0;
		this.juegosGanados = 0;
		this.juegosPerdidos = 0;
		this.estadio = estadio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
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
	public void addJugador(Jugador jugador) {
		this.jugadores.add(jugador);
	}
	public ImageIcon getLogo() {
		return logo;
	}
	public void setLogo(ImageIcon logo) {
		this.logo = logo;
	}
	public String getiD() {
		return iD;
	}
	public void setiD(String iD) {
		this.iD = iD;
	}
}
