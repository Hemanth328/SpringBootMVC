
<%@ page isELIgnored="false"  %>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
 <h1 style="color:red;text-align:center"> Edit Employee </h1>
 
  <script language="JavaScript"  src="js/validations.js">
      </script>
      
<noscript>
    <h1 style="color:red;text-align:center">Please enable java script </h1>
</noscript>
      
 <form:form modelAttribute="emp"  onsubmit="return validation(this)">
 <%-- <p style="color:red;text-align:center">
      <form:errors  path="*"/>
   </p> --%>
   
   <table border="1" bgcolor="cyan"  align="center">
   <tr>
         <td> employee no ::  </td>
         <td> <form:input path="empno"  readonly="true"/>  </td> 
      </tr>
      
      <tr>
         <td> employee name ::  </td>
         <td> <form:input path="ename"/>  </td> <form:errors  path="ename"/> <span id="enameErr"></span>
      </tr>
      
       
      <tr>
         <td> employee desg ::  </td>
         <td> <form:input path="job"/> </td> <form:errors  path="job"/>  <span id="jobErr"></span>
      </tr>
      
      <tr>
         <td> employee salary ::  </td>
         <td> <form:input path="sal"/>  </td> <form:errors  path="sal"/> <span id="salErr"></span>
      </tr>
      
      <tr>
         <td colspan="2" align="center"><input type="submit" value="Edit Employee"/></td>
      </tr>
   </table>
      <form:hidden path="vflag"/>
 </form:form> 