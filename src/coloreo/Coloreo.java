package coloreo;

/**
 * Clase que administra el coloreo de un grafo.
 * <p>
 * Utiliza la menor cantidad de colores posibles. <br>
 */
public class Coloreo {
	/**
	 * Cantidad de colores a utilizar. <br>
	 */
	private int cantidadColores;
	/**
	 * Vector de nodos. <br>
	 */
	private Nodo[] nodos;
	/**
	 * Tamaño de la matriz de adyacencia.
	 * <p>
	 * Cantidad de nodos del grafo. <br>
	 */
	private int cantidadNodos;
	/**
	 * Matriz de adyacencia del grafo. <br>
	 */
	private boolean[][] matrizAdyacencia;
	/**
	 * Algoritmo de coloreo. <br>
	 */
	private String algoritmo;

	/**
	 * Colorea un grafo, según el algoritmo seleccionado.
	 * <p>
	 * <b>Algoritmo de Matula</b>: Empieza por el nodo de grado mínimo hasta
	 * llegar al de grado máximo. <br>
	 * <b>Algoritmo de Welsh-Powell</b>: Empieza por el nodo de grado máximo
	 * hasta llegar al de grado mínimo. <br>
	 * <b>Algoritmo secuencial aleatorio</b>: No tiene en cuenta el grado del
	 * nodo. <br>
	 * 
	 * @param matriz
	 *            Matriz de adyacencia del grafo. <br>
	 * @param recorrido
	 *            Recorrido a utilizar. <br>
	 */
	public Coloreo(final int[][] matriz, final String recorrido) {
		this.algoritmo = recorrido;
		this.cantidadNodos = matriz.length;
		this.matrizAdyacencia = new boolean[this.cantidadNodos][this.cantidadNodos];
		this.nodos = new Nodo[this.cantidadNodos];
		for (int i = 0; i < this.cantidadNodos; i++) {
			this.nodos[i] = new Nodo(i, 0, 0);
		}
		for (int i = 0; i < this.cantidadNodos; i++) {
			for (int j = 0; j < this.cantidadNodos; j++) {
				if (matriz[i][j] != Integer.MAX_VALUE) {
					this.matrizAdyacencia[i][j] = true;
					this.nodos[i].setGrado(this.nodos[i].getGrado() + 1);
					this.nodos[j].setGrado(this.nodos[j].getGrado() + 1);
				}
				this.matrizAdyacencia[i][i] = false;
			}
		}
		if (this.algoritmo == Recorrido.SECAL.name()) {
			colorearSecuencialAleatorio();
		}
		if (this.algoritmo == Recorrido.WELSHPOW.name()) {
			colorearPowell();
		}
		if (this.algoritmo == Recorrido.MATULA.name()) {
			colorearMatula();
		}
	}

	/**
	 * Colorea el gráfo. <br>
	 */
	private void colorear() {
		int i, color;
		this.cantidadColores = 0;
		for (i = 0; i < cantidadNodos; i++) {
			color = 1;
			while (!sePuedeColorear(i, color)) {
				color++;
			}
			nodos[i].setColor(color);
			if (color > this.cantidadColores) {
				this.cantidadColores = color;
			}
		}
	}

	/**
	 * Indica si un nodo se puede colorear. <br>
	 * 
	 * @param pos
	 *            Posición del nodo en el vector. <br>
	 * @param color
	 *            Color del nodo. <br>
	 * @return true si se puede colorear, false de lo contrario. <br>
	 */
	private boolean sePuedeColorear(final int pos, final int color) {
		int i = 0;
		if (this.nodos[pos].getColor() != 0) {
			return false;
		}
		while (i < this.cantidadNodos) {
			if (nodos[i].getColor() == color) {
				if (esAdyacente(this.nodos[i], this.nodos[pos])) {
					return false;
				}
			}
			i++;
		}
		return true;
	}

	/**
	 * Colorea un gráfo utilizando el algoritmo de coloración de Nelsh-Powell.
	 * <br>
	 */
	private void colorearPowell() {
		ordenarGradoMayorAMenor(nodos, 0, nodos.length - 1);
		colorear();
	}

	/**
	 * Colorea un gráfo utilizando el algoritmo de coloración de Matula. <br>
	 */
	private void colorearMatula() {
		ordenarGradoMenorAMayor(nodos, 0, nodos.length - 1);
		colorear();
	}

	/**
	 * Colorea el nodo de utilizando una secuencia aleatoria. <br>
	 */
	private void colorearSecuencialAleatorio() {
		colorear();
	}

	/**
	 * Ordena la lista de nodos de mayor a menor. <br>
	 * 
	 * @param nodo
	 *            Lista de nodos. <br>
	 * @param izq
	 *            Primer nodo. <br>
	 * @param der
	 *            Último nodo. <br>
	 */
	private void ordenarGradoMenorAMayor(Nodo[] nodo, int izq, int der) {
		Nodo pivote = new Nodo(nodo[(izq + der) / 2]);
		int i = izq, d = der;
		do {
			while ((nodo[i].compararGrados(pivote) < 0)) {
				i++;
			}
			while ((nodo[d].compararGrados(pivote) > 0)) {
				d--;
			}
			if (i <= d) {
				nodo[i].intercambiar(nodo[d]);
				i++;
				d--;
			}
		} while (i <= d);
		if (izq < d) {
			ordenarGradoMenorAMayor(nodo, izq, d);
		}
		if (i < der) {
			ordenarGradoMenorAMayor(nodo, i, der);
		}
	}

	/**
	 * Ordena la lista de nodos de mayor a menor. <br>
	 * 
	 * @param nodo
	 *            Lista de nodos. <br>
	 * @param izq
	 *            Primer nodo del vector. <br>
	 * @param der
	 *            Último nodo del vector. <br>
	 */
	private void ordenarGradoMayorAMenor(Nodo nodo[], int izq, int der) {
		Nodo pivote = new Nodo(nodo[(izq + der) / 2]);
		int i = izq, d = der;
		do {
			while ((nodo[i].compararGrados(pivote) > 0)) {
				i++;
			}
			while ((nodo[d].compararGrados(pivote) < 0)) {
				d--;
			}
			if (i <= d) {
				nodo[i].intercambiar(nodo[d]);
				i++;
				d--;
			}
		} while (i <= d);
		if (izq < d) {
			ordenarGradoMayorAMenor(nodo, izq, d);
		}
		if (i < der) {
			ordenarGradoMayorAMenor(nodo, i, der);
		}
	}

	/**
	 * Indica si un nodo es adyacente a otro. <br>
	 * 
	 * @param nodoUno
	 *            Primer nodo. <br>
	 * @param nodoDos
	 *            Segúndo nodo. <br>
	 * @return true si es adyacente, false de lo contrario. <br>
	 */
	private boolean esAdyacente(Nodo nodoUno, Nodo nodoDos) {
		return this.matrizAdyacencia[nodoUno.getNumero()][nodoDos.getNumero()] == true;
	}

	/**
	 * Muestra el algoritmo utilizado y la cantidad de colores que se necesito
	 * para colorearlo. <br>
	 */
	public void mostrarResultado() {
		if (this.algoritmo == Recorrido.SECAL.name()) {
			System.out.println("Algoritmo: Secuencial aleatorio");
		}
		if (this.algoritmo == Recorrido.WELSHPOW.name()) {
			System.out.println("Algoritmo: Welsh-Powell");
		}
		if (this.algoritmo == Recorrido.MATULA.name()) {
			System.out.println("Algoritmo: Matula");
		}
		System.out.println("Cantidad de colores: " + this.cantidadColores);
		System.out.print("\n");
	}
}
