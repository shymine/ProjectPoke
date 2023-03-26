import main.java.pokemon.Attaque;
import main.java.pokemon.Pokemon;
import main.java.pokemon.Type;
import main.java.sauvegarde.GenerateurSauveurManager;
import main.java.utils.Triple;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        GenerateurSauveurManager manager = new GenerateurSauveurManager();
        Triple<List<Type>,List<Attaque>,List<Pokemon>> res = manager.genere();
        System.out.println(res.getPremier());
        System.out.println(res.getSecond());
        System.out.println(res.getTroisieme());
    }
}