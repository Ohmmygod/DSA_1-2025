package Lab05;

import Lab05.pack.MyStack_670764java;

public class Lab05_670764 {
    static void demo_0() {
        MyStack_670764java<Integer> stack = new MyStack_670764java<>();
        for (int i = 1; i < 4; i++)
            stack.push(i);  // 3 2 1 , cuz 1 being pushed first
        // System.out.println(stack);

        System.out.println("stack = " + stack);
        System.out.println("peek  = " + stack.peek());
        System.out.println("pop   = " + stack.pop());
        System.out.println("stack after popped = " + stack);
        System.out.println("size  = " + stack.size());
        System.out.println("empty = " + stack.isEmpty());
    }
    // static void demo_1() {
    //     String toBeRPN = "8 5 - 4 2 + 3 / *";
    //     StringTokenizer st = new StringTokenizer(toBeRPN);
    //     int i = 0;
    //     String t = "";
    //     while (st.hasMoreTokens()) {
    //         t = st.nextToken();
    //         if (MyRPN.isNumeric(t))
    //             System.out.println("Token " + i++ + " = " + t);
    //         else   
    //             System.out.println("Token " + i++ + " = " + t + " is an operator");
    //     }
    // }

    // static void demo_2() {
    //     String postfixString = "8 5 - 4 2 + 3 / *";
    //     System.out.println(postfixString + " = " + MyRPN.computeRPN(postfixString));
    // }
    public static void main(String[] args) {
        demo_0();
        // demo_1();
        // demo_2();
    }
}
