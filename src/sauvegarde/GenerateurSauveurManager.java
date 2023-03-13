package sauvegarde;

import pokemon.Attaque;
import pokemon.Pokemon;
import pokemon.Type;
import utils.Triple;

import java.util.Collection;
import java.util.List;

public class GenerateurSauveurManager {
    private PokeGenerateur pokeGenerateur;
    private TypeGenerateur typeGenerateur;
    private AttaqueGenerateur attaqueGenerateur;
    private PokemonSauve pokemonSauve;
    private TypeSauve typeSauve;
    private AttaqueSauve attaqueSauve;
    private final String pokeFile = "ressources/pokemons.csv";
    private final String typeFile = "ressources/types.csv";
    private final String attaqueFile = "ressources/attaques.csv";

    public GenerateurSauveurManager() {
        this.pokeGenerateur = new PokeGenerateur();
        this.typeGenerateur = new TypeGenerateur();
        this.attaqueGenerateur = new AttaqueGenerateur();
        this.pokemonSauve = new PokemonSauve();
        this.typeSauve = new TypeSauve();
        this.attaqueSauve = new AttaqueSauve();
    }

    public void sauve(Collection<Type> types, Collection<Attaque> attaques, Collection<Pokemon> pokemons) {
        this.typeSauve.sauvegarde(types, this.typeFile);
        this.attaqueSauve.sauvegarde(attaques, this.attaqueFile);
        this.pokemonSauve.sauvegarde(pokemons, this.pokeFile);
    }

    public Triple<List<Type>, List<Attaque>, List<Pokemon>> genere() {
        List<Type> types = this.typeGenerateur.genere(this.typeFile);
        List<Attaque> attaques = this.attaqueGenerateur.genere(this.attaqueFile, types);
        List<Pokemon> pokemons = this.pokeGenerateur.genere(this.pokeFile, types, attaques);
        return new Triple<>(types, attaques, pokemons);
    }

}
