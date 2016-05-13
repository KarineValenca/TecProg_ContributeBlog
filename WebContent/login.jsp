<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
   %>
<!DOCTYPE HTML>
<html>
   <link href="assets/css/bootstrap.min.css" rel="stylesheet">
   <link href="assets/css/bootstrap.css" rel="stylesheet">
   <link href="assets/css/login.css" rel="stylesheet">
   <script src="assets/js/bootstrap.min.js"></script>
   <meta charset="utf-8" />
   <meta name="viewport" content="width=device-width, initial-scale=1" />
   <!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
   <head>
      <title>
         Contribute Blog - Entrar
      </title>
   </head>
   <body background="images/cinza.png" bgproperties="fixed">
      <div class="container">
         <div class="row">
            <div class="col-md-4 col-md-offset-4">
               <div class="panel panel-default">
                  <div class="panel-heading">
                     <h3 class="panel-title">Preencha para entrar</h3>
                  </div>
                  <div class="panel-body">
                     <form action="ServletAuthentication" method="post" accept-charset="UTF-8" role="form">
                        <fieldset>
                           <div class="form-group">
                              <input class="form-control" placeholder="E-mail" name="email" type="email" value="${user.email}"  required>
                           </div>
                           <div class="form-group">
                              <input placeholder="Senha" name="password" type="password" class="form-control" value="${user.password}"  title="Deve possuir cinco ou mais caracteres" required>
                           </div>
                           <div class="checkbox">
                              <label>
                              <input name="remember" type="checkbox" value="Remember Me"> Lembrar
                              </label>
                           </div>
                           <input class="btn btn-lg btn-success btn-block" type="submit" value="Login">
                        </fieldset>
                     </form>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </body>
</html>