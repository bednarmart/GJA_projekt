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
        
        <input type="radio" name="werhauseFilter" value="1" checked="checked"> Všechny
        <input type="radio" name="werhauseFilter" value="2"> Pouze skladem
                          
         <s:submit id="submit" value="Vyfiltruj" theme="simple"/>
    </s:form>            
</div>        
