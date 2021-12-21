package com.banque.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banque.classe.Client;
import com.banque.dao.GestionBd;

/**
 * Servlet implementation class TraiterAuth
 */
@WebServlet("/TraiterAuth")
public class TraiterAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TraiterAuth() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identifiant = request.getParameter("identifiant");
		String password = request.getParameter("password");
		GestionBd bd = new GestionBd();
		Client client = new Client(identifiant, password);
		if((client = bd.findClient(client)) != null) {
			HttpSession session = request.getSession();
			session.setAttribute("client", client);
			getServletContext().getRequestDispatcher("/vues/accueil.jsp").forward(request, response);
		}else {
			HttpSession session = request.getSession(true);
			String msgErreur = "Erreur";
			session.setAttribute("erreur", msgErreur);
			getServletContext().getRequestDispatcher("/vues/index.jsp").forward(request, response);
		}
	}

}
