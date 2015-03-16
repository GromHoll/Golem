package org.golem.terminal;

import org.golem.graphics.Colored;

import java.util.Arrays;

/**
 * @author GromHoll
 * @since 14.03.2015
 */
public class TerminalBuffer extends Changeable {

    private final TerminalCell[][] buffer;

    public TerminalBuffer(int width, int height) {
        buffer = new TerminalCell[width][height];
        for (TerminalCell[] row : buffer) {
            for (int index = 0; index < row.length; index++) {
                row[index] = new TerminalCell();
            }
        }
    }

    public int getWidth() {
        return buffer.length;
    }

    public int getHeight() {
        return buffer[0].length;
    }

    public void reset() {
        Arrays.stream(buffer).flatMap(Arrays::stream).forEach(TerminalCell::reset);
        super.reset();
    }

    public void setCharacter(int x, int y, char character) {
        buffer[x][y].setCharacter(character);
        changed |= buffer[x][y].isChanged();
    }

    public void setBackground(int x, int y, Colored color) {
        buffer[x][y].setBackground(color);
        changed |= buffer[x][y].isChanged();
    }

    public void setForeground(int x, int y, Colored color) {
        buffer[x][y].setForeground(color);
        changed |= buffer[x][y].isChanged();
    }

    public TerminalCell getCell(int x, int y) {
        return buffer[x][y];
    }

}
