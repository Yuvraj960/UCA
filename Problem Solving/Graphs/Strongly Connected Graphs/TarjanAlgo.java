import java.util.*;

public class TarjanAlgo {
    private int V;
    private LinkedList<Integer>[] adj;
    private int indexCounter;
    private Stack<Integer> stack;
    private int[] index;
    private int[] lowlink;
    private boolean[] onStack;
    private List<List<Integer>> sccs;

    public TarjanAlgo(int V) {
        this.V = V;
        this.adj = new LinkedList[V];
        this.indexCounter = 0;
        this.stack = new Stack<>();
        this.index = new int[V];
        this.lowlink = new int[V];
        this.onStack = new boolean[V];
        this.sccs = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
            index[i] = -1;
        }
    }

    // Add edge to the graph
    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    // Tarjan's algorithm to find strongly connected components
    public void tarjanSCC() {
        for (int i = 0; i < V; i++) {
            if (index[i] == -1) {
                strongConnect(i);
            }
        }
    }

    // DFS-based helper method for Tarjan's algorithm
    private void strongConnect(int v) {
        index[v] = indexCounter;
        lowlink[v] = indexCounter;
        indexCounter++;
        stack.push(v);
        onStack[v] = true;

        for (int w : adj[v]) {
            if (index[w] == -1) {
                strongConnect(w);
                lowlink[v] = Math.min(lowlink[v], lowlink[w]);
            } else if (onStack[w]) {
                lowlink[v] = Math.min(lowlink[v], index[w]);
            }
        }

        if (lowlink[v] == index[v]) {
            List<Integer> component = new ArrayList<>();
            int w;
            do {
                w = stack.pop();
                onStack[w] = false;
                component.add(w);
            } while (w != v);
            sccs.add(component);
        }
    }

    // Display all strongly connected components
    public void displaySCC() {
        System.out.println("Strongly Connected Components:");
        for (int i = 0; i < sccs.size(); i++) {
            System.out.println("SCC " + (i + 1) + ": " + sccs.get(i));
        }
    }

    public static void main(String[] args) {
        TarjanAlgo graph = new TarjanAlgo(8);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 0);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 4);
        graph.addEdge(6, 7);

        graph.tarjanSCC();
        graph.displaySCC();
    }
}
