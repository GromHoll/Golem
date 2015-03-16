package org.golem.graphics;

/**
 * @author GromHoll
 * @since 13.03.2015
 */
public class Color implements Colored {

    private int rgb;

    public Color(int red, int green, int blue) {
        setRGB(red, green, blue);
    }

    public Color(int rgb) {
        setRGB(rgb);
    }

    @Override
    public int getRGB() {
        return rgb;
    }

    public void setRGB(int rgb) {
        this.rgb = 0xFF000000 | rgb;
    }

    public void setRGB(int red, int green, int blue) {
        validateColorValueRange(red, green, blue);
        rgb = 0xFF000000 |
            ((red   & 0xFF) << 16) |
            ((green & 0xFF) << 8 ) |
            (blue  & 0xFF);
    }

    public final Color copy() {
        return new Color(rgb);
    }

    private void validateColorValueRange(int r, int g, int b) {
        if (r < 0 || r > 255 ||
            g < 0 || g > 255 ||
            b < 0 || b > 255) {
            throw new IllegalArgumentException("Color parameters outside of expected range");
        }
    }
}
