<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE ht ml PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <link href="assets/css/utilizador.css" rel="stylesheet">
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/bootstrap.js"></script>
    <script src="assets/js/utilizador.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contribute Blog - Editar Cadatro</title>
    </head>
    <body>
        <body background="images/cinza.png" bgproperties="fixed">
            <div class="container">
                <div class="row centered-form">
                    <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Editar cadastro</h3>
                            </div>
                            <div class="panel-body">
                                <form role="form" method="post" action="ServletUtilizador?acao=Editar">
                                    <div class="row">
                                        <input type="hidden"  class="form-control input-sm" name="apelido" autofocus="autofocus" placeholder="Apelido"  value="${utilizador.apelido}">
                                        <input type="hidden"  class="form-control input-sm" name="id" autofocus="autofocus" placeholder="id" value="${utilizador.id}">
                                        <input type="hidden"  class="form-control input-sm" name="email" autofocus="autofocus" placeholder="Email"  value="${utilizador.email}">
                                        <div class="col-xs-6 col-sm-6 col-md-6">
                                            <label>Nome</label>
                                            <div class="form-group">
                                                <input type="text" name="nome" id="first_name" value="${utilizador.nome}" class="form-control input-sm" placeholder="Nome" required>
                                            </div>
                                        </div>
                                        <div class="col-xs-6 col-sm-6 col-md-6">
                                            <label>Sobrenome</label>
                                            <div class="form-group">
                                                <input type="text" name="sobrenome" id="last_name" class="form-control input-sm" value="${utilizador.sobrenome}" placeholder="Sobrenome" required>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-xs-6 col-sm-6 col-md-6">
                                            <label>Genero</label>
                                            <div class="form-group">
                                                <input type="text" name="genero" id="genero" value="${utilizador.genero}" class="form-control input-sm" placeholder="Masc. / Fem." required>
                                            </div>
                                        </div>
                                        <div class="col-xs-6 col-sm-6 col-md-6">
                                            <label>Data Nascimento</label>
                                            <div class="form-group">
                                                <input type="date" name="dataNascimento" class="form-control input-sm" value="${utilizador.dataNascimento}" placeholder="Data de Nascimento">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-xs-6 col-sm-6 col-md-6">
                                            <label>Senha</label>
                                            <div class="form-group">
                                                <input type="password" name="senha" id="password" class="form-control input-sm" value="${utilizador.senha}" placeholder="Senha" pattern=".{5,}" title="Deve possuir no mínimo cinco caracteres" required>
                                            </div>
                                        </div>
                                    </div>
                                    <input type="submit" value="Enviar" class="btn btn-info btn-sm">
                                    <input name='Voltar' type='button' class="btn btn-success btn-sm" onclick='javascript:history.back();self.location.reload();' value='Voltar' >
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
</html>