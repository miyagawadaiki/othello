public enum Type {
    BLACK(0),
    WHITE(1);

    private final int id;

    Type(final int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Type valueOf(int id) {
        if(id == BLACK.getId()) return BLACK;
        if(id == WHITE.getId()) return WHITE;

        throw new IllegalArgumentException("no such enum object for the id: " + id);
    }

    public Type getReverse() {
        return valueOf((this.getId()+1)%2);
    }

    public static Type getFirst() {
        return BLACK;
    }

    public boolean equals(Type t) {
        return this.getId() == t.getId();
    }

    public State toState() {
        return State.valueOf(this.getId());
    }
}
