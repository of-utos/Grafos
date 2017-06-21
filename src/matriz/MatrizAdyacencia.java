package matriz;

import java.util.Random;

/**
 * Clase que administra la matriz de adyacencia de un grafo. <br>
 */
public abstract class MatrizAdyacencia {
	/**
	 * MatrizAdyacencia del grafo. <br>
	 */
	private int[][] matriz;
	/**
	 * Tamaño de la matriz. <br>
	 */
	private int tamaño;
	/**
	 * Generador de números random. <br>
	 */
	private Random random = new Random();
	/**
	 * Número límite de random. <br>
	 */
	private int valorRandom;

	/**
	 * Crea una matriz de adyacencia de un grafo. <br>
	 * 
	 * @param tamaño
	 *            Tamaño de la matriz. <br>
	 * @param random
	 *            Número límite del random. <br>
	 */
	public MatrizAdyacencia(final int tamaño, final int random) {
		this.valorRandom = random;
		this.tamaño = tamaño;
		this.matriz = new int[this.tamaño][this.tamaño];
	}

	/**
	 * Devuelve la matriz. <br>
	 * 
	 * @return Matriz de Adyacencia. <br>
	 */
	public int[][] getMatriz() {
		int[][] nuevaMatriz = new int[this.tamaño][this.tamaño];
		for (int i = 0; i < this.tamaño; i++) {
			for (int j = 0; j < this.tamaño; j++) {
				nuevaMatriz[i][j] = this.matriz[i][j];
			}
		}
		return nuevaMatriz;
	}

	/**
	 * Muestra el contenido de la matriz. <br>
	 */
	public void mostarMatriz() {
		System.out.println("Matriz de adyacencia:\n");
		System.out.print(" ");
		for (int v = 0; v < this.tamaño; v++) {
			System.out.print("   " + (v + 1));
		}
		System.out.println();
		for (int v = 0; v < this.tamaño; v++) {
			System.out.print((v + 1) + " ");
			for (int w = 0; w < this.tamaño; w++) {
				if (this.matriz[v][w] != Integer.MAX_VALUE) {
					System.out.print("  " + this.matriz[v][w] + " ");
				} else {
					System.out.print("  " + '\u221e' + " ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * Devuelve el tamaño de la matriz. <br>
	 * 
	 * @return Tamaño de la matriz. <br>
	 */
	public int getTamaño() {
		return this.tamaño;
	}

	/**
	 * Devuelve un valor random. <br>
	 * 
	 * @return int random. <br>
	 */
	public int getRandom() {
		return this.random.nextInt(this.valorRandom);
	}

	/**
	 * Carga un elemento en la matriz.
	 * <p>
	 * De ser el mismo valor de fila o columna, o de ser un cero, carga un valor
	 * considierado como infinito. <br>
	 * 
	 * @param valor
	 *            Elemento a insertar. <br>
	 * @param fila
	 *            Fila de la matriz. <br>
	 * @param columna
	 *            Columna de la matriz. <br>
	 */
	protected abstract void cargarValorMatriz(final int valor, final int fila, final int columna);

	/**
	 * Devuelve el valor de una posición de la matriz. <br>
	 * 
	 * @param fila
	 *            Fila de la matriz. <br>
	 * @param columna
	 *            Columna de la matriz. <br>
	 * @return
	 */
	public int getValorMatriz(final int fila, final int columna) {
		return this.matriz[fila][columna];
	}

	/**
	 * Estabelece un valor en la matriz. <br>
	 * 
	 * @param fila
	 *            Fila de la matriz. <br>
	 * @param columna
	 *            Columna de la matriz. <br>
	 * @param valor
	 *            Valor a insertar. <br>
	 */
	public void setValorMatriz(final int fila, final int columna, final int valor) {
		this.matriz[fila][columna] = valor;
	}
}
