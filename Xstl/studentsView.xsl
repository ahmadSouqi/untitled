<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
           xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
 <body>
   <table border="1">
     <tr bgcolor="green">
      <th>Roll Number</th>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Mark</th>
      <th>Grad</th>
     </tr>

     <xsl:for-each select="class/student">
         <!-- <xsl:sort select="first-name"/> -->
         <!--<xsl:if test="mark > 90">-->
         <xsl:if test="first-name='' ">
             <xsl:message terminate="yes">First Name Empty.....</xsl:message>
         </xsl:if>
         <tr>
           <td><xsl:value-of select="@rollNumber"/></td>
           <td><xsl:value-of select="first-name"/></td>
           <td><xsl:value-of select="last-name"/></td>
           <td><xsl:value-of select="mark"/></td>
           <td>
               <xsl:choose>
                 <xsl:when test="mark >85">High</xsl:when>
                 <xsl:when test="mark >74">Good</xsl:when>
                 <xsl:otherwise>Low</xsl:otherwise>
               </xsl:choose>
           </td>
      </tr>
         <!-- </xsl:if> -->
     </xsl:for-each>
  </table>
 </body>
</html>
</xsl:template>
</xsl:stylesheet>
