/**
 * 
 */
package cm.objis.promo3.proxybank.domaine;

/**
 * @author thierry WADJI
 *
 */
public enum TypeCarte {
	VISAE("VISA ELECTRON"),
	VISAP("VISA PREMIER");
	
	private String nom;
	
	//Constructeur
	TypeCarte(String nom){
		this.nom = nom;
	}
	
	public String toString() {
		return nom;
		
	}

}
