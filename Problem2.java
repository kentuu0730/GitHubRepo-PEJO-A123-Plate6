import java.util.*;

public class Problem2 {
    public static void main(String[] Pejo_args) {
        Scanner Pejo_scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        while (!Pejo_scanner.hasNextInt()) {
            System.out.print("Invalid. Please enter an integer for the number of vertices: ");
            Pejo_scanner.next();
        }
        int Pejo_vertices = Pejo_scanner.nextInt();
        
        int[][] Pejo_adjacencyMatrix = new int[Pejo_vertices][Pejo_vertices];
        Map<String, Integer> Pejo_edgeCount = new LinkedHashMap<>();

        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < Pejo_vertices; i++) {
            for (int j = 0; j < Pejo_vertices; j++) {
                while (!Pejo_scanner.hasNextInt()) {
                    System.out.print("Invalid. Please enter an integer for adjacency matrix element [" + i + "][" + j + "]: ");
                    Pejo_scanner.next();
                }
                Pejo_adjacencyMatrix[i][j] = Pejo_scanner.nextInt();
            }
        }

        // Processing the adjacency matrix
        for (int i = 0; i < Pejo_vertices; i++) {
            for (int j = 0; j < Pejo_vertices; j++) {
                if (Pejo_adjacencyMatrix[i][j] > 0) {
                    String Pejo_edge = "Edge " + i + "-" + j;
                    Pejo_edgeCount.put(Pejo_edge, Pejo_edgeCount.getOrDefault(Pejo_edge, 0) + Pejo_adjacencyMatrix[i][j]);
                }
            }
        }

        // Output the edges and their counts
        System.out.println("Edges and their counts:");
        for (Map.Entry<String, Integer> Pejo_entry : Pejo_edgeCount.entrySet()) {
            System.out.println(Pejo_entry.getKey() + " appears " + Pejo_entry.getValue() + " times.");
        }

        Pejo_scanner.close();
    }
}
