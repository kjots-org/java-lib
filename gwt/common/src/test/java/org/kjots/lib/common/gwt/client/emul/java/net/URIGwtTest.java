/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.common.gwt.client.emul.java.net;

import java.net.URI;

import org.kjots.lib.common.gwt.client.CommonGwtTestBase;

/**
 * URI GWT Test.
 * <p>
 * Created: 23rd March 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 99-SNAPSHOT
 */
public class URIGwtTest extends CommonGwtTestBase {
  /**
   * Test the creation of a generic URI.
   */
  public void testCreateGenericUri() {
    URI genericUri = URI.create("scheme:scheme-specific-part#fragment");
    
    assertNotNull(genericUri);
    
    assertEquals("scheme", genericUri.getScheme());
    assertEquals("scheme-specific-part", genericUri.getSchemeSpecificPart());
    assertEquals("fragment", genericUri.getFragment());
  }
  
  /**
   * Test the creation of a hierarchical URI.
   */
  public void testCreateHierarchicalUri() {
    URI hierarchicalUri = URI.create("scheme://user-info@host.name:1234/path?query#fragment");
    
    assertNotNull(hierarchicalUri);
    
    assertEquals("scheme", hierarchicalUri.getScheme());
    assertEquals("//user-info@host.name:1234/path?query", hierarchicalUri.getSchemeSpecificPart());
    assertEquals("user-info@host.name:1234", hierarchicalUri.getAuthority());
    assertEquals("user-info", hierarchicalUri.getUserInfo());
    assertEquals("host.name", hierarchicalUri.getHost());
    assertEquals(1234, hierarchicalUri.getPort());
    assertEquals("/path", hierarchicalUri.getPath());
    assertEquals("query", hierarchicalUri.getQuery());
    assertEquals("fragment", hierarchicalUri.getFragment());
  }
}
