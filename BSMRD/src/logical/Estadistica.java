package logical;


public class Estadistica {
	private int tirosLibres;
	private int puntosDeCampo;
	private int puntosDeTres;
	private int totalPuntos;
	private int asistencias;
	private int rebotes;
	private int intentosTirosLibres;
	private int intentosDeCampo;
	private int intentosDeTres;
	
	//Añadir foto. 
	
	public Estadistica() {
		super();
		tirosLibres = 0;
		puntosDeCampo = 0;
		puntosDeTres = 0;
		totalPuntos = 0;
		asistencias = 0;
		rebotes = 0;
		intentosTirosLibres = 0;
		intentosDeCampo = 0;
		intentosDeTres = 0;
	}

	public int getTirosLibres() {
		return tirosLibres;
	}

	public void setTirosLibres(int tirosLibres) {
		this.tirosLibres = tirosLibres;
	}

	public int getPuntosDeCampo() {
		return puntosDeCampo;
	}
	public void setPuntosDeCampo(int puntosDeCampo) {
		this.puntosDeCampo = puntosDeCampo;
	}
	
	public int getPuntosDeTres() {
		return puntosDeTres;
	}

	public void setPuntosDeTres(int puntosDeTres) {
		this.puntosDeTres = puntosDeTres;
	}

	public int getTotalPuntos() {
		return totalPuntos;
	}

	public void setTotalPuntos(int totalPuntos) {
		this.totalPuntos = totalPuntos;
	}
	public int getAsistencias() {
		return asistencias;
	}
	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}
	public int getRebotes() {
		return rebotes;
	}
	public void setRebotes(int rebotes) {
		this.rebotes = rebotes;
	}
	public int getIntentosTirosLibres() {
		return intentosTirosLibres;
	}

	public void setIntentosTirosLibres(int intentosTirosLibres) {
		this.intentosTirosLibres = intentosTirosLibres;
	}

	public int getIntentosDeCampo() {
		return intentosDeCampo;
	}
	public void setIntentosDeCampo(int intentosDeCampo) {
		this.intentosDeCampo = intentosDeCampo;
	}
	public int getIntentosDeTres() {
		return intentosDeTres;
	}
	public void setIntentosDeTres(int intentosDeTres) {
		this.intentosDeTres = intentosDeTres;
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
		if (encestado == true) {
			switch (anotacion) {
			case 1:
				intentosTirosLibres += 1;
				tirosLibres += anotacion;
				porcentaje = (float)(tirosLibres/intentosTirosLibres);
			case 2:
				intentosDeCampo += 1;
				puntosDeCampo += anotacion;
				porcentaje = (float)(puntosDeCampo/intentosDeCampo);
			case 3:
				intentosDeTres += 1;
				puntosDeTres += anotacion;
				porcentaje = (float)(puntosDeTres/intentosDeTres);
			}

		}else {
			switch (anotacion) {
			case 1:
				intentosTirosLibres += 1;
				porcentaje = (float)(tirosLibres/intentosTirosLibres);
			case 2:
				intentosDeCampo += 1;
				porcentaje = (float)(puntosDeCampo/intentosDeCampo);
			case 3:
				intentosDeTres += 1;
				porcentaje = (float)(puntosDeTres/intentosDeTres);
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
		int promedio = totalPuntos/cantJuegos;
		return promedio;
	}
	
	public float calcAnotacionesPorJuego(int anotacion, int juegosJugados) {
		float anotacionPorJuego = anotacion/juegosJugados;
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
