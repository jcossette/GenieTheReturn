package genieprojet.annuaire;

import java.io.Serializable;

public class Adresse implements Serializable{

    private String numero;
    private String rue, ville, province;
    private String adresse;

    public Adresse(String numero, String rue, String ville, String province) {
        this.numero = numero;
        this.rue = rue;
        this.ville = ville;
        this.province = province;
    }

    public String getAdresse() {
        adresse = numero + ", " + rue + ", " + ville + ", " + province;
        return adresse;
    }

    public String getNumero() {
        return numero;
    }

    public String getRue() {
        return rue;
    }

    public String getVille() {
        return ville;
    }

    public String getProvince() {
        return province;
    }
}
