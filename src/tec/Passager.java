package tec;
interface Passager {
  public String nom();
  public boolean estDehors();
  public boolean estAssis();
  public boolean estDebout();
  public void accepterSortie();
  public void accepterPlaceAssise();
  public void accepterPlaceDebout();
  public void nouvelArret(Bus bus, int numeroArret);
void monterDans(Transport t);
}

