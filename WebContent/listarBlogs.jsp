<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <link href="assets/css/listgroup.css" rel="stylesheet">
    <script src="assets/js/listgroup.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contribute Blog - Listar Blogs</title>
    </head>
    <body>
        <div class="container">
            <div class="row col-md-6 col-md-offset-2 custyle">
                <table class="table table-striped custab">
                    <thead>
                        <tr>
                            <th>Titulo</th>
                            <th>Categoria</th>
                            <th class="text-center"> <input name='Voltar' type='button' class="btn btn-success btn-sm" onclick='javascript:history.back();self.location.reload();' value='Voltar' > </th>
                        </tr>
                    </thead>
                    <tr>
                        <c:forEach var="blog" items="${listaBlog}">
                    <tr>
                    <td>${blog.titulo}</td>
                    <td>${blog.categoria}</td>
                    <td class="text-center">
                    <a class='btn btn-info btn-xs' href="ServletBlog?acao=ListarPublicacoesBlog&idBlog=${blog.idBlog}"> Ver</a>
                    <a href="ServletDenuncia?acao=InstanciaBlog&idBlog=${blog.idBlog}" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Denunciar</a>
                    <a class='btn btn-info btn-xs' href="ServletSubmissao?acao=CriaColaboracao&idBlog=${blog.idBlog}">Submeter Publicação</a>
                    </td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>