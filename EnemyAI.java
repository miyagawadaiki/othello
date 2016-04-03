public class EnemyAI {
    Board board;

    public EnemyAI(Board board) {
        this.board = board.clone();
    }

    public Coord excute() {
        Coord c;
        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                c = new Coord(i,j);
                if(board.cp_boards[board.getCur_type().getId()].get(c) == true)
                    return c;
            }
        }
        return new Coord(8,0);
    }

    @Override
    public String toString() {
        String s = "";
        return s;
    }
}
