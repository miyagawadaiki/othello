//座標のクラス
public class Coord {
    public final int x;
    public final int y;

    public Coord(int x, int y) {
        //もし盤面内の座標でなければ
        if(x > 7 || x < 0 || y > 7 || y < 0)
            //例外を吐く
            throw new IllegalArgumentException("no such coord in the game-board : (" + x + "," + y + ")");

        this.x = x;
        this.y = y;
    }

    public Coord(Coord copy) {
        this.x = copy.x;
        this.y = copy.y;
    }

    public Coord clone() {
        return new Coord(this);
    }

    public String toString() {
        String s = "";
        s += String.format("(%d,%d)", x, y);
        return s;
    }
}
