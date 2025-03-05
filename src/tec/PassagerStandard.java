package tec;
import etatPassager.EtatPassager.Etat;

public class PassagerStandard implements Passager,Usager {
	
	/**Déclaration des variables à utiliser**/
	 
	 
	/**Construction d'une instance en précisant le nom du passager et prend en compte 2 paramètres
         * @param nom pour le nom du passager.
         * @param destination pour le numéro de l'arret de la destination.
      **/
	public PassagerStandard(String nom,int destination){
		/*constuire l'instance avec ce qu'il faut: 
		 * l'état sachant que etat=dehors par défaut,nom et destination*/
	}
	
	
	
	public String nom() {
		/**cette méthode retourne le nom du passager
		 * @return le nom**/
		return null;
	}
	public int destination() {
		/**Retourne le numéro de l'arrêt de la destination
		 * @return la destination**/
		return -1;
	}
	public boolean estDehors() {
		/**Cette méthode retourne vrai si le passager est dehors
		 * @return true si passager est dehors**/
		
		return false;
		
	}
	
	public boolean estAssis() {
		/** cette méthode retourne vrai si le passager est asssis
		 * @return true si passager est assis**/
		
		return false;
	
	}
	public boolean non() {
		/**cette méthode retourne vrai si le passager n'est ni debout ni assis
		 * @return true if !debout et !assis**/
		return false;
	}
	
	public boolean estDebout() {
		/**cette méthode retourne vrai si le passager est debout
		 * @return true si passager est debout**/
		
		return false;
	
	}
	
	/**Cette méthode change l'état du passager et le met en état dehors**/
	@Override
	public void accepterSortie() {
		/*changer l'etat du passager en etat=dehors*/
		
	}
	
	/**Cette méthode change l'état du passager et le mets en état assis
	 * **/
	@Override
	public void accepterPlaceAssise() {
		/*changer l'etat du passager en etat=assis*/
		
	}
	
	/**Cette méthode change l'état du passager et le mets en état debout**/
	
	@Override
	public void accepterPlaceDebout() {
		/*changer l'etat du passager en etat=debout*/
		
	}
	
	@Override
	public void nouvelArret(Bus bus,int destination) {
		/** 
		  * Indique au passager qu'il est arrivé à un nouvel arrêt. 
		  * Cette methode fixe le comportement du passager dans le bus(changer de place ou sortir)
		  * Elle prend en compte 2 paramètres à l'entrée notamment:
	      * @param bus le bus dans lequel se trouve le passager.
	      * @param destination.
	     **/
		
		
	}
	
	
	@Override
	public void monterDans(Transport trans)throws UsagerInvalideException{
		/**
		 * Fournit à l'usager le transport auquel il peut accéder. 
		 * il prend en compte le paramètre @param trans pour le transport dans lequel désire monter l'usager.
		 * @throws si l'état de l'usager est incohérent par rapport à sa demande.
		 **/
		
	}
}
