package coloreo;

import org.junit.Before;
import org.junit.Test;

import matriz.MatrizNoPonderadoNoDirigido;

public class TestColoreo {
	private int matriz[][];
	private MatrizNoPonderadoNoDirigido matrizNoPonderadaNoDirigida = new MatrizNoPonderadoNoDirigido(TAMAÑO);
	private Coloreo coloreo;
	private static final int TAMAÑO = 8;

	@Before
	public void iniciar() {
		this.matriz = this.matrizNoPonderadaNoDirigida.getMatriz();
	}

	@Test
	public void testMatula() {
		this.matrizNoPonderadaNoDirigida.mostarMatriz();
		this.coloreo = new Coloreo(this.matriz, Recorrido.MATULA.name());
		this.coloreo.mostrarResultado();
	}

	@Test
	public void testWellshPowell() {
		this.matrizNoPonderadaNoDirigida.mostarMatriz();
		this.coloreo = new Coloreo(this.matriz, Recorrido.WELSHPOW.name());
		this.coloreo.mostrarResultado();
	}

	@Test
	public void testSecuencialAleatorio() {
		this.matrizNoPonderadaNoDirigida.mostarMatriz();
		this.coloreo = new Coloreo(this.matriz, Recorrido.SECAL.name());
		this.coloreo.mostrarResultado();
	}
}
