package cm.objis.promo3.proxybank.domaine;

import java.util.Date;

/**
 * @author thierry WADJI
 *
 */
public class Agence {
	private Date creation;
	private String numId;
	private Bank bank;
	
	
	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Agence(Date creation, String numId) {
		super();
		this.creation = creation;
		this.numId = numId;
	}

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public String getNumId() {
		return numId;
	}

	public void setNumId(String numId) {
		this.numId = numId;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	

}
