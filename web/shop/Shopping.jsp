<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        <title>Prodej oblečení</title>
        <link rel="stylesheet" type="text/css" href="shop/css/shopping.css" />
        <script type="text/javascript" src="<%= request.getContextPath()%>/script/shop.js"></script>
    </head>

    <body onload="init('<%= request.getContextPath()%>');">
        <div id="page">
            <%-- Hlava --%>
            <div id="head">
                <span><h2>Oblečení</h2></span>
                <span class="head_menu">
                    <s:if test="#session.user.login == 'true'">
                        <a href="<%= request.getContextPath()%>/user/showProfile.action">${session.user.name}</a>
                    </s:if>
                    <s:else>
                        <s:url id="url" action="Login">
                            <a href="<%= request.getContextPath()%>/user/showLogin.action">Přihlásit</a>
                        </s:url>
                    </s:else>
                </span>
                <span class="head_menu">
                    <a href="<%= request.getContextPath()%>/shop/showCart.action">Košík</a>
                </span>
            </div>


            <%--    
            <div id="info"> 
                <s:url id="ajax" value="/ajax.action" />
                <s:a theme="ajax" href="%{ajax}" loadingText="Načítám kategorie. Prosím, čekejte" executeScripts="true" errorText="Omlouváme se, kategorie nelze načíst." formId="formRequests" targets="category">test</s:a>
            </div>--%>

            <%-- Tělo --%>
            <div id="body">
                <%-- Kategorie, podkategorie --%>


<%--                <div id="category"> --%>
                    <%-- AJAX: onload, onclick kategorie --%>
<%--                </div> --%>

    <s:action name="loadCategory" executeResult="true" />

                <%-- Obsah nabídky --%>
                <span id="content">
                    <%-- AJAX: onload, onclick podkategorie --%>
                    <div id="breadcrumb">
                        Breadcrumb (UCMS)
                    </div>
    
        <s:action name="loadProductTable" executeResult="true"  />

                </span>
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

