package algoritmo;

public class Floyd {

	public static void algoritmoFloyd(int[][] matrizAdy) {
		int cantPos = matrizAdy.length;
		for (int k = 0; k < cantPos; k++) {
			for (int i = 0; i < cantPos; i++) {
				for (int j = 0; j < cantPos; j++) {
					if (matrizAdy[i][k] != Integer.MAX_VALUE && matrizAdy[k][j] != Integer.MAX_VALUE
							&& Math.min(matrizAdy[i][j], matrizAdy[i][k] + matrizAdy[k][j]) != matrizAdy[i][j]) {
						matrizAdy[i][j] = matrizAdy[i][k] + matrizAdy[k][j];
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] mat = { { 0, 8, Integer.MAX_VALUE }, { Integer.MAX_VALUE, 0, 2 },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, 0 } };
		algoritmoFloyd(mat);
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.print(System.lineSeparator());
		}
	}
}
