<%-- 
    Document   : productDetail
    Created on : 16.5.2013, 16:49:24
    Author     : Martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="img" uri="/struts-images"%>
 
<span id="ProductDetail">

    <h3> ${product.name} </h3>
    <div id="detailImage">
        <img src="<%= request.getContextPath()%>/shop/${image}" />
        <%--<img:image src="C:\NetBeansWork\GJA_projekt\pic\dress\evening\alinePrincesOneShoulder.jpg" resize="true" height="25" refresh="false"/> --%>
    </div>
    <div id="detailProperties">
       <table>
       <tr>
           <td> Značka: </td>
           <td>  </td>
       </tr>
       <tr>
           <td> Velikost: </td>
           <td>  </td>
       </tr>
       <tr>
           <td> Barva: </td>
           <td>  </td>
       </tr>
       <tr>
           <td> Počet kusů skladem: </td>
           <td> ${product.count} </td>
       </tr>
       <tr>
           <td> <br /><B>Cena: </B></td>
           <td> <br /><B>${product.price} </B> Kč</td>
       </tr>
        <tr><td> 
        </td></tr>
    </table>
    
    <div id="addToCartButton">
        <s:form action="addToCart" method="POST">
             <s:hidden name="iProduct" value="%{selectedProduct}"  />
             <s:submit id="submit" value="Přidat do košíku"/>
        </s:form>
    </div>
    
    </div>
</span>
