package tec;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AutobusTest {
    private Autobus autobus;
    private Passager passager1;
    private Passager passager2;
    private FauxPassager fauxPassager1;

    @BeforeEach
    public void setUp() {
        // Initialiser l'autobus avec 10 places assises et 10 places debout
        autobus = new Autobus(10, 10);
        passager1 = new FauxPassager();  // Utilisez FauxPassager au lieu de PassagerImpl
        passager2 = new FauxPassager();
        fauxPassager1 = new FauxPassager();
    }


    @Test
    public void testDemanderPlaceAssise() {
        // Tester si un passager peut demander une place assise sans interférer avec l'autre passager
        assertTrue(autobus.aPlaceAssise());  // Il y a des places assises disponibles
        autobus.demanderPlaceAssise(passager1);
        assertEquals(1, autobus.getNbPlacesAssises());  // 1 passager assis
        assertTrue(passager1.estAssis());  // Le passager1 devrait être assis
        // Vérifier que l'autre passager ne modifie pas l'état
        assertFalse(passager2.estAssis());  // passager2 ne doit pas être assis
    }

    @Test
    public void testDemanderPlaceDebout() {
        // Tester si un passager peut demander une place debout sans interférer avec l'autre passager
        assertTrue(autobus.aPlaceDebout());  // Il y a des places debout disponibles
        autobus.demanderPlaceDebout(passager2);
        assertEquals(1, autobus.getNbPlacesDebout());  // 1 passager debout
        assertTrue(passager2.estDebout());  // Le passager2 devrait être debout
        // Vérifier que l'autre passager ne modifie pas l'état
        assertFalse(passager1.estDebout());  // passager1 ne doit pas être debout
    }

    @Test
    public void testDemanderChangerEnDebout() {
        // Tester si un passager assis peut demander de changer en debout sans affecter les autres passagers
        autobus.demanderPlaceAssise(passager1);  // Passager1 s'assoit
        autobus.demanderChangerEnDebout(passager1);  // Passager1 se met debout
        assertTrue(passager1.estDebout());  // Le passager1 devrait maintenant être debout
        assertEquals(0, autobus.getNbPlacesAssises());  // Aucune place assise n'est occupée
        assertEquals(1, autobus.getNbPlacesDebout());  // 1 place debout est occupée
        // Vérifier que l'autre passager ne modifie pas l'état
        assertFalse(passager2.estDebout());  // passager2 ne doit pas être debout
    }

    @Test
    public void testDemanderChangerEnAssis() {
        // Tester si un passager debout peut demander de changer en assis sans affecter les autres passagers
        autobus.demanderPlaceDebout(passager2);  // Passager2 se met debout
        autobus.demanderChangerEnAssis(passager2);  // Passager2 se met assis
        assertTrue(passager2.estAssis());  // Le passager2 devrait maintenant être assis
        assertEquals(1, autobus.getNbPlacesAssises());  // 1 place assise est occupée
        assertEquals(0, autobus.getNbPlacesDebout());  // Aucune place debout n'est occupée
        // Vérifier que l'autre passager ne modifie pas l'état
        assertFalse(passager1.estAssis());  // passager1 ne doit pas être assis
    }

    @Test
    void testDemanderSortie() {
        Autobus autobus = new Autobus(10, 10);
        Passager passager = new FauxPassager();
        
        // Ajouter le passager au bus et vérifier qu'il n'est pas dehors au départ
        autobus.demanderPlaceAssise(passager);
        assertFalse(passager.estDehors(), "Le passager ne doit pas être dehors avant la sortie");
        
        // Demander la sortie du passager
        autobus.demanderSortie(passager);
        
        // Vérifier si le passager est bien dehors après la sortie
        assertTrue(passager.estDehors(), "Le passager doit être dehors après avoir accepté la sortie");
        
        // Test de la condition d'erreur
        autobus.demanderSortie(passager);  // Le passager est déjà dehors
        assertTrue(passager.estDehors(), "Le passager doit rester dehors après avoir déjà accepté la sortie");
    }


    @Test
    public void testFauxPassagerDemanderPlaceAssise() {
        // Tester si un faux passager peut demander une place assise sans interférer avec les autres passagers
        assertTrue(autobus.aPlaceAssise());  // Il y a des places assises disponibles
        autobus.demanderPlaceAssise(fauxPassager1);
        assertEquals(1, autobus.getNbPlacesAssises());  // 1 faux passager assis
        assertTrue(fauxPassager1.estAssis());  // Le faux passager devrait être assis
        // Vérifier que l'autre passager ne modifie pas l'état
        assertFalse(passager1.estAssis());  // passager1 ne doit pas être assis
    }

    @Test
    void testFauxPassagerDemanderSortie() {
        Autobus autobus = new Autobus(10, 10);
        FauxPassager fauxPassager = new FauxPassager();
        
        // Ajouter le FauxPassager au bus (en supposant qu'il a une place)
        autobus.demanderPlaceAssise(fauxPassager);
        
        // Vérifier qu'il n'est pas dehors avant la demande de sortie
        assertFalse(fauxPassager.estDehors(), "Le faux passager ne doit pas être dehors avant la sortie.");
        
        // Demander la sortie du passager
        autobus.demanderSortie(fauxPassager);
        
        // Vérifier qu'il est bien dehors après la sortie
        assertTrue(fauxPassager.estDehors(), "Le faux passager doit être dehors après avoir accepté la sortie.");
        
        // Essayer de demander à nouveau la sortie (il est déjà dehors)
        autobus.demanderSortie(fauxPassager);
        
        // Vérifier qu'il reste dehors
        assertTrue(fauxPassager.estDehors(), "Le faux passager doit rester dehors après avoir déjà accepté la sortie.");
    }


    @Test
    public void testAllerArretSuivant() throws UsagerInvalideException {
        // Tester le déplacement à l'arrêt suivant sans interférence entre les passagers
        autobus.demanderPlaceAssise(passager1);  // Passager1 s'assoit
        autobus.demanderPlaceDebout(passager2);  // Passager2 se met debout
        autobus.allerArretSuivant();  // Déplacement à l'arrêt suivant
        assertEquals(1, autobus.getNbPlacesAssises());  // Le passager assis est toujours dans l'autobus
        assertEquals(1, autobus.getNbPlacesDebout());  // Le passager debout est toujours dans l'autobus
        // Vérifier que l'état des passagers est correct
        assertTrue(passager1.estAssis());
        assertTrue(passager2.estDebout());
    }

    @Test
    public void testExceptions() {
        // Tester les exceptions pour des valeurs invalides
        Autobus busInvalide = new Autobus(-1, 10);  // Bus avec un nombre négatif de places assises
        assertThrows(UsagerInvalideException.class, () -> busInvalide.allerArretSuivant());

        Autobus busInvalide2 = new Autobus(10, -1);  // Bus avec un nombre négatif de places debout
        assertThrows(UsagerInvalideException.class, () -> busInvalide2.allerArretSuivant());
    }
}


