package logical;

import java.util.Calendar;

public class Lesion {
	private String tipoLesion;
	private int gradoLesion;
	private FechaSimple fechaInicio;
	private int tiempoLesionado;
	private FechaSimple fechaRegreso;
	private String descripcion;
	private boolean activa;
	public Lesion(String tipoLesion, int gradoLesion, FechaSimple fechaInicio, int tiempoLesionado, FechaSimple fechaRegreso,
			String descripcion, boolean activa) {
		super();
		this.tipoLesion = tipoLesion;
		this.gradoLesion = gradoLesion;
		this.fechaInicio = fechaInicio;
		this.tiempoLesionado = tiempoLesionado;
		this.fechaRegreso = fechaRegreso;
		this.descripcion = descripcion;
		this.activa = activa;
	}
	public String getTipoLesion() {
		return tipoLesion;
	}
	public void setTipoLesion(String tipoLesion) {
		this.tipoLesion = tipoLesion;
	}
	public int getGradoLesion() {
		return gradoLesion;
	}
	public void setGradoLesion(int gradoLesion) {
		this.gradoLesion = gradoLesion;
	}
	public FechaSimple getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(FechaSimple fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public int getTiempoLesionado() {
		return tiempoLesionado;
	}
	public void setTiempoLesionado(int tiempoLesionado) {
		this.tiempoLesionado = tiempoLesionado;
	}
	public FechaSimple getFechaRegreso() {
		return fechaRegreso;
	}
	public void setFechaRegreso(FechaSimple fechaRegreso) {
		this.fechaRegreso = fechaRegreso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isActiva() {
		return activa;
	}
	public void setActiva(boolean activa) {
		this.activa = activa;
	}
}
