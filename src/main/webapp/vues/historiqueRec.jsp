<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="client" scope="session" type="com.banque.classe.Client" />
<%@page import="com.banque.classe.Virement"%>
<%@page import="java.util.Collection"%>
<%@page import="com.banque.dao.GestionBd"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Virement Reçu</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/smdBanque/css/style.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins&family=Roboto+Slab&display=swap" rel="stylesheet">
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
                    <li><a href="/smdBanque/vues/accueil.jsp">Accueil</a></li>
                    <li><a href="/smdBanque/vues/virement.jsp">Virement</a></li>
                    <li><div class="dropdown">
    					<button class="dropbtn"><p class="submenu">Historique</p>
      					<i class="fa fa-caret-down"></i>
    					</button>
    					<div class="dropdown-content">
      					<a href="#">Virement Recu</a>
      					<a href="/smdBanque/vues/historiqueEnv.jsp">Virement Envoye</a>
   					 </div>
  			</div></li>
                    <li><a href="/smdBanque/vues/contact.jsp">Contact</a></li>
                    <li><a href="/smdBanque/vues/rendezVous.jsp">Rendez Vous</a></li>
                    <li><a href="/smdBanque/TraiterDeconnexion">Deconnexion</a></li>
                </ul>
            </div>
        </div>
    <div class="tab">
	<div class="title">Virement Reçu</div>
	<table id="customers">
			<tr>
				<th>Emetteur</th>
				<th>Montant</th>
				<th id="date">Date</th>

			</tr>
			<%
				GestionBd bd = new GestionBd();
				Collection<Virement> virementsRec = bd.getAllVirementRec(client.getIdentifiant());
					for (Virement virement : virementsRec) {
			%>

			<tr>
				<td><%=virement.getEmetteur()%></td>
				<td><%=virement.getMontant()%></td>
				<td><%=virement.getDateVirement()%></td>
			</tr>
			<%
				}
			%>
		</table>
		</div>
    </div>
    </body>
</html>