public class CanPutBoard implements Interface_Board {
    Type type;  //白か黒か、どちらの置ける場所を記録するか
    private boolean[][] can_put_board;
    int count;  //置ける場所の総数

    public CanPutBoard(Type type) {
        this.type = type;
        init();
        start();
    }

    public CanPutBoard(CanPutBoard copy) {
        this.type = copy.type;
        this.count = copy.count;
        for(int i=0;i<8;i++) {
            this.can_put_board[i] = copy.can_put_board[i].clone();
        }
    }

    public CanPutBoard clone() {
        return new CanPutBoard(this);
    }

    //指定された座標を設置可能とする
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
    public boolean update() {
        init();
        return true;
    }

    @Override
    public void print() {
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
