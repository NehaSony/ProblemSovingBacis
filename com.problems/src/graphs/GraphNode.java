package graphs;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    Integer id;
    List<GraphNode> children;

    public GraphNode(){}

    public GraphNode(int val){
        this.id = val;
        this.children = new ArrayList<>();
    }

    public void addEdge(GraphNode source, int destination){
        GraphNode destinationNode = new GraphNode(destination);
        source.children.add(destinationNode);
    }
     public void addEdge(GraphNode source, GraphNode destination){
         source.children.add(destination);
     }

    @Override
    public String toString() {
        return "GraphNode{" +
                "val=" + id +
                ", children=" + children +
                '}';
    }
}
