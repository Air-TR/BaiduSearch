<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table cellpadding="0" cellspacing="0" style="width:510px;color:black;font-size:12px;border:1px gray solid;">
	<c:forEach items="${strList}" var="str">
		<tr style="height:22px; text-align: left;" onmouseover="this.style.background='#BBB8B8';" 
								 onmouseout="this.style.background='#FFFFFF'">
			<td onmousedown="showClickText(this)" style="padding-left: 7px; font-size: 13px;">${str}</td>
		</tr>
	</c:forEach>
</table>
