package genieprojet.controleurs;

import genieprojet.gui.PortailUI;

public class PortailControleur {
	
	PortailUI portail;
	
	public PortailControleur (PortailUI portail){
		this.portail = portail;
	}
	
	public void authenticateVente(){
		portail.showVente();
	}
	
	public void authenticateAnnuaire(){
		portail.showAnnuaire();
	}
	
	public void authenticateUsers(){
		portail.showUsers();
	}
	
	public void authenticateCatalogue(){
		portail.showCatalogue();
	}
}
