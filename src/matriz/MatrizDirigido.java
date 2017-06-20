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
	 *            Número random de tolerancia. <br>
	 */
	public MatrizDirigido(final int tamaño, final int random) {
		super(tamaño, random);
		for (int i = 0; i < super.getTamaño(); i++) {
			for (int j = 0; j < super.getTamaño(); j++) {
				super.setValorMatrizDirigido(super.getRandom(), i, j);
			}
		}
	}
}
