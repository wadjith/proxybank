package cm.objis.promo3.proxybank.domaine;

public class Bank {
	private int id;
	private String nom;
	
	
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bank(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}
