package genieprojet.controleurs;

import genieprojet.system.DBManager;
import genieprojet.vente.Article;
import genieprojet.vente.Catalogue;
import java.util.ArrayList;
import genieprojet.util.Observable;

/**
 *
 * @author Julien Cossette
 */
public class CatalogueControleur extends Observable{
    private Catalogue myCatalogue;

    public CatalogueControleur() {
        this.myCatalogue = Catalogue.getInstance();
    }

    public void ajouterArticle(String nom, int qty, String note, double prix) {
        myCatalogue.addArticle(nom, qty, note, prix);
        saveCatalogue();
        notifier();
    }

    public void retirerArticle(String IDtoRemove) {
        myCatalogue.removeArticle(IDtoRemove);
        saveCatalogue();
        notifier();
    }
    
    public void saveArticle(Article toSave, String newNom, int newQty, double newPrix, String newNote){
        myCatalogue.saveArticle(toSave, newNom, newQty, newPrix, newNote);
        saveCatalogue();
        notifier();
    }

    public ArrayList<Article> getAllArticles() {
        return myCatalogue.getAllArticles();
    }

    public int getNumArticle() {
        return myCatalogue.getNumArticle();
    }

    public void saveCatalogue() {
        DBManager.getInstance().saveCatalogue(myCatalogue);
    }

    public Article getArticle(String toFind) {
        return myCatalogue.getArticle(toFind);
    }
    
    public ArrayList<Article> findArticle(String toSearch){
        return myCatalogue.findArticle(toSearch);
    }
}
