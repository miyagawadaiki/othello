public enum State {
    NONE(-1,' '),
    BLACK(0,'O'),
    WHITE(1,'@');

    private final int id;
    private final char label;

    State(final int id, final char label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public char getLabel() {
        return label;
    }

    public static State valueOf(int id) {
        for(State i : values()) {
            if(i.getId() == id) {
                return i;
            }
        }

        throw new IllegalArgumentException("no such enum object for the id: " + id);
    }

    public boolean equals(State c) {
        if(this.getId() == c.getId()) return true;
        else return false;
    }

    public Type toType() {
        if(this.equals(NONE) == true)
            throw new IllegalArgumentException("cannot convert such enum");
        return Type.valueOf(this.getId());
    }

    public String toString() {
        return getLabel() + "";
    }
}
