package weighted.path;

class Connection {

    private Node from;
    private Node to;
    private int weight;

    Connection(Node from, Node to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    Node getFrom() {
        return from;
    }

    Node getTo() {
        return to;
    }

    int getWeight() {
        return weight;
    }
}
