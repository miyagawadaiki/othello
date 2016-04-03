public class GameLogs {
    Log[] logs;
    int length;

    public GameLogs() {
        logs = new Log[60];
        length = 0;
    }

    @Override
    public String toString() {
        String s = "";
        for(int i=0;i<length-1;i++) {
            s += logs[i].toString() + "\n";
        }
        s += logs[length-1].toString();
        return s;
    }
}
