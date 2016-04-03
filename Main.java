import java.util.*;

public class Main {
    enum Menu {
        END(0),
        //    READ,
        AI_VS_AI(1),
        P_VS_AI(2),
        P_VS_P(3);

        private final int id;

        Menu(final int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

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

    public static boolean selectMenu() {
        Scanner stdIn = new Scanner(System.in);

        for(Menu i : Menu.values()) {
            System.out.printf("%s:(%d)\n", i.name(), i.getId());
        }

        System.out.print("What's your order?:");

        int order = stdIn.nextInt();

        switch(order) {
        case 1: excuteAI_VS_AI();   return true;
        case 2: excuteP_VS_AI();    return true;
        case 3: excuteP_VS_P();     return true;
        default:                    return false;
        }
    }

    public static void main(String[] args) {
        while(selectMenu() == true);
    }
}
