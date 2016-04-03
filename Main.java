import java.util.*;
/*
public enum Menu {
    READ,

}
*/

public class Main {
    public static Coord read() {
        Scanner stdIn = new Scanner(System.in);

        int x = stdIn.nextInt();
        int y = stdIn.nextInt();

        return new Coord(x,y);
    }

    public static void main(String[] args) {
        System.out.println(new Log(1,Type.BLACK,new Coord(0,0)));
        Board b = new Board();
        b.start();
        while(true) {
            b.update();
            while(b.put(b.fr_board.getCur_turn(),read()) == false);
            b.fr_board.setPass(b.isPass());
        }
    }
}
