package Figure;

import NewPackage.Figure;
import NewPackage.Tile;

import java.awt.*;

public class DogEatingBug extends Figure {

    public DogEatingBug(int row, int col, Color color) {
        super(row, col);
        this.color = color;
        this.attack = 10;
        this.defense = 2;
        this.magic = 8;
        this.speed = 5;
    }

    @Override
    public void Draw(Graphics g) {
        int x = this.col * Tile.TILE_SIZE;
        int y = this.row * Tile.TILE_SIZE;

        g.setColor(this.color);
        g.fillRect(x + 10,y + 10,50,50);
        g.setColor(Color.BLACK);
        g.drawString(" DB ", x + 30, y + 40);
    }
}

