package Lab10a.pack;

public class BNode {
    public int data;
    public BNode left, right, parent;

    public BNode(int d) {
        data = d;
    }

    @Override
    public String toString() {
        if (left == null && right == null) return "null <- " + data + " -> null";
        if (left != null && right == null) return left.data + " <- " + data + " -> null";
        if (left == null && right != null) return "null <- " + data + " -> " + right.data;
        return left.data + " <- " + data + " -> " + right.data;
    }
}
