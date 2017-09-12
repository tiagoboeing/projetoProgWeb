<%

/* String url = request.getRequestURI(); 
String dados[] = url.split("/"); */

String pagina = request.getParameter("page");
		
	
	switch(pagina){

		// DASHBOARD
		case "dashboard":
			%><%@ include file="../pages/dashboard.xhtml" %><%
			break;
			
		// CLIENTES	
		case "clientes":
			%><%@ include file="../pages/clientes.xhtml" %><%
			break;
		
		default:
			%><%@ include file="../pages/dashboard.xhtml" %><%
				
	
	}
	
	
%>