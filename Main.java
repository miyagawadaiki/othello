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

    public static void excuteP_VS_P() {
        Board b = new Board();
        b.start();
        while(b.update() == true) {
            while(b.put(b.getCur_type(),read()) == false);
        }
    }

    public static void excuteP_VS_AI() {
        Board b = new Board();
        b.start();
        while(b.update() == true) {
            if(b.getCur_type().equals(Type.getFirst()) == true) {
                while(b.put(b.getCur_type(),read()) == false);
            }
            else {
                EnemyAI ai = new Simple_AI(b);
                b.put(b.getCur_type(),ai.excute());
            }
        }
    }

    public static void excuteAI_VS_AI() {
        Board b = new Board();
        b.start();
        while(b.update() == true) {
            if(b.getCur_type().equals(Type.getFirst()) == true) {
                EnemyAI enemy1 = new Simple_AI(b);
                b.put(b.getCur_type(),enemy1.excute());
            }
            else {
                EnemyAI enemy2 = new Random_AI(b);
                b.put(b.getCur_type(),enemy2.excute());
            }
        }
    }

    public static void main(String[] args) {
        excuteAI_VS_AI();
    }
}
