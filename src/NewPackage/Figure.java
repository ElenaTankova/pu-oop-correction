package NewPackage;

import java.awt.*;

public abstract class Figure {


    protected int row;
    protected int col;
    protected Color color;
    protected int attack;
    protected int defense;
    protected int magic;
    protected int speed;



    public Figure(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public abstract void Draw(Graphics g);

    public void move(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getSpeed() {
        return speed;
    }

    public Color getColor() {
        return color;
    }


}
