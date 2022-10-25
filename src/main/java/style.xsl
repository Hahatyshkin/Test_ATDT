<?xml version="1.0" encoding="windows-1251"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >
    <xsl:output method="text" omit-xml-declaration="yes" indent="no"/>
    <xsl:template match="/">Name,Status,Day,Month,Year,Status,Day,Month,Year,Status,Day,Month,Year,Type,Composition,Price,Number
        <xsl:for-each select="//Employee">
            <xsl:value-of select="concat(@Name,',',Dateo/@Status,',',Dateo/Day,',',Dateo/Month,',',Dateo/Year,',',Dated/@Status,',',Dated/Day,',',Dates/Month,',',Dates/Year,',',Dates/@Status,',',Dates/Day,',',Dates/Month,',',Dates/Year,',',Type,',',Composition,',',Price,',',Number,'&#xA;')"/></xsl:for-each>
    </xsl:template>
</xsl:stylesheet>