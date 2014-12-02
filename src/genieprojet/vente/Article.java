package genieprojet.vente;

import java.io.Serializable;

/**
 *
 * @author Julien Cossette
 */
public class Article implements Serializable {

    private String ID;
    private String nom;
    private int qty;
    private String note;
    private double prix;

    public Article(String nom, int qty, String note, double prix, int IDticker) {
        this.nom = nom;
        this.qty = qty;
        this.note = note;
        this.prix = prix;
        this.ID = generateID(IDticker);
    }

    private String generateID(int IDticker) {
        return getNom().substring(0, 3) + IDticker;
    }

    /**
     * @return The ID of this item
     */
    public String getID() {
        return this.ID;
    }

    /**
     * @return The name of this item
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom The name to set to this item
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return The quantity of this item
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty The quantity of this item to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return The notes of this item
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note Sets the note of this item
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return The price of this item
     */
    public double getPrix() {
        return prix;
    }

    /**
     * @param prix Sets the price of this item
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }
    
    @Override
    public String toString() {
        return getID() + " - " + getNom();
    }
}
