package jauge;

public interface IJauge {
    boolean estRouge();
    boolean estVert();
    boolean estBleu();
    void incrementer();
    void decrementer();
}
