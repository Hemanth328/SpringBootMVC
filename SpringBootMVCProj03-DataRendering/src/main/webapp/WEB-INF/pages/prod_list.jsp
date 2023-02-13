
<%@page  isELIgnored="false" import="java.util.*" %>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>

 <c:choose>
     <c:when test="${!empty prodList}">
        <table align="center" bgcolor="cyan" border="1">
            <tr>
              <th>PID </th> <th>PNAME </th> <th>PRICE </th> <th>QTY</th>
            </tr>
            <c:forEach var="prod"  items="${prodList}">
              <tr>
                 <td>${prod.pid} </td>
                 <td>${prod.pname} </td>
                 <td>${prod.price} </td>
                 <td>${prod.qty} </td>
              </tr>
            </c:forEach>
        </table>
     </c:when>
     <c:otherwise>
              <h1 style="color:red;text-align:center"> No Records found </h1>
     </c:otherwise>
 </c:choose>
      
      
       <br><br><br>
    
    
    <a href="./">Back</a>