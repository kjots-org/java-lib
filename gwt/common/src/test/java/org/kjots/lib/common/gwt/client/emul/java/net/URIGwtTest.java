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
   * Test the creation of a URI.
   */
  public void testCreateUri() {
    assertNotNull(URI.create("scheme:/path"));
  }
}
