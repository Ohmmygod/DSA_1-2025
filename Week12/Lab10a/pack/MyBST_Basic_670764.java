package Lab10a.pack;


import java.util.LinkedList;
import java.util.Queue;


public class MyBST_Basic_670764 {
    protected BNode root;
    public MyBST_Basic_670764() {  root = null; }
    public MyBST_Basic_670764(Integer[] input) {
        if (input.length == 0)
            return;
        root = null;
        for (int i = 0; i < input.length; i++) {
            /* your code 3 */
            if (input[i] != null)
                insert(input[i]);
        }
    }

    @Override
    public String toString() {
        if (root.left == null && root.right == null)
        return "null<-" + root.data + "->null";
        // no child
        StringBuilder sb = new StringBuilder();
        stringInOrder(root, sb);
        return sb.toString();
    }
    private void stringInOrder(BNode node, StringBuilder sb) {
        if (node == null) return; 
        stringInOrder(node.left, sb);
        sb.append(node.data + " ");
        stringInOrder(node.right, sb);  
    }
    public void insert(int d) {
        if (root == null) {
            root = new BNode(d);
        } else {
            BNode cur = root;
            while (cur != null) {
                if (d < cur.data) {
                    if (cur.left != null) {
                        cur = cur.left;
                    }
                    else {
                        /* your code 1 */
                        cur.left = new BNode(d);
                        cur.left.parent = cur;
                        return;
                    }
                } else {  //(d >= p.data)
                    if (cur.right != null) {
                        /* your code 2 */
                        cur = cur.right;

                    }
                    else {
                        cur.right = new BNode(d);
                        cur.right.parent = cur;
                        return;
                    }
                }
            }
        }
    }
    public void printPreOrder() {
        printPreOrderRecurse(root);
        System.out.println();
    }
    
    private void printPreOrderRecurse (BNode node) {
        if (node == null) return;
        /* your code 4 */
        System.out.print(node.data + " ");
        printPreOrderRecurse(node.left);
        printPostOrderRecurse(node.right);
    }

    public void printPostOrder() {
        printPostOrderRecurse(root);
        System.out.println();
    }
    
    private void printPostOrderRecurse (BNode node) {
        /* your code 5 */
        if (node == null) return;

        printPostOrderRecurse(node.left);
        printPostOrderRecurse(node.right);
        System.out.print(node.data + " ");    
    }

    public BNode search(int d) {
        return searchRecurse(d, root);
    }

    private BNode searchRecurse(int d, BNode node) {   
        if (node == null) return null;
        if (d == node.data) return node;

        /* your code 6 */
        if (d < node.data)
            return searchRecurse(d, node.left);
        else
            return searchRecurse(d, node.right);
    }
    public int size() {
        return size(root);
    }

    private int size(BNode node) {
        if (node == null) return 0;
        return 1 + size(node.left) + size(node.right);
    }

    public int height() { 
        return height(root);
    }
    private int height(BNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
    public void printLevelOrder() {
        if (root == null) return;

        Queue<BNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();  // number of nodes in this level
            System.out.print("Level " + level + ": ");

            for (int i = 0; i < size; i++) {
                BNode cur = queue.poll();
                System.out.print(cur.data + " ");
                /* your code 9 */
                if (i < size - 1)
                    System.out.print(" ");
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
            System.out.println();
            level++;
        }
    }
}
