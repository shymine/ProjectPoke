package main.java.exceptions;
import main.java.pokemon.Attaque;
import main.java.pokemon.Pokemon;
public class AttaqueNonApprenableException extends Exception{
    public AttaqueNonApprenableException(Attaque a, Pokemon p) {
        super("L'attaque "+a.getName()+" n'est pas apprenable par "+p.getName());
    }
}
