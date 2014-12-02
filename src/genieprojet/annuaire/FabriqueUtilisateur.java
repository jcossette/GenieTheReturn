package genieprojet.annuaire;

import java.io.Serializable;

/**
 *
 * @author fillioca
 */
public class FabriqueUtilisateur implements Serializable{

    private static FabriqueUtilisateur instance;

    private FabriqueUtilisateur() {
    }

    public static FabriqueUtilisateur getInstance() {
        if (instance == null) {
            instance = new FabriqueUtilisateur();
        }
        return instance;
    }

    public Utilisateur creerUtilisateur(String niveau, String nom, String prenom, int userIdTicker) {
        Utilisateur newUtilisateur;

        switch (niveau) {
            case "Prepose":
                newUtilisateur = new Prepose();
                break;
            case "Sous-directeur":
                newUtilisateur = new SousDirecteur();
                break;
            default:
                newUtilisateur = new Directeur();
        }
        newUtilisateur.setID(nom.substring(0, 3) + userIdTicker);
        newUtilisateur.setNom(nom);
        newUtilisateur.setPrenom(prenom);

        return newUtilisateur;
    }
}
