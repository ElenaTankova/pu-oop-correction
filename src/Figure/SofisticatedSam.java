package Figure;
import NewPackage.Figure;
import NewPackage.Tile;

import java.awt.*;

public class SofisticatedSam extends Figure {

    public SofisticatedSam(int row, int col, Color color) {
        super(row, col);
        this.color = color;
        this.attack = 10;
        this.defense = 5;
        this.magic = 4;
        this.speed = 1;
    }

    public void Draw(Graphics g) {
        int x = this.col * Tile.TILE_SIZE;
        int y = this.row * Tile.TILE_SIZE;

        g.setColor(this.color);
        g.fillRect(x + 10,y + 10,50,50);
        g.setColor(Color.BLACK);
        g.drawString(" SS ", x + 30, y + 40);
    }

}
