<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
  <html>
  <body>
  <h2>My Movie Collection</h2>
  <table border="1">
    <tr bgcolor="#9acd32">
      <th>Movie</th>
      <th>Producer</th>
    </tr>
    <xsl:for-each select="movies/movie">
    <tr>
      <td><xsl:value-of select="name"/></td>
      <td><xsl:value-of select="producer"/></td>
    </tr>
    </xsl:for-each>
  </table>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>
