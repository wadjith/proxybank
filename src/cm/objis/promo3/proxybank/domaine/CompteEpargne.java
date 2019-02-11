/**
 * 
 */
package cm.objis.promo3.proxybank.domaine;

/**
 * @author thierry WADJI
 *
 */
public class CompteEpargne extends CompteBancaire {

	/**
	 * Indique le taux de rénumération du compte d'épargne.
	 * Sa valeur par défaut est de 3% (0.03)
	 */
	private float renumeration;
	
	
	public CompteEpargne() {
		super();
		this.renumeration = 0.03f;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param numCompte
	 * @param solde
	 * @param dateOuverture
	 */
	public CompteEpargne(int id, String numCompte, double solde, String dateOuverture) {
		super(id, numCompte, solde, dateOuverture);
		this.renumeration = 0.03f;
	}

	public float getRenumeration() {
		return renumeration;
	}

	public void setRenumeration(float renumeration) {
		this.renumeration = renumeration;
	}

}
