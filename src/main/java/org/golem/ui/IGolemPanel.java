package org.golem.ui;

import org.golem.Colorable;

/**
 * @author GromHoll
 * @since 13.03.2015
 */
// TODO Rename
public interface IGolemPanel {

    public int getWidthInChars();
    public int getHeightInChars();

    public void printCharacter(int x, int y, char character);
    public void setBackground(int x, int y, Colorable color);
    public void setForeground(int x, int y, Colorable color);

    public boolean isFlushed();
    public void flush();

}
