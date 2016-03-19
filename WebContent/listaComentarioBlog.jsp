<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Do </title>
</head>
<body>

   <div class="container">
    <div class="row">
        <div class="panel panel-default widget">
            <div class="panel-heading">
                <span class="glyphicon glyphicon-comment"></span>
                <h3 class="panel-title">
                    Comentários Recentes</h3>
            </div>
            <div class="panel-body">
                <ul class="list-group">
                    <li class="list-group-item">
                    <c:forEach var="comentarios" items="${comentarios}">
                        <div class="row">
                            <div class="col-xs-2 col-md-1">
                                <img src="http://placehold.it/80" class="img-circle img-responsive" alt="" /></div>
                            <div class="col-xs-10 col-md-11">
                                <div>
                                </div>
                                <div class="comment-text">
                                    ${comentarios.conteudoComentario}
                                </div>
                                <div class="action">
                                <a href="ServletComentario?acao=ExcluirComentario&idComentario=${comentarios.idComentario}" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-trash"></span> </a>
                                </div>
                            </div>
                        </div>
                         </c:forEach>
                    </li>
                </ul>
                <a href="#" class="btn btn-primary btn-sm btn-block" role="button"><span class="glyphicon glyphicon-refresh"></span> Mais</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>