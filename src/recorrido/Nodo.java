package recorrido;

public class Nodo {
	int posX;
	int posY;
	int numero;

	public Nodo(int x, int y, int nombre) {
		this.numero = nombre;
		this.posX = x;
		this.posY = y;
	}

	public double calculaDistancia(Nodo g) {
		if (this.getPosX() <= g.getPosX() && this.getPosY() <= g.getPosY())
			return Math.sqrt(Math.pow(g.getPosX() - this.posX, 2) + Math.pow(g.getPosY() - this.posY, 2));
		return Integer.MAX_VALUE;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Nodo clone() {
		Nodo nuevo = new Nodo(this.posX, this.posY, this.numero);
		return nuevo;
	}

}