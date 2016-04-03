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
        Board b = new Board();
        b.start();
        while(b.update() == true) {
            while(b.put(b.getCur_type(),read()) == false);
        }
    }
}
