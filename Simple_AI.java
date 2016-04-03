public class Simple_AI extends EnemyAI {
    public Simple_AI(Board board) {
        super(board);
    }

    public Coord solve() {
        Coord c;
        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                c = new Coord(i,j);
                if(board.getCP(c) == true)
                    return c;
            }
        }
        return new Coord(8,0);
    }
}
