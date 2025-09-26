import Lab10a.pack.*;

public class Lab10b_670764 {
    public static void main(String[] args) {
        // demo1();
        // demo2();
        // demo3();
        // demo4();
        demo5();
    }
    public static void demo1() {
        System.out.println("---- find min & max ----");
        Integer data[] = {45, 12, 30, 55, 31, 64, 59};
        MyBST_670764 bst = new MyBST_670764(data);

        System.out.println(bst.findMin(bst.getRoot())); // null <- 12 -> 30
        System.out.println(bst.findMax(bst.getRoot())); // 59 <- 64 -> null

        bst.insert(70);
        System.out.println(bst.findMax(bst.getRoot())); // null <- 70 -> null
    }    
    public static void demo2() {
        System.out.println("---- delete ----");
        Integer data[] = {15, 34, 20, 10, 18, 16, 12, 8};
        MyBST_670764 bst = new MyBST_670764(data);
        System.out.println(bst); // 8 10 12 15 16 18 20 34 
        System.out.println(bst.search(10)); // 8 <- 10 -> 12
        System.out.println(bst.search(15)+"\n"); // 10 <- 15 -> 34

        bst.delete(bst.getRoot(), 34);
        bst.delete(bst.getRoot(), 10);
        bst.delete(bst.getRoot(), 100);
        System.out.println(bst); // 8 12 15 16 18 20
        System.out.println(bst.search(10)); // null
        System.out.println(bst.search(15)); // 8 <- 15 -> 20
        System.out.println(bst.search(20)); // 18 <- 20 -> null
    }
    public static void demo3() {
        System.out.println("---- find predecessor & successor ----");
        Integer data[] = {32, 46, 18, null, 43, 25, 31, 13};
        MyBST_670764 bst = new MyBST_670764(data);

        System.out.println(bst.inorderPredecessor(31)); // null <- 25 -> 31
        System.out.println(bst.inorderSuccessor( 43)); // 43 <- 46 -> null
        System.out.println(bst.inorderPredecessor( 13)); // null
    }
    public static void demo4() {
        System.out.println("---- kth smallest ----");
        Integer data[] = {1, null, 4, 10, 5, 7};
        MyBST_670764 bst = new MyBST_670764(data);

        System.out.println(bst.kthSmallest(bst.getRoot(), 3)); // 5
        System.out.println(bst.kthSmallest(bst.getRoot(), 5)); // 10
    }
    public static void demo5() {
        System.out.println("---- rotate ----");
        Integer[] data1 = {4,5,6,9};
        MyBST_670764 bst1 = new MyBST_670764(data1);
        System.out.println(bst1.search(5)); // null <- 5 -> 6
        System.out.println(bst1.search(6)); // null <- 6 -> 9
        System.out.println(bst1.search(9)); // null <- 9 -> null
        
        MyBST_670764.leftRotate(bst1, bst1.search(5));
        System.out.println(bst1.search(5)); // null <- 5 -> null
        System.out.println(bst1.search(6)); // 5 <- 6 -> 9
        System.out.println(bst1.search(9) + "\n"); // null <- 9 -> null

        Integer[] data2 = {2,4,7,5,6};
        MyBST_670764 bst2 = new MyBST_670764(data2);
        System.out.println(bst2.search(4)); // null <- 4 -> 7
        System.out.println(bst2.search(7)); // 5 <- 7 -> null
        System.out.println(bst2.search(5)); // null <- 5 -> 6

        MyBST_670764.rightLeftRotate(bst2, bst2.search(4));
        System.out.println(bst2.search(4)); // null <- 4 -> null
        System.out.println(bst2.search(7)); // 6 <- 7 -> null
        System.out.println(bst2.search(5)); // 4 <- 5 -> 7
    }
}
