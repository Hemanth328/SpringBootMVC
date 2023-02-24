<%@ page isELIgnored="false"  %>

<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>


<style media = "all">
   body {
      background-color: pink;
   }
   span {
      color: red;
   }
</style>

<script language="JavaScript"  src="js/validations.js"> 
</script>

 <h1 style="color:red;text-align:center"> Register Employee </h1>
 
 <form:form modelAttribute="emp" onsubmit="return validation(this)"  name="frm">
 
 <%--   <p style="color:red;text-align:center">
       <form:errors path="*" />
   </p> --%>
 
   <table border="1" bgcolor="lightblue"  align="center">
      <tr>
         <td> Employee Name ::  </td>
         <td> <form:input path="ename"/> </td> <form:errors  path="ename"/>  <span id="enameErr"> </span>
      </tr>
     
       
      <tr>
         <td> Employee Desg ::  </td>
         <td> <form:input path="job"/> </td> <form:errors  path="job"/> <span id="jobErr"> </span>
      </tr>
      
      <tr>
         <td> Employee Salary ::  </td>
         <td> <form:input path="sal"/> </td>  <form:errors  path="sal"/> <span id="salErr"> </span>
      </tr>
      
      <script language="JavaScript">
      
          function sendReqForStates(frm) {
        	  alert("1");
        	   frm.action ="statesurl" /* // request path for handler method */
        	   frm.submit(); /* // submits the request */
          }
      
      </script>
      
      
      
      <tr>
         <td> Select Country </td>
         <td> <form:select path="country"  onchange="sendReqForStates(this)" >
                   <form:options items="${countriesInfo}" />
              </form:select>
         </td>
      </tr>
      
      <tr>
         <td> Select State </td>
         <td> <form:select path="state">
                   <form:options items="${statesInfo}" />
              </form:select>
         </td>
      </tr>
      
      
      <tr>
         <td colspan="2" align="center"><input type="submit" value="register Employee"/> </td>
      </tr>
   </table>
   <form:hidden path="vflag"/>
 </form:form> 