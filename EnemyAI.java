//AI作成のための抽象クラス
//継承して使う
public abstract class EnemyAI {
    Board board;
    Coord ans;

    public EnemyAI(Board board) {
        //boardに盤面の状態がある
        this.board = board.clone();
    }

    //実行用メソッド
    //AIが指す位置の座標を返す
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

    //抽象メソッド
    //これにAIのとる手を計算させる
    public abstract Coord solve();
}
