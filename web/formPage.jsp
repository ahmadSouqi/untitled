<%--
  Created by IntelliJ IDEA.
  User: asouqi
  Date: 3/6/18
  Time: 12:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Page</title>
</head> 
<body>
       ${param.name}<br>
       (Length: ${f:length(param.name)})
       <br><br>
       ${param.txtAddress}<br>
       (Length: ${f:length(param.txtAddress)})

</body>
</html>
