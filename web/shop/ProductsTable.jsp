<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 




<s:iterator value="productInTableList" var="productInTable">

  <div id="products_row">
    <span id="product">
       <div><s:property value="product.name"/></div>
          <div>
             
             <span>
                 
                 <img src="<%= request.getContextPath()%>/shop/${productInTable.image}"
                      height="100" width="100" />
   <%--                                        <s:url action="/shop/addToCart.action" var="urlTag" >
                                                <s:param name="id">${product.id}</s:param>
                                            </s:url>
                                            <s:a href="%{urlTag}">Detail</s:a>
    --%>                                       
     <%--                                    </span>
                                     </div>  --%>
           </span>
           <div>${productInTable.product.price} Kč</div>
          </div>
             
            <a href="<%= request.getContextPath()%>/shop/product?cat=${catCot.id}&subcat=${subCatCot.id}&iProduct=${productInTable.product.id}">detail</a> 
          
               
           
               
     </span>      
  </div> 
</s:iterator> 
                                          