package com.banque.classe;

import java.util.ArrayList;

import com.banque.classe.*;

public class Client extends Personne{
	
	private double solde;
	private String pwd;
	
	
	public Client(String identifiant) {
		super(identifiant);
	}
	public Client(String identifiant, String pwd) {
		super(identifiant);
		this.pwd = pwd;
	}
	public Client(String identifiant, String nom, String prenom, double solde, String pwd) {
		super(nom, prenom, identifiant);
		this.solde = solde;
		this.pwd = pwd;
	}
	
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@Override
	public String toString() {
		return "Client [solde=" + solde + ", pwd=" + pwd + "]";
	}
	public Boolean comparer(double mt) {
		return (mt > this.solde)? false : true;
	}
}
