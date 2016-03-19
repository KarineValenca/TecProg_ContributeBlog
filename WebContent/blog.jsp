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
        <title>Contribute Blog - Criar Blog</title>
    </head>
    <body body background="images/cinza.png" bgproperties="fixed">
        <div class="container">
            <div class="row centered-form">
                <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Criar Blog</h3>
                        </div>
                        <div class="panel-body">
                            <form form method="post" action="ServletBlog?acao=Incluir">
                                <div class="form-group">
                                    <input type="hidden" name="idDonoBlog" id="iddonoblog" class="form-control input-sm" value="${utilizador.id}" placeholder="ID" required>
                                </div>
                                <div class="form-group">
                                    <label>Título</label>
                                    <input type="text" name="titulo" id="titulo" class="form-control input-sm" value="${blog.titulo}" placeholder="E ai corredor?!" required>
                                </div>
                                <div class="form-group">
                                    <label>Categoria</label>
                                    <input type="text" name="categoria" id="categoria" class="form-control input-sm" value="${blog.categoria}" placeholder="Esporte de corrida" required>
                                </div>
                                <input type="submit" value="Enviar" class="btn btn-info btn-sm">
                                <a href="ServletBlog?acao=Listar" class="btn btn-primary btn-sm" role="button">Listar todos Blogs</a>
                                <a href="index.jsp" class="btn btn-success btn-sm" role="button">Voltar</a>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div>
    </body>
</html>