package Graphs.ShortestPathAlgorithms;

public class BellmanFord {
    
    // Inner class to represent an edge in the graph
    static class Edge {
        int src, dest, weight;
        
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    
    // Bellman-Ford Algorithm: Finds shortest path from source to all vertices
    // Time Complexity: O(V*E) where V is number of vertices and E is number of edges
    // Space Complexity: O(V)
    static void bellmanFord(int vertices, Edge[] edges, int source) {
        int[] distance = new int[vertices];
        
        // Initialize distances with infinity except source
        for (int i = 0; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;
        
        // Relax all edges (vertices - 1) times
        for (int i = 0; i < vertices - 1; i++) {
            for (Edge edge : edges) {
                if (distance[edge.src] != Integer.MAX_VALUE && 
                    distance[edge.src] + edge.weight < distance[edge.dest]) {
                    distance[edge.dest] = distance[edge.src] + edge.weight;
                }
            }
        }
        
        // Check for negative weight cycles
        for (Edge edge : edges) {
            if (distance[edge.src] != Integer.MAX_VALUE && 
                distance[edge.src] + edge.weight < distance[edge.dest]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }
        
        // Print shortest distances from source
        printDistances(distance, source);
    }
    
    // Helper method: Prints shortest distances from source vertex to all other vertices
    static void printDistances(int[] distance, int source) {
        System.out.println("Shortest distances from vertex " + source + ":");
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("Vertex " + i + ": INF");
            } else {
                System.out.println("Vertex " + i + ": " + distance[i]);
            }
        }
    }
    
    // Main method: Demonstrates Bellman-Ford Algorithm with sample graph
    public static void main(String[] args) {
        int vertices = 5;
        Edge[] edges = new Edge[8];
        
        edges[0] = new Edge(0, 1, -1);
        edges[1] = new Edge(0, 2, 4);
        edges[2] = new Edge(1, 2, 3);
        edges[3] = new Edge(1, 3, 2);
        edges[4] = new Edge(1, 4, 2);
        edges[5] = new Edge(3, 2, 5);
        edges[6] = new Edge(3, 1, 1);
        edges[7] = new Edge(4, 3, -3);
        
        bellmanFord(vertices, edges, 0);
    }
}
