package logical;

import java.io.Serializable;

public class Juego implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2399864853701574515L;
	private String estadio;
	private Equipo local;
	private Equipo visitante; 
	private FechaSimple fecha;
	private Marcador marcador;
	private boolean ocurrido;
	public Juego(String estadio, Equipo local, Equipo visitante, FechaSimple fecha) {
		super();
		this.estadio = estadio;
		this.local = local;
		this.visitante = visitante;
		this.fecha = fecha;
		this.marcador = new Marcador();
		this.ocurrido = false;
	}
	public String getEstadio() {
		return estadio;
	}
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	public Equipo getLocal() {
		return local;
	}
	public void setLocal(Equipo local) {
		this.local = local;
	}
	public Equipo getVisitante() {
		return visitante;
	}
	public void setVisitante(Equipo visitante) {
		this.visitante = visitante;
	}
	public FechaSimple getFecha() {
		return fecha;
	}
	public void setFecha(FechaSimple fecha) {
		this.fecha = fecha;
	}
	public Marcador getMarcador() {
		return marcador;
	}
	public void setMarcador(Marcador marcador) {
		this.marcador = marcador;
	}
	public boolean isOcurrido() {
		return ocurrido;
	}
	public void setOcurrido(boolean ocurrido) {
		this.ocurrido = ocurrido;
	}
}
