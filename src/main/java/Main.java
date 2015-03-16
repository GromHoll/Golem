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
        TerminalPanel panel = new TerminalPanel(30, 30);
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

        int currentR = r.nextInt(256);
        int currentG = r.nextInt(256);
        int currentB = r.nextInt(256);

        int targetR = r.nextInt(256);
        int targetG = r.nextInt(256);
        int targetB = r.nextInt(256);
        Color color = new Color(currentR, currentG, currentB);

        long timeBefore = System.nanoTime();
        long timeAfter;
        long timeDelta;

        while (true) {
            if (currentR == targetR) {
                targetR = r.nextInt(256);
            } else {
                currentR += (currentR < targetR) ? 1 : -1;
            }
            if (currentG == targetG) {
                targetG = r.nextInt(256);
            } else {
                currentG += (currentG < targetG) ? 1 : -1;
            }
            if (currentB == targetB) {
                targetB = r.nextInt(256);
            } else {
                currentB += (currentB < targetB) ? 1 : -1;
            }

            color.setRGB(currentR, currentG, currentB);

            for (int x = 0; x < panel.getWidthInChars(); x++) {
                for (int y = 0; y < panel.getHeightInChars(); y++) {
                    panel.setForeground(x, y, color);
                    panel.printCharacter(x, y, '.');
                }
            }
            panel.flush();

            try {
                Thread.sleep(1000/70);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            timeAfter = System.nanoTime();
            timeDelta = timeAfter - timeBefore;
            System.out.println("FPS = " + (timeDelta == 0 ? "NaN" : (1000000000 / timeDelta)));
            timeBefore = timeAfter;
        }


    }


}
