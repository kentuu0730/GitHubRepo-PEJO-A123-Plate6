package PLATE6;

import java.util.*;

public class Problem5 {
    private int Pejo_vertices;
    private List<Integer>[] Pejo_adjacencyList;

    public Problem5(int Pejo_vertices) {
        this.Pejo_vertices = Pejo_vertices;
        Pejo_adjacencyList = new ArrayList[Pejo_vertices];
        for (int i = 0; i < Pejo_vertices; i++) {
            Pejo_adjacencyList[i] = new ArrayList<>();
        }
    }

    public void Pejo_addEdge(int Pejo_v, int Pejo_w) {
        Pejo_adjacencyList[Pejo_v].add(Pejo_w);
        Pejo_adjacencyList[Pejo_w].add(Pejo_v);
    }

    public boolean Pejo_isBipartite() {
        int[] Pejo_colors = new int[Pejo_vertices];
        Arrays.fill(Pejo_colors, -1); // -1 indicates that no color has been assigned yet

        for (int Pejo_start = 0; Pejo_start < Pejo_vertices; Pejo_start++) {
            if (Pejo_colors[Pejo_start] == -1) { // Not colored
                if (!Pejo_isBipartiteUtil(Pejo_start, Pejo_colors)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean Pejo_isBipartiteUtil(int Pejo_v, int[] Pejo_colors) {
        Queue<Integer> Pejo_queue = new LinkedList<>();
        Pejo_queue.add(Pejo_v);
        Pejo_colors[Pejo_v] = 1; // Start coloring with 1

        while (!Pejo_queue.isEmpty()) {
            int Pejo_current = Pejo_queue.poll();

            for (int Pejo_neighbor : Pejo_adjacencyList[Pejo_current]) {
                if (Pejo_colors[Pejo_neighbor] == -1) { // If not colored
                    Pejo_colors[Pejo_neighbor] = 1 - Pejo_colors[Pejo_current]; // Assign alternate color
                    Pejo_queue.add(Pejo_neighbor);
                } else if (Pejo_colors[Pejo_neighbor] == Pejo_colors[Pejo_current]) { // If same color as current
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] Pejo_args) {
        Scanner Pejo_scanner = new Scanner(System.in);

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

        Problem5 Pejo_graph = new Problem5(Pejo_vertices);

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
                    if (Pejo_scanner.hasNextInt()) {
                        Pejo_w = Pejo_scanner.nextInt();
                        validEdge = true;
                    } else {
                        System.out.println("Invalid input. Please enter valid integers for vertices.");
                        Pejo_scanner.next(); // Clear the invalid input
                    }
                } else {
                    System.out.println("Invalid input. Please enter valid integers for vertices.");
                    Pejo_scanner.next(); // Clear the invalid input
                }
            }
            Pejo_graph.Pejo_addEdge(Pejo_v, Pejo_w);
        }

        if (Pejo_graph.Pejo_isBipartite()) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }

        Pejo_scanner.close();
    }
}
