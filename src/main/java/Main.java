import org.golem.graphics.Color;
import org.golem.gui.TerminalPanel;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.util.Random;

/**
 * @author GromHoll
 * @since 13.03.2015
 */
public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        TerminalPanel panel = new TerminalPanel(10, 10);
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

//        panel.setForeground(0, 1, Colors.WHITE);
//        panel.setForeground(1, 1, Colors.LIGHTGRAY);
//        panel.setForeground(2, 1, Colors.GRAY);
//        panel.setForeground(3, 1, Colors.DARKGRAY);
//        panel.setForeground(0, 2, Colors.RED);
//        panel.setForeground(1, 2, Colors.PINK);
//        panel.setForeground(2, 2, Colors.ORANGE);
//        panel.setForeground(3, 2, Colors.YELLOW);
//        panel.setForeground(0, 0, Colors.GREEN);
//        panel.setForeground(1, 0, Colors.MAGENTA);
//        panel.setForeground(2, 0, Colors.CYAN);
//        panel.setForeground(3, 0, Colors.BLUE);

//        panel.printCharacter(0, 2, 'W');
//        panel.printCharacter(1, 2, 'L');
//        panel.printCharacter(2, 2, 'G');
//        panel.printCharacter(3, 2, 'D');
//        panel.printCharacter(0, 0, 'R');
//        panel.printCharacter(1, 0, 'P');
//        panel.printCharacter(2, 0, 'O');
//        panel.printCharacter(3, 0, 'Y');
//        panel.printCharacter(0, 1, 'G');
//        panel.printCharacter(1, 1, 'M');
//        panel.printCharacter(2, 1, 'C');
//        panel.printCharacter(3, 1, 'B');

        Random r = new Random();
        while (true) {
            Color color = new Color(r.nextInt());
            System.out.println("New color " + color.getRGB());
            for (int x = 0; x < panel.getWidthInChars(); x++) {
                for (int y = 0; y < panel.getHeightInChars(); y++) {
                    panel.setBackground(x, y, color);
                }
            }
            panel.flush();
        }


    }


}
