package main.java.sauvegarde;

import main.java.pokemon.Attaque;
import main.java.pokemon.Pokemon;
import main.java.pokemon.Type;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class AttaqueSauve implements Sauvegarde<Attaque> {
    @Override
    public void sauvegarde(Collection<Attaque> c, String fichier) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(fichier));
            for(Attaque a : c) {
                String res = a.getName()+","+
                        a.getDescription()+","+
                        a.getType().getName()+","+
                        a.getPuissance()+","+
                        a.getCategorie().name();
                res+="\n";
                bw.write(res);
            }

        } catch (IOException e) {
            System.out.println("Le fichier "+fichier+" n'a pas été trouvé.");
        }
    }
}
