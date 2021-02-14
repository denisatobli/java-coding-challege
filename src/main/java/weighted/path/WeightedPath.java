package weighted.path;

import java.util.regex.Pattern;

public class WeightedPath {

    private Graph build(String[] nodes, String[] connections) {
        Graph graph = new Graph(nodes);

        for (Node node : graph.getNodes()) {
            for (String connection : connections) {
                if (connection.contains(node.getName())) {
                    String[] neighboringNodes = connection.split(Pattern.quote("|"));
                    Node neighboringNode;
                    if (neighboringNodes[0].equals(node.getName())) {
                        neighboringNode = graph.findNode(neighboringNodes[1]);
                    }
                    else {
                        neighboringNode = graph.findNode(neighboringNodes[0]);
                    }
                    node.addConnection(neighboringNode, Integer.parseInt(neighboringNodes[2]));
                }
            }
        }
        return graph;
    }

    private void setDistance(Node node) {
        if (node.isEnd()) node.setDistanceFromEndNode(0);

        for (Connection connection : node.getConnections()) {
            int distance = node.getDistanceFromEndNode() + connection.getWeight();
            Node neighbour = connection.getTo();
            if (neighbour.getDistanceFromEndNode() == 0 || distance < neighbour.getDistanceFromEndNode()) {
                neighbour.setDistanceFromEndNode(distance);

                if (!neighbour.isStart()) {
                    setDistance(neighbour);
                }
            }
        }
    }

    public String getWeightedPath(String[] arr) {
        int nrOfNodes = Integer.parseInt(arr[0]);
        String[] nodes = new String[nrOfNodes];
        String[] connections = new String[arr.length - nrOfNodes - 1];

        for (int i = 1; i < arr.length; i++) {
            if (i <= nrOfNodes) {
                nodes[i - 1] = arr[i];
            }
            else {
                connections[i - nrOfNodes - 1] = arr[i];
            }
        }
        Graph graph = build(nodes, connections);
        Node endNode = graph.getNodes().get(graph.getNodes().size() - 1);
        setDistance(endNode);
        return graph.getShortestPath();
    }

}
