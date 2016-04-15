<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <title>Contribute Blog - Criar Publicação</title>
    </head>
    <body body background="images/cinza.png" bgproperties="fixed">
        <div class="container">
            <div class="row centered-form">
                <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Nova Publicação</h3>
                        </div>
                        <div class="panel-body">
                            <form form method="post" action="ServletPublication?action=CreatePublication">
                                <div class="form-group">
                                    <input type="hidden" name="idBlog" id="iddonoblog" class="form-control input-sm" value="${idBlog}" placeholder="ID" required>
                                </div>
                                <div class="form-group">
                                    <label>Título</label>
                                    <input type="text" name="titlePublication" id="titlePublication" class="form-control input-sm" value="${publicacao.titlePublication}" placeholder="Combate a Lesões" required>
                                </div>
                                <div class="form-group">
                                    <label>Categoria</label>
                                    <input type="text" name="categoryPublication" id="categoryPublication" class="form-control input-sm" value="${publicacao.categoryPublication}" placeholder="Categoria" required>
                                </div>
                                <div class="form-group">
                                    <label>Conteúdo</label>
                                    <textarea class="form-control" maxlength="150" rows="3" name="contentPublication" id="categoria" value="${publicacao.contentPublication}" placeholder="Escreva o conteúdo aqui" required></textarea>
                                </div>
                                <input type="submit" value="Enviar" class="btn btn-info btn-sm">
                                <input type="reset" value="Limpar" class="btn btn-warning btn-sm">
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