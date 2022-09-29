package com.urise.webapp.model;

import java.util.List;
import java.util.Objects;

public class ListPeriodSection extends AbstractSection <List<Organizations>>{

    List<Organizations> organizations = getItems();

    protected ListPeriodSection(List<Organizations> items) {
        super(items);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ListPeriodSection that = (ListPeriodSection) o;
        return Objects.equals(organizations, that.organizations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), organizations);
    }

    @Override
    public String toString() {
        return "ListPeriodSection{" +
                "organizations=" + organizations +
                '}';
    }
}
