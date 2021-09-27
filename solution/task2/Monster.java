package task2;

import task2.Line.Position;

public class Monster implements Linable {

    private final int r;
    private final int g;
    private final int b;
    private int rank;
    private Position position;

    Monster(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
        setRank(((r << 16) + (g << 8) + b) / 2048);
    }

    @Override
    public void setRank(int rank){
        this.rank = rank;
    }

    @Override
    public int getRank(){
        return this.rank;
    }
    
    @Override
    public String toString() {
        return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m " + this.rank + " \033[0m";

    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

}