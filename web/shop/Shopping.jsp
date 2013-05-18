<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>

<s:action name="header" namespace="/shop" executeResult="true" />
                    


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

                    <s:action name="productFilter" namespace="/shop" executeResult="true" />
    
                    <s:if test="%{cartActive == 'true'}">
                        <s:action name="cartDetail" namespace="/shop" executeResult="true" />
                    </s:if>
                    <s:else>
                        <s:if test="%{iProduct}">
                            <s:action name="productDetail" executeResult="true" />
                        </s:if>
                        <s:else>   
                            <s:action name="loadProductsTable" namespace="/shop" executeResult="true" />
                        </s:else>
                    </s:else>

                </span>
            </div>

<s:action name="footer" namespace="/shop" executeResult="true" />

