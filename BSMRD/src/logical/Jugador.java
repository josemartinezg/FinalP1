package logical;

import java.util.ArrayList;

public class Jugador {
	private String nombre; 
	private String apellido;
	private String iD;
	private FechaSimple fechaNacimiento;
	private float salarioAnual;
	private String ligaProveniente;
	private boolean lesionado;
	private ArrayList<Lesion> misLesiones;
	private Estadistica estadisticas;
	
	public Jugador(String nombre, String apellido, String iD, FechaSimple fechaNacimiento, float salarioAnual,
			String ligaProveniente, boolean lesionado, Estadistica estadisticas) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.iD = iD;
		this.fechaNacimiento = fechaNacimiento;
		this.salarioAnual = salarioAnual;
		this.ligaProveniente = ligaProveniente;
		this.lesionado = lesionado;
		this.estadisticas = estadisticas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getiD() {
		return iD;
	}
	public void setiD(String iD) {
		this.iD = iD;
	}
	public FechaSimple getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(FechaSimple fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public float getSalarioAnual() {
		return salarioAnual;
	}
	public void setSalarioAnual(float salarioAnual) {
		this.salarioAnual = salarioAnual;
	}
	public String getLigaProveniente() {
		return ligaProveniente;
	}
	public void setLigaProveniente(String ligaProveniente) {
		this.ligaProveniente = ligaProveniente;
	}
	public boolean isLesionado() {
		return lesionado;
	}
	public void setLesionado(boolean lesionado) {
		this.lesionado = lesionado;
	}
	public ArrayList<Lesion> getMisLesiones() {
		return misLesiones;
	}
	public void agregarLesion(Lesion lesion) {
		if(lesion.isActiva()) {
			this.lesionado = true;
		}
		this.misLesiones.add(lesion);
	}
	public void revisionEstado() {
		for(Lesion lesion : misLesiones) {
			if(lesion.getFechaRegreso().isEqual(FechaSimple.getInstance())) {
				this.lesionado = false;
			}
		}
	}
	public Estadistica getEstadisticas() {
		return estadisticas;
	}
	public void setEstadisticas(Estadistica estadisticas) {
		this.estadisticas = estadisticas;
	}
}
