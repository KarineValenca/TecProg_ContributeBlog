<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Insert title here</title>
   </head>
   <body>
      <div align="center">
         <P>Lista de Utilizadores</P>
         <table >
            <tr>
               <td>ID</td>
               <td>Nome</td>
            </tr>
            <c:forEach var="user" items="${listUsers}">
               <tr>
                  <td>${user.id}</td>
                  <td>${user.name}</td>
                  <td><a href="ServletUser?action=ListProfile&id=${user.id}">Editar</a></td>
                  <td><a href="ServletUser?action=DeleteUser&id=${user.id}">Excluir</a></td>
               </tr>
            </c:forEach>
         </table>
      </div>
      <a href="index.jsp">Voltar</a>
   </body>
</html>
