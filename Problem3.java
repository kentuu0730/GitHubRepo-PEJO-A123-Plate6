package PLATE6;

import java.util.*;

public class Problem3 {
    private int Pejo_vertices;
    private LinkedList<Integer>[] Pejo_adjacencyList;

    // Constructor to initialize the graph
    public Problem3(int Pejo_vertices) {
        this.Pejo_vertices = Pejo_vertices;
        Pejo_adjacencyList = new LinkedList[Pejo_vertices];
        for (int i = 0; i < Pejo_vertices; i++) {
            Pejo_adjacencyList[i] = new LinkedList<>();
        }
    }

    // Method to add an edge to the graph
    public void Pejo_addEdge(int Pejo_v, int Pejo_w) {
        Pejo_adjacencyList[Pejo_v].add(Pejo_w);
        Pejo_adjacencyList[Pejo_w].add(Pejo_v);
    }

    // Method to detect if a cycle exists in the graph
    public boolean Pejo_isCyclic() {
        boolean[] Pejo_visited = new boolean[Pejo_vertices];
        for (int Pejo_i = 0; Pejo_i < Pejo_vertices; Pejo_i++) {
            if (!Pejo_visited[Pejo_i]) {
                if (Pejo_isCyclicUtil(Pejo_i, Pejo_visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Utility method for DFS traversal to detect a cycle
    private boolean Pejo_isCyclicUtil(int Pejo_v, boolean[] Pejo_visited, int Pejo_parent) {
        Pejo_visited[Pejo_v] = true;
        for (Integer Pejo_neighbour : Pejo_adjacencyList[Pejo_v]) {
            if (!Pejo_visited[Pejo_neighbour]) {
                if (Pejo_isCyclicUtil(Pejo_neighbour, Pejo_visited, Pejo_v)) {
                    return true;
                }
            } else if (Pejo_neighbour != Pejo_parent) {
                return true;
            }
        }
        return false;
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
        
        Problem3 Pejo_graph = new Problem3(Pejo_vertices);

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

        System.out.println("Enter the edges (format: from to):");
        for (int i = 0; i < Pejo_edges; i++) {
            int Pejo_v = -1, Pejo_w = -1;
            boolean validEdge = false;
            while (!validEdge) {
                if (Pejo_scanner.hasNextInt()) {
                    Pejo_v = Pejo_scanner.nextInt();
                    if (Pejo_v >= 0 && Pejo_v < Pejo_vertices) {
                        if (Pejo_scanner.hasNextInt()) {
                            Pejo_w = Pejo_scanner.nextInt();
                            if (Pejo_w >= 0 && Pejo_w < Pejo_vertices) {
                                validEdge = true;
                            } else {
                                System.out.println("Invalid vertex index. Please enter valid vertex indices (0 to " + (Pejo_vertices - 1) + ").");
                                Pejo_scanner.nextLine(); // Clear the invalid input
                            }
                        } else {
                            System.out.println("Invalid vertex index. Please enter valid vertex indices (0 to " + (Pejo_vertices - 1) + ").");
                            Pejo_scanner.next(); // Clear the invalid input
                        }
                    } else {
                        System.out.println("Invalid vertex index. Please enter valid vertex indices (0 to " + (Pejo_vertices - 1) + ").");
                        Pejo_scanner.next(); // Clear the invalid input
                    }
                } else {
                    System.out.println("Invalid vertex index. Please enter valid vertex indices (0 to " + (Pejo_vertices - 1) + ").");
                    Pejo_scanner.next(); // Clear the invalid input
                }
            }
            Pejo_graph.Pejo_addEdge(Pejo_v, Pejo_w);
        }

        // Check if the graph contains a cycle and print the result
        if (Pejo_graph.Pejo_isCyclic()) {
            System.out.println("Graph contains a cycle.");
        } else {
            System.out.println("Graph does not contain a cycle.");
        }

        Pejo_scanner.close();
    }
}
