/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package genieprojet.vente.taxe;

/**
 *
 * @author cloutsa
 */
public class TaxeProvOntario implements IStrategieTaxe {
    
    private final double TAUX_TAXE = 0.08;
    
    @Override
    public double calculerTaxesProvinciales(double sousTotal) { 
        return sousTotal * TAUX_TAXE;
    }
}
