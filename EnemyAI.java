public abstract class EnemyAI {
    Board board;
    Coord ans;

    public EnemyAI(Board board) {
        this.board = board.clone();
    }

    public abstract void solve();
    public abstract Coord excute();
    public abstract String toString();
}
