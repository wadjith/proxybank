package cm.objis.promo3.proxybank.domaine;

/**
 * @author thierry WADJI
 *
 */
public class CarteBancaire {

	private int numero;
	private int client_id;
	private String type;
	private boolean actif;
	
	private Client client;
	
	
	public CarteBancaire() {
		// TODO Auto-generated constructor stub
	}
	public CarteBancaire(int numero, String type) {
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
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
	public int getclient_id() {
		return client_id;
	}
	public void setclient_id(int client_id) {
		this.client_id = client_id;
	}

}
