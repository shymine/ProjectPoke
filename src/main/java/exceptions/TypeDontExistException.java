package main.java.exceptions;

public class TypeDontExistException extends DontExistException{
    public TypeDontExistException(String s) {
        super("Type "+s+" n'existe pas");
    }
}
