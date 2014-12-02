package genieprojet.annuaire;

import java.io.Serializable;

/**
 * Created by coylter on 11/11/2014.
 */
public abstract class Client implements Serializable{

    private String ID;
    private String nom;
    private String numTel;
    private String codePostal;
    private Adresse adresse;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
    
    @Override
    public String toString() {
        return getNom();
    }

    public abstract String getType();

    public abstract String getPrenom();

    public abstract String getAge();
    
    public abstract void setNom2(String newNom);
}
