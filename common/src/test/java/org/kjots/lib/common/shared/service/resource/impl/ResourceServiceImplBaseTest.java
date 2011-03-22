/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.common.shared.service.resource.impl;

import org.junit.Before;

import org.kjots.lib.common.CommonTestBase;
import org.kjots.lib.common.shared.service.resource.ResourceDescriptor;

/**
 * Resource Service Implementation Base Test.
 * <p>
 * Created: 19th March 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 99-SNAPSHOT
 */
public class ResourceServiceImplBaseTest extends CommonTestBase {
  /**
   * Dummy Resource Service Implementation Base.
   */
  public static class DummyResourceServiceImplBase extends ResourceServiceImplBase {
    /**
     * Install the given resource descriptor.
     *
     * @param resourceDescriptor The resource descriptor.
     */
    @Override
    public void installResourceDescriptor(ResourceDescriptor resourceDescriptor) {
    }
  }
  
  /** The test resource service implementation base. */
  @SuppressWarnings("unused")
  private ResourceServiceImplBase testResourceServiceImplBase;
  
  /**
   * Setup the test environment.
   */
  @Before
  public void setup() {
    this.testResourceServiceImplBase = new DummyResourceServiceImplBase();
  }
}
