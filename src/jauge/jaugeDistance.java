package jauge;

public class jaugeDistance implements IjaugeNaturel{
  private long distMin;
  private long distMax;
  
  
  public jaugeDistance(long vigieMin, long vigieMax, long depart) {
    distMin = depart - vigieMin;
    distMax = depart - vigieMax;
  }
  
  public boolean estRouge() {
    return distMax >= 0 && distMin > 0;
  }

  public boolean estVert() {
 	  return (distMin > 0 && distMax < 0) || (distMin == 0 && distMax == 0) || (distMin < 0 && distMax > 0);
  }

  public boolean estBleu() {
    return distMin <= 0 && distMax < 0;
  }
  
  public void incrementer() {
	  distMin ++;
	  distMax --;
  }

  public void decrementer() {
	  distMin --;
	  distMax ++;
  }

  @Override
  public String toString() {
    return "<[" + distMin + "," + distMax + "]>";
  }
}