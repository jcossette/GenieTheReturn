package genieprojet.annuaire;

import genieprojet.system.DBManager;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class is the information specialist for the clients and the users.
 * Created by coylter on 11/11/2014.
 */
public class Annuaire implements Serializable {

    private static Annuaire instance;
    private FabriqueClient fabriqueClient;
    private FabriqueUtilisateur fabriqueUtilisateur;
    private ArrayList<Utilisateur> myUsers;
    private ArrayList<Client> myClients;
    private int clientIdTicker;
    private int userIdTicker;

    private Annuaire() {
        myUsers = new ArrayList();
        myClients = new ArrayList();
        clientIdTicker = 0;
        userIdTicker = 0;
        
        fabriqueClient = FabriqueClient.getInstance();
        fabriqueUtilisateur = FabriqueUtilisateur.getInstance();
    }

    public static Annuaire getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = DBManager.getInstance().loadAnnuaire();
        if (instance == null) {
            instance = new Annuaire();
        }
        return instance;
    }

    public void ajouterUtilisateur(String niveau, String nom, String prenom, String password) {
        myUsers.add(fabriqueUtilisateur.creerUtilisateur(niveau, nom, prenom, password, userIdTicker++));
    }

    public void ajouterClient(String type, String nom, String nom2, Adresse adresse, String codePostal, String numTel, String age) {
        myClients.add(fabriqueClient.creerClient(type, age, nom, nom2, numTel, codePostal, adresse, age, clientIdTicker++));
    }
    
    public void saveUtilisateur(Utilisateur toSave, String newNiveau, String newNom, String newPrenom){
        if (!toSave.getNiveauString().equals(newNiveau)){
            retirerUtilisateur(toSave.getID());
            
            ajouterUtilisateur(newNiveau, newNom, newPrenom, toSave.getPassword());
        } else {
            Utilisateur user = getUser(toSave.getID());
            user.setNom(newNom);
            user.setPrenom(newPrenom);
            
            /*toSave.setNom(newNom);
            toSave.setPrenom(newPrenom);*/
        }
    }
    
    public void saveClient(Client toSave, String newNom, String newNom2, Adresse newAdresse, String newCodePostal, String newNumTel, String newAge){
        toSave.setNom(newNom);
        toSave.setNom2(newNom2);
        toSave.setAdresse(newAdresse);
        toSave.setCodePostal(newCodePostal);
        toSave.setNumTel(newNumTel);
        //newAge
    }

    public void retirerClient(String ID) {
        for (Client c : myClients) {
            if (c.getID().equals(ID)) {
                myClients.remove(c);
                break;
            }
        }
    }

    public void retirerUtilisateur(String ID) {
        for (Utilisateur u : myUsers) {
            if (u.getID().equals(ID)) {
                myUsers.remove(u);
                break;
            }
        }
    }

    public Client getClient(String ID) {
        for (Client c : myClients) {
            if (c.getID().equals(ID)) {
                return c;
            }
        }
        return null;
    }

    public Utilisateur getUser(String ID) {
        for (Utilisateur u : myUsers) {
            if (u.getID().equals(ID)) {
                return u;
            }
        }
        return null;
    }

    public ArrayList<Utilisateur> getAllUsers() {
        return myUsers;
    }

    public ArrayList<Client> getAllClients() {
        return myClients;
    }
    
    public ArrayList<Client> findClients(String toFind){
        toFind = toFind.toLowerCase();
        ArrayList<Client> results = new ArrayList();
        if(toFind.equals("")){
            return myClients;
        }
        for(Client a : myClients){
            if(a.getNom().toLowerCase().contains(toFind)){
                results.add(a);
            }else if(a.getPrenom().toLowerCase().contains(toFind)){
                results.add(a);
            }else if(a.getID().toLowerCase().contains(toFind)){
                results.add(a);
            }else if(a.getCodePostal().toLowerCase().contains(toFind)){
                results.add(a);
            }
        }
        return results;
    }
    
    public ArrayList<Utilisateur> findUsers(String toFind){
        toFind = toFind.toLowerCase();
        ArrayList<Utilisateur> results = new ArrayList();
        if(toFind.equals("")){
            return myUsers;
        }
        for(Utilisateur a : myUsers){
            if(a.getNom().toLowerCase().contains(toFind)){
                results.add(a);
            }else if(a.getID().toLowerCase().contains(toFind)){
                results.add(a);
            }else if(a.getPrenom().toLowerCase().contains(toFind)){
                results.add(a);
            }
        }
        return results;
    }
    
    public Utilisateur verifyUser(String userID, String password){
    	for (Utilisateur u : myUsers){
    		if (u.getID().equals(userID)){
    			if (u.getPassword().equals(password)){
    				return u;
    			} else {
    				return null;
    			}
    		}
    	}
    	return null;
    }
}
