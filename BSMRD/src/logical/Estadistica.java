package logical;

import java.io.Serializable;

public class Estadistica implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1838388235515338303L;
	private int tirosLibres;
	private int puntosDeCampo;
	private int puntosDeTres;
	private int totalPuntos;
	private int asistencias;
	private int rebotes;
	private int intentosTirosLibres;
	private int intentosDeCampo;
	private int intentosDeTres;
	private int juegosJugados;
	
	//Añadir foto. 
	
	public Estadistica() {
		super();
		tirosLibres = 0;
		puntosDeCampo = 0;
		puntosDeTres = 0;
		asistencias = 0;
		rebotes = 0;
		intentosTirosLibres = 0;
		intentosDeCampo = 0;
		intentosDeTres = 0;
		juegosJugados = 0;
	}

	public int getTirosLibres() {
		return tirosLibres;
	}

	public int getPuntosDeCampo() {
		return puntosDeCampo;
	}
	
	public int getPuntosDeTres() {
		return puntosDeTres;
	}

	public int getTotalPuntos() {
		return tirosLibres + puntosDeCampo + puntosDeTres;
	}

	public int getAsistencias() {
		return asistencias;
	}
	public int getRebotes() {
		return rebotes;
	}
	public int getIntentosTirosLibres() {
		return intentosTirosLibres;
	}

	public int getIntentosDeCampo() {
		return intentosDeCampo;
	}
	public int getIntentosDeTres() {
		return intentosDeTres;
	}

	public int getJuegosJugados() {
		return juegosJugados;
	}

	public void setJuegosJugados(int juegosJugados) {
		this.juegosJugados = juegosJugados;
	}
	/*
	 * Llamar desde pantalla del tablero o simulación del juego.
	 * Condicionar los action listeners de acuerdo a las teclas. Ej: Si se asigna una tecla a tiro libre...
	 * ... "addPuntos(1, T/F)".  
	 * Agregar estructura de control al momento de invocar la función.
	 * */
	


	//TODO Probar enviandole datos directamente al constructor.
	public float addTiro(int anotacion, boolean encestado) {
		float porcentaje = 0;
		if (encestado) {
			switch (anotacion) {
				case 1:
					intentosTirosLibres += 1;
					tirosLibres += anotacion;
					porcentaje = (float)(tirosLibres/intentosTirosLibres);
					break;
				case 2:
					intentosDeCampo += 1;
					puntosDeCampo += anotacion;
					porcentaje = (float)(puntosDeCampo/intentosDeCampo);
					break;
				case 3:
					intentosDeTres += 1;
					puntosDeTres += anotacion;
					porcentaje = (float)(puntosDeTres/intentosDeTres);
					break;
			}

		} else {
			switch (anotacion) {
				case 1:
					intentosTirosLibres += 1;
					porcentaje = (float)(tirosLibres/intentosTirosLibres);
					break;
				case 2:
					intentosDeCampo += 1;
					porcentaje = (float)(puntosDeCampo/intentosDeCampo);
					break;
				case 3:
					intentosDeTres += 1;
					porcentaje = (float)(puntosDeTres/intentosDeTres);
					break;
				}
		}
		return porcentaje;
	}
	
	//Determinar si estos métodos son necesarios en esta clase...
	/*Llamar método por teclado al momento de que se realice una asistencia.*/
	public void addAsistencias() {
		asistencias += 1;
	}
	/*Llamar método por teclado al momento de que se realice un rebote.*/
	public void addRebotes() {
		rebotes += 1;
	}
	public int puntosPorJuego(int cantJuegos) {
		int promedio = 0;
		if (cantJuegos != 0) {
			promedio = totalPuntos/cantJuegos;
		}else {
			promedio = 0;
		}
		return promedio;
	}
	
	public float calcAnotacionesPorJuego(int anotacion, int juegosJugados) {
		float anotacionPorJuego = anotacion/juegosJugados;
		if (anotacion != 0 || juegosJugados != 0) {
			anotacionPorJuego = anotacion/juegosJugados;
		}else {
			anotacionPorJuego = 0;
		}
		return anotacionPorJuego;
	}
	/*
	public float calcRebotesPorJuego(int juegosJugados) {
		float rpj = rebotes/juegosJugados;
		return rpj;
	}
	public float calcAsistenciasPorJuego(int juegosJugados) {
		float apj = asistencias/juegosJugados;
		return apj;
	}*/
	
}
