<%-- 
    Document   : cardPaiment
    Created on : 18.5.2013, 20:44:37
    Author     : Martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<s:action name="header" namespace="/shop" executeResult="true" />

            <div id="body">
                <div id="registBlackLine">
                </div>
                <div id="registration">
                <h2>Platba kartou</h2>
                <s:actionerror/>
                <s:form action="loadCardData" portletMode="true" cssClass="registrationForm">
                    <s:textfield name="creditCartDataName" label="Jméno" value="%{creditCartDataName}" />
                    <s:textfield name="creditCartDataSurname" label="Příjmení" value="%{creditCartDataSurname}" />
                    <s:textfield name="cartData" label="Číslo karty" value="" />
                    <s:textfield name="cartData" label="Platnost karty" value=""  />
                    <s:textfield name="cartData" label="Autorizační kód" value=""  />
                    <s:submit value="Zaplatit" align="center" />
                </s:form>
                
                <a href="<%= request.getContextPath()%>/shop/showCart.action">Zpět do košíku</a>
                </div>
            </div>


                
<s:action name="footer" namespace="/shop" executeResult="true" />


