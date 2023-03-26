package main.java.pokemon;

import java.util.ArrayList;
import java.util.List;

public class Type {
    private String name;
    private ArrayList<Type> faiblesses;
    private ArrayList<Type> resistances;
    private ArrayList<Type> immunites;

    public Type(String name) {
        this.name = name;
        this.faiblesses = new ArrayList<>();
        this.resistances = new ArrayList<>();
        this.immunites = new ArrayList<>();
    }

    public void addFaiblesse(Type t) {
        this.faiblesses.add(t);
    }

    public void addResistance(Type t) {
        this.resistances.add(t);
    }
    public void addImmunite(Type t) {
        this.immunites.add(t);
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

    public ArrayList<Type> getImmunites() {
        return immunites;
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
        return "Type{" +
                "name='" + name + '\'' +
                ", faiblesses=" + typeListToString(faiblesses) +
                ", resistances=" + typeListToString(resistances) +
                ", immunites=" + typeListToString(immunites) +
                '}';
    }

    public static String typeListToString(List<Type> l) {
        String res = "";
        for(Type t : l) {
            res += t.getName()+";";
        }
        return res;
    }
}
