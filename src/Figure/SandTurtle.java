package Figure;
import NewPackage.Figure;
import NewPackage.Tile;

import java.awt.*;

public class SandTurtle extends Figure {

    public SandTurtle(int row, int col, Color color) {
        super(row, col);
        this.color = color;
        this.attack = 5;
        this.defense = 10;
        this.magic = 1;
        this.speed = 4;
    }

    public void Draw(Graphics g) {
        int x = this.col * Tile.TILE_SIZE;
        int y = this.row * Tile.TILE_SIZE;

        g.setColor(this.color);
        g.fillRect(x + 10,y + 10,50,50);
        g.setColor(Color.BLACK);
        g.drawString(" ST ", x + 30, y + 40);
    }

}
