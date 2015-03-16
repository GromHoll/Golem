package org.golem.ui;

import lombok.Getter;

/**
 * @author GromHoll
 * @since 14.03.2015
 */
public abstract class Changeable {

    @Getter
    protected boolean changed = true;

    protected void reset() {
        changed = false;
    }

    protected void change() {
        changed = true;
    }

}
