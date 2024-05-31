package PLATE6;

import java.util.*;

public class Problem7 {
    private List<Map.Entry<Integer, Integer>> Pejo_edges;
    private int Pejo_vertices;

    public Problem7(int Pejo_vertices) {
        this.Pejo_vertices = Pejo_vertices;
        this.Pejo_edges = new ArrayList<>();
    }

    public void Pejo_addEdge(int Pejo_from, int Pejo_to, int Pejo_count) {
        // Add each edge 'count' times to the list of edges
        for (int i = 0; i < Pejo_count; i++) {
            this.Pejo_edges.add(new AbstractMap.SimpleEntry<>(Pejo_from, Pejo_to));
        }
    }

    public void Pejo_printIncidenceMatrix() {
        // Initialize the incidence matrix with the number of vertices and the total number of edge entries
        int[][] Pejo_incidenceMatrix = new int[Pejo_vertices][Pejo_edges.size()];

        // Fill the incidence matrix: each column represents an edge
        for (int i = 0; i < Pejo_edges.size(); i++) {
            Map.Entry<Integer, Integer> Pejo_edge = Pejo_edges.get(i);
            Pejo_incidenceMatrix[Pejo_edge.getKey()][i] = 1;
            Pejo_incidenceMatrix[Pejo_edge.getValue()][i] = 1;
        }

        // Print the incidence matrix
        System.out.println("Incidence Matrix:");
        for (int i = 0; i < Pejo_vertices; i++) {
            for (int j = 0; j < Pejo_edges.size(); j++) {
                System.out.print(Pejo_incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

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

        Problem7 Pejo_graph = new Problem7(Pejo_vertices);

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

        // Input for edges and their count
        System.out.println("Enter each edge with the number of times it appears (format: from to count):");
        for (int i = 0; i < Pejo_edges; i++) {
            int Pejo_from = -1, Pejo_to = -1, Pejo_count = -1;
            boolean validEdge = false;

            while (!validEdge) {
                if (Pejo_scanner.hasNextInt()) {
                    Pejo_from = Pejo_scanner.nextInt();
                    if (Pejo_from >= 0 && Pejo_from < Pejo_vertices && Pejo_scanner.hasNextInt()) {
                        Pejo_to = Pejo_scanner.nextInt();
                        if (Pejo_to >= 0 && Pejo_to < Pejo_vertices && Pejo_scanner.hasNextInt()) {
                            Pejo_count = Pejo_scanner.nextInt();
                            if (Pejo_count > 0) {
                                validEdge = true;
                            } else {
                                System.out.println("Count must be a positive integer.");
                                Pejo_scanner.nextLine(); // Clear the line for the next input
                            }
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

            Pejo_graph.Pejo_addEdge(Pejo_from, Pejo_to, Pejo_count);
        }

        Pejo_graph.Pejo_printIncidenceMatrix();
        Pejo_scanner.close();
    }
}
