package etatPassager;

public class EtatPassagerMonter {
  public enum Etat {/** passager assis à l'intérieur */  ASSIS, 
                    /** passager debout à l'intérieur */ DEBOUT,  
                    /** passager à l'extérieur */        DEHORS};

  private final Etat monEtat;

  public EtatPassagerMonter(Etat e) {
    monEtat = e;
  }
  
      public boolean estExterieur() {
	    return monEtat == Etat.DEHORS;
	  }

	  public boolean estAssis() {
	    return monEtat == Etat.ASSIS;
	  }

	  public boolean estDebout() {
	    return monEtat == Etat.DEBOUT;
	  }

	  public boolean estInterieur() {
	    return monEtat != Etat.DEHORS;
	  }

	  @Override
	  public String toString() {
	    return "<" + monEtat + ">";
	  }
}