package tec;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AutobusTest {

    private Autobus autobus;
    private FauxPassager passager1;
    private FauxPassager passager2;

    @BeforeEach
    void setUp() {
        try {
            autobus = new Autobus(2, 3);  // L'autobus avec 2 places assises et 3 places debout
        } catch (UsagerInvalideException e) {
            e.printStackTrace();
        }
        passager1 = new FauxPassager();
        passager2 = new FauxPassager();
    }

    @Test
    void testDemanderPlaceAssise() {
        assertTrue(autobus.aPlaceAssise(), "Il devrait y avoir des places assises disponibles.");
        autobus.demanderPlaceAssise(passager1);
        assertTrue(passager1.estAssis(), "Le passager 1 devrait être assis.");
        assertEquals(1, autobus.getNbPlacesAssises(), "Le nombre de places assises occupées devrait être de 1.");
    }

    @Test
    void testDemanderPlaceDebout() {
        assertTrue(autobus.aPlaceDebout(), "Il devrait y avoir des places debout disponibles.");
        autobus.demanderPlaceDebout(passager2);
        assertTrue(passager2.estDebout(), "Le passager 2 devrait être debout.");
        assertEquals(1, autobus.getNbPlacesDebout(), "Le nombre de places debout occupées devrait être de 1.");
    }

    @Test
    void testDemanderChangerEnDebout() {
        autobus.demanderPlaceAssise(passager1);
        autobus.demanderChangerEnDebout(passager1);
        assertTrue(passager1.estDebout(), "Le passager 1 devrait être debout après le changement.");
        assertEquals(0, autobus.getNbPlacesAssises(), "Le nombre de places assises occupées devrait être de 0.");
        assertEquals(1, autobus.getNbPlacesDebout(), "Le nombre de places debout occupées devrait être de 1.");
    }

    @Test
    void testDemanderChangerEnAssis() {
        autobus.demanderPlaceDebout(passager2);
        autobus.demanderChangerEnAssis(passager2);
        assertTrue(passager2.estAssis(), "Le passager 2 devrait être assis après le changement.");
        assertEquals(1, autobus.getNbPlacesAssises(), "Le nombre de places assises occupées devrait être de 1.");
        assertEquals(0, autobus.getNbPlacesDebout(), "Le nombre de places debout occupées devrait être de 0.");
    }

    @Test
    void testDemanderSortie() {
        autobus.demanderPlaceAssise(passager1);
        autobus.demanderSortie(passager1);
        assertTrue(passager1.estDehors(), "Le passager 1 devrait être dehors.");
    }
}

