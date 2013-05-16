<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %> 


<span id="left">
    <h3>Kategorie</h3>  
    <ul class="sidebar_list">
        <s:iterator value="categoriList" var="catCot" >
            <li><a href="?cat=<s:property value="id" />"> <s:property value="name" /></a></li>
            <s:if test="%{#catCot.id == cat}">
                <s:iterator value="subCategoriList" var="subCatCot" >
                     <li><a href="?subcat=<s:property value="id" />"> <s:property value="name" /></a></li>
                </s:iterator>     
            </s:if>
        </s:iterator>

        <%--    nejaky srandy na ukazku --%>
        <%-- 
                <li><a href="#">Aenean varius nulla</a></li>
                <ul class="sub_sidebar_list">
                <li><a href="#">Cras mattis arcu</a></li>
                <li><a href="#">Donec turpis ipsum</a></li>
                <li><a href="#">Fusce sodales mattis</a></li>                            
                </ul>
                <li><a href="#">Maecenas et mauris</a></li>
                <li><a href="#">Mauris nulla tortor</a></li>
                <li><a href="#">Nulla odio ipsum</a></li>
                <li><a href="#">Nunc ac viverra nibh</a></li>
        --%>
        <%--   konec  nejaky srandy na ukazku --%>
        </ul>
                   
</span>
                  