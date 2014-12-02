package genieprojet.vente;

import java.util.ArrayList;

/**
 *
 * @author Benoit
 */
public class Registre {

    private static Registre instance;
    private ArrayList<Vente> ventes;
    private static int id;

    private Registre() {
        this.ventes = new ArrayList<>();
        id = 1;
    }

    public static Registre getInstance() {
        if (instance == null) {
            instance = new Registre();
        }
        return instance;
    }

    public void ajouterVente(Vente venteCourante) {
        // deja dans le registre
        if (ventes.contains(venteCourante)) {
            // revert quantite dans le catalogue pour correction update
            for (LigneArticle la : venteCourante.getLignes()) {
                Article article = la.getArticle();
                article.setQty(article.getQty() + la.getQte());
            }
            return;
        }
        // ajoute une nouvelle
        venteCourante.setNumero(id++);
        ventes.add(venteCourante);
        
        // update quantite dans le catalogue
        for (LigneArticle la : venteCourante.getLignes()) {
            Article article = la.getArticle();
            article.setQty(article.getQty() - la.getQte());
            System.out.println(article.getQty());
        }
    }

    public Vente getLastVente() {
        if (!ventes.isEmpty()) {
            return ventes.get(ventes.size() - 1);
        }
        return null;
    }
    
    public ArrayList<Vente> getAllVentes() {
         return ventes;
    }

    int nextNumber() {
        Vente last = getLastVente();

        if (last != null) {
            return last.getNumero() + 1;
        }
        return 0;
    }
}
