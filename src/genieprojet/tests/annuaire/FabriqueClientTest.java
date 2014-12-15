package genieprojet.tests.annuaire;

import static org.junit.Assert.*;
import genieprojet.annuaire.Adresse;
import genieprojet.annuaire.Client;
import genieprojet.annuaire.Entreprise;
import genieprojet.annuaire.FabriqueClient;
import genieprojet.annuaire.Personne;

import org.junit.Test;

public class FabriqueClientTest {

	@Test
	public void test_CreerClientParticulier(){
		Client testClientPersonne = creerClientParticulier();
		assertNotNull(testClientPersonne);
		assertEquals(Personne.class, testClientPersonne.getClass());
	}
	
	@Test
	public void test_CreerClientEntreprise(){
		Client testClientEntreprise = creerClientEntreprise();
		assertNotNull(testClientEntreprise);
		assertEquals(Entreprise.class, testClientEntreprise.getClass());
	}
	
	private Client creerClientParticulier(){
		Adresse forTesting = new Adresse("124", "Bob", "Roger", "Bill");
		return FabriqueClient.getInstance().creerClient("Particulier", "1", "Bill", "Bob", "5121231234", "G1Q1Q9", forTesting, "34", 1);
	}
	
	private Client creerClientEntreprise(){
		Adresse forTesting = new Adresse("124", "Bob", "Roger", "Bill");
		return FabriqueClient.getInstance().creerClient("Entreprise", "1", "Bill", "Bob", "5121231234", "G1Q1Q9", forTesting, "34", 1);
	}
	
}
