<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Prodej oblečení</title>
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/shop/css/shopping.css" />
        <script type="text/javascript" src="<%= request.getContextPath()%>/script/shop.js"></script>
    </head>
    
    <body onload="init('<%= request.getContextPath()%>');">
        <div id="page">
            <%-- Hlava --%>
            <div id="head">
                <span><h2>Registrace</h2></span>
         
                <span class="head_menu">
                    
                </span>
            </div>
            <s:actionerror/>
            
            <s:form action="createUser" >
              <s:textfield name="user.name" label="Jméno" value="" />
              <s:textfield name="user.surname" label="Příjmení" value="" />
              <s:textfield name="user.login" label="Login" value="" />
              <s:password name="user.pass" type="password" label="Heslo" value=""  />
              <s:password name="pass2" type="password" label="Heslo znovu" value=""  />
              <s:submit value="Registrace" align="center" />
            </s:form>
    
     <%-- Pata --%>
            <div id="footer">
                Autoři: Radim Reš, Vojtěch Škorvaga, Martin Bednář
            </div>
        </div>
        
        <%-- Formulář k mapování dodatečných parametrů příchozích z AJAXu --%>
        
        <form id="formRequest">
            <input type="hidden" name="state" value="">
        </form>
    </body>
</html>


