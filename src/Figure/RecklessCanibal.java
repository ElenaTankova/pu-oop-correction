package Figure;

import NewPackage.Figure;
import NewPackage.Tile;

import java.awt.*;

public class RecklessCanibal extends Figure {

    public RecklessCanibal(int row, int col, Color color) {
        super(row, col);
        this.color = color;
        this.attack = 4;
        this.defense = 6;
        this.magic = 8;
        this.speed = 10;
    }

    @Override
    public void Draw(Graphics g) {
        int x = this.col * Tile.TILE_SIZE;
        int y = this.row * Tile.TILE_SIZE;

        g.setColor(this.color);
        g.fillRect(x + 10,y + 10,50,50);
        g.setColor(Color.BLACK);
        g.drawString(" R ", x + 30, y + 40);
    }
}

