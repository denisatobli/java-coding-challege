package weighted.path;

import java.util.ArrayList;
import java.util.List;

class Node {

    private String name;
    private boolean start;
    private boolean end;
    private int distanceFromEndNode;
    private List<Connection> connections;

    Node(String name, boolean start, boolean end) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.distanceFromEndNode = 0;
        this.connections = new ArrayList<>();
    }

    void addConnection(Node node, int weight) {
        Connection connection = new Connection(this, node, weight);
        this.connections.add(connection);
    }

    Node getNextNodeOfShortestPath() {
        if (this.isEnd()) return null;

        Node lowestWeightNeighbour = null;
        for (Connection connection : this.connections) {
            Node neighbour = connection.getTo();
            if (this.isStart() && neighbour.isEnd() && connection.getWeight() == this.getDistanceFromEndNode()) {
                return neighbour;
            }
            if ((!this.isStart() || !neighbour.isEnd()) && (lowestWeightNeighbour == null
                    || neighbour.getDistanceFromEndNode() == this.getDistanceFromEndNode() - connection.getWeight())) {
                lowestWeightNeighbour = neighbour;
            }
        }
        return lowestWeightNeighbour;
    }

    String getName() {
        return name;
    }

    boolean isStart() {
        return start;
    }

    boolean isEnd() {
        return end;
    }

    int getDistanceFromEndNode() {
        return distanceFromEndNode;
    }

    void setDistanceFromEndNode(int distanceFromEndNode) {
        this.distanceFromEndNode = distanceFromEndNode;
    }

    List<Connection> getConnections() {
        return connections;
    }
}
