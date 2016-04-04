//メインクラス

import java.util.*;

public class Main {
    //メニュー用の列挙
    enum Menu {
        END(0),
        //    READ,
        P_VS_P(1),
        P_VS_AI(2),
        AI_VS_AI(3);

        private final int id;

        Menu(final int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

    //座標入力用メソッド
    public static Coord read() {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("Please input the coord");

        int x = stdIn.nextInt();
        int y = stdIn.nextInt();

        return new Coord(x,y);
    }

    //プレイヤー VS プレイヤー
    public static void excuteP_VS_P() {
        Board b = new Board();
        b.start();
        while(b.update() == true) {
            while(b.put(read()) == false);
        }
    }

    //プレイヤー VS コンピュータ
    public static void excuteP_VS_AI() {
        Board b = new Board();
        EnemyAI ai;

        b.start();
        while(b.update() == true) {
            if(b.getCur_type().equals(Type.getFirst()) == true) {
                while(b.put(read()) == false);
            }
            else {
                ai = new Simple_AI(b);
                b.put(ai.excute());
            }
        }
    }

    //コンピュータ VS コンピュータ
    public static void excuteAI_VS_AI() {
        Board b = new Board();
        EnemyAI enemy1, enemy2;

        b.start();
        while(b.update() == true) {
            if(b.getCur_type().equals(Type.getFirst()) == true) {
                enemy1 = new Simple_AI(b);
                b.put(enemy1.excute());
            }
            else {
                enemy2 = new Random_AI(b);
                b.put(enemy2.excute());
            }
        }
    }

    //メニューから命令を選んでもらう
    //終了命令を受け取るとfalseを返す
    public static boolean selectMenu() {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("---------------------------------\n");
        System.out.println("Please input your order(integer).\n");

        for(Menu i : Menu.values()) {
            System.out.printf("%s:(%d)\n", i.name(), i.getId());
        }

        System.out.print("order:");

        int order = stdIn.nextInt();

        System.out.println();

        switch(order) {
        case 1: excuteP_VS_P();   return true;
        case 2: excuteP_VS_AI();    return true;
        case 3: excuteAI_VS_AI();     return true;
        default:                    return false;
        }
    }

    //メイン関数
    public static void main(String[] args) {
        System.out.println("---------------------------------");
        System.out.println("     Welcome to the Othello!");
        while(selectMenu() == true);
        System.out.println("See you again!\n");
    }
}
