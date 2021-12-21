package com.banque.classe;

import java.util.Date;

public class RendezVous extends Personne{
	
	private String date;
	private String service;
	private String dateReservation;
	
	public RendezVous(String nom, String prenom, String date, String service, String dateReservation) {
		super(nom, prenom);
		this.date = date;
		this.service = service;
		this.dateReservation = dateReservation;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(String dateReservation) {
		this.dateReservation = dateReservation;
	}
	@Override
	public String toString() {
		return "RendezVous [date=" + date + ", service=" + service + ", dateReservation=" + dateReservation + "]";
	}
	
}
