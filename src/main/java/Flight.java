public class Flight {
    String name;
    int start;
    int end;
    int cost;

    public Flight(String name, int start, int end, int cost) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getCost() {
        return cost;
    }
}
