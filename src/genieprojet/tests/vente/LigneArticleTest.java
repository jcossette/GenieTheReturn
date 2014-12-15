package genieprojet.tests.vente;

import static org.junit.Assert.*;
import genieprojet.vente.Article;
import genieprojet.vente.LigneArticle;

import org.junit.Test;

public class LigneArticleTest {

	@Test
	public void testPrix() {
		LigneArticle la = new LigneArticle(new Article("Test", 10, "Test", 19.99, 1000000), 5);
		assertEquals(la.getPrix(), la.getArticle().getPrix() * la.getQte(), 0.001);
	}

}
