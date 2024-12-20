package jauge;

/**
 * Représente une jauge avec une valeur bornée entre un minimum et un maximum.
 */
public class JaugeNaturel implements IJauge {
    private long valeur;
    private final long min;
    private final long max;
    


    /**
     * Constructeur pour initialiser une jauge.
     * 
     * @param vigieMin La borne minimale.
     * @param vigieMax La borne maximale.
     * @param depart   La valeur initiale.
     * @throws IllegalArgumentException si les paramètres sont invalides.
     */
    public JaugeNaturel(long vigieMin, long vigieMax, long depart) {
        if (vigieMin >= vigieMax) {
            throw new IllegalArgumentException("vigieMin doit être inférieur à vigieMax.");
        }
        if (depart < vigieMin || depart > vigieMax) {
            throw new IllegalArgumentException("La valeur de départ doit être comprise entre vigieMin et vigieMax.");
        }
        this.valeur = depart;
        this.min = vigieMin;
        this.max = vigieMax;
    }

    public boolean estRouge() {
        return valeur >= max;
    }

    public boolean estVert() {
        return valeur > min && valeur < max;
    }

    public boolean estBleu() {
        return valeur <= min;
    }

    public void incrementer() {
        valeur++;
    }

    public void decrementer() {
        valeur--;
    }

    @Override
    public String toString() {
        return "<" + valeur + " [" + min + "," + max + "]>";
    }

    public long getValeur() {
        return valeur;
    }

    public long getMin() {
        return min;
    }

    public long getMax() {
        return max;
    }
}

