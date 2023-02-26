package pokemon;

import java.util.ArrayList;

public class Type {
    private String name;
    private ArrayList<Type> faiblesses;
    private ArrayList<Type> resistances;

    public Type(String name) {
        this.name = name;
        this.faiblesses = new ArrayList<>();
        this.resistances = new ArrayList<>();
    }

    public void addFaiblesse(Type t) {
        this.faiblesses.add(t);
    }

    public void addResistance(Type t) {
        this.resistances.add(t);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Type> getFaiblesses() {
        return faiblesses;
    }

    public ArrayList<Type> getResistances() {
        return resistances;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return name.equals(type.name);
    }

    @Override
    public String toString() {
        return "pokemon.Type{" +
                "name='" + name + '\'' +
                ", faiblesses=" + faiblesses +
                ", resistances=" + resistances +
                '}';
    }
}
