package sauvegarde;

import java.util.Collection;
import java.util.List;

public interface Generateur<T> {
    List<T> genere(String fichier);

}
