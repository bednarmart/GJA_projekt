<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>

<jsp:include page="../shop/Header.jsp" />


           
                
            </div>

            <div id="body">
                <div id="registBlackLine">
                </div>
                <div id="registration">
                    <h2>Registrace</h2>
                    <s:actionerror/>
                    <s:form action="createUser" portletMode="true" cssClass="registrationForm">
                        <s:textfield name="user.name" label="Jméno" value="" />
                        <s:textfield name="user.surname" label="Příjmení" value="" />
                        <s:textfield name="user.login" label="Login" value="" />
                        <s:password name="user.pass" type="password" label="Heslo" value=""  />
                        <s:password name="pass2" type="password" label="Heslo znovu" value=""  />
                        <s:submit value="Registrace" align="center" />
                    </s:form>
                    <a href="<%= request.getContextPath()%>/user/showLogin.action">Zpět na login</a>
                </div>
            </div>

<jsp:include page="../shop/Footer.jsp" />