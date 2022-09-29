package com.urise.webapp.model;

import java.util.List;
import java.util.Objects;

public class Organizations {
    private final String name;
    private final List<Period> period;

    public Organizations(String name, List<Period> period) {
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
        Organizations that = (Organizations) o;
        return name.equals(that.name) && period.equals(that.period);
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
