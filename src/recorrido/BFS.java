package recorrido;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

	private Nodo nodoInicio;
	private Nodo nodoObjetivo;

	public BFS(Nodo start, Nodo goalNode) {
		this.nodoInicio = start;
		this.nodoObjetivo = goalNode;
	}

	public boolean resolver() {
		if (this.nodoInicio.equals(nodoObjetivo)) {
			System.out.println("Nodo encontrado: " + this.nodoInicio);
		}
		Queue<Nodo> cola = new LinkedList<>();
		List<Nodo> visitados = new ArrayList<>();
		cola.add(this.nodoInicio);
		visitados.add(nodoInicio);
		while (!cola.isEmpty()) {
			Nodo current = cola.remove();
			if (current.equals(this.nodoObjetivo)) {
				System.out.println(visitados);
				return true;
			} else {
				if (current.getChildren().isEmpty())
					return false;
				else
					cola.addAll(current.getChildren());
			}
			visitados.add(current);
		}
		return false;
	}
}
