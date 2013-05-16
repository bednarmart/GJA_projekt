<%-- 
    Document   : productDetail
    Created on : 16.5.2013, 16:49:24
    Author     : Martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="img" uri="/struts-images"%>
 
<span id="ProductDetail">

    <h3> ${product.name} </h3>
    <div>
        <img src="<%= request.getContextPath()%>/pic/dress/evening/alinePrincesOneShoulder.jpg" alt="Jak psát web">
        <%--<img:image src="C:\NetBeansWork\GJA_projekt\pic\dress\evening\alinePrincesOneShoulder.jpg" resize="true" height="25" refresh="false"/> --%>
    </div>
       <table>
       <tr><td>
<%--         <img:image src="%{image}" resize="true" height="25" refresh="false"/> --%>
        </td></tr>
        <tr><td> 
          <text >name: </text> <s:property value="name"/>
        </td></tr>
    </table>
</span>
