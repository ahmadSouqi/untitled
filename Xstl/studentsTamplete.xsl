<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h1>Students List</h1>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="student">
        <p>
            <xsl:apply-templates select="rollNumber"/>
            <xsl:apply-templates select="first-name"/>
            <xsl:apply-templates select="last-name"/>
            <xsl:apply-templates select="mark"/>
        </p>
    </xsl:template>

    <xsl:template match="rollNumber">
        Roll Number: <span style="color:#00ff00">
          <xsl:value-of select="."/>
        </span>
        <br></br>
    </xsl:template>

    <xsl:template match="first-name">
        First Name: <span style="color:#00ff00">
            <xsl:value-of select="."/>
        </span><br></br>
    </xsl:template>

    <xsl:template match="last-name">
        Last Name: <span style="color:#00ff00">
            <xsl:value-of select="."/>
        </span><br></br>
    </xsl:template>

    <xsl:template match="mark">
        Mark: <span style="color:#00ff00">
            <xsl:value-of select="."/>
        </span><br></br>
    </xsl:template>

</xsl:stylesheet>