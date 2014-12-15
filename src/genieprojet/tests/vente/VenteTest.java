package genieprojet.tests.vente;

import static org.junit.Assert.*;
import genieprojet.vente.Article;
import genieprojet.vente.LigneArticle;
import genieprojet.vente.Paiement;
import genieprojet.vente.Vente;
import genieprojet.vente.taxe.TaxeProvOntario;

import org.junit.Before;
import org.junit.Test;

public class VenteTest {

	Vente vente;
	
	@Before
	public void before() {
		vente = new Vente(new TaxeProvOntario());
	}

	@Test
	public void testAjouterArticle() {
		int size = vente.getLignes().size();
		ajouterArticle();
		assertEquals("Un article a ete ajoute à la vente", vente.getLignes().size(), size + 1);
	}
	
	private void ajouterArticle() {
		Article articleTest = new Article("aTest", 2, "noteTest", 5.55, 10000);
		LigneArticle ligneTest = new LigneArticle(articleTest, 2);
		vente.ajouterArticle(ligneTest);
	}

	@Test
	public void testAjouterPaiement() {
		int size = vente.getPaiements().size();
		ajouterPaiement();
		assertEquals("Un paiement a ete ajoute à la vente", vente.getPaiements().size(), size + 1);
	}
	
	private void ajouterPaiement() {
		Paiement paiementTest = new Paiement(11.50);
		vente.ajouterPaiement(paiementTest);
	}
}
