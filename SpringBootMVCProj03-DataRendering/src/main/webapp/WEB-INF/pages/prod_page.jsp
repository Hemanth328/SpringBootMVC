
<%@page  isELIgnored="false" %>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>

 <b>Model  data  is <b> <br>
    <c:if test="${!empty prodData}">
         product id ::  ${prodData.pid} <br>
         product name ::  ${prodData.pname} <br>
         product price ::  ${prodData.price} <br>
         product qty ::  ${prodData.qty} <br>
    </c:if>
    
    <br><br><br>
    
    
    <a href="./">Back</a>