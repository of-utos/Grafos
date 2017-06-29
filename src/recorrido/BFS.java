package recorrido;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Clase que busca el recorrido de un nodo a otro dentro de un grafo.
 * <p>
 * El grafo puede ser dirigido o no, como ponderado y no ponderado. <br>
 */
public class BFS {
	boolean[] estados;
	int[] distancia;

	int[] padre;
	LinkedList<Nodo> cola;
	/**
	 * Nodo de origen. <br>
	 */
	Nodo nodoOrigen;
	/**
	 * Nodos del grafo. <br>
	 */
	Nodo[] nodos;

	public BFS(int[][] matrizAdyacencia, Nodo nodoOrigen, Nodo[] nodos) {
		cola = new LinkedList<Nodo>();
		this.nodos = nodos;
		this.nodoOrigen = nodoOrigen;
		estados = new boolean[matrizAdyacencia.length];
		distancia = new int[matrizAdyacencia.length];
		padre = new int[matrizAdyacencia.length];

		for (int j = 0; j < matrizAdyacencia.length; j++) {
			estados[j] = false;
			distancia[j] = Integer.MAX_VALUE;
		}

		estados[nodoOrigen.getNumero()] = true;
		distancia[nodoOrigen.getNumero()] = 0;
		cola.addFirst(nodoOrigen);

		while (!cola.isEmpty()) {
			Nodo u = cola.removeFirst();
			// Busco los adyacentes.
			for (int i = 0; i < matrizAdyacencia.length; i++) {
				int costo = matrizAdyacencia[u.numero][i];
				if (costo < Integer.MAX_VALUE) {

					if (estados[i] == false) {
						estados[i] = true;
						distancia[i] = distancia[u.numero] + 1;
						padre[i] = u.numero;
						cola.addFirst(nodos[i]);
					}
				}
			}
		}
	}

	public Stack<Integer> recorrido(Nodo NodoDestino) {

		Stack<Integer> pilaResultado = new Stack<Integer>();
		int aVisitar = padre[NodoDestino.numero];

		if (this.nodoOrigen.numero != aVisitar && estados[aVisitar] == true) {
			pilaResultado.push(NodoDestino.numero);
			pilaResultado.push(aVisitar);
		} else {
			if (this.nodoOrigen.numero == aVisitar && this.nodoOrigen.numero == NodoDestino.numero
					&& estados[aVisitar] == true) {
				pilaResultado.push(aVisitar);
				return pilaResultado;
			}

			pilaResultado.push(Integer.MIN_VALUE);
			return pilaResultado;
		}

		while (this.nodoOrigen.numero != aVisitar) {
			pilaResultado.push(padre[aVisitar]);
			aVisitar = padre[aVisitar];

		}
		// pilaResultado.push(nodoOrigen.numero);
		return pilaResultado;
	}

	public void BFS(int origen) {
		LinkedList<Integer> cola = new LinkedList<Integer>();
		boolean nodosVistos[] = new boolean[cantNodos];
		int nodo;
		iniciarAFalse(nodosVistos, origen);
		System.out.println("Acolo el origen: " + origen);
		cola.add(origen);
		while (!cola.isEmpty()) {
			nodo = cola.peek();
			for (int i = 0; i < cantNodos; i++) {
				nodo = buscarAdyacente(nodo, nodosVistos);
				if (nodo != -1) {
					System.out.println("Acolo el nodo: " + nodo);
					cola.add(nodo);
					nodo = cola.peek();
				} else {
					System.out.println("Desacolo el nodo: " + cola.peek());
					cola.remove();
					break;
				}
			}
		}
	}
}
