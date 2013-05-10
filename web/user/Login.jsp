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
                <input id="username" type="text" placeholder="Login" autofocus required>   
                <input id="password" type="password" placeholder="Heslo" required>
            </fieldset>
            <fieldset id="actions">
                <input type="submit" id="submit" value="Přihlásit">
                <a href="<%= request.getContextPath()%>/user/showLostPassword.action">Zapomenuté heslo</a><a href="/user/showRegistration.action">Registrace</a>
            </fieldset>
            <s:actionerror /><s:fielderror />
        </form>
    </body>
</html>
