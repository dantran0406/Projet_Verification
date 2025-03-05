<<<<<<< HEAD
package etatPassager;

public class EtatPassager implements IEtatPassager {

  public enum Etat {/** passager assis à l'intérieur */  ASSIS, 
                    /** passager debout à l'intérieur */ DEBOUT,  
                    /** passager à l'extérieur */        DEHORS};

  private final Etat monEtat;
  
  public EtatPassager(Etat e) {
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
=======
package etatPassager;

public class EtatPassager implements IEtatPassager {

  public enum Etat {/** passager assis à l'intérieur */  ASSIS, 
                    /** passager debout à l'intérieur */ DEBOUT,  
                    /** passager à l'extérieur */        DEHORS};

  private final Etat monEtat;
  
  public EtatPassager(Etat e) {
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
>>>>>>> dedda375988d7ef0c9e18528c152e1592f465560
}