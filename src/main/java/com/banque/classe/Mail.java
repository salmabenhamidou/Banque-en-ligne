package com.banque.classe;

public class Mail {
	
	private String nom;
	private String emetteur;
	private String sujet;
	private String msg;
	private String Date;
	
	public Mail(String emetteur, String sujet, String msg) {
		super();
		this.emetteur = emetteur;
		this.sujet = sujet;
		this.msg = msg;
	}
	
	public Mail(String nom, String emetteur, String msg, String sujet, String date) {
		super();
		this.nom = nom;
		this.emetteur = emetteur;
		this.sujet = sujet;
		this.msg = msg;
		Date = date;
	}

	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmetteur() {
		return emetteur;
	}
	public void setEmetteur(String emetteur) {
		this.emetteur = emetteur;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	@Override
	public String toString() {
		return "Mail [nom=" + nom + ", emetteur=" + emetteur + ", sujet=" + sujet + ", msg=" + msg + ", Date=" + Date
				+ "]";
	}

}
