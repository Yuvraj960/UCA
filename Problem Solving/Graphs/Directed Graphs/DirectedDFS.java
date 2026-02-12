import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class DirectedDFS {
  private boolean[] marked;
  private int[] edgeTo;
  private int s;
  
  DirectedDFS(Graph g, int s) {
    this.marked = new boolean[g.V()];
    this.edgeTo = new int[g.V()];
    this.s = s;
    dfs(g, s);
  }

  private void dfs(Graph g, int v) {
    Stack<Integer> stack = new Stack<>();
    stack.push(v);
    marked[v] = true;
    
    while (!stack.isEmpty()) {
      int w = stack.pop();
      for (int z : g.adj(w)) {  
        if (marked[z]) continue;
        marked[z] = true;
        edgeTo[z] = w;
        stack.push(z);
      }
    }    
  }

  public boolean connected(int v) {
    return marked[v];
  }

  public void printShortestPath(int v) {
    if (!connected(v)) return;
    Stack<Integer> path = new Stack<>();
    for (int w = v; w != s; w = edgeTo[w]) {
      path.push(w);
    }
    path.push(s); 
    while (!path.isEmpty()) {
      System.out.print(path.pop() + " ");
    }
    System.out.println();
  }
}