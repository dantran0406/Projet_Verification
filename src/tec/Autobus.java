package tec;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe Autobus représente un bus avec des places assises et debout,
 * ainsi qu'une gestion des passagers (vrais et faux).
 */
public class Autobus implements Bus, Transport {
    private int maxPlacesAssises;
    private int maxPlacesDebout;
    private int arretActuel;
    private int nbPlacesAssises;
    private int nbPlacesDebout;
    private List<Passager> passagers;
    private List<FauxPassager> fauxpassagers;

    // Constructeur par défaut
    public Autobus() {
        this(0, 0); // Appel au constructeur principal avec des valeurs par défaut
    }

    // Constructeur avec les places assises et debout spécifiées
    public Autobus(int maxPlacesAssises, int maxPlacesDebout) {
        this.maxPlacesAssises = maxPlacesAssises;
        this.maxPlacesDebout = maxPlacesDebout;
        this.arretActuel = 0;
        this.nbPlacesAssises = 0;
        this.nbPlacesDebout = 0;
        this.passagers = new ArrayList<>();
        this.fauxpassagers = new ArrayList<>();
    }

    // Nouveau constructeur : les places assises et debout sont égales
    public Autobus(int nbPlaces) {
        this(nbPlaces, nbPlaces); // Réutilisation du constructeur principal
    }

    // Getters pour les attributs
    public int getMaxPlacesAssises() {
        return this.maxPlacesAssises;
    }

    public int getMaxPlacesDebout() {
        return this.maxPlacesDebout;
    }

    public int getArretActuel() {
        return this.arretActuel;
    }

    public int getNbPlacesAssises() {
        return this.nbPlacesAssises;
    }

    public int getNbPlacesDebout() {
        return this.nbPlacesDebout;
    }

    public List<Passager> getListPassagers() {
        return this.passagers;
    }

    // Méthodes pour vérifier les places disponibles
    @Override
    public boolean aPlaceAssise() {
        return nbPlacesAssises < maxPlacesAssises;
    }

    @Override
    public boolean aPlaceDebout() {
        return nbPlacesDebout < maxPlacesDebout;
    }

    // Méthodes pour demander des places pour les passagers
    @Override
    public void demanderPlaceAssise(Passager p) {
        if (aPlaceAssise()) {
            p.accepterPlaceAssise();
            passagers.add(p);
            nbPlacesAssises++;
        }
    }

    @Override
    public void demanderPlaceDebout(Passager p) {
        if (aPlaceDebout()) {
            p.accepterPlaceDebout();
            passagers.add(p);
            nbPlacesDebout++;
        }
    }

    @Override
    public void demanderChangerEnDebout(Passager p) {
        if (aPlaceDebout() && p.estAssis()) {
            p.accepterPlaceDebout();
            nbPlacesAssises--;
            nbPlacesDebout++;
        }
    }

    @Override
    public void demanderChangerEnAssis(Passager p) {
        if (aPlaceAssise() && p.estDebout()) {
            p.accepterPlaceAssise();
            nbPlacesDebout--;
            nbPlacesAssises++;
        }
    }

    @Override
    public void demanderSortie(Passager p) {
        if (p.estAssis()) {
            nbPlacesAssises--;
        } else if (p.estDebout()) {
            nbPlacesDebout--;
        }
        passagers.remove(p);
    }

    // Méthode pour avancer à l'arrêt suivant
    @Override
    public void allerArretSuivant() throws UsagerInvalideException {
        arretActuel++;
        for (Passager p : new ArrayList<>(passagers)) {
            p.nouvelArret(this, arretActuel);
        }
    }

    // Méthode toString pour afficher l'état de l'autobus
    @Override
    public String toString() {
        return "[arret:" + arretActuel + ", assis:" + nbPlacesAssises + ", debout:" + nbPlacesDebout + "]";
    }

	@Override
	public void allerArretSortie() {
		// TODO Auto-generated method stub
		
	}
}
