<%

String url = request.getRequestURI(); 
String dados[] = url.split("/");


if(dados.length > 1){
		
	switch(dados[2]){
	
		case "index.jsp":
			%><%@ include file="../pages/dashboard.xhtml" %><%
			break;
			
		case "index.jsp?p=clientes":
			out.print("../pages/clientes.xhtml");
			break;
		
	
	}
	
}
%>