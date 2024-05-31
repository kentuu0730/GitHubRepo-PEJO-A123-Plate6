package PLATE6;

import java.util.Scanner;

public class Problem6 {
    private int[][] Pejo_adjacencyMatrix;
    private int Pejo_vertices;

    // Constructor to initialize the graph
    public Problem6(int Pejo_vertices) {
        this.Pejo_vertices = Pejo_vertices;
        Pejo_adjacencyMatrix = new int[Pejo_vertices][Pejo_vertices];
    }

    // Method to add an edge to the graph
    public void Pejo_addEdge(int Pejo_from, int Pejo_to) {
        Pejo_adjacencyMatrix[Pejo_from][Pejo_to] += 1; // Increment the value to handle multiple edges and loops
    }

    // Method to print the adjacency matrix
    public void Pejo_printAdjacencyMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < Pejo_vertices; i++) {
            for (int j = 0; j < Pejo_vertices; j++) {
                System.out.print(Pejo_adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Main method to execute the program
    public static void main(String[] Pejo_args) {
        Scanner Pejo_scanner = new Scanner(System.in);

        // Input validation for number of vertices
        int Pejo_vertices = -1;
        while (Pejo_vertices <= 0) {
            System.out.print("Enter the number of vertices (positive integer): ");
            if (Pejo_scanner.hasNextInt()) {
                Pejo_vertices = Pejo_scanner.nextInt();
                if (Pejo_vertices <= 0) {
                    System.out.println("Number of vertices must be a positive integer.");
                }
            } else {
                System.out.println("Invalid input. Please enter a positive integer.");
                Pejo_scanner.next(); // Clear the invalid input
            }
        }

        Problem6 Pejo_graph = new Problem6(Pejo_vertices);

        // Input validation for number of edges
        int Pejo_edges = -1;
        while (Pejo_edges < 0) {
            System.out.print("Enter the number of edges (non-negative integer): ");
            if (Pejo_scanner.hasNextInt()) {
                Pejo_edges = Pejo_scanner.nextInt();
                if (Pejo_edges < 0) {
                    System.out.println("Number of edges must be a non-negative integer.");
                }
            } else {
                System.out.println("Invalid input. Please enter a non-negative integer.");
                Pejo_scanner.next(); // Clear the invalid input
            }
        }

        // Input for edges
        System.out.println("Enter the edges (format: from to):");
        for (int i = 0; i < Pejo_edges; i++) {
            int Pejo_from = -1, Pejo_to = -1;
            boolean validEdge = false;

            while (!validEdge) {
                if (Pejo_scanner.hasNextInt()) {
                    Pejo_from = Pejo_scanner.nextInt();
                    if (Pejo_from >= 0 && Pejo_from < Pejo_vertices && Pejo_scanner.hasNextInt()) {
                        Pejo_to = Pejo_scanner.nextInt();
                        if (Pejo_to >= 0 && Pejo_to < Pejo_vertices) {
                            validEdge = true;
                        } else {
                            System.out.println("Invalid input. Please enter valid integers for vertices.");
                            Pejo_scanner.nextLine(); // Clear the line for the next input
                        }
                    } else {
                        System.out.println("Invalid input. Please enter valid integers for vertices.");
                        Pejo_scanner.nextLine(); // Clear the line for the next input
                    }
                } else {
                    System.out.println("Invalid input. Please enter valid integers for vertices.");
                    Pejo_scanner.next(); // Clear the invalid input
                }
            }

            Pejo_graph.Pejo_addEdge(Pejo_from, Pejo_to);
        }

        Pejo_graph.Pejo_printAdjacencyMatrix();
        Pejo_scanner.close();
    }
}
