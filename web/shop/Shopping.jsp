<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        <title>Prodej oblečení</title>
    </head>

    <body>
        <%-- Hlava --%>
        <div id="head">
            <span><h2>Oblečení</h2></span>
            <span class="head_menu">
                <s:if test="#session.user.login == 'true'">
                    <a href="<%= request.getContextPath()%>/showProfile.action">${session.user.name}</a>
                </s:if>
                <s:else>
                    <s:url id="url" action="Login">
                        <a href="<%= request.getContextPath()%>/showLogin.action">Přihlásit</a>
                    </s:url>
                </s:else>
            </span>
            <span class="head_menu">
                <a href="<%= request.getContextPath()%>/showCart.action">Košík</a>
            </span>
        </div>

        <%-- Tělo --%>
        <div id="body">
            <%-- Kategorie, podkategorie --%>
            <span id="left">
            </span>

            <%-- Obsah nabídky --%>
            <span id="content">
                <div id="breadcrumb">
                    Breadcrumb (UCMS)
                </div>

                <%-- Produkty --%>
                <%-- cyklus nad listem produktů po 3 produktech na řádku --%>
                <s:iterator value="products" id="products_row">
                    <div id="products_row">
                        <s:iterator value="products_row" id="product">
                            <%-- produkt --%>
                            <span id="product"> 
                                <div>Název produktu${product.name}</div>
                                <div>Popis${product.description}</div>
                                <div>Obrázek${product.name}</div>
                                <div>
                                    <span>cena${product.price}</span>
                                    <span>
                                        <s:url action="addToCart.action" var="urlTag" >
                                            <s:param name="id">${product.id}</s:param>
                                        </s:url>
                                        <s:a href="%{urlTag}">Koupit</s:a>
                                       
                                    </span>
                                </div>
                            </span>
                        </s:iterator>
                    </div>
                </s:iterator>
            </span>
        </div>

        <%-- Pata --%>
        <div id="footer">
            Autoři: Radim Reš, Vojtěch Škorvaga, Martin Bednář
        </div>
    </body>
</html>

