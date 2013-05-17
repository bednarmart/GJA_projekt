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
           <td> ${sign} </td>
       </tr>
       <tr>
           <td> Velikost: </td>
           <td> ${product.size} </td>
       </tr>
       <tr>
           <td> Barva: </td>
           <td> ${product.color} </td>
       </tr>
       <tr>
       <tr>
           <td> Určeno pro: </td>
           <td> ${productSex} </td>
       </tr>
       <tr>
           <td> Počet kusů skladem: </td>
           <td> ${product.count} </td>
       </tr>
       <tr>
           <td> Hodnocení: </td>
           <td> ${Evaluation} </td>
       </tr>
       <tr>
           <td> <br /><B>Cena: </B></td>
           <td> <br /><B>${product.price} </B> Kč</td>
       </tr>
       <tr>
           <td>  </td>
           <td>     
               <div id="addToCartButton">
                  <s:if test="%{bLogedIn}">
                    <s:form action="addToCart" method="POST">
                        <s:hidden name="iProduct" value="%{selectedProduct}"  />
                        <s:submit id="submit" value="Přidat do košíku"/>
                    </s:form>
                  </s:if>  
               </div>
           </td>
       </tr>       
       </table>

       <s:if test="%{bLogedIn}">
       <br /> Ohodnoťte produkt: 
       <table>
       <tr><td>Nelíbí</td><td>

                    <s:form action="evaluateProduct" method="POST">
                         <input type="radio" name="newEvaluation" value="1">
                         <input type="radio" name="newEvaluation" value="2">
                         <input type="radio" name="newEvaluation" value="3">
                         <input type="radio" name="newEvaluation" value="4">
                         <input type="radio" name="newEvaluation" value="5" checked="checked">
                         <s:hidden name="iProduct" value="%{selectedProduct}"  />
                         <s:submit id="submit" value="Ohodnotit produkt"/>
                    </s:form>
               </td><td>
               Líbí
           </td>         
       </tr>
    </table>
            </s:if>

    
    </div>
</span>
