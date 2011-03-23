/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package java.net;

import java.io.UnsupportedEncodingException;

import com.google.gwt.http.client.URL;

/**
 * This class is used to encode a string using the format required by {@code
 * application/x-www-form-urlencoded} MIME content type. It contains helper
 * methods used by the URI class, and performs encoding and decoding in a
 * slightly different way than {@code URLEncoder} and {@code URLDecoder}.
 * 
 * Modified for use in <em>GWT</em> by <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>:
 * <ul>
 * <li>Inlined messages and removed NON-NLS directives</li>
 * <li>Updated encoding field to be "UTF-8" instead of "UTF8"</li>
 * <li>Copied isSpaceChar() and isISOControl() methods from java.lang.Character</li>
 * <li>Updated decode() method to delegate to com.google.gwt.http.client.URL.decodePathSegment()</li>
 * </ul>
 */
class URIEncoderDecoder {

    static final String digits = "0123456789ABCDEF";

    static final String encoding = "UTF-8";

    /**
     * Validate a string by checking if it contains any characters other than:
     * 1. letters ('a'..'z', 'A'..'Z') 2. numbers ('0'..'9') 3. characters in
     * the legalset parameter 4. others (unicode characters that are not in
     * US-ASCII set, and are not ISO Control or are not ISO Space characters)
     * <p>
     * called from {@code URI.Helper.parseURI()} to validate each component
     *
     * @param s
     *            {@code java.lang.String} the string to be validated
     * @param legal
     *            {@code java.lang.String} the characters allowed in the String
     *            s
     */
    static void validate(String s, String legal) throws URISyntaxException {
        for (int i = 0; i < s.length();) {
            char ch = s.charAt(i);
            if (ch == '%') {
                do {
                    if (i + 2 >= s.length()) {
                        throw new URISyntaxException(s, "Incomplete % sequence", i);
                    }
                    int d1 = Character.digit(s.charAt(i + 1), 16);
                    int d2 = Character.digit(s.charAt(i + 2), 16);
                    if (d1 == -1 || d2 == -1) {
                        throw new URISyntaxException(s, "Invalid % sequence (" + s.substring(i, i + 3) + ")", i);
                    }

                    i += 3;
                } while (i < s.length() && s.charAt(i) == '%');

                continue;
            }
            if (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')
                    || (ch >= '0' && ch <= '9') || legal.indexOf(ch) > -1 || (ch > 127
                        && !isSpaceChar(ch) && !isISOControl(ch)))) {
                throw new URISyntaxException(s, "Illegal character", i);
            }
            i++;
        }
    }

    static void validateSimple(String s, String legal)
            throws URISyntaxException {
        for (int i = 0; i < s.length();) {
            char ch = s.charAt(i);
            if (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')
                    || (ch >= '0' && ch <= '9') || legal.indexOf(ch) > -1)) {
                throw new URISyntaxException(s, "Illegal character", i);
            }
            i++;
        }
    }

    /**
     * All characters except letters ('a'..'z', 'A'..'Z') and numbers ('0'..'9')
     * and legal characters are converted into their hexidecimal value prepended
     * by '%'.
     * <p>
     * For example: '#' -> %23
     * Other characters, which are unicode chars that are not US-ASCII, and are
     * not ISO Control or are not ISO Space chars, are preserved.
     * <p>
     * Called from {@code URI.quoteComponent()} (for multiple argument
     * constructors)
     *
     * @param s
     *            java.lang.String the string to be converted
     * @param legal
     *            java.lang.String the characters allowed to be preserved in the
     *            string s
     * @return java.lang.String the converted string
     */
    static String quoteIllegal(String s, String legal)
            throws UnsupportedEncodingException {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch >= 'a' && ch <= 'z')
                    || (ch >= 'A' && ch <= 'Z')
                    || (ch >= '0' && ch <= '9')
                    || legal.indexOf(ch) > -1
                    || (ch > 127 && !isSpaceChar(ch) && !isISOControl(ch))) {
                buf.append(ch);
            } else {
                byte[] bytes = new String(new char[] { ch }).getBytes(encoding);
                for (int j = 0; j < bytes.length; j++) {
                    buf.append('%');
                    buf.append(digits.charAt((bytes[j] & 0xf0) >> 4));
                    buf.append(digits.charAt(bytes[j] & 0xf));
                }
            }
        }
        return buf.toString();
    }

    /**
     * Other characters, which are Unicode chars that are not US-ASCII, and are
     * not ISO Control or are not ISO Space chars are not preserved. They are
     * converted into their hexidecimal value prepended by '%'.
     * <p>
     * For example: Euro currency symbol -> "%E2%82%AC".
     * <p>
     * Called from URI.toASCIIString()
     *
     * @param s
     *            java.lang.String the string to be converted
     * @return java.lang.String the converted string
     */
    static String encodeOthers(String s) throws UnsupportedEncodingException {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch <= 127) {
                buf.append(ch);
            } else {
                byte[] bytes = new String(new char[] { ch }).getBytes(encoding);
                for (int j = 0; j < bytes.length; j++) {
                    buf.append('%');
                    buf.append(digits.charAt((bytes[j] & 0xf0) >> 4));
                    buf.append(digits.charAt(bytes[j] & 0xf));
                }
            }
        }
        return buf.toString();
    }

    /**
     * Decodes the string argument which is assumed to be encoded in the {@code
     * x-www-form-urlencoded} MIME content type using the UTF-8 encoding scheme.
     * <p>
     *'%' and two following hex digit characters are converted to the
     * equivalent byte value. All other characters are passed through
     * unmodified.
     * <p>
     * e.g. "A%20B%20C %24%25" -> "A B C $%"
     * <p>
     * Called from URI.getXYZ() methods
     * 
     * @param s
     *            java.lang.String The encoded string.
     * @return java.lang.String The decoded version.
     */
    static String decode(String s) throws UnsupportedEncodingException {
        return URL.decodePathSegment(s);
    }
    
    /**
     * Indicates whether the specified character is a Unicode space character.
     * That is, if it is a member of one of the Unicode categories Space
     * Separator, Line Separator, or Paragraph Separator.
     * 
     * @param c
     *            the character to check.
     * @return {@code true} if {@code c} is a Unicode space character,
     *         {@code false} otherwise.
     */
    static boolean isSpaceChar(char c) {
        if (c == 0x20 || c == 0xa0 || c == 0x1680) {
            return true;
        }
        if (c < 0x2000) {
            return false;
        }
        return c <= 0x200b || c == 0x2028 || c == 0x2029 || c == 0x202f
                || c == 0x3000;
    }
    
    /**
     * Indicates whether the specified character is an ISO control character.
     * 
     * @param c
     *            the character to check.
     * @return {@code true} if {@code c} is an ISO control character;
     *         {@code false} otherwise.
     */
    static boolean isISOControl(char c) {
        return isISOControl((int)c);
    }

    /**
     * Indicates whether the specified code point is an ISO control character.
     * 
     * @param c
     *            the code point to check.
     * @return {@code true} if {@code c} is an ISO control character;
     *         {@code false} otherwise.
     */
    static boolean isISOControl(int c) {
        return (c >= 0 && c <= 0x1f) || (c >= 0x7f && c <= 0x9f);
    }
}
