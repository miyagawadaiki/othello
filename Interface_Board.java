public interface Interface_Board {
    public abstract void init();        //初期化用
    public abstract void start();       //ゲーム開始時用
    public abstract boolean update();   //ターン終了後に読み込まれ、次のターンに移る
    public abstract void print();       //情報表示用
    public abstract String toString();
}
