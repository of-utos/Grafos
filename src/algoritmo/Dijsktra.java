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
	private int[] ruta;

	public Dijsktra(final int[][] matAdy, final int nodoInicio) {
		this.matrizAdy = matAdy;
		this.nodoInicio = nodoInicio;
		this.nodoInicio--;
		this.cantidadNodos = matAdy.length;
		this.visitados = new boolean[this.cantidadNodos];
		this.costos = new int[this.cantidadNodos];
		this.ruta = new int[this.cantidadNodos];
	}

	public void algoritmoDijsktra() {
		valoresIniciales();
		visitados[nodoInicio] = true;
		costos[nodoInicio] = 0;
		for (int i = 0; i < cantidadNodos; i++) {
			int v = minimo();
			visitados[v] = true;
			for (int j = 0; j < cantidadNodos; j++) {
				if (!visitados[j]) {
					if ((costos[v] + matrizAdy[v][j]) < costos[j]) {
						costos[j] = costos[v] + matrizAdy[v][j];
						ruta[j] = v;
					}
				}
			}
		}
	}

	private int minimo() {
		int min = Integer.MAX_VALUE;
		int v = 1;
		for (int i = 0; i < cantidadNodos; i++) {
			if (!visitados[i] && costos[i] <= min) {
				min = costos[i];
				v = i;
			}
		}
		return v;
	}

	private void valoresIniciales() {
		for (int i = 0; i < cantidadNodos; i++) {
			visitados[i] = false;
			costos[i] = matrizAdy[nodoInicio][i];
			ruta[i] = nodoInicio;
		}
	}

	public void resultado() {
		for (int i = 0; i < this.cantidadNodos; i++) {
			System.out.println(this.ruta[i] + "\t" + this.costos[i]);
		}
	}

	public void ruta(final int destino) {
		int i = destino;
		System.out.print(this.nodoInicio);
		while (ruta[i] != this.nodoInicio) {
			System.out.print(" -> " + (ruta[i] + 1));
			i = ruta[i];
		}
		System.out.print(" -> " + destino + "\n");
		System.out.println("Peso de la ruta: " + this.costos[destino]);
	}
}