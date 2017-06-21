package algoritmo;

import org.junit.Before;
import org.junit.Test;

import matriz.MatrizAdyacencia;
import matriz.MatrizDirigido;

public class TestWarshall {
	private int matriz[][];
	private static final int TAMAÑO = 4;
	private static final int RANDOM = 2;
	private MatrizAdyacencia matrizDirigido;

	@Before
	public void iniciar() {
		matrizDirigido = new MatrizDirigido(TAMAÑO, RANDOM);
		matriz = matrizDirigido.getMatriz();
	}

	@Test
	public void test() {
		matrizDirigido.mostarMatriz();
		Warshall matrizFloyd = new Warshall(matriz);
		matrizFloyd.mostarMatriz();
	}
}
