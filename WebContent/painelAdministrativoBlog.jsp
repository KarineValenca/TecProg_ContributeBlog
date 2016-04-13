
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
        <title>Contribute Blog - Painel Administrativo Blog</title>
    </head>
    <style>
        body { padding-top:20px; }
        .panel-body .btn:not(.btn-block) { width:120px;margin-bottom:10px; }
    </style>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">
                                <span class="glyphicon glyphicon-bookmark"></span> Bem vindo ao, ${idBlog}</h3>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-xs-6 col-md-6">
                                    <a href="ServletPublication?acao=InstanciaPublicacao&idBlog=${idBlog}" class="btn btn-success btn-lg" role="button"><span class="glyphicon glyphicon-user"></span><h6><br/>Criar Publicacação</h6></a>
                                    <a href="ServletBlog?acao=Excluir&idBlog=${idBlog}" class="btn btn-warning btn-lg" role="button"><span class="glyphicon glyphicon-remove"></span> <h6><br/>Excluir Blog</h6></a>
                                </div>
                                <div class="col-xs-6 col-md-6">
                                    <a href="ServletBlog?acao=ListarPublicacoes&idBlog=${idBlog}" class="btn btn-primary btn-lg" role="button"><span class="glyphicon glyphicon-list-alt"></span> <h6><br/>Ver Publicacoes</h6></a>
                                    <a href="ServletSubmissao?acao=AprovarPublicacoes&idBlog=${idBlog}" class="btn btn-info btn-lg" role="button"><span class="glyphicon glyphicon-file"></span> <h6><br/>Aprovar Publicações Colaborativas</h6></a>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>