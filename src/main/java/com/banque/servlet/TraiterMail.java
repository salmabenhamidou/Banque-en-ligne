package com.banque.servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banque.classe.Mail;
import com.banque.classe.SendMail;
import com.banque.dao.GestionBd;

/**
 * Servlet implementation class TraiterMail
 */
@WebServlet("/TraiterMail")
public class TraiterMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TraiterMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionBd db = new GestionBd();
		SendMail mail = new SendMail();
		String nom = request.getParameter("nom");
		String message = nom + " :\n" + request.getParameter("msg");
		String emetteur = request.getParameter("email");
		String password = request.getParameter("password");
		String sujet = "Contact Us";
		if(mail.send(sujet, message, emetteur, password, "centrecomptage.app@gmail.com")) {
			System.out.println("Message envoyé");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();
			Mail email = new Mail(nom, emetteur, message, sujet, dtf.format(now));
			db.addMail(email);
		}else {
			String msg = "Erreur Email";
			HttpSession session = request.getSession();
			session.setAttribute("erreur", msg);
			getServletContext().getRequestDispatcher("/vues/contact.jsp").forward(request, response);
		}
	}

}
