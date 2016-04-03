public class GameLogs {
    Log[] logs;
    int[][] order;

    public GameLogs() {
    }

    public void init() {
        order = new int[8][8];
        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                if((i==3 && j==3) || (i==3 && j==4) ||
                   (i==4 && j==3) || (i==4 && j==4))
                    continue;
                order[i][j] = -1;
            }
        }

        logs = new Log[60];
        return;
    }
}
