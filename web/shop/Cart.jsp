<%-- 
    Document   : Cart
    Created on : 17.5.2013, 21:22:45
    Author     : Radim
cartProductCount[${cartRow.product.id}]
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 

<span id="productDetail">
    <s:if test="%{cart != null && cart.size}">
        <s:form action="updateInCart" method="POST" theme="simple" >
        <table border="1">
            <tr style="background-color: black; color: white"><th>Produkt</th><th>Cena</th><th>Množství</th><th>Cena celkem</th>

            <s:iterator value="cart" var="cartRow" >
                <tr><td>
                        <a href="<%= request.getContextPath()%>/shop/removeFromCart?cat=${catCot.id}&subcat=${subCatCot.id}&iProduct=${cartRow.product.id}">X </a>
                        <a href="<%= request.getContextPath()%>/shop/product?cat=${catCot.id}&subcat=${subCatCot.id}&iProduct=${cartRow.product.id}">${cartRow.product.name}</a></td>
                    <td>${cartRow.product.price}</td>
                    <td><input class="cart_product_count" name="cartRow.count" type="text" value="${cartRow.count}"><%--<s:submit value="Změnit"/>--%></td>
                    <td>${cartRow.price}</td>
            </s:iterator>
            <tr/>
            <tr><th colspan="3">Celková cena za nákup</th><th>${cartTotalPrice}</th></tr>
        </table>
        </s:form>
        <a href="<%= request.getContextPath()%>/shop/eraseCart?cat=${catCot.id}&subcat=${subCatCot.id}">Vymazat košík</a>
    </s:if>
    <s:else>
        <b>Košík je prázdný</b>
    </s:else>

</span>