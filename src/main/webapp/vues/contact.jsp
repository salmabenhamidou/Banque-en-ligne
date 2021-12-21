<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact</title>
</head>
<body>
	<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/smdBanque/css/contact.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins&family=Roboto+Slab&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous"><link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <header>
            <h1>Contactez Nous</h1>
            <p></p>
        </header>
        <div class="content">
            <div class="content-form">
                <section>
                    <i class="fa fa-map-marker fa-2x" aria-hidden="true"></i>
                    <h2>adresse</h2>
                    <p>
                        Kenitra <br>
                        Centre Ville <br>
                        Mohamed Diouri N° 11
                    </p>
                </section>

                <section>
                    <i class="fa fa-phone fa-2x" aria-hidden="true"></i>
                    <h2>Tel</h2>
                    <p>+212 644617803</p>
                </section>

                <section>
                    <i class="fa fa-envelope fa-2x" aria-hidden="true"></i>
                    <h2>E-mail</h2>
                    <p>smdBanque2service@gmail.com</p>
                </section>
            </div>
        </div>

      <form method="post" action="/smdBanque/TraiterMail">
        <div class="form">
            <div class="right">
              <% 
				String msg = (String)session.getAttribute("erreur");
				if( msg == "Erreur Email"){
			  %>
    	<p style="color: red; font-weight: bold;">Email ou Mot de Passe Incorrect.</p>
    		  <%
    	      }
			  session.setAttribute("erreur", "");
    	      %>
              <div class="contact-form">
                  <input type="text" name="nom" required>
                  <span>Nom Complet</span>
              </div>
  
              <div class="contact-form">
                  <input type="email" name="email" required>
                  <span>E-mail</span>
              </div>
              <div class="contact-form">
                  <input type="password" name="password" required>
                  <span>Mot de Passe</span>
              </div>
              <div class="contact-form">
                  <textarea name="msg">
                    
                  </textarea>
                  <span> Ecrivez votre Message....</span>
              </div>
  
              <div class="contact-form" style="margin-bottom: 40px;">
                  <input type="submit" name="submit">
                  <a href="/smdBanque/vues/accueil.jsp">Page Accueil</a>
              </div>
              </div>
            </div>
    </form>
        <div class="media">
            <li><i class="fa fa-facebook-square fa-2x" aria-hidden="true"></i></li>
            <li><i class="fa fa-instagram fa-2x" aria-hidden="true"></i></li>
            <li><i class="fa fa-whatsapp fa-2x" aria-hidden="true"></i></li>
            <li><i class="fa fa-twitter-square fa-2x" aria-hidden="true"></i></li>
        </div>
        <div class="empty">

        </div>
    </div>    
</body>
</html>
</body>
</html>