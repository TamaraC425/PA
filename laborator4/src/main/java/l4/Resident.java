package l4;

import java.util.Objects;

public class Resident implements Comparable<Resident> {
    private String name;

    public Resident() {
    }

    public Resident(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Resident o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Resident)) return false;
        Resident resident = (Resident) o;
        return Objects.equals(name, resident.name);
    }
}
