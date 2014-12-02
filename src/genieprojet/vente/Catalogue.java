package genieprojet.vente;

import genieprojet.system.DBManager;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Benoit
 */
public class Catalogue implements Serializable {

    private static Catalogue instance;
    private ArrayList<Article> articles;
    private int IDticker;

    private Catalogue() {
        articles = new ArrayList();
        IDticker = 1000000;
    }

    public static Catalogue getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = DBManager.getInstance().loadCatalogue();
        if (instance == null) {
            instance = new Catalogue();
        }
        return instance;
    }

    public Article getArticle(String IDtoGet) {
        for (Article article : articles) {
            if (article.getID().equals(IDtoGet)) {
                return article;
            }
        }
        return null;
    }

    public void addArticle(String nom, int qty, String note, double prix) {
        Article newArticle = new Article(nom, qty, note, prix, IDticker);
        articles.add(newArticle);
        IDticker++;
    }

    public void removeArticle(String IDtoRemove) {
        articles.remove(getArticle(IDtoRemove));
    }

    public ArrayList<Article> getAllArticles() {
        return articles;
    }

    public int getNumArticle() {
        return articles.size();
    }
    
    public void saveArticle(Article toSave, String newNom, int newQty, double newPrix, String newNote){
        toSave.setNom(newNom);
        toSave.setQty(newQty);
        toSave.setPrix(newPrix);
        toSave.setNote(newNote);
    }
    
    public ArrayList<Article> findArticle(String toFind){
        toFind = toFind.toLowerCase();
        ArrayList<Article> results = new ArrayList();
        if(toFind.equals("")){
            return articles;
        }
        for(Article a : articles){
            if(a.getNom().toLowerCase().contains(toFind)){
                results.add(a);
            }else if(a.getID().toLowerCase().contains(toFind)){
                results.add(a);
            }
        }
        return results;
    }
}
