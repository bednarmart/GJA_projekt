<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %> 


<span id="left">
    <h3>Kategorie</h3>  
    <ul class="sidebar_list">
        <s:iterator value="categoriList" var="catCot" >
            <li><a href="?cat=<s:property value="id" />"> <s:property value="name" /></a></li>

                     <s:if test="%{#catCot.id == cat}">
                         <ul class="sub_sidebar_list">  
                         <%-- vypis podkategorii--%>  
                         <s:iterator value="subCategoriList" var="subCatCot" >
                           <li><a href="?subcat=<s:property value="id" />"> <s:property value="name" /></a></li>
                        </s:iterator>     
        </s:iterator>
        <%-- 
                        </ul>   
                    </s:if>
                </s:iterator>
        --%>
                </ul>
                   
</span>
                  