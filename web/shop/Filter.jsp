<%-- 
    Document   : Filter
    Created on : 17.5.2013, 16:41:46
    Author     : Martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<div id="breadcrumb">

    <s:form action="doFilter" method="POST" >     

	<s:select label="Pohlaví" 
		headerKey="-1" headerValue="Pohlaví"
                list="sexList"
		name="sexFilter" 
                theme="simple"/>
        
        <s:select label="Značka" 
		headerKey="-1" headerValue="Značka"
                list="signList"
		name="signFilter" 
                theme="simple"/>

        
         <s:submit id="submit" value="Vyfiltruj" theme="simple"/>
    </s:form>            
</div>        
