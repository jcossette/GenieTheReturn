package genieprojet.tests.vente;

import static org.junit.Assert.*;
import genieprojet.annuaire.Utilisateur;
import genieprojet.vente.Article;
import genieprojet.vente.Catalogue;

import org.junit.Before;
import org.junit.Test;

public class CatalogueTest {

	Catalogue catalogue;
	
	@Before
	public void before() {
		catalogue = catalogue.getInstance();
	}
	
	@Test
	public void testAddArticle() {
		int size = catalogue.getNumArticle();
		creerArticle();
		assertEquals("Un utilisateur a ete ajoute", catalogue.getNumArticle(), size + 1);
	}

	private void creerArticle() {
		catalogue.setIDTicker(1000000);
		catalogue.addArticle("Test", 10, "Test", 99.99);
		
	}

	@Test
	public void testRemoveArticle() {
		creerArticle();
		int initial = catalogue.getNumArticle();
		catalogue.removeArticle("Tes1000000");
		assertEquals("Un utilisateur a ete retire", catalogue.getNumArticle(), initial - 1);
	}

	@Test
	public void testSaveArticle() {
		creerArticle();
		Article article = catalogue.getArticle("Tes1000000");
		catalogue.saveArticle(article, "other", 12, 10.99, "other");
		assertEquals("L'article est mis a jour", article.getNom(), "other");
	}

}
