<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="client" scope="session" type="com.banque.classe.Client" />
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>SMDBanque</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/smdBanque/css/style.css">
        <style type="text/css">
.sign-up-form h1 {
  color: #ff7200;
  margin-bottom: 30px;
}
.input-box {
  border-radius: 20px;
  padding: 10px;
  margin: 10px 0;
  width: 90%;
  border: 1px solid #999;
  outline: none;
}
button {
  color: white;
  width: 98%;
  padding: 10px;
  border-radius: 20px;
  font-weight: bold;
  font-size: 15px;
  margin: 10px 0;
  border: none;
  outline: none;
  cursor: pointer;
}       	
        </style>
    </head>
    <body>
    	<% 
		String msg = "";
		msg = (String)session.getAttribute("msg");
		%>
        <div class="main">
        <div class="navbar">
            <div class="icon">
                <h2 class="logo">SMDBanque</h2>
            </div>
            <div class="menu">
                <ul>
                    <li><a href="/smdBanque/vues/accueil.jsp">Accueil</a></li>
                    <li><a href="#">Virement</a></li>
                    <li><div class="dropdown">
    					<button class="dropbtn"><p class="submenu">Historique</p>
      					<i class="fa fa-caret-down"></i>
    					</button>
    					<div class="dropdown-content">
      					<a href="/smdBanque/vues/historiqueRec.jsp">Virement Recu</a>
      					<a href="/smdBanque/vues/historiqueEnv.jsp">Virement Envoye</a>
   					 </div>
  					</div></li>
  					<li><a href="/smdBanque/vues/rendezVous.jsp">Rendez Vous</a></li>
                    <li><a href="/smdBanque/vues/contact.jsp">Contact</a></li>
                    <li><a href="/smdBanque/TraiterDeconnexion">Deconnexion</a></li>
                </ul>
            </div>
        </div>
        <div class="sign-up-form">
        <h1>Virement</h1>
        <%if( msg == "Erreur Identifiant"){
    	%>
    	<p style="color: red; font-weight: bold;">Identifiant incorrecte .</p>
    	<%
    	}else if(msg == "Erreur Montant"){
    	%>
    	<p style="color: red; font-weight: bold;">Solde Insuffisant .</p>
    	<%
    	}else if(msg == "Virement Effectue"){
    	%>
    	<p style="color: #00CD00; font-weight: bold;">Virement Effectuee .</p>
    	<%
    	}
        session.setAttribute("msg", "");
    	%>
    	
        <form action="/smdBanque/TraiterVirement" method="post">
            <input type="text" name="identifiant" class="input-box" placeholder="Entrez Identifiant" required autofocus>
            <input type="text" name="solde" class="input-box" placeholder="Entrez Montant" required>
            <button type="submit" class="signup-btn" >Valider</button>
        </form>
    </div>
    </div>
    </body>
</html>