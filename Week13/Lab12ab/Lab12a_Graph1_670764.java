package Lab12ab;
import Lab12ab.pack.*;
import  java.util.ArrayList;


public class Lab12a_Graph1_670764 {
    final static int INF = Integer.MAX_VALUE;   // for q2
  
    public static void main(String args[]) {
        // q1_1();
        // q1_2();
        // q1_3();
        // q2();
        // q3_1();
        // q3_2();
        // q3_3();
        // q3_4();
    }

    static void q1_1() {
        System.out.println("Graph List");
        GraphList_670764 graphL = new GraphList_670764(5);
        graphL.addEdge(0, 1);
        graphL.addEdge(0, 4);
        graphL.addEdge(1, 2);
        graphL.addEdge(1, 3);
        graphL.printGraph();
            // 0 -> 1 4 
            // 1 -> 0 2 3
            // 2 -> 1
            // 3 -> 1
            // 4 -> 0        
        System.out.println("From 1 to 3 = " + graphL.hasEdge(1, 3));   // true
        System.out.println("From 1 to 0 = " + graphL.hasEdge(1, 0));   // true
        System.out.println("From -3 to 0 = " + graphL.hasEdge(-3, 0));   //  false
        System.out.println("Is there a path from 4 to 2 = "+ graphL.hasPath(4, 2) );  // true
        System.out.println("Is there a path from 0 to 3 = "+ graphL.hasPath(0, 3) );  // true
        System.out.println("Is there a path from 4 to 1 = "+ graphL.hasPath(4, 1) );  // true
        System.out.println("Neighbor of [2] = " + graphL.neighborsOf(2) );     // [1]
        System.out.println("Neighbor of [0] = " + graphL.neighborsOf(0) );     // [1, 4]

        System.out.println("DFS:");
        graphL.dfs(0); // 0 1 2 3 4
    }
    static void q1_2() {
        System.out.println("Graph Map");
        GraphMap_670764 graphM = new GraphMap_670764();
        graphM.addEdge(1, 2);
        graphM.addEdge(1, 3);
        graphM.addEdge(2, 4);
        graphM.printGraph();
            // 1 -> [2, 3]
            // 2 -> [1, 4]
            // 3 -> [1]
            // 4 -> [2]      
        System.out.println("hasEdge from 1 to 4: " + graphM.hasEdge(1, 4));   // false
        System.out.println("hasEdge from 4 to 2: " + graphM.hasPath(4, 2) );  // true
        graphM.addVertex(5);    // add isolated node 5 to the graph
        System.out.println(graphM.hasPath(5, 2) );  // false
        System.out.println("***"+ graphM.neighborsOf(2) ); // [1, 4]
        System.out.println("Neighbors of [5] while graph size = 4: "  + graphM.neighborsOf(5) );

        System.out.println("DFS:");
        graphM.dfsAll();  
        // 1 2 4 3
        // 5
    }
    static void q1_3() {
        System.out.println("Graph Node");
        GraphNode_670764 graphN = new GraphNode_670764();
        Node a = graphN.addNode(1);
        Node b = graphN.addNode(2);
        Node c = graphN.addNode(3);

        graphN.addEdge(a, b);
        graphN.addEdge(b, c);
        graphN.addEdge(a, c);

        graphN.printGraph();
            // 1 -> 2 3
            // 2 -> 1 3
            // 3 -> 2 1
        System.out.println(graphN.hasEdge(1, 3));   // true
        System.out.println(graphN.hasPath(3, 2) );  // true
        System.out.println("***"+ graphN.neighborsOf(2) ); // [1, 3]

        System.out.println("DFS:");
        graphN.dfs(a);  // 1 2 3
    }

    static void q2() {
                            //   0 1  2   3   4
        int[][] thisGraph =    {{0,3,INF,INF,INF},  // 0
                                {INF,0,1,INF,INF},  // 1
                                {INF,INF,0,4,INF},  // 2
                                {INF,INF,INF,0,5},  // 3
                                {INF,INF,INF,INF,0}};//4
        System.out.println("computing dfs");
        q2_dfs(thisGraph);
    }

    private static void q2_dfs(int[][] thisGraph) {
        ArrayList<Integer> stack = new ArrayList<>();
        ArrayList<Integer> visited = new ArrayList<>();
        
        stack.add(0);
        while (!stack.isEmpty()) {
            int parent = stack.remove(stack.size() - 1); /* <- your code 9 */
            visited.add(parent);
            for (int x = 0; x < thisGraph.length; x++) {                      /* your code 10 v */
                if (0 < thisGraph[parent][x] && thisGraph[parent][x] < INF && !visited.contains(x)) { 
                    stack.add(x);
                    System.out.println("Edge " + parent + ", " + x);
                }
            }

        } // while 
    }
    static void q3_2() {
        GraphMap_670764 graphM = new GraphMap_670764();
        graphM.addEdge(1, 2);
        graphM.addEdge(1, 2);
        graphM.addEdge(1, 2);
        graphM.addEdge(4, 3);
            // 1 - 2
            // |   |
            // 4 - 3
        System.out.println(graphM.hasCycle());  // true
    }
}