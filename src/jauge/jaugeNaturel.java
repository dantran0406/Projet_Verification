package jauge;

public class jaugeNaturel implements IjaugeNaturel {
 public long valeur;
 public final long min;
 public final long max;

 
 public jaugeNaturel(long vigieMin, long vigieMax, long depart) {
   valeur = depart;
   min = vigieMin;
   max = vigieMax;
 }
 public boolean estRouge() {
   return valeur >= max;
 }

 public boolean estVert() {
   return (!estBleu() && !estRouge());
 }

 public boolean estBleu() {
   return valeur <= min;
 }

 public void incrementer() {
   valeur++;
 }

 public void decrementer() {
	 valeur --;
 }
 
 @Override
 public String toString() {
   return "<" + valeur + " [" + min + "," + max + "]>";
 }
}
