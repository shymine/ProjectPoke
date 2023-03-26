package main.java.sauvegarde;

import main.java.exceptions.DontExistException;
import main.java.exceptions.TypeDontExistException;
import main.java.pokemon.Type;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TypeGenerateur {
    public List<Type> genere(String fichier) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fichier));
            Map<Type,ArrayList<String>[]> elems = new HashMap<>();
            while(br.ready()) {
               elems.putAll(this.stringToType(br.readLine()));
            }
            Set<Type> set_type = elems.keySet();
            for(Type t: set_type) { // pour tous les types présents
                try {
                    //associer les faiblesses
                    this.associer(t, elems.get(t)[0], set_type, 0);
                    //associer les résistances
                    this.associer(t, elems.get(t)[1], set_type, 1);
                    //associer les immunités
                    this.associer(t, elems.get(t)[2], set_type, 2);
                }catch (TypeDontExistException e) {
                    System.out.println(e.getMessage());
                }
            }
            br.close();
            return set_type.stream().toList();

        } catch (FileNotFoundException e) {
            System.out.println("Type file not found at "+fichier);
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Type file is not correct at "+fichier);
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

    /*
    retourne une map avec le type de la ligne ainsi que le tableau des faiblesses et résistances associées
    sous forme de String
     */
    private Map<Type,ArrayList<String>[]> stringToType(String line) {
        String[] elements = line.split(",");
        String nom_type = elements[0];
        ArrayList<String> faiblesses = new ArrayList<>();
        ArrayList<String> resistances = new ArrayList<>();
        ArrayList<String> immunites = new ArrayList<>();
        int index = 2; // index du début de la boucle des faiblesses
        while(!elements[index].equals("resistances")) {
            faiblesses.add(elements[index]);
            index++;
        }
        index++;
        while(!elements[index].equals("immunites")) {
            resistances.add(elements[index]);
            index++;
        }
        for(int i = index+1; i < elements.length-1; i++) {
            immunites.add(elements[i]);
        }

        Map<Type,ArrayList<String>[]> res = new HashMap<>();
        res.put(new Type(nom_type), new ArrayList[]{faiblesses, resistances, immunites});
        return res;
    }

    private void associer(Type type, List<String> liste_types, Set<Type> set_types, int mode) throws TypeDontExistException {
        for(String s : liste_types) {
            Type type_correspondant = null;
            for (Type t : set_types) {
                if (t.getName().equals(s)) {
                    type_correspondant = t;
                    break;
                }
            }
            if (type_correspondant == null) throw new TypeDontExistException(s);

            switch (mode) {
                case 0:
                    type.addFaiblesse(type_correspondant);
                    break;
                case 1:
                    type.addResistance(type_correspondant);
                    break;
                case 2:
                    type.addImmunite(type_correspondant);
                    break;
            }
        }
    }
}
