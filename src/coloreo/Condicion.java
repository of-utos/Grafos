package coloreo;

/**
 * Condición de coloreo de un grafo. <br>
 */
public enum Condicion {
	/**
	 * Colorea utilizando el algoritmo de coloreo de Matula. <br>
	 */
	MATULA,
	/**
	 * Colorea utilizando el algoritmo de coloreo de Welsh-Powell. <br>
	 */
	WELSHPOW,
	/**
	 * Colorea utilizando el algoritmo secuencial aleatorio. <br>
	 */
	SECAL;
}
