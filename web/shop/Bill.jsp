<%-- 
    Document   : Bill
    Created on : 18.5.2013, 23:34:14
    Author     : Martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Faktura</title>
    </head>
    <body>
        <h1>Faktura</h1>
        
        <b>Zákazník:</b><br>
        ${session.user.name} ${session.user.surname}<br>
        ${session.lastOrder.deliveryCity}<br>
        ${session.lastOrder.deliveryStreet}<br>
        ${session.lastOrder.deliveryZip}<br>
 
        
        <table>
            <tr>
                <td>nic</td>
                <td></td>
            </tr>
            <tr>
                <td>nic</td>
                <td></td>
            </tr>    
        </table>
    </body>
</html>
