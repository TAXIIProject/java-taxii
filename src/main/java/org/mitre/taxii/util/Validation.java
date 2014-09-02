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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xml.sax.SAXParseException;

/**
 * Validation results that keeps track of all warnings, errors, and fatal
 * errors as strings. Inspired by SAX's ErrorHandler interface.
 *
 * @author Jonathan W. Cranford
 */
public final class Validation {

    /*
     * DESIGN NOTE: We use a List here to keeps the warnings, errors, and fatal
     * errors in same order in which they are added.
     */
    private final List<String> warnings = new ArrayList<String>();
    private final List<String> errors = new ArrayList<String>();
    private final List<String> fatalErrors = new ArrayList<String>();

    /* ======================
     * factory methods
     */

    /**
     * Convenience factory method that returns a successful validation result.
     */
    public static Validation success() {
        return new Validation();
    }

    /** Convenience factory method that returns a warning validation result. */
    public static Validation warning(String warning) {
        return new Validation().addWarning(warning);
    }

    /** Convenience factory method that returns an error validation result. */
    public static Validation error(String error) {
        return new Validation().addError(error);
    }

    /** Convenience factory method that returns a fatalError validation result. */
    public static Validation fatalError(String msg) {
        return new Validation().addFatalError(msg);
    }


    /* ===============
     * accessors
     */

    /** Validation is successful if there are no warnings, errors, or
     * fatalErrors.*/
    public boolean isSuccess() {
        return (errors.isEmpty()
                && fatalErrors.isEmpty());
    }

    public boolean isFailure() {
        return ! isSuccess();
    }

    public boolean hasWarnings() {
        return ! warnings.isEmpty();
    }

    public boolean hasErrors() {
        return ! errors.isEmpty();
    }

    public boolean hasFatalErrors() {
        return ! fatalErrors.isEmpty();
    }


    /**
     * Returns a read-only list of warnings.
     */
    public List<String> getWarnings() {
       return Collections.unmodifiableList(warnings);
    }


    /**
     * Returns a read-only list of errors.
     */
    public List<String> getErrors() {
        return Collections.unmodifiableList(errors);
    }


    /**
     * Returns a read-only list of fatal errors.
     */
    public List<String> getFatalErrors() {
        return Collections.unmodifiableList(fatalErrors);
    }


    public StringBuilder appendAllErrors(StringBuilder sb) {
        Iterators.appendWithLabel("FATAL ERRORS", sb, fatalErrors.iterator(), Iterators.EOL);
        return Iterators.appendWithLabel("ERRORS", sb, errors.iterator(), Iterators.EOL);
    }

    public StringBuilder appendAllErrorsAndWarnings(StringBuilder sb) {
        appendAllErrors(sb);
        return appendAllWarnings(sb);
    }

    public StringBuilder appendAllWarnings(StringBuilder sb) {
        return Iterators.appendWithLabel("WARNINGS", sb, warnings.iterator(), Iterators.EOL);
    }
    

    public String getAllErrorsAndWarnings() {
        return appendAllErrorsAndWarnings(new StringBuilder()).toString();
    }

    public String getAllErrors() {
        return appendAllErrors(new StringBuilder()).toString();
    }

    public String getAllWarnings() {
        return appendAllWarnings(new StringBuilder()).toString();
    }

    public Validation addWarning(String warning) {
        warnings.add(warning);
        return this;
    }

    public Validation addError(String error) {
        errors.add(error);
        return this;
    }

    public Validation addFatalError(String fatalError) {
        fatalErrors.add(fatalError);
        return this;
    }
    
    public static String formatException(SAXParseException e) {
        return String.format("(%s, line %d, column %d) %s",
                    e.getSystemId(),
                    e.getLineNumber(),
                    e.getColumnNumber(),
                    e.getMessage());
    }


}

