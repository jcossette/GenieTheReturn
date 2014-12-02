package genieprojet.vente;

import genieprojet.vente.taxe.IStrategieTaxe;
import genieprojet.annuaire.Client;
import java.text.NumberFormat;
import java.util.ArrayList;
import genieprojet.util.Observable;

/**
 *
 * @author Benoit
 */
public class Vente extends Observable {

    private int numero;
    private Client client;
    private ArrayList<Paiement> paiements;
    private ArrayList<LigneArticle> lignes;
    private IStrategieTaxe strategieTaxe;

    public Vente(IStrategieTaxe iStrategieTaxe) {
        this.numero = 0;
        this.client = null;
        this.lignes = new ArrayList<>();
        this.paiements = new ArrayList<>();
        this.strategieTaxe = iStrategieTaxe;
    }

    public void ajouterArticle(LigneArticle ligneArticle) {
        lignes.add(ligneArticle);
        notifier();
    }

    public void ajouterPaiement(Paiement paiement) {
        paiements.add(paiement);
        notifier();
    }
    
    public void setStrategieTaxe(IStrategieTaxe strategie) {
        this.strategieTaxe = strategie;
        notifier();
    }

    public Client getClient() {
        return client;
    }

    public LigneArticle getLigneFromArticle(Article article) {
        for (LigneArticle la : lignes) {
            if (la.getArticle().equals(article)) {
                return la;
            }
        }
        return null;
    }

    public ArrayList<LigneArticle> getLignes() {
        return lignes;
    }

    public int getNumero() {
        return numero;
    }

    public double getPaiementsTotal() {
        double total = 0;

        for (Paiement p : paiements) {
            total += p.getMontant();
        }

        return total;
    }
    
    public ArrayList<Paiement> getPaiements() {
        return paiements;
    }

    public double getSolde() {
        return getTotal() - getPaiementsTotal();
    }

    public double getSousTotal() {
        double sousTotal = 0;

        for (LigneArticle ligne : lignes) {
            sousTotal += ligne.getPrix();
        }

        return sousTotal;
    }

    public double getTaxesFederales() {
        return getSousTotal() * 0.05;
    }

    public double getTaxesProvinciales() {
        return strategieTaxe.calculerTaxesProvinciales(getSousTotal());
    }

    public double getTotal() {
        return getSousTotal() + getTaxesFederales() + getTaxesProvinciales();
    }

    public boolean hasArticle(Article article) {
        for (LigneArticle la : lignes) {
            if (la.getArticle().equals(article)) {
                return true;
            }
        }
        return false;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    void setNumero(int numero) {
        this.numero = numero;
    }
    
    @Override
    public String toString() {
        NumberFormat f = NumberFormat.getCurrencyInstance();
        return "Facture #" + getNumero() + " : " + f.format(getTotal());
    }
}
