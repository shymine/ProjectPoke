package main.java.sauvegarde;

import main.java.exceptions.AttaqueDontExistException;
import main.java.exceptions.TypeDontExistException;
import main.java.pokemon.Attaque;
import main.java.pokemon.Pokemon;
import main.java.pokemon.Type;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PokeGenerateur {
    public List<Pokemon> genere(String fichier, List<Type> types, List<Attaque> attaques) {
        BufferedReader br = null;
        try {
           br = new BufferedReader(new FileReader(fichier));
           ArrayList<Pokemon> pokemons = new ArrayList<>();
           while (br.ready()) {
               pokemons.add(this.stringToPokemon(br.readLine(), types, attaques));
           }
           br.close();
           return pokemons;

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

    private Pokemon stringToPokemon(String line, List<Type> types, List<Attaque> attaques) {
        String[] elements = line.split(",");
        String nomPoke = elements[0];
        int pv = Integer.parseInt(elements[1]);
        int attaque = Integer.parseInt(elements[2]);
        int defence = Integer.parseInt(elements[3]);
        int att_spe = Integer.parseInt(elements[4]);
        int def_spe = Integer.parseInt(elements[5]);
        int vitesse = Integer.parseInt(elements[6]);

        ArrayList<Type> pokeTypes = new ArrayList<>();
        int i = 8;
        while(!elements[i].equals("possibles_attaques")) {
            String typeActuel = elements[i];
            try {
                pokeTypes.add(this.trouverType(typeActuel, types));
            } catch (TypeDontExistException e) {
                System.out.println(e.getMessage());
            }
            i++;
        }
        ArrayList<Attaque> pokeAttaques = new ArrayList<>();
        for(int j = i+1; j < elements.length; j++) {
            String attActuelle = elements[j];
            try {
                pokeAttaques.add(this.trouverAttaque(attActuelle, attaques));
            } catch (AttaqueDontExistException e) {
                System.out.println(e.getMessage());
            }
        }
        return new Pokemon(nomPoke,pokeTypes, pokeAttaques, pv, attaque, defence, att_spe, def_spe, vitesse);
    }

    private Type trouverType(String nomType, List<Type> liste) throws TypeDontExistException {
        for (Type t : liste) {
            if (t.getName().equals(nomType)) {
                return t;
            }
        }
        throw new TypeDontExistException(nomType);
    }

    private Attaque trouverAttaque(String nomAtt, List<Attaque> liste) throws AttaqueDontExistException {
        for (Attaque a: liste) {
            if(a.getName().equals(nomAtt)) {
                return a;
            }
        }
        throw new AttaqueDontExistException(nomAtt);
    }
}
