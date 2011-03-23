/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.common.gwt.client;

import com.google.gwt.junit.client.GWTTestCase;

/**
 * Common GWT Test Base.
 * <p>
 * Created: 23rd March 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 99-SNAPSHOT
 */
public abstract class CommonGwtTestBase extends GWTTestCase {
  /**
   * Retrieve the name of the GWT module.
   *
   * @return The name of the GWT module.
   */
  @Override
  public final String getModuleName() {
    return "org.kjots.lib.common.CommonTest";
  }
}
