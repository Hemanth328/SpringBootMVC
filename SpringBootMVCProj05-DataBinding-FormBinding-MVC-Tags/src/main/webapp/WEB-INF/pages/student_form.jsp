<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

   <h1 style="color:red;text-align:center">student registration page</h1>
    
    <!-- method='POST' is optional in spring mvc tags -->
   <form:form    modelAttribute="stud">
      <table align="center" bgcolor="cyan">
         <tr>
            <td>Student Number  </td>
            <td><form:input path="sid"/> </td>
         </tr>
         <tr>
            <td>Student Name  </td>
            <td><form:input path="sname"/>  </td>
         </tr>
         <tr>
            <td>Student Address  </td>
            <td><form:input path="sadd"/>  </td>
         </tr>
         <tr>
            <td>Student Avg  </td>
            <td><form:input path="avg"/>  </td>
         </tr>
         <tr>
            <td colspan="2"><input type="submit" value="Register"></td>
         </tr>
      </table>
   </form:form>
     
     <a href="./">Back</a>