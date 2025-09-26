package Lab10a.pack;

public class MyBST_670764 extends MyBST_Basic_670764 {
    public MyBST_670764() { 
        super(); 
    }

    public MyBST_670764(Integer[] input) {
        super(input);
    }
    public BNode getRoot() {
        return root; // fixed MyBST_Basic protected root
    }
    public BNode findMin(BNode node) {
        if (node == null) throw new IllegalArgumentException("Empty Tree");
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    public BNode findMax(BNode node) {
        if (node == null) throw new IllegalArgumentException("Empty Tree");
        while (node.right != null) {    
            node = node.right;
        }
        return node;        
    }
    public void delete(BNode node, int d) {
        if (node == null)   return;
        if (d < node.data) {
            delete(node.left, d);       
        } else if (d > node.data) {     
            delete(node.right, d);
        } else { // found
            if (node.left == null || node.right == null) { // 0 or 1 child
                BNode q = node.left == null ? node.right : node.left;
                if (node.parent != null) {
                    if (node.parent.left == node) 
                        node.parent.left = q;
                    else
                        node.parent.right = q;

                    if (q != null)
                        q.parent = node.parent;  
                } else {
                    root = q;
                }
            } else { // 2 children
                BNode q = findMax(node.left);               
                delete(node.left, q.data);

                if (node.parent ==null) {
                    root = q;
                } else if (node.parent.left == node) {
                    node.parent.left = q;
                } else {
                    node.parent.right = q ;
                }
                q.parent = node.parent;

                // migrate node's children
                q.left = node.left;
                if (q.left != null) q.left.parent = q;

                q.right = node.right;
                if (q.right != null) q.right.parent = q;
            }
        }
    }
    public BNode inorderPredecessor(int val) {
        BNode node = root;
        BNode pred = null;
        while (node != null) {
            if (val > node.data) {
                pred = node;
                node = node.right;
            } else {
                node = node.left;
            }
        }
        
        return pred;        
    }
    public BNode inorderSuccessor(int val) {
        BNode node = root, succ = null;
        while (node != null) {
            if (val < node.data) {
                succ = node;
                node = node.left;   
            } else {
                node = node.right;
            }
        }
        return succ;
    }
    public int kthSmallest(BNode node, int k) {
        java.util.Stack<BNode> stack = new java.util.Stack<>();
        while (true) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (--k == 0) return node.data;
            node = node.right;
        }
    }    
    public static void leftRotate(MyBST_670764 bst, BNode node) {
        if (node == null || node.right == null) return;
        BNode rightChild = node.right;
        BNode tmp = rightChild.left;    

        // rotate
        rightChild.left = node;
        node.right = tmp;

        // update parents
        rightChild.parent = node.parent;
        node.parent = rightChild;
        if (tmp != null) tmp.parent = node;

        // update children
        if (rightChild.parent == null) {
            bst.root = rightChild;  // node was root
        } else if (rightChild.parent.left == node) {
            rightChild.parent.left = rightChild;
        } else {
            rightChild.parent.right = rightChild;
        }
    }
    public static void rightRotate(MyBST_670764 bst, BNode node) {
        if (node == null || node.left == null) return;

        BNode leftChild = node.left;
        BNode tmp = leftChild.right;

        // rotate
        leftChild.right = node;
        node.left = tmp;

        // update parents
        leftChild.parent = node.parent;
        node.parent = leftChild;
        if (tmp != null)
            tmp.parent = node; 
        
        // update children
        if (leftChild.parent == null) {
            bst.root = leftChild;
        } else if (leftChild.parent.left == node) {
            leftChild.parent.left = leftChild;
        } else {
            leftChild.parent.right = leftChild;
        }
    }
    public static void rightLeftRotate(MyBST_670764 bst, BNode node) {
        if (node == null || node.right == null) return;
        
        rightRotate(bst, node.right);
        leftRotate(bst, node);
    }
}
// public void delete(int d, BNode node) { 
//     //   Copy candidate value into this node and fix child links
//     if (node == null) return;

