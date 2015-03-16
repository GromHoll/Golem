package org.golem.gui;

import lombok.Getter;
import org.golem.graphics.Colored;
import org.golem.graphics.Colors;
import org.golem.terminal.Terminal;
import org.golem.terminal.TerminalBuffer;
import org.golem.terminal.TerminalCell;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * @author GromHoll
 * @since 13.03.2015
 */
// TODO needs synchronizations
public class TerminalPanel extends Component implements Terminal {

    public static final int DEFAULT_CELL_SIZE = 20;

    @Getter
    private final int widthInChars;

    @Getter
    private final int heightInChars;

    @Getter
    private boolean flushed = true;

    private final TerminalBuffer buffer;

    private final BufferedImage bufferedImage;
    private final Bitmap bitmap;

    public TerminalPanel(int widthInChars, int heightInChars) {
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
        synchronized (buffer) {
            buffer.setCharacter(x, y, symbol);
        }
    }

    @Override
    public void setBackground(int x, int y, Colored color) {
        synchronized (buffer) {
            buffer.setBackground(x, y, color);
        }
    }

    @Override
    public void setForeground(int x, int y, Colored color) {
        synchronized (buffer) {
            buffer.setForeground(x, y, color);
        }
    }

    @Override
    public void flush() {
        flushed = true;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        if (flushed) {
            synchronized (buffer) {
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

                    g.drawImage(bufferedImage, 0, 0, null);

                    // TODO add font support to bitmap (or don't use bitmap
                    for (int x = 0; x < buffer.getWidth(); x++) {
                        for (int y = 0; y < buffer.getHeight(); y++) {
                            TerminalCell cell = buffer.getCell(x, y);
                            g.setColor(new Color(cell.getForeground().getRGB()));
                            String symbol = String.valueOf(cell.getCharacter());
                            g.setFont(new Font("default", Font.BOLD, 16));
                            g.drawString(symbol, x*DEFAULT_CELL_SIZE + 5, (1+y)*DEFAULT_CELL_SIZE - 5);
                        }
                    }
                }
                buffer.reset();
            }
            flushed = false;
        }
        g.dispose();
    }

}
