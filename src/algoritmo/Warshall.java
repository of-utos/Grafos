package algoritmo;

/**
 * Clase que utiliza el algoritmo de Warshall para poder obtener todas las
 * posibles uniones entre nodos, directa o indirectamente.
 * <p>
 * No tiene en cuenta el costo ni el camino. <br>
 */
public class Warshall {
	/**
	 * Tamaño de la matriz.
	 * <p>
	 * Es la cantidad total de nodos en el grafo. <br>
	 */
	private int tamaño;
	/**
	 * MatrizAdyacencia de clausura transitiva. <br>
	 */
	private boolean[][] matrizClausura;

	/**
	 * Crea una matriz de clausura transitiva en la que se muestran todas las
	 * posibles uniones entre nodos. <br>
	 * 
	 * @param matrizAdyacencia
	 *            MatrizAdyacencia de adyacencia del gráfo. <br>
	 */
	public Warshall(final int[][] matrizAdyacencia) {
		this.tamaño = matrizAdyacencia.length;
		this.matrizClausura = new boolean[this.tamaño][this.tamaño];
		for (int i = 0; i < this.tamaño; i++) {
			for (int j = 0; j < this.tamaño; j++) {
				if (matrizAdyacencia[i][j] != Integer.MAX_VALUE) {
					this.matrizClausura[i][j] = true;
				}
				this.matrizClausura[i][i] = false;
			}
		}
		for (int i = 0; i < this.tamaño; i++) {
			for (int j = 0; j < this.tamaño; j++) {
				if (this.matrizClausura[j][i]) {
					for (int k = 0; k < this.tamaño; k++) {
						if (this.matrizClausura[j][i] && this.matrizClausura[i][k]) {
							this.matrizClausura[j][k] = true;
						}
					}
				}
			}
		}
	}

	/**
	 * Devuelve la matriz de clausura transitiva. <br>
	 * 
	 * @return MatrizAdyacencia de clausara transitiva. <br>
	 */
	public boolean[][] getMatrizWarsahll() {
		return this.matrizClausura;
	}

	/**
	 * Muestra la matriz de clausura transitiva. <br>
	 */
	public void mostarMatriz() {
		System.out.println("Matriz de clausura transitiva:\n");
		System.out.print(" ");
		for (int v = 0; v < this.tamaño; v++) {
			System.out.print("   " + (v + 1));
		}
		System.out.println();
		for (int v = 0; v < this.tamaño; v++) {
			System.out.print((v + 1) + " ");
			for (int w = 0; w < this.tamaño; w++) {
				if (w == v) {
					System.out.print("  " + '\u221e' + " ");
				} else {
					if (this.matrizClausura[v][w]) {
						System.out.print("  1 ");
					} else {
						System.out.print("  0 ");
					}
				}
			}
			System.out.println();
		}
	}
}
