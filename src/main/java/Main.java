import org.golem.Colors;
import org.golem.ui.GolemPanel;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * @author GromHoll
 * @since 13.03.2015
 */
public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        GolemPanel panel = new GolemPanel(10, 10);
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        panel.setBackground(0, 0, Colors.WHITE);
        panel.setBackground(1, 0, Colors.LIGHTGRAY);
        panel.setBackground(2, 0, Colors.GRAY);
        panel.setBackground(3, 0, Colors.DARKGRAY);
        panel.setBackground(0, 1, Colors.RED);
        panel.setBackground(1, 1, Colors.PINK);
        panel.setBackground(2, 1, Colors.ORANGE);
        panel.setBackground(3, 1, Colors.YELLOW);
        panel.setBackground(0, 2, Colors.GREEN);
        panel.setBackground(1, 2, Colors.MAGENTA);
        panel.setBackground(2, 2, Colors.CYAN);
        panel.setBackground(3, 2, Colors.BLUE);

        panel.flush();

    }


}
