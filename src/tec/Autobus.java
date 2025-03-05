package tec;

import java.util.ArrayList;
import java.util.List;

/**
<<<<<<< HEAD
 * La classe Autobus représente un bus avec des places assises et debout,
=======
 * La classe Autobus représente un bus avec des places assises et debout
>>>>>>> e58cc2426ec413ac939cc099da2cd785c7d88bc2
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
<<<<<<< HEAD
        this(0, 0); // Appel au constructeur principal avec des valeurs par défaut
    }

    // Constructeur avec les places assises et debout spécifiées
=======
        this.maxPlacesAssises = 0;
        this.maxPlacesDebout = 0;
        this.arretActuel = 0;
        this.nbPlacesAssises = 0;
        this.nbPlacesDebout = 0;
        this.passagers = new ArrayList<>();
        this.fauxpassagers = new ArrayList<>();
    }

    // Constructeur avec les places assises et debout
>>>>>>> e58cc2426ec413ac939cc099da2cd785c7d88bc2
    public Autobus(int maxPlacesAssises, int maxPlacesDebout) {
        this.maxPlacesAssises = maxPlacesAssises;
        this.maxPlacesDebout = maxPlacesDebout;
        this.arretActuel = 0;
        this.nbPlacesAssises = 0;
        this.nbPlacesDebout = 0;
        this.passagers = new ArrayList<>();
        this.fauxpassagers = new ArrayList<>();
    }

<<<<<<< HEAD
    // Nouveau constructeur : les places assises et debout sont égales
    public Autobus(int nbPlaces) {
        this(nbPlaces, nbPlaces); // Réutilisation du constructeur principal
    }

    // Getters pour les attributs
=======
    // Getter et Setter
>>>>>>> e58cc2426ec413ac939cc099da2cd785c7d88bc2
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

<<<<<<< HEAD
    // Méthodes pour vérifier les places disponibles
=======
    // Vérifie si des places assises sont disponibles
>>>>>>> e58cc2426ec413ac939cc099da2cd785c7d88bc2
    @Override
    public boolean aPlaceAssise() {
        return nbPlacesAssises < maxPlacesAssises;
    }

<<<<<<< HEAD
=======
    // Vérifie si des places debout sont disponibles
>>>>>>> e58cc2426ec413ac939cc099da2cd785c7d88bc2
    @Override
    public boolean aPlaceDebout() {
        return nbPlacesDebout < maxPlacesDebout;
    }

<<<<<<< HEAD
    // Méthodes pour demander des places pour les passagers
    @Override
    public void demanderPlaceAssise(Passager p) {
        if (aPlaceAssise()) {
=======
    // Demander une place assise pour un passager
    @Override
    public void demanderPlaceAssise(Passager p) {
        if (passagers.size() < maxPlacesAssises + maxPlacesDebout && aPlaceAssise()) {
>>>>>>> e58cc2426ec413ac939cc099da2cd785c7d88bc2
            p.accepterPlaceAssise();
            passagers.add(p);
            nbPlacesAssises++;
        }
    }

<<<<<<< HEAD
    @Override
    public void demanderPlaceDebout(Passager p) {
        if (aPlaceDebout()) {
=======
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
>>>>>>> e58cc2426ec413ac939cc099da2cd785c7d88bc2
            p.accepterPlaceDebout();
            passagers.add(p);
            nbPlacesDebout++;
        }
    }

<<<<<<< HEAD
=======
    // Demander une place debout pour un faux passager
    public void demanderPlaceDebout(FauxPassager p) {
        if (fauxpassagers.size() < maxPlacesAssises + maxPlacesDebout && aPlaceDebout()) {
            p.accepterPlaceDebout();
            fauxpassagers.add(p);
            nbPlacesDebout++;
        }
    }

    // Demander de changer en debout pour un passager
>>>>>>> e58cc2426ec413ac939cc099da2cd785c7d88bc2
    @Override
    public void demanderChangerEnDebout(Passager p) {
        if (aPlaceDebout() && p.estAssis()) {
            p.accepterPlaceDebout();
            nbPlacesAssises--;
            nbPlacesDebout++;
        }
    }

<<<<<<< HEAD
=======
    // Demander de changer en debout pour un faux passager
    public void demanderChangerEnDebout(FauxPassager p) {
        if (aPlaceDebout() && p.estAssis()) {
            p.accepterPlaceDebout();
            nbPlacesAssises--;
            nbPlacesDebout++;
        }
    }

    // Demander de changer en assis pour un passager
>>>>>>> e58cc2426ec413ac939cc099da2cd785c7d88bc2
    @Override
    public void demanderChangerEnAssis(Passager p) {
        if (aPlaceAssise() && p.estDebout()) {
            p.accepterPlaceAssise();
            nbPlacesDebout--;
            nbPlacesAssises++;
        }
    }

<<<<<<< HEAD
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
=======
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
>>>>>>> e58cc2426ec413ac939cc099da2cd785c7d88bc2
        }
    }

    // Méthode toString pour afficher l'état de l'autobus
    @Override
    public String toString() {
<<<<<<< HEAD
        return "[arret:" + arretActuel + ", assis:" + nbPlacesAssises + ", debout:" + nbPlacesDebout + "]";
    }

	@Override
	public void allerArretSortie() {
		// TODO Auto-generated method stub
		
	}
=======
        return "[arret:" + this.arretActuel + ", assis:" + this.nbPlacesAssises + ", debout:" + this.nbPlacesDebout + "]";
    }

    @Override
    public void allerArretSortie() {
        // TODO: Implémenter la logique de gestion de l'arrêt sortie si nécessaire
    }
>>>>>>> e58cc2426ec413ac939cc099da2cd785c7d88bc2
}
