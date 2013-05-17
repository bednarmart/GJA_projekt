<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 




<s:iterator value="productList" var="product">
  <div id="products_row">
    <span id="product">
       <div><s:property value="name"/></div>
          <div>
             
             <span>
                 <img src="<%= request.getContextPath()%>/shop/${image}" />
   <%--                                        <s:url action="/shop/addToCart.action" var="urlTag" >
                                                <s:param name="id">${product.id}</s:param>
                                            </s:url>
                                            <s:a href="%{urlTag}">Koupit</s:a>
    --%>                                       
     <%--                                    </span>
                                     </div>  --%>
           </span>
           <div>${product.price} Kč</div>
          </div>  
     </span>      
  </div> 
</s:iterator> 
                                          