package com.banque.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banque.classe.Client;
import com.banque.classe.RendezVous;
import com.banque.dao.GestionBd;

/**
 * Servlet implementation class TraiterRendezVous
 */
@WebServlet("/TraiterRendezVous")
public class TraiterRendezVous extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TraiterRendezVous() {
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
		String service = request.getParameter("service");
		String d = request.getParameter("date");
		String time = request.getParameter("time");
		String date = d + " " + time;
		System.out.println(date);
		try {
			GestionBd bd = new GestionBd();
			HttpSession session = request.getSession();
			Client client = (Client)session.getAttribute("client"); 
			if(bd.existDate(service, date)) {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");  
				LocalDateTime now = LocalDateTime.now(); 
				String dateReservation = dtf.format(now);
				System.out.println(dateReservation);
				RendezVous r = new RendezVous(client.getNom(), client.getPrenom(), date, service, dateReservation);
				System.out.println(dateReservation);
				bd.addRendezVous(r);
				session.setAttribute("rendezvous", r);
				response.sendRedirect("RecuPdf");
			}else {
				String msg = "Erreur Reservation";
				session.setAttribute("msg", msg);
				getServletContext().getRequestDispatcher("/vues/rendezVous.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}
