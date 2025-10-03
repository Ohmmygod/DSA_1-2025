package Lab12ab.pack;
import java.util.ArrayList;
import java.util.List;

public class Node {
    int value;
    List<Node> neighbors;

    public Node(int value) {
        this.value = value;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(Node node) {
        neighbors.add(node);
    }

    // public List<Node> getNeighbor(Node node) {
    //     System.out.println("from getNeighbor()");
    //     return node.neighbors;
    // }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}