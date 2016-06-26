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
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Do</title>
</head>
<body>

	<div class="container">
		<fmt:setBundle basename="resources.messages" var="msg" />
		<div class="row">
			<div class="panel panel-default widget">
				<a href="?locale=pt_BR">Português</a>|<a href="?locale=en_US">English</a>
				<div class="panel-heading">
					<span class="glyphicon glyphicon-comment"></span>
					<h3 class="panel-title">
						<fmt:message key="comment.recent_comments" bundle="${msg}" />
					</h3>
				</div>
				<div class="panel-body">
					<ul class="list-group">
						<li class="list-group-item"><c:forEach var="comments"
								items="${comments}">
								<div class="row">
									<div class="col-xs-2 col-md-1">
										<img src="http://placehold.it/80"
											class="img-circle img-responsive" alt="" />
									</div>
									<div class="col-xs-10 col-md-11">
										<div></div>
										<div class="comment-text">${comments.commentContent}</div>
										<div class="action">
											<a
												href="ServletComment?action=DeleteComment&idComment=${comments.idComment}"
												class="btn btn-danger btn-xs"><span
												class="glyphicon glyphicon-trash"></span> </a>
										</div>
									</div>
								</div>
							</c:forEach></li>
					</ul>
					<a href="#" class="btn btn-primary btn-sm btn-block" role="button"><span
						class="glyphicon glyphicon-refresh"></span>
					<fmt:message key="button.button_more" bundle="${msg}" /></a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>