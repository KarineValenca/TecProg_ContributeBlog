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
	<fmt:setBundle basename="resources.messages" var="msg"/>
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <link href="assets/css/listgroup.css" rel="stylesheet">
    <script src="assets/js/listgroup.js">
    </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.4/js/bootstrap.min.js">
    </script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.4/css/bootstrap.min.css" 
    	  rel="stylesheet"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
        	<fmt:message key="denounce.list" bundle="${msg}"/>
        </title>
    </head>
    <body>
        <div class="container">
            <div class="row col-md-6 col-md-offset-2 custyle">
                <a href="?locale=pt_BR">Português</a>|<a href="?locale=en_US">English</a>
                <table class="table table-striped custab">
                    <thead>
                    <tr>
                           <b><h2><td colspan="3">
                           	<fmt:message key="denounce.blog" bundle="${msg}"/>                           
                           </td></h2></b>
                    </tr>       
                        <tr>
                            <th>ID</th>
                            <th><fmt:message key="publication.content" bundle="${msg}"/></th>
                            <th class="text-center"> 
                            	<input name=' <fmt:message key="button.button_back" bundle="${msg}"/>' 
                            	type='button'
                            	class="btn btn-success btn-sm" 
                            	onclick='javascript:history.back();self.location.reload();' 
                            	value='<fmt:message key="button.button_back" bundle="${msg}"/>' > </th>
                        </tr>
                    </thead>
                    <tr>
                        <c:forEach var="denuncia" items="${listDenounceBlog}">
                    <tr>
                    <td>${denounce.idDenounce}</td>
                    <td>${denounce.contentDenounce}</td>
                    <td class="text-center">
                   <a class='btn btn-danger btn-xs' 
                   		href="ServletDenounce?action=DeleteDenounceBlog&idDenounce=${denounce.idDenounce}">
                   		<fmt:message key="button.button_delete_denounce" bundle="${msg}"/>' 
                   	</a>
                   <a class='btn btn-danger btn-xs' 
                   		href="ServletDenounce?action=DeleteBlogDenounce&idDenounce=${denuncia.idDenounce}">
                   		<fmt:message key="button.button_delete_blog" bundle="${msg}"/>' 
                   </a>
                   </td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <div class="container">
            <div class="row col-md-6 col-md-offset-2 custyle">
                <table class="table table-striped custab">
                    <thead>
                    <tr>
                           <b><h2></h2><td colspan="3">
                           		<fmt:message key="denounce.publication" bundle="${msg}"/>
							</td></h2></b>
                    </tr>       
                        <tr>
                            <th>ID</th>
                            <th><fmt:message key="publication.content" bundle="${msg}"/></th>
                            <th class="text-center"> 
                            	<input name='<fmt:message key="button.button_back" bundle="${msg}"/>' 
                            	type='button' class="btn btn-success btn-sm" 
                            	onclick='javascript:history.back();self.location.reload();' 
                            	value='<fmt:message key="button.button_back" bundle="${msg}"/>' > </th>
                        </tr>
                    </thead>
                    <tr>
                        <c:forEach var="denounce" items="${listDenouncePublication}">
                    <tr>
                    <td>${denounce.idDenounce}</td>
                    <td>${denounce.contentDenounce}</td>
                    <td class="text-center">
                    <a class='btn btn-danger btn-xs' 
                    href="ServletDenounce?action=DeleteDenouncePublication&idDenounce=${denounce.idDenounce}">
                    <fmt:message key="button.button_delete_denounce" bundle="${msg}"/>
                    </a>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>