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
	protected int client_id;
	protected int decouvert;
	protected int remuneration;
	
	protected Client client;
	
	
	public CompteBancaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteBancaire(int id, String numCompte, double solde, String dateOuverture ,int client_id,int remuneration) {
		super();
		this.id = id;
		this.numCompte = numCompte;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
		this.client_id =client_id;
		this.remuneration =remuneration ;
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
	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public int getDecouvert() {
		return decouvert;
	}

	public void setdecouvert(int decouvert) {
		this.decouvert = decouvert;
	}
	
	public int getRemuneration() {
		return remuneration;
	}

	public void setRemuneration(int remuneration) {
		this.remuneration = remuneration;
	}
	
	

}
