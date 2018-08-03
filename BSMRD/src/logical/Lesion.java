package logical;

import java.io.Serializable;

public class Lesion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1931014929479886626L;
	private String tipoLesion;
	private int gradoLesion;
	private FechaSimple fechaInicio;
	private String tiempoLesionado;
	private FechaSimple fechaRegreso;
	private String descripcion;
	private boolean activa;
	public Lesion(String tipoLesion, int gradoLesion, FechaSimple fechaInicio, String tiempoLesionado, FechaSimple fechaRegreso,
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
	public String getTiempoLesionado() {
		return tiempoLesionado;
	}
	public void setTiempoLesionado(String tiempoLesionado) {
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
