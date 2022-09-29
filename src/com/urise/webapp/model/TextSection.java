package com.urise.webapp.model;

public class TextSection extends AbstractSection <String> {

    protected TextSection(String content) {
        super(content);
    }

    @Override
    public String toString() {
        return getItems();
    }
}
