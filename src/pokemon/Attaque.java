package pokemon;

import java.util.Objects;

public class Attaque {
    private String name;
    private String description;
    private Type type;
    private int puissance;
    private AttaqueCategorie categorie;

    public Attaque(String name, String description, Type type, int puissance, AttaqueCategorie categorie) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.puissance = puissance;
        this.categorie = categorie;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    public int getPuissance() {
        return puissance;
    }

    public AttaqueCategorie getCategorie() {
        return categorie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attaque attaque = (Attaque) o;
        return name.equals(attaque.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "pokemon.Attaque{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", puissance=" + puissance +
                ", categorie=" + categorie +
                '}';
    }
}
