<%

String url = request.getRequestURI(); 
String dados[] = url.split("/");


if(dados.length > 1){
	
	out.print(dados[2]);
	
	switch(dados[2]){
	
		case "index.jsp":
			out.print("pages/dashboard.xhtml");
			break;
			
		case "dashboard.xhtml":
			//out.print("pages/dashboard.xhtml");
			break;
			
		case "clientes":
			out.print("pages/clientes.xhtml");
			break;
		
	
	}
	
} else {
	
}

%>