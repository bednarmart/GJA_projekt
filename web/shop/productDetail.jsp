<%-- 
    Document   : productDetail
    Created on : 16.5.2013, 16:49:24
    Author     : Martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="img" uri="/struts-images"%>
 
<span id="ProductDetail">

    <h2> jmeno </h2>
       <table>
       <tr><td>
<%--         <img:image src="%{image}" resize="true" height="25" refresh="false"/> --%>
        </td></tr>
        <tr><td> 
          <text >name: </text> <s:property value="name"/>
        </td></tr>
    </table>
</span>
