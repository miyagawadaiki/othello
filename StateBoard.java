/*
盤面の状態 (state) を保持するクラス

置いてない   : -1
    黒      : 0
    白      : 1
*/

public class StateBoard extends Framework_Board implements Interface_Board {
    //状態の列挙
    State state;
    private int[][] state_board;
    private int b_num, w_num;

    public StateBoard() {
        init();
        start();
    }

    public StateBoard(StateBoard copy) {

    }

    public StateBoard clone() {
        return new StateBoard(this);
    }

    public boolean turn(State st, Coord c) {
        boolean flag = false;
        if(get(c).getId() > state.NONE.getId()) flag = true;
        state_board[c.y][c.x] = st.getId();

        return flag;
    }

    public State get(Coord c) {
        return state.valueOf(state_board[c.y][c.x]);
    }

    public void count() {
        int b = 0,w = 0;
        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                if(get(new Coord(i,j)).equals(state.BLACK)) b++;
                if(get(new Coord(i,j)).equals(state.WHITE)) w++;
            }
        }
        b_num = b;
        w_num = w;
        return;
    }

    public int getB_num() {
        return b_num;
    }

    public int getW_num() {
        return w_num;
    }

    @Override
    public void init() {
        state_board = new int[8][8];
        b_num = w_num = 0;

        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                state_board[i][j] = state.NONE.getId();
            }
        }
        return;
    }

    @Override
    public void start() {
        turn(state.BLACK,new Coord(3,4));
        turn(state.BLACK,new Coord(4,3));
        turn(state.WHITE,new Coord(3,3));
        turn(state.WHITE,new Coord(4,4));
        count();
        return;
    }

    @Override
    public void update() {
        count();
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
        String s = "State Board : \n";
        s += String.format("B:%2d, W:%2d\n", b_num, w_num);
        s += "  0 1 2 3 4 5 6 7\n";

        for(int i=0;i<8;i++) {
            s += i;
            for(int j=0;j<8;j++) {
                s += String.format("|%s", state.valueOf(state_board[i][j]));
            }
            s += String.format("|%s", ((i<7)?"\n":""));
        }
        return s;
    }
}
