<%-- 
    Document   : cardPaiment
    Created on : 18.5.2013, 20:44:37
    Author     : Martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<s:action name="header" namespace="/shop" executeResult="true" />

            <div id="body">
                <div id="registBlackLine">
                </div>
                <div id="registration">
                <h2>Děkujeme za Váš nákup</h2>
                    <a href="<%= request.getContextPath()%>/shop/index.action">Pokračovat</a>
                </div>
            </div>

<s:action name="footer" namespace="/shop" executeResult="true" />