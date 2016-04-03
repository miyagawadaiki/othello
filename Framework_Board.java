public class Framework_Board implements Interface_Board {
    Type cur_turn;
    int turn_cnt;
    boolean pass;

    public Framework_Board() {
        setCur_turn(Type.getFirst());
        setTurn_cnt(0);
        setPass(true);
        return;
    }

    public Framework_Board(Framework_Board copy) {
        setCur_turn(copy.cur_turn);
        setTurn_cnt(copy.turn_cnt);
    }

    public Framework_Board clone() {
        return new Framework_Board(this);
    }

    public void setCur_turn(Type t) { cur_turn = t; }

    public void setTurn_cnt(int n) { turn_cnt = n; }

    public void setPass(boolean b) { pass = b; }

    public Type getCur_turn() { return cur_turn; }

    public int getTurn_cnt() { return turn_cnt; }

    public boolean getPass() { return pass; }

    public void init() {
        return;
    }

    public void start() {
        return;
    }

    public void update() {
        setTurn_cnt(getTurn_cnt()+1);
        if(getPass() == true) {
            setPass(false);
            return;
        }
        setCur_turn(getCur_turn().getReverse());
        return;
    }

    public void print() {
        return;
    }

    public String toString() {
        String s = "";
        s = String.format("<<Turn %d: %s>>", getTurn_cnt(), getCur_turn());
        return s;
    }
}
