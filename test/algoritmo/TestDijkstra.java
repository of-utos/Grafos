package algoritmo;

import org.junit.Before;
import org.junit.Test;

import matriz.MatrizAdyacencia;
import matriz.MatrizDirigido;

public class TestDijkstra {

	private int matriz[][];
	private static final int TAMAÑO = 5;
	private static final int RANDOM = 10;
	private MatrizAdyacencia matrizDirigido;

	@Before
	public void iniciar() {
		matrizDirigido = new MatrizDirigido(TAMAÑO, RANDOM);
		matriz = matrizDirigido.getMatriz();
	}

	@Test
	public void test() {
		matrizDirigido.mostarMatriz();
		Dijsktra matrizDijkstra = new Dijsktra(matriz,3);
		matrizDijkstra.resultado();
		matrizDijkstra.ruta(2);
	}
}