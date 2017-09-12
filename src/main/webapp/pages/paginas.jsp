<%

String pagina = request.getParameter("page");
	
	switch(pagina){

		// DASHBOARD
		case "dashboard":
			%><%@ include file="dashboard.xhtml" %><%
			break;
			
			
		default:
			%><%@ include file="dashboard.xhtml" %><%	
	
	}
	
	
%>