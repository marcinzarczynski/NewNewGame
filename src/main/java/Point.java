public enum Point {
    EASY(3);

    private final int value;

    Point(int id){
        this.value=id;
    }

    public int getValue(){
        return value;
    }
}
