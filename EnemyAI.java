public abstract class EnemyAI {
    Board board;
    Coord ans;

    public EnemyAI(Board board) {
        this.board = board.clone();
    }

    public Coord excute() {
        ans = solve();
        System.out.println(this);
        return ans;
    }

    public String toString() {
        String s = "";
        s += String.format("%d %d", ans.x, ans.y);
        return s;
    }

    public abstract Coord solve();
}
