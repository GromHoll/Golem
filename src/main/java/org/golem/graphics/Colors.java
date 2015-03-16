package org.golem.graphics;

/**
 * @author GromHoll
 * @since 13.03.2015
 */
public enum Colors implements Colored {

    WHITE     (255, 255, 255),
    LIGHTGRAY (192, 192, 192),
    GRAY      (128, 128, 128),
    DARKGRAY  ( 64,  64,  64),
    BLACK     (  0,   0,   0),
    RED       (255,   0,   0),
    PINK      (255, 175, 175),
    ORANGE    (255, 200,   0),
    YELLOW    (255, 255,   0),
    GREEN     (  0, 255,   0),
    MAGENTA   (255,   0, 255),
    CYAN      (  0, 255, 255),
    BLUE      (  0,   0, 255);

    private final Color color;

    private Colors(int r, int g, int b) {
        color = new Color(r, g, b);
    }

    public Color create() {
        return color.copy();
    }

    @Override
    public int getRGB() {
        return color.getRGB();
    }
}