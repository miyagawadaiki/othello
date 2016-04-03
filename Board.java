public class Board {
    Framework_Board fr_board = new Framework_Board();
    StateBoard st_board = new StateBoard();
    CanPutBoard black = new CanPutBoard(Type.BLACK);
    CanPutBoard white = new CanPutBoard(Type.WHITE);

    public Board() {

    }

    public boolean put(Type t, Coord c) {
        boolean is_anime;
        switch(t) {
        case BLACK:
            if(black.get(c) == false) return false;
            is_anime = st_board.turn(t.toState(),c);
            turn(t,c);
            break;
        case WHITE:
            if(white.get(c) == false) return false;
            is_anime = st_board.turn(t.toState(),c);
            turn(t,c);
            break;
        default:
            break;
        }
        return true;
    }

    public void turn(Type t, Coord c) {
        int[] dx = {0,-1,-1,-1,0,1,1,1};
        int[] dy = {1,1,0,-1,-1,-1,0,1};
        for(int i=0;i<8;i++) {
            Coord next;
            try { next = new Coord(c.x+dx[i], c.y+dy[i]); }
            catch(IllegalArgumentException e) { continue; }
            if(st_board.get(next).equals(t.getReverse().toState()) == true) {
                turn_recursion(t,next,dx[i],dy[i]);
            }
        }
    }

    public boolean turn_recursion(Type t, Coord c, int dx, int dy) {
        Coord next;
        try {next = new Coord(c.x+dx, c.y+dy);}
        catch(IllegalArgumentException e) {return false;}
        if(st_board.get(next).equals(State.NONE) == true) return false;
        else if(st_board.get(next).equals(t.toState()) == true) {
            st_board.turn(t.toState(),c);
            return true;
        }
        else {
            boolean b = false;
            if(b = turn_recursion(t, next, dx, dy) == true)
                st_board.turn(t.toState(),c);
            return b;
        }
    }

    public void calcCanPut() {
        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                if(st_board.get(new Coord(i,j)).getId() > State.NONE.getId()) continue;
                if(checkCanPut(Type.BLACK,new Coord(i,j)) == true) {
                    black.enable(new Coord(i,j));
                }
                if(checkCanPut(Type.WHITE,new Coord(i,j)) == true) {
                    white.enable(new Coord(i,j));
                }
            }
        }
        return;
    }

    public boolean checkCanPut(Type put_type, Coord c) {
        int[] dx = {0,-1,-1,-1,0,1,1,1};
        int[] dy = {1,1,0,-1,-1,-1,0,1};
        for(int i=0;i<8;i++) {
            Coord temp;
            try { temp = new Coord(c.x+dx[i], c.y+dy[i]); }
            catch(IllegalArgumentException e) { continue; }
            if(st_board.get(temp).equals(put_type.getReverse().toState()) == true) {
                boolean flag = false;
                while(true) {
                    try { temp = new Coord(temp.x+dx[i], temp.y+dy[i]); }
                    catch(IllegalArgumentException e) { break; }
                    if(st_board.get(temp).equals(put_type.toState()) == true) {
                        flag = true;
                        break;
                    }
                }
                if(flag == true) return true;
            }
        }
        return false;
    }

    public boolean isPass() {
        if(fr_board.cur_turn.equals(Type.BLACK) == true)
            return black.count == 0;
        else
            return white.count == 0;
    }

    public boolean isEnd() {
        if(fr_board.turn_cnt > 60) return true;
        if(fr_board.cur_turn.equals(Type.BLACK) == true)
            return st_board.getB_num() == 0;
        else
            return st_board.getW_num() == 0;
    }

    public void start() {
        fr_board.start();
        st_board.start();
        black.start();
        white.start();

//        calcCanPut();
//        print();
        return;
    }

    public void update() {
        fr_board.update();
        st_board.update();
        black.update();
        white.update();

        calcCanPut();
        if(isEnd() == true) EndPrint();
        print();
        return;
    }

    public void print() {
        System.out.println(fr_board);
        System.out.print(this);
        System.out.println(st_board);
        System.out.println();
        if(fr_board.cur_turn.equals(Type.BLACK) == true)
            System.out.println(black);
        else
            System.out.println(white);

        System.out.println("\n\n\n");
        return;
    }

    public void EndPrint() {
        System.out.println("<<<END>>>");
    }

    public String toString() {
        String s = "Board : ";

        return s;
    }
}
