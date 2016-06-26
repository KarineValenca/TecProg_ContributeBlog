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
<link href="assets/css/comment.css" rel="stylesheet">
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
<title>Comentários</title>
</head>
<body>
	<div class="container">
		<fmt:setBundle basename="resources.messages" var="msg" />
		<div class="row">
			<a href="?locale=pt_BR">Português</a>|<a href="?locale=en_US">English</a>
			<div class="panel panel-default widget">
				<div class="panel-heading">
					<span class="glyphicon glyphicon-comment"></span>
					<h3 class="panel-title">
						<fmt:message key="listCommentsPublication.recent_comments"
							bundle="${msg}" />
					</h3>
				</div>
				<div class="panel-body">
					<ul class="list-group">
						<li class="list-group-item"><c:forEach var="comentario"
								items="${listCommentsPublication}">
								<div class="row">
									<div class="col-xs-2 col-md-1">
										<img src="http://placehold.it/80"
											class="img-circle img-responsive" alt="" />
									</div>
									<div class="col-xs-10 col-md-11">
										<div>
											<div class="mic-info">
												Por: <a href="#">${comment.userComment}</a> | Em:
												${comment.commentDate}
											</div>
										</div>
										<div class="comment-text">
											${comment.commentContent}<br />
										</div>
										<div class="action">
											<c:if test="${user.nickname == comment.userComment}">
												<a
													href="ServletComment?action=DeleteComment&idComment=${comment.idComment}"
													class="btn btn-danger btn-xs"><fmt:message
														key="button.button_delete_comment" bundle="${msg}" /></a>
											</c:if>
										</div>
									</div>
								</div></li>
					</ul>
					</c:forEach>
					<a href="#" class="btn btn-primary btn-sm btn-block" role="button"><span
						class="glyphicon glyphicon-refresh"></span>
					<fmt:message key="listCommentsPublication.more_comments"
							bundle="${msg}" /></a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
