package recorrido;

import java.util.Stack;

import matriz.MatrizAdyacencia;

public class DFS {
	private int cantNodos;
	private MatrizAdyacencia matSim;

	public void iniciarAFalse(boolean vec[], int origen) {
		for (int i = 0; i < cantNodos; i++)
			vec[i] = false;
		vec[origen] = true;
	}

	public int hayCiclo(int nodo, boolean adyVistos[], int origen) {
		int i = 0;
		int ciclo = 0;
		while (i < cantNodos) {
			if (i != origen) {
				if (adyVistos[i] == true && matSim.sonAdyacentes(nodo, i)) {
					ciclo = 1;
					break;
				}
			}
			i++;
		}
		return ciclo;
	}

	public int buscarAdyacente(int nodo, boolean adyVistos[]) {
		int i = 0;
		int adyacente = -1;
		while (i < cantNodos) {
			if (adyVistos[i] == false && matSim.sonAdyacentesConCosto(nodo, i)) {
				adyVistos[i] = true;
				adyacente = i;
				break;
			}
			i++;
		}
		return adyacente;
	}

	public boolean todosVistos(boolean nodosVistos[]) {
		for (int i = 0; i < cantNodos; i++) {
			if (nodosVistos[i] == false)
				return false;
		}
		return true;
	}

	public boolean DFS(int origen) {
		Stack<Integer> pila = new Stack<Integer>();
		boolean nodosVistos[] = new boolean[cantNodos];
		int nodo;
		boolean esConexo;
		iniciarAFalse(nodosVistos, origen);
		pila.push(origen);
		System.out.println("Empiezo del nodo: " + origen);
		while (!pila.empty()) {
			nodo = pila.peek();
			for (int i = 0; i < cantNodos; i++) {
				nodo = buscarAdyacente(nodo, nodosVistos);
				if (nodo != -1) {
					nodosVistos[nodo] = true;
					pila.push(nodo);
					System.out.println("Visito el nodo: " + nodo);
				} else {
					System.out.println("Vuelvo del nodo: " + pila.peek());
					pila.pop();
					break;
				}
			}
		}
		esConexo = todosVistos(nodosVistos);
		return esConexo;
	}
}
