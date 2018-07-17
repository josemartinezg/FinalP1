package logical;

public class Marcador {
	private int puntajeVisitante; 
	private int puntajeLocal;
	private float tiempoDelCuarto;
	private int cuartoActual;
	
	public Marcador(float tiempoDelCuarto, int cuartoActual) {
		super();
		puntajeVisitante = 0;
		puntajeLocal = 0;
		this.tiempoDelCuarto = tiempoDelCuarto;
		this.cuartoActual = cuartoActual;
	}
	public int getPuntajeVisitante() {
		return puntajeVisitante;
	}
	public void setPuntajeVisitante(int puntajeVisitante) {
		this.puntajeVisitante = puntajeVisitante;
	}
	public int getPuntajeLocal() {
		return puntajeLocal;
	}
	public void setPuntajeLocal(int puntajeLocal) {
		this.puntajeLocal = puntajeLocal;
	}
	public float getTiempoDelCuarto() {
		return tiempoDelCuarto;
	}
	public void setTiempoDelCuarto(float tiempoDelCuarto) {
		this.tiempoDelCuarto = tiempoDelCuarto;
	}
	public int getCuartoActual() {
		return cuartoActual;
	}
	public void setCuartoActual(int cuartoActual) {
		this.cuartoActual = cuartoActual;
	}
	/*
	 * Addición simple de puntos. 
	 * Se sugiere configurar el KeyListener, para invocar el método con parámetros predeterminados.
	 * Ej: if (key == KeyEvent.VK_ENTER){
	 * "addPuntos(3, true)"
	 * "addTiro(3, true)"}
	 * */
	public void addPuntos(int anotacion, boolean esLocal) {
		if (esLocal == true) {
			puntajeLocal += anotacion;
		}else {
			puntajeVisitante += anotacion;
		}
	}
	
	public void tiempoDeJuego() {
		System.out.println("Inicio del juego");
		new CountDown();
	}
}