<%-- 
    Document   : SignManager
    Created on : May 8, 2013, 6:48:33 PM
    Author     : lacoret
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign manager</title>
    </head>
 
 
<h1>Sign Manager</h1>

 
<s:form action="add" method="post">
    <s:textfield name="sign.name" label="Name"/>
    <s:submit value="Add sign" align="center"/>
</s:form> 

<h2>Signs</h2>
<table>
<tr>
    <th>Name</th>
    <th>Delete</th>
</tr>

<s:iterator value="signList" var="contact">
    <tr>
        <td><s:property value="name"/></td>
        
        <td><a href="delete?id=<s:property value="id"/>">delete</a></td>
    </tr> 
</s:iterator>

</table>
</body>
</html>
