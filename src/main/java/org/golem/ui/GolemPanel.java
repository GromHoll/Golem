package org.golem.ui;

import lombok.Getter;
import org.golem.Colorable;
import org.golem.Colors;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * @author GromHoll
 * @since 13.03.2015
 */
// TODO needs synchronizations
public class GolemPanel extends Component implements IGolemPanel {

    public static final int DEFAULT_CELL_SIZE = 20;

    @Getter
    private final int widthInChars;

    @Getter
    private final int heightInChars;

    @Getter
    private boolean flushed = true;

    private TerminalBuffer buffer;

    private final BufferedImage bufferedImage;
    private final Bitmap bitmap;

    public GolemPanel(int widthInChars, int heightInChars) {
        this.widthInChars = widthInChars;
        this.heightInChars = heightInChars;
        this.buffer = new TerminalBuffer(widthInChars, heightInChars);
        this.bufferedImage = new BufferedImage(widthInChars*DEFAULT_CELL_SIZE, heightInChars*DEFAULT_CELL_SIZE, BufferedImage.TYPE_INT_ARGB);
        this.bitmap = new Bitmap(bufferedImage.getWidth(), bufferedImage.getHeight(), ((DataBufferInt) bufferedImage.getRaster().getDataBuffer()).getData());
        this.bitmap.fill(Colors.BLACK.getRGB());
        this.setPreferredSize(new Dimension(bufferedImage.getWidth(), bufferedImage.getHeight()));
    }

    @Override
    public void printCharacter(int x, int y, char symbol) {
        buffer.setCharacter(x, y, symbol);
    }

    @Override
    public void setBackground(int x, int y, Colorable color) {
        buffer.setBackground(x, y, color);
    }

    @Override
    public void setForeground(int x, int y, Colorable color) {
        buffer.setForeground(x, y, color);
    }

    @Override
    public void flush() {
        if (buffer.isChanged()) {
            for (int x = 0; x < buffer.getWidth(); x++) {
                for (int y = 0; y < buffer.getHeight(); y++) {
                    TerminalCell cell = buffer.getCell(x, y);
                    if (cell.isChanged()) {
                        bitmap.drawRect(x*DEFAULT_CELL_SIZE, y*DEFAULT_CELL_SIZE,
                                        DEFAULT_CELL_SIZE, DEFAULT_CELL_SIZE,
                                        cell.getBackground());
                    }
                }
            }
            flushed = true;
        }
    }


    @Override
    public void paint(Graphics g) {
        if (flushed) {
            if (buffer.isChanged()) {
                g.drawImage(bufferedImage, 0, 0, null);
            }
            buffer.reset();
            flushed = false;
        }
    }

}
