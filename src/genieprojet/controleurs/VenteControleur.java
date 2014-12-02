package genieprojet.controleurs;

import genieprojet.annuaire.Annuaire;
import genieprojet.annuaire.Client;
import genieprojet.gui.VenteUI;
import genieprojet.vente.Article;
import genieprojet.vente.Catalogue;
import genieprojet.vente.LigneArticle;
import genieprojet.vente.Paiement;
import genieprojet.vente.Registre;
import genieprojet.vente.Vente;
import genieprojet.vente.taxe.IStrategieTaxe;
import genieprojet.vente.taxe.TaxeProvQuebec;
import genieprojet.vente.taxe.TaxeProvOntario;
import genieprojet.vente.taxe.TaxeProvSaskatchewan;

/**
 *
 * @author Julien Cossette
 */
public class VenteControleur {
    private Vente venteCourante;
    private final VenteUI vue;
    private final Registre registre;
    private final Catalogue catalogue;
    private IStrategieTaxe iStrategieTaxe;
    
    enum Province {
        QUEBEC,
        ONTARIO,
        SASKATCHEWAN
    }

    public VenteControleur(Registre registre, Catalogue catalogue, VenteUI vue) {
        this.iStrategieTaxe = new TaxeProvQuebec();
        this.venteCourante = new Vente(iStrategieTaxe);
        this.catalogue = catalogue;
        this.registre = registre;
        this.vue = vue;
        this.vue.setVente(venteCourante);
        this.vue.setControleur(this);
    }

    public void ajouterArticle(String id, int qte) {
        Article article = catalogue.getArticle(id);
        LigneArticle la = venteCourante.hasArticle(article) ?
                venteCourante.getLigneFromArticle(article) : new LigneArticle(article, qte);
        int vraiQte = venteCourante.hasArticle(article) ? la.getQte() + qte : qte;

        // verifier que l'article existe
        if (article == null) {
            vue.showErreur("Aucun article avec ce code");
            return;
        }

        // verifier le stock
        if (article.getQty() < vraiQte) {
            vue.showErreur("Pas assez d'articles en stock");
            return;
        }

        // update si article deja dans la vente
        if (venteCourante.hasArticle(article)) {
            la.setQte(vraiQte);
            vue.update();
        } else {
            venteCourante.ajouterArticle(la);
        }
    }

    public void ajouterPaiement(double paiement) {
        venteCourante.ajouterPaiement(new Paiement(paiement));
    }
    public void ouvrirVente(Vente v) {
        nouvelleVente(v, false);
    }
    
    public void nouvelleVente() {
        nouvelleVente(null, true);
        vue.clearFields();
    }
    
    public void nouvelleVente(Vente v, boolean confirmation) {
        // si vente en cours, demander a l'utiliseur s'il est certain
        if ((venteCourante != null) && confirmation) {
            if (vue.demanderConfirmation("Les modifications seront perdues, etes-vous certain de vouloir continuer?")) {
                return;
            }
        }
        // re-initialiser une nouvelle vente;
        venteCourante = (v != null) ? v : new Vente(iStrategieTaxe);
        vue.setVente(venteCourante);
    }
    
    public void setProvince(String province) {
        // mettre taxe courante choisi
        Province p = Province.valueOf(province);
        switch (p) {
            case QUEBEC:
                iStrategieTaxe = new TaxeProvQuebec();
                break;
            case ONTARIO:
                iStrategieTaxe = new TaxeProvOntario();
                break;
            case SASKATCHEWAN:
                iStrategieTaxe = new TaxeProvSaskatchewan();
                break;
        }
        
        // vente en cours // update
        if (venteCourante != null) {
            venteCourante.setStrategieTaxe(iStrategieTaxe);
        }
    }

    public void confirmerVente(String idClient) {
        Client client = Annuaire.getInstance().getClient(idClient);
        
        if (client == null) {
            vue.showErreur("Le client n'a pas ete specifie ou n'existe pas");
            return;
        }
        
        venteCourante.setClient(client);
        registre.ajouterVente(venteCourante);
        vue.showMessage("La vente a été enregistrée");
        vue.clearFields();
        nouvelleVente(null, false);
    }
}
