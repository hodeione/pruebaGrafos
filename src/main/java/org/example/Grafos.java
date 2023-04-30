package org.example;
import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

public class Grafos {
    static Graph<Barco, DefaultWeightedEdge> grafo = new DefaultDirectedWeightedGraph<>(DefaultWeightedEdge.class);
    public static void main(String[] args) {
        //Ejemplo de ayuda
        // Crear ciudades
        Barco barco1 = new Barco("Mery", 100000,50,100);
        Barco barco2 = new Barco("barco2", 200000,55,45);
        Barco barco3 = new Barco("barco3", 300000,70,200);

        // Crear grafo

        // Añadir vértices
        grafo.addVertex(barco1);
        grafo.addVertex(barco2);
        grafo.addVertex(barco3);

        // Añadir aristas con pesos
        DefaultWeightedEdge arista1 = grafo.addEdge(barco1, barco2);
        grafo.setEdgeWeight(arista1, 150);
        DefaultWeightedEdge arista2 = grafo.addEdge(barco2, barco3);
        grafo.setEdgeWeight(arista2, 100);
        DefaultWeightedEdge arista3 = grafo.addEdge(barco3, barco1);
        grafo.setEdgeWeight(arista3, 300);

        // Imprimir información del grafo solo el dirigido y no al que pertenece
        System.out.println("Direccion del grafo que hemos predefinido nosotros\n");
        for (Barco barco : grafo.vertexSet()) {

            System.out.println("Vértice: " + barco.getNombre());
            System.out.println("Aristas:");
            for (DefaultWeightedEdge arista : grafo.edgesOf(barco)) {
                Barco barcoOrigen = grafo.getEdgeSource(arista);
                if (barcoOrigen == barco){
                    Barco barcoFin = grafo.getEdgeTarget(arista);
                    double peso = grafo.getEdgeWeight(arista);
                    System.out.println("  Desde " + barcoOrigen.getNombre() +
                            " hasta " + barcoFin.getNombre() +
                            " con peso " + peso);
                }
            }
            System.out.println();
        }

        System.out.println("----------------------------------");
        System.out.println("----------------------------------");
        System.out.println("aristas a las que pertenece cada vertice\n");
        for (Barco barco : grafo.vertexSet()) {

            System.out.println("Vértice: " + barco.getNombre());
            System.out.println("Aristas:");
            for (DefaultWeightedEdge arista : grafo.edgesOf(barco)) {
                Barco barcoOrigen = grafo.getEdgeSource(arista);
                    Barco barcoFin = grafo.getEdgeTarget(arista);
                    double peso = grafo.getEdgeWeight(arista);
                    System.out.println("  Desde " + barcoOrigen.getNombre() +
                            " hasta " + barcoFin.getNombre() +
                            " con peso " + peso);
            }
            System.out.println();
        }
    }

}