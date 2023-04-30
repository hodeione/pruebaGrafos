package org.example;

import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.example.Grafos.grafo;

public class Main {
    public static void main(String[] args) {
        int opcio;
        Scanner sc = new Scanner(System.in);
        do {
            opcio = 0;
            System.out.println("1. Crear barco y añadir al grafo");
            System.out.println("2. Crear arista entrre los barcos");
            System.out.println("3. Mostrar grafo");
            System.out.println("4. Salir");
            opcio = sc.nextInt();

            switch (opcio) {
                case 1:
                    creaBarcos();
                    break;
                case 2:
                    creaArista();
                    break;
                case 3:
                    mostrarGrafo();
                    break;
                case 4:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }


        } while (opcio != 4);
    }

    public static void creaBarcos() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Creando barco");
            System.out.println("Dime el nombre del barco");
            String nombre = sc.nextLine();
            System.out.println("Dime la capacidad del barco");
            int capacidad = sc.nextInt();
            System.out.println("Dime la tripulacion del barco");
            int tripulacion = sc.nextInt();
            System.out.println("Dime la velocidad del barco");
            double velocidad = sc.nextDouble();
            Barco barco = new Barco(nombre, capacidad, tripulacion, velocidad);
            grafo.addVertex(barco);
        } catch (InputMismatchException e) {
            System.out.println("Error: entrada no válida. " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void creaArista() {
        try {
            if (grafo.vertexSet().size() < 2) {
                System.out.println("No hay suficientes barcos para crear una arista");
            } else {
                Scanner sc = new Scanner(System.in);
                System.out.println("Dime el nombre del barco origen");
                String nombreOrigen = sc.nextLine();
                System.out.println("Dime el nombre del barco destino");
                String nombreDestino = sc.nextLine();
                System.out.println("Dime el peso de la arista");
                double peso = sc.nextDouble();
                Barco barcoOrigen = null;
                Barco barcoDestino = null;
                for (Barco barco : grafo.vertexSet()) {
                    if (barco.getNombre().equals(nombreOrigen)) {
                        barcoOrigen = barco;
                    }
                    if (barco.getNombre().equals(nombreDestino)) {
                        barcoDestino = barco;
                    }
                }
                if (barcoOrigen == null || barcoDestino == null) {
                    System.out.println("No se ha encontrado alguno de los barcos");
                } else {
                    DefaultWeightedEdge arista = grafo.addEdge(barcoOrigen, barcoDestino);
                    grafo.setEdgeWeight(arista, peso);
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: entrada no válida. " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void mostrarGrafo() {
        try {
            System.out.println("Direccion del grafo que hemos predefinido nosotros\n");
            for (Barco barco : grafo.vertexSet()) {
                System.out.println("Vértice: " + barco.getNombre());
                System.out.println("Aristas:");
                for (DefaultWeightedEdge arista : grafo.edgesOf(barco)) {
                    Barco barcoOrigen = grafo.getEdgeSource(arista);
                    if (barcoOrigen == barco) {
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
        }catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}