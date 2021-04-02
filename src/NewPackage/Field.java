package NewPackage;
import java.awt.*;

public class Field extends Tile {

        public Color color;

        public Field(int row, int col) {
            super(row, col);
            this.id = "F";
            color = Gray;
        }

    @Override
    public void drawTiles(Graphics g) {
        int tileX = this.col * this.TILE_SIZE;
        int tileY = this.row * this.TILE_SIZE;

        if (this.row == 2 || this.row == 3 || this.row == 4) {
            g.setColor(Gray);
            g.fillRect(tileX,tileY,TILE_SIZE,TILE_SIZE);
            drawBorders(g,tileX,tileY);
        }
    }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

}
