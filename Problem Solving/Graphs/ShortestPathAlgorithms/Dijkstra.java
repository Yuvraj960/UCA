public class Dijkstra {
    private int vertices;
    private int[][] adjacencyMatrix;
    
    // Constructor to initialize the graph
    public Dijkstra(int vertices) {
        this.vertices = vertices;
        this.adjacencyMatrix = new int[vertices][vertices];
    }
    
    // Method to add an edge to the graph
    public void addEdge(int u, int v, int weight) {
        adjacencyMatrix[u][v] = weight;
        adjacencyMatrix[v][u] = weight;
    }
    
    // Method to find the minimum distance vertex that has not been visited
    private int minDistance(int[] distance, boolean[] visited) {
        int minDist = Integer.MAX_VALUE;
        int minVertex = -1;
        
        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && distance[i] < minDist) {
                minDist = distance[i];
                minVertex = i;
            }
        }
        
        return minVertex;
    }
    
    // Main method to implement Dijkstra's algorithm
    public void dijkstra(int source) {
        int[] distance = new int[vertices];
        boolean[] visited = new boolean[vertices];
        
        for (int i = 0; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        
        distance[source] = 0;
        
        for (int count = 0; count < vertices - 1; count++) {
            int u = minDistance(distance, visited);
            
            if (u == -1) break;
            
            visited[u] = true;
            
            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && adjacencyMatrix[u][v] != 0 && 
                    distance[u] != Integer.MAX_VALUE && 
                    distance[u] + adjacencyMatrix[u][v] < distance[v]) {
                    distance[v] = distance[u] + adjacencyMatrix[u][v];
                }
            }
        }
        
        printSolution(distance);
    }
    
    // Method to print the shortest distances from source to all vertices
    private void printSolution(int[] distance) {
        System.out.println("Vertex\t\tDistance from Source");
        for (int i = 0; i < vertices; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println(i + "\t\tINF");
            } else {
                System.out.println(i + "\t\t" + distance[i]);
            }
        }
    }
}
