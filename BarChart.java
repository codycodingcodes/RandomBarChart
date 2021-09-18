import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BarChart implements ActionListener {
    JFrame frame = new JFrame("Random Bar Chart");
    JPanel panel = new JPanel();
    JButton button = new JButton("Redraw");

    /*
     * BarChart() constructor - constructs initial JFrame with our redraw button and
     * grid
     */
    BarChart() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        frame.setLayout(new BorderLayout());

        panel.setLayout(new BorderLayout());

        // button action listener
        button.addActionListener(this);
        // add button to panel
        panel.add(button);
        // add button panel to the bottom of frame
        frame.add(panel, BorderLayout.SOUTH);

        // add randomized grid to built frame
        frame.add(buildGrid());

        frame.setVisible(true);

    }

    /*
     * buildGrid() - builds a grid with randomized bar graph
     * 
     * @returns Grid grid - a randomized bar graph on top of a grid
     */
    public Grid buildGrid() {
        Grid grid = new Grid();
        return grid;
    }

    /*
     * actionPerformed(ActionEvent e) - each button press, we add new random grid to
     * our frame and set visibility to true
     */
    public void actionPerformed(ActionEvent e) {
        frame.add(buildGrid());
        frame.setVisible(true);
    }
}
