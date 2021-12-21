package com.banque.classe;

import java.util.Date;

public class Virement {

	private String emetteur;
	private String recepteur;
	private Double montant;
	private String dateVirement;
	
	
	public Virement(String emetteur) {
		super();
		this.emetteur = emetteur;
	}

	public Virement(String emetteur, String recepteur, Double montant, String dateVirement) {
		super();
		this.emetteur = emetteur;
		this.recepteur = recepteur;
		this.montant = montant;
		this.dateVirement = dateVirement;
	}

	public String getEmetteur() {
		return emetteur;
	}

	public void setEmetteur(String emetteur) {
		this.emetteur = emetteur;
	}

	public String getRecepteur() {
		return recepteur;
	}

	public void setRecepteur(String recepteur) {
		this.recepteur = recepteur;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public String getDateVirement() {
		return dateVirement;
	}

	public void setDateVirement(String dateVirement) {
		this.dateVirement = dateVirement;
	}

	@Override
	public String toString() {
		return "Virement [emetteur=" + emetteur + ", recepteur=" + recepteur + ", montant=" + montant
				+ ", dateVirement=" + dateVirement + "]";
	}
	
	
	
}
