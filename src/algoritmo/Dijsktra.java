package algoritmo;

/**
 * El grafo puede ser dirigido o no. El grafo debe ser ponderado. <br>
 */
public class Dijsktra {
	private int[][] matrizAdy;
	private boolean[] visitados;
	private int[] costos;
	private int nodoActual;
	private int cantidadDeNodos;
	private int[] ruta;

	public Dijsktra(final int[][] matAdy, final int nodoInicio) {
		this.matrizAdy = matAdy;
		this.nodoActual = nodoInicio;
		this.nodoActual--;
		this.cantidadDeNodos = matAdy.length;
		this.visitados = new boolean[this.cantidadDeNodos];
		this.costos = new int[this.cantidadDeNodos];
		this.ruta = new int[this.cantidadDeNodos];
	}

	public void algoritmoDijsktra() {
		valoresIniciales();
		visitados[nodoActual] = true;
		costos[nodoActual] = 0;
		for (int i = 0; i < cantidadDeNodos; i++) {
			int v = minimo();
			visitados[v] = true;
			for (int j = 0; j < cantidadDeNodos; j++) {
				if (!visitados[j]) {
					if ((costos[v] + matrizAdy[v][j]) < costos[j]) {
						costos[j] = costos[v] + matrizAdy[v][j];
						ruta[j] = v;
					}
				}
			}
		}
	}

	private int minimo() {
		int min = Integer.MAX_VALUE;
		int v = 1;
		for (int i = 0; i < cantidadDeNodos; i++) {
			if (!visitados[i] && costos[i] <= min) {
				min = costos[i];
				v = i;
			}
		}
		return v;
	}

	private void valoresIniciales() {
		for (int i = 0; i < cantidadDeNodos; i++) {
			visitados[i] = false;
			costos[i] = matrizAdy[nodoActual][i];
			ruta[i] = nodoActual;
		}
	}

	public void ruta(final int destino) {
		int i = destino;
		System.out.print(this.nodoActual);
		while (ruta[i] != this.nodoActual) {
			System.out.print(" -> " + (ruta[i] + 1));
			i = ruta[i];
		}
		System.out.print(" -> " + destino + "\n");
		System.out.println("Peso de la ruta: " + this.costos[destino]);
	}
}