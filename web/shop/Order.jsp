<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>


<jsp:include page="Header.jsp" />


 <div id="body">
                <div id="registBlackLine">
                </div>
                <div id="registration">
                <h2>Volba dodáni</h2>

            <s:actionerror/>
             <div class="vybiratka_odrazedlo">
                 
             </div>
            <s:form action="createOrder" cssClass="registrationForm">
                <div class="vybiratka">
                    <label cssClass="vybiratka">Způsob platby: <label>     
                    <s:select label="Způsob platby" 
                      headerKey="-1" headerValue="---"
                      list="paymentStringTypeList"
                      name="payment" 
                      theme="simple"
                      />
                    <br>

                    <label cssClass="vybiratka">Způsob dodání: <label>
                    <s:select label="Způsob dodání" 
                      headerKey="-1" headerValue="---"
                      list="deliveryStringList"
                      name="delivery" 
                      theme="simple"/>
                    <br>
                    <br>
                    <label cssClass="vybiratka">Adresa dodání:<label>
                </div>
              <s:textfield name="order.deliveryCity" label="Město" value="" />
              <s:textfield name="order.deliveryStreet" label="Ulice" value="" />
              <s:textfield name="order.deliveryZip" label="P.S.Č." value="" />
              
              <s:submit value="Dokonči objednávku" align="center" />
            </s:form>
                </div>
            
<jsp:include page="Footer.jsp" />