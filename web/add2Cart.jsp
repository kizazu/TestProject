<html>
<body>
<%
	String id = request.getParameter("id"); // id - key
	Object value = session.getAttribute(id);//getKey(id)
     //   Product pro=(Product)session.getAttribute(id);
	//the first time the product is selected
	if(value==null){
		//put name-value pair into session object (see HttpSession)
		session.setAttribute(id,"1"); // put(key,value)
	}
	//the second/third... time the product is selected
	else{
		int count = Integer.parseInt(value.toString())+1;
		//put name-value pair into session object (see HttpSession)
		session.setAttribute(id,String.valueOf(count));
		
	}	
%>
<h1>Item with id=<%=id%> was added to the Shopping Cart</h1>
<h2><a href="showCart.jsp">Show Shopping Cart</h2>

</body>
</html>