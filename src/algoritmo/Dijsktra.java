package algoritmo;

/**
 * El grafo puede ser dirigido o no. El grafo debe ser ponderado. <br>
 */
public class Dijsktra {
	/**
	 * Matriz de adyacencia del grafo. <br>
	 */
	private int[][] matrizAdy;
	/**
	 * Nodos ya visitados. <br>
	 */
	private boolean[] visitados;
	/**
	 * Costo para llegar a un nodo. <br>
	 */
	private int[] costos;
	/**
	 * Nodo inicial. <br>
	 */
	private int nodoInicio;
	/**
	 * Cantidad de nodos del grafo. <br>
	 */
	private int cantidadNodos;
	/**
	 * 
	 */
	private int[] ruta;

	public Dijsktra(final int[][] matrizAdyacencia, final int nodoInicio) {
		this.matrizAdy = matrizAdyacencia;
		this.nodoInicio = nodoInicio;
		this.nodoInicio--;
		this.cantidadNodos = matrizAdyacencia.length;
		this.visitados = new boolean[this.cantidadNodos];
		this.costos = new int[this.cantidadNodos];
		this.ruta = new int[this.cantidadNodos];
		inicializarEstructurasInternas();
		this.visitados[this.nodoInicio] = true;
		this.costos[this.nodoInicio] = Integer.MAX_VALUE;
		for (int i = 0; i < this.cantidadNodos; i++) {
			int v = minimo();

			System.out.println("W: " + (v + 1));

			visitados[v] = true;
			for (int j = 0; j < cantidadNodos; j++) {
				if (!visitados[j]) {
					if ((costos[j] + matrizAdy[v][j]) < costos[v]) {
						costos[j] = costos[v] + matrizAdy[v][j];
						System.out.println("\tNueva ruta: " + (j + 1));
						ruta[j] = v;
					}
				}
			}
		}
	}

	private int minimo() {
		int valorMinimo = Integer.MAX_VALUE;
		int indiceMinimo = 1;
		for (int i = 0; i < cantidadNodos; i++) {
			if (!visitados[i] && costos[i] <= valorMinimo) {
				valorMinimo = costos[i];
				indiceMinimo = i;
			}
		}
		return indiceMinimo;
	}

	/**
	 * Inicializa los vectores de Dijkstra. <br>
	 */
	private void inicializarEstructurasInternas() {
		for (int i = 0; i < cantidadNodos; i++) {
			costos[i] = matrizAdy[nodoInicio][i];
			ruta[i] = -1;
		}
	}

	public void resultado() {
		System.out.println("Costo para llegar los nodos desde " + (this.nodoInicio + 1) + ":");
		for (int i = 0; i < this.cantidadNodos; i++) {
			if (this.ruta[i] != -1) {
				System.out.println((i + 1) + "\t" + this.costos[i]);
			} else {
				System.out.println((i + 1) + "\t" + '\u221e');
			}

		}
	}

	/**
	 * Muestra la ruta a tomar para llegar a un nodo .<br>
	 * 
	 * @param destino
	 *            Nodo a llegar. <br>
	 */
	public void ruta(final int destino) {
		int i = destino;
		System.out.print(this.nodoInicio);
		if (ruta[destino] != -1) {
			while (ruta[i] != this.nodoInicio) {
				System.out.print(" -> " + (ruta[i] + 1));
				i = ruta[i];
			}
			System.out.print(" -> " + destino + "\n");
		}
		System.out.println("Peso de la ruta: " + this.costos[destino]);
	}
}