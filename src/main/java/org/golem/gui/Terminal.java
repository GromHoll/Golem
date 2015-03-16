package org.golem.gui;

import org.golem.graphics.Colored;

/**
 * @author GromHoll
 * @since 13.03.2015
 */
// TODO Rename
public interface Terminal {

    public int getWidthInChars();
    public int getHeightInChars();

    public void printCharacter(int x, int y, char character);
    public void setBackground(int x, int y, Colored color);
    public void setForeground(int x, int y, Colored color);

    public boolean isFlushed();
    public void flush();

}
