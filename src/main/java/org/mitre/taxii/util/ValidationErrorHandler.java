/*
Copyright (c) 2012-2014, The MITRE Corporation
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
    * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer in the
      documentation and/or other materials provided with the distribution.
    * Neither the name of The MITRE Corporation nor the 
      names of its contributors may be used to endorse or promote products
      derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. 
 */
package org.mitre.taxii.util;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.ValidationEventLocator;
import javax.xml.transform.SourceLocator;

import net.sf.saxon.s9api.MessageListener;
import net.sf.saxon.s9api.XdmNode;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

/** 
 * An error handler that adds all warnings, errors, and fatalErrors to the
 * given Validation object. Implements the SAX ErrorHandler, JAXB
 * ValidationEventHandler, and Saxon MessageListener interfaces.
 */
public final class ValidationErrorHandler 
implements ErrorHandler, ValidationEventHandler, MessageListener {
    private final Validation results;
    private final boolean failFast;

    public ValidationErrorHandler(Validation results, boolean failFast) {
        this.results = results;
        this.failFast = failFast;
    }
    
    public static String formatEvent(ValidationEvent e) {
        StringBuilder sb = new StringBuilder();
        if (e.getLocator() != null) {
            appendLocator(sb, e.getLocator());
        }
        if (e.getMessage() != null) {
            sb.append(e.getMessage());
            if (e.getLinkedException() != null) {
                sb.append(" - ");
            }
        }
        if (e.getLinkedException() != null) {
            sb.append(e.getLinkedException().toString());
        }
        return sb.toString();
    }
    


    @Override
    public void warning(SAXParseException e) {
        results.addWarning(Validation.formatException(e));
    }
    
   
    @Override
    public void error(SAXParseException exception) throws SAXParseException  {
        results.addError(Validation.formatException(exception));
        if (failFast) {
            throw exception;
        }
    }
    

    @Override
    public void fatalError(SAXParseException exception) throws SAXParseException  {
        results.addFatalError(Validation.formatException(exception));
        if (failFast) {
            throw exception;
        }
    }

    
    private boolean warning(ValidationEvent e) {
        results.addWarning(formatEvent(e));
        return true;
    }

    private boolean error(ValidationEvent e) {
        results.addError(formatEvent(e));
        if (failFast) {
            return false;   // don't continue
        } else {
            return true;    // continue
        }
    }
    
    private boolean fatalError(ValidationEvent e) {
        results.addFatalError(formatEvent(e));
        if (failFast) {
            return false;   // don't continue
        } else {
            return true;    // continue
        }
    }
    
    
    /* (non-Javadoc)
     * @see javax.xml.bind.ValidationEventHandler#handleEvent(javax.xml.bind.ValidationEvent)
     */
    @Override
    public boolean handleEvent(ValidationEvent event) {
        switch(event.getSeverity()) {
        case ValidationEvent.WARNING:
            return warning(event);
        case ValidationEvent.ERROR:
            return error(event);
        case ValidationEvent.FATAL_ERROR:
            return fatalError(event);
        }
        
        throw new IllegalArgumentException("Unsupported ValidationEvent severity: " + event.getSeverity());
    }

    
    
    /**
     * Register the output from <code>xsl:message</code> as a validation error.
     * Useful when using XSLT for validation (for example, when the XSLT
     * is generated from Schematron).
     */
    @Override
    public void message(XdmNode content, boolean terminate, SourceLocator locator) {
        if (terminate) {
            // Assumes that the content of xsl:message is just a string. This
            // is true for XSLT generated from Schematron.
            results.addFatalError(content.getStringValue());
        }
        else {
            results.addError(content.getStringValue());
        }
        /*
         *  DEVNOTE: We don't short-circuit XSLT execution by throwing an 
         *  exception here, even if failFast is true.  The MessageListener
         *  interface is designed to simply be a callback listener; it does
         *  not have the same short-circuit semantics as the SAX ErrorHandler
         *  or JAXB ValidationEventHandler interfaces.  Thus, we don't 
         *  interrupt the XSLT execution because (1) the MessageListener
         *  interface wasn't designed to support it and (2) because we
         *  don't want to cause resource leaks.
         */
    }

    
    public Validation getResults() {
        return results;
    }
    
    
    private static void appendLocator(StringBuilder sb, ValidationEventLocator loc) {
        if (loc.getURL() == null 
                && loc.getLineNumber() < 0 
                && loc.getColumnNumber() < 0
                && loc.getOffset() < 0
                && loc.getNode() == null
                && loc.getObject() == null) {
            return;
        }
        sb.append("(");
        boolean first = true;
        if (loc.getURL() != null) {
            sb.append(loc.getURL().toExternalForm());
            first = false;
        }
        if (loc.getLineNumber() >= 0) {
            if (!first) {
                sb.append(", ");
            }
            sb.append("line ").append(loc.getLineNumber());
            first = false;
        }
        if (loc.getColumnNumber() >= 0) {
            if (!first) {
                sb.append(", ");
            }
            sb.append("column ").append(loc.getColumnNumber());
            first = false;
        }
        if (loc.getOffset() >= 0) {
            if (!first) {
                sb.append(", ");
            }
            sb.append("byte ").append(loc.getOffset());
            first = false;
        }
        if (loc.getObject() != null) {
            if (!first) {
                sb.append(", ");
            }
            sb.append("object ").append(loc.getObject().getClass().getName());
            first = false;
        }
        if (loc.getNode() != null) {
            if (!first) {
                sb.append(", ");
            }
            sb.append("node ").append(loc.getNode().getLocalName());
            first = false;
        }
        sb.append(") ");
    }

}