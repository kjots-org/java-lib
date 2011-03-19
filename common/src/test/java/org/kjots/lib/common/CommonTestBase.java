/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.common;

import org.junit.After;
import org.junit.Before;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Common Test Base.
 * <p>
 * Created: 19th March 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 99-SNAPSHOT
 */
public abstract class CommonTestBase {
  /**
   * Initialize Mockito mocks before every test method.
   */
  @Before
  public void initMocks() {
    MockitoAnnotations.initMocks(this);
  }
  
  /**
   * Validate Mockito usage after every test method.
   */
  @After
  public void validateMockitoUsage() {
    Mockito.validateMockitoUsage();
  }
}
