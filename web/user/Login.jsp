<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        <title>Prodej oblečení</title>
        <link rel="stylesheet" type="text/css" href="css/login.css" />
    </head>

    <body>
        <s:form id="login" action="doLogin" method="POST" theme="simple" >
            <h1>Přihlášení</h1>
            <fieldset id="inputs">
                <input id="username" name="login" type="text" placeholder="Login" autofocus required>   
                <input id="password" name="pass" type="password" placeholder="Heslo" required>
            </fieldset>
            <fieldset id="actions">
                <s:submit id="submit" value="Přihlásit"/>
                <a href="<%= request.getContextPath()%>/user/showLostPassword.action">Zapomenuté heslo</a><a href="<%= request.getContextPath()%>/user/showRegistration.action">Registrace</a>
            </fieldset>
            <s:actionerror /><s:fielderror />
        </s:form>
    </body>
</html>

