package Lab12ab.pack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphList_670764 {
    private int vertices;    // จำนวน vertices 
    private List<Integer>[] adjacencyList;

    public GraphList_670764(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int src, int dest) {
        /* your code 1 */ 
        if (src < 0 || src >= vertices || dest < 0 || dest >= vertices)
            return ;
        adjacencyList[src].add(dest); 
        adjacencyList[dest].add(src); // remove if directed
    }

    public List<Integer> neighborsOf(int i) {
        if (i >= vertices) { System.out.println("out of range"); return Collections.emptyList(); }
        return adjacencyList[i];
    }
                            // 1       3
    public boolean hasEdge(int n1, int n2) {
        if (n1 < 0 || n1 >= vertices || n2 < 0 || n2 >= vertices) {
            return false;
        }
        return adjacencyList[n1].contains(n2);
    }

            // 0 -> 1 4 
            // 1 -> 0 2 3
            // 2 -> 1
            // 3 -> 1
            // 4 -> 0  
                    //    from  0  to  3 dai rue mai?
    public boolean hasPath(int n1, int n2) {
        if (n1 < 0 || n1 >= vertices || n2 < 0 || n2 >= vertices) {
            return false;
        }
        boolean[] visited = new boolean[vertices];
        return hasPathDFS(n1, n2, visited);
    }

    private boolean hasPathDFS(int current, int target, boolean[] visited) {
        if (current == target) return true;
        visited[current] = true;

        for (int neighbor : adjacencyList[current]) {
            if (visited[neighbor] != true) {
                if (hasPathDFS(neighbor, target, visited)) {
                    return true;
                }
            }
        }

        return false;
    }        

    public void dfs(int src) {
        if (src < 0 || src >= vertices) {
            System.out.println("Error: Node " + src + " does not exist in this graph.");
            return;
        }

        boolean[] visited = new boolean[vertices];
        dfsHelper(src, visited);
    }

    private void dfsHelper(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int neighbor : adjacencyList[v]) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " -> ");
            for (int neighbor : adjacencyList[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println("");
        }
    }
}
