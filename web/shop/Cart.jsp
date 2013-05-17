<%-- 
    Document   : Cart
    Created on : 17.5.2013, 21:22:45
    Author     : Radim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 

<table>
    <tr><th>Produkt</th><th>Cena</th><th>Množství</th><th>Cena celkem</th>
    <s:iterator value="cart" var="cartRow" >
        <tr><td>${cartRow.product.name}</td><td>${cartRow.product.price}</td><td>${cartRow.count}</td><td>${cartRow.price}</td>
    </s:iterator>
    <tr/>
    <tr><th colspan="3">Celková cena za nákup</th><th>${cartTotalPrice}</th></tr>
</table>