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
                <span><h2>Oblečení</h2></span>
                <span class="head_menu">
                    <s:if test="#session.login == 'true'">
                        <a href="<%= request.getContextPath()%>/user/showProfile.action">${session.user.name}</a>
                        <a href="<%= request.getContextPath()%>/user/logout.action">Odhlásit</a>
                    </s:if>
                    <s:else>
                        <s:url id="url" action="Login">
                            <a href="<%= request.getContextPath()%>/user/showLogin.action">Přihlásit</a>
                        </s:url>
                    </s:else>
                </span>
                <span class="head_menu">
                    <a href="<%= request.getContextPath()%>/shop/showCart.action">Košík <s:if test="%{cartItemsCount > 0}">(${cartItemsCount})</s:if></a>
                </span>


           
                
            </div>


 <div id="body">
                <div id="registBlackLine">
                </div>
                <div id="registration">
                <h2>Volba dodáni</h2>

            <s:actionerror/>
            
            <s:form action="createOrder" cssClass="registrationForm">
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
                </div>
 </div>

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