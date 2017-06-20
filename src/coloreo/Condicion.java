package coloreo;

/**
 * Condición de coloreo de un grafo. <br>
 */
public enum Condicion {
	/**
	 * Colorea utilizando el algoritmo de coloreo de Matula.
	 * <p>
	 * Empieza por el nodo de grado mínimo hasta llegar al de grado máximo. <br>
	 */
	MATULA,
	/**
	 * Colorea utilizando el algoritmo de coloreo de Welsh-Powell.
	 * <p>
	 * Empieza por el nodo de grado máximo hasta llegar al de grado mínimo. <br>
	 */
	WELSHPOW,
	/**
	 * Colorea utilizando el algoritmo secuencial aleatorio.
	 * <p>
	 * No tiene en cuenta el grado del nodo. <br>
	 */
	SECAL;
}
