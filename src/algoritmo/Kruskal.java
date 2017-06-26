package algoritmo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * El grafo deb ser no dirigido y ponderado. <br>
 */
public class Kruskal {
	/**
	 * Matriz de adyacencia del grafo. <br>
	 */
	private int[][] matrizAdyacencia;
	/**
	 * Cantidad de nodos. <br>
	 */
	private int cantidadNodos;
	/**
	 * Matriz de las aristas con sus pesos. <br>
	 */
	private int[] padre;
	private int[] pesoMinimo;
	private boolean[] recorridoRealizado;
	private List<Arista> matrizAristas = new ArrayList<Arista>();

	public Kruskal(final int[][] matriz) {
		this.cantidadNodos = matriz.length;
		this.matrizAdyacencia = matriz;
		this.padre = new int[this.cantidadNodos];
		this.pesoMinimo = new int[this.cantidadNodos];
		this.recorridoRealizado = new boolean[this.cantidadNodos];
		for (int i = 0; i < this.cantidadNodos; i++) {
			this.pesoMinimo[i] = Integer.MAX_VALUE;
		}
		for (int fila = 0; fila < this.cantidadNodos; fila++) {
			for (int columna = fila; columna < this.matrizAdyacencia[fila].length; columna++) {
				if (this.matrizAdyacencia[fila][columna] != Integer.MAX_VALUE) {
					Arista arista = new Arista(fila, columna, this.matrizAdyacencia[fila][columna]);
					matrizAristas.add(arista);
				}
			}
		}
		matrizAristas.sort(new OrdenarAristas());
		for (java.util.ListIterator<Arista> iterator = matrizAristas.listIterator(); iterator.hasNext();) {
			Arista actual = iterator.next();
			System.out.println((actual.getNodoOrigen() + 1) + " " + (actual.getNodoFin() + 1) + " " + actual.getPeso());
		}
		System.out.print("\n");
		int nodosUsados = 0;
		int actual = 0;
		while (nodosUsados < this.cantidadNodos) {
			if (!this.recorridoRealizado[this.matrizAristas.get(actual).getNodoOrigen()]
					|| !this.recorridoRealizado[this.matrizAristas.get(actual).getNodoFin()]) {
				System.out.println((this.matrizAristas.get(actual).getNodoOrigen() + 1) + " "
						+ (this.matrizAristas.get(actual).getNodoFin() + 1) + " "
						+ this.matrizAristas.get(actual).getPeso());
				if (!this.recorridoRealizado[this.matrizAristas.get(actual).getNodoOrigen()]) {
					this.recorridoRealizado[this.matrizAristas.get(actual).getNodoOrigen()] = true;
					nodosUsados++;
				}
				if (!this.recorridoRealizado[this.matrizAristas.get(actual).getNodoFin()]) {
					this.recorridoRealizado[this.matrizAristas.get(actual).getNodoFin()] = true;
					nodosUsados++;
				}
				this.padre[this.matrizAristas.get(actual).getNodoFin()] = this.matrizAristas.get(actual)
						.getNodoOrigen();
				this.pesoMinimo[this.matrizAristas.get(actual).getNodoFin()] = this.matrizAristas.get(actual).getPeso();
			}
			actual++;
		}
	}

	/**
	 * Muestra el subconjunto de aristas que forman el árbol el menor peso
	 * posible. <br>
	 */
	public void mostarResultado() {
		int peso = 0;
		System.out.println("Resultado:");
		for (int i = 1; i < this.cantidadNodos; i++) {
			if (this.matrizAdyacencia[i][this.padre[i]] != Integer.MAX_VALUE) {
				System.out.println((this.padre[i] + 1) + "-" + (i + 1) + "-" + this.matrizAdyacencia[i][this.padre[i]]);
				peso += this.matrizAdyacencia[i][this.padre[i]];
			}
		}
		System.out.print("\n");
		System.out.println("Peso total: " + peso);
		System.out.print("\n");
	}

	/**
	 * Clase que administra aristas de un grafo. <br>
	 */
	private class Arista {
		/**
		 * Nodo de origen. <br>
		 */
		private int nodoOrigen;
		/**
		 * Nodo destino. <br>
		 */
		private int nodoFin;
		/**
		 * Peso de la arista. <br>
		 */
		private int peso;

		/**
		 * Crea una arista entre dos nodos con su peso. <br>
		 * 
		 * @param nodoOrigen
		 *            Nodo origen. <br>
		 * @param nodoFin
		 *            Nodo destino. <br>
		 * @param peso
		 *            Peso de la arista. <br>
		 */
		public Arista(final int nodoOrigen, final int nodoFin, final int peso) {
			this.nodoFin = nodoFin;
			this.nodoOrigen = nodoOrigen;
			this.peso = peso;
		}

		/**
		 * Devuelve el peso de la arista. <br>
		 * 
		 * @return Peso de la arista. <br>
		 */
		public int getPeso() {
			return this.peso;
		}

		/**
		 * Devuelve el nodo de origen. <br>
		 * 
		 * @return Nodo de origen. <br>
		 */
		public int getNodoOrigen() {
			if (this.nodoOrigen > this.nodoFin) {
				return this.nodoFin;
			}
			return this.nodoOrigen;
		}

		/**
		 * Devuelve el nodo destino. <br>
		 * 
		 * @return Nodo destino. <br>
		 */
		public int getNodoFin() {
			if (this.nodoOrigen > this.nodoFin) {
				return this.nodoOrigen;
			}
			return nodoFin;
		}
	}

	/**
	 * Ordena las aristas por tamaños. <br>
	 */
	private class OrdenarAristas implements Comparator<Arista> {
		@Override
		public int compare(Arista n1, Arista n2) {
			if (n1.getPeso() > n2.getPeso()) {
				return 1;
			}
			if (n1.getPeso() < n2.getPeso()) {
				return -1;
			}
			return 0;
		}
	}
}