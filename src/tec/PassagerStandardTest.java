package tec;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PassagerStandardTest {

     PassagerStandard passager;

    @Before
    public void initialiser() throws Exception {
    	/**initialiser un nouvel objet PassagerStandard avant chaque test pour pouvoir exécuter les tests.**/
      
    }

    @After
    public void nettoyer() throws Exception {
    	/**Remettre les variables d'instance à null,nettoyage après chaque test**/
        
    }

    @Test
    public void estDehors() {
    	/**
         * Vérifie que l'état initial du passager est "dehors".
         * Le passager doit être considéré comme étant à l'extérieur par défaut juste après son instanciation.
         **/
        
    }
    @Test
    public void estAssis() {
    	/**vérifier si l'état du passager est différent de "assis" immédiatement après son instanciation**/
        
        
    }
    
    @Test
    public void estDebout() {
    	/**vérifie si l'état du passager n'est pas "debout" immédiatement après son instanciation,
    	 *ceci confirme que l'état du passager par défaut n'est pas "debout" **/
    	
    	
    }
    @Test
    public void non() {
    	/**vérifie si l'état du passager après son instanciation n'est ni debout ni assis,
    	 * ce qui confirme que l'état initial est bien "dehors".**/
    	
    }
    
    @Test
    public void accepterSortie() {
    	/**Vérifie correctement que l'état du passager passe à"dehors" lorsqu'on fait appel la méthode accepterSortie.
    	 * ça teste la méthode accepterSortie.**/
    	
        
    }
        

    @Test
    public void accepterPlaceAssise() {
    	/**Vérifie correctement que l'état du passager passe à "assis" lorsqu'on fait appel à  la méthode accepterPlaceAssise.
    	 * ça teste la méthode accepterPlaceAssise.**/
    	
        
    }

    @Test
    public void accepterPlaceDebout() {
    	/**Vérifie correctement que l'état du passager passe à "debout" lorsqu'on fait appel à la méthode accepterPlaceDebout.
    	 * ça teste la méthode accepterPlaceDebout.**/
    	
   }

    @Test
    public void nouvelArret() {
    	/**Teste la méthode nouvelArret.
    	 *Ce test nous aide à vérifier que le passager réagit correctement à l'arrivée à un nouvel arrêt.**/   
        

    }

    @Test
    public void monterDans() {
    	/**Teste la méthode monterDans.
    	 *Vérifie que le passager peut monter correctement dans un bus et interagir avec celui ci.**/   
    	
    }
}