package Lab12ab.pack;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import java.util.HashSet;

public class GraphNode_670764 {
    private List<Node> nodes;
    
    public GraphNode_670764() {
        nodes = new ArrayList<>();
    }

    public Node addNode(int value) {
        Node node = new Node(value);
        /* your code 7 */ 
        return node;
    }

    public void addEdge(Node a, Node b) {
        a.addNeighbor(b);
        b.addNeighbor(a); //remove if directed
    }

    public List<Node> neighborsOf(int value) {
        for (Node n : nodes) {
            if (n.value == value) {
                return n.neighbors;
            }
        }
        return Collections.emptyList(); // safe fallback
    }

    private Node getNode(int value) {
        /* your code 8 begin */ 

        /* your code 8 end */ 
        return null;
    }

    public boolean hasEdge(int v1, int v2) {
        Node n1 = getNode(v1);
        Node n2 = getNode(v2);
        if (n1 == null || n2 == null) return false;
        return n1.neighbors.contains(n2);
    }

    public boolean hasPath(int v1, int v2) {
        Node n1 = getNode(v1);
        Node n2 = getNode(v2);
        if (n1 == null || n2 == null) return false;

        Set<Node> visited = new HashSet<>();
        return hasPathDFS(n1, n2, visited);
    }

    private boolean hasPathDFS(Node current, Node target, Set<Node> visited) {
        if (current == target) return true;
        visited.add(current);

        for (Node neighbor : current.neighbors) {
            if (!visited.contains(neighbor)) {
                if (hasPathDFS(neighbor, target, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void dfs(Node src) {
        if (src == null || !nodes.contains(src)) {
            System.out.println("Error: Node " + src + " does not exist in this graph.");
            return;
        }
        Set<Node> visited = new HashSet<>();
        dfsHelper(src, visited);
        System.out.println("");
    }

    private void dfsHelper(Node node, Set<Node> visited) {
        visited.add(node);
        System.out.print(node + " ");

        for (Node neighbor : node.neighbors) { // getNeighbor()) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }


    public void printGraph() {
        for (Node n: nodes) {
            System.out.print(n + " -> ");
            for (Node neighbor : n.neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}