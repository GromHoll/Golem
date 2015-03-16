package org.golem.terminal;

import lombok.Getter;
import org.golem.graphics.Color;
import org.golem.graphics.Colored;
import org.golem.graphics.Colors;

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

    public Colored getForeground() {
        return foreground;
    }

    public Colored getBackground() {
        return background;
    }

    void setCharacter(char character) {
        if (this.character == character) { return; }
        this.character = character;
        change();
    }

    void setForeground(Colored foreground) {
        if (this.foreground.getRGB() == foreground.getRGB()) { return; }
        this.foreground.setRGB(foreground.getRGB());
        change();
    }

    void setBackground(Colored background) {
        if (this.background.getRGB() == background.getRGB()) { return; }
        this.background.setRGB(background.getRGB());
        change();
    }
}
