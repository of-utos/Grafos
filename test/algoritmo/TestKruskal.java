package algoritmo;

import org.junit.Before;
import org.junit.Test;

import matriz.MatrizAdyacencia;
import matriz.MatrizNoDirigido;

public class TestKruskal {
	private int matriz[][];
	private static final int TAMAÑO = 7;
	private static final int RANDOM = 10;
	private MatrizAdyacencia matrizDirigido;

	@Before
	public void iniciar() {
		matrizDirigido = new MatrizNoDirigido(TAMAÑO, RANDOM);
		// matriz = matrizDirigido.getMatriz();
		int[][] casoForzado = { { 0, 2, 4, 1, 0, 0, 0 }, { 2, 0, 0, 3, 10, 0, 0 }, { 4, 0, 0, 2, 0, 5, 0 },
				{ 1, 3, 2, 0, 7, 8, 4 }, { 0, 10, 0, 7, 0, 0, 6 }, { 0, 0, 5, 8, 0, 0, 1 }, { 0, 0, 0, 4, 6, 1, 0 } };
		for (int i = 0; i < casoForzado.length; i++) {
			for (int j = 0; j < casoForzado.length; j++) {
				if (casoForzado[i][j] == 0) {
					casoForzado[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		matriz = casoForzado;
		matrizDirigido.setMatriz(casoForzado);
	}

	@Test
	public void test() {
		matrizDirigido.mostarMatriz();
		Kruskal kruskal = new Kruskal(matriz);
		kruskal.mostarResultado();
	}
}
