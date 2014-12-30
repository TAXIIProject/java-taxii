<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<xsl:stylesheet xmlns:xs="http://www.w3.org/2001/XMLSchema"
                xmlns:xsd="http://www.w3.org/2001/XMLSchema"
                xmlns:saxon="http://saxon.sf.net/"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:schold="http://www.ascc.net/xml/schematron"
                xmlns:iso="http://purl.oclc.org/dsdl/schematron"
                xmlns:xhtml="http://www.w3.org/1999/xhtml"
                xmlns:taxii="http://taxii.mitre.org/messages/taxii_xml_binding-1"
                version="2.0"><!--Implementers: please note that overriding process-prolog or process-root is 
    the preferred method for meta-stylesheets to use where possible. -->
   <xsl:param name="archiveDirParameter"/>
   <xsl:param name="archiveNameParameter"/>
   <xsl:param name="fileNameParameter"/>
   <xsl:param name="fileDirParameter"/>
   <xsl:variable name="document-uri">
      <xsl:value-of select="document-uri(/)"/>
   </xsl:variable>

   <!--PHASES-->


   <!--PROLOG-->
   <xsl:output method="text"/>

   <!--XSD TYPES FOR XSLT2-->


   <!--KEYS AND FUNCTIONS-->


   <!--DEFAULT RULES-->


   <!--MODE: SCHEMATRON-SELECT-FULL-PATH-->
   <!--This mode can be used to generate an ugly though full XPath for locators-->
   <xsl:template match="*" mode="schematron-select-full-path">
      <xsl:apply-templates select="." mode="schematron-get-full-path"/>
   </xsl:template>

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
         <xsl:when test="namespace-uri()=''">@<xsl:value-of select="name()"/>
         </xsl:when>
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
   <!--MODE: SCHEMATRON-FULL-PATH-3-->
   <!--This mode can be used to generate prefixed XPath for humans 
	(Top-level element has index)-->
   <xsl:template match="node() | @*" mode="schematron-get-full-path-3">
      <xsl:for-each select="ancestor-or-self::*">
         <xsl:text>/</xsl:text>
         <xsl:value-of select="name(.)"/>
         <xsl:if test="parent::*">
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
      <xsl:value-of select="concat('.',name(),'-',1+count(preceding-sibling::*[name()=name(current())]),'-')"/>
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

   <!--SCHEMA SETUP-->
   <xsl:template match="/">
      <xsl:apply-templates select="/" mode="M1"/>
      <xsl:apply-templates select="/" mode="M2"/>
      <xsl:apply-templates select="/" mode="M3"/>
   </xsl:template>

   <!--SCHEMATRON PATTERNS-->


   <!--PATTERN Status Message Rules-->


	  <!--RULE -->
   <xsl:template match="/taxii:Status_Message[@status_type = 'RETRY']/taxii:Status_Detail"
                 priority="1003"
                 mode="M1">

		<!--ASSERT -->
      <xsl:choose>
         <xsl:when test=". castable as xs:dateTime"/>
         <xsl:otherwise>
            <xsl:message>
                            A Status Message of type RETRY should have a Status_Detail containing a timestamp.
                         (. castable as xs:dateTime)</xsl:message>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:apply-templates select="*" mode="M1"/>
   </xsl:template>

	  <!--RULE -->
   <xsl:template match="/taxii:Status_Message[@status_type = 'UNSUPPORTED_MESSAGE']/taxii:Status_Detail"
                 priority="1002"
                 mode="M1">

		<!--ASSERT -->
      <xsl:choose>
         <xsl:when test="every $token in tokenize(., ' ') satisfies $token castable as xs:anyURI"/>
         <xsl:otherwise>
            <xsl:message>
                            Status_Detail must contain a space-separated list of Message Binding IDs indicating supported message bindings.
                         (every $token in tokenize(., ' ') satisfies $token castable as xs:anyURI)</xsl:message>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:apply-templates select="*" mode="M1"/>
   </xsl:template>

	  <!--RULE -->
   <xsl:template match="/taxii:Status_Message[@status_type = 'UNSUPPORTED_CONTENT']/taxii:Status_Detail"
                 priority="1001"
                 mode="M1">

		<!--ASSERT -->
      <xsl:choose>
         <xsl:when test="every $token in tokenize(., ' ') satisfies $token castable as xs:anyURI"/>
         <xsl:otherwise>
            <xsl:message>
                            Status_Detail must contain a space-separated list of Content Binding IDs indicating supported content bindings.
                         (every $token in tokenize(., ' ') satisfies $token castable as xs:anyURI)</xsl:message>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:apply-templates select="*" mode="M1"/>
   </xsl:template>

	  <!--RULE -->
   <xsl:template match="/taxii:Status_Message[@status_type = 'UNSUPPORTED_PROTOCOL']/taxii:Status_Detail"
                 priority="1000"
                 mode="M1">

		<!--ASSERT -->
      <xsl:choose>
         <xsl:when test="every $token in tokenize(., ' ') satisfies $token castable as xs:anyURI"/>
         <xsl:otherwise>
            <xsl:message>
                            Status_Detail must contain a space-separated list of Protocol Binding IDs indicating supported protocol bindings.
                         (every $token in tokenize(., ' ') satisfies $token castable as xs:anyURI)</xsl:message>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:apply-templates select="*" mode="M1"/>
   </xsl:template>
   <xsl:template match="text()" priority="-1" mode="M1"/>
   <xsl:template match="@*|node()" priority="-2" mode="M1">
      <xsl:apply-templates select="*" mode="M1"/>
   </xsl:template>

   <!--PATTERN Content_Binding only present when @service_type=INBOX. XML Binding Spec section 3.3. -->


	  <!--RULE -->
   <xsl:template match="taxii:Service_Instance/taxii:Content_Binding"
                 priority="1000"
                 mode="M2">

		<!--ASSERT -->
      <xsl:choose>
         <xsl:when test="../@service_type='INBOX'"/>
         <xsl:otherwise>
            <xsl:message>If Content_Binding is present, @service_type SHOULD be "INBOX". (../@service_type='INBOX')</xsl:message>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:apply-templates select="*" mode="M2"/>
   </xsl:template>
   <xsl:template match="text()" priority="-1" mode="M2"/>
   <xsl:template match="@*|node()" priority="-2" mode="M2">
      <xsl:apply-templates select="*" mode="M2"/>
   </xsl:template>

   <!--PATTERN Subscription Management Request Rules-->


	  <!--RULE -->
   <xsl:template match="/taxii:Subscription_Management_Request[@action='UNSUBSCRIBE']"
                 priority="1002"
                 mode="M3">

		<!--ASSERT -->
      <xsl:choose>
         <xsl:when test="@subscription_id"/>
         <xsl:otherwise>
            <xsl:message>
                            @subscription_id MUST be present if the action is UNSUBSCRIBE.
                         (@subscription_id)</xsl:message>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:apply-templates select="*" mode="M3"/>
   </xsl:template>

	  <!--RULE -->
   <xsl:template match="/taxii:Subscription_Management_Request[not(@action='UNSUBSCRIBE')]"
                 priority="1001"
                 mode="M3">

		<!--ASSERT -->
      <xsl:choose>
         <xsl:when test="not(@subscription_id)"/>
         <xsl:otherwise>
            <xsl:message>
                            @subscription_id SHOULD not be present if the action is not UNSUBSCRIBE.
                         (not(@subscription_id))</xsl:message>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:apply-templates select="*" mode="M3"/>
   </xsl:template>

	  <!--RULE -->
   <xsl:template match="/taxii:Subscription_Management_Request[not(@action='SUBSCRIBE')]"
                 priority="1000"
                 mode="M3">

		<!--ASSERT -->
      <xsl:choose>
         <xsl:when test="not(Push_Parameters)"/>
         <xsl:otherwise>
            <xsl:message>
                            For values of @action other than SUBSCRIBE senders SHOULD NOT include Push_Parameters.
                         (not(Push_Parameters))</xsl:message>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:apply-templates select="*" mode="M3"/>
   </xsl:template>
   <xsl:template match="text()" priority="-1" mode="M3"/>
   <xsl:template match="@*|node()" priority="-2" mode="M3">
      <xsl:apply-templates select="*" mode="M3"/>
   </xsl:template>
</xsl:stylesheet>
