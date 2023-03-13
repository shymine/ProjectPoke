package exceptions;

public class AttaqueDontExistException extends DontExistException{
    public AttaqueDontExistException(String s) {
        super("Attaque "+s+" n'existe pas");
    }
}
