package algoritmo;

import org.junit.Before;
import org.junit.Test;

import matriz.MatrizAdyacencia;
import matriz.MatrizDirigido;

public class TestFloyd {

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
		Floyd matrizFloyd = new Floyd(matriz);
		matrizFloyd.mostarMatriz();
	}
}
