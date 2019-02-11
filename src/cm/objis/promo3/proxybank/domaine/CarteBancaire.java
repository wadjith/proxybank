package cm.objis.promo3.proxybank.domaine;

/**
 * @author thierry WADJI
 *
 */
public class CarteBancaire {

	private int numero;
	private TypeCarte type;
	private boolean actif;
	
	private Client client;
	
	public CarteBancaire() {
		// TODO Auto-generated constructor stub
	}
	public CarteBancaire(int numero, TypeCarte type) {
		super();
		this.numero = numero;
		this.type = type;
		this.actif = true;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public TypeCarte getType() {
		return type;
	}
	public void setType(TypeCarte type) {
		this.type = type;
	}
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	

}
