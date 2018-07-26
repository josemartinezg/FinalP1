package logical;

public class Marcador {
	private int puntajeVisitante; 
	private int puntajeLocal;
	
	public Marcador() {
		super();
		puntajeVisitante = 0;
		puntajeLocal = 0;
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
}