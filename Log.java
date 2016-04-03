public class Log {
    int turn;
    Type type;
    Coord coord;

    public Log(int turn, Type type, Coord coord) {
        this.turn = turn;
        this.type = type;
        this.coord = coord;
    }

    public String toString() {
        String s = "";
        s += String.format("%d %c %d %d", turn, type.name().charAt(0), coord.x, coord.y);
        return s;
    }
}
