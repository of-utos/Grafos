package coloreo;

import org.junit.Before;
import org.junit.Test;

import matriz.MatrizNoDirigido;

public class TestColoreo {
	private int matriz[][];
	private MatrizNoDirigido matrizNoDirigido = new MatrizNoDirigido(TAMAÑO);
	private Coloreo coloreo;
	private static final int TAMAÑO = 8;

	@Before
	public void iniciar() {
		this.matriz = this.matrizNoDirigido.getMatriz();
	}

	@Test
	public void testMatula() {
		this.matrizNoDirigido.mostarMatriz();
		this.coloreo = new Coloreo(this.matriz, Condicion.MATULA.name());
		this.coloreo.mostrarResultado();
	}

	@Test
	public void testWellshPowell() {
		this.matrizNoDirigido.mostarMatriz();
		this.coloreo = new Coloreo(this.matriz, Condicion.WELSHPOW.name());
		this.coloreo.mostrarResultado();
	}

	@Test
	public void testSecuencialAleatorio() {
		this.matrizNoDirigido.mostarMatriz();
		this.coloreo = new Coloreo(this.matriz, Condicion.SECAL.name());
		this.coloreo.mostrarResultado();
	}
}
