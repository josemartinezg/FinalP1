package logical;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Jugador {
	private String nombre; 
	private String apellido;
	private String equipo;
	private String iD;
	private FechaSimple fechaNacimiento;
	private float salarioAnual;
	private String ligaProveniente;
	private boolean lesionado;
	private ArrayList<Lesion> misLesiones;
	private Estadistica estadisticas;
	private int numeroCamiseta;
	private float estatura;
	private float peso;
	private ImageIcon fotoPersonal;
	
	
	public Jugador(String nombre, String apellido, String equipo, String iD, FechaSimple fechaNacimiento, float salarioAnual,
			String ligaProveniente, boolean lesionado, Estadistica estadisticas, int numeroCamiseta, float estatura, float peso,
			ImageIcon foto) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.equipo = equipo;
		this.iD = iD;
		this.fechaNacimiento = fechaNacimiento;
		this.salarioAnual = salarioAnual;
		this.ligaProveniente = ligaProveniente;
		this.lesionado = lesionado;
		this.estadisticas = estadisticas;
		this.numeroCamiseta = numeroCamiseta;
		this.estatura = estatura;
		this.peso = peso;
		this.fotoPersonal = foto;
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
	public int getNumeroCamiseta() {
		return numeroCamiseta;
	}
	public void setNumeroCamiseta(int numeroCamiseta) {
		this.numeroCamiseta = numeroCamiseta;
	}
	public float getEstatura() {
		return estatura;
	}
	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
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
	public String getEquipo() {
		return equipo;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	public ImageIcon getFotoPersonal() {
		return fotoPersonal;
	}
	public void setFotoPersonal(ImageIcon fotoPersonal) {
		this.fotoPersonal = fotoPersonal;
	}	
}
