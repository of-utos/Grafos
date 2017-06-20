package algoritmo;

/**
 * Clase que encuentra un subconjunto de aristas que forman un árbol con todos
 * los vertices, donde el peso total de todas las aristas en el árbol es el
 * mínimo posible.
 * <p>
 * Debe ser no dirigido. <br>
 */
public class Prim {
	/**
	 * Matriz de adyacencia. <br>
	 */
	private int[][] matrizAdyacencia;
	/**
	 * Peso mínimo del árbol. <br>
	 */
	private int peso = 0;
	/**
	 * Tamaño de la matriz. <br>
	 */
	private int tamaño;

	public Prim(final int matriz[][]) {
		this.tamaño = matriz.length;
		this.matrizAdyacencia = new int[this.tamaño][this.tamaño];
	}
}
