package recorrido;

public class TestBFS {

	public static void main(String args[]) {
		Nodo station1 = new Nodo(null, null);
		Nodo station2 = new Nodo(station1, null);
		Nodo station3 = new Nodo(station1, station2);
		Nodo station4 = new Nodo(station2, station3);
		Nodo station5 = new Nodo(station4, station3);
		Nodo station6 = new Nodo(station5, station4);

		BFS bfs = new BFS(station6, station1);

		if (bfs.caminoExistente()) {
			System.out.print("Existe el camino");
		}
	}
}