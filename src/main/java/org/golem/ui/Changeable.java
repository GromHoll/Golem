package org.golem.ui;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * @author GromHoll
 * @since 14.03.2015
 */
public abstract class Changeable {

    // TODO Delete AccessLevel after fix lombok plugin
    @Getter(AccessLevel.PUBLIC)
    protected boolean changed = true;

    protected void reset() {
        changed = false;
    }

    protected void change() {
        changed = true;
    }

}
