package sauvegarde;

import pokemon.Type;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class TypeSauve implements Sauvegarde<Type> {
    @Override
    public void sauvegarde(Collection<Type> c, String fichier) {
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new FileWriter(fichier));
            for(Type t: c) {
                String res = "Type;"+t.getName()+";faiblesses;";
                for(Type t2: t.getFaiblesses()) {
                    res += t2.getName()+";";
                }
                res += "resistances;";
                for(Type t2: t.getResistances()) {
                    res += ";"+t2.getName();
                }
                res += "\n";
                bw.write(res);
            }
        } catch (IOException e) {
            System.out.println("Le fichier "+fichier+" n'a pas été trouvé.");
        }
    }
}