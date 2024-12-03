package tec;

import java.util.ArrayList;
import java.util.List;

public class Autobus implements Bus, Transport {
    private int maxPlacesAssises;
    private int maxPlacesDebout;
    private int arretActuel;
    private int nbPlacesAssises;
    private int nbPlacesDebout;
    private List<Passager> passagers;

    // Constructeur de l'autobus avec vérification des paramètres.
    public Autobus(int maxPlacesAssises, int maxPlacesDebout) throws UsagerInvalideException {
        if (maxPlacesAssises < 0 || maxPlacesDebout < 0 || (maxPlacesAssises + maxPlacesDebout) <= 0) {
            throw new UsagerInvalideException("Le nombre de places dans l'autobus est invalide!");
        }
        this.maxPlacesAssises = maxPlacesAssises;
        this.maxPlacesDebout = maxPlacesDebout;
        this.arretActuel = 0;
        this.nbPlacesAssises = 0;
        this.nbPlacesDebout = 0;
        this.passagers = new ArrayList<>();
    }

    // Méthode pour vérifier s'il y a des places assises disponibles.
    @Override
    public boolean aPlaceAssise() {
        return nbPlacesAssises < maxPlacesAssises;
    }

    // Méthode pour vérifier s'il y a des places debout disponibles.
    @Override
    public boolean aPlaceDebout() {
        return nbPlacesDebout < maxPlacesDebout;
    }

    // Demander une place assise pour un passager.
    @Override
    public void demanderPlaceAssise(Passager p) {
        if (passagers.size() < maxPlacesAssises + maxPlacesDebout && aPlaceAssise()) {
            p.accepterPlaceAssise();
            passagers.add(p);
            nbPlacesAssises++;
        }
    }

    // Demander une place debout pour un passager.
    @Override
    public void demanderPlaceDebout(Passager p) {
        if (passagers.size() < maxPlacesAssises + maxPlacesDebout && aPlaceDebout()) {
            p.accepterPlaceDebout();
            passagers.add(p);
            nbPlacesDebout++;
        }
    }

    // Demander un changement de place assise à debout pour un passager.
    @Override
    public void demanderChangerEnDebout(Passager p) {
        if (aPlaceDebout() && p.estAssis()) {
            p.accepterPlaceDebout();
            nbPlacesAssises--;
            nbPlacesDebout++;
        }
    }

    // Demander un changement de place debout à assise pour un passager.
    @Override
    public void demanderChangerEnAssis(Passager p) {
        if (aPlaceAssise() && p.estDebout()) {
            p.accepterPlaceAssise();
            nbPlacesDebout--;
            nbPlacesAssises++;
        }
    }

    // Demander la sortie d'un passager.
    @Override
    public void demanderSortie(Passager p) {
        if (!p.estDehors()) {
            p.accepterSortie();
        }
    }

    // Aller à l'arrêt suivant, mettre à jour l'état des passagers.
    @Override
    public void allerArretSuivant() throws UsagerInvalideException {
        arretActuel++;
        nbPlacesAssises = 0;
        nbPlacesDebout = 0;
        List<Passager> newPassagers = new ArrayList<>();
        if (!passagers.isEmpty()) {
            for (int i = 0; i < passagers.size(); i++) {
                Passager p = passagers.get(i);
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
            passagers = newPassagers; // Mise à jour de la liste des passagers
        }

        // Vérifications des paramètres après le déplacement.
        if (nbPlacesAssises < 0 || nbPlacesDebout < 0 || arretActuel < 0 || maxPlacesAssises < 0 || maxPlacesDebout < 0 || (maxPlacesAssises + maxPlacesDebout) <= 0) {
            throw new UsagerInvalideException("Les paramètres de l'autobus ne sont pas valides!");
        }
    }

    // Méthode toString pour afficher l'état de l'autobus.
    @Override
    public String toString() {
        return "[arret:" + this.arretActuel + ", assis:" + this.nbPlacesAssises + ", debout:" + this.nbPlacesDebout + "]";
    }

    // Getters pour les variables privées
    public int getNbPlacesAssises() {
        return nbPlacesAssises;
    }

    public int getNbPlacesDebout() {
        return nbPlacesDebout;
    }

    @Override
    public void allerArretSortie() {
        // TODO: Implémenter la logique pour gérer l'arrêt de sortie.
    }
}

