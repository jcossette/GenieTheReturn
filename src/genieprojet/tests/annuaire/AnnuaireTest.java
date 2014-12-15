package genieprojet.tests.annuaire;

import static org.junit.Assert.*;
import genieprojet.annuaire.Adresse;
import genieprojet.annuaire.Annuaire;
import genieprojet.annuaire.Client;
import genieprojet.annuaire.Utilisateur;

import org.junit.Before;
import org.junit.Test;

public class AnnuaireTest {
	Annuaire annuaire;
	
	@Before
	public void before() {
		annuaire = Annuaire.getInstance();
	}

	@Test
	public void testAjouterUtilisateur() {
		int size = annuaire.getAllUsers().size();
		creerUtilisateur();
		assertEquals("Un utilisateur a ete ajoute", annuaire.getAllUsers().size(), size + 1);
	}

	@Test
	public void testAjouterClient() {
		int size = annuaire.getAllClients().size();
		creerClient();
		assertEquals("Un client a ete ajoute", annuaire.getAllClients().size(), size + 1);
	}
	
	@Test
	public void testRetirerUtilisateur() {
		creerUtilisateur();
		int initial = annuaire.getAllUsers().size();
		annuaire.retirerUtilisateur("Jea0");
		assertEquals("Un utilisateur a ete retire", annuaire.getAllUsers().size(), initial - 1);
	}
	
	@Test
	public void testRetirerClient() {
		creerClient();
		int initial = annuaire.getAllClients().size();
		annuaire.retirerClient("Jea0");
		assertEquals("Un client a ete retire", annuaire.getAllClients().size(), initial - 1);
	}
	
	@Test
	public void testSaveUtilisateur() {
		creerUtilisateur();
		Utilisateur user = annuaire.getUser("Jea0");
		annuaire.saveUtilisateur(user, "Prepose", "Math", "Beliveau");
		assertEquals("L'utilisateur est mis a jour", user.getNom(), "Math");
	}
	
	@Test
	public void testSaveClient() {
		creerClient();
		Client client = annuaire.getClient("Jea0");
		annuaire.saveClient(client, "Test", "", new Adresse("", "", "", ""), "", "", "");
		assertEquals("Le client est mis a jour", client.getNom(), "Test");
	}
	
	@Test
	public void testFindClient() {
		creerClient();
		assertEquals("Le client a ete trouve", annuaire.findClients("Jean").size(), 1);
	}
	
	@Test
	public void testFindUtilisateur() {
		creerUtilisateur();
		assertEquals("L'utilisateur a ete trouve", annuaire.findUsers("Jean").size(), 1);
	}

	private void creerUtilisateur() {
		annuaire.ajouterUtilisateur("Prepose", "Jean", "Jeanne", "Test");
	}

	private void creerClient() {
		annuaire.ajouterClient("Personne", "Jean", "Jeanne", new Adresse("124", "Bonaventure", "Repentigny", "QC"), "J5Y6C4","5144534343",  "25");
	}
}
