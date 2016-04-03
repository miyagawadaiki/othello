public class CanPutBoard extends Framework_Board implements Interface_Board {
    Type type;
    private boolean[][] can_put_board;
    int count;

    public CanPutBoard(Type type) {
        this.type = type;
        init();
        start();
    }

    public CanPutBoard(CanPutBoard copy) {

    }

    public CanPutBoard clone() {
        return new CanPutBoard(this);
    }

    public void enable(Coord c) {
        can_put_board[c.y][c.x] = true;
        count++;
        return;
    }

    //実験用
    public void enableAll() {
        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                enable(new Coord(i,j));
            }
        }
        return;
    }

    public boolean get(Coord c) {
        return can_put_board[c.y][c.x];
    }

    @Override
    public void init() {
        count = 0;
        can_put_board = new boolean[8][8];
        return;
    }

    @Override
    public void start() {
        init();
        return;
    }

    @Override
    public void update() {
        init();
        return;
    }

    @Override
    public void print() {
        System.out.println(super.toString());
        System.out.println(this);
        return;
    }

    @Override
    public String toString() {
        String s = type.name() + " Can Put Board:\n";
        s += "count : " + count + "\n";
        s += "  0 1 2 3 4 5 6 7\n";

        for(int i=0;i<8;i++) {
            s += i;
            for(int j=0;j<8;j++) {
                s += String.format("|%c", can_put_board[i][j]?'1':' ');
            }
            s += String.format("|%s", ((i<7)?"\n":""));
        }

        return s;
    }
}
