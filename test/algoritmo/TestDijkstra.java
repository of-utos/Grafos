package algoritmo;

import org.junit.Before;
import org.junit.Test;

import matriz.MatrizAdyacencia;
import matriz.MatrizDirigido;

public class TestDijkstra {

	private int matriz[][];
	private static final int TAMAÑO = 5;
	private static final int RANDOM = 8;
	private MatrizAdyacencia matrizDirigido;

	@Before
	public void iniciar() {
		matrizDirigido = new MatrizDirigido(TAMAÑO, RANDOM);
		// matriz = matrizDirigido.getMatriz();
		int[][] casoForzado = { { 0, 100, 30, 20, 0 }, { 0, 0, 0, 0, 0 }, { 0, 10, 0, 0, 10 }, { 0, 0, 0, 0, 0 },
				{ 0, 30, 0, 40, 0 } };
		matriz = casoForzado;
		matrizDirigido.setMatriz(casoForzado);
	}

	@Test
	public void test() {
		matrizDirigido.mostarMatriz();
		Dijsktra matrizDijkstra = new Dijsktra(matriz, 2);
		matrizDijkstra.algoritmoDijsktra();
		matrizDijkstra.ruta(3);
	}
}