package recorrido;

/**
 * Clase que crea aristas entre nodos.
 * <p>
 * Las aristas pueden tener peso o no.<br>
 *
 */
public class Nodo {
	/**
	 * Nodo origen. <br>
	 */
	private int nodoInicio;
	/**
	 * Nodo fin. <br>
	 */
	private int nodoFin;
	/**
	 * Costo entre los nodos. <br>
	 */
	private int costo;
	/**
	 * 
	 */
	private int numeroArista;

	/**
	 * Crea una arista sin costo entre nodos. <br>
	 * 
	 * @param nodoInicio
	 *            Nodo inicio. <br>
	 * @param nodoFin
	 *            Nodo fin. <br>
	 */
	public Nodo(final int nodoInicio, final int nodoFin, final int numeroArista) {
		this.nodoInicio = nodoInicio;
		this.nodoFin = nodoFin;
		this.numeroArista = numeroArista;
	}

	/**
	 * Crea una arista entre nodos. <br>
	 * 
	 * @param nodoInicio
	 *            Nodo inicio. <br>
	 * @param nodoFin
	 *            Nodo fin. <br>
	 * @param costo
	 *            Costo de la arista. <br>
	 * @param numeroArista
	 *            Número de arista. <br>
	 */
	public Nodo(final int nodoInicio, final int nodoFin, final int costo, final int numeroArista) {
		this.nodoInicio = nodoInicio;
		this.nodoFin = nodoFin;
		this.costo = costo;
		this.numeroArista = numeroArista;
	}

	public double calculaDistancia(Nodo g) {
		if (this.getNodoInicio() <= g.getNodoInicio() && this.getNodoFin() <= g.getNodoFin()) {
			return Math.sqrt(
					Math.pow(g.getNodoInicio() - this.nodoInicio, 2) + Math.pow(g.getNodoFin() - this.nodoFin, 2));
		}
		return Integer.MAX_VALUE;
	}

	/**
	 * Devuelve el nodo de inicio. <br>
	 * 
	 * @return Nodo de inicio. <br>
	 */
	public int getNodoInicio() {
		return nodoInicio;
	}

	public void setNodoInicio(final int posX) {
		this.nodoInicio = posX;
	}

	/**
	 * Devuelve el nodo fin. <br>
	 * 
	 * @return Nodo fin. <br>
	 */
	public int getNodoFin() {
		return nodoFin;
	}

	public void setNodoFin(final int posY) {
		this.nodoFin = posY;
	}

	/**
	 * Devuelve el costo de una arista. <br>
	 * 
	 * @return Costo de la arista. <br>
	 */
	public int getCosto() {
		return costo;
	}

	/**
	 * Devuelve el número de arista. <br>
	 * 
	 * @return Número de arista. <br>
	 */
	public int getNumeroArista() {
		return numeroArista;
	}
}