package com.urise.webapp.model;

import java.util.List;
import java.util.Objects;

public class Organization {
    private final String name;
    private final List<Period> period;

    public Organization(String name, List<Period> period) {
        this.name = name;
        this.period = period;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(name, that.name) && Objects.equals(period, that.period);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, period);
    }

    @Override
    public String toString() {
        return "Organizations{" +
                "name='" + name + '\'' +
                ", period=" + period +
                '}';
    }
}
