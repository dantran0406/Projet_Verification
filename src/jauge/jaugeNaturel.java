package jauge;

import java.util.Objects;

/**
 * Représente une jauge avec une valeur bornée entre un minimum et un maximum.
 */
public class jaugeNaturel implements IjaugeNaturel {
    // La valeur actuelle de la jauge.
    private long valeur;

    // Les bornes minimum et maximum de la jauge.
    private final long min;
    private final long max;

    /**
     * Constructeur pour initialiser la jauge.
     *
     * @param vigieMin la valeur minimale.
     * @param vigieMax la valeur maximale.
     * @param depart   la valeur initiale de la jauge.
     * @throws IllegalArgumentException si vigieMin >= vigieMax ou si depart est hors limites.
     */
    public jaugeNaturel(long vigieMin, long vigieMax, long depart) {
        if (vigieMin >= vigieMax) {
            throw new IllegalArgumentException("vigieMin doit être inférieur à vigieMax.");
        }
        if (depart < vigieMin || depart > vigieMax) {
            throw new IllegalArgumentException("La valeur de départ doit être comprise entre min et max.");
        }
        this.valeur = depart;
        this.min = vigieMin;
        this.max = vigieMax;
    }

    /**
     * Vérifie si la jauge est dans l'état "Rouge".
     *
     * @return true si la valeur est supérieure ou égale à la borne maximale.
     */
    public boolean estRouge() {
        return valeur >= max;
    }

    /**
     * Vérifie si la jauge est dans l'état "Vert".
     *
     * @return true si la valeur est strictement entre la borne minimale et la borne maximale.
     */
    public boolean estVert() {
        return valeur > min && valeur < max;
    }

    /**
     * Vérifie si la jauge est dans l'état "Bleu".
     *
     * @return true si la valeur est inférieure ou égale à la borne minimale.
     */
    public boolean estBleu() {
        return valeur <= min;
    }

    /**
     * Incrémente la valeur de la jauge.
     */
    public void incrementer() {
        valeur++;
    }

    /**
     * Décrémente la valeur de la jauge.
     */
    public void decrementer() {
        valeur--;
    }

    /**
     * Retourne une représentation sous forme de chaîne de la jauge.
     *
     * @return une chaîne représentant la jauge.
     */
    @Override
    public String toString() {
        return "<" + valeur + " [" + min + "," + max + "]>";
    }

    /**
     * Compare cette jauge avec un autre objet.
     *
     * @param obj l'objet à comparer.
     * @return true si les jauges ont les mêmes attributs, false sinon.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        jaugeNaturel that = (jaugeNaturel) obj;
        return valeur == that.valeur && min == that.min && max == that.max;
    }

    /**
     * Génère un hash code pour cette jauge.
     *
     * @return le hash code basé sur les attributs de la jauge.
     */
    @Override
    public int hashCode() {
        return Objects.hash(valeur, min, max);
    }

    // Getters pour accéder aux attributs privés

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

