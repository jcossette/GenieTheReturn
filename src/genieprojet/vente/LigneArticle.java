package genieprojet.vente;

/**
 *
 * @author Benoit
 */
public class LigneArticle {

    private Article article;
    private int quantite;

    public LigneArticle(Article article, int quantite) {
        this.article = article;
        this.quantite = quantite;
    }

    public Article getArticle() {
        return article;
    }

    /*
     * Retourne le prix total selon la quantite.
     */
    public double getPrix() {
        return this.article.getPrix() * quantite;
    }

    public int getQte() {
        return quantite;
    }

    public void setQte(int qte) {
        quantite = qte;
    }
}
