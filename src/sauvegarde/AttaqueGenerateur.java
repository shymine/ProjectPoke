package sauvegarde;

import exceptions.TypeDontExistException;
import pokemon.Attaque;
import pokemon.AttaqueCategorie;
import pokemon.Type;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AttaqueGenerateur {
    public List<Attaque> genere(String fichier, List<Type> types) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fichier));
            ArrayList<Attaque> attaques = new ArrayList<>();
            while(br.ready()) {
                try {
                    attaques.add(this.stringToAttaque(br.readLine(), types));
                } catch (TypeDontExistException e) {
                    System.out.println(e.getMessage());
                }
            }
            br.close();
            return attaques;
        } catch (FileNotFoundException e) {
            System.out.println("Pokemon file not found at "+fichier);
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Pokemon file is not correct at "+fichier);
            throw new RuntimeException(e);
        }finally {
            if (br != null) {
                try {
                    br.close();
                } catch(IOException e) { // Erreur de fermeture finale
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private Attaque stringToAttaque(String ligne, List<Type> types) throws TypeDontExistException {
        String[] elements = ligne.split(",");
        String nomAttaque = elements[0];
        String description = elements[1];
        Type type = this.trouverType(elements[2], types);
        int puissance = Integer.parseInt(elements[3]);
        AttaqueCategorie  categorie = AttaqueCategorie.valueOf(elements[4]);
        return new Attaque(nomAttaque, description, type, puissance, categorie);
    }

    private Type trouverType(String nomType, List<Type> liste) throws TypeDontExistException {
        for (Type t : liste) {
            if (t.getName().equals(nomType)) {
                return t;
            }
        }
        throw new TypeDontExistException(nomType);
    }
}
