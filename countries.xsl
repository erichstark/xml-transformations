<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> 
 <xsl:strip-space elements="*" /> 
  <xsl:output method="text" omit-xml-declaration="yes" indent="no" />  
  <xsl:template match="/"> 
    <xsl:for-each select="/staty/stat" >
     	
    	<xsl:text>Nazov statu:</xsl:text>
    	<xsl:copy-of select="nazov" />
    	<xsl:text>&#10;rozloha statu:  </xsl:text>
    	<xsl:copy-of select="rozloha" />
             <xsl:text>&#10;pocet obyvatelov </xsl:text>	
    	<xsl:copy-of select="pocetObyvatelov" />
    	<xsl:text> &#10;</xsl:text>
    	<xsl:text> &#10;</xsl:text>
      </xsl:for-each >

     
</xsl:template> 
</xsl:stylesheet>

