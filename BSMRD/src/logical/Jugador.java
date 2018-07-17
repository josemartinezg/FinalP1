package logical;

import java.util.ArrayList;
import java.util.Calendar;

public class Jugador {
	private String nombre; 
	private String apellido;
	private String iD;
	private Calendar fechaNacimiento;
	private float salarioAnual;
	private String ligaProveniente;
	private boolean lesionado;
	ArrayList<Lesion> misLesiones;
	
	public Jugador(String nombre, String apellido, String iD, Calendar fechaNacimiento, float salarioAnual,
			String ligaProveniente, boolean lesionado, ArrayList<Lesion> misLesiones) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.iD = iD;
		this.fechaNacimiento = fechaNacimiento;
		this.salarioAnual = salarioAnual;
		this.ligaProveniente = ligaProveniente;
		this.lesionado = lesionado;
		this.misLesiones = misLesiones;
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
	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Calendar fechaNacimiento) {
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
	public void setMisLesiones(ArrayList<Lesion> misLesiones) {
		this.misLesiones = misLesiones;
	}
}