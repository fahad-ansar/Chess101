package Controller;

public enum MovesLimit {
    EASY(50),MEDIUM(100),HARD(500),EXPERT(1000000000);


    private int limit = 0;
    MovesLimit(int l){limit=l;}
    public int getLimit(){return limit;}
}
