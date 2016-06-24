<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <c:choose>
	<c:when test="${param.locale eq 'pt_BR'}">
		<fmt:setLocale value="pt_BR"/>
	</c:when>
	<c:otherwise>
		<fmt:setLocale value="en_US"/>
	</c:otherwise>
</c:choose>
<html>
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <link href="assets/css/listgroup.css" rel="stylesheet">
    <script src="assets/js/listgroup.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet"/>
    <fmt:setBundle basename="resources.messages" var="msg"/>
    <a href="?action=ListBlog&locale=pt_BR">Português</a>|<a href="?action=ListBlog&locale=en_US">English</a>
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
                            <th><fmt:message key="blog.blog_title" bundle="${msg}"/></th>
                            <th><fmt:message key="blog.blog_categorie" bundle="${msg}"/></th>
                            <th class="text-center"> <input name='Voltar' type='button' class="btn btn-success btn-sm" onclick='javascript:history.back();self.location.reload();' value='Voltar' > </th>
                        </tr>
                    </thead>
                    <tr>
                        <c:forEach var="blog" items="${listBlog}">
                    <tr>
                    <td>${blog.title}</td>
                    <td>${blog.categorie}</td>
                    <td class="text-center">
                    <a class='btn btn-info btn-xs' href="ServletBlog?action=ListPublicationsBlog&idBlog=${blog.idBlog}"><fmt:message key="button.button_view" bundle="${msg}"/></a>
                    <a href="ServletDenuncia?acao=InstanciaBlog&idBlog=${blog.idBlog}" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span><fmt:message key="button.button_denounce" bundle="${msg}"/></a>
                    <a class='btn btn-info btn-xs' href="ServletSubmissao?acao=CriaColaboracao&idBlog=${blog.idBlog}"><fmt:message key="button.button_submit_publication" bundle="${msg}"/></a>
                    </td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>