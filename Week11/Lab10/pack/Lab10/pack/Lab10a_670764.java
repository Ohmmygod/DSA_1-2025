package Lab10.pack;

public class Lab10a_670764 {
    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
        demo4();
        demo5();
        demo6();
    }

public static void demo1() {
    System.out.println("----insert----");
    MyBST_Basic_670764 bst = new MyBST_Basic_670764();
    bst.insert(2);
    bst.insert(5);
    bst.insert(1);
    System.out.println(bst); // 1 2 5
}    
    public static void demo2() {
        System.out.println("----construct from array of int----");
        // Integer[] tree = {1,2,3,4,5,null,8,null,null,6,7,9}; 
        Integer[] tree = {4,2,6,1,3,5,7,null,null,null,null,null,null,null,9,8,null}; // 4 2 6 5 7 1 3 9 8
        MyBST_Basic_670764 bst = new MyBST_Basic_670764(tree);
        System.out.println(bst); // 1 2 3 4 5 6 7 8 9
    }
    public static void demo3() {
        Integer[] tree = {4,2,7,1,3,5,8,null,null,null,null,null,6};
        MyBST_Basic_670764 bst = new MyBST_Basic_670764(tree);
        System.out.println("----traversal methods----");
        System.out.println("\t Pre order:"); 
        bst.printPreOrder();    // 4 2 1 3 7 5 6 8
        System.out.println("\t Post order:");
        bst.printPostOrder();   // 1 3 2 6 5 8 7 4
    }
    public static void demo4() {
        System.out.println("----search----");
        Integer[] tree = {4,2,7,1,3,5,8,null,null,null,null,null,6};
        MyBST_Basic_670764 bst = new MyBST_Basic_670764(tree);
        System.out.println("search 4");
        System.out.println(bst.search(4)); // 2 <- 4 -> 7
        System.out.println("search 5");
        System.out.println(bst.search(5)); // null <- 5 -> 6
        System.out.println("search 8");
        System.out.println(bst.search(8)); // null <- 8 -> null
        System.out.println("search 9");
        System.out.println(bst.search(9)); // null
    }
    public static void demo5() {
        System.out.println("----size and height----");
        Integer[] tree1 = {4,2,7,1,3,5,8,null,null,null,null,null,6};
        MyBST_Basic_670764 bst1 = new MyBST_Basic_670764(tree1);
        System.out.println("tree 1 size: " + bst1.size());      // 8
        System.out.println("tree 1 height: " + bst1.height());  // 4
        Integer[] tree2 = {1,null,2,null,3,null,4,null,5,null,6,null,7,null,8};
        MyBST_Basic_670764 bst2 = new MyBST_Basic_670764(tree2);
        System.out.println("tree 2 size: " + bst2.size());      // 8
        System.out.println("tree 2 height: " + bst2.height());  // 8
    }
    public static void demo6() {
        System.out.println("print Level Order");  
        Integer[] tree = {4,2,7,1,3,5,8,null,null,null,null,null,6};
        MyBST_Basic_670764 bst = new MyBST_Basic_670764(tree);
        bst.printLevelOrder(); 
    }
}
