/**
 * 
 */
package cm.objis.promo3.proxybank.domaine;

/**
 * Classe abstraite representant un compte bancaire
 * 
 * @author thierry WADJI
 *
 */
public abstract class CompteBancaire {
	protected int id;
	protected String numCompte;
	protected double solde;
	protected String dateOuverture;
	
	protected Client client;
	
	
	public CompteBancaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteBancaire(int id, String numCompte, double solde, String dateOuverture) {
		super();
		this.id = id;
		this.numCompte = numCompte;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
	}

	public String getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	

}
