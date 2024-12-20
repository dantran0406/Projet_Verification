package tec;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import tec.Autobus;

public class AutobusTest {

    @Test
    public void testConstructeurAvecDeuxValeurs() {
        Autobus bus = new Autobus(10, 20);
        assertEquals(10, bus.getMaxPlacesAssises());
        assertEquals(20, bus.getMaxPlacesDebout());
    }

    @Test
    public void testConstructeurAvecUneValeur() {
        Autobus bus = new Autobus(15);
        assertEquals(15, bus.getMaxPlacesAssises());
        assertEquals(15, bus.getMaxPlacesDebout());
    }

    @Test
    public void testConstructeurParDefaut() {
        Autobus bus = new Autobus();
        assertEquals(0, bus.getMaxPlacesAssises());
        assertEquals(0, bus.getMaxPlacesDebout());
    }

    @Test
    public void testDemanderPlaceAssise() {
        Autobus bus = new Autobus(1, 1);
        FauxPassager passager = new FauxPassager();
        bus.demanderPlaceAssise(passager);
        assertEquals(1, bus.getNbPlacesAssises());
    }

    @Test
    public void testDemanderPlaceDebout() {
        Autobus bus = new Autobus(1, 1);
        FauxPassager passager = new FauxPassager();
        bus.demanderPlaceDebout(passager);
        assertEquals(1, bus.getNbPlacesDebout());
    }
}

