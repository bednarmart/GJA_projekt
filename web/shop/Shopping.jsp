<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        <title>Prodej oblečení</title>
        <link rel="stylesheet" type="text/css" href="shop/css/shopping.css" />
    </head>

    <body>
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

        <%-- Tělo --%>
        <div id="body">
            <%-- Kategorie, podkategorie --%>
            <span id="left">
                <h3>Kategorie</h3>  
                   <ul class="sidebar_list">
                       
<%--    nejaky srandy na ukazku --%>
                    	<li><a href="#">Aenean varius nulla</a></li>
                        <ul class="sub_sidebar_list">
                        <li><a href="#">Cras mattis arcu</a></li>
                        <li><a href="#">Donec turpis ipsum</a></li>
                        <li><a href="#">Fusce sodales mattis</a></li>                            
                        </ul>
                        <li><a href="#">Maecenas et mauris</a></li>
                        <li><a href="#">Mauris nulla tortor</a></li>
                        <li><a href="#">Nulla odio ipsum</a></li>
                        <li><a href="#">Nunc ac viverra nibh</a></li>
                        <li><a href="#">Praesent id venenatis</a></li>
                        <li><a href="#">Quisque odio velit</a></li>
                        <li><a href="#">Suspendisse posuere</a></li>
                        <li><a href="#">Tempus lacus risus</a></li>
                        <li><a href="#">Ut tincidunt imperdiet</a></li>
                        <li><a href="#">Vestibulum eleifend</a></li>
                        <li><a href="#">Velit mi rutrum diam</a></li>
<%--   konec  nejaky srandy na ukazku --%>
                   </ul>
                   
            </span>

            <%-- Obsah nabídky --%>
            <span id="content">
                <div id="breadcrumb">
                    Breadcrumb (UCMS)
                </div>
<%-- Nejaky ukazkovy produkty --%>                    
     <div id="products_row">
                            <%-- produkt --%>
                            <span id="product"> 
                                <div>Název produktu${product.name}</div>
                                <div>Popis${product.description}</div>
                                <div>Obrázek${product.name}</div>
                                <div>
                                    <span>cena${product.price}</span>
                                    <span>
<%--                                        <s:url action="/shop/addToCart.action" var="urlTag" >
                                            <s:param name="id">${product.id}</s:param>
                                        </s:url>
                                        <s:a href="%{urlTag}">Koupit</s:a>
--%>                                       
                                    </span>
                                </div>
                            </span>
                            <%-- produkt --%>
                            <span id="product"> 
                                <div>Název produktu${product.name}</div>
                                <div>Popis${product.description}</div>
                                <div>Obrázek${product.name}</div>
                                <div>
                                    <span>cena${product.price}</span>
                                    <span>
<%--                                        <s:url action="/shop/addToCart.action" var="urlTag" >
                                            <s:param name="id">${product.id}</s:param>
                                        </s:url>
                                        <s:a href="%{urlTag}">Koupit</s:a>
--%>                                       
                                    </span>
                                </div>
                            </span>
                            <%-- produkt --%>
                            <span id="product"> 
                                <div>Název produktu${product.name}</div>
                                <div>Popis${product.description}</div>
                                <div>Obrázek${product.name}</div>
                                <div>
                                    <span>cena${product.price}</span>
                                    <span>
<%--                                        <s:url action="/shop/addToCart.action" var="urlTag" >
                                            <s:param name="id">${product.id}</s:param>
                                        </s:url>
                                        <s:a href="%{urlTag}">Koupit</s:a>
--%>                                       
                                    </span>
                                </div>
                            </span>                                    
     </div>           
    <div id="products_row">
                            <%-- produkt --%>
                            <span id="product"> 
                                <div>Název produktu${product.name}</div>
                                <div>Popis${product.description}</div>
                                <div>Obrázek${product.name}</div>
                                <div>
                                    <span>cena${product.price}</span>
                                    <span>
<%--                                        <s:url action="/shop/addToCart.action" var="urlTag" >
                                            <s:param name="id">${product.id}</s:param>
                                        </s:url>
                                        <s:a href="%{urlTag}">Koupit</s:a>
--%>                                       
                                    </span>
                                </div>
                            </span>
    </div>
<--% konec natvrdo vloženejch zbozi --%>                


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
                                        <s:url action="/shop/addToCart.action" var="urlTag" >
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
      </div>  
    </body>
</html>

