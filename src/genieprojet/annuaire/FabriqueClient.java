package genieprojet.annuaire;

import java.io.Serializable;

/**
 *
 * @author fillioca
 */
public class FabriqueClient implements Serializable{
    
    private static FabriqueClient instance;
    
    private FabriqueClient(){}
    
    public static FabriqueClient getInstance() {
        if (instance == null) {
            instance = new FabriqueClient();
        }
        return instance;
    }
    
    public Client creerClient(String type, String ID, String nom, String nom2, String numTel, String codePostal, Adresse adresse, String age, int clientIdTicker){
        Client newClient;

        if (type.equals("Entreprise")) {
            newClient = new Entreprise(nom2);
        } else {
            int ageInt = Integer.parseInt(age);
            newClient = new Personne(nom2, ageInt);
        }

        newClient.setID(nom.substring(0, 3) + clientIdTicker);
        newClient.setNom(nom);
        newClient.setCodePostal(codePostal);
        newClient.setAdresse(adresse);
        newClient.setNumTel(numTel);
        
        return newClient;
    }
}
