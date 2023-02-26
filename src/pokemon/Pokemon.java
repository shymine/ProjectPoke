package pokemon;

import exceptions.AttaqueNonApprenableException;
import pokemon.Attaque;

import java.util.ArrayList;

public class Pokemon {
    private String name;
    private ArrayList<Type> types;
    private ArrayList<Attaque> possibles_attaques;
    private int pv;
    private int attaque;
    private int defence;
    private int attaque_speciale;
    private int defence_speciale;
    private int vitesse;

    public Pokemon(String name, ArrayList<Type> types, ArrayList<Attaque> possibles_attaques, int pv, int attaque, int defence, int attaque_speciale, int defence_speciale, int vitesse) {
        this.name = name;
        this.types = types;
        this.possibles_attaques = possibles_attaques;
        this.pv = pv;
        this.attaque = attaque;
        this.defence = defence;
        this.attaque_speciale = attaque_speciale;
        this.defence_speciale = defence_speciale;
        this.vitesse = vitesse;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Type> getTypes() {
        return types;
    }

    public ArrayList<Attaque> getPossibles_attaques() {
        return possibles_attaques;
    }


    public int getPv() {
        return pv;
    }

    public int getAttaque() {
        return attaque;
    }

    public int getDefence() {
        return defence;
    }

    public int getAttaque_speciale() {
        return attaque_speciale;
    }

    public int getDefence_speciale() {
        return defence_speciale;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTypes(Type type) {
        this.types.add(type);
    }

    public void addPossibles_attaques(Attaque attaque) {
        this.possibles_attaques.add(attaque);
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setAttaque_speciale(int attaque_speciale) {
        this.attaque_speciale = attaque_speciale;
    }

    public void setDefence_speciale(int defence_speciale) {
        this.defence_speciale = defence_speciale;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }
}
