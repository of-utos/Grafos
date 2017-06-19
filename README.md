# Algoritmos de grafos

Se implementan los siguientes algoritmos de grafos: Dijkstra, Prim, Kruskal, Floyd, Warshall y coloreo.

## 1) Algoritmo de Dijkstra
El algoritmo de Dijkstra determina la ruta más corta desde un nodo origen hacia los demás nodos. Es necesario que el grafo tenga aristas que posean peso. Es el camino más corto según el peso de las aristas.

## 2) Algoritmo de Prim
El algoritmo de Prim encuentra un subconjunto de aristas que forman un árbol con todos los vértices, donde el peso total de todas las aristas en el árbol es el mínimo posible. Debe ser no dirigido.

## 3) Algoritmo de Kruskal
Encuentra un subconjunto de aristas que, formando un árbol, incluye todos los vértices y donde el valor total de todas las aristas del árbol es el mínimo. Busca las aristas de menor peso primero, hasta llegar a las de peso máximo. A partir de eso, construye el árbol. Se agregan al árbol aquellos nodos que no aparecen, se trata de evitar el camino cíclico.

## 4) Algoritmo de Floyd
Encuentra el camino mínimo en grafos dirigidos ponderados.

## 5) Algoritmo de Warshall
Indica si existe posibles uniones entre nodos, directa o indirectamente. No le interesa el costo ni el camino.
