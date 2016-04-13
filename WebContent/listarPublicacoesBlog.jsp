<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <link href="assets/css/listpublicblog.css" rel="stylesheet">
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/bootstrap.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Publicações do blog</title>
    </head>
    <body background="images/cinza.png" bgproperties="fixed">
        <div class="container">
            <div class="row">
                <div class="panel panel-default widget">
                    <div class="panel-heading">
                        <span class="glyphicon glyphicon-comment"></span>
                        <h3 class="panel-title">
                            Publicações
                        </h3>
                        <span style="float:right;">
                        <input name='Voltar' type='button' class="btn btn- btn-sm" onclick='javascript:history.back();self.location.reload();' value='Voltar' ></span><br/>
                    </div>
                    <c:forEach var="publicacao" items="${listaPublicacaoBlog}">
                        <div class="panel-body">
                            <ul class="list-group">
                                <li class="list-group-item">
                                    <div class="row">
                                        <div class="col-xs-10 col-md-11">
                                            <div>
                                                <a href="#">
                                                    <h4><label>Título: ${publicacao.titlePublication}</label></h4>
                                                </a>
                                            </div>
                                            <div class="comment-text">
                                                <h5><label>Categoria:</label> ${publicacao.categoriaPublicacao}<br/>
                                                    <label>Nota: </label> ${publicacao.nota}<br/>
                                                    <label>Descrição:</label><br/>${publicacao.conteudoPublicacao}<br/>
                                                </h5>
                                            </div>
                                            <div class="action">
                                                <a href="ServletPublicacao?acao=AvaliarPublicacao&idPublication=${publicacao.idPublication}&notaPublicacao=1" class="btn btn-success btn-xs" role="button"><span class="glyphicon glyphicon-ok"></span> Gostei</a>
                                                <a href="ServletPublicacao?acao=AvaliarPublicacao&idPublication=${publicacao.idPublication}&notaPublicacao=-1" class="btn btn-danger btn-xs" role="button"><span class="glyphicon glyphicon-minus"></span> Não Gostei</a>
                                                <a href="ServletComentario?acao=InstanciaPublicacao&idPublication=${publicacao.idPublication}" class="btn btn-success btn-xs" role="button"> Comentar</a>
                                                <a href="ServletPublicacao?acao=ListarComentarios&idPublication=${publicacao.idPublication}" class="btn btn-primary btn-xs" role="button"> Ver comentários</a>
                                                <a href="ServletDenuncia?acao=InstanciaPublicacao&idPublication=${publicacao.idPublication}" class="btn btn-danger btn-xs" role="button"> Denunciar Publicacao</a>

                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </body>
</html>