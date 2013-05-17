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
                    <a href="<%= request.getContextPath()%>/shop/showCart.action">Košík</a>
                </span>
            </div>


        <%-- pokus o AJAX              
                    <div id="info"> 
                        <s:url id="ajax" value="/shop/ajax.action" />
                        <s:a theme="ajax" href="%{ajax}" loadingText="Načítám kategorie. Prosím, čekejte" executeScripts="true" errorText="Omlouváme se, kategorie nelze načíst." formId="formRequests" targets="category">test</s:a>
                    </div>
        --%>


            <%-- Tělo --%>
            <div id="body">
                <%-- Kategorie, podkategorie --%>
                <s:action name="loadCategory" namespace="/shop" executeResult="true" />
                <%-- Obsah nabídky --%>
                <span id="content">
                    <%-- AJAX: onload, onclick podkategorie --%>
                    <div id="breadcrumb">
                        Breadcrumb (UCMS)
                    </div>
    
                    <s:if test="%{#selectedProduct}>= 0">
                        <s:action name="productDetail" executeResult="true" />
                    </s:if>
                    <s:else>   
                        <s:action name="loadProductsTable" executeResult="true" />
                    </s:else>

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

