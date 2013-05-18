<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        <title>Prodej oblečení</title>
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/shop/css/shopping.css" />
        <script type="text/javascript" src="<%= request.getContextPath()%>/script/shop.js"></script>
    </head>
    
    <body onload="init('<%= request.getContextPath()%>');">
        <div id="page">
            <%-- Hlava --%>
            <div id="head">
                <span><h2>Vytvoření objednávky</h2></span>
         
                <span class="head_menu">
                    
                </span>
            </div>
            <s:actionerror/>
            
            <s:form action="createOrder" >    
              <s:label>Způsob platby: </s:label>     
              <s:select label="Způsob platby" 
                headerKey="-1" headerValue="---"
                list="paymentStringTypeList"
                name="payment" 
                theme="simple"/>
              <br>
              
              <s:label>Způsob dodání: </s:label>
              <s:select label="Způsob dodání" 
                headerKey="-1" headerValue="---"
                list="deliveryStringList"
                name="delivery" 
                theme="simple"/>
              <br>
              <br>
              <s:label>Adresa dodání:</s:label>
              <s:textfield name="order.deliveryCity" label="Město" value="" />
              <s:textfield name="order.deliveryStreet" label="Ulice" value="" />
              <s:textfield name="order.deliveryZip" label="P.S.Č." value="" />
              
              <s:submit value="Dokonči objednávku" align="center" />
            </s:form>
    
            
            
     <%-- Pata --%>
            <div id="footer">
                Autoři: Radim Reš, Vojtěch Škorvaga, Martin Bednář
            </div>
        </div>
        
        <%-- Formulář k mapování dodatečných parametrů příchozích z AJAXu --%>
        
        <form id="formRequest">
            <input type="hidden" name="state" value="">
        </form>
    </body>
</html>
