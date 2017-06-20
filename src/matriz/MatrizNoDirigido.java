package matriz;

/**
 * Crea una matriz de adyacencia de un grafo no dirigido. <br>
 */
public class MatrizNoDirigido extends MatrizAdyacencia {

	public MatrizNoDirigido(final int tamaño) {
		super(tamaño, 5);
		for (int i = 0; i < super.getTamaño(); i++) {
			for (int j = 0; j < super.getTamaño(); j++) {
				cargarValorMatriz(super.getRandom(), i, j);
			}
		}
	}

	@Override
	public void cargarValorMatriz(int valor, int fila, int columna) {
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

	/**
	 * Muestra el contenido de la matriz. <br>
	 */
	@Override
	public void mostarMatriz() {
		System.out.println("Matriz de adyacencia:\n");
		System.out.print(" ");
		for (int v = 0; v < super.getTamaño(); v++) {
			System.out.print("   " + (v + 1));
		}
		System.out.println();
		for (int v = 0; v < super.getTamaño(); v++) {
			System.out.print((v + 1) + " ");
			for (int w = 0; w < super.getTamaño(); w++) {
				if (super.getValorMatriz(v, w) != Integer.MAX_VALUE) {
					System.out.print("  1 ");
				} else {
					System.out.print("  " + '\u221e' + " ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}