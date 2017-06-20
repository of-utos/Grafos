package matriz;

/**
 * Crea una matriz de adyacencia de un grafo dirigido. <br>
 */
public class MatrizDirigido extends MatrizAdyacencia {

	/**
	 * Genera una matriz de adyacencia con valores random. <br>
	 * 
	 * @param tamaño 
	 *            Tamaño de la matriz. <br>
	 * @param random
	 *            Número random de rango. <br>
	 */
	public MatrizDirigido(final int tamaño, final int random) {
		super(tamaño, random);
		for (int i = 0; i < super.getTamaño(); i++) {
			for (int j = 0; j < super.getTamaño(); j++) {
				cargarValorMatriz(super.getRandom(), i, j);
			}
		}
	}

	@Override
	public void cargarValorMatriz(final int valor, final int fila, final int columna) {
		if (super.getValorMatriz(fila, columna) != Integer.MAX_VALUE) {
			if (valor == 0 || fila == columna) {
				super.setValorMatriz(fila, columna, Integer.MAX_VALUE);
			} else {
				super.setValorMatriz(fila, columna, valor);
				super.setValorMatriz(columna, fila, Integer.MAX_VALUE);
			}
		} else {
			super.setValorMatriz(fila, columna, Integer.MAX_VALUE);
		}
	}
}
