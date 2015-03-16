package org.golem.gui;

import lombok.Getter;
import org.golem.graphics.Colored;

import java.util.Arrays;

/**
 * @author GromHoll
 * @since 13.03.2015
 */
public class Bitmap {

    @Getter
    private int width;

    @Getter
    private int height;

    @Getter
    private int[] pixels;

    public Bitmap(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels = new int[width*height];
    }

    public Bitmap(int width, int height, int[] pixels) {
        if (width*height == pixels.length) {
            this.width = width;
            this.height = height;
            this.pixels = pixels;
        } else {
            throw new IllegalArgumentException("Wrong buffer size");
        }
    }

    public void fill(int color) {
        Arrays.fill(pixels, color);
    }

    public void drawRect(int x, int y, int w, int h, Colored color) {
        int x0 = Math.max(x, 0);
        int y0 = Math.max(y, 0);
        int x1 = Math.min(x + Math.max(w, 0), width);
        int y1 = Math.min(y + Math.max(h, 0), height);
        for (int yy = y0; yy < y1; yy++) {
            Arrays.fill(pixels, yy*width + x0, yy*width + x1, color.getRGB());
        }
    }
}