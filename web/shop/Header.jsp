<%@ page contentType="text/html; charset=UTF-8" %>

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


<%-- SMAZAT !!!!!!!!!!!!!!!!!!!!!!!!!!!! --%>
                <span class="head_menu">
                    <a href="<%= request.getContextPath()%>/shop/cardPaiment.action">Karta</a>
                    
                </span>
                
<%-- KONEC SMAZAT !!!!!!!!!!!!!!!!!!!!!!!!!!!! --%>                
                
            </div>
