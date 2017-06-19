package algoritmo;

public class Dijsktra {
	private int[][] matrizAdy;
	private boolean[] visitados;
	private int[] costos;
	private int nodoActual;
	private int cantidadDeNodos;
	private int[] ruta;

	public Dijsktra(int[][] matAdy, int nodoInicio, int cantNodos) {
		this.matrizAdy = matAdy;
		this.nodoActual = nodoInicio;
		this.cantidadDeNodos = cantNodos;
		this.visitados = new boolean[cantNodos];
		this.costos = new int[cantNodos];
		this.ruta = new int[cantNodos];
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

	public void ruta(int destino) {
		System.out.println(destino);
		while (ruta[destino] != 0) {
			System.out.println(ruta[destino]);
			destino = ruta[destino];
		}
		System.out.println(ruta[destino]);
	}

}
