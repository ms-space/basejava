package com.urise.webapp.model;

import java.util.List;

public class ListSection extends AbstractSection <List<String>> {

    protected ListSection(List<String> items) {
        super(items);
    }

    @Override
    public String toString() {
        return getItems().toString();
    }
}
