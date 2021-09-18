import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Grid extends JPanel {
    private final int X = 40;
    private final int Y = 20;
    private final int CELL = 30;

    private final int GRIDS = 10;

    Random rand = new Random();

    // empty grid constructor
    public Grid() {
    }

    // necessary function for Grid panel size
    public Dimension getPreferredCELL() {
        return new Dimension(400, 335);
    }

    /*
     * randomColor() randomizes 3 ints for rgb scale
     * 
     * @returns Color rColor - a randomized number
     */
    public Color randomColor() {
        int r = rand.nextInt(256);
        int gr = rand.nextInt(256);
        int b = rand.nextInt(256);

        Color rColor = new Color(r, gr, b);

        return rColor;
    }

    /*
     * paintComponent(graphics g) - prints a 10 x 10 grid and 9 random color and
     * height bar graphs
     */
    protected void paintComponent(Graphics g) {
        // set background to light gray
        this.setBackground(new Color(200, 200, 200));
        super.paintComponent(g);

        // 2D graphics for bar graph
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setStroke(new BasicStroke(9));

        // draws horizontal and vertical lines to makeup a 10 x 10 grid
        for (int i = 0; i < GRIDS + 1; i++) {
            // prints horizontal lines (x1, y1, x2, y2)
            // y1 and y2: Y + i * CELL increases the value of Y each iteration, shifting the
            // grid *10 pixels down for each new line ie. line 3 is 30 pixels shifted down
            // etc
            // x2: X + GRIDS * CELL is the max width of our grid
            g.drawLine(X, Y + i * CELL, X + GRIDS * CELL, Y + i * CELL);
            // prints vertical lines (x1, y1, x2, y2)
            // x1 and x2: X + i * CELL increase the value of X each iteration, shifting the
            // grid *10 pixels right for each new line ie. line 4 is 40 pixels shifted right
            // etc
            // y2: Y + GRIDS * CELLS is the max height for our grid
            g.drawLine(X + i * CELL, Y, X + i * CELL, Y + GRIDS * CELL);
        }

        // print 9 bars of random color and height
        for (int i = 1; i <= 9; i++) {
            // set random Color
            g2d.setColor(randomColor());
            // find random number bound between 310 and 25 as that is top and bottom of
            // graph
            int randNum = rand.nextInt(310 - 25) + 25;
            // draw lines shifting X by (10 * i) for each iteration, and setting y2: height
            // to a random number
            g2d.drawLine(X + (CELL * i), 315, X + (CELL * i), randNum);
        }
    }
}
