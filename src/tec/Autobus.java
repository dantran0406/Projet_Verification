package tec;
import java.util.ArrayList;
import java.util.List;
/**
 * C'est la classe Autobus représentant un Bus et un Transport
 * utilisée pour transporter des passagers, fournir des places debout et assises aux passagers.
 * La classe autobus aura les variables
 * maxPlacesAssises est le nombre maximal de places assises du bus.
 * maxPlacesDebout est le nombre maximal de places debout du bus.
 * arretActuel l'arrêt actuel du bus.
 * nbPlacesAssises est le nombre de passagers assis.
 * nbPlacesDebout est le nombre de passagers bout.
 * passagers est liste des passagers utilisant le bus.
 * 
 */
public class Autobus implements Bus, Transport {
    private int maxPlacesAssises;
    private int maxPlacesDebout;
    private int arretActuel;
    private int nbPlacesAssises;
    private int nbPlacesDebout;
    private List<Passager> passagers;
    private List<FauxPassager> fauxpassagers;
    //
    public Autobus() {
        this.maxPlacesAssises = 0;
        this.maxPlacesDebout = 0;
        this.arretActuel = 0;
        this.nbPlacesAssises =0;
        this.nbPlacesDebout =0;
        this.passagers = new ArrayList<>();
    }
   /**
    * Le constructeur d'Autobus avec 2 paramètres, le nombre de places assises et le nombre de places debout.
    * Les autres paramètres seront initialisés à 0 ou à une liste vide.
    * @param maxPlacesAssises est le nombre maximal de places assises du bus.
    * @param maxPlacesDebout est le nombre maximal de places debout du bus.
    */
    public Autobus(int maxPlacesAssises, int maxPlacesDebout) {
        this.maxPlacesAssises = maxPlacesAssises;
        this.maxPlacesDebout = maxPlacesDebout;
        this.arretActuel = 0;
        this.nbPlacesAssises =0;
        this.nbPlacesDebout =0;
        this.passagers = new ArrayList<>();
    }
   //
    public int getMaxPlacesAssises() {
    	return this.maxPlacesAssises;
    }
    //
    public int getMaxPlacesDebout() {
    	return this.maxPlacesDebout;
    }
    //
    public int getArretActuel() {
    	return this.arretActuel;
    }
    //
    public int getNbPlacesAssises() {
    	return this.nbPlacesAssises;
    }
    //
    public int getNbPlacesDebout() {
    	return this.nbPlacesDebout;
    }
    //
    public List<Passager> getListPassagers() {
    	return this.passagers;
    }
    //
    public void setMaxPlacesAssises(int _maxPlacesAssies) {
    	this.maxPlacesAssises = _maxPlacesAssies;
    }
    //
    public void setMaxPlacesDebout(int _maxPlacesDebout) {
    	this.maxPlacesDebout = _maxPlacesDebout;
    }
    //
    public void setArretActuel(int _arretActuel) {
    	this.arretActuel = _arretActuel;
    }
    //
    public void setNbPlacesAssises(int _nbPlacesAssies) {
    	this.nbPlacesAssises = _nbPlacesAssies;
    }
    //
    public void setNbPlacesDebout(int _nbPlacesDebout) {
    	this.nbPlacesDebout = _nbPlacesDebout;
    }
    //
    public void setListPassagers(List<Passager> _passagers) {
    	this.passagers = _passagers;
    }
    /**
     * Vrai si le nombre de passagers assis est inférieur au nombre total de places assises.
     * @return vrai s'il existe des places assises
     */
    @Override 
    public boolean aPlaceAssise() {
        if(nbPlacesAssises < maxPlacesAssises)
        	return true;
        else 
        	return false;
    }
    /**
     * Vrai si le nombre de passagers debouts est inférieur au nombre total de places debouts .
     * @return vrai s'il existe des places debouts.
     */
    @Override
    public boolean aPlaceDebout() {
        if(nbPlacesDebout < maxPlacesDebout)
        	return true;
        else 
        	return false;
    }
    /**
     * La fonction propose des places assises si le nombre de passagers est inférieur à la somme totale des places debout et assises
     * permettant aux passagers de choisir une place s'il y a encore des sièges disponibles.
     * @param p est le passager utiliser le bus.
     */
    @Override
    public void demanderPlaceAssise(Passager p) {
    	if(passagers.size() < maxPlacesAssises + maxPlacesDebout) {
    		if (aPlaceAssise()) {
    			p.accepterPlaceAssise();
    			passagers.add(p);
    			nbPlacesAssises++;
    			
    		}
    	}
    }
    //
    public void demanderPlaceAssise(FauxPassager p) {
    	if(fauxpassagers.size() < maxPlacesAssises + maxPlacesDebout) {
    		if (aPlaceAssise()) {
    			p.accepterPlaceAssise();
    			fauxpassagers.add(p);
    			nbPlacesAssises++;
    			
    		}
    	}
    }
    /**
     * La fonction propose des places debouts si le nombre de passagers est inférieur à la somme totale des places debout et assises
     * permettant aux passagers de choisir une place s'il y a encore des debouts disponibles.
     * @param p est le passager utiliser le bus.
     */
    @Override
    public void demanderPlaceDebout(Passager p) {
    	if(passagers.size() < maxPlacesAssises + maxPlacesDebout) {
    		if (aPlaceDebout()) {
    			p.accepterPlaceDebout();
    			passagers.add(p);
    			nbPlacesDebout++;
    		}
    	}
    }
    //
    public void demanderPlaceDebout(FauxPassager p) {
    	if(fauxpassagers.size() < maxPlacesAssises + maxPlacesDebout) {
    		if (aPlaceDebout()) {
    			p.accepterPlaceDebout();
    			fauxpassagers.add(p);
    			nbPlacesDebout++;
    		}
    	}
    }
    /**
     * La fonction propose au passagers de changer de siège en position debout
     * @param p est le passager utiliser le bus.
     */
    @Override
    public void demanderChangerEnDebout(Passager p) {
    	if (aPlaceDebout()) {
    		if(p.estAssis()) {
    			p.accepterPlaceDebout();
    			nbPlacesAssises--;
    			nbPlacesDebout++;
    		}
    	}
    }
    //
    public void demanderChangerEnDebout(FauxPassager p) {
    	if (aPlaceDebout()) {
    		if(p.estAssis()) {
    			p.accepterPlaceDebout();
    			nbPlacesAssises--;
    			nbPlacesDebout++;
    		}
    	}
    }
    /**
     * La fonction propose au passagers de changer de debout en position siège 
     * @param p est le passager utiliser le bus.
     */
    @Override
    public void demanderChangerEnAssis(Passager p) {
    	if (aPlaceAssise()) {
    		if(p.estDebout()) {
    			p.accepterPlaceAssise();
    			nbPlacesDebout--;
    			nbPlacesAssises++;
    		}
		} 
    }
    //
    public void demanderChangerEnAssis(FauxPassager p) {
    	if (aPlaceAssise()) {
    		if(p.estDebout()) {
    			p.accepterPlaceAssise();
    			nbPlacesDebout--;
    			nbPlacesAssises++;
    		}
		} 
    }
    /**
     * La fonction propose au passagers de sortir 
     * @param p est le passager utiliser le bus.
     */
    @Override
    public void demanderSortie(Passager p) {
    	if(!p.estDehors()) {
    		p.accepterSortie();
    	}
    }
    //
    public void demanderSortie(FauxPassager p) {
    	if(!p.estDehors()) {
    		p.accepterSortie();
    	}
    }
    /**
     * La fonction se déplace vers la prochaine station,
     * et si c'est le station que les passagers souhaitent descendre,
	 * l'état des passagers sera modifié en 'dehors'." 
	 *  Des erreurs peuvent survenir si les valeurs des paramètres de Autobus sont négatives ou invalides.
     */
    @Override
    public void allerArretSuivant() throws UsagerInvalideException{
    	arretActuel++;
    	nbPlacesAssises = 0;
    	nbPlacesDebout = 0;
    	List<Passager> newPassagers = new ArrayList<>();
    	if(passagers.size()!=0) {
    		for(int i=0;i<passagers.size();i++) {
    			Passager p = passagers.get(i);
    			p.nouvelArret(this, arretActuel);
    			if(!p.estDehors()) {
    				if(p.estAssis()) {
    					newPassagers.add(p);
    					nbPlacesAssises++;
    				}
    				else {
    					newPassagers.add(p);
    					nbPlacesDebout++;
    				}
    			}
    		}
    		newPassagers = passagers;
    	}
    	if((nbPlacesAssises<0)||(nbPlacesDebout<0)||(arretActuel<0)||(maxPlacesAssises<0)||(maxPlacesDebout<0)||((maxPlacesAssises+maxPlacesDebout)<=0))
    		throw new UsagerInvalideException("Les paramètres de l'autobus ne sont pas valides!");

    }
    //
    public void allerArretSuivantFaux() throws UsagerInvalideException{
    	arretActuel++;
    	nbPlacesAssises = 0;
    	nbPlacesDebout = 0;
    	List<FauxPassager> newPassagers = new ArrayList<>();
    	if(fauxpassagers.size()!=0) {
    		for(int i=0;i<fauxpassagers.size();i++) {
    			FauxPassager p = fauxpassagers.get(i);
    			p.nouvelArret(this, arretActuel);
    			if(!p.estDehors()) {
    				if(p.estAssis()) {
    					newPassagers.add(p);
    					nbPlacesAssises++;
    				}
    				else {
    					newPassagers.add(p);
    					nbPlacesDebout++;
    				}
    			}
    		}
    		newPassagers = fauxpassagers;
    	}
    	if((nbPlacesAssises<0)||(nbPlacesDebout<0)||(arretActuel<0)||(maxPlacesAssises<0)||(maxPlacesDebout<0)||((maxPlacesAssises+maxPlacesDebout)<=0))
    		throw new UsagerInvalideException("Les paramètres de l'autobus ne sont pas valides!");

    }
    /**
     * La fonction enregistre toutes les informations sur la station actuelle,
     * y compris le nombre de passagers assis et le nombre de passagers debout en String.
     */
    public String toString() {
        return "[arret:"+ this.arretActuel+", "+"assis:"+ this.nbPlacesAssises+", "+"debout:"+ this.nbPlacesDebout+"]";
  }
	@Override
	public void allerArretSortie() {
		// TODO Auto-generated method stub
		
	}
}
