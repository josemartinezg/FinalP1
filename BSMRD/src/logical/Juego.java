package logical;

public class Juego {
	private String estadio;
	private Equipo local;
	private Equipo visitante; 
	private FechaSimple fecha;
	private Marcador marcador;
	public Juego(String estadio, Equipo local, Equipo visitante, FechaSimple fecha, Marcador marcador) {
		super();
		this.estadio = estadio;
		this.local = local;
		this.visitante = visitante;
		this.fecha = fecha;
		this.marcador = marcador;
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
}
