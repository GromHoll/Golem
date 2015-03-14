package org.golem.ui;

import lombok.Getter;
import org.golem.Color;
import org.golem.Colorable;
import org.golem.Colors;

/**
 * @author GromHoll
 * @since 14.03.2015
 */
// TODO add readonly interface
public class TerminalCell extends Changeable {

    @Getter
    private char character = ' ';

    private Color foreground = Colors.WHITE.create();
    private Color background = Colors.BLACK.create();

    public Colorable getForeground() {
        return foreground;
    }

    public Colorable getBackground() {
        return background;
    }

    public void setCharacter(char character) {
        if (this.character == character) { return; }
        this.character = character;
        change();
    }

    public void setForeground(Colorable foreground) {
        if (this.foreground.getRGB() == foreground.getRGB()) { return; }
        this.foreground.setRGB(foreground.getRGB());
        change();
    }

    public void setBackground(Colorable background) {
        if (this.background.getRGB() == background.getRGB()) { return; }
        this.background.setRGB(background.getRGB());
        change();
    }
}
