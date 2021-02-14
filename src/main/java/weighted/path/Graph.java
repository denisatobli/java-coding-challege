package weighted.path;

import java.util.ArrayList;
import java.util.List;

class Graph {

    private List<Node> nodes;

    Graph(String[] nodes) {
        this.nodes = new ArrayList<>();

        for (int i = 0; i < nodes.length; i++) {
            this.nodes.add(new Node(nodes[i], i == 0, i == nodes.length - 1));
        }
    }

    Node findNode(String nodeName) {
        for (Node node : this.nodes) {
            if (node.getName().equals(nodeName)) return node;
        }
        return null;
    }

    String getShortestPath() {
        StringBuilder path = new StringBuilder();
        Node nextNode = this.nodes.get(0);

        if (nextNode.getDistanceFromEndNode() == 0) return "-1";

        path.append(nextNode.getName()).append("-");
        while ((nextNode = nextNode.getNextNodeOfShortestPath()) != null) {
            path.append(nextNode.getName());
            if (!nextNode.isEnd()) {
                path.append("-");
            }
        }
        return path.toString();
    }

    List<Node> getNodes() {
        return nodes;
    }
}
