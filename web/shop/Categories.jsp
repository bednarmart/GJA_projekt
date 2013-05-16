<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %> 


<span id="left">
    <h3>Kategorie</h3>  
    <ul class="sidebar_list">
        <s:iterator value="categoriList" var="catCot" >
            <li><a href="<%= request.getContextPath()%>/shop/category?cat=${catCot.id}"> ${catCot.name}</a></li>

            <s:if test="%{#catCot.id == cat}">
                <ul class="sub_sidebar_list">  
                    <%-- vypis podkategorii--%>  
                    <s:iterator value="subCategoriList" var="subCatCot" >
                        <li><a href="<%= request.getContextPath()%>/shop/category?subcat=${subCatCot.id}">${subCatCot.name}</a></li>
                    </s:iterator>     
                </ul>
            </s:if>
        </s:iterator>
    </ul>
                   
</span>
                  