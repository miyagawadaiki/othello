public class Simple_AI extends EnemyAI {
    public Simple_AI(Board board) {
        super(board);
    }

    public void solve() {
        Coord c;
        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                c = new Coord(i,j);
                if(board.cp_boards[board.getCur_type().getId()].get(c) == true){
                    ans = c;
                    return;
                }
            }
        }
        ans = new Coord(8,0);
        return;
    }

    public Coord excute() {
        solve();
        System.out.println(this);
        return ans;
    }

    public String toString() {
        String s = "";
        s += String.format("%d %d", ans.x, ans.y);
        return s;
    }
}
