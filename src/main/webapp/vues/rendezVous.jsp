<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.text.*"%>
<%@page import="java.util.*"%>
<%@page import="java.time.*"%>
<jsp:useBean id="client" scope="session" type="com.banque.classe.Client" />
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>SMDBanque</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/smdBanque/css/style.css">
        <style type="text/css">
        #date{
        	width: 93%;
        }
        .sign-up-form h1 {
  			color: #ff7200;
 			 margin-bottom: 30px;
		}
        </style>
<script type="text/javascript">
function googleTranslateElementInit() {
  new google.translate.TranslateElement({pageLanguage: 'fr'}, 'google_translate_element');
}
</script>
<script type="text/javascript" src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
    </head>
    <body>
        <div class="main">
        <div class="navbar">
            <div class="icon">
                <h2 class="logo">SMDBanque</h2>
            </div>
            <div class="menu">
                <ul>
                    <li><a href="#">Accueil</a></li>
                    <li><a href="/smdBanque/vues/virement.jsp">Virement</a></li>
                    <li><div class="dropdown">
    					<button class="dropbtn"><p class="submenu">Historique</p>
      					<i class="fa fa-caret-down"></i>
    					</button>
    					<div class="dropdown-content">
      					<a href="/smdBanque/vues/historiqueRec.jsp">Virement Recu</a>
      					<a href="/smdBanque/vues/historiqueEnv.jsp">Virement Envoye</a>
   					 </div>
  			</div></li>
                    <li><a href="/smdBanque/vues/contact.jsp">Contact</a></li>
                    <li><a href="/smdBanque/vues/rendezVous.jsp">Rendez Vous</a></li>
                    <li><a href="/smdBanque/TraiterDeconnexion">Deconnexion</a></li>
                </ul>
            </div>
        </div>
         <div class="sign-up-form">
        <h1>Rendez Vous</h1>
        <% 
		String msg = "";
		msg = (String)session.getAttribute("msg");
		if( msg == "Erreur Reservation"){
	    %>
	    	<p style="color: red; font-weight: bold;"> Date deja Reservee <br> Choisi une autre Date .</p>
	    <%
		}
		session.setAttribute("msg", "");
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		%>
        <form action="/smdBanque/TraiterRendezVous" method="post">
            <select class="input-box" name="service">
  				<option selected>Choisir Service</option>
				<option value="Demande Credit">Demande Credit</option>
				<option value="Demande Carte Guichet">Demande Carte Guichet</option>
				<option value="Reclamation de Perte">Reclamation de Perte</option>
				<option value="Debloquage du Compte">Debloquage du Compte</option>
				<option value="Création du Compte">Création du Compte</option>
			</select>
			<input type="time" class="input-box" id="date" name="time"
       min="09:00" max="15:00" required>
       		<small>Ouverte 09:00-15:00</small>
            <input type="date" class="input-box" id="date" name="date"
       min="<%= format.format(date) %>" required>
            <button type="submit" class="signup-btn">Valider</button>
        </form>
    </div>
    </div>
    </body>
</html>