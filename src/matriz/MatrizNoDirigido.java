package matriz;

/**
 * Clase que administra la matriz de adyacencia de un grafo no dirigido. <br>
 */
public class MatrizNoDirigido extends MatrizAdyacencia {

	/**
	 * Crea una matriz de adyacencia de un grafo no dirigido con valores random.
	 * <br>
	 * 
	 * @param tamaño
	 *            Tamaño de la matriz. <br>
	 * @param random
	 *            Valor límite para el random. <br>
	 */
	public MatrizNoDirigido(final int tamaño, final int random) {
		super(tamaño, random);
		for (int i = 0; i < super.getTamaño(); i++) {
			for (int j = 0; j < super.getTamaño(); j++) {
				cargarValorMatriz(super.getRandom(), i, j);
			}
		}
	}

	@Override
	protected void cargarValorMatriz(int valor, int fila, int columna) {
		if (super.getValorMatriz(fila, columna) != Integer.MAX_VALUE) {
			if (valor == 0 || fila == columna) {
				super.setValorMatriz(fila, columna, Integer.MAX_VALUE);
				super.setValorMatriz(columna, fila, Integer.MAX_VALUE);
			} else {
				super.setValorMatriz(fila, columna, valor);
				super.setValorMatriz(columna, fila, valor);
			}
		}
	}
}