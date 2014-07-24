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

import java.util.Iterator;

/**
 * Utility methods for Iterators.
 *
 * @author Jonathan W. Cranford
 */
public final class Iterators {

    // prevent construction of utility class
    private Iterators() {
    }

    public static final String EOL = System.getProperty("line.separator");  

    /**
     * Appends each element from the given Iterator into the given StringBuilder,
     * with trailingDelim following each element.
     */
    public static StringBuilder append(StringBuilder sb, Iterator<?> it, String trailingDelim) {
        while (it.hasNext()) {
            sb.append(it.next().toString()).append(trailingDelim);
        }
        return sb;
     }


    /**
     * Joins each element from the iterator with the given separator.
     */
    public static String join(Iterator<?> it, String sep) {
        final StringBuilder sb = new StringBuilder();
        if (it.hasNext()) {
            sb.append(it.next().toString());
        }
        while (it.hasNext()) {
            sb.append(sep).append(it.next().toString());
        }
        return sb.toString();
    }


    /**
     * Like append, but it takes a label up-front and then appends the given
     * Iterator to the given StringBuilder.
     */
    public static StringBuilder appendWithLabel(
            Object label,
            StringBuilder sb,
            Iterator<?> it,
            String separator)
    {
        if (it.hasNext()) {
            return append(
                sb.append(label.toString()).append(": ").append(separator),
                it,
                separator);
        }
        return sb;
    }
}