//     if (d < node.data) {
//         delete(d, node.left);
//     } else if (d > node.data) {
//         delete(d, node.right);
//     } else {
//         // Case 1: no child
//         if (node.left == null && node.right == null) {
//             // cannot just nullify node (since caller holds the ref)
//             if (node.parent != null) {
//                 if (node.parent.left == node) node.parent.left = null;
//                 else node.parent.right = null;
//             }
//         }
//         // Case 2: one child
//         else if (node.left == null || node.right == null) {
//             BNode child = (node.left != null) ? node.left : node.right;
//             node.data = child.data;
//             node.left = child.left;
//             node.right = child.right;
//             if (child.left != null) child.left.parent = node;
//             if (child.right != null) child.right.parent = node;
//         }
//         // Case 3: two children
//         else {
//             BNode pred = findMax(node.left);
//             node.data = pred.data;                 // just copy value
//             delete(pred.data, node.left);          // delete predecessor
//         }
//     }
// }
    // public void delete(int d, BNode node) {
    //     // replace node.data = pred.data -> delete pred
    //     if (node == null) return;

    //     if (d < node.data) {
    //         delete(d, node.left);
    //     } else if (d > node.data) {
    //         delete(d, node.right);
    //     } else { // found
    //         if (node.left == null || node.right == null) {
    //             BNode child = (node.left != null) ? node.left : node.right;

    //             if (node.parent == null) {
    //                 root = child;
    //             } else if (node.parent.left == node) {
    //                 node.parent.left = child;
    //             } else {
    //                 node.parent.right = child;
    //             }
    //             if (child != null) child.parent = node.parent;

    //         } else {
    //             BNode pred = findMax(node.left);
    //             node.data = pred.data;                 // just copy value
    //             delete(pred.data, node.left);          // delete predecessor
    //         }
    //     }
    // }
    // public void delete(int d) {
    //     BNode parent = null;
    //     BNode current = root;

    //     while (current != null && current.data != d) {
    //         parent = current;
    //         if (d < current.data) {
    //             current = current.left;
    //         } else {
    //             current = current.right;
    //         }
    //     }
    
    //     if (current == null) {
    //         return;
    //     }
    
    //     //no child
    //     if (current.left == null && current.right == null) {
    //         if (current == root) {
    //             root = null;
    //         } else if (parent.left == current) {
    //             parent.left = null;
    //         } else {
    //             parent.right = null;
    //         }
    //     }
    
    //     // one child
    //     // just promote the child (do not need to findMax or findMin)
    //     else if (current.left == null || current.right == null) {
    //         BNode child = (current.left != null) ? current.left : current.right;
    
    //         if (current == root) {
    //             root = child;
    //         } else if (parent.left == current) {
    //             parent.left = child;
    //         } else {
    //             parent.right = child;
    //         }
    //     }
    
    //     //two child
    //     else {
    //         BNode predecessorParent = current;
    //         BNode predecessor = current.right;
    
    //         while (predecessor.left != null) {
    //             predecessorParent = predecessor;
    //             predecessor = predecessor.left;
    //         }
    
    //         current.data = predecessor.data;
    
    //         if (predecessorParent.left == predecessor) {
    //             predecessorParent.left = predecessor.right;
    //         } else {
    //             predecessorParent.right = predecessor.right;
    //         }
    //     }
    // }
/* 
    // successor without parent 
    public BNode successor(int d) {
        BNode target = find(root, d);
        if (target == null) return null;

        // Case 1: right subtree exists
        if (target.right != null) {
            return minValueNode(target.right);
        }

        // Case 2: no right subtree
        BNode succ = null;
        BNode ancestor = root;
        while (ancestor != null) {
            if (d < ancestor.data) {
                succ = ancestor; // possible successor
                ancestor = ancestor.left;
            } else if (d > ancestor.data) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return succ;
    }

    // helper: find node with value d
    private BNode find(BNode node, int d) {
        if (node == null) return null;
        if (d < node.data) return find(node.left, d);
        else if (d > node.data) return find(node.right, d);
        else return node;
    }

    // helper: get minimum node
    private BNode minValueNode(BNode node) {
        while (node.left != null)
            node = node.left;
        return node;
    }
*/