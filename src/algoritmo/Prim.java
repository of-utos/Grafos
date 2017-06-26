package algoritmo;

/**
 * Clase que encuentra un subconjunto de aristas que forman un árbol con todos
 * los vertices, donde el peso total de todas las aristas en el árbol es el
 * mínimo posible.
 * <p>
 * El grafo debe ser no dirigido. <br>
 */
public class Prim {
	/**
	 * Matriz de adyacencia. <br>
	 */
	private int[][] matrizAdyacencia;
	/**
	 * Tamaño de la matriz. <br>
	 */
	private int tamaño;
	/**
	 * Nodo origen. <br>
	 */
	private int[] padre;
	/**
	 * Peso mínimo para llegar a un nodo. <br>
	 */
	private int[] pesoMinimo;
	/**
	 * Recorrido realizado por el algoritmo. <br>
	 */
	private boolean[] recorridoRealizado;

	/**
	 * Busca el subconjunto de aristas que forman un árbol con todos los
	 * vertices, donde el peso total de todas las aristas en el árbol es el
	 * mínimo posible.
	 * 
	 * @param matriz
	 *            Matriz de adyacencia del grafo. <br>
	 */
	public Prim(final int[][] matriz) {
		this.tamaño = matriz.length;
		this.matrizAdyacencia = matriz;
		this.padre = new int[this.tamaño];
		this.pesoMinimo = new int[this.tamaño];
		this.recorridoRealizado = new boolean[this.tamaño];
		for (int i = 0; i < this.tamaño; i++) {
			this.pesoMinimo[i] = Integer.MAX_VALUE;
		}
		this.pesoMinimo[0] = 0;
		this.padre[0] = -1;
		int i;
		for (int count = 0; count < this.tamaño - 1; count++) {
			i = menorPeso();
			this.recorridoRealizado[i] = true;
			for (int j = 0; j < this.tamaño; j++) {
				if (this.matrizAdyacencia[i][j] != Integer.MAX_VALUE && this.recorridoRealizado[j] == false
						&& this.matrizAdyacencia[i][j] < this.pesoMinimo[j]) {
					this.padre[j] = i;
					this.pesoMinimo[j] = this.matrizAdyacencia[i][j];
				}
			}
		}
	}

	/**
	 * Muestra el subconjunto de aristas que forman el árbol el menor peso
	 * posible. <br>
	 */
	public void mostarResultado() {
		int peso = 0;
		System.out.println("Resultado:");
		for (int i = 1; i < this.tamaño; i++) {
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
	 * Devuelve la posición de la arista con menor peso de algún nodo
	 * pertenciente al árbol solución. <br>
	 * 
	 * @return Índice. <br>
	 */
	private int menorPeso() {
		int min = Integer.MAX_VALUE, indice = 0;
		for (int i = 0; i < this.tamaño; i++) {
			if (this.recorridoRealizado[i] == false && this.pesoMinimo[i] < min) {
				min = this.pesoMinimo[i];
				indice = i;
			}
		}
		return indice;
	}
}