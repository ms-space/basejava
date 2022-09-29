package com.urise.webapp.model;

import java.util.Objects;

public abstract class AbstractSection <T> {
    private final T items;

    protected AbstractSection(T items) {
        this.items = items;
    }

    public T getItems() {
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractSection<?> that = (AbstractSection<?>) o;
        return Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }
}