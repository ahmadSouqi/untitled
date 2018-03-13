<%--
  Created by IntelliJ IDEA.
  User: asouqi
  Date: 3/6/18
  Time: 12:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>User Page</title>
</head>
<body>
     <form action="formPage.jsp" method="post">
      <table>
          <tr>
              <td>
                  Name:<input type="text" name="name"/>
              </td>
          </tr>
          <tr>
              <td>
                  Address:<input type="text" name="txtAddress"/>
              </td>
          </tr>
          <tr>
              <td colspan="2">
                  <input type="submit" value="Submit"/>
              </td>
          </tr>
      </table>
     </form>
</body>
</html>
