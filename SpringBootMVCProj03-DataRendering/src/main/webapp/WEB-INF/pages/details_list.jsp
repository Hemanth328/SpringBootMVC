<%@page  isELIgnored="false" %>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>

<b>Model data(Array,collections)  is :: </b><br>
    favourite colors(arary)::
    <c:if test="${!empty  favColors}">
        <c:forEach var="color" items="${favColors}">
                ${color},
        </c:forEach>
    </c:if>
   <br> 
   Nicknames(List Collection)::
    <c:if test="${!empty  nickNames}">
        <c:forEach var="name" items="${nickNames}">
                ${name},
        </c:forEach>
    </c:if>
   <br> 
    PhoneNumber(Set Collection)::
    <c:if test="${!empty  phoneNumbers}">
        <c:forEach var="phone" items="${phoneNumbers}">
                ${phone},
        </c:forEach>
    </c:if>
    
       <br> 
    IdDetails(Map Collection -->gives only values by taking keys)::
    <c:if test="${!empty  idDetails}">
                ${idDetails.aadhar},
                ${idDetails.panNo},
                ${idDetails.voterId}<br>
    </c:if>
    <br>
    IdDetails(Map Collection (gives both keys and values))::
    <c:if test="${!empty  idDetails}">
            <c:forEach  var="id"  items="${idDetails}">
                  ${id.key}<----> ${id.value} <br>
            </c:forEach>
    </c:if>
    

    
    
    
    <br><br><br>
    
    
    <a href="./">Back</a>
     