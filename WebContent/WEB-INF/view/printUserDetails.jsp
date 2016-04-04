<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Email:<%= request.getAttribute("emailId") %><br>
Password:<%= request.getAttribute("password") %><br>
First Name:<%= request.getAttribute("firstName") %><br>
Last Name:<%= request.getAttribute("lastName") %><br>
Gender:<%= request.getAttribute("gender") %><br>
Phone Number:<%= request.getAttribute("phoneNumber") %><br>
Firm Name:<%= request.getAttribute("firmName") %><br>
Salary:<%= request.getAttribute("salary") %><br>

</body>
</html>