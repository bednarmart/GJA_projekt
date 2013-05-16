<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="img" uri="/struts-images"%>

<span id="ProductSmall">

          <div><s:property value="product.name"/></div>
                                    
                                    <div><img:image src="%{image}" resize="true" height="25" refresh="false"/></div>
                                    <div>
                                        <span><s:property value="product.price"/></span>
                                        <span>
    <%--                                        <s:url action="/shop/addToCart.action" var="urlTag" >
                                                <s:param name="id">${product.id}</s:param>
                                            </s:url>
                                            <s:a href="%{urlTag}">Koupit</s:a>
    --%>                                       
                                        </span>
                                    </div>
                                </span>
</span> 