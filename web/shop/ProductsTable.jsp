<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="img" uri="/struts-images"%>



 <s:iterator value="productList" var="product">
    <div id="products_row">

    <span id="product">
        
          <div><s:property value="name"/></div>
                                    
                                    
                                    <div>
                                        <span>${product.price}</span>
                                        <span>
    <%--                                        <s:url action="/shop/addToCart.action" var="urlTag" >
                                                <s:param name="id">${product.id}</s:param>
                                            </s:url>
                                            <s:a href="%{urlTag}">Koupit</s:a>
    --%>                                       
     <%--                                    </span>
                                     </div>  --%>
      </span>
</div>  
     </div> 
</s:iterator> 
                                          