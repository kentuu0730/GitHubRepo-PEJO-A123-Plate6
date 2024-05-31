package PLATE6;

import java.util.*;

public class Problem8 {
    // Function to read an adjacency matrix from the user
    private static int[][] Pejo_readGraph(Scanner Pejo_scanner, int Pejo_vertices) {
        int[][] Pejo_adjacencyMatrix = new int[Pejo_vertices][Pejo_vertices];
        System.out.println("Enter adjacency matrix for the graph:");
        for (int i = 0; i < Pejo_vertices; i++) {
            for (int j = 0; j < Pejo_vertices; j++) {
                while (!Pejo_scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter an integer.");
                    Pejo_scanner.next();
                }
                Pejo_adjacencyMatrix[i][j] = Pejo_scanner.nextInt();
            }
        }
        return Pejo_adjacencyMatrix;
    }

    // Function to check if two graphs are isomorphic
    private static boolean Pejo_areIsomorphic(int[][] Pejo_graph1, int[][] Pejo_graph2) {
        if (Pejo_graph1.length != Pejo_graph2.length) return false;

        int Pejo_vertices = Pejo_graph1.length;
        List<Integer> Pejo_permutation = new ArrayList<>();
        for (int i = 0; i < Pejo_vertices; i++) Pejo_permutation.add(i);

        do {
            if (Pejo_checkPermutation(Pejo_graph1, Pejo_graph2, Pejo_permutation)) {
                return true;
            }
        } while (Pejo_nextPermutation(Pejo_permutation));
        return false;
    }

    // Helper function to check if the current permutation makes the two graphs identical
    private static boolean Pejo_checkPermutation(int[][] Pejo_graph1, int[][] Pejo_graph2, List<Integer> Pejo_permutation) {
        int Pejo_vertices = Pejo_graph1.length;
        for (int i = 0; i < Pejo_vertices; i++) {
            for (int j = 0; j < Pejo_vertices; j++) {
                if (Pejo_graph1[i][j] != Pejo_graph2[Pejo_permutation.get(i)][Pejo_permutation.get(j)]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Function to generate the next lexicographical permutation
    private static boolean Pejo_nextPermutation(List<Integer> Pejo_permutation) {
        int Pejo_k = Pejo_permutation.size() - 2;
        while (Pejo_k >= 0 && Pejo_permutation.get(Pejo_k) >= Pejo_permutation.get(Pejo_k + 1)) {
            Pejo_k--;
        }
        if (Pejo_k == -1) return false;

        int Pejo_l = Pejo_permutation.size() - 1;
        while (Pejo_permutation.get(Pejo_k) >= Pejo_permutation.get(Pejo_l)) {
            Pejo_l--;
        }
        Collections.swap(Pejo_permutation, Pejo_k, Pejo_l);
        Collections.reverse(Pejo_permutation.subList(Pejo_k + 1, Pejo_permutation.size()));
        return true;
    }

    public static void main(String[] Pejo_args) {
        Scanner Pejo_scanner = new Scanner(System.in);

        int Pejo_vertices = -1;
        while (Pejo_vertices <= 0) {
            System.out.print("Enter the number of vertices for the graphs (positive integer): ");
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

        System.out.println("Graph 1:");
        int[][] Pejo_graph1 = Pejo_readGraph(Pejo_scanner, Pejo_vertices);

        System.out.println("Graph 2:");
        int[][] Pejo_graph2 = Pejo_readGraph(Pejo_scanner, Pejo_vertices);

        if (Pejo_areIsomorphic(Pejo_graph1, Pejo_graph2)) {
            System.out.println("The graphs are isomorphic.");
        } else {
            System.out.println("The graphs are not isomorphic.");
        }

        Pejo_scanner.close();
    }
}
