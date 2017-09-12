<%

/* String url = request.getRequestURI(); 
String dados[] = url.split("/"); */

String pagina = request.getParameter("page");
		
	switch(pagina){
	
		case "dashboard":
			%><%@ include file="../pages/dashboard.xhtml" %><%
			break;
			
		case "clientes":
			%><%@ include file="../pages/clientes.xhtml" %><%
			break;
		
	
	}
	
%>