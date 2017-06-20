package algoritmo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import utilidades.MatrizDirigido;

public class TestFloyd {

	private int matriz[][];
	private static final int TAMAÑO = 4;
	private static final int RANDOM = 3;
	private MatrizDirigido matrizDirigido;

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
