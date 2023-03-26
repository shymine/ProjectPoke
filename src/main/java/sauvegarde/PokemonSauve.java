package main.java.sauvegarde;

import main.java.pokemon.Attaque;
import main.java.pokemon.Pokemon;
import main.java.pokemon.Type;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class PokemonSauve implements Sauvegarde<Pokemon>{
    @Override
    public void sauvegarde(Collection<Pokemon> c, String fichier) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(fichier));
            for(Pokemon p : c) {
                String res = p.getName()+","
                        +p.getPv()+","
                        +p.getAttaque()+","
                        +p.getDefence()+","
                        +p.getAttaque_speciale()+","
                        +p.getDefence_speciale()+","
                        +p.getVitesse()+",types,";
                for(Type t: p.getTypes()) {
                    res+=t.getName()+",";
                }
                res+="possibles_attaques";
                for(Attaque a: p.getPossibles_attaques()) {
                    res+=","+a.getName();
                }
                res+="\n";
                bw.write(res);
            }

        } catch (IOException e) {
            System.out.println("Le fichier "+fichier+" n'a pas été trouvé.");
        }
    }
}
