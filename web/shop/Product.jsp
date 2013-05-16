<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="img" uri="/struts-images"%>

<span id="Product">
    <table>
        <tr><td>
          <img:image src="%{image}" resize="true" height="25" refresh="false"/>
         </td></tr>
         <tr><td> 
           <text >name: </text> <s:property value="name"/>
         </td></tr>
     </table>
</span> 