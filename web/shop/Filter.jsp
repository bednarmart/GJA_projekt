<%-- 
    Document   : Filter
    Created on : 17.5.2013, 16:41:46
    Author     : Martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<div id="breadcrumb">
    <s:form action="doFilter" method="POST" >     


<select name="sexFilter" id="doFilter_sexFilter">
    <option value="Pohlaví" <s:if test="#session.sexFilterId == 0"> selected="selected" </s:if> >Pohlaví </option>
    <option value="Pánské" <s:if test="#session.sexFilterId == 1"> selected="selected" </s:if> >Pánské </option>
    <option value="Dámské" <s:if test="#session.sexFilterId == 2"> selected="selected" </s:if> >Dámské </option>
</select>
<%--        
	<s:select label="Pohlaví" 
		headerKey="-1" headerValue="Pohlaví"
                list="sexList"
		name="sexFilter" 
                theme="simple"
                key="defaultValue"
                />
    --%>    
<%--        <s:select label="Značka" 
		headerKey="-1" headerValue="Značka"
                list="signList"
		name="signFilter" 
                theme="simple"/>
--%><select name="signFilter" id="doFilter_signFilter">
        <option value="Značka" <s:if test="#session.signFilterId == 0"> selected="selected" </s:if> > Značka </option>
        <s:iterator value="signList" var="signListItem">
            <option value="${signListItem}" <s:if test="#session.signFilterName == #signListItem"> selected="selected" </s:if> > ${signListItem} </option>
        </s:iterator>     
    </select>

        <input type="radio" name="werhauseFilter" value="1" <s:if test="#session.werhauseFilter == 1 || #session.werhauseFilter == null"> checked="checked" </s:if>> Všechny
        <input type="radio" name="werhauseFilter" value="2" <s:if test="#session.werhauseFilter == 2"> checked="checked" </s:if>> Pouze skladem
        
         <s:hidden name="cat" value="%{cat}"  />                 
         <s:hidden name="subcat" value="%{subcat}"  />                 
         <s:submit id="submit" value="Vyfiltruj" theme="simple" class="button"/>
    </s:form>            
</div>        
