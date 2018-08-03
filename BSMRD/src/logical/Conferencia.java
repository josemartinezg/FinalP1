package logical;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.jfree.data.UnknownKeyException;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;


public class Conferencia implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4089348180939898618L;
	private ArrayList<Juego> juegos;
	private ArrayList<Jugador> misJugadores;
	private ArrayList<Equipo> equipos;
	private static Conferencia conf = null;
	
	private Conferencia() {
		super();
		this.juegos = new ArrayList<Juego>();
		this.misJugadores = new ArrayList<>();
		this.equipos = new ArrayList<Equipo>();
	}

	public ArrayList<Juego> getJuegos() {
		return juegos;
	}
	
	public ArrayList<Juego> getJuegos(FechaSimple fecha, boolean ocurrido) {
		ArrayList<Juego> aux = new ArrayList<Juego>();
		for (Juego jg : juegos) {
			FechaSimple fechaJuego = jg.getFecha();
			if (fechaJuego.isEqual(fecha)) {
				aux.add(jg);
			}
		}
		return aux;
	}
	
	public ArrayList<Juego> getJuegos(int rangoDeDias) {
		ArrayList<Juego> aux = new ArrayList<Juego>();
		for (Juego jg : juegos) {
			FechaSimple fechaJuego = jg.getFecha();
			if (fechaJuego.daysLeft() <= rangoDeDias && !jg.isOcurrido()) {
				aux.add(jg);
			}
		}
		return aux;
	}

	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}
	
	public void insertJuego(Juego juego) throws IOException {
		this.juegos.add(juego);
		Collections.sort(juegos, new Comparator() {
			public int compare(Object j1, Object j2) {
				FechaSimple f1 = ( (Juego) j1).getFecha();
				FechaSimple f2 = ( (Juego) j2 ).getFecha();
				
				Integer year1 = f1.getYear();
				Integer year2 = f2.getYear();
				int yComp = year1.compareTo(year2);
				
				if (yComp != 0) return yComp;
				
				Integer month1 = f1.getMonth();
				Integer month2 = f2.getMonth();
				int mComp = month1.compareTo(month2);
				
				if (mComp != 0) return mComp;
				
				Integer day1 = f1.getDay();
				Integer day2 = f2.getDay();
				
				return day1.compareTo(day2);
			}
		});
		Conferencia.save();
	}
	
	public void insertEquipo(Equipo equipo) throws IOException {
		this.equipos.add(equipo);
		Conferencia.save();
	}
	
	public void removeJuego(Juego juego) throws IOException {
		this.juegos.remove(juego);
		Conferencia.save();
	}
	
	public void removeEquipo(Equipo equipo) throws IOException {
		this.equipos.remove(equipo);
		Conferencia.save();
	}
	
	public static Conferencia getInstance() throws IOException, ClassNotFoundException {		
		if (conf == null) {
			try {
				File file = new File("src/data/data.dat");
				FileInputStream inputStream = new FileInputStream(file);
				@SuppressWarnings("resource")
				ObjectInputStream objectInput = new ObjectInputStream(inputStream);
				conf = (Conferencia) objectInput.readObject();
				inputStream.close();
				objectInput.close();
			} catch (ClassNotFoundException e) {
				conf = new Conferencia();
			} catch (Exception e1) {
				conf = new Conferencia();
			}
		}

		return conf;
	}
	
	public ArrayList<Juego> getJuegosDelDia() {
		return this.getJuegos(FechaSimple.getInstance(), false);

	}
	
	public ArrayList<Juego> getJuegosSemana() {
		return this.getJuegos(7);
	}
	public ArrayList<Jugador> getMisJugadores() {
		return misJugadores;
	}
	public void setMisJugadores(ArrayList<Jugador> misJugadores) throws IOException {
		this.misJugadores = misJugadores;
		Conferencia.save();
	}
	
	public Juego getProximoJuego() {
		return getJuegosSemana().get(0);
	}
	
	public ArrayList<Jugador> topMasPuntos() {
		ArrayList<Jugador> aux = misJugadores;
		Collections.sort(aux, new Comparator() {
			public int compare(Object j1, Object j2) {
				Integer puntos1 = ((Jugador) j1).getEstadisticas().getTotalPuntos();
				Integer puntos2 = ((Jugador) j2).getEstadisticas().getTotalPuntos();
				return puntos2.compareTo(puntos1);
			}
		});
		return aux;
	}
	
	public ArrayList<Jugador> topMasAsistencias() {
		ArrayList<Jugador> aux = misJugadores;
		Collections.sort(aux, new Comparator() {
			public int compare(Object j1, Object j2) {
				Integer asist1 = ((Jugador) j1).getEstadisticas().getAsistencias();
				Integer asist2 = ((Jugador) j2).getEstadisticas().getAsistencias();
				return asist2.compareTo(asist1);
			}
		});
		return aux;
	}
	
	public ArrayList<Jugador> topMasRebotes() {
		ArrayList<Jugador> aux = misJugadores;
		Collections.sort(aux, new Comparator() {
			public int compare(Object j1, Object j2) {
				Integer rebotes1 = ((Jugador) j1).getEstadisticas().getRebotes();
				Integer rebotes2 = ((Jugador) j2).getEstadisticas().getRebotes();
				return rebotes2.compareTo(rebotes1);
			}
		});
		return aux;
	}
	
	public ArrayList<Jugador> topPorcentajeTiro() {
		ArrayList<Jugador> aux = misJugadores;
		Collections.sort(aux, new Comparator() {
			public int compare(Object j1, Object j2) {
				Float pt = ((Jugador) j1).getEstadisticas().getPorcentajeTiro();
				Float pt2 = ((Jugador) j2).getEstadisticas().getPorcentajeTiro();
				return pt2.compareTo(pt);
			}
		});
		return aux;
	}
	
	public ArrayList<Equipo> topEquipos() {
		ArrayList<Equipo> aux = equipos;
		Collections.sort(aux, new Comparator() {
			public int compare(Object j1, Object j2) {
				Float wr = ((Equipo) j1).getWinRate();
				Float wr2 = ((Equipo) j2).getWinRate();
				return wr2.compareTo(wr);
			}
		});
		return aux;
	}
	
	public Jugador jugadorMasPuntos() {
		return topMasPuntos().get(0);
	}
	
	public Jugador jugadorMasAsistencias() {
		return topMasAsistencias().get(0);
	}
	
	public Jugador jugadorMasRebotes() {
		return topMasRebotes().get(0);
	}

	public void modficarJugador(Jugador jugador) throws IOException {
		int ind = misJugadores.indexOf(jugador);
		misJugadores.set(ind, jugador);
		Conferencia.save();
	}
	public void addJugador(Jugador nuevoJugador) throws IOException {
		misJugadores.add(nuevoJugador);
		for (Equipo equipo : equipos) {
			if (equipo.getNombre().equalsIgnoreCase(nuevoJugador.getEquipo())) {
				equipo.addJugador(nuevoJugador);
			}
		}
		Conferencia.save();
	}

	public Jugador buscarJugadores(String iD) {
		Jugador aux = null;
		for (Jugador jugador : misJugadores){ 
			if (jugador.getiD().equalsIgnoreCase(iD)) 
				aux = jugador;
		}
		return aux;
	}

	public Equipo buscarEquipos(String iD) {
		Equipo aux = null;
		for (Equipo equipo : equipos){ 
			if (equipo.getiD().equalsIgnoreCase(iD)) 
				aux = equipo;
		}
		return aux;
	}
  
	public ArrayList<Jugador> sortByLastName() {
		ArrayList<Jugador> aux = misJugadores;
		Collections.sort(aux, new Comparator() {
			public int compare(Object j1, Object j2) {
				String asist1 = ((Jugador) j1).getApellido();
				String asist2 = ((Jugador) j2).getApellido();
				return asist1.compareTo(asist2);
			}
		});
		return aux;
	}
	
	public ArrayList<Jugador> getTeamMembers(String team) {
		ArrayList<Jugador> aux = new ArrayList<>();
		for (int i = 0; i < misJugadores.size(); i++) {
			if(misJugadores.get(i).getEquipo().equalsIgnoreCase(team)) {
				aux.add(misJugadores.get(i));
			}
		}
		return aux;
	}
		
	public static void save() throws IOException {
		File file = new File("src/data/data.dat");
		
		FileOutputStream outputStream = new FileOutputStream(file);
		
		ObjectOutputStream objectOutput = new ObjectOutputStream(outputStream);
		
		objectOutput.writeObject(conf);
		
		objectOutput.close();
		outputStream.close();
  }
	
	public DefaultPieDataset getMapLesiones() {
		
		DefaultPieDataset aux = new DefaultPieDataset();
		
		for (Jugador jg : misJugadores) {
			for (Lesion ls : jg.getMisLesiones()) {
				int actualValue = 0;
				try {
					actualValue = (int) aux.getValue("Grado " + ls.getGradoLesion());
				} catch(UnknownKeyException error) {
				} finally {
					aux.setValue("Grado " + ls.getGradoLesion(), new Integer(actualValue+1));
				}
			}
		}
		
		return aux;
		
	}
	
	public DefaultCategoryDataset getMapTopFive() {
		DefaultCategoryDataset aux = new DefaultCategoryDataset();
		
		ArrayList<Jugador> mejores = topPorcentajeTiro();
		for(int i=0; i<5;i++) {
			Jugador jg = mejores.get(i);
			aux.addValue((double) jg.getEstadisticas().getTotalPuntos(), jg.getNombre() + " " + jg.getApellido(), "Puntos");
			aux.addValue((double) jg.getEstadisticas().getRebotes(), jg.getNombre() + " " + jg.getApellido(), "Rebotes");
			aux.addValue((double) jg.getEstadisticas().getAsistencias(), jg.getNombre() + " " + jg.getApellido(), "Asistencias");
		}
		
		return aux;
	}
	
	public DefaultCategoryDataset getRanking() {
		DefaultCategoryDataset aux = new DefaultCategoryDataset();
		
		for (Equipo eq : equipos) {
			aux.addValue((double) eq.getJuegosGanados(), "Juegos ganados", eq.getNombre());
			aux.addValue((double) eq.getJuegosPerdidos(), "Juegos perdidos", eq.getNombre());
		}
		
		return aux;
	}

}

