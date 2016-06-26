<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
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
    <link href="assets/css/listpublicblog.css" rel="stylesheet">
    <script src="assets/js/bootstrap.min.js">
    </script>
    <script src="assets/js/bootstrap.js">
    </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.4/js/bootstrap.min.js">
    </script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.4/css/bootstrap.min.css" 
    	rel="stylesheet"/>
    <head>
    	<fmt:setBundle basename="resources.messages" var="msg"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
        	<fmt:message key="approveCollaboration.titlePage" bundle="${msg}"/>
        </title>
    </head>
    <body background="images/cinza.png" bgproperties="fixed">
        <div class="container">  	
            <div class="row">
                <div class="panel panel-default widget">
                    <div class="panel-heading">
                    <a href="?locale=pt_BR">Português</a>|<a href="?locale=en_US">English</a>
                   	<br><br>
                        <span class="glyphicon glyphicon-comment">
                        </span>
                        <h3 class="panel-title">
                            <fmt:message key="approveCollaboration.titlePublication" bundle="${msg}"/>
                        </h3>
                        <span style="float:right;">
                        	<input name='Voltar' type='button' 
                        	   	   class="btn btn- btn-sm" 
                        	  	   onclick='javascript:history.back();self.location.reload();' 
                        	       value='<fmt:message key="approveCollaboration.back" bundle="${msg}"/>' >
                       	</span>
                       	<br/>
                    </div>
                    <c:forEach var="publication" items="${listPublicationBlog}">
                        <div class="panel-body">
                            <ul class="list-group">
                                <li class="list-group-item">
                                    <div class="row">
                                        <div class="col-xs-10 col-md-11">
                                            <div>
                                                <a href="#">
                                                    <h4>
                                                    	<label>
                                                    		<fmt:message key="approveCollaboration.title" bundle="${msg}"/> 
                                                    		${publication.titlePublication}
                                                    	</label>
                                                    </h4>
                                                </a>
                                            </div>
                                            <div class="comment-text">
                                                <h5>
                                                    <label>
                                                    	ID:
                                                    </label> 
                                                    ${publication.idPublication}
                                                    <br/>
                                                    <label>
                                                    	<fmt:message key="approveCollaboration.category" bundle="${msg}"/>
                                                    </label> 
                                                    ${publication.categoryPublication}
                                                    <br/>
                                                    <label>
                                                    	<fmt:message key="approveCollaboration.description" bundle="${msg}"/>
                                                    </label>
                                                    <br/>
                                                    ${publication.contentPublication}
                                                    <br/>
                                                </h5>
                                            </div>
                                            <div class="action">
                                                <a href="ServletSubmission?action=AcceptPublication&idPublication=${publication.idPublication}" 
                                                		class="btn btn-success btn-xs" 
                                                		role="button">
                                                	<fmt:message key="approveCollaboration.approvePublication" bundle="${msg}"/>
                                                </a>
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