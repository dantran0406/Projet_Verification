package tec;

public class FauxPassager implements Passager { 
  static final byte DEHORS = 0;
  static final byte ASSIS  = 1;
  static final byte DEBOUT = 2;
  byte status = DEHORS;

  String message ="???";

  @Override
  public String nom() {
    return "Faux Passager";  // Donne un nom au passager
  }

  @Override
  public boolean estDehors() {
    return status == DEHORS;
  }

  @Override
  public boolean estAssis() {
    return status == ASSIS;
  }

  @Override
  public boolean estDebout() {
    return status == DEBOUT;
  }

  @Override
  public void accepterSortie() {
      message = ":accepterSortie:";
      status = DEHORS;  
  }


  @Override
  public void accepterPlaceAssise() {
    message = ":accepterPlaceAssise:";
    status = ASSIS;
  }

  @Override
  public void accepterPlaceDebout() {
    message = ":accepterPlaceDebout:";
    status = DEBOUT;
  }

  @Override
  public void nouvelArret(Bus bus, int numeroArret) {
    message = ":nouvelArret " + numeroArret + ":";
  }

  @Override
  public void monterDans(Transport t) {
	  //throws UsagerInvalideException 
  }

}
<<<<<<< HEAD

=======
>>>>>>> e58cc2426ec413ac939cc099da2cd785c7d88bc2
