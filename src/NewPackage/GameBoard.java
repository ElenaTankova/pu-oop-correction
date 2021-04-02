package NewPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class GameBoard extends JFrame implements MouseListener {

    public static int firstRandomNumber;
    public static int secondRandomNumber;
    public static int rN;
    public static Random rand = new Random();
    public Object[][] tileCollection;
    public Object[][] figureCollection;
    public Object selectedFigure;
    public Object figureUnderAttack;
    public int roundCounter;
    public static int oldRow;
    public static int oldCol;
    public static Player p1 = new Player(1, true, 0, 0);
    public static Player p2 = new Player(2, false, 0, 0);
    ArrayList<String> p1BlueDeadFigures = new ArrayList<>();
    ArrayList<String> p2RedDeadFigures = new ArrayList<>();

    public GameBoard() {

        this.setSize(700, 700);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.addMouseListener(this);
        this.tileCollection = new Object[12][12];
        fillTileCollection();
        this.figureCollection = new Object[12][12];
        fillP1FigureCollection();
        fillP2FigureCollection();
        JOptionPane.showMessageDialog(null, "Играта започва! Ред е на Играч 1 с розовите фигури :)");

    }

    private void fillP2FigureCollection() {
    }

    private void fillP1FigureCollection() {
    }


    public void mouseClicked(MouseEvent e) {
        int row = this.getDimensionsBasedOnCoordinates(e.getY());
        int col = this.getDimensionsBasedOnCoordinates(e.getX());

        if (this.isThereFigure(row, col) && this.selectedFigure == null) {
            Figure fig = (Figure) figureCollection[row][col];
            if (p1.isActive) {
                if (fig.getColor() == Color.BLUE) {
                    this.selectedFigure = this.getFigure(row, col);
                    oldRow = row;
                    oldCol = col;
                    JOptionPane.showMessageDialog(null, "Фигурата е избрана успешно за Играч 1!");
                    p1.isActive = false;
                    p2.isActive = true;
                    roundCounter += 1;
                } else {
                    JOptionPane.showMessageDialog(null, "Ред е на Играч 1  " +
                            "избери синя фигура!");
                    selectedFigure = null;
                }
            } else if (p2.isActive) {
                if (fig.getColor() == Color.RED) {
                    this.selectedFigure = this.getFigure(row, col);
                    oldRow = row;
                    oldCol = col;
                    JOptionPane.showMessageDialog(null, "Фигурата е избрана успешно за Играч 2!");
                    p1.isActive = true;
                    p2.isActive = false;
                } else {
                    JOptionPane.showMessageDialog(null, "Ред е на Играч 2 " +
                            "избери червена фигура!");
                    selectedFigure = null;
                }
            }
        } else if (this.selectedFigure != null && !isThereFigure(row, col)) {
            actionFrame(row, col);

        } else if (this.selectedFigure != null && isThereFigure(row, col)) {
            this.figureUnderAttack = this.getFigure(row, col);
            actionFrame(row, col);

        } else if (this.selectedFigure != null && oldRow == row && oldCol == col) {
            JOptionPane.showMessageDialog(null, "Вие избрахте същата фигура, " +
                    "възможно е само да я излекувате");
            actionFrame(row, col);
        }
    }

    private int getDimensionsBasedOnCoordinates(int y) {

        return y;
    }

    private void actionFrame(int row, int col) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private void renderTiles(Graphics g, int row, int col) {
        if (this.isThereTile(row, col)) {
            Tile t = (Tile) this.getTile(row, col);
            t.drawTiles(g);
        }
    }

    private void renderFigures(Graphics g, int row, int col) {

        if (this.isThereFigure(row, col)) {
            Figure fig = (Figure) this.getFigure(row, col);
            fig.Draw(g);
        }
    }

    public void visualizePoints() {
        String tempP1 = "Точки на Играч 1: " + p1.getPointsReceived();
        String tempP2 = "Точки на Играч 2: " + p2.getPointsReceived();
        this.setTitle(tempP1 + "                   Knights, Elves and Dwarves                   " + tempP2);

    }

    @Override
    public void paint(Graphics g) {

        for (int row = 0; row < 12; row++) {
            for (int col = 0; col < 12; col++) {

                this.renderTiles(g, row, col);
                this.renderFigures(g, row, col);
                visualizePoints();
            }
        }
    }


    public Object getFigure(int row, int col) {
        return this.figureCollection[row][col];
    }


    public boolean isThereFigure(int row, int col) {
        return this.getFigure(row, col) != null;
    }

    public Object getTile(int row, int col) {
        return this.tileCollection[row][col];
    }


    public boolean isThereTile(int row, int col) {
        return this.tileCollection[row][col] != null;
    }

    public void fillTileCollection() {

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                this.tileCollection[i][j] = (new Player1Territory(i, j));
            }
        }

        for (int i = 2; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                this.tileCollection[i][j] = (new Field(i, j));
            }
        }

        for (int i = 5; i <= 12; i++) {
            for (int j = 0; j < 12; j++) {
                this.tileCollection[i][j] = (new Player2Territory(i, j));
            }
        }
        

        getRandomNumberOfObstacles();
        for (int i = 0; i <= rN; i++) {
            getRandomPositionForObstacle();
            this.tileCollection[firstRandomNumber][secondRandomNumber] =
                    new Obstacle(firstRandomNumber, secondRandomNumber);
        }
    }

    public static void getRandomPositionForP1Figure() {

        firstRandomNumber = rand.nextInt(0);
        secondRandomNumber = rand.nextInt(12);
    }

    public static void getRandomPositionForP2Figure() {
        firstRandomNumber = rand.nextInt(0);
        secondRandomNumber = rand.nextInt(12);
        while (firstRandomNumber != 5 && firstRandomNumber != 6) {
            firstRandomNumber = rand.nextInt(0);
            secondRandomNumber = rand.nextInt(12);
        }
    }

    public static void getRandomNumberOfObstacles() {
        while (rN == 0) {
            rN = rand.nextInt(5);
        }
    }

    public static void getRandomPositionForObstacle() {
        firstRandomNumber = rand.nextInt(12);
        secondRandomNumber = rand.nextInt(12);
        while (firstRandomNumber != 2 && firstRandomNumber != 3 && firstRandomNumber != 4) {
            firstRandomNumber = rand.nextInt(12);
        }
    }

}
