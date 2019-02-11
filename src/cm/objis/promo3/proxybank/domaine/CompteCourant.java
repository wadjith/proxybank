/**
 * 
 */
package cm.objis.promo3.proxybank.domaine;

/**
 * @author thierry WADJI
 *
 */
public class CompteCourant extends CompteBancaire {
	
	/**
	 * Le compte courant qui a un decouvert par defaut de 1000 
	 */
	private int decouvert;
	

	public CompteCourant() {
		super();
		this.decouvert = 1000;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param numCompte
	 * @param solde
	 * @param dateOuverture
	 */
	public CompteCourant(int id, String numCompte, double solde, String dateOuverture) {
		super(id, numCompte, solde, dateOuverture);
		this.decouvert = 1000;
	}

	public int getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(int decouvert) {
		this.decouvert = decouvert;
	}
	

}
