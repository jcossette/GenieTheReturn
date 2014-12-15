package genieprojet.tests.vente;

import genieprojet.vente.taxe.*;

import static org.junit.Assert.*;
import genieprojet.vente.Registre;
import genieprojet.vente.Vente;

import org.junit.Before;
import org.junit.Test;

public class RegistreTest {

	Registre registre;
	
	@Before
	public void setUp() {
		registre = Registre.getInstance();
	}
	
	@Test
	public void testAjouterVente() {
		int size = registre.getAllVentes().size();
		creerVente();
		assertEquals("Une vente a ete ajoute", registre.getAllVentes().size(), size + 1);
	}

	@Test
	public void testGetLastVente() {
		Vente v = creerVente();
		assertEquals("Derniere vente test", registre.getLastVente(), v);
	}

	private Vente creerVente() {
		Vente v = new Vente(new TaxeProvOntario());
		registre.ajouterVente(v);
		return v;
	}
}
