import java.util.*;

public class Problem1 {
    private int Pejo_vertices;
    private LinkedList<Integer> Pejo_adjacencyList[];
    
    // Constructor to initialize the graph
    public Problem1(int Pejo_vertices) {
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
    
    // Utility method for checking connectivity
    private void checkConnectivity(int Pejo_v, boolean Pejo_visited[]) {
        Pejo_visited[Pejo_v] = true;
        for (int Pejo_n : Pejo_adjacencyList[Pejo_v]) {
            if (!Pejo_visited[Pejo_n]) {
                checkConnectivity(Pejo_n, Pejo_visited);
            }
        }
    }
    
    // Method to check if the graph is connected
    public boolean Pejo_isConnected() {
        boolean Pejo_visited[] = new boolean[Pejo_vertices];
        checkConnectivity(0, Pejo_visited); // Start connectivity check from the first vertex

        // Check if all vertices are visited
        for (int i = 0; i < Pejo_vertices; i++) {
            if (!Pejo_visited[i]) {
                return false;
            }
        }
        return true;
    }
    
    // Method to count the number of connected components
    public int Pejo_connectedComponents() {
        boolean Pejo_visited[] = new boolean[Pejo_vertices]; int Pejo_count = 0;

        // Perform connectivity check for each unvisited vertex and count components
        for (int i = 0; i < Pejo_vertices; i++) {
            if (!Pejo_visited[i]) {
                checkConnectivity(i, Pejo_visited);
                Pejo_count++;
            }
        }
        return Pejo_count;
    }
    
    // Main method to execute the program
    public static void main(String Pejo_args[]) {
        Scanner Pejo_scanner = new Scanner(System.in);
    
        System.out.print("Number of vertices: ");
        while (!Pejo_scanner.hasNextInt()) {
            System.out.print("Invalid. Please enter an integer for the number of vertices: ");
            Pejo_scanner.next();
        }

        int Pejo_vertices = Pejo_scanner.nextInt();
    
        System.out.print("Number of edges: ");
        while (!Pejo_scanner.hasNextInt()) {
            System.out.print("Invalid. Please enter an integer for the number of edges: ");
            Pejo_scanner.next(); } int Pejo_edges = Pejo_scanner.nextInt();
    
        Problem1 Pejo_graph = new Problem1(Pejo_vertices);
    
        System.out.println("Enter the edges in vertex v w format:");
        for (int i = 0; i < Pejo_edges; i++) {
            System.out.print("Edge " + (i + 1) + ": ");
            while (!Pejo_scanner.hasNextInt()) {
                System.out.print("Invalid. Please enter an integer for vertex v: ");
                Pejo_scanner.next();
            }
            int Pejo_v = Pejo_scanner.nextInt();
    
            while (!Pejo_scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter an integer for vertex w: ");
                Pejo_scanner.next();
            }
            int Pejo_w = Pejo_scanner.nextInt();
    
            Pejo_graph.Pejo_addEdge(Pejo_v, Pejo_w);
        }
    
        // Check if the graph is connected and print the result
        if (Pejo_graph.Pejo_isConnected()) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected.");
            System.out.println("The graph has " + Pejo_graph.Pejo_connectedComponents() + " connected components.");
        }
    
        Pejo_scanner.close();
    }
    
}
