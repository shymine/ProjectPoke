package utils;

public class Triple <A,B,C>{
    private final A premier;
    private final B second;
    private final C troisième;

    public Triple(A premier, B second, C troisième) {
        this.premier = premier;
        this.second = second;
        this.troisième = troisième;
    }

    public A getPremier() {
        return premier;
    }

    public B getSecond() {
        return second;
    }

    public C getTroisième() {
        return troisième;
    }
}
