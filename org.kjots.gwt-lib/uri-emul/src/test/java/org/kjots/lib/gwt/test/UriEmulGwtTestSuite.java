/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.test;

import com.google.gwt.junit.tools.GWTTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.kjots.lib.gwt.client.org.apache.harmony.luni.tests.java.net.URIGwtTest;
import org.kjots.lib.gwt.client.org.apache.harmony.luni.tests.java.net.URISyntaxExceptionGwtTest;

/**
 * java.net.URI Emulation GWT Test Suite.
 * <p>
 * Created: 23rd March 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 11.5.8
 */
public class UriEmulGwtTestSuite extends GWTTestSuite {
  /**
   * Create the test suite.
   *
   * @return The test suite.
   */
  public static Test suite() {
    UriEmulGwtTestSuite suite = new UriEmulGwtTestSuite();
    
    addTestSuites(suite);
    
    return suite;
  }
  
  /**
   * Add the test suites.
   *
   * @param suite The test suite.
   */
  public static void addTestSuites(TestSuite suite) {
    suite.addTestSuite(URIGwtTest.class);
    suite.addTestSuite(URISyntaxExceptionGwtTest.class);
  }
  
  /**
   * Construct a new java.net.URI Emulation GWT Test Suite.
   * <p>
   * This constructor is declared <code>private</code> to prevent external
   * instantiation.
   */
  private UriEmulGwtTestSuite() {
    super("java.net.URI Emulation GWT Test Suite.");
  }
}
