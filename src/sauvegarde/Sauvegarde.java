package sauvegarde;

import java.util.Collection;

public interface Sauvegarde<T> {
    void sauvegarde(Collection<T> c, String fichier);
}
