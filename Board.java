public class Board implements Interface_Board {
    private StateBoard st_board;
    private CanPutBoard[] cp_boards;

    private Type cur_type;
    private int turn_cnt;
    private boolean pass;
    private boolean end;

    public Board() {
        init();
    }

    public void setCur_type(Type t) { cur_type = t; }

    public void setTurn_cnt(int n) { turn_cnt = n; }

    public void setPass(boolean b) { pass = b; }

    public void setEnd(boolean b) { end = b; }

    public Type getCur_type() { return cur_type; }

    public int getTurn_cnt() { return turn_cnt; }

    public boolean getPass() { return pass; }

    public boolean getEnd() { return end; }

    public boolean put(Type t, Coord c) {
        boolean is_anime;

        if(cp_boards[t.getId()].get(c) == false) return false;
        is_anime = st_board.turn(t.toState(),c);
        turn(t,c);

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
                    cp_boards[Type.BLACK.getId()].enable(new Coord(i,j));
                }
                if(checkCanPut(Type.WHITE,new Coord(i,j)) == true) {
                    cp_boards[Type.WHITE.getId()].enable(new Coord(i,j));
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
        return cp_boards[cur_type.getId()].count == 0;
    }

    public boolean isEnd() {
        if(st_board.getB_num() + st_board.getW_num() >= 64) return true;
        if(cur_type.equals(Type.BLACK) == true)
            return st_board.getB_num() == 0;
        else
            return st_board.getW_num() == 0;
    }

    @Override
    public void init() {
        st_board = new StateBoard();
        cp_boards = new CanPutBoard[2];
        cp_boards[0] = new CanPutBoard(Type.BLACK);
        cp_boards[1] = new CanPutBoard(Type.WHITE);
        setCur_type(Type.getFirst().getReverse());
        setTurn_cnt(0);
        setPass(false);
        setEnd(false);
        return;
    }

    @Override
    public void start() {
//        fr_board.start();
        st_board.start();
        cp_boards[0].start();
        cp_boards[1].start();

//        calcCanPut();
//        print();
        return;
    }

    @Override
    public boolean update() {
        st_board.update();
        cp_boards[0].update();
        cp_boards[1].update();

        calcCanPut();
        setTurn_cnt(getTurn_cnt()+1);
        setCur_type(getCur_type().getReverse());
        setPass(isPass());
        setEnd(isEnd());

        if(getEnd() == true) {
            EndPrint();
            print();
            return false;
        }

        if(getPass() == true) {
            setCur_type(getCur_type().getReverse());
            setPass(false);
        }

        print();
        return true;
    }

    @Override
    public void print() {
        System.out.println(this);
        System.out.println(st_board);
        System.out.println();
        System.out.println(cp_boards[cur_type.getId()]);
        System.out.println("\n\n\n");
        return;
    }

    public void EndPrint() {
        System.out.println("<<<END>>>");
    }

    @Override
    public String toString() {
        String s = "";
        s = String.format("<<Turn %d: %s>>", getTurn_cnt(), getCur_type());
        return s;
    }
}
