package recorrido;

import java.util.ArrayList;
import java.util.List;

public class Nodo {
	public String stationName;
	Nodo hijoIzquierdo;
	Nodo hijoDerecho;

	public Nodo(String stationName, Nodo primerHijo, Nodo segundoHijo) {
		this.stationName = stationName;
		this.hijoIzquierdo = primerHijo;
		this.hijoDerecho = segundoHijo;
	}

	public List<Nodo> getChildren() {
		List<Nodo> nodosHijos = new ArrayList<>();
		if (this.hijoIzquierdo != null) {
			nodosHijos.add(hijoIzquierdo);
		}
		if (this.hijoDerecho != null) {
			nodosHijos.add(hijoDerecho);
		}
		return nodosHijos;
	}

	public boolean quitarHijo(Nodo n) {
		return false;
	}
}