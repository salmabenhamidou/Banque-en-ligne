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

import com.banque.classe.Client;
import com.banque.classe.Virement;
import com.banque.dao.GestionBd;
import com.mysql.cj.Session;
import com.sun.mail.iap.Response;

/**
 * Servlet implementation class TraiterVirement
 */
@WebServlet("/TraiterVirement")
public class TraiterVirement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TraiterVirement() {
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
		String identifiant = request.getParameter("identifiant");
		String montant = request.getParameter("solde");
		GestionBd bd = new GestionBd();
		Client client2 = new Client(identifiant);
		HttpSession session = request.getSession();
		Client client1 = (Client)session.getAttribute("client");
		if((client2 = bd.findId(client2)) != null && !(identifiant.equals(client1.getIdentifiant()))) {
			if(bd.virement(client1, client2, Double.parseDouble(montant))) {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
				LocalDateTime now = LocalDateTime.now(); 
				System.out.println(dtf.format(now));
				Virement virement = new Virement(client1.getIdentifiant(), client2.getIdentifiant(), Double.parseDouble(montant), dtf.format(now));
				bd.addVirement(virement);
			    client1 = bd.findId(client1);
			    session.setAttribute("client", client1);
			    System.out.println(client1.getSolde());
			    String msg = "Virement Effectue";
				session.setAttribute("msg", msg);
				//getServletContext().getRequestDispatcher("/vues/virement.jsp").forward(request, response);
				response.sendRedirect(request.getContextPath()+"/vues/virement.jsp");
			}else {
			String msg = "Erreur Montant";
			session.setAttribute("msg", msg);
			getServletContext().getRequestDispatcher("/vues/virement.jsp").forward(request, response);
			}
			}else {
			String msg = "Erreur Identifiant";
			session.setAttribute("msg", msg);
			getServletContext().getRequestDispatcher("/vues/virement.jsp").forward(request, response);
		}
	}

}
