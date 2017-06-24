package matriz;

/**
 * Clase que administra la matriz de adyacencia de un grafo no ponderado y no
 * dirigido. <br>
 */
public class MatrizNoPonderadoNoDirigido extends MatrizNoDirigido {
	/**
	 * Crea una matriz de adyacencia de un grafo no ponderado y no dirigido con
	 * valores random. <br>
	 * 
	 * @param tamaño
	 *            Tamaño de la matriz. <br>
	 */
	public MatrizNoPonderadoNoDirigido(final int tamaño) {
		super(tamaño, 5);
	}

	/**
	 * Muestra el contenido de la matriz. <br>
	 */
	@Override
	public void mostarMatriz() {
		System.out.println("Matriz de adyacencia:\n");
		System.out.print(" ");
		for (int v = 0; v < super.getTamaño(); v++) {
			System.out.print("\t" + (v + 1));
		}
		System.out.println();
		for (int v = 0; v < super.getTamaño(); v++) {
			System.out.print((v + 1));
			for (int w = 0; w < super.getTamaño(); w++) {
				if (super.getValorMatriz(v, w) != Integer.MAX_VALUE) {
					System.out.print("\t1");
				} else {
					System.out.print("\t" + '\u221e');
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}
