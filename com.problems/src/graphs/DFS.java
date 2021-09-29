package graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class DFS {
    HashSet<Integer> visited = new HashSet<>();
    List<Integer> path = new LinkedList();

    public boolean dfsSearch(GraphNode node,int val){
        if(visited.equals(node.id)){
            return false;
        }
        if(node.id.equals(Integer.valueOf(val))){
            return true;
        }
        node.children.forEach(e->{
            System.out.println(e);
            if(dfsSearch(e,val)){
                path.add(e.id);
            }
        });
        return false;
    }

    public static void main(String[] args) {
        DFS dfs = new DFS();
        GraphNode graphNode = new GraphNode(0);
        GraphNode graphNode1 = new GraphNode(1);
        GraphNode graphNode2 = new GraphNode(2);
        GraphNode graphNode3 = new GraphNode(3);
        GraphNode graphNode4 = new GraphNode(4);
        GraphNode graphNode5 = new GraphNode(5);
        GraphNode graphNode6 = new GraphNode(6);
        GraphNode graphNode7 = new GraphNode(7);
        GraphNode graphNode8 = new GraphNode(8);

        graphNode.addEdge(graphNode,graphNode1);
        graphNode.addEdge(graphNode1,graphNode2);
        graphNode.addEdge(graphNode2,graphNode3);
        graphNode.addEdge(graphNode3,graphNode4);
        graphNode.addEdge(graphNode4,graphNode5);
        graphNode.addEdge(graphNode2,graphNode6);
        graphNode.addEdge(graphNode6,graphNode7);
        graphNode.addEdge(graphNode4,graphNode8);
        System.out.println(dfs.dfsSearch(graphNode,8));
        System.out.println(dfs.path);

    }
}
