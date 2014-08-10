<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<xsl:stylesheet xmlns:xs="http://www.w3.org/2001/XMLSchema"
                xmlns:xsd="http://www.w3.org/2001/XMLSchema"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:taxii="http://taxii.mitre.org/messages/taxii_xml_binding-1.1"
                version="2.0"><!--Implementers: please note that overriding process-prolog or process-root is 
    the preferred method for meta-stylesheets to use where possible. The name or details of 
    this mode may change during 1Q 2007.-->


<!--PHASES-->


<!--PROLOG-->
   <xsl:output method="text"/>

   <!--KEYS-->


   <!--DEFAULT RULES-->


   <!--MODE: SCHEMATRON-FULL-PATH-->
   <!--This mode can be used to generate an ugly though full XPath for locators-->
   <xsl:template match="*" mode="schematron-get-full-path">
      <xsl:apply-templates select="parent::*" mode="schematron-get-full-path"/>
      <xsl:text>/</xsl:text>
      <xsl:choose>
         <xsl:when test="namespace-uri()=''">
            <xsl:value-of select="name()"/>
         </xsl:when>
         <xsl:otherwise>
            <xsl:text>*:</xsl:text>
            <xsl:value-of select="local-name()"/>
            <xsl:text>[namespace-uri()='</xsl:text>
            <xsl:value-of select="namespace-uri()"/>
            <xsl:text>']</xsl:text>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:variable name="preceding"
                    select="count(preceding-sibling::*[local-name()=local-name(current())                                   and namespace-uri() = namespace-uri(current())])"/>
      <xsl:text>[</xsl:text>
      <xsl:value-of select="1+ $preceding"/>
      <xsl:text>]</xsl:text>
   </xsl:template>
   <xsl:template match="@*" mode="schematron-get-full-path">
      <xsl:apply-templates select="parent::*" mode="schematron-get-full-path"/>
      <xsl:text>/</xsl:text>
      <xsl:choose>
         <xsl:when test="namespace-uri()=''">@sch:schema</xsl:when>
         <xsl:otherwise>
            <xsl:text>@*[local-name()='</xsl:text>
            <xsl:value-of select="local-name()"/>
            <xsl:text>' and namespace-uri()='</xsl:text>
            <xsl:value-of select="namespace-uri()"/>
            <xsl:text>']</xsl:text>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template>

   <!--MODE: SCHEMATRON-FULL-PATH-2-->
   <!--This mode can be used to generate prefixed XPath for humans-->
   <xsl:template match="node() | @*" mode="schematron-get-full-path-2">
      <xsl:for-each select="ancestor-or-self::*">
         <xsl:text>/</xsl:text>
         <xsl:value-of select="name(.)"/>
         <xsl:if test="preceding-sibling::*[name(.)=name(current())]">
            <xsl:text>[</xsl:text>
            <xsl:value-of select="count(preceding-sibling::*[name(.)=name(current())])+1"/>
            <xsl:text>]</xsl:text>
         </xsl:if>
      </xsl:for-each>
      <xsl:if test="not(self::*)">
         <xsl:text/>/@<xsl:value-of select="name(.)"/>
      </xsl:if>
   </xsl:template>

   <!--MODE: GENERATE-ID-FROM-PATH -->
   <xsl:template match="/" mode="generate-id-from-path"/>
   <xsl:template match="text()" mode="generate-id-from-path">
      <xsl:apply-templates select="parent::*" mode="generate-id-from-path"/>
      <xsl:value-of select="concat('.text-', 1+count(preceding-sibling::text()), '-')"/>
   </xsl:template>
   <xsl:template match="comment()" mode="generate-id-from-path">
      <xsl:apply-templates select="parent::*" mode="generate-id-from-path"/>
      <xsl:value-of select="concat('.comment-', 1+count(preceding-sibling::comment()), '-')"/>
   </xsl:template>
   <xsl:template match="processing-instruction()" mode="generate-id-from-path">
      <xsl:apply-templates select="parent::*" mode="generate-id-from-path"/>
      <xsl:value-of select="concat('.processing-instruction-', 1+count(preceding-sibling::processing-instruction()), '-')"/>
   </xsl:template>
   <xsl:template match="@*" mode="generate-id-from-path">
      <xsl:apply-templates select="parent::*" mode="generate-id-from-path"/>
      <xsl:value-of select="concat('.@', name())"/>
   </xsl:template>
   <xsl:template match="*" mode="generate-id-from-path" priority="-0.5">
      <xsl:apply-templates select="parent::*" mode="generate-id-from-path"/>
      <xsl:text>.</xsl:text>
      <xsl:choose>
         <xsl:when test="count(. | ../namespace::*) = count(../namespace::*)">
            <xsl:value-of select="concat('.namespace::-',1+count(namespace::*),'-')"/>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="concat('.',name(),'-',1+count(preceding-sibling::*[name()=name(current())]),'-')"/>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template>

   <!--MODE: GENERATE-ID-2 -->
   <xsl:template match="/" mode="generate-id-2">U</xsl:template>
   <xsl:template match="*" mode="generate-id-2" priority="2">
      <xsl:text>U</xsl:text>
      <xsl:number level="multiple" count="*"/>
   </xsl:template>
   <xsl:template match="node()" mode="generate-id-2">
      <xsl:text>U.</xsl:text>
      <xsl:number level="multiple" count="*"/>
      <xsl:text>n</xsl:text>
      <xsl:number count="node()"/>
   </xsl:template>
   <xsl:template match="@*" mode="generate-id-2">
      <xsl:text>U.</xsl:text>
      <xsl:number level="multiple" count="*"/>
      <xsl:text>_</xsl:text>
      <xsl:value-of select="string-length(local-name(.))"/>
      <xsl:text>_</xsl:text>
      <xsl:value-of select="translate(name(),':','.')"/>
   </xsl:template>
   <!--Strip characters-->
   <xsl:template match="text()" priority="-1"/>

   <!--SCHEMA METADATA-->
   <xsl:template match="/">
      <xsl:apply-templates select="/" mode="M1"/>
   </xsl:template>

   <!--SCHEMATRON PATTERNS-->


   <!--PATTERN Rules for TAXII Messages-->


	  <!--RULE -->
   <xsl:template match="/taxii:Status_Message[@status_type = 'INVALID_RESPONSE_PART']"
                 priority="108"
                 mode="M1">

		<!--ASSERT -->
      <xsl:choose>
         <xsl:when test="taxii:Status_Detail/taxii:Detail[@name='MAX_PART_NUMBER'] castable as xs:integer and xs:integer(taxii:Status_Detail/taxii:Detail[@name='MAX_PART_NUMBER']) &gt; 0"/>
         <xsl:otherwise>
            <xsl:message>A Status Message of type INVALID_RESPONSE_PART requires a MAX_PART_NUMBER Status Detail that is a positive integer. </xsl:message>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:apply-templates select="@*|*|comment()|processing-instruction()" mode="M1"/>
   </xsl:template>

	  <!--RULE -->
   <xsl:template match="/taxii:Status_Message[@status_type = 'PENDING']"
                 priority="107"
                 mode="M1">

		<!--ASSERT -->
      <xsl:choose>
         <xsl:when test="taxii:Status_Detail/taxii:Detail[@name='ESTIMATED_WAIT'] castable as xs:integer and xs:integer(taxii:Status_Detail/taxii:Detail[@name='ESTIMATED_WAIT']) &gt; 0"/>
         <xsl:otherwise>
            <xsl:message>A Status Message of type PENDING requires an ESTIMATED_WAIT Status Detail that is a positiveInteger. </xsl:message>
         </xsl:otherwise>
      </xsl:choose>

		    <!--ASSERT -->
      <xsl:choose>
         <xsl:when test="string-length(taxii:Status_Detail/taxii:Detail[@name='RESULT_ID']) &gt; 0"/>
         <xsl:otherwise>
            <xsl:message>A Status Message of type PENDING requires a RESULT_ID Status Detail that is a URI. </xsl:message>
         </xsl:otherwise>
      </xsl:choose>

		    <!--ASSERT -->
      <xsl:choose>
         <xsl:when test="taxii:Status_Detail/taxii:Detail[@name='WILL_PUSH'] castable as xs:boolean"/>
         <xsl:otherwise>
            <xsl:message>A Status Message of type PENDING requires a WILL_PUSH Status Detail that is a boolean. </xsl:message>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:apply-templates select="@*|*|comment()|processing-instruction()" mode="M1"/>
   </xsl:template>

	  <!--RULE -->
   <xsl:template match="/taxii:Status_Message[@status_type = 'RETRY']/taxii:Status_Detail/taxii:Detail[@name='ESTIMATED_WAIT']"
                 priority="106"
                 mode="M1">

		<!--ASSERT -->
      <xsl:choose>
         <xsl:when test=". castable as xs:integer and xs:integer(.) &gt; 0"/>
         <xsl:otherwise>
            <xsl:message>A Status Message of type RETRY has an optional ESTIMATED_WAIT Status Detail of type positiveInteger. </xsl:message>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:apply-templates select="@*|*|comment()|processing-instruction()" mode="M1"/>
   </xsl:template>

	  <!--RULE -->
   <xsl:template match="/taxii:Subscription_Management_Request[@action='UNSUBSCRIBE' or @action='PAUSE' or @action='RESUME']"
                 priority="105"
                 mode="M1">

		<!--ASSERT -->
      <xsl:choose>
         <xsl:when test="taxii:Subscription_ID"/>
         <xsl:otherwise>
            <xsl:message>Subscription_ID MUST be present in UNSUBSCRIBE, PAUSE, and RESUME actions. </xsl:message>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:apply-templates select="@*|*|comment()|processing-instruction()" mode="M1"/>
   </xsl:template>

	  <!--RULE -->
   <xsl:template match="/taxii:Subscription_Management_Request[@action='SUBSCRIBE']"
                 priority="104"
                 mode="M1">

		<!--ASSERT -->
      <xsl:choose>
         <xsl:when test="taxii:Subscription_Parameters"/>
         <xsl:otherwise>
            <xsl:message>Subscription Parameters MUST be present in SUBSCRIBE actions. </xsl:message>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:apply-templates select="@*|*|comment()|processing-instruction()" mode="M1"/>
   </xsl:template>

	  <!--RULE -->
   <xsl:template match="/taxii:Poll_Request[taxii:Exclusive_Begin_Timestamp and taxii:Inclusive_End_Timestamp]"
                 priority="103"
                 mode="M1">

		<!--ASSERT -->
      <xsl:choose>
         <xsl:when test="taxii:Inclusive_End_Timestamp &gt; taxii:Exclusive_Begin_Timestamp"/>
         <xsl:otherwise>
            <xsl:message>If both Exclusive_Begin_Timestamp and Inclusive_End_Timestamp are present in a Poll_Request, the Inclusive_End_Timestamp MUST be greater than Exclusive_Begin_Timestamp. </xsl:message>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:apply-templates select="@*|*|comment()|processing-instruction()" mode="M1"/>
   </xsl:template>

	  <!--RULE -->
   <xsl:template match="/taxii:Poll_Response" priority="102" mode="M1">

		<!--ASSERT -->
      <xsl:choose>
         <xsl:when test="if (@more = true()) then (string-length(@result_id) &gt; 0) else true()"/>
         <xsl:otherwise>
            <xsl:message>The @result_id attribute MUST be present if @more is true. </xsl:message>
         </xsl:otherwise>
      </xsl:choose>

		    <!--ASSERT -->
      <xsl:choose>
         <xsl:when test="if (taxii:Content_Block or taxii:Record_Count) then (xs:integer(taxii:Record_Count) &gt;= count(taxii:Content_Block)) else true()"/>
         <xsl:otherwise>
            <xsl:message>Record_Count MUST be greater than or equal to the number of Content Blocks. </xsl:message>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:apply-templates select="@*|*|comment()|processing-instruction()" mode="M1"/>
   </xsl:template>

	  <!--RULE -->
   <xsl:template match="/taxii:Inbox_Message" priority="101" mode="M1">

		<!--ASSERT -->
      <xsl:choose>
         <xsl:when test="if (taxii:Content_Block or taxii:Record_Count) then (xs:integer(taxii:Record_Count) &gt;= count(taxii:Content_Block)) else true()"/>
         <xsl:otherwise>
            <xsl:message>Record_Count MUST be greater than or equal to the number of Content Blocks. </xsl:message>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:apply-templates select="@*|*|comment()|processing-instruction()" mode="M1"/>
   </xsl:template>
   <xsl:template match="text()" priority="-1" mode="M1"/>
   <xsl:template match="@*|node()" priority="-2" mode="M1">
      <xsl:choose><!--Housekeeping: SAXON warns if attempting to find the attribute
                           of an attribute-->
         <xsl:when test="not(@*)">
            <xsl:apply-templates select="node()" mode="M1"/>
         </xsl:when>
         <xsl:otherwise>
            <xsl:apply-templates select="@*|node()" mode="M1"/>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template>
</xsl:stylesheet>
