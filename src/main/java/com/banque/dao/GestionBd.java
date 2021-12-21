package com.banque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.banque.classe.Client;
import com.banque.classe.Mail;
import com.banque.classe.RendezVous;
import com.banque.classe.Virement;

public class GestionBd {
	
	public Client findClient(Client client) {
		Connection connection = ConfigConnection.getInstance().getConnection();
		try {
			Statement st = connection.createStatement();
			String sql1 = "select * from client where identifiant ='" + client.getIdentifiant() + "' and password ='" + client.getPwd() + "'";
			ResultSet rs = st.executeQuery(sql1);
			// is used to move the cursor to the last row in result set object
			rs.last();
			if (rs.getRow() == 0)
				return null;
			else {
				Client c = new Client(rs.getString(2), rs.getString(3), rs.getString(4), Double.parseDouble(rs.getString(6)), rs.getString(5));
				return c;
			}
				
		} catch (SQLException e) {
			System.out.println("Erreur SQL " + e.getMessage());
		}
		return null;
	}
	public Client findId(Client client) {
		Connection connection = ConfigConnection.getInstance().getConnection();
		try {
			Statement st = connection.createStatement();
			String sql1 = "select * from client where identifiant ='" + client.getIdentifiant() + "'";
			ResultSet rs = st.executeQuery(sql1);
			// is used to move the cursor to the last row in result set object
			rs.last();
			if (rs.getRow() == 0)
				return null;
			else {
				Client c = new Client(rs.getString(2), rs.getString(3), rs.getString(4), Double.parseDouble(rs.getString(6)), rs.getString(5));
				return c;
			}
				
		} catch (SQLException e) {
			System.out.println("Erreur SQL " + e.getMessage());
		}
		return null;
	}
	public void retirer(Client client, double mt) {
		Connection connection = ConfigConnection.getInstance().getConnection();
		try {
			Statement st = connection.createStatement();
			String sql1 = "update client set solde =" + (client.getSolde()-mt) + " where identifiant = '" + client.getIdentifiant() + "'";
			st.executeUpdate(sql1);			
		} catch (SQLException e) {
			System.out.println("Erreur SQL " + e.getMessage());
		}
	}
	public void verser(Client client, double mt) {
		Connection connection = ConfigConnection.getInstance().getConnection();
		try {
			Statement st = connection.createStatement();
			String sql1 = "update client set solde =" + (client.getSolde()+mt) + " where identifiant = '" + client.getIdentifiant() + "'";
			st.executeUpdate(sql1);
		} catch (SQLException e) {
			System.out.println("Erreur SQL " + e.getMessage());
		}
	}
	public Boolean virement(Client client1, Client client2, double mt) {

		try {
			if(client1.comparer(mt)) {
				retirer(client1, mt);
				verser(client2, mt);
				return true;
			}
		} catch (Exception e) {
			System.out.println("Erreur SQL " + e.getMessage());
		}
		return false;
	}
	public Boolean addVirement(Virement virement) {
		Connection connection = ConfigConnection.getInstance().getConnection();
		try {
			PreparedStatement stmt;
			stmt = connection.prepareStatement("insert into virement(emetteur, recepteur, montant, date)Values('"+virement.getEmetteur()+"', '"+virement.getRecepteur()+"', '"+virement.getMontant()+"', '"+virement.getDateVirement()+"')");
			if(stmt.execute())
				return true;
		} catch (SQLException e) {
			System.out.println("Erreur SQL " + e.getMessage());
		}
		return false;
	}
	
	public Collection<Virement> getAllVirementRec(String identifiant) {
		Connection connection = ConfigConnection.getInstance().getConnection();

		try {
			PreparedStatement stmt;
			stmt = connection.prepareStatement("SELECT * FROM virement where recepteur = '" + identifiant + "'" );
			ResultSet result = stmt.executeQuery();
			Collection<Virement> virements = new ArrayList<Virement>();
			while (result.next()) {
				String emetteur = result.getString("emetteur");
				String recepteur = result.getString("recepteur");
				double montant = result.getDouble("montant");
				String date  = result.getString("date");
				Virement virement = new Virement(emetteur, recepteur, montant, date);
				virements.add(virement);
			}
			return virements;

		} catch (SQLException e) {
			System.out.println("Erreur SQL " + e.getMessage());
		}
		return null;
	}
	
	public Collection<Virement> getAllVirementEnv(String identifiant) {
		Connection connection = ConfigConnection.getInstance().getConnection();

		try {
			PreparedStatement stmt;
			stmt = connection.prepareStatement("SELECT * FROM virement where emetteur = '" + identifiant + "'" );
			ResultSet result = stmt.executeQuery();
			Collection<Virement> virements = new ArrayList<Virement>();
			while (result.next()) {
				String emetteur = result.getString("emetteur");
				String recepteur = result.getString("recepteur");
				double montant = result.getDouble("montant");
				String date  = result.getString("date");
				Virement virement = new Virement(emetteur, recepteur, montant, date);
				virements.add(virement);
			}
			return virements;

		} catch (SQLException e) {
			System.out.println("Erreur SQL " + e.getMessage());
		}
		return null;
	}
	
	public Boolean addMail(Mail mail) {
		Connection connection = ConfigConnection.getInstance().getConnection();
		try {
			PreparedStatement stmt;
			stmt = connection.prepareStatement("insert into email(nom, emetteur, msg, sujet, date)Values('"+mail.getNom() + "', '"+mail.getEmetteur()+"', '"+mail.getMsg()+"', '"+ mail.getSujet()+"', '"+mail.getDate()+"')");
			if(stmt.execute())
				return true;
		} catch (SQLException e) {
			System.out.println("Erreur SQL " + e.getMessage());
		}
		return false;
	}
	
	public Boolean addRendezVous(RendezVous r) {
		Connection connection = ConfigConnection.getInstance().getConnection();
		try {
			PreparedStatement stmt;
			stmt = connection.prepareStatement("insert into rendezvous(nom, prenom, date, dateReservation, service)Values('"+r.getNom()+"', '"+
			r.getPrenom()+"', STR_TO_DATE('"+ r.getDate() + "', '%Y-%m-%d %H:%i'), STR_TO_DATE('"+ r.getDateReservation() + "', '%Y-%m-%d %H:%i'), '"
			+ r.getService() + "')");
			if(stmt.execute())
				return true;
		} catch (SQLException e) {
			System.out.println("Erreur SQL " + e.getMessage());
		}
		return false;
	}
	
	public Boolean existDate(String service, String date) {
		Connection connection = ConfigConnection.getInstance().getConnection();
		try {
			Statement st = connection.createStatement();
			String sql1 = "select * from rendezvous where service ='" + service + "' and date = STR_TO_DATE('"+ date + "', '%Y-%m-%d %H:%i')";
			ResultSet rs = st.executeQuery(sql1);
			// is used to move the cursor to the last row in result set object
			rs.last();
			if (rs.getRow() == 0)
				return true;
			else {
				return false;
			}
				
		} catch (SQLException e) {
			System.out.println("Erreur SQL " + e.getMessage());
		}
		return false;
	}
	

}