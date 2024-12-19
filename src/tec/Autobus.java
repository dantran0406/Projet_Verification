package tec;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe Autobus représente un bus avec des places assises et debout
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
        this.maxPlacesAssises = 0;
        this.maxPlacesDebout = 0;
        this.arretActuel = 0;
        this.nbPlacesAssises = 0;
        this.nbPlacesDebout = 0;
        this.passagers = new ArrayList<>();
        this.fauxpassagers = new ArrayList<>();
    }

    // Constructeur avec les places assises et debout
    public Autobus(int maxPlacesAssises, int maxPlacesDebout) {
        this.maxPlacesAssises = maxPlacesAssises;
        this.maxPlacesDebout = maxPlacesDebout;
        this.arretActuel = 0;
        this.nbPlacesAssises = 0;
        this.nbPlacesDebout = 0;
        this.passagers = new ArrayList<>();
        this.fauxpassagers = new ArrayList<>();
    }

    // Getter et Setter
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

    // Vérifie si des places assises sont disponibles
    @Override
    public boolean aPlaceAssise() {
        return nbPlacesAssises < maxPlacesAssises;
    }

    // Vérifie si des places debout sont disponibles
    @Override
    public boolean aPlaceDebout() {
        return nbPlacesDebout < maxPlacesDebout;
    }

    // Demander une place assise pour un passager
    @Override
    public void demanderPlaceAssise(Passager p) {
        if (passagers.size() < maxPlacesAssises + maxPlacesDebout && aPlaceAssise()) {
            p.accepterPlaceAssise();
            passagers.add(p);
            nbPlacesAssises++;
        }
    }

    // Demander une place assise pour un faux passager
    public void demanderPlaceAssise(FauxPassager p) {
        if (fauxpassagers.size() < maxPlacesAssises + maxPlacesDebout && aPlaceAssise()) {
            p.accepterPlaceAssise();
            fauxpassagers.add(p);
            nbPlacesAssises++;
        }
    }

    // Demander une place debout pour un passager
    @Override
    public void demanderPlaceDebout(Passager p) {
        if (passagers.size() < maxPlacesAssises + maxPlacesDebout && aPlaceDebout()) {
            p.accepterPlaceDebout();
            passagers.add(p);
            nbPlacesDebout++;
        }
    }

    // Demander une place debout pour un faux passager
    public void demanderPlaceDebout(FauxPassager p) {
        if (fauxpassagers.size() < maxPlacesAssises + maxPlacesDebout && aPlaceDebout()) {
            p.accepterPlaceDebout();
            fauxpassagers.add(p);
            nbPlacesDebout++;
        }
    }

    // Demander de changer en debout pour un passager
    @Override
    public void demanderChangerEnDebout(Passager p) {
        if (aPlaceDebout() && p.estAssis()) {
            p.accepterPlaceDebout();
            nbPlacesAssises--;
            nbPlacesDebout++;
        }
    }

    // Demander de changer en debout pour un faux passager
    public void demanderChangerEnDebout(FauxPassager p) {
        if (aPlaceDebout() && p.estAssis()) {
            p.accepterPlaceDebout();
            nbPlacesAssises--;
            nbPlacesDebout++;
        }
    }

    // Demander de changer en assis pour un passager
    @Override
    public void demanderChangerEnAssis(Passager p) {
        if (aPlaceAssise() && p.estDebout()) {
            p.accepterPlaceAssise();
            nbPlacesDebout--;
            nbPlacesAssises++;
        }
    }

    // Demander de changer en assis pour un faux passager
    public void demanderChangerEnAssis(FauxPassager p) {
        if (aPlaceAssise() && p.estDebout()) {
            p.accepterPlaceAssise();
            nbPlacesDebout--;
            nbPlacesAssises++;
        }
    }

    // Demander la sortie pour un passager
    public void demanderSortie(Passager p) {
        if (!p.estDehors()) {
            p.accepterSortie();
        } else {
            // Optionnel: Ajouter un message ou un log pour vérifier pourquoi cette ligne ne s'est pas exécutée comme prévu.
            System.out.println("Le passager est déjà dehors.");
        }
    }



    // Demander la sortie pour un faux passager
    public void demanderSortie(FauxPassager p) {
        if (!p.estDehors()) {
            p.accepterSortie();
        }
    }

    // Se déplacer à l'arrêt suivant
    @Override
    public void allerArretSuivant() throws UsagerInvalideException {
        arretActuel++;
        nbPlacesAssises = 0;
        nbPlacesDebout = 0;
        List<Passager> newPassagers = new ArrayList<>();
        
        for (Passager p : passagers) {
            p.nouvelArret(this, arretActuel);
            if (!p.estDehors()) {
                if (p.estAssis()) {
                    newPassagers.add(p);
                    nbPlacesAssises++;
                } else {
                    newPassagers.add(p);
                    nbPlacesDebout++;
                }
            }
        }
        
        passagers = newPassagers;

        // Vérification des valeurs invalides
        if (nbPlacesAssises < 0 || nbPlacesDebout < 0 || arretActuel < 0 || maxPlacesAssises < 0 || maxPlacesDebout < 0 || (maxPlacesAssises + maxPlacesDebout) <= 0) {
            throw new UsagerInvalideException("Les paramètres de l'autobus ne sont pas valides!");
        }
    }

    // Méthode toString pour afficher l'état de l'autobus
    @Override
    public String toString() {
        return "[arret:" + this.arretActuel + ", assis:" + this.nbPlacesAssises + ", debout:" + this.nbPlacesDebout + "]";
    }

    @Override
    public void allerArretSortie() {
        // TODO: Implémenter la logique de gestion de l'arrêt sortie si nécessaire
    }
}
