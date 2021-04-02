package NewPackage;
import java.awt.*;

public abstract class Tile {


    protected int row;
    protected int col;
    protected String id;
    protected boolean isObstacle;
    public static final int TILE_SIZE = 70;
    public static Color Gray = new Color(221, 221, 221);
    public static Color nGray = new Color(170, 170, 170);
    public static Color nBlack = new Color(68, 68, 68);


    public Tile (int row, int col) {

        this.row = row;
        this.col = col;
    }

    public abstract void drawTiles(Graphics g);

    public void drawBorders(Graphics g, int tileX, int tileY) {

        g.setColor(nBlack);
        g.drawRect(tileX,tileY,TILE_SIZE,TILE_SIZE);
    }

    public String getId() {
        return id;
    }


}
