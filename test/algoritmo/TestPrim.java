package algoritmo;

import org.junit.Before;
import org.junit.Test;

import matriz.MatrizAdyacencia;
import matriz.MatrizNoDirigido;

public class TestPrim {
	private int matriz[][];
	private static final int TAMAÑO = 5;
	private static final int RANDOM = 5;
	private MatrizAdyacencia matrizDirigido;

	@Before
	public void iniciar() {
		matrizDirigido = new MatrizNoDirigido(TAMAÑO, RANDOM);
		matriz = matrizDirigido.getMatriz();
	}

	@Test
	public void test() {
		matrizDirigido.mostarMatriz();
		Prim prim = new Prim(matriz);
		prim.mostarResultado();
	}
}
