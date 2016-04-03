import java.util.Random;

public class Random_AI extends EnemyAI {
    public Random_AI(Board board) {
        super(board);
    }

    public Coord solve() {
        Random rand = new Random();
        Coord c;
        while(true) {
            if(board.getCP(c = new Coord(rand.nextInt(8), rand.nextInt(8))) == true)
                return c;
        }
    }
}
