# othelloを作ってみました

##機能
* プレイヤー VS プレイヤー
* プレイヤー VS AI
* AI VS AI(見るだけ)
* 使うAIの選択      <- 準備中
* 対局ログを読み込む <- 準備中
* 対局ログを吐き出す <- 準備中

##使い方
`cd othello`でディレクトリへ
`javac *.java`でコンパイルし、
`java Main`で実行できます。

実行するとメニューが出てきます。整数を入力してメニューを選んでください。
自分が指す場合、

> x y

のようにx座標とy座標を入力してください。
0を入力すると終了します。
##拡張できますよ
AIを自由に作ることができます。

```Simple_AI.java
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
```

上のように`EnemyAI.java`を継承し`solve()`をオーバーライドして、AIが次に指す位置の座標を返してください。
引数付きコンストラクタは必ず記述してください。

###拡張作業に伴って使いそうな要素たち
Boardクラス、StateBoardクラス、CanPutBoardクラスを主に使うかと。

* Boardクラスに大概の要素は集まってます。探索のために次のターンに行きたい時は、`board.update()`してください。
* StateBoardクラスに今の盤面が記録されています。
* CanPutBoardクラスは石を置くことができる位置を記録しています。
