<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${param.locale eq 'pt_BR'}">
		<fmt:setLocale value="pt_BR" />
	</c:when>
	<c:otherwise>
		<fmt:setLocale value="en_US" />
	</c:otherwise>
</c:choose>

<html>
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<link href="assets/css/bootstrap.css" rel="stylesheet">
<link href="assets/css/user.css" rel="stylesheet">
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/bootstrap.js"></script>
<script src="assets/js/user.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.4/css/bootstrap.min.css"
	rel="stylesheet" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contribute Blog - Criar Comentário</title>
</head>
<body body background="images/cinza.png" bgproperties="fixed">
	<div class="container">
		<fmt:setBundle basename="resources.messages" var="msg" />
		<div class="row centered-form">
			<div
				class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<a href="?locale=pt_BR">Português</a> | <a href="?locale=en_US">English</a>
						<h3 class="panel-title">
							<fmt:message key="createComment.title" bundle="${msg}" />
						</h3>
					</div>
					<div class="panel-body">
						<form form method="post" action="ServletComment?action=Create">

							<div class="form-group">
								<input type="hidden" name="idPublication" id="idPublication"
									value="${idPublication}"> <input type="hidden"
									name="idUser" id="idUser" class="form-control input-sm"
									value="${user.id}" placeholder="ID" required>
							</div>

							<div class="form-group">
								<label><fmt:message key="createComment.label"
										bundle="${msg}" /></label>
								<textarea class="form-control" maxlength="150" rows="3"
									name="commentContent" id="content"
									value="${comment.commentContent}"
									placeholder="Escreva o conteúdo aqui" required></textarea>
							</div>
							<input type="submit" value="Enviar" class="btn btn-info btn-sm">
							<input type="reset" value="Limpar" class="btn btn-warning btn-sm">
							<a href="ServletBlog?action=ListBlogPublications&idBlog=9"
								class="btn btn-success btn-sm" role="button"><fmt:message
									key="button.button_back" bundle="${msg}" /></a>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>