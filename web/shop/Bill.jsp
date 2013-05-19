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
        
        <div id="zakaznik">
        <b>Kupující</b><br>
            ${session.user.name} ${session.user.surname}<br>
            ${session.lastOrder.deliveryStreet}<br>
            ${session.lastOrder.deliveryCity}<br>
            ${session.lastOrder.deliveryZip}<br>
        </div>
        <div id="obchodnik">
            <b>Prodávající</b><br>
            ClothesShop<br>
            Božetěchova 2<br>
            Brno<br>
            Ico:nejaky ico<br>
            Dic:CZ-nejaky doco<br>
            Tel: Nevolejte nám<br>
            Fax: NIKDY<br>
            e-mail: obereme.vas@nakost.cz<br>
        </div>

        Způsob dodání: ${session.lastOrder.delivery.name}<br>            
        Způsob platby: ${session.lastOrder.paymentType.name}<br>
        
        Datum: ${session.lastOrder.date}<br>
        <div id="items">
        
        <table id="itemsTable" border="1">
            <tr style="background-color: black; color: white"><th>Produkt</th><th>Cena</th><th>Množství</th><th>Cena celkem</th>

                <%--              neco.getProduct().getName()   
                neco.getProduct().getPrice()
                neco.getCount();
                neco.getPrice() // cena celkem--%>
            <s:iterator value="#session.lastOrderItems" var="cartRow" >
                <tr><td>${cartRow.product.name}</td>
                    <td>${cartRow.price}</td>
                    <td>${cartRow.count}</td>
                    <td>${cartRow.price*cartRow.count}</td>
            </s:iterator>
            <tr/>
            <tr><th colspan="3">Celková cena za nákup</th><th>${billTotalPrice} Kč vc DPH</th></tr>
        </table>
        </div>
    </body>
</html>
