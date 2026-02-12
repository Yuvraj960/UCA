public class FloydWarshall {
    
    // Initializes the distance matrix with the adjacency matrix values
    // Sets distance[i][i] = 0 for all diagonal elements
    private static void initializeDistances(int[][] graph, int[][] distances) {
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distances[i][j] = graph[i][j];
            }
        }
    }
    
    // Applies Floyd-Warshall algorithm to find shortest paths between all pairs of vertices
    // Uses intermediate vertices k to check if path through k is shorter than direct path
    private static void floydWarshall(int[][] distances) {
        int n = distances.length;
        int INF = Integer.MAX_VALUE / 2;
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distances[i][k] != INF && distances[k][j] != INF) {
                        distances[i][j] = Math.min(distances[i][j], 
                                                   distances[i][k] + distances[k][j]);
                    }
                }
            }
        }
    }
    
    // Prints the shortest distance matrix in a formatted table layout
    // Displays distances between all pairs of vertices
    private static void printDistances(int[][] distances) {
        int n = distances.length;
        int INF = Integer.MAX_VALUE / 2;
        
        System.out.println("Shortest distances between all pairs of vertices:");
        System.out.print("    ");
        for (int i = 0; i < n; i++) {
            System.out.print("  " + i + " ");
        }
        System.out.println();
        
        for (int i = 0; i < n; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < n; j++) {
                if (distances[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(distances[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }
    
    // Main method to execute Floyd-Warshall algorithm
    // Creates sample graph, initializes distances, runs algorithm, and displays results
    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE / 2;
        
        // Adjacency matrix representation of the graph
        int[][] graph = {
            {0, 3, INF, 7},
            {8, 0, 2, INF},
            {5, INF, 0, 1},
            {2, INF, INF, 0}
        };
        
        int n = graph.length;
        int[][] distances = new int[n][n];
        
        initializeDistances(graph, distances);
        floydWarshall(distances);
        printDistances(distances);
    }
}
