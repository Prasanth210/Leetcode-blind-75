/*
Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
Output: [[2,4],[1,3],[2,4],[1,3]]
Explanation: There are 4 nodes in the graph.
        1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
        2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
        3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
        4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).

*/
import java.util.*;
public class Clone_Graph {

// Definition for a Node.
        static class Node {
            public int val;
            public List<Node> neighbors;
            public Node() {
                val = 0;
                neighbors = new ArrayList<Node>();
            }
            public Node(int _val) {
                val = _val;
                neighbors = new ArrayList<Node>();
            }
            public Node(int _val, ArrayList<Node> _neighbors) {
                val = _val;
                neighbors = _neighbors;
            }
        }
            HashMap<Integer,Node> map=new HashMap<>();
            public Node cloneGraph(Node root) {
                if(root == null){
                    return null;
                }
                Node nd=new Node();
                nd.val=root.val;
                map.put(nd.val,nd);
                for(int i=0;i<root.neighbors.size();i++){
                    if(!map.containsKey(root.neighbors.get(i).val)){
                        cloneGraph(root.neighbors.get(i));
                    }
                }
                for(int i=0;i<root.neighbors.size();i++){
                    nd.neighbors.add(map.get(root.neighbors.get(i).val));
                }
                return nd;
            }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Clone_Graph cloneGraph = new Clone_Graph();
        Node clonedNode = cloneGraph.cloneGraph(node1);
        printGraph(clonedNode);
    }
    private static void printGraph(Node node) {
        // HashMap to keep track of visited nodes to avoid infinite loops in case of cycles
        HashMap<Integer, Boolean> visited = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited.put(node.val, true);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print(curr.val + " -> ");
            for (Node neighbor : curr.neighbors) {
                System.out.print(neighbor.val + " ");
                if (!visited.containsKey(neighbor.val)) {
                    visited.put(neighbor.val, true);
                    queue.add(neighbor);
                }
            }
            System.out.println();
        }
    }
}
