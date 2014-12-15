package genieprojet.tests.annuaire;

import static org.junit.Assert.*;
import genieprojet.annuaire.Adresse;
import genieprojet.annuaire.Client;
import genieprojet.annuaire.Directeur;
import genieprojet.annuaire.Entreprise;
import genieprojet.annuaire.FabriqueClient;
import genieprojet.annuaire.FabriqueUtilisateur;
import genieprojet.annuaire.Personne;
import genieprojet.annuaire.Prepose;
import genieprojet.annuaire.SousDirecteur;
import genieprojet.annuaire.Utilisateur;

import org.junit.Test;

public class FabriqueUtilisateurTest {

	@Test
	public void test_CreerUtilisateurPrepose(){
		Utilisateur testUtilisateurPrepose = creerUtilisateurPrepose();
		assertNotNull(testUtilisateurPrepose);
		assertEquals(Prepose.class, testUtilisateurPrepose.getClass());
	}
	
	@Test
	public void test_CreerUtilisateurDirecteur(){
		Utilisateur testUtilisateurDirecteur = creerUtilisateurDirecteur();
		assertNotNull(testUtilisateurDirecteur);
		assertEquals(Directeur.class, testUtilisateurDirecteur.getClass());
	}
	
	@Test
	public void test_CreerUtilisateurSousDirecteur(){
		Utilisateur testUtilisateurSousDirecteur = creerUtilisateurSousDirecteur();
		assertNotNull(testUtilisateurSousDirecteur);
		assertEquals(SousDirecteur.class, testUtilisateurSousDirecteur.getClass());
	}
	
	private Utilisateur creerUtilisateurPrepose(){
		return FabriqueUtilisateur.getInstance().creerUtilisateur("Prepose", "Bob", "Roger", "password", 1);
	}
	
	private Utilisateur creerUtilisateurDirecteur(){
		return FabriqueUtilisateur.getInstance().creerUtilisateur("Directeur", "Bob", "Roger", "password", 1);
	}
	
	private Utilisateur creerUtilisateurSousDirecteur(){
		return FabriqueUtilisateur.getInstance().creerUtilisateur("Sous-directeur", "Bob", "Roger", "password", 1);
	}

}
