package org.golem;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * @author GromHoll
 * @since 13.03.2015
 */
@NoArgsConstructor
public class Symbol {

    @Getter @Setter
    private char symbol = ' ';

    @Getter @Setter
    private Colorable foreground = Colors.WHITE;

    @Getter @Setter
    private Colorable background = Colors.BLACK;


    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Color will be shared object
     */
    public Symbol(char symbol, Colorable foreground) {
        this.symbol = symbol;
        this.foreground = foreground;
    }

    /**
     * Color will be shared object
     */
    public Symbol(char symbol, Colorable foreground, Colorable background) {
        this.symbol = symbol;
        this.foreground = foreground;
        this.background = background;
    }

    public Symbol(char symbol, int foreground) {
        this.symbol = symbol;
        this.foreground = new Color(foreground);
    }

    public Symbol(char symbol, int foreground, int background) {
        this.symbol = symbol;
        this.foreground = new Color(foreground);
        this.background = new Color(background);
    }




}
