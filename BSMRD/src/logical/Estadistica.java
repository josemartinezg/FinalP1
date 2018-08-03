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
	private float porcentajeTiro;
	
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
		porcentajeTiro = 0;
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

	public void aumentarJuegos() {
		this.juegosJugados += 1;
	}

	public void addTiro(int anotacion, boolean encestado) {
		if (encestado) {
			switch (anotacion) {
				case 1:
					intentosTirosLibres += 1;
					tirosLibres += anotacion;
					porcentajeTiro = (float)(tirosLibres/intentosTirosLibres);
					break;
				case 2:
					intentosDeCampo += 1;
					puntosDeCampo += anotacion;
					porcentajeTiro = (float)(puntosDeCampo/intentosDeCampo);
					break;
				case 3:
					intentosDeTres += 1;
					puntosDeTres += anotacion;
					porcentajeTiro = (float)(puntosDeTres/intentosDeTres);
					break;
			}

		} else {
			switch (anotacion) {
				case 1:
					intentosTirosLibres += 1;
					porcentajeTiro = (float)(tirosLibres/intentosTirosLibres);
					break;
				case 2:
					intentosDeCampo += 1;
					porcentajeTiro = (float)(puntosDeCampo/intentosDeCampo);
					break;
				case 3:
					intentosDeTres += 1;
					porcentajeTiro = (float)(puntosDeTres/intentosDeTres);
					break;
				}
		}
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
	public int puntosPorJuego() {
		int promedio = 0;
		if (juegosJugados != 0) {
			promedio = totalPuntos/juegosJugados;
		}else {
			promedio = 0;
		}
		return promedio;
	}
	
	public float calcAnotacionesPorJuego(int anotacion) {
		float anotacionPorJuego;
		if (anotacion != 0 && juegosJugados != 0) {
			anotacionPorJuego = anotacion/juegosJugados;
		}else {
			anotacionPorJuego = 0;
		}
		return anotacionPorJuego;
	}
	
	public float getPorcentajeTiro() {
		return porcentajeTiro;
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
