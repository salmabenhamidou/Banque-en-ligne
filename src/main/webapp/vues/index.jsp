<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!-- Custom styles for this template -->
<link rel="stylesheet" href="/smdBanque/css/style.css">
<style type="text/css">
.sign-up-form h1 {
  color: #ff7200;
  margin-bottom: 30px;
}
</style>
</head>
<body background="../img/background.jpg">
	<% 
	String msg = "";
	msg = (String)session.getAttribute("erreur");
	%>
	<div class="sign-up-form">
        <img src="img/user.png">
        <h1>SMDBanque</h1>
    <%if( msg == "Erreur"){
    	%>
    	<p style="color: red; font-weight: bold;">Mot de Passe ou <br>Identifiant incorrecte .</p>
    	<%
    	}
    	session.setAttribute("erreur", "");
    	%>
        <form action="/smdBanque/TraiterAuth" method="post">
            <input type="text" name="identifiant" class="input-box" placeholder="Entrez Identifiant" required autofocus>
            <input type="password" name="password" class="input-box" placeholder="Entrez Password" required>
            <button type="submit" class="signup-btn">Se connecter</button>
        </form>
    </div>
</body>
</html>