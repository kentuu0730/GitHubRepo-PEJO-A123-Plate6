package PLATE6;

import java.util.*;

public class Problem4 {
    private Map<Integer, Integer> Pejo_vertexDegrees;

    // Constructor to initialize the vertex degree map
    public Problem4() {
        this.Pejo_vertexDegrees = new HashMap<>();
    }

    // Method to add an edge and update the degree of vertices
    public void Pejo_addEdge(int Pejo_v, int Pejo_w) {
        Pejo_vertexDegrees.put(Pejo_v, Pejo_vertexDegrees.getOrDefault(Pejo_v, 0) + 1);
        Pejo_vertexDegrees.put(Pejo_w, Pejo_vertexDegrees.getOrDefault(Pejo_w, 0) + 1);
    }

    // Method to display the degree of each vertex
    public void Pejo_displayDegrees() {
        for (Map.Entry<Integer, Integer> Pejo_entry : Pejo_vertexDegrees.entrySet()) {
            System.out.println("Degree of vertex " + Pejo_entry.getKey() + " is " + Pejo_entry.getValue());
        }
    }

    // Main method to execute the program
    public static void main(String[] Pejo_args) {
        Scanner Pejo_scanner = new Scanner(System.in);
        Problem4 Pejo_graph = new Problem4();

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

        Pejo_graph.Pejo_displayDegrees();
        Pejo_scanner.close();
    }
}
